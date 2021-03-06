/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qasproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author tahab
 */
public class addDepartment extends javax.swing.JFrame {

    /**
     * Creates new form AddUOM
     */
    
    Connection conn=null;
    String Category=null;
    String unit=null;
    
    public addDepartment() {
        initComponents();
        this.setTitle("Add New Plant");
        conn=DBconnection.connectDb();
        
        
        int sNo;
        try {
            sNo = generateSerialNumber();
            plantId.setText(String.valueOf(sNo));
        } catch (SQLException ex) {
            Logger.getLogger(addDepartment.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    
    private int generateSerialNumber() throws SQLException 
    {
        int sNo=0;
        Statement stmt;
        ResultSet rs= null;
        String serial="SELECT max(id) from department";
        
        try{
         stmt=conn.createStatement();
         rs=stmt.executeQuery(serial);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            
        }
        
        if(rs.next())
        {
            sNo=rs.getInt(1);
            sNo++;
        }
        else
        {
            sNo=1;
        }
        
        return sNo;
        
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        openAccountButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        plantId = new javax.swing.JTextField();
        plantName = new javax.swing.JTextField();
        submit = new javax.swing.JButton();
        Logout = new javax.swing.JButton();
        Home = new javax.swing.JButton();

        openAccountButton.setText("Open Account");
        openAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openAccountButtonActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel12.setText("Add New Department");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 31;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 75, 0, 0);
        jPanel1.add(jLabel12, gridBagConstraints);

        jLabel13.setText("Department Id : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 12, 0, 0);
        jPanel1.add(jLabel13, gridBagConstraints);

        jLabel14.setText("Department Name :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 12, 0, 0);
        jPanel1.add(jLabel14, gridBagConstraints);

        plantId.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 144;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 12, 0, 0);
        jPanel1.add(plantId, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 144;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(19, 12, 0, 0);
        jPanel1.add(plantName, gridBagConstraints);

        submit.setText("Add Department");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(56, 75, 50, 0);
        jPanel1.add(submit, gridBagConstraints);

        Logout.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Logout.setText("Log out / وتل");
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 160, 0, 12);
        jPanel1.add(Logout, gridBagConstraints);

        Home.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Home.setText("Home / کور");
        Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 160, 0, 12);
        jPanel1.add(Home, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openAccountButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_openAccountButtonActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        // TODO add your handling code here:
        Statement stmt;
        
        Category=plantId.getText();
        unit=plantName.getText();
        
        if(Category!=null && unit!=null)
        {
         String sql= "INSERT into department values (default,?)" ;
            try {
                
                PreparedStatement pstmt = conn.prepareStatement(sql);
                
                //pstmt.setString(1,Category);
                pstmt.setString(1,unit);
                
                pstmt.executeUpdate();
                
                JOptionPane.showMessageDialog(null,"  Successfully Addded! ");
                plantId.setText(" ");
                plantName.setText(" ");
                
                addDepartment obj=new addDepartment();
                obj.setVisible(true);
                this.dispose();
                
//                String role=QASProject.userrole;
//
//        if(role.equals("Admin"))
//        {
//            adminHome obj=new adminHome();
//            obj.setVisible(true);
//            this.dispose();
//
//        }
//
//        //manager
//        else if(role.equals("Manager"))
//        {
//            ManagerHome obj=new ManagerHome();
//            obj.setVisible(true);
//            this.dispose();
//
//        }
//
//        //gateKeeper
//        else if(role.equals("Gate Keeper"))
//        {
//            gateKeeperHome obj=new gateKeeperHome();
//            obj.setVisible(true);
//            this.dispose();
//
//        }
//        //store Incharge
//        else if(role.equals("Store Incharge"))
//        {
//            storeInchargeHome obj=new storeInchargeHome();
//            obj.setVisible(true);
//            this.dispose();
//
//        }
//
//        //finished goods store incharge
//        else if(role.equals("Warehouse Incharge"))
//        {
//            FinishedStoreInchargeHome obj=new FinishedStoreInchargeHome();
//            obj.setVisible(true);
//            this.dispose();
//        }
//                
                    //this.dispose();
                
            } catch (SQLException ex) {
                Logger.getLogger(addDepartment.class.getName()).log(Level.SEVERE, null, ex);
            }
         
         
        }
        
        
        
    }//GEN-LAST:event_submitActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        // TODO add your handling code here:
        login obj=new login();
        obj.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_LogoutActionPerformed

    private void HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeActionPerformed
        // TODO add your handling code here:
        String role=QASProject.userrole;

        if(role.equals("Admin"))
        {
            adminHome obj=new adminHome();
            obj.setVisible(true);
            this.dispose();

        }

        //manager
        else if(role.equals("Manager"))
        {
            ManagerHome obj=new ManagerHome();
            obj.setVisible(true);
            this.dispose();

        }

        //gateKeeper
        else if(role.equals("Gate Keeper"))
        {
            gateKeeperHome obj=new gateKeeperHome();
            obj.setVisible(true);
            this.dispose();

        }
        //store Incharge
        else if(role.equals("Store Incharge"))
        {
            storeInchargeHome obj=new storeInchargeHome();
            obj.setVisible(true);
            this.dispose();

        }

        //finished goods store incharge
        else if(role.equals("Warehouse Incharge"))
        {
            FinishedStoreInchargeHome obj=new FinishedStoreInchargeHome();
            obj.setVisible(true);
            this.dispose();
        }

    }//GEN-LAST:event_HomeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(addDepartment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addDepartment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addDepartment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addDepartment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addDepartment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Home;
    private javax.swing.JButton Logout;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton openAccountButton;
    private javax.swing.JTextField plantId;
    private javax.swing.JTextField plantName;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}
