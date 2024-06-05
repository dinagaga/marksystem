/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;



import config.dbConnector;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;



public class creationUserForm extends javax.swing.JFrame {

    public static String section,program;  

    public creationUserForm() {
        initComponents();
        
         Image img=new ImageIcon(this.getClass().getResource("/tb.jpg")).getImage();
        this.setIconImage(img);
    }
 
    public String destination ="";
    File selectedFile;
    public String oldpath;    
    public String path;  
    
    public int FileExistenceChecker(String path){
        File file = new File(path);
        String fileName = file.getName();
        
        Path filePath = Paths.get("src/userimages", fileName);
        boolean fileExists = Files.exists(filePath);
        
        if (fileExists) {
            return 1;
        } else {
            return 0;
        }
    
    }
    
    public static int getHeightFromWidth(String imagePath, int desiredWidth) {
        try {
            // Read the image file
            File imageFile = new File(imagePath);
            BufferedImage image = ImageIO.read(imageFile);
            
            // Get the original width and height of the image
            int originalWidth = image.getWidth();
            int originalHeight = image.getHeight();
            
            // Calculate the new height based on the desired width and the aspect ratio
            int newHeight = (int) ((double) desiredWidth / originalWidth * originalHeight);
            
            return newHeight;
        } catch (IOException ex) {
            System.out.println("No image found!");
        }
        
        return -1;
    }
    
    public  ImageIcon ResizeImage(String ImagePath, byte[] pic, JLabel label) {
    ImageIcon MyImage = null;
        if(ImagePath !=null){
            MyImage = new ImageIcon(ImagePath);
        }else{
            MyImage = new ImageIcon(pic);
        }
        
    int newHeight = getHeightFromWidth(ImagePath, label.getWidth());

    Image img = MyImage.getImage();
    Image newImg = img.getScaledInstance(label.getWidth(), newHeight, Image.SCALE_SMOOTH);
    ImageIcon image = new ImageIcon(newImg);
    return image;
}
    
    
    public void imageUpdater(String existingFilePath, String newFilePath){
        File existingFile = new File(existingFilePath);
        if (existingFile.exists()) {
            String parentDirectory = existingFile.getParent();
            File newFile = new File(newFilePath);
            String newFileName = newFile.getName();
            File updatedFile = new File(parentDirectory, newFileName);
            existingFile.delete();
            try {
                Files.copy(newFile.toPath(), updatedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Image updated successfully.");
            } catch (IOException e) {
                System.out.println("Error occurred while updating the image: "+e);
            }
        } else {
            try{
                Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
            }catch(IOException e){
                System.out.println("Error on update!");
            }
        }
   }

       public boolean updateCheck(){
        dbConnector dbc = new dbConnector();
          
        try{
        String query = "SELECT * FROM studententry  WHERE(s_Section ='"+st.getText()+"'OR s_Program='" + pr.getSelectedItem() + "')AND s_studentno!='"+uid.getText()+"'";
            ResultSet resultSet = dbc.getData(query);
             
             if(resultSet.next()){
              program = resultSet.getString("s_Program");
             if(program.equals(pr.getSelectedItem())){
            JOptionPane.showMessageDialog(null, "program IS VALID!");
            pr.setSelectedItem(""); 
           } 
         
            section = resultSet.getString("s_Section");  
           if(section.equals(st.getText())){
           JOptionPane.showMessageDialog(null, "section IS VALID!");
            st.setText("");
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
        lname = new javax.swing.JLabel();
        ln = new javax.swing.JTextField();
        Program = new javax.swing.JLabel();
        st = new javax.swing.JTextField();
        Section = new javax.swing.JLabel();
        address = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        adds = new javax.swing.JTextField();
        fn = new javax.swing.JTextField();
        studentno = new javax.swing.JLabel();
        fname = new javax.swing.JLabel();
        uid = new javax.swing.JTextField();
        update = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        remove = new javax.swing.JButton();
        select = new javax.swing.JButton();
        mname = new javax.swing.JLabel();
        mn = new javax.swing.JTextField();
        contactNo = new javax.swing.JLabel();
        conNO = new javax.swing.JTextField();
        pr = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        lname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lname.setText("Last Name:");

        ln.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N

        Program.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Program.setText("Progam:");

        st.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        st.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stActionPerformed(evt);
            }
        });

        Section.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Section.setText("Section:");

        address.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        address.setText("Address:");

        add.setBackground(new java.awt.Color(255, 255, 255));
        add.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        add.setText("ADD");
        add.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        adds.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        adds.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addsActionPerformed(evt);
            }
        });

        fn.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N

        studentno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        studentno.setText("Student NO:");

        fname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fname.setText("First Name:");

        uid.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        uid.setEnabled(false);

        update.setBackground(new java.awt.Color(255, 255, 255));
        update.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        update.setText("UPDATE");
        update.setEnabled(false);
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        cancel.setBackground(new java.awt.Color(255, 255, 255));
        cancel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cancel.setText("CANCEL");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        jPanel2.setLayout(null);
        jPanel2.add(image);
        image.setBounds(10, 10, 200, 180);

        remove.setBackground(new java.awt.Color(255, 255, 255));
        remove.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        remove.setText("REMOVE");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });

        select.setBackground(new java.awt.Color(255, 255, 255));
        select.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        select.setText("SELECT");
        select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectActionPerformed(evt);
            }
        });

        mname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mname.setText("Middle Name:");

        mn.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N

        contactNo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        contactNo.setText("Contact NO:");

        conNO.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        conNO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conNOActionPerformed(evt);
            }
        });

        pr.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BSIT\t", "BSBA", "BSHM", "BSCRIM" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(update))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(studentno)
                                    .addComponent(lname)
                                    .addComponent(fname)
                                    .addComponent(mname)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Section)
                                    .addComponent(Program)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(address)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ln, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(uid, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(mn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1))
                                    .addComponent(adds, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(conNO, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(pr, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(st, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(contactNo)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(select)
                                .addGap(18, 18, 18)
                                .addComponent(remove))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(cancel))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add)
                    .addComponent(update)
                    .addComponent(cancel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(studentno)
                            .addComponent(uid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lname)
                            .addComponent(ln, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fname)
                            .addComponent(fn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mname)
                            .addComponent(mn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Program, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Section)
                            .addComponent(st, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(address)
                            .addComponent(adds, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(contactNo)
                            .addComponent(conNO, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(remove)
                        .addComponent(select)))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
  
        if(ln.getText().isEmpty() || fn.getText().isEmpty() || mn.getText().isEmpty()
            || st.getText().isEmpty() || adds.getText().isEmpty()|| conNO.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "All fields are required!");
           }else if(updateCheck()){
            System.out.println("Duplicate Exist");
        }else{
 
        dbConnector dbc = new dbConnector();   
        dbc.updateData("UPDATE studententry SET s_LastName = '"+ln.getText()+"',s_FirstName ='"+fn.getText()+"',"
                + " s_MiddleName ='"+mn.getText()+"',s_Program ='"+pr.getSelectedItem()+"',"
                 + "s_Section ='"+st.getText()+"',"
                  + " s_Address ='"+adds.getText()+"',Contact_no ='"+conNO.getText()+"',u_image = '"+destination+"'WHERE s_studentno ='"+uid.getText()+"'");  
                 
               if(destination.isEmpty()){
                   File existingFile = new File(oldpath);
                   if(existingFile.exists()){
                       existingFile.delete();
                       }
               }else{
                   if(!(oldpath.equals(path))){
                     imageUpdater(oldpath,path);  
                       
                       
                   }
               }
        
               usersForm uf = new usersForm();
                uf.setVisible(true);
              this.dispose();
        }
    }//GEN-LAST:event_updateActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed

         if(ln.getText().isEmpty() || fn.getText().isEmpty() || mn.getText().isEmpty()
            || st.getText().isEmpty() || adds.getText().isEmpty()|| conNO.getText().isEmpty()|| destination.isEmpty()){
            JOptionPane.showMessageDialog(null, "All fields are required!");      
            }else{
             
            dbConnector dbc = new dbConnector();
            if (dbc.insertData("INSERT INTO studententry (s_LastName,s_FirstName,s_MiddleName,s_Program,s_Section,s_Address,Contact_no,u_image)"
                    + "VALUES('" + ln.getText() + "','" + fn.getText() + "','" + mn.getText() + "','" + pr.getSelectedItem() + "','"
                    + st.getText() + "','" + adds.getText()+ "','" + conNO.getText() + "','" + destination+"')"))
                
                try{ 
                    Files.copy(selectedFile.toPath(),new File(destination).toPath(),StandardCopyOption.REPLACE_EXISTING);
                    JOptionPane.showMessageDialog(null, "Add Successfully!");
                    usersForm uf = new usersForm();
                    uf.setVisible(true);
                    this.dispose();
   
                }catch(IOException ex){
                    System.out.println("Insert Image Error: "+ex);
                }else{       
            
                JOptionPane.showMessageDialog(null, "Failed!");
            
            }
         }

    
    }//GEN-LAST:event_addActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        usersForm usf= new usersForm();
        usf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
   remove.setEnabled(false);
   select.setEnabled(true);
   image.setIcon(null);
   destination ="";
   path ="";
    }//GEN-LAST:event_removeActionPerformed

    private void selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectActionPerformed
     JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    try {
                        selectedFile = fileChooser.getSelectedFile();
                        destination = "src/userimages/" + selectedFile.getName();
                        path  = selectedFile.getAbsolutePath();
                        
                        
                        if(FileExistenceChecker(path) == 1){
                          JOptionPane.showMessageDialog(null, "File Already Exist, Rename or Choose another!");
                            destination = "";
                            path="";
                        }else{
                            image.setIcon(ResizeImage(path, null, image));
                            select.setEnabled(false);                         
                            remove.setEnabled(true);
                        }
                    } catch (Exception ex) {
                        System.out.println("File Error!");
                    }
                }

    }//GEN-LAST:event_selectActionPerformed

    private void addsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addsActionPerformed

    private void stActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stActionPerformed

    private void conNOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conNOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_conNOActionPerformed
 
       

    public static void main(String args[]){
  
   
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new creationUserForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel Program;
    public javax.swing.JLabel Section;
    public javax.swing.JButton add;
    public javax.swing.JLabel address;
    public javax.swing.JTextField adds;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    public javax.swing.JButton cancel;
    public javax.swing.JTextField conNO;
    public javax.swing.JLabel contactNo;
    public javax.swing.JTextField fn;
    public javax.swing.JLabel fname;
    public javax.swing.JLabel image;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JTextField ln;
    public javax.swing.JLabel lname;
    public javax.swing.JTextField mn;
    public javax.swing.JLabel mname;
    public javax.swing.JComboBox<String> pr;
    public javax.swing.JButton remove;
    public javax.swing.JButton select;
    public javax.swing.JTextField st;
    public javax.swing.JLabel studentno;
    public javax.swing.JTextField uid;
    public javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
