
package qasproject;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
//import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
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
public class gateReport extends javax.swing.JFrame {
//
//    /**
//     * Creates new form stockReport
//     */
    Connection conn=null;
    ArrayList <String> availableItems=new ArrayList();
    
    ArrayList <String> availableMaterials=new ArrayList();
    ArrayList <String> availableSuppliers=new ArrayList();
    
    String selectedItem=null;
    
    public gateReport() throws SQLException {
        
        initComponents();
        this.setTitle("Gate Outward");
        
        buttonGroup1.add(materialRadio);
        buttonGroup1.add(dateRadio);
        buttonGroup1.add(supplierRadio);
        
        
        //buttonGroup1.add(singleItem);
        
        conn=DBconnection.connectDb();
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	LocalDateTime now = LocalDateTime.now();
	
        openingDate.setText(dtf.format(now));
        
        
        //populating comboBoxes
        
        
        Statement stmt1;
        ResultSet rs1 = null;

        
        String sql1="SELECT materialName FROM Material;";
        
        try{
         stmt1=conn.createStatement();
         rs1=stmt1.executeQuery(sql1);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            
        }
         while(rs1.next())
         {
             System.out.println("not null");
             String mName=rs1.getString(1);
             availableMaterials.add(mName);
             
         }
        
        DefaultComboBoxModel model = new DefaultComboBoxModel(availableMaterials.toArray());
        materialCombo.setModel( model );
        materialCombo.disable();

        
        
        Statement stmt2;
        ResultSet rs2 = null;

        
        String sql2="SELECT Distinct(supplierCode),name FROM Suppliers;";
        
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
             String sCode=rs2.getString(1);
             String sName=rs2.getString(2);
             String show=sCode+" "+sName;
             availableSuppliers.add(show);
             
         }
        
        
        DefaultComboBoxModel model2 = new DefaultComboBoxModel(availableSuppliers.toArray());
        supplierCombo.setModel( model2 );
        supplierCombo.disable();

        
        startDate.setEnabled(false);
        endDate.setEnabled(false);
        
        preparedBy.setText(QASProject.userName);
//        
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        this.addWindowListener(new WindowAdapter() {
            
            public void windowClosing(WindowEvent e) {
            int confirmed = JOptionPane.showConfirmDialog(null, 
            "Do you want to close the program?", "Exit Program Message Box",
            JOptionPane.YES_NO_OPTION);

        if (confirmed == JOptionPane.YES_OPTION) {
          //dispose();
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
        materialRadio = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        dateRadio = new javax.swing.JRadioButton();
        supplierRadio = new javax.swing.JRadioButton();
        startDate = new com.toedter.calendar.JDateChooser();
        endDate = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        materialCombo = new javax.swing.JComboBox();
        supplierCombo = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        itemTable = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        print = new javax.swing.JButton();
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

        materialRadio.setText("Material Based");
        materialRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialRadioActionPerformed(evt);
            }
        });

        jLabel3.setText("Select Report Type:");

        dateRadio.setText("Date Based");
        dateRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateRadioActionPerformed(evt);
            }
        });

        supplierRadio.setText("Supplier Based");
        supplierRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierRadioActionPerformed(evt);
            }
        });

        startDate.setDateFormatString("yyyy/MM/dd");

        endDate.setDateFormatString("yyyy/MM/dd");

        jLabel1.setText("to");

        jLabel4.setText("from ");

        materialCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        supplierCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        supplierCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierComboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout GeneralInfoLayout = new javax.swing.GroupLayout(GeneralInfo);
        GeneralInfo.setLayout(GeneralInfoLayout);
        GeneralInfoLayout.setHorizontalGroup(
            GeneralInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GeneralInfoLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(GeneralInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GeneralInfoLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(155, 155, 155)
                        .addComponent(openingDate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(GeneralInfoLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(141, 141, 141)
                        .addGroup(GeneralInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(materialRadio)
                            .addGroup(GeneralInfoLayout.createSequentialGroup()
                                .addGroup(GeneralInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(GeneralInfoLayout.createSequentialGroup()
                                        .addComponent(dateRadio)
                                        .addGap(62, 62, 62)
                                        .addComponent(jLabel4))
                                    .addComponent(supplierRadio))
                                .addGap(12, 12, 12)
                                .addGroup(GeneralInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(supplierCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(materialCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(GeneralInfoLayout.createSequentialGroup()
                                        .addComponent(startDate, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel1)
                                        .addGap(10, 10, 10)
                                        .addComponent(endDate, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(GeneralInfoLayout.createSequentialGroup()
                        .addGap(908, 908, 908)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 350, Short.MAX_VALUE)
                .addGroup(GeneralInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Home, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );
        GeneralInfoLayout.setVerticalGroup(
            GeneralInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GeneralInfoLayout.createSequentialGroup()
                .addGroup(GeneralInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GeneralInfoLayout.createSequentialGroup()
                        .addGroup(GeneralInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(GeneralInfoLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GeneralInfoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(GeneralInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(openingDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Logout, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGroup(GeneralInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(GeneralInfoLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(GeneralInfoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(materialRadio))
                            .addGroup(GeneralInfoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Home))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GeneralInfoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(materialCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)))
                .addGroup(GeneralInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GeneralInfoLayout.createSequentialGroup()
                        .addGroup(GeneralInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(GeneralInfoLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel4))
                            .addGroup(GeneralInfoLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(startDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(GeneralInfoLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel1))
                            .addGroup(GeneralInfoLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(endDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GeneralInfoLayout.createSequentialGroup()
                        .addComponent(dateRadio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(GeneralInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GeneralInfoLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(supplierRadio))
                    .addComponent(search)
                    .addComponent(supplierCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(76, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel23.setText("Prepared by:");

        print.setText("Print");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(preparedBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(print))))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(GeneralInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GeneralInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
        //int inwardSerial=Integer.parseInt(gateInwardSerial.getText().toString());
        
        
        Statement stmt;
        ResultSet rs= null;
        
        if(materialRadio.isSelected()==false && dateRadio.isSelected()==false && supplierRadio.isSelected()==false)
        {
            JOptionPane.showMessageDialog(null," Please select atleast one itmem! ");
            
        }
        else if(materialRadio.isSelected()==true)
        {
            String selectedMaterial=materialCombo.getSelectedItem().toString();
            //update
            String sql="Select g.serialNumber,g.dateOpened,g.supplier,g.purchaser,g.material,g.itemCode,i.itemDescription,g.quantity,g.approvedBy From gateInward AS g inner join ItemType as i on g.itemCode=i.itemBarcode Where g.material='"+selectedMaterial+"'; ";
            //String sql="Select S.itemCode, I.itemDescription, S.itemQuantity, S.itemUnitPrice From stock As S inner join ItemType as I on S.itemCode=I.itemBarcode ";
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
                Logger.getLogger(gateReport.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else if (dateRadio.isSelected()==true)
        {
            Date sDate= startDate.getDate();
            Date eDate= endDate.getDate();
            
            System.out.println(sDate);
            System.out.println(eDate);
            
            java.sql.Date sqlSDate = new java.sql.Date(sDate.getTime());
            java.sql.Date sqlEDate = new java.sql.Date(eDate.getTime());
            
            System.out.println(sqlSDate);
            System.out.println(sqlEDate);
            
            
//            selectedItem=itemsCombo.getSelectedItem().toString();
//            selectedItem= selectedItem.substring(0, selectedItem.indexOf(" "));
//            
           String sql="Select g.serialNumber,g.dateOpened,g.supplier,g.purchaser,g.material,g.itemCode,i.itemDescription,g.quantity,g.approvedBy From gateInward AS g inner join ItemType as i on g.itemCode=i.itemBarcode Where g.dateOpened BETWEEN '"+sqlSDate+"' AND '"+sqlEDate+"' ; ";
            //String sql="Select S.itemCode, I.itemDescription, S.itemQuantity, S.itemUnitPrice From stock As S inner join ItemType as I on S.itemCode=I.itemBarcode Where S.itemcode='"+selectedItem+"'; ";
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
                Logger.getLogger(gateReport.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        
        
        else if (supplierRadio.isSelected()==true)
        {
            String selectedSup=supplierCombo.getSelectedItem().toString();
            //selectedItem=itemsCombo.getSelectedItem().toString();
            selectedSup= selectedSup.substring(selectedSup.indexOf(" ")+1,selectedSup.length());
            System.out.println(selectedSup);
            
            
//            selectedItem=itemsCombo.getSelectedItem().toString();
//            selectedItem= selectedItem.substring(0, selectedItem.indexOf(" "));
//            
           String sql="Select g.serialNumber,g.dateOpened,g.supplier,g.purchaser,g.material,g.itemCode,i.itemDescription,g.quantity,g.approvedBy From gateInward AS g inner join ItemType as i on g.itemCode=i.itemBarcode Where g.supplier ='"+selectedSup+"'  ; ";
            //String sql="Select S.itemCode, I.itemDescription, S.itemQuantity, S.itemUnitPrice From stock As S inner join ItemType as I on S.itemCode=I.itemBarcode Where S.itemcode='"+selectedItem+"'; ";
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
                Logger.getLogger(gateReport.class.getName()).log(Level.SEVERE, null, ex);
            }
        
                //        }
            //
            //
            //
        }
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

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        // TODO add your handling code here:
        
        String finalPrint="";
        String header="                                                   Al Makkah Fiber/ الماکه فایبر ;;                                                      Gate Report/ دروازه راپور ;";
        String serial="تاربخ : "+openingDate.getText()+";";
        //String supplier="Supplier : "+supplierCombo.getSelectedItem().toString()+";";
        String line="; -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------;";
        String tableHeading="د سلسلې نمره             تاربخ               عرضه کونکی                اخسیتونکی               مواد               کوډ                   تفصیل             مقداری";
        
        
        //printArea.append();
        int rows=itemTable.getRowCount();
        
        String table="";
        
        for(int i=0;i<rows;i++)
        {
            table=table+itemTable.getValueAt(i, 7)+"               "+itemTable.getValueAt(i, 6)+"              "+itemTable.getValueAt(i, 5)+"              "+itemTable.getValueAt(i, 4)+"              "+itemTable.getValueAt(i, 3)+"              "+itemTable.getValueAt(i, 2)+"                "+itemTable.getValueAt(i, 1)+"            "+itemTable.getValueAt(i, 0)+";";
            
        }
        
        String approv=";;"+"له خوا چمتو شوی :"+preparedBy.getText()+"; "+"لخوا تاييد شوی :                "+"; "+"  کیټ مسول              :";
        
        
        finalPrint=finalPrint+header+serial+line+tableHeading+line+table+line+approv;
        printNow p=new printNow();
        header=header+table;
        printNow.printCard(finalPrint);
        
        
        
        
        
        
    }//GEN-LAST:event_printActionPerformed

    private void materialRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materialRadioActionPerformed
        // TODO add your handling code here:
        materialCombo.setEnabled(true);
        supplierCombo.disable();
        startDate.setEnabled(false);
        endDate.setEnabled(false);
        
    }//GEN-LAST:event_materialRadioActionPerformed

    private void dateRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateRadioActionPerformed
        // TODO add your handling code here:
        startDate.setEnabled(true);
        endDate.setEnabled(true);
        
        materialCombo.disable();
        supplierCombo.disable();
    }//GEN-LAST:event_dateRadioActionPerformed

    private void supplierRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierRadioActionPerformed
        // TODO add your handling code here:
        supplierCombo.setEnabled(true);
        
        startDate.setEnabled(false);
        endDate.setEnabled(false);
        materialCombo.disable();
        
        
    }//GEN-LAST:event_supplierRadioActionPerformed

    private void preparedByActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preparedByActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_preparedByActionPerformed

    private void supplierComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_supplierComboActionPerformed

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
            java.util.logging.Logger.getLogger(gateReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gateReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gateReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gateReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new gateReport().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(gateReport.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel GeneralInfo;
    private javax.swing.JButton Home;
    private javax.swing.JButton Logout;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton dateRadio;
    private com.toedter.calendar.JDateChooser endDate;
    private javax.swing.JTable itemTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JComboBox materialCombo;
    private javax.swing.JRadioButton materialRadio;
    private javax.swing.JTextField openingDate;
    private javax.swing.JTextField preparedBy;
    private javax.swing.JButton print;
    private javax.swing.JButton search;
    private com.toedter.calendar.JDateChooser startDate;
    private javax.swing.JComboBox supplierCombo;
    private javax.swing.JRadioButton supplierRadio;
    // End of variables declaration//GEN-END:variables
}
