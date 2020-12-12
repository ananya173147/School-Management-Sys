package teacher;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class studentData {
    private final StringProperty rollNumber;
    private final StringProperty name;
    private final StringProperty marks;

    public studentData(String rollno, String name, String marks) {
        this.rollNumber = new SimpleStringProperty(rollno);
        this.name = new SimpleStringProperty(name);
        this.marks = new SimpleStringProperty(marks);
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

    public String getMarks() {
        return marks.get();
    }

    public StringProperty marksProperty() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks.set(marks);
    }
}
