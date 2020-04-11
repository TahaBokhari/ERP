/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qasproject;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 * 
 * 
 * 
//username = doadmin
//password = cpfx990bvcaontic
//host = db-mysql-nyc1-04847-do-user-7210428-0.a.db.ondigitalocean.com
//port = 25060
//database = defaultdb
//sslmode = REQUIRED
 *
 * @author tahab
 */
public class DBconnection {
    
    public static Connection connectDb()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://db-mysql-nyc1-04847-do-user-7210428-0.a.db.ondigitalocean.com:25060/defaultdb", "doadmin", "cpfx990bvcaontic");
            System.out.println("Connection Established");
            return conn;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
            return null;
        }
    }
}

//
//public static Connection connectDb()
//    {
//        try
//        {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/inventory", "root", null);
//            System.out.println("Connection Established");
//            return conn;
//        }
//        catch(Exception e)
//        {
//            JOptionPane.showMessageDialog(null,e);
//            return null;
//        }
//    }
//}