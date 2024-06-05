/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package markky;

import config.dbConnector;
import config.passwordHasher;
import java.awt.Image;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class RegistrationForm extends javax.swing.JFrame {

    private boolean duplicateCheck;
    
    public RegistrationForm() {
        initComponents();
        
         Image img=new ImageIcon(this.getClass().getResource("/tb.jpg")).getImage();
        this.setIconImage(img);
    }
    
     public static String uemail,username;  
     
     public boolean duplicateCheck(){
        dbConnector dbc = new dbConnector();
           
        try{
        String query = "SELECT * FROM tbl_users  WHERE u_username = '" + un.getText() + "' OR u_password = '" + em.getText() + "'";
            ResultSet resultSet = dbc.getData(query);
             
             if(resultSet.next()){
              uemail = resultSet.getString("u_email");
             if(uemail.equals(em.getText())){
            JOptionPane.showMessageDialog(null, "Email is Already Used!");
            em.setText("");
           } 
           username = resultSet.getString("u_username");  
           if(username.equals(un.getText())){
           JOptionPane.showMessageDialog(null, "Username is Already Used!");
            un.setText("");
           }
           return true;
     }else{
           return false;
     }
   }catch(SQLException ex){
        System.out.println(""+ex);
          return false;       
     }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        fn = new javax.swing.JTextField();
        registrationform = new javax.swing.JLabel();
        em = new javax.swing.JTextField();
        fname = new javax.swing.JLabel();
        ln = new javax.swing.JTextField();
        lname = new javax.swing.JLabel();
        un = new javax.swing.JTextField();
        email = new javax.swing.JLabel();
        pw = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        usert = new javax.swing.JLabel();
        register = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        ut = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setForeground(new java.awt.Color(0, 153, 153));

        fn.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N

        registrationform.setBackground(new java.awt.Color(153, 255, 255));
        registrationform.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        registrationform.setForeground(new java.awt.Color(153, 0, 153));
        registrationform.setText("REGISTRATION FORM");

        em.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N

        fname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fname.setText("First Name:");

        ln.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N

        lname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lname.setText("Last Name:");

        un.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N

        email.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        email.setText("Email:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("User Name:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Password:");

        usert.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        usert.setText("Account Type:");

        register.setBackground(new java.awt.Color(255, 255, 255));
        register.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        register.setText("Register");
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });

        cancel.setBackground(new java.awt.Color(255, 255, 255));
        cancel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        ut.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "user" }));
        ut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                utActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(register)
                        .addGap(40, 40, 40)
                        .addComponent(cancel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(fname)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(un, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lname)
                                    .addComponent(email))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ln)
                                    .addComponent(em, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(usert)
                                .addGap(18, 18, 18)
                                .addComponent(ut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(pw, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(registrationform))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(registrationform)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fname)
                    .addComponent(fn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lname)
                    .addComponent(ln, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(em, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(un, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(pw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usert)
                    .addComponent(ut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(register)
                    .addComponent(cancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void utActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_utActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_utActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
     
    }//GEN-LAST:event_cancelActionPerformed

    private void registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerActionPerformed
      
        if(fn.getText().isEmpty() || ln.getText().isEmpty() || em.getText().isEmpty()
         || un.getText().isEmpty() || pw.getText().isEmpty()){
          JOptionPane.showMessageDialog(null, "All fields are required!");
        }else if (pw.getText().length() < 8) {
            JOptionPane.showMessageDialog(null, "Password should have at least 8 characters.", "Invalid Password", JOptionPane.ERROR_MESSAGE);
            pw.setText(""); 
       }else if (duplicateCheck){
            System.out.println("Duplicate Exist");
       }else{      
           
        try{  
        dbConnector dbc = new dbConnector();   
        String pass = passwordHasher.hashPassword(pw.getText());
        if (dbc.insertData("INSERT INTO tbl_user (u_fname,u_lname,u_email,u_username,u_password,u_type,u_status)"
                + "VALUES('" + fn.getText() + "','" + ln.getText() + "','" + em.getText() + "','" + un.getText() + "','" +pass+ "','" + ut.getSelectedItem() + "','Pending')"))
        {
            JOptionPane.showMessageDialog(null, "Registered Successfully!");
            loginForm lgf = new loginForm();
            lgf.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Failed!");
        }
       }catch(NoSuchAlgorithmException ex){
           System.out.println(""+ex);       
       }
    }//GEN-LAST:event_registerActionPerformed
         
    }
      public static void main(String args[]) {   
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrationForm().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton cancel;
    private javax.swing.JTextField em;
    private javax.swing.JLabel email;
    private javax.swing.JTextField fn;
    private javax.swing.JLabel fname;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField ln;
    private javax.swing.JLabel lname;
    private javax.swing.JPasswordField pw;
    private javax.swing.JButton register;
    private javax.swing.JLabel registrationform;
    private javax.swing.JTextField un;
    private javax.swing.JLabel usert;
    private javax.swing.JComboBox<String> ut;
    // End of variables declaration//GEN-END:variables
}
