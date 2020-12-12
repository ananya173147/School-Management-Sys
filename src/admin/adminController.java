package admin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import DB_Util.DB_Connection;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class adminController implements Initializable {

    @FXML
    private TextField rollno;
    @FXML
    private TextField name;
    @FXML
    private DatePicker dob;
    @FXML
    private TextField gender;
    @FXML
    private TextField grade;
    @FXML
    private TextField contact;
    @FXML
    private TextField address;
    @FXML
    private TableView<studentData> studentTable;
    @FXML
    private TableColumn<studentData, String> rollnocol;
    @FXML
    private TableColumn<studentData, String> namecol;
    @FXML
    private TableColumn<studentData, String> dobcol;
    @FXML
    private TableColumn<studentData, String> gendercol;
    @FXML
    private TableColumn<studentData, String> gradecol;
    @FXML
    private TableColumn<studentData, String> contactcol;
    @FXML
    private TableColumn<studentData, String> addresscol;

    @FXML
    private TextField teacher_id;
    @FXML
    private TextField teacher_name;
    @FXML
    private TextField subject;
    @FXML
    private TableView<teacherData> teacherTable;
    @FXML
    private TableColumn<teacherData, String> teacher_id_col;
    @FXML
    private TableColumn<teacherData, String> subject_col;
    @FXML
    private TableColumn<teacherData, String> teacher_name_col;

    @FXML
    private TextField staff_id;
    @FXML
    private TextField staff_name;
    @FXML
    private TextField post;
    @FXML
    private TableView<staffData> staffTable;
    @FXML
    private TableColumn<staffData, String> staff_id_col;
    @FXML
    private TableColumn<staffData, String> staff_name_col;
    @FXML
    private TableColumn<staffData, String> post_col;

    private ObservableList<studentData> data;
    private ObservableList<teacherData> data_t;
    private ObservableList<staffData> data_s;

    public void initialize(URL url, ResourceBundle rb) {
        DB_Connection dc = new DB_Connection();
    }

    @FXML
    private void loadData (ActionEvent event) {
        try {
            Connection conn = DB_Connection.getConnection();
            this.data = FXCollections.observableArrayList();

            ResultSet rs = conn != null ? conn.createStatement().executeQuery("SELECT RollNumber, Name, DOB, Grade, Gender, Contact, Address FROM students") : null;
            while(rs != null && rs.next()){
                this.data.add(new studentData(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));
            }
        } catch(SQLException ex){
            ex.printStackTrace();
        }

        this.rollnocol.setCellValueFactory(new PropertyValueFactory<studentData, String>("rollNumber"));
        this.namecol.setCellValueFactory(new PropertyValueFactory<studentData, String>("name"));
        this.dobcol.setCellValueFactory(new PropertyValueFactory<studentData, String>("DOB"));
        this.gendercol.setCellValueFactory(new PropertyValueFactory<studentData, String>("gender"));
        this.gradecol.setCellValueFactory(new PropertyValueFactory<studentData, String>("grade"));
        this.contactcol.setCellValueFactory(new PropertyValueFactory<studentData, String>("contact"));
        this.addresscol.setCellValueFactory(new PropertyValueFactory<studentData, String>("address"));


        this.studentTable.setItems(null);
        this.studentTable.setItems(this.data);
    }

    @FXML
    private void loadData_t (ActionEvent event) {
        try {
            Connection conn = DB_Connection.getConnection();
            this.data_t = FXCollections.observableArrayList();

            ResultSet rs = conn != null ? conn.createStatement().executeQuery("SELECT * FROM teachers") : null;
            while(rs != null && rs.next()){
                this.data_t.add(new teacherData(rs.getString(1),rs.getString(2),rs.getString(3)));
            }
        } catch(SQLException ex){
            ex.printStackTrace();
        }

        this.teacher_id_col.setCellValueFactory(new PropertyValueFactory<teacherData, String>("teacherID"));
        this.teacher_name_col.setCellValueFactory(new PropertyValueFactory<teacherData, String>("teacherName"));
        this.subject_col.setCellValueFactory(new PropertyValueFactory<teacherData, String>("subject"));

        this.teacherTable.setItems(null);
        this.teacherTable.setItems(this.data_t);
    }

    @FXML
    private void loadData_s (ActionEvent event) {
        try {
            Connection conn = DB_Connection.getConnection();
            this.data_s = FXCollections.observableArrayList();

            ResultSet rs = conn != null ? conn.createStatement().executeQuery("SELECT * FROM staff") : null;
            while(rs != null && rs.next()){
                this.data_s.add(new staffData(rs.getString(1),rs.getString(2),rs.getString(3)));
            }
        } catch(SQLException ex){
            ex.printStackTrace();
        }

        this.staff_id_col.setCellValueFactory(new PropertyValueFactory<staffData, String>("staffID"));
        this.staff_name_col.setCellValueFactory(new PropertyValueFactory<staffData, String>("staffName"));
        this.post_col.setCellValueFactory(new PropertyValueFactory<staffData, String>("post"));

        this.staffTable.setItems(null);
        this.staffTable.setItems(this.data_s);
    }

    @FXML
    private void addEntry(javafx.event.ActionEvent event) {
        try{
            Connection conn = DB_Connection.getConnection();
            PreparedStatement stmt = conn != null ? conn.prepareStatement("INSERT INTO students(RollNumber, Name, DOB, Grade, Gender, Contact, Address) VALUES (?,?,?,?,?,?,?)") : null;
            PreparedStatement stmt1 = conn != null ? conn.prepareStatement("INSERT INTO login(username,password,usertype) VALUES (?,?,?)") : null;
            if (stmt1 != null) {
                stmt1.setString(1,this.name.getText());
            }
            if (stmt1 != null) {
                stmt1.setString(2,"default456");
            }
            if (stmt1 != null) {
                stmt1.setString(3,"Student");
            }
            if (stmt != null) {
                stmt.setString(1,this.rollno.getText());
            }
            if (stmt != null) {
                stmt.setString(2,this.name.getText());
            }
            if (stmt != null) {
                stmt.setString(3,this.dob.getEditor().getText());
            }
            if (stmt != null) {
                stmt.setString(4,this.grade.getText());
            }
            if (stmt != null) {
                stmt.setString(5,this.gender.getText());
            }
            if (stmt != null) {
                stmt.setString(6,this.contact.getText());
            }
            if (stmt != null) {
                stmt.setString(7,this.address.getText());
            }
            if (stmt1 != null) {
                stmt1.execute();
            }
            if (stmt != null) {
                stmt.execute();
            }
            if (conn != null) {
                conn.close();
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }

    }

    @FXML
    private void addEntry_t (javafx.event.ActionEvent event) {
        try{
            Connection conn = DB_Connection.getConnection();
            PreparedStatement stmt = conn != null ? conn.prepareStatement("INSERT INTO teachers(Teacher_ID, Name, Subject) VALUES (?,?,?)") : null;
            PreparedStatement stmt1 = conn != null ? conn.prepareStatement("INSERT INTO login(username,password,usertype) VALUES (?,?,?)") : null;
            if (stmt1 != null) {
                stmt1.setString(1,this.teacher_name.getText());
            }
            if (stmt1 != null) {
                stmt1.setString(2,"default123");
            }
            if (stmt1 != null) {
                stmt1.setString(3,"Teacher");
            }
            if (stmt != null) {
                stmt.setString(1,this.teacher_id.getText());
            }
            if (stmt != null) {
                stmt.setString(2,this.teacher_name.getText());
            }
            if (stmt != null) {
                stmt.setString(3,this.subject.getText());
            }
            if (stmt != null) {
                stmt.execute();
            }
            stmt1.execute();
            if (conn != null) {
                conn.close();
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }

    }

    @FXML
    private void addEntry_s (javafx.event.ActionEvent event) {
        try{
            Connection conn = DB_Connection.getConnection();
            PreparedStatement stmt = conn != null ? conn.prepareStatement("INSERT INTO staff(Staff_ID, Name, Post) VALUES (?,?,?)") : null;
            if (stmt != null) {
                stmt.setString(1,this.staff_id.getText());
            }
            if (stmt != null) {
                stmt.setString(2,this.staff_name.getText());
            }
            if (stmt != null) {
                stmt.setString(3,this.post.getText());
            }
            if (stmt != null) {
                stmt.execute();
            }
            if (conn != null) {
                conn.close();
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }

    }

}
