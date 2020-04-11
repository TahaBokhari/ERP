/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qasproject;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tahab
 */
public class gateOutward extends javax.swing.JFrame {

    /**
     * Creates new form GateInward
     */
    
    Connection conn=null;
    ArrayList <String> suppliers=new ArrayList();
    ArrayList <String> materials=new ArrayList();
    
    
    ArrayList <String> codes=new ArrayList();
    ArrayList <String> descriptions=new ArrayList();
    
    ArrayList <Integer> rolls;
    
    DefaultTableModel dtm = new DefaultTableModel();
    
    public gateOutward() throws SQLException {
        initComponents();
        this.setTitle("Gate Outward");
        
        conn=DBconnection.connectDb();
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	LocalDateTime now = LocalDateTime.now();
        
        date.setText(dtf.format(now));
        
        int sNo=generateSerialNumber();
        serialNumber.setText(String.valueOf(sNo));
        
        populateSuppliers();
        populateMaterials();
        rolls=new ArrayList();
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
    
    private int generateSerialNumber() throws SQLException 
    {
        int sNo=0;
        Statement stmt;
        ResultSet rs= null;
        String serial="SELECT max(serialNumber) from gateOutward";
        
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
    
    private void populateSuppliers() throws SQLException
    {
        Statement stmt;
        ResultSet rs= null;
        String getSupplier="SELECT distinct name from Customers";
        
        try{
         stmt=conn.createStatement();
         rs=stmt.executeQuery(getSupplier);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            
        }
         while(rs.next())
         {
             System.out.println("not null");
             String supplier=rs.getString(1);
             suppliers.add(supplier);
             
         }
         
//        if(suppliers.isEmpty())
//        {
//            
//        } 
        suppliers.add(" "); 
        DefaultComboBoxModel model2 = new DefaultComboBoxModel(suppliers.toArray());
        customerCombo.setModel( model2);
         
        
    }
    
    private void populateMaterials() throws SQLException
    {
        Statement stmt;
        ResultSet rs= null;
        String getMaterial="SELECT distinct materialName from Material";
        
        try{
         stmt=conn.createStatement();
         rs=stmt.executeQuery(getMaterial);
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
         
        DefaultComboBoxModel model2 = new DefaultComboBoxModel(materials.toArray());
        materialCombo.setModel( model2);
         
        
    }

    private void populateCodeAndDescription(String selectedMaterial, String sql) throws SQLException
    {
        codes.clear();
        descriptions.clear();
        
        Statement stmt;
        ResultSet rs= null;
        
        String sql1="SELECT itemBarcode,itemDescription from ItemType WHERE itemCategory='"+selectedMaterial+"' ";
        
        if(sql!=null)
        {
            sql1=sql;
        }
        
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
             
             codes.add(code);
             descriptions.add(desc);
             
         }
        
        //Collections.sort(codes);
        Collections.sort(descriptions);
         
        DefaultComboBoxModel model = new DefaultComboBoxModel(codes.toArray());
        itemCodeCombo.setModel( model);
        
        DefaultComboBoxModel model2 = new DefaultComboBoxModel(descriptions.toArray());
        descriptionCombo.setModel( model2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonGroup2 = new javax.swing.ButtonGroup();
        GeneralInfo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        customerCombo = new javax.swing.JComboBox();
        serialNumber = new javax.swing.JTextField();
        date = new javax.swing.JTextField();
        materialCombo = new javax.swing.JComboBox();
        Logout = new javax.swing.JButton();
        Home = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        driverNumber = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        driverName = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        vehicleNumber = new javax.swing.JTextField();
        AddItems = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        addItem = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        itemCodeCombo = new javax.swing.JComboBox();
        descriptionCombo = new javax.swing.JComboBox();
        unitText = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        weight = new javax.swing.JTextField();
        roleBaleNumber = new javax.swing.JComboBox();
        itemsPanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        itemTable = new javax.swing.JTable();
        deleteRow = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        submit = new javax.swing.JButton();
        print = new javax.swing.JButton();
        preparedBy = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        GeneralInfo.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Serial Number / د سلسلې نمره :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Date / نیټه:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Customer :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Material / مواد:");

        customerCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        customerCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerComboActionPerformed(evt);
            }
        });

        serialNumber.setEditable(false);
        serialNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serialNumberActionPerformed(evt);
            }
        });

        date.setEditable(false);

        materialCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        materialCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialComboActionPerformed(evt);
            }
        });

        Logout.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Logout.setText("Log out / وتل");
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });

        Home.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Home.setText("Home / کور");
        Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Driver Name :");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Driver Phone Number :");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Vehicle Number :");

        javax.swing.GroupLayout GeneralInfoLayout = new javax.swing.GroupLayout(GeneralInfo);
        GeneralInfo.setLayout(GeneralInfoLayout);
        GeneralInfoLayout.setHorizontalGroup(
            GeneralInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GeneralInfoLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(GeneralInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(GeneralInfoLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(64, 64, 64)
                        .addComponent(serialNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(175, 175, 175)
                        .addComponent(Logout))
                    .addGroup(GeneralInfoLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(164, 164, 164)
                        .addGroup(GeneralInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(customerCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(175, 175, 175)
                        .addComponent(Home, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(GeneralInfoLayout.createSequentialGroup()
                        .addGroup(GeneralInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(122, 122, 122)
                        .addGroup(GeneralInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(vehicleNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(materialCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(driverNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(GeneralInfoLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(179, 179, 179)
                        .addComponent(driverName, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        GeneralInfoLayout.setVerticalGroup(
            GeneralInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GeneralInfoLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(GeneralInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(GeneralInfoLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(serialNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Logout))
                .addGap(13, 13, 13)
                .addGroup(GeneralInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(GeneralInfoLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Home))
                .addGroup(GeneralInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GeneralInfoLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(GeneralInfoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(customerCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(GeneralInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GeneralInfoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(GeneralInfoLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(driverName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(driverNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(GeneralInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GeneralInfoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(vehicleNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(GeneralInfoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(GeneralInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(materialCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        AddItems.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Description / توضيح:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Unit / د اندازه کولو واحد:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Roll/ Bale Number:");

        addItem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addItem.setText("Add Item/ توکي اضافه کړئ");
        addItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Item Code / د توکي کوډ : ");

        itemCodeCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        itemCodeCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCodeComboActionPerformed(evt);
            }
        });

        descriptionCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        descriptionCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descriptionComboActionPerformed(evt);
            }
        });

        unitText.setEditable(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Weight/ size :");

        roleBaleNumber.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        roleBaleNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roleBaleNumberActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AddItemsLayout = new javax.swing.GroupLayout(AddItems);
        AddItems.setLayout(AddItemsLayout);
        AddItemsLayout.setHorizontalGroup(
            AddItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddItemsLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(AddItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(AddItemsLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(103, 103, 103)
                        .addComponent(itemCodeCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(AddItemsLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(137, 137, 137)
                        .addComponent(descriptionCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(AddItemsLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(119, 119, 119)
                        .addComponent(unitText, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AddItemsLayout.createSequentialGroup()
                        .addGroup(AddItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(137, 137, 137)
                        .addGroup(AddItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(weight, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(roleBaleNumber, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(355, 371, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddItemsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addItem, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        AddItemsLayout.setVerticalGroup(
            AddItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddItemsLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(AddItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(AddItemsLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(itemCodeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addGroup(AddItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(AddItemsLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(descriptionCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(AddItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddItemsLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(unitText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(AddItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddItemsLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 5, Short.MAX_VALUE))
                    .addGroup(AddItemsLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(roleBaleNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(AddItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addItem)
                            .addComponent(weight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        itemsPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setText("Items:");

        itemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(itemTable);

        deleteRow.setText("Delete Row");
        deleteRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteRowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout itemsPanelLayout = new javax.swing.GroupLayout(itemsPanel);
        itemsPanel.setLayout(itemsPanelLayout);
        itemsPanelLayout.setHorizontalGroup(
            itemsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itemsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(itemsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(itemsPanelLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, itemsPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(deleteRow, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        itemsPanelLayout.setVerticalGroup(
            itemsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, itemsPanelLayout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteRow)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setText("Prepared by:");

        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(preparedBy, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(247, 247, 247)
                .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(preparedBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(print)
                            .addComponent(submit))))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(itemsPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AddItems, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(GeneralInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GeneralInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AddItems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(itemsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemActionPerformed
        // TODO add your handling code here:
        //itemTable=new JTable();
        
        
        String header[] = new String[] { "Customer", "Material", "Item Code",
      "Description", "Unit", "Roll/Bale","Weight/Size"};
        
        dtm.setColumnIdentifiers(header);
        itemTable.setModel(dtm);
        
        Object[] row={customerCombo.getSelectedItem().toString(),materialCombo.getSelectedItem().toString(),itemCodeCombo.getSelectedItem().toString(),descriptionCombo.getSelectedItem().toString(),unitText.getText(),roleBaleNumber.getSelectedItem(),weight.getText()};
        
        
        dtm.addRow(row);
        
        
        
    }//GEN-LAST:event_addItemActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        // TODO add your handling code here:
        //PreparedStatement pst=null;
        
        Statement st=null;
        ResultSet rs=null;
        
        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        int sr=Integer.parseInt(serialNumber.getText());
        
        //String supplier=supplierCombo.getSelectedItem().toString();
        //String material=materialCombo.getSelectedItem().toString();
        int rows=itemTable.getRowCount();
        
        PreparedStatement pstmt=null;
        
        String sql4="INSERT into gateOutward values (default,?,?,?,?,?,?,?,?,?,?,?)" ; //setting status no in fiber and carpet
        
        try {
            pstmt = conn.prepareStatement(sql4);
        } catch (SQLException ex) {
            Logger.getLogger(gateOutward.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        for(int row = 0; row<rows; row++)
            {
                System.out.println(itemTable.getValueAt(row, 0).toString());
                
                String customer =(itemTable.getValueAt(row, 0)).toString();//                    (String)tblCO2.getValueAt(row, 0);
                String material =(itemTable.getValueAt(row, 1)).toString();
                //String purc=(itemTable.getValueAt(row, 2)).toString();
                String itemCode =(itemTable.getValueAt(row, 2)).toString();
                int rollOrBale =Integer.parseInt(itemTable.getValueAt(row, 5).toString());
                int wOrs =Integer.parseInt(itemTable.getValueAt(row, 6).toString());
                
            try {
                
                    pstmt.setInt(1, sr);
                    pstmt.setTimestamp(2, date);
                    pstmt.setString(3,customer);
                    pstmt.setString(4,driverName.getText().toString());
                    pstmt.setString(5,driverNumber.getText().toString());
                    pstmt.setString(6,vehicleNumber.getText().toString());
                    
                    pstmt.setString(7,material);
                    //pstmt.setString(8,material);
                    pstmt.setString(8,itemCode);
                    pstmt.setInt(9,rollOrBale);
                    pstmt.setInt(10,wOrs);//unitPrice
                    //pstmt.setInt(9,0);//totalPrice
                    pstmt.setString(11,preparedBy.getText());
//                    pstmt.setInt(11,0);
//                    pstmt.setString(12,"No");
//                    pstmt.setNull(13, Types.NULL);
//                    
                     pstmt.addBatch();
                     
                     String statusUpdate=null;
                     String status="OUT";
                     
                     if(material.equals("مالوچ"))
                     {
                         statusUpdate="Update fiberStock set stockStatus='"+status+"' Where itemCode='"+itemCode+"' and  baleNumber='"+rollOrBale+"'";
                     }
                     else if(material.equals("کارپیټ"))
                     {
                         statusUpdate="Update carpetStock set stockStatus='"+status+"' Where itemCode='"+itemCode+"' and  rollNumber='"+rollOrBale+"'";
                     }
                     
                     st=conn.createStatement();
                     rs=st.executeQuery(statusUpdate);
                     
                     
                     
                     
            } catch (SQLException ex) {
                     Logger.getLogger(gateOutward.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            
            
            }
                
        try {
           pstmt.executeBatch();
            //conn.commit();
            JOptionPane.showMessageDialog(null,"  Successfully Saved! ");
            gateOutward obj= new gateOutward();
            obj.setVisible(true);
            this.dispose();

         
        } catch (SQLException ex) {
            Logger.getLogger(gateOutward.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_submitActionPerformed

    private void serialNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serialNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_serialNumberActionPerformed

    private void materialComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materialComboActionPerformed
        // TODO add your handling code here:
        String selected=materialCombo.getSelectedItem().toString();
        try {
            populateCodeAndDescription(selected,null);
        } catch (SQLException ex) {
            Logger.getLogger(gateOutward.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_materialComboActionPerformed

    private void setUnit(String code)
    {
        Statement stmt;
        ResultSet rs= null;
        String sql="SELECT itemUnit from ItemType WHERE itemBarcode ='"+code+"' ";
        String unit=null;
        
        try{
         stmt=conn.createStatement();
         rs=stmt.executeQuery(sql);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            
        }
        
        try {
            while(rs.next())
            {
                System.out.println("not null");
                unit=rs.getString(1);
                unitText.setText(unit);
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(gateOutward.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void itemCodeComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCodeComboActionPerformed
        // TODO add your handling code here:
        
        String mat=materialCombo.getSelectedItem().toString();
        
        Statement stmt;
        ResultSet rs= null;
        
        String selected=itemCodeCombo.getSelectedItem().toString();
        String sql="SELECT itemDescription from ItemType WHERE itemBarcode ='"+selected+"' ";
        String desc=null;
        
        try{
         stmt=conn.createStatement();
         rs=stmt.executeQuery(sql);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            
        }
        
        try {
            while(rs.next())
            {
                System.out.println("not null");
                desc=rs.getString(1);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(gateOutward.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        String status="IN";
        Statement stmt2;
        ResultSet rs2= null;
        String sql2=null;
        
        if(mat.equals("مالوچ"))
        {
            sql2="SELECT baleNumber from fiberStock WHERE stockStatus='"+status+"' And itemCode='"+selected+"'";
        }
        else if(mat.equals("کارپیټ"))
        {
             sql2="SELECT rollNumber from carpetStock WHERE stockStatus='"+status+"' And itemCode='"+selected+"'";
        }
        
        //String selected=itemCodeCombo.getSelectedItem().toString();
        //String sql="SELECT itemDescription from ItemType WHERE itemBarcode ='"+selected+"' ";
        //String desc=null;
        int rol=0;
        
        try{
         stmt2=conn.createStatement();
         rs2=stmt2.executeQuery(sql2);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            
        }
        
        try {
            while(rs2.next())
            {
                //rs2.beforeFirst();
                System.out.println("not nullpp");
                rol=rs2.getInt(1);
                rolls.add(rol);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(gateOutward.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        if(desc!=null){
        descriptionCombo.setSelectedItem(desc);
        setUnit(selected);
        
        DefaultComboBoxModel model4 = new DefaultComboBoxModel(rolls.toArray());
        roleBaleNumber.setModel( model4);
        
        //roleBaleNumber.set
        //descriptionCombo.disable();
        }
    }//GEN-LAST:event_itemCodeComboActionPerformed

    private void descriptionComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descriptionComboActionPerformed
        // TODO add your handling code here:
        Statement stmt;
        ResultSet rs= null;
        
        String selected=descriptionCombo.getSelectedItem().toString();
        String sql="SELECT itemBarcode from ItemType WHERE itemDescription ='"+selected+"' ";
        String code=null;
        
        try{
         stmt=conn.createStatement();
         rs=stmt.executeQuery(sql);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            
        }
        
        try {
            while(rs.next())
            {
                System.out.println("not null");
                code=rs.getString(1);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(gateOutward.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(code!=null){
        itemCodeCombo.setSelectedItem(code);
        setUnit(selected);
        //descriptionCombo.disable();
        }
        
    }//GEN-LAST:event_descriptionComboActionPerformed

    private void customerComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerComboActionPerformed

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

    private void deleteRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteRowActionPerformed
        // TODO add your handling code here:
        int row=itemTable.getSelectedRow();
        DefaultTableModel model= (DefaultTableModel)itemTable.getModel();

        int opt=JOptionPane.showConfirmDialog(null,"Do you want to Delete?","Delete", JOptionPane.YES_NO_OPTION);
        if(row>=0)
        {
            if(opt==0)
            {
                model.removeRow(row);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null," Please select a row");
        }
    }//GEN-LAST:event_deleteRowActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        // TODO add your handling code here:
        String finalPrint="";
        String header="                                              Al Makkah Fiber ;;                                                 Gate Inward ;";
        String serial="Serial Number : "+serialNumber.getText()+";";
        String supplier="Supplier : "+customerCombo.getSelectedItem().toString()+";";
        String line="; --------------------------------------------------------------------------------------------------------------------------------;";
        String tableHeading="Material          Item Code          Description          Unit          Quantity";
        
        
        //printArea.append();
        int rows=itemTable.getRowCount();
        
        String table="";
        
        for(int i=0;i<rows;i++)
        {
            table=table+ itemTable.getValueAt(i, 1)+"            "+itemTable.getValueAt(i, 2)+"               "+itemTable.getValueAt(i, 3)+"              "+itemTable.getValueAt(i, 4)+"            "+itemTable.getValueAt(i, 5)+";";
            
        }
        
        String approv=";;"+"Prepared By :"+preparedBy.getText()+"; "+"Approved By :";
        
        
        finalPrint=finalPrint+header+serial+supplier+line+tableHeading+line+table+line+approv;
        printNow p=new printNow();
        header=header+table;
        printNow.printCard(finalPrint);
        
        
        System.out.println(itemTable.getRowCount());
//        String str="AL MAKKAH FIBER \n baba";
//        MessageFormat header=new MessageFormat(str+ "Serial N:"+serialNumber.getText()); 
//        MessageFormat footer=new MessageFormat("hello"); 
//        String a="dd";
//        
//        try {
//            //GateInward.p
//            //serialNumber.print();
//            //itemsPanel.print(null);
//            //itemTable.get
//            //itemTable.print(JTable.PrintMode.NORMAL, header, footer);
//        } catch (PrinterException ex) {
//            Logger.getLogger(GateInward.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_printActionPerformed

    private void preparedByActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preparedByActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_preparedByActionPerformed

    private void roleBaleNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roleBaleNumberActionPerformed
        // TODO add your handling code here:
        String mat=materialCombo.getSelectedItem().toString();
        String code=itemCodeCombo.getSelectedItem().toString();
        int baleNum=Integer.parseInt(roleBaleNumber.getSelectedItem().toString());
        String sql2=null;
        
        if(mat.equals("مالوچ"))
        {
            sql2="SELECT  weight from fiberStock WHERE itemCode='"+code+"' and baleNumber='"+baleNum+"' ";
        }
        else if(mat.equals("کارپیټ"))
        {
             sql2="SELECT rollNumber from carpetStock WHERE itemCode='"+code+"' and rollNumber='"+baleNum+"'";
        }
        
    }//GEN-LAST:event_roleBaleNumberActionPerformed

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
            java.util.logging.Logger.getLogger(gateOutward.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gateOutward.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gateOutward.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gateOutward.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new gateOutward().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(gateOutward.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AddItems;
    private javax.swing.JPanel GeneralInfo;
    private javax.swing.JButton Home;
    private javax.swing.JButton Logout;
    private javax.swing.JButton addItem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox customerCombo;
    private javax.swing.JTextField date;
    private javax.swing.JButton deleteRow;
    private javax.swing.JComboBox descriptionCombo;
    private javax.swing.JTextField driverName;
    private javax.swing.JTextField driverNumber;
    private javax.swing.JComboBox itemCodeCombo;
    private javax.swing.JTable itemTable;
    private javax.swing.JPanel itemsPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox materialCombo;
    private javax.swing.JTextField preparedBy;
    private javax.swing.JButton print;
    private javax.swing.JComboBox roleBaleNumber;
    private javax.swing.JTextField serialNumber;
    private javax.swing.JButton submit;
    private javax.swing.JTextField unitText;
    private javax.swing.JTextField vehicleNumber;
    private javax.swing.JTextField weight;
    // End of variables declaration//GEN-END:variables
}
