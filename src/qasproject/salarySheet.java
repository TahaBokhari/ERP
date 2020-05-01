/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qasproject;

import java.awt.Color;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author tahab
 */
public class salarySheet extends javax.swing.JFrame {

    /**
     * Creates new form attandanceSheet
     */
    Connection conn=null;
    static boolean dateFlag=false;
    static String d=null;
    
    ArrayList <String> employees=new ArrayList();
    
    public salarySheet() throws SQLException {
        initComponents();
        this.setTitle("Salary Sheet");
        conn=DBconnection.connectDb();
        
        buttonGroup1.add(selectEmpRadio);
        buttonGroup1.add(allEmpRadio);
        
        Calendar cal = Calendar.getInstance();
        jMonthChooser.setMonth(cal.get(Calendar.MONTH));
        jMonthChooser.setEnabled(false);
        
        Calendar c = Calendar.getInstance();
        int monthMaxDays = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        
        workingDays.setText(Integer.toString(monthMaxDays));
        
        
        populateEmployees();
//        Date date = new Date();
//        currDate.setDate(date);
//        java.sql.Date sqlDate = new java.sql.Date(currDate.getDate().getTime());
//        d=sqlDate.toString();
//        //java.sql.Date date1=(java.sql.Date) currDate.getTime();
//        
//        System.out.println(sqlDate);
//        
//        
//        //currDate.setEnabled(false);
//        
//        dateFlag=checkAttendance(sqlDate);
//        
//        if(dateFlag==false){
//        //String sql="Select distinct (employeeId),name From Employees";
//            submit.disable();
//            print.disable();
//            currDate.setEnabled(false);
//            
//            
//        }
//        else if(dateFlag==true){
//        
//        populateEmployee();
//        String[] values={"--Please Select--","Present","Absent"};
//        JComboBox c=new JComboBox(values);
//        itemTable.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(c));
//        }
//        
//        
        
    }
    
    private void populateEmployees() throws SQLException
    {
        Statement stmt;
        ResultSet rs= null;
        String sql="Select distinct (employeeId),name From employees";
        
        try{
         stmt=conn.createStatement();
         rs=stmt.executeQuery(sql);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            
        }
        while(rs.next())
        {
            String emp=rs.getString(2)+"  "+rs.getString(1);
            employees.add(emp);
        }
        
//        employees.add("ali  EMP-0002");
//        employees.add("farooq  EMP-0003");
        
        DefaultComboBoxModel model2 = new DefaultComboBoxModel(employees.toArray());
        empCombo.setModel( model2);
        
        empCombo.setSelectedItem(" ");
        AutoCompleteDecorator.decorate(empCombo);
        
    }
//    private boolean checkAttendance(Date currentDate) throws SQLException
//    {
//        ArrayList <String> enteredDates=new ArrayList();
//        Statement stmt;
//        ResultSet rs= null;
//        String sql="Select distinct (attendanceDate) From attendance";
//        
//        try{
//         stmt=conn.createStatement();
//         rs=stmt.executeQuery(sql);
//        }
//        catch(Exception e)
//        {
//            System.out.println(e.getMessage());
//            
//        }
//        
//        while(rs.next())
//         {
//             System.out.println("not null");
//             String supplier=rs.getString(1);
//             enteredDates.add(supplier);
//             
//         }
//        System.out.println("list: "+enteredDates);
//        System.out.println("passed date :"+currentDate.toString());
//        
//        if(enteredDates.contains(currentDate.toString()))
//        {
//            return false;
//        }
//        
//        return true;
//    }
    
//    private void populateEmployee() throws SQLException
//    {
//        Statement stmt;
//        ResultSet rs= null;
//        String sql="Select distinct (employeeId)AS Employee_ID,name AS Name,fatherName AS Father_Name,department AS Department,fatherName AS Attendance From employees";
//        
//        try{
//         stmt=conn.createStatement();
//         rs=stmt.executeQuery(sql);
//        }
//        catch(Exception e)
//        {
//            System.out.println(e.getMessage());
//            
//        }
//        
//        itemTable.setModel(DbUtils.resultSetToTableModel(rs));
//        
//        for(int i=0;i<itemTable.getRowCount();i++)
//        {
//        itemTable.setValueAt("--Please Select--", i, 4);
//        }
////        String[] values={"--Please Select--","Present","Absent"};
////        JComboBox c=new JComboBox(values);
//        //itemTable.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(c));
////        plants.add("--Please Select--");
////         while(rs.next())
////         {
////             System.out.println("not null");
////             String plant=rs.getString(1);
////             plants.add(plant);
////             
////         }
////         
////        DefaultComboBoxModel model2 = new DefaultComboBoxModel(plants.toArray());
////        deptCombo.setModel( model2);
//         
//        
//    }
//    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemTable = new javax.swing.JTable();
        print = new javax.swing.JButton();
        jMonthChooser = new com.toedter.calendar.JMonthChooser();
        factoryCombo = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        allEmpRadio = new javax.swing.JRadioButton();
        selectEmpRadio = new javax.swing.JRadioButton();
        empCombo = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        generateSalary = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        workingDays = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Factory :");

        itemTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        itemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        itemTable.setRowHeight(24);
        itemTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                itemTableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(itemTable);

        print.setText("Print");

        factoryCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Al Makkah Fiber" }));
        factoryCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                factoryComboActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Month :");

        allEmpRadio.setText("All Employees");

        selectEmpRadio.setText("Select Employee");
        selectEmpRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectEmpRadioActionPerformed(evt);
            }
        });

        empCombo.setEditable(true);
        empCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        empCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empComboActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Employee :");

        generateSalary.setText("Generate Salary");
        generateSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateSalaryActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Total Working Days :");

        workingDays.setEditable(false);
        workingDays.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                workingDaysActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1313, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(selectEmpRadio)
                                        .addGap(35, 35, 35))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jMonthChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(40, 40, 40)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(workingDays, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(empCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(48, 48, 48)
                                .addComponent(generateSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(allEmpRadio)
                            .addComponent(factoryCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(factoryCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(workingDays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jMonthChooser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(allEmpRadio)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(selectEmpRadio)
                            .addComponent(empCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(generateSalary)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(print)
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void factoryComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_factoryComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_factoryComboActionPerformed

    private void empComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empComboActionPerformed

    private void workingDaysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_workingDaysActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_workingDaysActionPerformed

    private void generateSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateSalaryActionPerformed
        // TODO add your handling code here:
        
        String sql="Select E.employeeId AS EMP_ID, E.name AS EMP_Name,E.department AS Department, (E.salaryAmount/DAY(LAST_DAY(CURDATE()))) AS Per_Day_Salary, count(A.employeeId)AS Working_Days,(E.salaryAmount/DAY(LAST_DAY(CURDATE())))*count(A.employeeId) AS Calculated_Salary,DAY(LAST_DAY(CURDATE())) AS Previous_Deduction,(E.salaryAmount/DAY(LAST_DAY(CURDATE())))*count(A.employeeId) AS Net_Salary From employees AS E inner join attendance AS A on E.employeeId=A.employeeId Where MONTH(A.attendanceDate)=MONTH(CURDATE()) AND YEAR(A.attendanceDate)=YEAR(CURDATE()) AND A.status='Present' GROUP BY A.employeeId ";
        Statement stmt;
        ResultSet rs= null;
        try{
         stmt=conn.createStatement();
         rs=stmt.executeQuery(sql);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            
        }
        
        double val=0.0;
        BigDecimal a=new BigDecimal(val); 
        
        
            
            //int totalDays=(Integer) itemTable.getValueAt(0, 6);
        
        
        itemTable.setModel(DbUtils.resultSetToTableModel(rs));
        
        
        
        for(int i=0;i<itemTable.getRowCount();i++)
        {
            itemTable.setValueAt(a, i, 6);
            //itemTable.setValueAt(0, i, 7);
        }
        
        
    }//GEN-LAST:event_generateSalaryActionPerformed

    private void selectEmpRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectEmpRadioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectEmpRadioActionPerformed

    private void itemTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemTableKeyPressed
        // TODO add your handling code here:
        //System.out.println(this.);
        int row=itemTable.getSelectedRow();
        
        TableModel model=itemTable.getModel();
        
        BigDecimal calcSalary=(BigDecimal)itemTable.getValueAt(row,5);
        System.out.println(calcSalary);
        
        BigDecimal deduction=new BigDecimal(Double.parseDouble(model.getValueAt(row, 6).toString())) ;
        System.out.println(deduction);
//        
        //double calcSalary=(double) itemTable.getValueAt(row,5);
        //BigDecimal deduction=(BigDecimal) itemTable.getValueAt(row,6);
        //System.out.println(deduction);
        
        BigDecimal netSalary=calcSalary.subtract(deduction);
        itemTable.setValueAt(netSalary, row, 7);
//        //itemTable.setV
        
    }//GEN-LAST:event_itemTableKeyPressed

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
            java.util.logging.Logger.getLogger(salarySheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(salarySheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(salarySheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(salarySheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                   salarySheet obj= new salarySheet();
                   obj.setVisible(true);
                   
//                    if(dateFlag==false)
//                    {
//                        JOptionPane.showMessageDialog(null,"Attendance already marked for "+d);
//                        obj.setEnabled(false);
//                        //obj.setBackground(new Color(0,100,0,100));
//                        
//                        
//                    }
                } catch (SQLException ex) {
                    Logger.getLogger(salarySheet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton allEmpRadio;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox empCombo;
    private javax.swing.JComboBox factoryCombo;
    private javax.swing.JButton generateSalary;
    private javax.swing.JTable itemTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private com.toedter.calendar.JMonthChooser jMonthChooser;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton print;
    private javax.swing.JRadioButton selectEmpRadio;
    private javax.swing.JTextField workingDays;
    // End of variables declaration//GEN-END:variables
}
