package qasproject;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Muhammad Taha Bokhar
 */
public class storeInchargeHome extends javax.swing.JFrame {

    /**
     * Creates new form home
     */
    public storeInchargeHome() {
        initComponents();
        this.setTitle("Store Incharge Home");
        
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        this.addWindowListener(new WindowAdapter() {
            
            public void windowClosing(WindowEvent e) {
            int confirmed = JOptionPane.showConfirmDialog(null, 
            "Do you want to close the program?", "Exit Program Message Box",
            JOptionPane.YES_NO_OPTION);

        if (confirmed == JOptionPane.YES_OPTION) {
          dispose();
        }
  }
});
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel12 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        issueNote = new java.awt.Button();
        stockReport = new java.awt.Button();
        GRN = new java.awt.Button();
        changePassword = new java.awt.Button();
        GRN1 = new java.awt.Button();
        conumReport = new java.awt.Button();
        fiberProduction = new java.awt.Button();
        gateOutward = new java.awt.Button();

        jPanel12.setBackground(new java.awt.Color(36, 47, 65));

        jLabel43.setFont(new java.awt.Font("Trebuchet MS", 3, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(97, 212, 195));
        jLabel43.setText("SYNCSOL ");

        jLabel44.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(97, 212, 195));
        jLabel44.setText("+92 333 8639112");

        jLabel45.setFont(new java.awt.Font("Trebuchet MS", 2, 12)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(97, 212, 195));
        jLabel45.setText("technologies");

        jLabel46.setFont(new java.awt.Font("Trebuchet MS", 2, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(97, 212, 195));
        jLabel46.setText("Taha Bokhari");

        jLabel47.setFont(new java.awt.Font("Trebuchet MS", 2, 12)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(97, 212, 195));
        jLabel47.setText("Powered by:");

        jLabel48.setFont(new java.awt.Font("Trebuchet MS", 2, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(97, 212, 195));
        jLabel48.setText("theSyncSol@gmail.com");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel44)
                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel45))
                    .addComponent(jLabel47)
                    .addComponent(jLabel48))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addComponent(jLabel47)
                .addGap(2, 2, 2)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(54, 69, 79));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 55)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("INVENTORY MODULE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(384, 384, 384)
                .addComponent(jLabel6)
                .addContainerGap(391, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(54, 69, 79), 2));

        issueNote.setBackground(new java.awt.Color(54, 69, 79));
        issueNote.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        issueNote.setForeground(new java.awt.Color(255, 255, 255));
        issueNote.setLabel("Issue Note");
        issueNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issueNoteActionPerformed(evt);
            }
        });

        stockReport.setBackground(new java.awt.Color(54, 69, 79));
        stockReport.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        stockReport.setForeground(new java.awt.Color(255, 255, 255));
        stockReport.setLabel("Stock Report");
        stockReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockReportActionPerformed(evt);
            }
        });

        GRN.setBackground(new java.awt.Color(54, 69, 79));
        GRN.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        GRN.setForeground(new java.awt.Color(255, 255, 255));
        GRN.setLabel("GRN");
        GRN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GRNActionPerformed(evt);
            }
        });

        changePassword.setBackground(new java.awt.Color(54, 69, 79));
        changePassword.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        changePassword.setForeground(new java.awt.Color(255, 255, 255));
        changePassword.setLabel("Change Password");
        changePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePasswordActionPerformed(evt);
            }
        });

        GRN1.setBackground(new java.awt.Color(54, 69, 79));
        GRN1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        GRN1.setForeground(new java.awt.Color(255, 255, 255));
        GRN1.setLabel("GRN Pet\n  ");
        GRN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GRN1ActionPerformed(evt);
            }
        });

        conumReport.setBackground(new java.awt.Color(54, 69, 79));
        conumReport.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        conumReport.setForeground(new java.awt.Color(255, 255, 255));
        conumReport.setLabel("Consumption Report");
        conumReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conumReportActionPerformed(evt);
            }
        });

        fiberProduction.setBackground(new java.awt.Color(54, 69, 79));
        fiberProduction.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        fiberProduction.setForeground(new java.awt.Color(255, 255, 255));
        fiberProduction.setLabel("Fiber Production");
        fiberProduction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiberProductionActionPerformed(evt);
            }
        });

        gateOutward.setBackground(new java.awt.Color(54, 69, 79));
        gateOutward.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        gateOutward.setForeground(new java.awt.Color(255, 255, 255));
        gateOutward.setLabel("Gate Outward");
        gateOutward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gateOutwardActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(gateOutward, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(fiberProduction, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGap(486, 486, 486)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(changePassword, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                                .addComponent(stockReport, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                                .addComponent(issueNote, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                                .addComponent(GRN, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                                .addComponent(GRN1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(conumReport, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(GRN1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GRN, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(issueNote, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stockReport, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(conumReport, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fiberProduction, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(gateOutward, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(changePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void GRNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GRNActionPerformed
        try {
            // TODO add your handling code here:
            GRNtechnical obj=new GRNtechnical();
            obj.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(storeInchargeHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_GRNActionPerformed

    private void issueNoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issueNoteActionPerformed
        try {
            // TODO add your handling code here:
            issueNote obj=new issueNote();
            obj.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(storeInchargeHome.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_issueNoteActionPerformed

    private void stockReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockReportActionPerformed
        // TODO add your handling code here:
         try {
            // TODO add your handling code here:
            stockReport obj=new stockReport();
            obj.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(ManagerHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_stockReportActionPerformed

    private void changePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePasswordActionPerformed
        // TODO add your handling code here:
        changePassword obj=new changePassword();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_changePasswordActionPerformed

    private void GRN1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GRN1ActionPerformed
        try {
            // TODO add your handling code here:

            GRNPet obj=new GRNPet();
            obj.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(ManagerHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_GRN1ActionPerformed

    private void conumReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conumReportActionPerformed
        try {
            // TODO add your handling code here:

            consumptionReport obj=new consumptionReport();
            obj.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(ManagerHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_conumReportActionPerformed

    private void fiberProductionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiberProductionActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            finishedFiber obj=new finishedFiber();
            obj.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(ManagerHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_fiberProductionActionPerformed

    private void gateOutwardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gateOutwardActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            gateOutward obj=new gateOutward();
            obj.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(ManagerHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_gateOutwardActionPerformed

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
            java.util.logging.Logger.getLogger(storeInchargeHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(storeInchargeHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(storeInchargeHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(storeInchargeHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new storeInchargeHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button GRN;
    private java.awt.Button GRN1;
    private java.awt.Button changePassword;
    private java.awt.Button conumReport;
    private java.awt.Button fiberProduction;
    private java.awt.Button gateOutward;
    private java.awt.Button issueNote;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private java.awt.Button stockReport;
    // End of variables declaration//GEN-END:variables
}