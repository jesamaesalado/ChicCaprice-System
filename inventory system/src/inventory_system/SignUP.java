/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package inventory_system;

/**
 *
 * @author Clintoy
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class SignUP extends javax.swing.JFrame {

    /**
     * Creates new form SignUP
     */
    public SignUP() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        lname = new javax.swing.JTextField();
        haddress = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        pnumber = new javax.swing.JTextField();
        conpassword = new javax.swing.JPasswordField();
        accname = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        jLabel13 = new javax.swing.JLabel();
        btn_SIGNUP = new javax.swing.JButton();
        CANCEL2 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        BLOGIN = new javax.swing.JLabel();
        CLOSE = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        accountype = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javafp/Brand1.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 36)); // NOI18N
        jLabel2.setText("Sign Up");

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel3.setText("Get started with your account");

        fname.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        fname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lname.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        lname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        haddress.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        haddress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel4.setText("First Name");

        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel5.setText("Last Name");

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel6.setText("Phone Number (Optional)");

        jLabel7.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel7.setText("Confirm Password");

        email.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel8.setText("Home Address");

        jLabel9.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel9.setText("Email");

        pnumber.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        pnumber.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        conpassword.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        conpassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        conpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conpasswordActionPerformed(evt);
            }
        });

        accname.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        accname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel10.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel10.setText("Account Name");

        jLabel11.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel11.setText("Account Info");

        jLabel12.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel12.setText("Personal Info");

        password.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        password.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel13.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel13.setText("Password");

        btn_SIGNUP.setBackground(new java.awt.Color(0, 204, 102));
        btn_SIGNUP.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        btn_SIGNUP.setText("Submit");
        btn_SIGNUP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_SIGNUP.setContentAreaFilled(false);
        btn_SIGNUP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SIGNUPActionPerformed(evt);
            }
        });

        CANCEL2.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        CANCEL2.setText("Cancel");
        CANCEL2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        CANCEL2.setContentAreaFilled(false);
        CANCEL2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CANCEL2MouseClicked(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel14.setText("Click here to");

        BLOGIN.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        BLOGIN.setForeground(new java.awt.Color(0, 102, 255));
        BLOGIN.setText("LOGIN");
        BLOGIN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BLOGINMouseClicked(evt);
            }
        });

        CLOSE.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        CLOSE.setText("X");
        CLOSE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CLOSEMouseClicked(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel15.setText("Account type");

        accountype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "user", "admin" }));
        accountype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel11)
                                    .addComponent(haddress)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(lname, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel8)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9)
                                            .addComponent(accname, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel7)
                                            .addComponent(conpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(accountype, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel15)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(pnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel13))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                                .addComponent(CLOSE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BLOGIN, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_SIGNUP, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CANCEL2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(CLOSE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(haddress, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(conpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(accountype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CANCEL2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_SIGNUP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(BLOGIN))
                .addContainerGap())
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

    private void btn_SIGNUPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SIGNUPActionPerformed
        // TODO add your handling code here:
        
        String firstname = fname.getText();
        String lastname = lname.getText();
        String homeaddress = haddress.getText();
        String emailaddress = email.getText();
        String phonenumber = pnumber.getText();
        String accountname = accname.getText();
        String pass = String.valueOf(password.getPassword());
        String confirmpass = String.valueOf(conpassword.getPassword());
//        String acc = accountype.getText();
        String acc= accountype.getSelectedItem().toString();
//            Save.setString(7, role.getSelectedItem().toString());
        String message ="Please Input the Required Field !";
       
        
        
        PreparedStatement ps;
        String query = "INSERT INTO `user_info`(`first_name`, `last_name`, `address`, `email`, `phone_number`, `account_name`, `password`,`confirm_password`, account_type) VALUES (?,?,?,?,?,?,?,?,?)";
        
        
        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            
            ps.setString(1, firstname);
            ps.setString(2, lastname);
            ps.setString(3, homeaddress); 
            ps.setString(4, emailaddress);
            ps.setString(5, phonenumber);
            ps.setString(6, accountname);
            ps.setString(7, pass);
            ps.setString(8, confirmpass);
            ps.setString(9, acc);
             
        if (firstname.equals("")){
            JOptionPane.showMessageDialog(null, message);
        }
        else if(lastname.equals("")){
            JOptionPane.showMessageDialog(null, message);
        }
        else if(homeaddress.equals("")){
            JOptionPane.showMessageDialog(null, message);
        }
        else if(emailaddress.equals("")){
            JOptionPane.showMessageDialog(null, message);
        }
        else if(phonenumber.equals("")){
            JOptionPane.showMessageDialog(null, message);
        }
        else if(accountname.equals("")){
            JOptionPane.showMessageDialog(null, message);
        }
        else if(pass.equals("")){
            JOptionPane.showMessageDialog(null, message);
        }
        else if(confirmpass.equals("")){
            JOptionPane.showMessageDialog(null, message);
        }
        else if(!pass.equals(confirmpass)){
            JOptionPane.showMessageDialog(null, "Password Dont Match");
        }
        
        else if(checkAccountname(accountname)){
            
            JOptionPane.showMessageDialog(null, "Account Name Already Existed");
        }
        else if (ps.executeUpdate() > 0) 
            {
                 
                JOptionPane.showMessageDialog(null, "Succesfully Registered");
                 fname.setText("");
                 lname.setText("");
                 haddress.setText("");
                 email.setText("");
                 pnumber.setText("");
                 accname.setText("");
                 password.setText("");
                 conpassword.setText("");
//                 accountype.setValue(null);
                 
            }
        
            
        } catch (SQLException ex) {
            Logger.getLogger(SignUP.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
        
    }//GEN-LAST:event_btn_SIGNUPActionPerformed

     public boolean checkAccountname(String accountname){
          PreparedStatement ps;
          ResultSet rs;
          boolean checkAccountname = false;
          String query = "SELECT * FROM `user_info` WHERE `account_name`=?";
          
        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            ps.setString(1, accountname);
            
             rs = ps.executeQuery();
            
            if(rs.next())
            {
                checkAccountname = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SignUP.class.getName()).log(Level.SEVERE, null, ex);
        }
         return checkAccountname;
    }
    private void conpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_conpasswordActionPerformed

    private void BLOGINMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BLOGINMouseClicked
        // TODO add your handling code here:
        Login lgn = new Login();
        lgn.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BLOGINMouseClicked

    private void CANCEL2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CANCEL2MouseClicked
        Login b2login = new Login();
        b2login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CANCEL2MouseClicked

    private void CLOSEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CLOSEMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_CLOSEMouseClicked

    private void accountypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_accountypeActionPerformed

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
            java.util.logging.Logger.getLogger(SignUP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BLOGIN;
    private javax.swing.JButton CANCEL2;
    private javax.swing.JLabel CLOSE;
    private javax.swing.JTextField accname;
    private javax.swing.JComboBox<String> accountype;
    private javax.swing.JButton btn_SIGNUP;
    private javax.swing.JPasswordField conpassword;
    private javax.swing.JTextField email;
    private javax.swing.JTextField fname;
    private javax.swing.JTextField haddress;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lname;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField pnumber;
    // End of variables declaration//GEN-END:variables
}
