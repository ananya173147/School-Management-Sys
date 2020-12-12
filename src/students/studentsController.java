package students;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import DB_Util.DB_Connection;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class studentsController implements Initializable {
    @FXML
    private TableColumn name;
    @FXML
    private TableColumn science;
    @FXML
    private TableColumn maths;
    @FXML
    private TableColumn english;
    @FXML
    private TableColumn pt;
    @FXML
    private TableColumn social;
    @FXML
    private TableView<studentData> studentTable;

    private DB_Connection dc;
    private ObservableList<studentData> data;

    public void initialize(URL url, ResourceBundle rb) {
        this.dc = new DB_Connection();
    }

    @FXML
    public void setData (ActionEvent event) throws SQLException {
        try{
            Connection conn = DB_Connection.getConnection();
            this.data = FXCollections.observableArrayList();
            ResultSet rs = conn.createStatement().executeQuery("SELECT Name, Science, Maths, English, PT, SocialScience FROM students WHERE Name LIKE 'Ananya'");
            while(rs.next()){
                this.data.add(new studentData(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        this.name.setCellValueFactory(new PropertyValueFactory<teacher.studentData, String>("name"));
        this.science.setCellValueFactory(new PropertyValueFactory<teacher.studentData, String>("science"));
        this.maths.setCellValueFactory(new PropertyValueFactory<teacher.studentData, String>("maths"));
        this.english.setCellValueFactory(new PropertyValueFactory<teacher.studentData, String>("english"));
        this.pt.setCellValueFactory(new PropertyValueFactory<teacher.studentData, String>("pt"));
        this.social.setCellValueFactory(new PropertyValueFactory<teacher.studentData, String>("ss"));

        this.studentTable.setItems(null);
        this.studentTable.setItems(this.data);


    }


}
