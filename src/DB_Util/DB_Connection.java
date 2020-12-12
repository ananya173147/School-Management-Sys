package DB_Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connection {
    private static final String CONN = "jdbc:sqlite:sms.sqlite";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(CONN);
        }
        catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
