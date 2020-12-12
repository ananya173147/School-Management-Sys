package loginapp;

import DB_Util.DB_Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel {
    Connection connection;

    public LoginModel(){
        try{
            this.connection = DB_Connection.getConnection();
        }  catch (SQLException ex){
            ex.printStackTrace();
        }
        if(this.connection == null){
            System.exit(1);
        }
    }

    public boolean isLogin(String user, String pass, String opt) throws Exception {

        PreparedStatement pr = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM login where username = ? and password = ? and usertype = ?";
        try{
            pr = this.connection.prepareStatement(sql);
            pr.setString(1, user);
            pr.setString(2, pass);
            pr.setString(3, opt);

            rs = pr.executeQuery();

            return rs.next();
        }
        catch (SQLException ex) {
            return false;
        }
        finally {
            {
                if (pr != null) {
                    pr.close();
                }
                if (rs != null) {
                    rs.close();
                }
            }
        }
    }

}
