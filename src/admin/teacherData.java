package admin;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class teacherData {
    private final StringProperty teacherID;
    private final StringProperty teacherName;
    private final StringProperty subject;

    public teacherData(String id, String name, String sub) {
        this.teacherID = new SimpleStringProperty(id);
        this.teacherName = new SimpleStringProperty(name);
        this.subject = new SimpleStringProperty(sub);
    }

    public String getTeacherID() {
        return teacherID.get();
    }

    public StringProperty teacherIDProperty() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID.set(teacherID);
    }

    public String getTeacherName() {
        return teacherName.get();
    }

    public StringProperty teacherNameProperty() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName.set(teacherName);
    }

    public String getSubject() {
        return subject.get();
    }

    public StringProperty subjectProperty() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject.set(subject);
    }
}
