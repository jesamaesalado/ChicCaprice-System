/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory_system;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author student.admin
 */


public class DBconnection {
    private static String servername = "localhost";
    private static String username = "root";
    private static String dbname = "chic";
    private static Integer portnumber = 3306;
    private static String password = "";
    
    public static Connection getConnection(){
        Connection con = null;
        
        MysqlDataSource datasource = new MysqlDataSource();
        
        datasource.setServerName(servername);
        datasource.setUser(username);
        datasource.setPassword(password);
        datasource.setDatabaseName(dbname);
        datasource.setPortNumber(portnumber);
        
        try {
            con = datasource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(" Get Connection -> " + DBconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return con;
    }
}




