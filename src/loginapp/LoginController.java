package loginapp;

import admin.adminController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import students.studentsController;
import students.studentsController1;
import teacher.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    LoginModel loginModel = new LoginModel();

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private ComboBox<options> combobox;
    @FXML
    private Button loginbutton;
    @FXML
    private Label loginStatus;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.combobox.setItems(FXCollections.observableArrayList(options.values()));
    }

    @FXML
    public void Login(ActionEvent event) {
        try {
            if(this.loginModel.isLogin("Latha", this.password.getText(), "Teacher")) {
                Stage stage = (Stage)this.loginbutton.getScene().getWindow();
                stage.close();
                teacherLogin_Science();
            }
            else if(this.loginModel.isLogin("Samyuktha", this.password.getText(), "Teacher")) {
                Stage stage = (Stage)this.loginbutton.getScene().getWindow();
                stage.close();
                teacherLogin_Maths();
            }
            else if(this.loginModel.isLogin("Lakshmi", this.password.getText(), "Teacher")) {
                Stage stage = (Stage)this.loginbutton.getScene().getWindow();
                stage.close();
                teacherLogin_English();
            }
            else if(this.loginModel.isLogin("Venkatesh", this.password.getText(), "Teacher")) {
                Stage stage = (Stage)this.loginbutton.getScene().getWindow();
                stage.close();
                teacherLogin_PT();
            }
            else if(this.loginModel.isLogin("Parvati", this.password.getText(), "Teacher")) {
                Stage stage = (Stage)this.loginbutton.getScene().getWindow();
                stage.close();
                teacherLogin_SocialScience();
            }
            else if(this.loginModel.isLogin("Ananya", this.password.getText(), "Student")) {
                Stage stage = (Stage)this.loginbutton.getScene().getWindow();
                stage.close();
                studentLogin();
            }
            else if(this.loginModel.isLogin(this.username.getText(), this.password.getText(), this.combobox.getValue().toString())) {
                Stage stage = (Stage)this.loginbutton.getScene().getWindow();
                stage.close();
                switch(this.combobox.getValue().toString()) {
                    case "Admin":
                        adminLogin();
                        break;
                    case "Student":
                        studentLogin_1();
                        break;
                }
            }  else {
                this.loginStatus.setText("Wrong Credentials");
            }
        }
        catch (Exception localExp) {
            localExp.printStackTrace();
        }
    }

    public void studentLogin(){
        try {
            Stage userstage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = loader.load(getClass().getResource("/students/studentFXML.fxml").openStream());
            studentsController StudentsController = loader.getController();
            Scene scene = new Scene(root);
            userstage.setScene(scene);
            userstage.setTitle("Student Dashboard");
            userstage.show();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    public void studentLogin_1(){
        try {
            Stage userstage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = loader.load(getClass().getResource("/students/studentFXML1.fxml").openStream());
            studentsController1 StudentsController = loader.getController();
            Scene scene = new Scene(root);
            userstage.setScene(scene);
            userstage.setTitle("Student Dashboard");
            userstage.show();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void adminLogin(){
        try {
            Stage adminstage = new Stage();
            FXMLLoader adminloader = new FXMLLoader();
            Pane adminroot = adminloader.load(getClass().getResource("/admin/adminFXML.fxml").openStream());
            adminController AdminController = adminloader.getController();
            Scene scene = new Scene(adminroot);
            adminstage.setScene(scene);
            adminstage.setTitle("Admin Dashboard");
            adminstage.show();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void teacherLogin_Science(){
        try {
            Stage tstage = new Stage();
            FXMLLoader tloader = new FXMLLoader();
            Pane troot = tloader.load(getClass().getResource("/teacher/teacherFXML.fxml").openStream());
            teacherController TeacherController = tloader.getController();
            Scene scene = new Scene(troot);
            tstage.setScene(scene);
            tstage.setTitle("Teacher Dashboard");
            tstage.show();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void teacherLogin_Maths(){
        try {
            Stage tstage = new Stage();
            FXMLLoader tloader = new FXMLLoader();
            Pane troot = tloader.load(getClass().getResource("/teacher/teacherFXML2.fxml").openStream());
            teacherController2 TeacherController = tloader.getController();
            Scene scene = new Scene(troot);
            tstage.setScene(scene);
            tstage.setTitle("Teacher Dashboard");
            tstage.show();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void teacherLogin_English(){
        try {
            Stage tstage = new Stage();
            FXMLLoader tloader = new FXMLLoader();
            Pane troot = tloader.load(getClass().getResource("/teacher/teacherFXML3.fxml").openStream());
            teacherController3 TeacherController = tloader.getController();
            Scene scene = new Scene(troot);
            tstage.setScene(scene);
            tstage.setTitle("Teacher Dashboard");
            tstage.show();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void teacherLogin_PT(){
        try {
            Stage tstage = new Stage();
            FXMLLoader tloader = new FXMLLoader();
            Pane troot = tloader.load(getClass().getResource("/teacher/teacherFXML4.fxml").openStream());
            teacherController4 TeacherController = tloader.getController();
            Scene scene = new Scene(troot);
            tstage.setScene(scene);
            tstage.setTitle("Teacher Dashboard");
            tstage.show();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void teacherLogin_SocialScience(){
        try {
            Stage tstage = new Stage();
            FXMLLoader tloader = new FXMLLoader();
            Pane troot = tloader.load(getClass().getResource("/teacher/teacherFXML5.fxml").openStream());
            teacherController5 TeacherController = tloader.getController();
            Scene scene = new Scene(troot);
            tstage.setScene(scene);
            tstage.setTitle("Teacher Dashboard");
            tstage.show();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
