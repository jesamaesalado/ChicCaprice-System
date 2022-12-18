/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javafp;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
//import inventory_system.*;

/**
 *
 * @author Clintoy
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ACCNAME = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        PASSWORD = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        BTN_LOGIN = new javax.swing.JButton();
        EXIT = new javax.swing.JButton();
        SIGNUP = new javax.swing.JLabel();
        CLOSE = new javax.swing.JLabel();

        jTextField2.setText("jTextField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javafp/Brand1.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel2.setText("LOGIN TO YOUR ACCOUNT");

        ACCNAME.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        ACCNAME.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ACCNAME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ACCNAMEActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel3.setText("Account Name");

        PASSWORD.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        PASSWORD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PASSWORD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PASSWORDActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel4.setText("Password");

        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel5.setText("Don't have account?");

        BTN_LOGIN.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        BTN_LOGIN.setText("LOGIN");
        BTN_LOGIN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        BTN_LOGIN.setContentAreaFilled(false);
        BTN_LOGIN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BTN_LOGINMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BTN_LOGINMouseExited(evt);
            }
        });
        BTN_LOGIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_LOGINActionPerformed(evt);
            }
        });

        EXIT.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        EXIT.setText("CANCEL");
        EXIT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        EXIT.setContentAreaFilled(false);
        EXIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EXITActionPerformed(evt);
            }
        });

        SIGNUP.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        SIGNUP.setForeground(new java.awt.Color(51, 102, 255));
        SIGNUP.setText("SIGN UP");
        SIGNUP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SIGNUPMouseClicked(evt);
            }
        });

        CLOSE.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        CLOSE.setText("X");
        CLOSE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CLOSEMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ACCNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(PASSWORD, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(SIGNUP))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(BTN_LOGIN, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(EXIT, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 24, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CLOSE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CLOSE)
                .addGap(47, 47, 47)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ACCNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PASSWORD, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_LOGIN, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EXIT, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(SIGNUP))
                .addContainerGap(128, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void PASSWORDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PASSWORDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PASSWORDActionPerformed

    private void BTN_LOGINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_LOGINActionPerformed
        // TODO add your handling code here:
        Statement ps;
        ResultSet rs;
        String accountname = ACCNAME.getText(); 
        String pass = String.valueOf(PASSWORD.getPassword());
        String role = " ";

               // Finding if User in database is equal to accountname in jTextfield and password from database to password.getText() 
        
        String query = "select * from user_info where account_name='"+ accountname+"' and password='"+pass+"'";
        
        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            rs = ps.executeQuery(query);
            // we use if rather than while loop since we wanted the program to be executed once
            if(rs.next())     
            {
                //Setting the equivalent value of jTextfield to database table and rows
                accountname = rs.getString(7);
                pass = rs.getString(8);
                role = rs.getString(10);
                
                
                // if the user has an account of admin whihch is the account_type in database it will directed to admin dashboard
               if(accountname.equals(accountname) && pass.equals(pass) && role.equals("admin")){
                   JOptionPane.showMessageDialog(this, role + " Login Successfully!");
                   admin_dashboard ad = new admin_dashboard();
                   ad.show();
                   dispose();
            }
               
               // if user has an account of user in account type in database then it will directed to cashiering frame
               
               else if(accountname.equals(accountname) && pass.equals(pass) && role.equals("user")){
                    JOptionPane.showMessageDialog(this, role + " Login Successfully!");
                   cashiering d = new cashiering(ACCNAME.getText());
                   d.show();
                   dispose();
               }
            }else {
                    JOptionPane.showMessageDialog(this, "Incorrect Account Name or Password");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BTN_LOGINActionPerformed

    private void EXITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EXITActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_EXITActionPerformed

    private void ACCNAMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ACCNAMEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ACCNAMEActionPerformed

    private void SIGNUPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SIGNUPMouseClicked
        SignUP sup = new SignUP();
        sup.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_SIGNUPMouseClicked

    private void CLOSEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CLOSEMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_CLOSEMouseClicked

    private void BTN_LOGINMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_LOGINMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_LOGINMouseEntered

    private void BTN_LOGINMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_LOGINMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_LOGINMouseExited

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ACCNAME;
    private javax.swing.JButton BTN_LOGIN;
    private javax.swing.JLabel CLOSE;
    private javax.swing.JButton EXIT;
    private javax.swing.JPasswordField PASSWORD;
    private javax.swing.JLabel SIGNUP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
