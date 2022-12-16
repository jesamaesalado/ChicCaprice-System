/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory_system;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.io.FileWriter;
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
    String quantity, id, product;

    public cashiering() {
        initComponents();
        Connect();
        display();
        getUsernameandID();
        showDate();
        showTime();
    }

    Connection con;
    PreparedStatement pst;
    PreparedStatement pst1;
    ResultSet rs;
    DefaultTableModel df;

    public void getUsernameandID() {

        PreparedStatement st;
        ResultSet rst;

        String query = "SELECT * FROM users WHERE username='" + Login.username.getText() + "'";

        try {
            st = DBconnection.getConnection().prepareStatement(query);
            rst = st.executeQuery();

            if (rst.next()) {
                user.setText(rst.getString(1));
                jLabel12.setText(rst.getString(4));

            }
        } catch (SQLException e) {
        }
    }

    public void Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/users", "root", "");
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
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "");

            Statement st = conn.createStatement();
            String sql = "SELECT * FROM products";
            ResultSet rst = st.executeQuery(sql);
            DefaultTableModel tbl = (DefaultTableModel) jTable2.getModel();
            while (tbl.getRowCount() > 0) {
                tbl.removeRow(0);
            }
            while (rst.next()) {

                int inventory_id = rst.getInt(1);
                String product_name = rst.getString(2);
                String category1 = rst.getString(3);
                int price1 = rst.getInt(5);
                String stock_quantity = rst.getString(6);
                String pubdate1 = rst.getString(9);

                Object tbData[] = {inventory_id, product_name, category1, price1, stock_quantity, pubdate1};

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

    public void CashTrans() {
        try {

            getinvID();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "");
            PreparedStatement ps = conn.prepareStatement("insert into cashiertransactions (inventoryID, productname, quantity, total, UserID, date, time ) values (?,?,?,?,?,?,?");
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("select * from products_sold");

            Statement stm = con.createStatement();

            String inventory_id = ID.getText();
            String productname = item.getText();
            String quantityy = qty.getText();
            String total = subtotal.getText();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM");
            SimpleDateFormat d = new SimpleDateFormat("hh:mm a");
            Date dateobj = new Date();
            String timee = d.format(dateobj.getTime());
            String today = sdf.format(dateobj.getTime());
            String datee = today + " " + timee;
            String user_id = user.getText();

//            String type = "ADD";
            String query = "INSERT INTO cashiertransactions (inventoryID,productname, quantity, total, UserID, date, time)"
                    + "values('" + inventory_id + "', '" + productname + "','"
                    + quantityy + "','" + total + "','" + user_id + "','" + datee + "','" + timee + "')";

//             String query = "INSERT INTO products ( bookname, category,quantity,price)
//                    values('" + bookname + "','"+ category1 +"','"+ quantity +"','"+ price +"')";
            int x = stm.executeUpdate(query);
            if (x == 0) {
//                JOptionPane.showMessageDialog(null, "INVENTORY ADDED!");
            } else {
                JOptionPane.showMessageDialog(null,
                        "YOU ARE ABOUT TO ADD A PRODUCT!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }

    public void getResult() {
        try {
            float total = Float.valueOf(subtotal.getText());
            float payy = Float.valueOf(pay.getText());
            float result = total - payy;
            String data = String.valueOf(result);
            change.setText(data);

        } catch (Exception e) {

        }
    }

    private void salesSTOCK() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/users", "root", "");
            pst = con.prepareStatement("select * from products where InventoryID=?");

            while (rs.next()) {
                int currentquanti;
                currentquanti = rs.getInt("StockQuantity");

                int newquanty = Integer.parseInt(jButton5.getText());

                if (newquanty >= currentquanti) {
                    JOptionPane.showMessageDialog(this, "Available Products" + " =" + currentquanti);
                    JOptionPane.showMessageDialog(this, "Quantity is not enough!!");
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(cashiering.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(cashiering.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        subtotal = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        user = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        date = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        pay = new javax.swing.JTextField();
        change = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        ID = new javax.swing.JTextField();
        qty = new javax.swing.JTextField();
        price = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        receipt = new javax.swing.JTextArea();
        item = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setBackground(new java.awt.Color(153, 102, 0));
        jLabel1.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Cashiering");

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setForeground(new java.awt.Color(255, 102, 102));
        jButton2.setText("New");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

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

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "inventory_id", "product_name", "category", "price", "quantity", "published_date"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);

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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "InventoryID", "ProductName", "Quantity", "Price"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton5.setBackground(new java.awt.Color(0, 0, 0));
        jButton5.setForeground(new java.awt.Color(255, 102, 102));
        jButton5.setText("Quantity");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

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

        jButton10.setBackground(new java.awt.Color(0, 0, 0));
        jButton10.setForeground(new java.awt.Color(255, 102, 102));
        jButton10.setText("Print Receipt");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        receipt.setColumns(20);
        receipt.setRows(5);
        receipt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                receiptKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(receipt);

        jLabel4.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 127, 123));
        jLabel4.setText("invent_ID");

        jButton7.setBackground(new java.awt.Color(0, 0, 0));
        jButton7.setForeground(new java.awt.Color(255, 102, 102));
        jButton7.setText("Reset");
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(130, 130, 130)
                                .addComponent(jButton3)
                                .addGap(182, 182, 182)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(78, 78, 78))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1034, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel12)
                                        .addComponent(user)
                                        .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1034, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(95, 95, 95)
                                .addComponent(jButton9)
                                .addGap(29, 29, 29)
                                .addComponent(pay, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(125, 125, 125)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(change, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(95, 95, 95)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(item)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(qty, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton11)
                                .addGap(18, 18, 18)
                                .addComponent(jButton6)
                                .addGap(53, 53, 53))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(223, 223, 223)
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(148, 148, 148))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(date)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(time)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)
                        .addComponent(qty, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(item, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(change, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8)
                                .addComponent(pay, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(75, 75, 75))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        DefaultTableModel tbl = (DefaultTableModel) jTable1.getModel();
        DefaultTableModel tb = (DefaultTableModel) jTable2.getModel();

        int row = jTable1.getSelectedRow();

        String price = jTable1.getValueAt(row, 3).toString();

        String quan = JOptionPane.showInputDialog(null, "QUANTITY");
        int total = Integer.parseInt(quan) * Integer.parseInt(price);
        tbl.setValueAt(quan, row, 2);
        tbl.setValueAt(total, row, 3);

        int newQuantity = Integer.parseInt(quantity) - Integer.parseInt(quan);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "");
            PreparedStatement ps = conn.prepareStatement("UPDATE products SET StockQuantity=? WHERE InventoryID=? ");
            ps.setString(1, String.valueOf(newQuantity));
            ps.setString(2, id);

            ps.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(cashiering.class.getName()).log(Level.SEVERE, null, ex);
        }

        int tot = Integer.parseInt(jTable1.getValueAt(row, 3).toString()) + Integer.parseInt(subtotal.getText());
        subtotal.setText(String.valueOf(tot));

        insertTransaction();
        tb.setRowCount(0);
        display();
//       

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

//         salesSTOCK();
        int row = jTable2.getSelectedRow();
        String ID = jTable2.getValueAt(row, 0).toString();

        product = jTable2.getValueAt(row, 1).toString();
        String price = jTable2.getValueAt(row, 3).toString();
        AddRowToJtable(new Object[]{
            ID, product, 0, price

        });

        quantity = jTable2.getValueAt(row, 4).toString();
        id = jTable2.getValueAt(row, 0).toString();
        int to = Integer.parseInt(subtotal.getText());
        subtotal.setText(String.valueOf(to));
        getResult();


    }//GEN-LAST:event_jButton4ActionPerformed

//    public void insertTransaction() {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection con = DriverManager.getConnection(
//                    "jdbc:mysql://localhost:3306/users", "root", "");
//
//            Statement stmt = con.createStatement();
//            ResultSet rst;
//            rst = stmt.executeQuery("select * from products_sold");
//
//            Statement stm = con.createStatement();
//
//            String inventory_id = ID.getText();
//            String productname = item.getText();
//            String quantityy = qty.getText();
//
////            String sellingprice = price.getText();
//            String total = price.getText();
//
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM");
//            SimpleDateFormat d = new SimpleDateFormat("hh:mm a");
//            Date dateobj = new Date();
//            String timee = d.format(dateobj.getTime());
//            String today = sdf.format(dateobj.getTime());
//            String datee = today + " " + time;
//            String user_id = user.getText();
//
//            
//
//            String query = "INSERT INTO cashiertransactions (inventoryID, productname, quantity, total, UserID, date, time)"
//                    + "values('" + inventory_id + "', '" + productname + "','" + quantityy + "','"
//                    + total + "','" + user_id + "','" + datee + "','" + timee + "')";
//
////             String query = "INSERT INTO products ( bookname, category,quantity,price)
////                    values('" + bookname + "','"+ category1 +"','"+ quantity +"','"+ price +"')";
//            stm.executeUpdate(query);
////            if (x == 0) {
////                JOptionPane.showMessageDialog(null, "INVENTORY ADDED!");
////            } else {
////                JOptionPane.showMessageDialog(null,
////                        "YOU ARE ABOUT TO ADD A PRODUCT!");
////            }
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//            e.printStackTrace();
//        }
//    }
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
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        DefaultTableModel dm = (DefaultTableModel) jTable1.getModel();
        int rowCount = dm.getRowCount();
//Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
            dm.removeRow(i);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        DefaultTableModel tblModel = (DefaultTableModel) jTable2.getModel();

        String id = tblModel.getValueAt(jTable2.getSelectedRow(), 0).toString();
        String productname = tblModel.getValueAt(jTable2.getSelectedRow(), 1).toString();

        String quantity1 = tblModel.getValueAt(jTable2.getSelectedRow(), 4).toString();
        String price1 = tblModel.getValueAt(jTable2.getSelectedRow(), 3).toString();

        ID.setText(id);
        item.setText(productname);
        qty.setText(quantity1);
        price.setText(price1);
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked


    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        int t = Integer.valueOf(subtotal.getText());
        int c = Integer.valueOf(pay.getText());
        int cas = c - t;
        change.setText(Integer.toString(cas));
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
//        try {
//            FileWriter myWriter = new FileWriter("receipt.txt");
//            receipt.setText(receipt.getText() + "=========================" + "\n"
//                    + "Develop by: Lorgem's SAVERS FAST MOVERS MINIMART MANAGEMENT");
//            myWriter.write(receipt.getText() + item.getText() + "\t" + qty.getText() + "\t\t" + price.getText() + "\n");
//            receipt.setText(receipt.getText() + "ProductName:" + "\n"
//                    + "Develop by: JECIL'S SAVERS FAST MOVERS MINIMART MANAGEMENT");
//            myWriter.close();
//            JOptionPane.showMessageDialog(null, "receipt successfully printed");
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "ERROR FIND AND RESTART NOW!");
//        }

//            insertTransaction();                
//
//
// 
//            
//        try 
//        {
//            receipt.print();
//        } 
//        catch (PrinterException ex) {
//            Logger.getLogger(cashiering.class.getName()).log(Level.SEVERE, null, ex);
//        }  
//    
        receipt.setText("*          Book Inventory System          *\n");

        Date obj = new Date();
        String date = obj.toString();

        receipt.setText(receipt.getText() + "\n" + date + "n\n");
        receipt.setText(receipt.getText() + "**ITEM : " + item.getText() + "n\n");
        receipt.setText(receipt.getText() + "QUANTITY : " + qty.getText() + "n\n");
        receipt.setText(receipt.getText() + "PRICE : " + price.getText() + "n\n");
        receipt.setText(receipt.getText() + "TOTAL : " + subtotal.getText() + "n\n");

    }//GEN-LAST:event_jButton10ActionPerformed

    private void subtotalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_subtotalKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_subtotalKeyPressed

    private void subtotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_subtotalKeyReleased
//       getResult();
    }//GEN-LAST:event_subtotalKeyReleased

    private void receiptKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_receiptKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String pcode = receipt.getText();
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/users", "root", "");
                pst = con.prepareStatement("select * from products_sold where item = ?");
                pst.setString(1, pcode);
                rs = pst.executeQuery();

                if (rs.next() == false) {
                    JOptionPane.showMessageDialog(this, "Product Code Not Found");
                } else {
                    String inventid = rs.getString("id");
                    String pname = rs.getString("item");
                    String quantity1 = rs.getString("qty");
                    String price1 = rs.getString("quantity");
                    ID.setText(pname.trim());
                    item.setText(pname.trim());
                    qty.setText(quantity1.trim());
                    price.setText(price1.trim());
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(cashiering.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(cashiering.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_receiptKeyPressed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        ID.setText("");
        item.setText("");
        qty.setText("");
        price.setText("");
        subtotal.setText("");
        pay.setText("");
        change.setText("");
        receipt.setText("");


    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        HOME ad = new HOME();
        ad.show();
        dispose();
    }//GEN-LAST:event_jButton11ActionPerformed

    public void AddRowToJtable(Object[] dataRow) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(dataRow);
    }

    public void bill() {
        String total = subtotal.getText();
        String payy = pay.getText();
        String bal = change.getText();

        DefaultTableModel model = new DefaultTableModel();

        model = (DefaultTableModel) jTable1.getModel();

        receipt.setText(receipt.getText() + "******************************************************\n");
        receipt.setText(receipt.getText() + "           BOOKSHOP RECEIPT                                    \n");
        receipt.setText(receipt.getText() + "*******************************************************\n");

        //Heading
        receipt.setText(receipt.getText() + "item" + "\t" + "quantity" + "\t" + "price" + "\n");

        for (int i = 0; i < model.getRowCount(); i++) {

            String pname = (String) model.getValueAt(i, 1);
            String pricee = (String) model.getValueAt(i, 3);
            String amount = (String) model.getValueAt(i, 4);

            receipt.setText(receipt.getText() + pname + "\t" + pricee + "\t" + amount + "\n");

        }

        receipt.setText(receipt.getText() + "\n");

        receipt.setText(receipt.getText() + "\t" + "\t" + "item :" + total + "\n");
        receipt.setText(receipt.getText() + "\t" + "\t" + "quantity :" + pay + "\n");
        receipt.setText(receipt.getText() + "\t" + "\t" + "price :" + bal + "\n");
        receipt.setText(receipt.getText() + "\n");
        receipt.setText(receipt.getText() + "*******************************************************\n");
        receipt.setText(receipt.getText() + "           THANK YOU COME AGIN             \n");

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
    private javax.swing.JTextField item;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField pay;
    private javax.swing.JTextField price;
    private javax.swing.JTextField qty;
    private javax.swing.JTextArea receipt;
    private javax.swing.JTextField subtotal;
    private javax.swing.JLabel time;
    public javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables
}
