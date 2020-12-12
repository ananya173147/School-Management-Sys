package students;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
public class studentData {
    private final StringProperty name;
    private final StringProperty science;
    private final StringProperty maths;
    private final StringProperty english;
    private final StringProperty pt;
    private final StringProperty ss;

    public studentData(String name, String sci, String maths, String english,String pt, String ss) {
        this.science = new SimpleStringProperty(sci);
        this.name = new SimpleStringProperty(name);
        this.maths = new SimpleStringProperty(maths);
        this.english = new SimpleStringProperty(english);
        this.pt = new SimpleStringProperty(pt);
        this.ss = new SimpleStringProperty(ss);
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

    public String getScience() {
        return science.get();
    }

    public StringProperty scienceProperty() {
        return science;
    }

    public void setScience(String science) {
        this.science.set(science);
    }

    public String getMaths() {
        return maths.get();
    }

    public StringProperty mathsProperty() {
        return maths;
    }

    public void setMaths(String maths) {
        this.maths.set(maths);
    }

    public String getEnglish() {
        return english.get();
    }

    public StringProperty englishProperty() {
        return english;
    }

    public void setEnglish(String english) {
        this.english.set(english);
    }

    public String getPt() {
        return pt.get();
    }

    public StringProperty ptProperty() {
        return pt;
    }

    public void setPt(String pt) {
        this.pt.set(pt);
    }

    public String getSs() {
        return ss.get();
    }

    public StringProperty ssProperty() {
        return ss;
    }

    public void setSs(String ss) {
        this.ss.set(ss);
    }
}
