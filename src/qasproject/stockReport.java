
package qasproject;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;


///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package qasproject;
//
///**
// *
// * @author tahab
// */
public class stockReport extends javax.swing.JFrame {
//
//    /**
//     * Creates new form stockReport
//     */
    Connection conn=null;
    ArrayList <String> availableItems=new ArrayList();
    ArrayList <String> availableMaterials=new ArrayList();
    String selectedItem=null;
    
    public stockReport() throws SQLException {
        
        initComponents();
        this.setTitle("stock Report");
        
        buttonGroup1.add(AllItems);
        buttonGroup1.add(singleItem);
        buttonGroup1.add(singleMaterial);                        
        
        conn=DBconnection.connectDb();
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	LocalDateTime now = LocalDateTime.now();
	
        openingDate.setText(dtf.format(now));
        
        
        
        Statement stmt;
        ResultSet rs = null;

        
        String sql="SELECT DISTINCT(materialName) FROM Material;";
        
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
//             String desc=rs.getString(2);
//             String item=code+" "+desc;
            availableMaterials.add(material);
             
         }
        
        
        DefaultComboBoxModel model = new DefaultComboBoxModel(availableMaterials.toArray());
        materialCombo.setModel( model );
        materialCombo2.setModel( model );
        
        materialCombo2.disable();
        materialCombo.disable();
        itemsCombo.disable();
        
        preparedBy.setText(QASProject.userName);
        
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
        
    }
//
//    /**
//     * This method is called from within the constructor to initialize the form.
//     * WARNING: Do NOT modify this code. The content of this method is always
//     * regenerated by the Form Editor.
//     */
//    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        GeneralInfo = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        openingDate = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        Home = new javax.swing.JButton();
        Logout = new javax.swing.JButton();
        AllItems = new javax.swing.JRadioButton();
        singleItem = new javax.swing.JRadioButton();
        itemsCombo = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        materialCombo = new javax.swing.JComboBox();
        singleMaterial = new javax.swing.JRadioButton();
        materialCombo2 = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        itemTable = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        preparedBy = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        GeneralInfo.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Date:");

        openingDate.setEditable(false);

        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        Home.setText("Home");
        Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeActionPerformed(evt);
            }
        });

        Logout.setText("Log out");
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });

        AllItems.setText("All Items");
        AllItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AllItemsActionPerformed(evt);
            }
        });

        singleItem.setText("Select Item");
        singleItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singleItemActionPerformed(evt);
            }
        });

        itemsCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        itemsCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemsComboActionPerformed(evt);
            }
        });

        jLabel3.setText("Select items:");

        materialCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        materialCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialComboActionPerformed(evt);
            }
        });

        singleMaterial.setText("Select Material");
        singleMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singleMaterialActionPerformed(evt);
            }
        });

        materialCombo2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        materialCombo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialCombo2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout GeneralInfoLayout = new javax.swing.GroupLayout(GeneralInfo);
        GeneralInfo.setLayout(GeneralInfoLayout);
        GeneralInfoLayout.setHorizontalGroup(
            GeneralInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GeneralInfoLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(GeneralInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(155, 155, 155)
                .addGroup(GeneralInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GeneralInfoLayout.createSequentialGroup()
                        .addGroup(GeneralInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(singleItem, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(singleMaterial))
                        .addGap(58, 58, 58)
                        .addGroup(GeneralInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(GeneralInfoLayout.createSequentialGroup()
                                .addComponent(materialCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(84, 84, 84)
                                .addComponent(itemsCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(149, 149, 149)
                                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(materialCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(GeneralInfoLayout.createSequentialGroup()
                        .addGroup(GeneralInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(GeneralInfoLayout.createSequentialGroup()
                                .addComponent(openingDate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(653, 653, 653)
                                .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(GeneralInfoLayout.createSequentialGroup()
                                .addComponent(AllItems)
                                .addGap(724, 724, 724)
                                .addComponent(Home, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        GeneralInfoLayout.setVerticalGroup(
            GeneralInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GeneralInfoLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(GeneralInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(GeneralInfoLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(openingDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Logout))
                .addGroup(GeneralInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GeneralInfoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(materialCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(GeneralInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(singleItem)
                            .addComponent(materialCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(itemsCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(search)))
                    .addGroup(GeneralInfoLayout.createSequentialGroup()
                        .addGroup(GeneralInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(GeneralInfoLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(Home))
                            .addGroup(GeneralInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(GeneralInfoLayout.createSequentialGroup()
                                    .addGap(29, 29, 29)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GeneralInfoLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(AllItems))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(singleMaterial)
                        .addGap(0, 34, Short.MAX_VALUE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setText("Items:");

        itemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Rate/ unit"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        itemTable.setCellSelectionEnabled(true);
        jScrollPane3.setViewportView(itemTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel23.setText("Prepared by:");

        jButton5.setText("Print");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        preparedBy.setEditable(false);
        preparedBy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preparedByActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(preparedBy, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(797, 797, 797)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(preparedBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jButton5)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GeneralInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GeneralInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private void populateCodeAndDescription(String selectedMaterial, String sql) throws SQLException
    {
        availableItems.clear();
        //descriptions.clear();
        
        Statement stmt;
        ResultSet rs = null;

        
        String sql1="SELECT DISTINCT(itemBarcode),itemDescription FROM ItemType Where itemCategory='"+selectedMaterial+"';";
        
        try{
         stmt=conn.createStatement();
         rs=stmt.executeQuery(sql1);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            
        }
         while(rs.next())
         {
             System.out.println("not null");
             String code=rs.getString(1);
             String desc=rs.getString(2);
             String item=code+" "+desc;
             availableItems.add(item);
             
         }
        
        
        DefaultComboBoxModel model = new DefaultComboBoxModel(availableItems.toArray());
        itemsCombo.setModel( model );
        //itemsCombo.disable();
            }

    
    
    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
        //int inwardSerial=Integer.parseInt(gateInwardSerial.getText().toString());
        
        
        Statement stmt;
        ResultSet rs= null;
        
        if(AllItems.isSelected()==false && singleItem.isSelected()==false && singleMaterial.isSelected()==false)
        {
            JOptionPane.showMessageDialog(null," Please select atleast one itmem! ");
            
        }
        else if(AllItems.isSelected()==true)
        {
            //update
            String sql="Select S.itemCode, I.itemDescription, S.itemQuantity, S.itemUnitPrice From stock As S inner join ItemType as I on S.itemCode=I.itemBarcode Where S.itemQuantity>0";
            try {
                stmt=conn.createStatement();
                rs=stmt.executeQuery(sql);
                
//                if(rs.next())
//                {
                  itemTable.setModel(DbUtils.resultSetToTableModel(rs));
//                }
//                else
//                {
//                    JOptionPane.showMessageDialog(null," No Record Found ");
//                }
            } catch (SQLException ex) {
                Logger.getLogger(stockReport.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else if (singleItem.isSelected()==true)
        {
            selectedItem=itemsCombo.getSelectedItem().toString();
            selectedItem= selectedItem.substring(0, selectedItem.indexOf(" "));
            
            String sql="Select S.itemCode, I.itemDescription, S.itemQuantity, S.itemUnitPrice From stock As S inner join ItemType as I on S.itemCode=I.itemBarcode Where S.itemcode='"+selectedItem+"'; ";
            try {
                stmt=conn.createStatement();
                rs=stmt.executeQuery(sql);
                
//                if(rs.next())
//                {
                  itemTable.setModel(DbUtils.resultSetToTableModel(rs));
//                }
//                else
//                {
//                    JOptionPane.showMessageDialog(null," No Record Found ");
//                }
                
                
            } catch (SQLException ex) {
                Logger.getLogger(stockReport.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        
        else if (singleMaterial.isSelected()==true)
        {
            selectedItem=materialCombo2.getSelectedItem().toString();
            //selectedItem= selectedItem.substring(0, selectedItem.indexOf(" "));
            
            String sql="Select S.itemCode, I.itemDescription, S.itemQuantity, S.itemUnitPrice From stock As S inner join ItemType as I on S.itemCode=I.itemBarcode Where I.itemCategory='"+selectedItem+"'; ";
            try {
                stmt=conn.createStatement();
                rs=stmt.executeQuery(sql);
                
//                if(rs.next())
//                {
                  itemTable.setModel(DbUtils.resultSetToTableModel(rs));
//                }
//                else
//                {
//                    JOptionPane.showMessageDialog(null," No Record Found ");
//                }
                
                
            } catch (SQLException ex) {
                Logger.getLogger(stockReport.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
            //
    }//GEN-LAST:event_searchActionPerformed

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

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        // TODO add your handling code here:
        login obj=new login();
        obj.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_LogoutActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void AllItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AllItemsActionPerformed
        // TODO add your handling code here:
        materialCombo.disable();
        itemsCombo.disable();
    }//GEN-LAST:event_AllItemsActionPerformed

    private void singleItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singleItemActionPerformed
        // TODO add your handling code here:
        materialCombo.enable();
        itemsCombo.disable();
        materialCombo2.disable();
        //itemsCombo.enable();
    }//GEN-LAST:event_singleItemActionPerformed

    private void preparedByActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preparedByActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_preparedByActionPerformed

    private void itemsComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemsComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemsComboActionPerformed

    private void materialComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materialComboActionPerformed
        // TODO add your handling code here:
        itemsCombo.enable();
        String selected=materialCombo.getSelectedItem().toString();
        try {
            populateCodeAndDescription(selected,null);
        } catch (SQLException ex) {
            Logger.getLogger(GateInward.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_materialComboActionPerformed

    private void singleMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singleMaterialActionPerformed
        // TODO add your handling code here:
        materialCombo2.enable();
        materialCombo.disable();
        itemsCombo.disable();
    }//GEN-LAST:event_singleMaterialActionPerformed

    private void materialCombo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materialCombo2ActionPerformed
        // TODO add your handling code here:
        itemsCombo.disable();
    }//GEN-LAST:event_materialCombo2ActionPerformed

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
            java.util.logging.Logger.getLogger(stockReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(stockReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(stockReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(stockReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new stockReport().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(stockReport.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton AllItems;
    private javax.swing.JPanel GeneralInfo;
    private javax.swing.JButton Home;
    private javax.swing.JButton Logout;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTable itemTable;
    private javax.swing.JComboBox itemsCombo;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JComboBox materialCombo;
    private javax.swing.JComboBox materialCombo2;
    private javax.swing.JTextField openingDate;
    private javax.swing.JTextField preparedBy;
    private javax.swing.JButton search;
    private javax.swing.JRadioButton singleItem;
    private javax.swing.JRadioButton singleMaterial;
    // End of variables declaration//GEN-END:variables
}
