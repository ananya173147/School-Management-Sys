package loginapp;

public enum options {
    Admin, Student, Teacher;

    private options (){}

    public String value(){
        return name();
    }
    public static options fromValue(String v) {
        return valueOf(v);
    }

}
