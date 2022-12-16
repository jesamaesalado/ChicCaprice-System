/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory_system;

import static inventory_system.PendingReg.jTable2;
import java.awt.HeadlessException;
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
import javafx.animation.Animation.Status;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static inventory_system.Login.username;

/**
 *
 * @author student.admin
 */
public final class Staff extends javax.swing.JFrame {

    /**
     * Creates new form admin
     */
    public Staff() {
        initComponents();
        Connect();
        display();
        getUsernameandID();
//        ShowData();
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
            e.printStackTrace();
        }
    }

    public void getinvID() {

        PreparedStatement st;
        ResultSet rst;

        String query = "SELECT MAX(InventoryID) FROM products;";

        try {
            st = DBconnection.getConnection().prepareStatement(query);
            rst = st.executeQuery();

            if (rst.next()) {
                id1.setText(rst.getString(1));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/users", "root", "");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HOME.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(HOME.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void display() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "");

            Statement st = conn.createStatement();
            String sql = "SELECT * FROM products";
            ResultSet rst = st.executeQuery(sql);
            DefaultTableModel tbl = (DefaultTableModel) jTable1.getModel();
            while (tbl.getRowCount() > 0) {
                tbl.removeRow(0);
            }
            while (rst.next()) {

                int inventory_id = rst.getInt(1);
                String product_name = rst.getString(2);
                String category1 = rst.getString(3);
                int buyprice1 = rst.getInt(4);
                int price1 = rst.getInt(5);
                String quantity = rst.getString(6);
                String stock_quantity = rst.getString(7);
                String uom1 = rst.getString(8);
                String pubdate1 = rst.getString(9);
                String availl = rst.getString(10);

                Object tbData[] = {inventory_id, product_name, category1, buyprice1, price1, quantity, stock_quantity, uom1, pubdate1, availl};

                tbl.addRow(tbData);

            }

        } catch (ClassNotFoundException | SQLException e) {

        }

    }

    public void AddTrans() {
        try {

            getinvID();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/users", "root", "");

            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("select * from products");

            Statement stm = con.createStatement();

            String inventory_id = id1.getText();
            String productname = name1.getText();
            String sellingprice = price.getText();
            String quantity = qty.getText();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM");
            SimpleDateFormat d = new SimpleDateFormat("hh:mm a");
            Date dateobj = new Date();
            String time = d.format(dateobj.getTime());
            String today = sdf.format(dateobj.getTime());
            String date = today + " " + time;
            String user_id = user.getText();

            String type = "ADD";

            String query = "INSERT INTO stransactions (InventoryID, ProductName, Quantity, TypeofTransaction, UserID, Date, Time)"
                    + "values('" + inventory_id + "', '" + productname + "', '" + quantity + "','"
                    + type + "','"  + user_id + "','"  + date + "','" + time + "')";

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

    public void EditTrans() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/users", "root", "");

            Statement stmt = con.createStatement();
            ResultSet rst;
            rst = stmt.executeQuery("select * from products");

            Statement stm = con.createStatement();

            String inventory_id = id1.getText();
            String productname = name1.getText();

//            String sellingprice = price.getText();
            String quantity = qty.getText();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM");
            SimpleDateFormat d = new SimpleDateFormat("hh:mm a");
            Date dateobj = new Date();
            String time = d.format(dateobj.getTime());
            String today = sdf.format(dateobj.getTime());
            String date = today + " " + time;
            String user_id = user.getText();

            String type = "EDIT";

            String query = "INSERT INTO stransactions (InventoryID, ProductName, Quantity, TypeofTransaction, UserID, Date, Time)"
                    + "values('" + inventory_id + "', '" + productname + "','" + quantity + "','"
                    + type + "','"  + user_id + "','"  + date + "','" + time + "')";

//             String query = "INSERT INTO products ( bookname, category,quantity,price)
//                    values('" + bookname + "','"+ category1 +"','"+ quantity +"','"+ price +"')";
            stm.executeUpdate(query);
//            if (x == 0) {
//                JOptionPane.showMessageDialog(null, "INVENTORY ADDED!");
//            } else {
//                JOptionPane.showMessageDialog(null,
//                        "YOU ARE ABOUT TO ADD A PRODUCT!");
//            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }

    }

//    public void ShowData() {
//        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
//
//        String[] cols = {"Bid", "Book name", "quantity", "price", "category"
//        };
//        String[][] data = {
//            {"1", "A walk to Remember","150","999","Romance"},
//            {"2", "Rain in Espanya","100","750",""},
//            {"3", "Our Yesterday's Escape","100","500","Romance"},
//            {"4", "Espresso Love","100","980","Teen fiction"},
//            {"5", "Island Trap","100","870","Romance"},
//            {"6", "Temptation Island","100","999","Romance"},
//            {"7", "Exclusively Mine","100","500","Teen fiction"},
//            {"8", "Bride of Alfonso","100","1000","Romance"},
//            {"9", "The Summer I Drowned","100","600","Tragic"},
//            {"10", "Safe Sky Archer","100","980","Tragic"},
//            {"11", "The Hoodie Girl","100","750","Romance"},
//            {"12", "Fame","100","800","Teen Fiction"},
//            {"13", "Special Section","100","880","Horror"},
//            {"14", "Perfect Addiction","100","560","Romance"},
//            {"15", "Dominantly Yours","100","600","Teen Fiction"},
//            {"16", "That Promdi Girl","100","750","Teen Fiction"},
//            {"17", "The Artist's Armour","100","780","Romance"},
//            {"18", "Golden Scenery of Tomorrow","100","820","Teen Fiction"},
//            {"19", "Our Asymptotic Love Story","100","700","Fiction"},
//            {"20", "A Kidnappers Mistake","123","900","Romance"}};
//
//        model.setDataVector(data, cols);
//    }
    public void getThreshold() {
        DefaultTableModel lorgem = (DefaultTableModel) jTable1.getModel();

        int lor = jTable1.getSelectedRow();

        int pila = Integer.parseInt(lorgem.getValueAt(lor, 6).toString());

        if (pila < 50) {
            JOptionPane.showMessageDialog(null, "YOU ARE ALMOST OUT OF STOCK!!!");

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

        jFrame1 = new javax.swing.JFrame();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        category = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        id1 = new javax.swing.JTextField();
        qty = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        name1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        buyprice = new javax.swing.JTextField();
        pubdate = new javax.swing.JTextField();
        uom = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tqty1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        avail = new javax.swing.JComboBox<>();
        user = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        back = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 102, 102));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jPanel2.setBackground(new java.awt.Color(146, 109, 109));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel1.setText("Inventory ID");

        jLabel2.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel2.setText("Treshold Quantity");

        jLabel3.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel3.setText("Product Name");

        jLabel4.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel4.setText("Category");

        jLabel5.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel5.setText("Selling Price");

        id1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id1ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(153, 153, 153));
        jButton1.setText("add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(153, 153, 153));
        jButton2.setText("update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(153, 153, 153));
        jButton3.setText("clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(153, 153, 153));
        jButton4.setText("delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel9.setText("Unit of measure");

        jLabel11.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel11.setText("Availability");

        jLabel8.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel8.setText("Stock Quantity");

        jLabel12.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel12.setText("Username");

        jLabel13.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel13.setText("Published Date");

        avail.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Available", "Unavailable" }));
        avail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                availActionPerformed(evt);
            }
        });

        user.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        user.setText("ID");

        jLabel10.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jLabel10.setText("Buying Price");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(user)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel10))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(12, 12, 12)))
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(id1, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                                            .addComponent(name1))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))))
                                .addGap(33, 33, 33))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(0, 18, Short.MAX_VALUE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buyprice, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(qty, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tqty1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pubdate)
                            .addComponent(avail, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(uom, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(76, 76, 76))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buyprice, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(uom, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pubdate, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(id1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(name1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(avail, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(qty, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tqty1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(10, 10, 10))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(user)))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(21, 21, 21))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "InventoryID", "ProductName", "Category", "BuyingPrice", "SellingPrice", "quantity", "Treshold Quantity", "Unit of measure", "Published Date", "Availability"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, true, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(7).setResizable(false);
        }

        jButton5.setBackground(new java.awt.Color(0, 0, 0));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButton5.setForeground(new java.awt.Color(153, 0, 0));
        jButton5.setText("X");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel14.setBackground(new java.awt.Color(204, 102, 0));
        jLabel14.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(175, 112, 110));
        jLabel14.setText("MANAGE PRODUCTS");

        back.setBackground(new java.awt.Color(0, 0, 0));
        back.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        back.setForeground(new java.awt.Color(153, 0, 0));
        back.setText("Log out");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void id1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        id1.setText("");
        name1.setText("");
        category.setText("");
        buyprice.setText("");
        price.setText("");
        qty.setText("");
        tqty1.setText("");
        uom.setText("");
        pubdate.setText("");
        avail.setSelectedItem(null);

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String pn = name1.getText();
        String cat = category.getText();
        Integer b = Integer.valueOf(buyprice.getText());
        Integer p = Integer.valueOf(price.getText());
        Integer q = Integer.valueOf(qty.getText());
        Integer t = Integer.valueOf(tqty1.getText());
        String unit = uom.getText();
        String pd = pubdate.getText();
        String av = avail.getSelectedItem().toString();

        PreparedStatement ps;
        String lorgem = "INSERT INTO products ( ProductName,Category,BuyingPrice, SellingPrice, StockQuantity, Threshold, UnitofMeasure, PublishedDate,Availability) VALUES (?,?,?,?,?,?,?,?,?)";

        try {

            ps = DBconnection.getConnection().prepareStatement(lorgem);

            ps.setString(1, pn);
            ps.setString(2, cat);
            ps.setInt(3, b);
            ps.setInt(4, p);
            ps.setInt(5, q);
            ps.setInt(6, t);
            ps.setString(7, unit);
            ps.setString(8, pd);
            ps.setString(9, av);

            if (ps.executeUpdate() != 0) {

                JOptionPane.showMessageDialog(null, "ADDED SUCCESSFULLY!");
                display();
                AddTrans();

            } else {
                JOptionPane.showMessageDialog(null, "Error! Check your information.");
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:

        getThreshold();
        DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();

        String uid1 = tblModel.getValueAt(jTable1.getSelectedRow(), 0).toString();
        String name = tblModel.getValueAt(jTable1.getSelectedRow(), 1).toString();
        String category1 = tblModel.getValueAt(jTable1.getSelectedRow(), 2).toString();
        String bprice = tblModel.getValueAt(jTable1.getSelectedRow(), 3).toString();
        String price1 = tblModel.getValueAt(jTable1.getSelectedRow(), 4).toString();
        String quantity = tblModel.getValueAt(jTable1.getSelectedRow(), 5).toString();
        String stock_quantity = tblModel.getValueAt(jTable1.getSelectedRow(), 6).toString();
        String unit = tblModel.getValueAt(jTable1.getSelectedRow(), 7).toString();
        String exp = tblModel.getValueAt(jTable1.getSelectedRow(), 8).toString();

        id1.setText(uid1);
        name1.setText(name);
        category.setText(category1);
        buyprice.setText(bprice);
        price.setText(price1);
        qty.setText(quantity);
        tqty1.setText(stock_quantity);
        uom.setText(unit);
        pubdate.setText(exp);

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (id1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Select an Inventory ID to be deleted!");

        } else {
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "");
                String id = id1.getText();
                String query = "delete from products where  InventoryID=" + id;
                Statement stm = con.createStatement();
                stm.executeUpdate(query);

                display();
                JOptionPane.showMessageDialog(this, "SUCCESSFULLY DELETED!");

            } catch (SQLException ex) {
                Logger.getLogger(Staff.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//              try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            
//
//            
//            int row = jTable1.getSelectedRow();
//            DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();
//            String bid = tblModel.getValueAt(row, 0).toString();
//
//            
//            
//            
////             String query = "INSERT INTO products ( bookname, category,quantity,price)
////                    values('" + bookname + "','"+ category1 +"','"+ quantity +"','"+ price +"')";
//
//            
//            JOptionPane.showMessageDialog(null,"WARNING!, "  + "This book will be permanently DELETED!");
//            
//            tblModel.setRowCount(0);
//            
//            Statement stmt = con.createStatement();
//            ResultSet rs;
//            rs = stmt.executeQuery("select * from products");
//
//           
//    while(rs.next()){
//
//            String id = rs.getString(1);
//            String name = rs.getString(2);
//            String category1 = rs.getString(3);
//            String bprice = rs.getString(4);
//            String pricee = rs.getString(5);
//            String quantity= rs.getString(6);
//            String tres_quantity= rs.getString(7);
//            String unit = rs.getString(8);
//            String ex = rs.getString(9);
//
//
//            String tbData[] ={id, name, category1,bprice, pricee,quantity,tres_quantity,unit,ex};
//            
//
//            tblModel.addRow(tbData);
//}
//
//        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
//                                  

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
//            int i = jTable1.getSelectedRow();
//       DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
//       if(i>=0){
//           model.setValueAt(id1.getText(),i,0);
//           model.setValueAt(name1.getText(),i,1);
//           model.setValueAt(category.getText(),i,2);
//           model.setValueAt(buyprice.getText(),i,3);
//           model.setValueAt(price.getText(),i,4);
//           model.setValueAt(qty.getText(),i,5);
//           model.setValueAt(uom.getText(),i,6);
//           model.setValueAt(pubdate.getText(),i,7);
//
//       }else{
//           JOptionPane.showMessageDialog(null, "ERROR!");
//       }

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/users", "root", "");

            PreparedStatement pst_1 = con.prepareStatement("update products set InventoryID=?, ProductName=?, Category=?, BuyingPrice=?, SellingPrice=?, StockQuantity=?, Threshold=?, UnitofMeasure=?, PublishedDate=?, Availability=? WHERE InventoryID=?");
//            Statement STMT = con.createStatement();
//            STMT.executeUpdate(String.format("update products set ProductName='%s', Category='%s', BuyingPrice='%s', SellingPrice='%s', StockQuantity='%s', Threshold='%s', UnitofMeasure='%s', PublishedDate='%s', Availability='%s' where InventoryID='%s'",
//                                           name1.getText(), category.getText(), buyprice.getText(), price.getText(), qty.getText() ,tqty1.getText(), uom.getText(), pubdate.getText(), avail.getSelectedItem().toString(), id1.getText()));
            pst_1.setInt(1, Integer.parseInt(id1.getText()));
            pst_1.setString(2, name1.getText());
            pst_1.setString(3, category.getText());
            pst_1.setInt(4, Integer.parseInt(buyprice.getText()));
            pst_1.setInt(5, Integer.parseInt(price.getText()));
            pst_1.setInt(6, Integer.parseInt(qty.getText()));
            pst_1.setInt(7, Integer.parseInt(tqty1.getText()));
            pst_1.setString(8, uom.getText());
            pst_1.setString(9, pubdate.getText());
            pst_1.setString(10, avail.getSelectedItem().toString());
            pst_1.setInt((11), Integer.parseInt(id1.getText()));
            pst_1.executeUpdate();

            JOptionPane.showMessageDialog(null, "Updated Successfully!");
            display();
            EditTrans();
//         
//        
        } catch (SQLException ex) {
            Logger.getLogger(HOME.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(adminn.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void availActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_availActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_availActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        Login l = new Login();
        l.show();
        dispose();

    }//GEN-LAST:event_backActionPerformed

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
            java.util.logging.Logger.getLogger(Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Staff().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> avail;
    private javax.swing.JButton back;
    private javax.swing.JTextField buyprice;
    private javax.swing.JTextField category;
    private javax.swing.JTextField id1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JFrame jFrame1;
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField name1;
    private javax.swing.JTextField price;
    private javax.swing.JTextField pubdate;
    private javax.swing.JTextField qty;
    private javax.swing.JTextField tqty1;
    private javax.swing.JTextField uom;
    private javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables
}
