/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qasproject;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tahab
 */
public class issueNote extends javax.swing.JFrame {

    /**
     * Creates new form issueNote
     */
    Connection conn=null;
    ArrayList <String> materials=new ArrayList();
    ArrayList <String> plants=new ArrayList();
    ArrayList <String> codes=new ArrayList();
    ArrayList <String> descriptions=new ArrayList();
    int availQty=0;
    
    DefaultTableModel dtm = new DefaultTableModel();
    
    
    public issueNote() throws SQLException {
        initComponents();
        this.setTitle("Issue Note");
        
        conn=DBconnection.connectDb();
        
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd ");
	LocalDateTime now = LocalDateTime.now();
        
        date.setText(dtf.format(now));
        
        int sNo=generateSerialNumber();
        serialNumber.setText(String.valueOf(sNo));
        
        populateMaterials();
        populatePlant();
        
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
            Logger.getLogger(GateInward.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private int generateSerialNumber() throws SQLException 
    {
        int sNo=0;
        Statement stmt;
        ResultSet rs= null;
        String serial="SELECT max(serialNumber) from issueNote";
        
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

    
    private void populatePlant() throws SQLException
    {
        Statement stmt;
        ResultSet rs= null;
        String getMaterial="SELECT distinct name from department";
        
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
             String plant=rs.getString(1);
             plants.add(plant);
             
         }
         
        DefaultComboBoxModel model2 = new DefaultComboBoxModel(plants.toArray());
        plantCombo.setModel( model2);
         
        
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

        jPanel1 = new javax.swing.JPanel();
        AddItems = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        itemQuantity = new javax.swing.JTextField();
        addItem = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        itemCodeCombo = new javax.swing.JComboBox();
        descriptionCombo = new javax.swing.JComboBox();
        materialCombo = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        unitText = new javax.swing.JTextField();
        qtyIndicator = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        UnitPrice = new javax.swing.JTextField();
        TotalPrice = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        itemTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        submit1 = new javax.swing.JButton();
        preparedBy = new javax.swing.JTextField();
        print = new javax.swing.JButton();
        GeneralInfo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        serialNumber = new javax.swing.JTextField();
        date = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        plantCombo = new javax.swing.JComboBox();
        Logout1 = new javax.swing.JButton();
        Home = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        AddItems.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setText("Description:");

        jLabel7.setText("Quantity:");

        itemQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemQuantityActionPerformed(evt);
            }
        });

        addItem.setText("Add Item");
        addItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemActionPerformed(evt);
            }
        });

        jLabel12.setText("Item Code:");

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

        materialCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        materialCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialComboActionPerformed(evt);
            }
        });

        jLabel4.setText("Material:");

        jLabel11.setText("Unit:");

        unitText.setEditable(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Unit Price / د واحد قیمت : ");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Total Price / ټول قیمت :  ");

        UnitPrice.setEditable(false);
        UnitPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UnitPriceActionPerformed(evt);
            }
        });

        TotalPrice.setEditable(false);
        TotalPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalPriceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AddItemsLayout = new javax.swing.GroupLayout(AddItems);
        AddItems.setLayout(AddItemsLayout);
        AddItemsLayout.setHorizontalGroup(
            AddItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddItemsLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(AddItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddItemsLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(159, 159, 159)
                        .addComponent(materialCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AddItemsLayout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(159, 159, 159)
                        .addComponent(itemCodeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AddItemsLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(159, 159, 159)
                        .addComponent(descriptionCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AddItemsLayout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(159, 159, 159)
                        .addComponent(unitText, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AddItemsLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(159, 159, 159)
                        .addComponent(itemQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AddItemsLayout.createSequentialGroup()
                        .addGroup(AddItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel9))
                        .addGap(102, 102, 102)
                        .addGroup(AddItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AddItemsLayout.createSequentialGroup()
                                .addGroup(AddItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(UnitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(213, 213, 213)
                                .addComponent(addItem, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(qtyIndicator, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(36, 36, 36))
        );
        AddItemsLayout.setVerticalGroup(
            AddItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddItemsLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(AddItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(AddItemsLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(materialCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(AddItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(AddItemsLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(itemCodeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addGroup(AddItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(AddItemsLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(descriptionCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addGroup(AddItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(AddItemsLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(unitText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addGroup(AddItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(AddItemsLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(itemQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addComponent(qtyIndicator, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AddItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UnitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AddItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addItem))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setText("Issued Items:");

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setText("Prepared by:");

        submit1.setText("Submit");
        submit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit1ActionPerformed(evt);
            }
        });

        preparedBy.setEditable(false);
        preparedBy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preparedByActionPerformed(evt);
            }
        });

        print.setText("Print");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(preparedBy, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(267, 267, 267)
                .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(submit1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(preparedBy, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(print)
                    .addComponent(submit1))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AddItems, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(AddItems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        GeneralInfo.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Serial Number:");

        jLabel2.setText("Date:");

        serialNumber.setEditable(false);
        serialNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serialNumberActionPerformed(evt);
            }
        });

        date.setEditable(false);

        jLabel6.setText("Plant:");

        plantCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        plantCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plantComboActionPerformed(evt);
            }
        });

        Logout1.setText("Log out");
        Logout1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Logout1ActionPerformed(evt);
            }
        });

        Home.setText("Home");
        Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout GeneralInfoLayout = new javax.swing.GroupLayout(GeneralInfo);
        GeneralInfo.setLayout(GeneralInfoLayout);
        GeneralInfoLayout.setHorizontalGroup(
            GeneralInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GeneralInfoLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(GeneralInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GeneralInfoLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(151, 151, 151)
                        .addComponent(plantCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(GeneralInfoLayout.createSequentialGroup()
                        .addGroup(GeneralInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(GeneralInfoLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(151, 151, 151)
                                .addComponent(serialNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(GeneralInfoLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(151, 151, 151)
                                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(GeneralInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Logout1, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(Home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        GeneralInfoLayout.setVerticalGroup(
            GeneralInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GeneralInfoLayout.createSequentialGroup()
                .addGroup(GeneralInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GeneralInfoLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(GeneralInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(GeneralInfoLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(serialNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GeneralInfoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Home)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(GeneralInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(GeneralInfoLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(GeneralInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Logout1))))
                .addGap(8, 8, 8)
                .addGroup(GeneralInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(GeneralInfoLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(plantCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(GeneralInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GeneralInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void serialNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serialNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_serialNumberActionPerformed

    private void materialComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materialComboActionPerformed
        // TODO add your handling code here:
        String selected=materialCombo.getSelectedItem().toString();
        try {
            populateCodeAndDescription(selected,null);
        } catch (SQLException ex) {
            Logger.getLogger(GateInward.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_materialComboActionPerformed

    private void addItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemActionPerformed
        // TODO add your handling code here:
        //itemTable=new JTable();

        String header[] = new String[] { "Material", "Item Code",
            "Description", "Quantity","Unit Cost", "Total Cost" };

        dtm.setColumnIdentifiers(header);
        itemTable.setModel(dtm);
        
        int enteredQty=Integer.parseInt(itemQuantity.getText().toString());
        if(enteredQty>availQty)
        {
            JOptionPane.showMessageDialog(null," Quantity greater that available quantity!");
        }
        else
        {
        Object[] row={materialCombo.getSelectedItem().toString(),itemCodeCombo.getSelectedItem().toString(),descriptionCombo.getSelectedItem().toString(),itemQuantity.getText(),UnitPrice.getText(),TotalPrice.getText()};

        dtm.addRow(row);
        }

    }//GEN-LAST:event_addItemActionPerformed

    private void itemCodeComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCodeComboActionPerformed
        // TODO add your handling code here:

        qtyIndicator.setText(" ");
        Statement stmt;
        ResultSet rs= null;

        String selected=itemCodeCombo.getSelectedItem().toString();
        String sql="SELECT I.itemDescription, S.itemQuantity, S.itemUnitPrice from ItemType AS I inner join stock AS S on I.itemBarcode=S.itemCode WHERE itemBarcode ='"+selected+"' ";
        String desc=null;
        int qty=0;
        int uPrice=0;
       
        
        try{
            stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);
            
            if(rs.next())
            {
                System.out.println("not null");
                desc=rs.getString(1);
                qty=rs.getInt(2);
                uPrice=rs.getInt(3);

            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());

        }

        if(desc!=null){
            descriptionCombo.setSelectedItem(desc);
            setUnit(selected);
            qtyIndicator.setText("Maximum available quantity is "+qty);
            availQty=qty;
            UnitPrice.setText(Integer.toString(uPrice));
            //descriptionCombo.disable();
        }
    }//GEN-LAST:event_itemCodeComboActionPerformed

    private void descriptionComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descriptionComboActionPerformed
        // TODO add your handling code here:
        qtyIndicator.setText(" ");
        Statement stmt;
        ResultSet rs= null;

        String selected=descriptionCombo.getSelectedItem().toString();
        //"SELECT I.itemDescription, S.itemQuantity from itemType AS I inner join stock AS S on I.itemBarcode=S.itemCode WHERE itemBarcode ='"+selected+"' ";
        String sql="SELECT I.itemBarcode , S.itemQuantity, S.itemUnitPrice from ItemType AS I inner join stock AS S on I.itemBarcode=S.itemCode WHERE I.itemDescription ='"+selected+"' ";
        String code=null;
        int qty=0;
        int uPrice=0;

        try{
            stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);
            
            if(rs.next())
            {
                System.out.println("not null");
                code=rs.getString(1);
                qty=rs.getInt(2);
                uPrice=rs.getInt(3);

            }
        

           if(code!=null){
            itemCodeCombo.setSelectedItem(code);
            setUnit(selected);
            qtyIndicator.setText("Maximum available quantity is "+qty);
            availQty=qty;
             UnitPrice.setText(Integer.toString(uPrice));
            //descriptionCombo.disable();
        }

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());

        }

        
        
    }//GEN-LAST:event_descriptionComboActionPerformed

    private void plantComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plantComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_plantComboActionPerformed

    private void submit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit1ActionPerformed
        // TODO add your handling code here:
        //PreparedStatement pst=null;

        Statement stmt;
        ResultSet rs= null;
        
        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        int sr=Integer.parseInt(serialNumber.getText());
        String plant=plantCombo.getSelectedItem().toString();

        //String supplier=supplierCombo.getSelectedItem().toString();
        //String material=materialCombo.getSelectedItem().toString();
        int rows=itemTable.getRowCount();

        PreparedStatement pstmt=null;

        String sql4="INSERT into issueNote values (default,?,?,?,?,?,?,?)" ;

        try {
            pstmt = conn.prepareStatement(sql4);
        } catch (SQLException ex) {
            Logger.getLogger(GateInward.class.getName()).log(Level.SEVERE, null, ex);
        }

        for(int row = 0; row<rows; row++)
        {
            //String material =(itemTable.getValueAt(row, 0)).toString();
            String itemCode =(itemTable.getValueAt(row, 1)).toString();
            int quantity =Integer.parseInt(itemTable.getValueAt(row, 3).toString());
            try {

                pstmt.setInt(1, sr);
                pstmt.setTimestamp(2, date);
                pstmt.setString(3,itemCode);
                pstmt.setInt(4,quantity);
                pstmt.setString(5,plant);
                pstmt.setString(6," "); //check these
                pstmt.setString(7,preparedBy.getText());

                pstmt.addBatch();
                
                String update;

                update="UPDATE stock  SET itemQuantity = itemQuantity - '"+quantity+"'  WHERE itemCode  = '"+itemCode+"'";

                    
                stmt=conn.createStatement();
                stmt.executeUpdate(update);
                    
                
                
            } catch (SQLException ex) {
                Logger.getLogger(GateInward.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        try {
            pstmt.executeBatch();
            //conn.commit();
            JOptionPane.showMessageDialog(null,"  Successfully Saved! ");

        } catch (SQLException ex) {
            Logger.getLogger(GateInward.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_submit1ActionPerformed

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

    private void UnitPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UnitPriceActionPerformed
        // TODO add your handling code here:
//        int uPrice=Integer.parseInt(UnitPrice.getText().toString());
//        int qty=Integer.parseInt(updateQuantity.getText().toString());
//
//        int tPrice=uPrice*qty;
//        TotalPrice.setText(Integer.toString(tPrice));
    }//GEN-LAST:event_UnitPriceActionPerformed

    private void TotalPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TotalPriceActionPerformed

    private void itemQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemQuantityActionPerformed
        // TODO add your handling code here:
        int qty=Integer.parseInt(itemQuantity.getText());
        int uPrice=Integer.parseInt(UnitPrice.getText());
        TotalPrice.setText(Integer.toString(qty*uPrice));
    }//GEN-LAST:event_itemQuantityActionPerformed

    private void preparedByActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preparedByActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_preparedByActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        // TODO add your handling code here:
        
        String finalPrint="";
        String header="                                                   Al Makkah Fiber/ الماکه فایبر ;;                                                      Issue Note/ مصرف پاڼه ;";
        String dateIssue=" تاربخ : "+date.getText()+";";
        String serial=" د سلسلې نمره: "+serialNumber.getText()+";";
        String plt="ماشین:"+plantCombo.getSelectedItem().toString()+";";       //String supplier="Supplier : "+supplierCombo.getSelectedItem().toString()+";";
        String line="; --------------------------------------------------------------------------------------------------------------------------------------;";
        String tableHeading=" مواد                 کوډ                   تفصیل              مقدار               د واحدقیمت              ټول لګښت ";
        
        
        //printArea.append();
        int rows=itemTable.getRowCount();
        
        String table="";
        
        for(int i=0;i<rows;i++)
        {
            table=table+itemTable.getValueAt(i, 5)+"                   "+itemTable.getValueAt(i, 4)+"                      "+itemTable.getValueAt(i, 3)+"                   "+itemTable.getValueAt(i, 2)+"                "+itemTable.getValueAt(i, 0)+"                  "+itemTable.getValueAt(i, 1)+";";
            
        }
        
        String approv=";;"+"له خوا چمتو شوی :"+preparedBy.getText()+"        "+"چیک کوونکی:                "+" نګران:                   " +"; "+"; "+"وصول کونکی"+"نوټ:                                       "; //+"  کیټ مسول              :"
        
        
        finalPrint=finalPrint+header+dateIssue+serial+plt+line+tableHeading+line+table+line+approv;
        printNow p=new printNow();
        header=header+table;
        printNow.printCard(finalPrint);
        
        
            //            Logger.getLogger(GateInward.class.getName()).log(Level.SEVERE, null, ex);
            //        }
    }//GEN-LAST:event_printActionPerformed

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
            java.util.logging.Logger.getLogger(issueNote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(issueNote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(issueNote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(issueNote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new issueNote().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(issueNote.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AddItems;
    private javax.swing.JPanel GeneralInfo;
    private javax.swing.JButton Home;
    private javax.swing.JButton Logout1;
    private javax.swing.JTextField TotalPrice;
    private javax.swing.JTextField UnitPrice;
    private javax.swing.JButton addItem;
    private javax.swing.JTextField date;
    private javax.swing.JComboBox descriptionCombo;
    private javax.swing.JComboBox itemCodeCombo;
    private javax.swing.JTextField itemQuantity;
    private javax.swing.JTable itemTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JComboBox materialCombo;
    private javax.swing.JComboBox plantCombo;
    private javax.swing.JTextField preparedBy;
    private javax.swing.JButton print;
    private javax.swing.JLabel qtyIndicator;
    private javax.swing.JTextField serialNumber;
    private javax.swing.JButton submit1;
    private javax.swing.JTextField unitText;
    // End of variables declaration//GEN-END:variables
}
