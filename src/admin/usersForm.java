/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import config.Session;
import config.dbConnector;
import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author PC11
 */
public class usersForm extends javax.swing.JFrame {

    /**
     * Creates new form adminDashboard
     */
    public usersForm() {
        initComponents();
        
         Image img=new ImageIcon(this.getClass().getResource("/tb.jpg")).getImage();
        this.setIconImage(img);
        
        displayData();       
    }
   
    Color navcolor = new Color (51,255,255);
    Color hovercolor = new Color (204,204,255);
    
        public void displayData(){
        try{
            dbConnector dbc = new dbConnector();
            ResultSet rs = dbc.getData("SELECT s_StudentNo,s_LastName,s_FirstName,s_MiddleName,s_Program,s_Section,s_Address,Contact_no  FROM studententry");
            usersTable.setModel(DbUtils.resultSetToTableModel(rs));
             rs.close();
        }catch(SQLException ex){
            System.out.println("Errors: "+ex.getMessage());
        
        }
        
    
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        usersTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        acc_id = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        p_add = new javax.swing.JPanel();
        ADD = new javax.swing.JLabel();
        p_edit = new javax.swing.JPanel();
        edit = new javax.swing.JLabel();
        PRINT = new javax.swing.JPanel();
        print = new javax.swing.JLabel();
        p_delete = new javax.swing.JPanel();
        delete = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));
        jPanel4.setLayout(null);

        jPanel7.setBackground(new java.awt.Color(204, 204, 255));

        usersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        usersTable.setToolTipText("");
        usersTable.setDropMode(javax.swing.DropMode.ON);
        jScrollPane1.setViewportView(usersTable);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel7);
        jPanel7.setBounds(0, 0, 850, 470);

        jPanel3.setBackground(new java.awt.Color(51, 255, 255));

        jPanel6.setBackground(new java.awt.Color(51, 255, 255));

        acc_id.setBackground(new java.awt.Color(0, 0, 0));
        acc_id.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        acc_id.setText("ID");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(acc_id, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(acc_id)
                .addGap(23, 23, 23))
        );

        jPanel2.setBackground(new java.awt.Color(51, 255, 255));
        jPanel2.setLayout(null);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/user.png"))); // NOI18N
        jPanel2.add(jLabel3);
        jLabel3.setBounds(20, 20, 80, 90);

        p_add.setBackground(new java.awt.Color(51, 255, 255));
        p_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p_addMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                p_addMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                p_addMouseExited(evt);
            }
        });
        p_add.setLayout(null);

        ADD.setBackground(new java.awt.Color(51, 255, 0));
        ADD.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ADD.setText("ADD");
        ADD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADDMouseClicked(evt);
            }
        });
        p_add.add(ADD);
        ADD.setBounds(30, 10, 50, 20);

        p_edit.setBackground(new java.awt.Color(51, 255, 255));
        p_edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p_editMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                p_editMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                p_editMouseExited(evt);
            }
        });
        p_edit.setLayout(null);

        edit.setBackground(new java.awt.Color(51, 255, 0));
        edit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        edit.setText("EDIT");
        p_edit.add(edit);
        edit.setBounds(30, 10, 50, 20);

        PRINT.setBackground(new java.awt.Color(51, 255, 255));
        PRINT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PRINTMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PRINTMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PRINTMouseExited(evt);
            }
        });
        PRINT.setLayout(null);

        print.setBackground(new java.awt.Color(51, 255, 0));
        print.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        print.setText("PRINT");
        PRINT.add(print);
        print.setBounds(30, 10, 70, 20);

        p_delete.setBackground(new java.awt.Color(51, 255, 255));
        p_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p_deleteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                p_deleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                p_deleteMouseExited(evt);
            }
        });
        p_delete.setLayout(null);

        delete.setBackground(new java.awt.Color(51, 255, 0));
        delete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        delete.setText("DELETE");
        p_delete.add(delete);
        delete.setBounds(20, 10, 70, 20);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PRINT, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(p_delete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(p_edit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(p_add, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(p_add, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(p_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(PRINT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.add(jPanel3);
        jPanel3.setBounds(850, 0, 120, 470);

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 78, 970, 470));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 255, 153));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BACK");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(0, 255, 153));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("STUDENT ENTRY");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 537, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
       adminDashboard ds = new adminDashboard();
       ds.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
       Session sess = Session.getinstance();
       acc_id.setText(""+sess.getUid());
       
    }//GEN-LAST:event_formWindowActivated

    private void p_addMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_addMouseEntered
       p_add.setBackground(hovercolor); 
    }//GEN-LAST:event_p_addMouseEntered

    private void p_addMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_addMouseExited
      p_add.setBackground(navcolor); 
    }//GEN-LAST:event_p_addMouseExited

    private void p_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_addMouseClicked
       creationUserForm cruf = new creationUserForm();
       cruf.setVisible(true);
       this.dispose();
       
    }//GEN-LAST:event_p_addMouseClicked

    private void p_editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_editMouseClicked
          int rowlndex = usersTable.getSelectedRow();
     if(rowlndex <0){
        JOptionPane.showMessageDialog(null,"Please select an item!");
     }else{        
        try{
            dbConnector dbc =  new dbConnector();
            TableModel tbl = usersTable.getModel();
            ResultSet rs = dbc.getData("SELECT * FROM studententry WHERE s_StudentNo ="+tbl.getValueAt(rowlndex,0)+"");
            if(rs.next()){
            creationUserForm cruf = new creationUserForm();
            cruf.uid.setText(""+rs.getString("s_StudentNo"));      
            cruf.ln.setText(""+rs.getString("s_LastName"));
            cruf.fn.setText(""+rs.getString("s_FirstName"));
            cruf.mn.setText(""+rs.getString("s_MiddleName"));
            cruf.pr.setSelectedItem(""+rs.getString("s_Program"));
            cruf.st.setText(""+rs.getString("s_Section")); 
            cruf.adds.setText(""+rs.getString("s_Address"));    
            cruf.conNO.setText(""+rs.getString("Contact_no"));  
            cruf.image.setIcon(cruf.ResizeImage(rs.getString("u_image"),null,cruf.image));
            cruf.oldpath =rs.getString("u_image");
            cruf.path =rs.getString("u_image");
            cruf.destination =rs.getString("u_image");
            cruf.add.setEnabled(false);
            cruf.update.setEnabled(true);
            cruf.setVisible(true);
            
            if(rs.getString("u_image").isEmpty()){
            cruf.select.setEnabled(true);
            cruf.remove.setEnabled(false);
            }else{        
            cruf.select.setEnabled(false);
            cruf.remove.setEnabled(true);
            }
            this.dispose();
            }
        }catch(SQLException ex){ 
           System.out.println(""+ex);
        }
     }
     
    
    }//GEN-LAST:event_p_editMouseClicked

    private void p_editMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_editMouseEntered
      p_edit.setBackground(hovercolor); 
    }//GEN-LAST:event_p_editMouseEntered

    private void p_editMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_editMouseExited
        p_edit.setBackground(navcolor); 
    }//GEN-LAST:event_p_editMouseExited

    private void ADDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADDMouseClicked
       creationUserForm cruf = new creationUserForm();
       cruf.setVisible(true);
       cruf.remove.setEnabled(false);
       cruf.select.setEnabled(true);
       this.dispose();
       
    }//GEN-LAST:event_ADDMouseClicked

    private void PRINTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PRINTMouseClicked
       int rowlndex = usersTable.getSelectedRow();
     if(rowlndex <0){
        JOptionPane.showMessageDialog(null,"Please select an item!");
     }else{        
        try{
            dbConnector dbc =  new dbConnector();
            TableModel tbl = usersTable.getModel();
            ResultSet rs = dbc.getData("SELECT * FROM studententry WHERE s_StudentNo ="+tbl.getValueAt(rowlndex,0)+"");
            if(rs.next()){
            individualPrinting ipt = new individualPrinting();
            ipt.uid.setText(""+rs.getString("s_StudentNo"));      
            ipt.ln.setText(""+rs.getString("s_LastName"));
            ipt.fn.setText(""+rs.getString("s_FirstName"));
            ipt.mn.setText(""+rs.getString("s_MiddleName"));
            ipt.pr.setText(""+rs.getString("s_Program"));  
            ipt.st.setText(""+rs.getString("s_Section"));
            ipt.adds.setText(""+rs.getString("s_Address"));
            ipt.conNO.setText(""+rs.getString("Contact_no"));
            ipt.image.setIcon(ipt.ResizeImage(rs.getString("u_image"),null,ipt.image));
            ipt.setVisible(true);
            this.dispose();
            }
        }catch(SQLException ex){ 
           System.out.println(""+ex);
        }
     }
    }//GEN-LAST:event_PRINTMouseClicked

    private void PRINTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PRINTMouseEntered
     PRINT.setBackground(hovercolor); 
    }//GEN-LAST:event_PRINTMouseEntered

    private void PRINTMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PRINTMouseExited
      PRINT.setBackground(navcolor); 
    }//GEN-LAST:event_PRINTMouseExited

    private void p_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_deleteMouseClicked
    
       int rowindex = usersTable.getSelectedRow();
       if (rowindex < 0){
     JOptionPane.showMessageDialog(null, "Please select an item to delete!");
       }else{
    int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this record?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
    if(confirm == JOptionPane.YES_OPTION) { 
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    
    try {
      dbConnector DbConnector = new dbConnector();
      connection = DbConnector.getConnection(); 
      
      TableModel tbl = usersTable.getModel();
      String selectedid = tbl.getValueAt(rowindex,0).toString();
    
     String deleteQuery = "DELETE FROM studententry WHERE s_studentno = ?";
     preparedStatement = connection.prepareStatement(deleteQuery); 
     preparedStatement.setString(1, selectedid);
     
    int rowsAffected = preparedStatement.executeUpdate();
    
  if (rowsAffected > 0) {
  JOptionPane.showMessageDialog(null, "Record deleted successfully!");
  displayData();
    }else{
   JOptionPane.showMessageDialog(null, "No data found for the selected item.");
       }
   }catch(SQLException ex){
     JOptionPane.showMessageDialog(null, "Error deleting data: " + ex.getMessage());
    }finally{
        
    try{
       if(preparedStatement!= null){
     preparedStatement.close();
      }
       
       if(connection != null){
          connection.close();
      }
         }catch(SQLException ex){
          JOptionPane.showMessageDialog(null, "Error deleting data: " + ex.getMessage());
      }
       }
         }
           }
    
    }//GEN-LAST:event_p_deleteMouseClicked

    private void p_deleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_deleteMouseEntered
          p_delete.setBackground(hovercolor); 
    }//GEN-LAST:event_p_deleteMouseEntered

    private void p_deleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_deleteMouseExited
        p_delete.setBackground(navcolor); 
    }//GEN-LAST:event_p_deleteMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new usersForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ADD;
    private javax.swing.JPanel PRINT;
    private javax.swing.JLabel acc_id;
    private javax.swing.JLabel delete;
    private javax.swing.JLabel edit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel p_add;
    private javax.swing.JPanel p_delete;
    private javax.swing.JPanel p_edit;
    private javax.swing.JLabel print;
    public javax.swing.JTable usersTable;
    // End of variables declaration//GEN-END:variables
}
