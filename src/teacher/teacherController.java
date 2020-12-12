package teacher;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import DB_Util.DB_Connection;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class teacherController implements Initializable {

    @FXML
    private TextField rollno;
    @FXML
    private TextField marks;
    @FXML
    private TableView<studentData> studentTable;
    @FXML
    private TableColumn<studentData, String> rollnocol;
    @FXML
    private TableColumn<studentData, String> namecol;
    @FXML
    private TableColumn<studentData, String> markscol;

    private DB_Connection dc;
    private ObservableList<studentData> data;

    public void initialize(URL url, ResourceBundle rb) {
        this.dc = new DB_Connection();
    }

    @FXML
    private void loadData (ActionEvent event) throws SQLException {
        try {
            Connection conn = DB_Connection.getConnection();
            this.data = FXCollections.observableArrayList();
            String sql = "SELECT RollNumber, Name, Science FROM students";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while(rs.next()){
                this.data.add(new studentData(rs.getString(1),rs.getString(2),rs.getString(3)));
            }
        } catch(SQLException ex){
            ex.printStackTrace();
        }

        this.rollnocol.setCellValueFactory(new PropertyValueFactory<studentData, String>("rollNumber"));
        this.namecol.setCellValueFactory(new PropertyValueFactory<studentData, String>("name"));
        this.markscol.setCellValueFactory(new PropertyValueFactory<studentData, String>("marks"));

        this.studentTable.setItems(null);
        this.studentTable.setItems(this.data);
    }

}
