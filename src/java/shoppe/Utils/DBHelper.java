/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppe.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author hj
 */
public class DBHelper {
    public static Connection makeConnection() throws SQLException, ClassNotFoundException {         
        
//        1. Load Driver
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        2. Connection String
        String url = "jdbc:sqlserver://"
                + "localhost:1433;"
                + "databaseName=ShoppeProduct";
//        3. Open connection
        Connection con  = DriverManager.getConnection(url, "SA", "12345");
//        4. Return connection to caller
        return con;
    }
    
}
