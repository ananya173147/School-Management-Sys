package admin;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class staffData {
    private final StringProperty staffID;
    private final StringProperty staffName;
    private final StringProperty post;

    public staffData(String id, String name, String post) {
        this.staffID = new SimpleStringProperty(id);
        this.staffName = new SimpleStringProperty(name);
        this.post = new SimpleStringProperty(post);
    }

    public String getStaffID() {
        return staffID.get();
    }

    public StringProperty staffIDProperty() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID.set(staffID);
    }

    public String getStaffName() {
        return staffName.get();
    }

    public StringProperty staffNameProperty() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName.set(staffName);
    }

    public String getPost() {
        return post.get();
    }

    public StringProperty postProperty() {
        return post;
    }

    public void setPost(String post) {
        this.post.set(post);
    }
}

