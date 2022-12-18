/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory_system;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafp.Login;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author student.admin
 */
public final class cashiering extends javax.swing.JFrame {

    /**
     * Creates new form cashiering
     */

    public cashiering() {
        
        initComponents();
        Connect();
        display();
         DisplayData();
//        getUsernameandID();
        showDate();
        showTime();
    }
public cashiering(String first){
    initComponents();
    jLabel12.setText(first);
    display();
         DisplayData();

        showDate();
        showTime();
}
    Connection con;
    PreparedStatement pst;
    PreparedStatement pst1;
    ResultSet rs;
  

    
    
    
    
    public void DisplayData() {

         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chic", "root", "");

            Statement st = conn.createStatement();
            String sql = "SELECT * FROM cart";
            ResultSet rs = st.executeQuery(sql);
            DefaultTableModel tbl = (DefaultTableModel) jTable1.getModel();
            while (tbl.getRowCount() > 0) {
                tbl.removeRow(0);
            }
            while (rs.next()) {

                String cart_id = rs.getString("cart_id");
                String name = rs.getString("name");
                String productname = rs.getString("productname");
                String quantity = rs.getString("quantity");
                String price = rs.getString("price");
                String date = rs.getString("date");

                String tbData[] = {cart_id, name, productname, quantity, price,date};
                tbl.addRow(tbData);

            }

        } catch (ClassNotFoundException | SQLException e) {

        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//    public void getUsernameandID() {
//
//        PreparedStatement st;
//        ResultSet rst;
//
//        String query = "SELECT * FROM users WHERE username='" + Login.txtusername.getText() + "'";
//
//        try {
//            st = DBconnection.getConnection().prepareStatement(query);
//            rst = st.executeQuery();
//
//            if (rst.next()) {
//                user.setText(rst.getString(1));
//                jLabel12.setText(rst.getString(4));
//
//            }
//        } catch (SQLException e) {
//        }
//    }

    public void Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/chic", "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(HOME.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//      

    public void getinvID() {

        PreparedStatement st;
        ResultSet rslt;

        String query = "SELECT MAX(InventoryID) FROM products;";

        try {
            st = DBconnection.getConnection().prepareStatement(query);
            rslt = st.executeQuery();

//            if (rs.next()) {
//                id1.setText(rs.getString(1));
//
//            }
        } catch (SQLException e) {
        }
    }

    public void display() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chic", "root", "");

            Statement st = conn.createStatement();
            String sql = "SELECT * FROM inventory";
            ResultSet rs = st.executeQuery(sql);
            DefaultTableModel tbl = (DefaultTableModel) table2.getModel();
            while (tbl.getRowCount() > 0) {
                tbl.removeRow(0);
            }
            while (rs.next()) {

                String inventory_id = rs.getString("inventory_id");
                String productname = rs.getString("productname");
                String category = rs.getString("category");
                String price = rs.getString("price");
                String quantity = rs.getString("quantity");

                String tbData[] = {inventory_id, productname, category, price, quantity};
                tbl.addRow(tbData);

            }

        } catch (ClassNotFoundException | SQLException e) {

        }
    }

    public void showDate() {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        String dat = s.format(d);
        date.setText(dat);

    }

    public void showTime() {
        new Timer(0, new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                Date d = new Date();
                SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss");
                String tim = s.format(d);
                time.setText(tim);

            }

        }).start();

    }






    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        subtotal = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        user = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        date = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pay = new javax.swing.JTextField();
        change = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        ID = new javax.swing.JTextField();
        qty = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        item = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setBackground(new java.awt.Color(153, 102, 0));
        jLabel1.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Cashiering");

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setForeground(new java.awt.Color(255, 102, 102));
        jButton3.setText("Remove from cart");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(0, 0, 0));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButton6.setForeground(new java.awt.Color(153, 0, 0));
        jButton6.setText("Log out");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        subtotal.setText("0");
        subtotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                subtotalKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                subtotalKeyReleased(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(184, 128, 71));
        jLabel12.setText("Username");

        user.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        user.setForeground(new java.awt.Color(184, 128, 71));
        user.setText("ID");

        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setForeground(new java.awt.Color(255, 102, 102));
        jButton4.setText("Add to Cart");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        date.setBackground(new java.awt.Color(255, 161, 128));
        date.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        date.setForeground(new java.awt.Color(184, 128, 71));
        date.setText("DATE");

        time.setBackground(new java.awt.Color(255, 161, 128));
        time.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        time.setForeground(new java.awt.Color(184, 128, 71));
        time.setText("TIME");

        jLabel6.setBackground(new java.awt.Color(255, 161, 128));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(184, 128, 71));
        jLabel6.setText("Total:");

        pay.setText("0");

        change.setText("0");

        jLabel8.setBackground(new java.awt.Color(255, 161, 128));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(184, 128, 71));
        jLabel8.setText("Change:");

        jLabel3.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 127, 123));
        jLabel3.setText("prod");

        jLabel11.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 127, 123));
        jLabel11.setText("quantity");

        jLabel13.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 127, 123));
        jLabel13.setText("price");

        jButton9.setBackground(new java.awt.Color(0, 0, 0));
        jButton9.setForeground(new java.awt.Color(255, 102, 102));
        jButton9.setText("Pay");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 127, 123));
        jLabel4.setText("invent_ID");

        jButton7.setBackground(new java.awt.Color(0, 0, 0));
        jButton7.setForeground(new java.awt.Color(255, 102, 102));
        jButton7.setText("Refresh");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(0, 0, 0));
        jButton11.setForeground(new java.awt.Color(255, 102, 102));
        jButton11.setText("Home");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "inventory_id", "productname", "category", "price", "quantity"
            }
        ));
        table2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table2MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(table2);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "cart_id", "name", "productname", "quantity", "price", "date"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable1);

        jLabel2.setForeground(new java.awt.Color(184, 128, 71));
        jLabel2.setText("....");

        item.setForeground(new java.awt.Color(184, 128, 71));
        item.setText("....");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40)
                                        .addComponent(jLabel3)
                                        .addGap(39, 39, 39)
                                        .addComponent(item, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(89, 89, 89)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(161, 161, 161)
                                                .addComponent(jLabel13))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(qty, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(38, 38, 38)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 987, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 991, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(95, 95, 95)
                                            .addComponent(jButton9)
                                            .addGap(29, 29, 29)
                                            .addComponent(pay, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(125, 125, 125)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(change, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(38, 38, 38)
                                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jButton11)
                                            .addGap(18, 18, 18)
                                            .addComponent(jButton6)))))
                            .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(515, 515, 515)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112)
                        .addComponent(jButton3))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(user, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addComponent(jLabel12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(date)
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(time)
                            .addComponent(jLabel1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel13)
                    .addComponent(qty, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(item, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(change, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(pay, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try{
           
            
              Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chic", "root", "");
             Statement stmt = conn.createStatement();
            
            
             
            
            String productname = item.getText();
            String quantity = qty.getText();
            String total = jLabel2.getText();
            String name = jLabel12.getText();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM");
            SimpleDateFormat d = new SimpleDateFormat("hh:mm a");
            Date dateobj = new Date();
            String timee = d.format(dateobj.getTime());
            String today = sdf.format(dateobj.getTime());
            String date = today + " " + timee;
            
            
           
            
            
             String query = "INSERT INTO cart (name,productname,quantity, price, date)"
                    + "values('" + name + "','"
                    + productname + "','" + quantity + "','" + total + "','" + date +"')";

            int x = stmt.executeUpdate(query);
            if (x == 0) {
                JOptionPane.showMessageDialog(null, " ADDED TO CART!");
              
            }

            
            JOptionPane.showMessageDialog(this, "Added Successfully!");
        }catch(Exception e){
            e.printStackTrace();
        }



    }//GEN-LAST:event_jButton4ActionPerformed


    public void insertTransaction() {
        int row = jTable1.getSelectedRow();

        String inventID = jTable1.getValueAt(row, 0).toString();
        String pro = jTable1.getValueAt(row, 1).toString();
        String quant = jTable1.getValueAt(row, 2).toString();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM");
        SimpleDateFormat d = new SimpleDateFormat("hh:mm a");
        Date dateobj = new Date();
        String time = d.format(dateobj.getTime());
        String today = sdf.format(dateobj.getTime());
        String date = today;
        String user_id = user.getText();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "");
            PreparedStatement pst = conn.prepareStatement("INSERT INTO `ctransaction`( `inventoryID`, `quantity`, `total`, `UID`, `date`, `time`) VALUES (?,?,?,?,?,?)");
            pst.setInt(1, Integer.parseInt(inventID));
            pst.setInt(2, Integer.parseInt(quant));
            pst.setInt(3, Integer.parseInt(subtotal.getText()));
            pst.setInt(4, Integer.parseInt(user_id));
            pst.setString(5, date);
            pst.setString(6, time);

            pst.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }

    }

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
           int x = JOptionPane.showConfirmDialog(this,"Are you sure you want to log out?");
        if(x==0){
            JOptionPane.showMessageDialog(this, "Thank you!");
            Login h = new Login();
            h.show();
            dispose();
        }
       
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (ID.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Select a USER to be deleted!");

        } else {
            try {
                String id1 = ID.getText();
                String query1 = "DELETE FROM cart WHERE  cart_id=" + id1;
                PreparedStatement ps = DBconnection.getConnection().prepareStatement(query1);
                ps.executeUpdate(query1);
                JOptionPane.showMessageDialog(this, "SUCCESSFULLY DELETED!");
                item.setText("");
                ID.setText("");
                qty.setText("");
                jLabel2.setText("");

            } catch (SQLException ex) {
                Logger.getLogger(cashiering.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        int t = Integer.valueOf(subtotal.getText());
        int c = Integer.valueOf(pay.getText());
        int cas = c - t;
        change.setText(Integer.toString(cas));
    }//GEN-LAST:event_jButton9ActionPerformed

    private void subtotalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_subtotalKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_subtotalKeyPressed

    private void subtotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_subtotalKeyReleased
//       getResult();
    }//GEN-LAST:event_subtotalKeyReleased

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
DisplayData();
display();
        
        
        ID.setText("");
        item.setText("");
        qty.setText("");
        jLabel2.setText("");
        subtotal.setText("");
        pay.setText("");
        change.setText("");
  


    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        new admin_dashboard().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void table2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table2MouseClicked
          DefaultTableModel tblModel = (DefaultTableModel) table2.getModel();

        String tblid = tblModel.getValueAt(table2.getSelectedRow(), 0).toString();
        String tblname = tblModel.getValueAt(table2.getSelectedRow(), 1).toString();
        String tblca = tblModel.getValueAt(table2.getSelectedRow(), 3).toString();
        String tblq = tblModel.getValueAt(table2.getSelectedRow(), 4).toString();
        
        ID.setText(tblid);
        item.setText(tblname);
        qty.setText(tblq);
        jLabel2.setText(tblca);
    }//GEN-LAST:event_table2MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
         DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();

        String tblid = tblModel.getValueAt(jTable1.getSelectedRow(), 0).toString();
        String tblname = tblModel.getValueAt(jTable1.getSelectedRow(), 2).toString();
        String tblca = tblModel.getValueAt(jTable1.getSelectedRow(), 3).toString();
        String tblq = tblModel.getValueAt(jTable1.getSelectedRow(), 4).toString();
        
        ID.setText(tblid);
        item.setText(tblname);
        qty.setText(tblca);
        jLabel2.setText(tblq);
    }//GEN-LAST:event_jTable1MouseClicked

    public void AddRowToJtable(Object[] dataRow) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(dataRow);
    }

 
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
            java.util.logging.Logger.getLogger(cashiering.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cashiering.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cashiering.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cashiering.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cashiering().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ID;
    private javax.swing.JTextField change;
    private javax.swing.JLabel date;
    private javax.swing.JLabel item;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField pay;
    private javax.swing.JTextField qty;
    private javax.swing.JTextField subtotal;
    private javax.swing.JTable table2;
    private javax.swing.JLabel time;
    public javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables
}
