/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package markky;

import admin.adminDashboard;
import config.Session;
import config.dbConnector;
import config.passwordHasher;
import java.awt.Image;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import user.userDashboard;


/**
 *
 * @author PC11
 */
public class loginForm extends javax.swing.JFrame {

    /**
     * Creates new form loginForm
     */
    public loginForm() {
        initComponents();
       
        Image img=new ImageIcon(this.getClass().getResource("/tb.jpg")).getImage();
        this.setIconImage(img);
    }
     static String status;
     static String type; 
     
    public static boolean loginAcc(String username, String password){
        dbConnector connector = new dbConnector();
        
        try{
            String query = "SELECT * FROM tbl_user  WHERE u_username = '" + username +"'";
            ResultSet resultSet = connector.getData(query);
           if(resultSet.next()){
           
      
            String hashedPass = resultSet.getString("u_password"); 
            String rehashedPass = passwordHasher.hashPassword(password); 
     
             
             if(hashedPass.equals(rehashedPass)){
            status = resultSet.getString("u_status");
            type = resultSet.getString("u_type");
            Session sess = Session.getinstance();
            sess.setUid(resultSet.getInt("u_id"));
            sess.setFname(resultSet.getString("u_fname"));
            sess.setLname(resultSet.getString("u_lname"));
            sess.setEmail(resultSet.getString("u_email"));
            sess.setUsername(resultSet.getString("u_username"));
            sess.setType(resultSet.getString("u_type"));
            sess.setStatus(resultSet.getString("u_status"));        
            return true;      
            }else{
            return false;          
            }
           }else{
            return false;    
        }
        }catch (SQLException | NoSuchAlgorithmException ex){
         return false;

        }     

    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        ut = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        login = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jLabel4.setText("jLabel4");

        ut.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "user" }));
        ut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                utActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Password:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, -1, 39));

        login.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        login.setForeground(new java.awt.Color(255, 51, 51));
        login.setText("LOGIN");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        login.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                loginKeyPressed(evt);
            }
        });
        getContentPane().add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 350, 100, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText("STUDENT");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 280, 60));

        user.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, 160, -1));

        pass.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passKeyPressed(evt);
            }
        });
        getContentPane().add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, 160, -1));

        jLabel5.setBackground(new java.awt.Color(204, 204, 255));
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("NEW? REGISTER HERE!");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 360, 130, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Username:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, -1, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/tb.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 390));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
          if(loginAcc(user.getText(),pass.getText())){  
        if(!status.equals("active")){
          JOptionPane.showMessageDialog(null,"In-Active Account, Contact the Admin!");  
        }else{  
        JOptionPane.showMessageDialog(null,"Login Success!");
          if(type.equals("admin")){
        adminDashboard ads = new adminDashboard(); 
        ads.setVisible(true);   
        this.dispose();
      }else if(type.equals("user")){
        userDashboard uds = new userDashboard(); 
        uds.setVisible(true);   
        this.dispose();
         }else{
        JOptionPane.showMessageDialog(null,"NO account type found, Contact the Admin!");   
             }
        }
      }else{ 
       JOptionPane.showMessageDialog(null,"Invalid Account!");
           
        }
       
    }//GEN-LAST:event_loginActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
       RegistrationForm rgf = new RegistrationForm();
       rgf.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void utActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_utActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_utActionPerformed

    private void loginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginKeyPressed
       
        
    }//GEN-LAST:event_loginKeyPressed

    private void passKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passKeyPressed
       
    }//GEN-LAST:event_passKeyPressed

   
    public static void main(String args[]) {    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton login;
    private javax.swing.JPasswordField pass;
    private javax.swing.JTextField user;
    private javax.swing.JComboBox<String> ut;
    // End of variables declaration//GEN-END:variables
}
