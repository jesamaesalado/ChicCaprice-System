
package javafp;
import java.sql.*;
/**
 *
 * @author Clintoy
 */
public class MyConnection {
    public static Connection getConnection(){
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/cc.db","root", "");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return con;
    }
    
   
    
}
