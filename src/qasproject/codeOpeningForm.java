/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qasproject;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.xml.datatype.DatatypeConstants.DATETIME;

/**
 *
 * @author tahab
 */
public class codeOpeningForm extends javax.swing.JFrame {

    /**
     * Creates new form codeOpeningForm
     */
    
    Connection conn=null;
    ArrayList <String> materials=new ArrayList();
    ArrayList <String> MCat=new ArrayList();
    
    int number=0;
    String type="TECHNICAL"; 
    
    public codeOpeningForm() throws SQLException {
        
        initComponents();
        this.setTitle("Add New Item");
        conn=DBconnection.connectDb();
        
        //
        //int num=10;
//        int length = String.valueOf(num).length();
//        System.out.println(length);
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	LocalDateTime now = LocalDateTime.now();
	//System.out.println(dtf.format(now)); //2016/11/16 12:08:43
        
        openingDate.setText(dtf.format(now));
        //openingDate.disable();
       
        factorySelectionCombo.addItem("Al Makkah Fiber");
        
        Statement stmt;
        ResultSet rs = null;
        
        Statement stmt2;
        ResultSet rs2 = null;
        
        Statement stmt3;
        ResultSet rs3 = null;

        
        String sql="SELECT DISTINCT materialName FROM Material;";
        
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
             System.out.println("not null");
             String material=rs.getString(1);
             materials.add(material);
             
         }
        
        
        DefaultComboBoxModel model = new DefaultComboBoxModel(materials.toArray());
        materialSelectionCombo.setModel( model );
        //materialSelectionCombo.addActionListener(factorySelectionCombo);
        
        String code1=generateItemCode();
        //String code1="ab";
        itemCode.setText(code1);
        barCode.setText(code1);
        
        
        //Measurement Category combo 
        
        String sql2="SELECT DISTINCT unitName FROM Units;";
        
        try{
         stmt2=conn.createStatement();
         rs2=stmt2.executeQuery(sql2);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            
        }
         while(rs2.next())
         {
             System.out.println("not null");
             String categ=rs2.getString(1);
             MCat.add(categ);
             
         }
        
        DefaultComboBoxModel model2 = new DefaultComboBoxModel(MCat.toArray());
        UOMCombo.setModel( model2);
        
        
        accountOpenedBy.setText(QASProject.userName);
        
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        this.addWindowListener(new WindowAdapter() {
            
            public void windowClosing(WindowEvent e) {
            int confirmed = JOptionPane.showConfirmDialog(null, 
            "Do you want to close the program?", "Exit Program Message Box",
            JOptionPane.YES_NO_OPTION);

        if (confirmed == JOptionPane.YES_OPTION) {
         String role=QASProject.userrole;
        
                    if(role.equals("Admin"))
                    {
                        adminHome obj=new adminHome();
                        obj.setVisible(true);
                        dispose();

                    }
                    
                    //manager
                    else if(role.equals("Manager"))
                    {
                        ManagerHome obj=new ManagerHome();
                        obj.setVisible(true);
                        dispose();

                    }
                    
                     //gateKeeper
                    else if(role.equals("Gate Keeper"))
                    {
                        gateKeeperHome obj=new gateKeeperHome();
                        obj.setVisible(true);
                        dispose();

                    }
                    //store Incharge
                    else if(role.equals("Store Incharge"))
                    {
                        storeInchargeHome obj=new storeInchargeHome();
                        obj.setVisible(true);
                        dispose();

                    }
                    
                    //finished goods store incharge
                    else if(role.equals("Warehouse Incharge"))
                    {
                        FinishedStoreInchargeHome obj=new FinishedStoreInchargeHome();
                        obj.setVisible(true);
                        dispose();
                    }
        }
  }
});
        //UOM combo box
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Logout = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        openingDate = new javax.swing.JTextField();
        barCode = new javax.swing.JTextField();
        itemCode = new javax.swing.JTextField();
        itemDescription = new javax.swing.JTextField();
        accountOpenedBy = new javax.swing.JTextField();
        materialSelectionCombo = new javax.swing.JComboBox();
        factorySelectionCombo = new javax.swing.JComboBox();
        UOMCombo = new javax.swing.JComboBox();
        openAccountButton1 = new javax.swing.JButton();
        openAccountButton2 = new javax.swing.JButton();
        Home = new javax.swing.JButton();
        Logout1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        openAccountButton = new javax.swing.JButton();
        openAccountButton3 = new javax.swing.JButton();

        Logout.setText("Log out");
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setText("Account Opening Date :");

        jLabel13.setText("Item Category :");

        jLabel14.setText("Barcode :");

        jLabel15.setText("Item Code :");

        jLabel16.setText("Name :");

        jLabel17.setText("Unit of Measurement :");

        jLabel18.setText("Factory :");

        jLabel19.setText("Account Opened By :");

        openingDate.setEditable(false);

        accountOpenedBy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountOpenedByActionPerformed(evt);
            }
        });

        materialSelectionCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialSelectionComboActionPerformed(evt);
            }
        });

        UOMCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UOMComboActionPerformed(evt);
            }
        });

        openAccountButton1.setText("Add Item Category");
        openAccountButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openAccountButton1ActionPerformed(evt);
            }
        });

        openAccountButton2.setText("Add Unit");
        openAccountButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openAccountButton2ActionPerformed(evt);
            }
        });

        Home.setText("Home");
        Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeActionPerformed(evt);
            }
        });

        Logout1.setText("Log out");
        Logout1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Logout1ActionPerformed(evt);
            }
        });

        jButton1.setText("View Items");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(504, 504, 504)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(openingDate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Logout1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(materialSelectionCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(openAccountButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                .addComponent(Home, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(barCode, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(itemCode, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(itemDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(UOMCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(openAccountButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(factorySelectionCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(accountOpenedBy, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(openingDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Logout1))))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(materialSelectionCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(openAccountButton1)
                    .addComponent(Home))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(barCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(itemCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(itemDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(UOMCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(openAccountButton2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(factorySelectionCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(accountOpenedBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        openAccountButton.setText("Open Account");
        openAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openAccountButtonActionPerformed(evt);
            }
        });

        openAccountButton3.setText("Update Account");
        openAccountButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openAccountButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(503, 503, 503)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(openAccountButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(openAccountButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(openAccountButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(openAccountButton3)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public String generateItemCode() throws SQLException
    {
        Statement stmt2;
        ResultSet rs2 = null;
        //int number=0;
        
        if(materialSelectionCombo.getSelectedItem()!=null)
        type=materialSelectionCombo.getSelectedItem().toString();
        
        String queryNumber="SELECT max(itemCode) FROM ItemType WHERE itemCategory='"+type+"' group by itemCategory ";
        
        try{
         stmt2=conn.createStatement();
         rs2=stmt2.executeQuery(queryNumber);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            
        }
        
        if(rs2.next())
        {
         number=Integer.valueOf(rs2.getString(1));
         number++;
        }
        else
        {
            number=1;
        }
        
        
        //appending
        String append=null;
        
        //number
        int length = String.valueOf(number).length();
        System.out.println(length);
        
        if(length==1)
        {
            append="000";
        }
        else if(length==2)
        {
            append="00";
        }
        else if(length==3)
        {
            append="0";
            
        }
        System.out.println(length);

        //type
        type=type; //.substring(0, 3)
        //type=type.toUpperCase();
//        if(type.equalsIgnoreCase("TECHNICAL"))
//        {
//           type="TEC"; 
//        }
        
        String code=type+"-"+append+number;
        
        return code;
    }
    
    private void openAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openAccountButtonActionPerformed
        // TODO add your handling code here:
        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        
        String itemCtg=materialSelectionCombo.getSelectedItem().toString();
        String barcode=barCode.getText();
        String code=itemCode.getText();
        String desc=itemDescription.getText();
        //String unitCtg=measurementCategoryCombo.getSelectedItem().toString();
        String unit=UOMCombo.getSelectedItem().toString();
        String fac=factorySelectionCombo.getSelectedItem().toString();
        String openedBy=accountOpenedBy.getText();
        
        String sql4="INSERT into ItemType values (default,?,?,?,?,?,?,?,?)" ;
        
        PreparedStatement pstmt=null;
        
        try {
            pstmt = conn.prepareStatement(sql4);
            
            System.out.println(date);
            pstmt.setTimestamp(1, date);
            pstmt.setString(2,itemCtg);
            pstmt.setString(3,barcode);
            pstmt.setInt(4,number);
            pstmt.setString(5,desc);
            //pstmt.setString(6,unitCtg);
            pstmt.setString(6,unit);
            pstmt.setString(7,fac);
            pstmt.setString(8,openedBy);
           
            pstmt.executeUpdate();
                
            JOptionPane.showMessageDialog(null,"  Successfully Addded! ");
            
            Statement stmt2=conn.createStatement();;
            ResultSet rs2 = null;
            
            //String StockQuery="INSERT INTO stock  VALUES (NULL, '2020-01-01 00:00:00', 'TEC-0002', '0', '0', NULL, NULL)";
           
        String sql5="INSERT into stock values (default,?,?,?,?)" ;
        
        PreparedStatement pstmt2=null;
        
        try {
            pstmt2 = conn.prepareStatement(sql5);
            
            
            pstmt2.setTimestamp(1, date);
            pstmt2.setString(2,barcode);
            pstmt2.setInt(3,0);
            pstmt2.setInt(4,0);
//            pstmt2.setString(5,null);
//            pstmt2.setString(6,null);
//            pstmt.setString(5,desc);
//            pstmt.setString(6,unitCtg);
//            pstmt.setString(7,unit);
//            pstmt.setString(8,fac);
//            pstmt.setString(9,openedBy);
//           
            pstmt2.executeUpdate();
            //JOptionPane.showMessageDialog(null,"  Successfully Addded in Stock! ");
            
            //String StockQuery="INSERT INTO stock VALUES (default,'"+barcode+"','"+date+"','0','0',NULL,NULL)"; //default,'"+barcode+"','"+date+"',0,0,NULL,NULL
            
//            boolean flag=stmt2.execute(StockQuery);
//            if(flag==true)
//            {
//                JOptionPane.showMessageDialog(null,"  Successfully Addded in Stock! ");
//            }
//            else
//            {
//                System.out.println("error");
//            }
            
        
            
        } catch (SQLException ex) {
            Logger.getLogger(codeOpeningForm.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        } catch (SQLException ex) {
            Logger.getLogger(codeOpeningForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_openAccountButtonActionPerformed

    private void materialSelectionComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materialSelectionComboActionPerformed
        try {
            // TODO add your handling code here:
            String code=generateItemCode();
            itemCode.setText(code);
            barCode.setText(code);
            //itemCode.setText(generateItemCode());
        } catch (SQLException ex) {
            Logger.getLogger(codeOpeningForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_materialSelectionComboActionPerformed

    private void UOMComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UOMComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UOMComboActionPerformed

    private void openAccountButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openAccountButton1ActionPerformed
        // TODO add your handling code here:
        addMaterial am;
        try {
            am = new addMaterial();
            am.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(codeOpeningForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_openAccountButton1ActionPerformed

    private void openAccountButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openAccountButton2ActionPerformed
        // TODO add your handling code here:
        AddUOM au;
        au = new AddUOM();
        au.setVisible(true);
    }//GEN-LAST:event_openAccountButton2ActionPerformed

    private void openAccountButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openAccountButton3ActionPerformed
        try {
            // TODO add your handling code here:
            updateItemCode form=new updateItemCode();
            form.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(codeOpeningForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_openAccountButton3ActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        // TODO add your handling code here:
        login obj=new login();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LogoutActionPerformed

    private void Logout1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Logout1ActionPerformed
        // TODO add your handling code here:
        login obj=new login();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Logout1ActionPerformed

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        viewItemCode obj;
        try {
            obj = new viewItemCode();
            obj.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(codeOpeningForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void accountOpenedByActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountOpenedByActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_accountOpenedByActionPerformed

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
            java.util.logging.Logger.getLogger(codeOpeningForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(codeOpeningForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(codeOpeningForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(codeOpeningForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
                try {
                    codeOpeningForm form=new codeOpeningForm();
                    form.setVisible(true);
                    //form.disable();
                } catch (SQLException ex) {
                    Logger.getLogger(codeOpeningForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                
               
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Home;
    private javax.swing.JButton Logout;
    private javax.swing.JButton Logout1;
    private javax.swing.JComboBox UOMCombo;
    private javax.swing.JTextField accountOpenedBy;
    private javax.swing.JTextField barCode;
    private javax.swing.JComboBox factorySelectionCombo;
    private javax.swing.JTextField itemCode;
    private javax.swing.JTextField itemDescription;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JComboBox materialSelectionCombo;
    private javax.swing.JButton openAccountButton;
    private javax.swing.JButton openAccountButton1;
    private javax.swing.JButton openAccountButton2;
    private javax.swing.JButton openAccountButton3;
    private javax.swing.JTextField openingDate;
    // End of variables declaration//GEN-END:variables
}
