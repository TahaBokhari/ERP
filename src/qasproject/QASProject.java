/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qasproject;

import java.sql.SQLException;

/**
 *
 * @author tahab
 */
public class QASProject {

    public static int userId=0;
    public static String userrole=null;
    public static String userName=null;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        login tb= new login();
        tb.setVisible(true);
    }
    
}
