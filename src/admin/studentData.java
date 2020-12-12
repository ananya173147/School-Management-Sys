package admin;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class studentData {
    private final StringProperty rollNumber;
    private final StringProperty name;
    private final StringProperty DOB;
    private final StringProperty grade;
    private final StringProperty gender;
    private final StringProperty contact;
    private final StringProperty address;

    public studentData(String rollno, String name, String dob, String grade,String gender, String contact, String address) {
        this.rollNumber = new SimpleStringProperty(rollno);
        this.name = new SimpleStringProperty(name);
        this.DOB = new SimpleStringProperty(dob);
        this.grade = new SimpleStringProperty(grade);
        this.gender = new SimpleStringProperty(gender);
        this.contact = new SimpleStringProperty(contact);
        this.address = new SimpleStringProperty(address);
    }

    public String getRollNumber() {
        return rollNumber.get();
    }

    public StringProperty rollNumberProperty() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber.set(rollNumber);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getDOB() {
        return DOB.get();
    }

    public StringProperty DOBProperty() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB.set(DOB);
    }

    public String getGrade() {
        return grade.get();
    }

    public StringProperty gradeProperty() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade.set(grade);
    }

    public String getGender() {
        return gender.get();
    }

    public StringProperty genderProperty() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public String getContact() {
        return contact.get();
    }

    public StringProperty contactProperty() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact.set(contact);
    }

    public String getAddress() {
        return address.get();
    }

    public StringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }
}
