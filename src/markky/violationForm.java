/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package markky;



import admin.*;
import config.Session;
import config.dbConnector;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;

public class violationForm extends javax.swing.JFrame {

   public static String section,program; 
   
    public violationForm() {
        initComponents();
        
         Image img=new ImageIcon(this.getClass().getResource("/tb.jpg")).getImage();
        this.setIconImage(img);
        
         displayData();  
         
    }
    
    public String id;
    boolean checkAdd = true;
 
    public String destination ="";
    File selectedFile;
    public String oldpath;    
    public String path;  
    
    public void displayData(){
        try{
            dbConnector dbc = new dbConnector();
            ResultSet rs = dbc.getData("SELECT student_no,s_name,s_program,s_section,ay_code,s_violation,s_sanction,s_type,u_image FROM violation" );
            violationTable.setModel(DbUtils.resultSetToTableModel(rs));
            update.setEnabled(false);
             rs.close();
        }catch(SQLException ex){
            System.out.println("Errors: "+ex.getMessage());
        
        }
        
    
    }
    
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
        String query = "SELECT * FROM violation  WHERE(s_section ='"+ST.getText()+"'OR s_program='" + PR.getSelectedItem() + "')AND student_no=!'"+sid.getText()+"'";
            ResultSet resultSet = dbc.getData(query);
             
             if(resultSet.next()){
                 program = resultSet.getString("s_program");
             if(program.equals(PR.getSelectedItem())){
            JOptionPane.showMessageDialog(null, "Program IS VALID!");
            PR.setSelectedItem(""); 
           } 
         
             section = resultSet.getString("s_section");  
           if(section.equals(ST.getText())){
           JOptionPane.showMessageDialog(null, "Section IS VALID!");
            ST.setText("");
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
        jSpinner1 = new javax.swing.JSpinner();
        scrollPane1 = new java.awt.ScrollPane();
        jPanel1 = new javax.swing.JPanel();
        PROGRAM = new javax.swing.JLabel();
        ST = new javax.swing.JTextField();
        SECTION = new javax.swing.JLabel();
        aycode = new javax.swing.JLabel();
        ayc = new javax.swing.JTextField();
        nm = new javax.swing.JTextField();
        studentno = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        sid = new javax.swing.JTextField();
        violation = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        sanction = new javax.swing.JLabel();
        type = new javax.swing.JLabel();
        vio = new javax.swing.JComboBox<>();
        san = new javax.swing.JComboBox<>();
        ty = new javax.swing.JComboBox<>();
        button1 = new java.awt.Button();
        Add = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        violationTable = new javax.swing.JTable();
        clear = new javax.swing.JButton();
        update = new javax.swing.JButton();
        sd = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        PR = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        select = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        PRINT = new javax.swing.JButton();
        delete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        PROGRAM.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        PROGRAM.setText("PROGRAM");

        ST.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        ST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                STActionPerformed(evt);
            }
        });

        SECTION.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        SECTION.setText("SECTION");

        aycode.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        aycode.setText("AYCODE");

        ayc.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        ayc.setText("2024-2025 2nd SEM");
        ayc.setEnabled(false);
        ayc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aycActionPerformed(evt);
            }
        });

        nm.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N

        studentno.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        studentno.setText("STUDENT NO.");

        name.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        name.setText("NAME");

        sid.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        sid.setText(" ");

        violation.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        violation.setText("VIOLATION");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("VIOLATION ENTRY");

        sanction.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        sanction.setText("SANCTION");

        type.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        type.setText("TYPE");

        vio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Threatening", "Cheating", "Alcohol", "Inappropriate touching", "Harassment", "Leaving the school premise without permission" }));
        vio.setToolTipText("");
        vio.setAutoscrolls(true);

        san.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st WARNING ", "2nd WARNING ", "3rd WARNING " }));

        ty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Minor Offense", "Major Offense" }));

        button1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        button1.setLabel("X");
        button1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button1MouseClicked(evt);
            }
        });

        Add.setBackground(new java.awt.Color(255, 255, 255));
        Add.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Add.setText("ADD");
        Add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddMouseClicked(evt);
            }
        });
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        violationTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        violationTable.setToolTipText("");
        violationTable.setDropMode(javax.swing.DropMode.ON);
        violationTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                violationTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(violationTable);

        clear.setBackground(new java.awt.Color(255, 255, 255));
        clear.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        clear.setText("CLEAR");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        update.setBackground(new java.awt.Color(255, 255, 255));
        update.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        update.setText("UPDATE");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        sd.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        sd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                sdKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setText("Search Data:");

        PR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BSIT", "BSCRIM", "BSBA", "BSHM" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(31, 31, 31)
                                .addComponent(sd, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(studentno)
                                    .addComponent(PROGRAM)
                                    .addComponent(SECTION)
                                    .addComponent(name))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(sid, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ST, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                    .addComponent(nm)
                                    .addComponent(PR, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(118, 118, 118)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sanction)
                            .addComponent(aycode)
                            .addComponent(violation)
                            .addComponent(type))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(vio, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ayc, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(ty, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(san, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Add)
                                .addGap(18, 18, 18)
                                .addComponent(update)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(clear)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 3, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1278, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(aycode)
                            .addComponent(ayc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(violation)
                            .addComponent(vio, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sanction)
                            .addComponent(san, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ty, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(type))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sd, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(sid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(studentno))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(name)
                                        .addGap(26, 26, 26)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(3, 3, 3)
                                                .addComponent(PR, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(PROGRAM, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SECTION)
                            .addComponent(ST, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(86, 86, 86)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jPanel3.setLayout(null);
        jPanel3.add(image);
        image.setBounds(10, 10, 200, 180);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        select.setBackground(new java.awt.Color(255, 255, 255));
        select.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        select.setText("SELECT");
        select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectActionPerformed(evt);
            }
        });

        remove.setBackground(new java.awt.Color(255, 255, 255));
        remove.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        remove.setText("REMOVE");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });

        PRINT.setBackground(new java.awt.Color(255, 255, 255));
        PRINT.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        PRINT.setText("PRINT");
        PRINT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRINTActionPerformed(evt);
            }
        });

        delete.setBackground(new java.awt.Color(255, 255, 255));
        delete.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PRINT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(select, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(remove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(52, 52, 52))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(remove)
                    .addComponent(select))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PRINT)
                    .addComponent(delete))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void aycActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aycActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aycActionPerformed

    private void STActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_STActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_STActionPerformed

    private void button1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button1MouseClicked
         adminDashboard ds = new adminDashboard();
        ds.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_button1MouseClicked

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
       int rowindex = violationTable.getSelectedRow();
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
      
      TableModel tbl = violationTable.getModel();
      String selectedid = tbl.getValueAt(rowindex,0).toString();
    
     String deleteQuery = "DELETE FROM violation WHERE student_no = ?";
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
     
    }//GEN-LAST:event_deleteActionPerformed

    private void PRINTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRINTActionPerformed
       int rowlndex = violationTable.getSelectedRow();
     if(rowlndex <0){
        JOptionPane.showMessageDialog(null,"Please select an item!");
     }else{        
        try{
            dbConnector dbc =  new dbConnector();
            TableModel tbl = violationTable.getModel();
            ResultSet rs = dbc.getData("SELECT * FROM violation WHERE student_no  ="+tbl.getValueAt(rowlndex,0)+"");
            if(rs.next()){
            violationPrinting vpt = new violationPrinting();
            vpt.uid.setText(""+rs.getString("student_no"));      
            vpt.nm.setText(""+rs.getString("s_name"));
            vpt.pr.setText(""+rs.getString("s_program"));
            vpt.st.setText(""+rs.getString("s_section"));
            vpt.ayc.setText(""+rs.getString("ay_code"));  
            vpt.vio.setText(""+rs.getString("s_violation"));
            vpt.san.setText(""+rs.getString("s_sanction"));
            vpt.ty.setText(""+rs.getString("s_type"));
            vpt.image.setIcon(vpt.ResizeImage(rs.getString("u_image"),null,vpt.image));
            vpt.setVisible(true);
            this.dispose();
            }
        }catch(SQLException ex){ 
           System.out.println(""+ex);
        }
     }
    }//GEN-LAST:event_PRINTActionPerformed

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

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        remove.setEnabled(false);
        select.setEnabled(true);
        image.setIcon(null);
        destination ="";
        path ="";
    }//GEN-LAST:event_removeActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        checkAdd = true;
        sid.setText("");
        nm.setText("");
        PR.setSelectedItem("");
        ST.setText("");
        vio.setSelectedItem("");
        san.setSelectedItem("");
        ty.setSelectedItem("");
        image.setIcon(null);
    }//GEN-LAST:event_clearActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        if(sid.getText() == null ) {
    JOptionPane.showMessageDialog(null, "Please select list first");
} else {      
    if(nm.getText().isEmpty() || ST.getText().isEmpty()|| vio.getSelectedItem() == null || toString().isEmpty()
            || san.getSelectedItem() == null || toString().isEmpty() || ty.getSelectedItem() == null
            || toString().isEmpty()){
        JOptionPane.showMessageDialog(null, "All fields are required!");    
        
        
    } else {
        dbConnector dbc = new dbConnector();   
        dbc.updateData("UPDATE violation SET s_name = '"+nm.getText()+"', s_program ='"+PR.getSelectedItem()+"',"
                + " s_section ='"+ST.getText()+"', ay_code ='"+ayc.getText()+"',"
                + " s_violation ='"+vio.getSelectedItem()+"',"
                + " s_sanction ='"+san.getSelectedItem()+"', s_type ='"+ty.getSelectedItem()+"', u_image = '"+destination+"' WHERE student_no ='"+sid.getText()+"'");           

        // Refresh the displayed data after the update
        displayData();
                
        try { 
            // Copy the selected file to the destination
            Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);              

            // Show success message
            JOptionPane.showMessageDialog(null, "Updated Successfully!");  

            // Open the violation form
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
        
            
            
          
            // Set the selected items in the combo boxes
            vio.setSelectedItem(vio.getSelectedItem());
            san.setSelectedItem(san.getSelectedItem());
            ty.setSelectedItem(ty.getSelectedItem());

        }catch(IOException ex){
            // Handle IO exception
            System.out.println("Insert Image Error: "+ex);
            JOptionPane.showMessageDialog(null, "Clear The field First !");    
                     
            checkAdd = true;
            sid.setText("");
            nm.setText("");
            PR.setSelectedItem("");
            ST.setText("");             
            vio.setSelectedIndex(0);
            san.setSelectedIndex(0);
            ty.setSelectedIndex(0);
            image.setIcon(null);     
            
           
        }
    }
}

    }//GEN-LAST:event_updateActionPerformed

    private void violationTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_violationTableMouseClicked
       int rowlndex = violationTable.getSelectedRow();
     if(rowlndex <0){
        JOptionPane.showMessageDialog(null,"Please select an item!");
     }else{   
         
        try{
          
            dbConnector dbc =  new dbConnector();
            TableModel tbl = violationTable.getModel();
            ResultSet rs = dbc.getData("SELECT * FROM violation WHERE student_no ="+tbl.getValueAt(rowlndex,0)+"");
            if(rs.next()){    
            sid.setText(""+rs.getString("student_no"));        
            nm.setText(""+rs.getString("s_name"));
            PR.setSelectedItem(""+rs.getString("s_program"));
            ST.setText(""+rs.getString("s_section"));
            ayc.setText(""+rs.getString("ay_code"));
            vio.setSelectedItem(""+rs.getString("s_violation")); 
            san.setSelectedItem(""+rs.getString("s_sanction"));    
            ty.setSelectedItem(""+rs.getString("s_type"));
            image.setIcon(ResizeImage(rs.getString("u_image"),null,image));      
            Add.setEnabled(false);
            checkAdd = false;
            update.setEnabled(true);
            }
        }catch(SQLException ex){ 
           System.out.println(""+ex);
        }
     }
    }//GEN-LAST:event_violationTableMouseClicked

    private void sdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sdKeyReleased
        DefaultTableModel ob= (DefaultTableModel) violationTable.getModel();
        TableRowSorter<DefaultTableModel> obj=new TableRowSorter<>(ob);
        violationTable.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(sd.getText()));
        
    }//GEN-LAST:event_sdKeyReleased

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        
        
       if (checkAdd) {
            if (nm.getText().isEmpty() || PR.getSelectedItem() == null || ST.getText().isEmpty()
                || sid.getText().isEmpty() || vio.getSelectedItem() == null || toString().isEmpty()
                || san.getSelectedItem() == null || toString().isEmpty() || ty.getSelectedItem() == null
                || toString().isEmpty() || destination.isEmpty()){
                JOptionPane.showMessageDialog(null, "All fields are required!");

            } else {
                dbConnector dbc = new dbConnector();
                if (dbc.insertData("INSERT INTO violation (student_no,s_name,s_program,s_section,ay_code,s_violation,s_sanction,s_type,u_image)"
                    + "VALUES('" + sid.getText() + "','" + nm.getText() + "','" + PR.getSelectedItem() + "','" + ST.getText() + "','"
                    + ayc.getText() + "','" + vio.getSelectedItem().toString() + "','" + san.getSelectedItem().toString() + "','" + ty.getSelectedItem().toString() + "','" + destination + "')")) {
                displayData();

                try {
                    Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
                    JOptionPane.showMessageDialog(null, "Add Successfully!");
                    violationForm vifff = new violationForm();
                    vifff.setVisible(true);
                    this.dispose();
                } catch (IOException ex) {
                    System.out.println("Insert Image Error: " + ex);
                }
                checkAdd = true;
                sid.setText("");
                nm.setText("");
                PR.setSelectedIndex(0);
                ST.setText("");
                vio.setSelectedIndex(0);
                san.setSelectedIndex(0);
                ty.setSelectedIndex(0);
                update.setEnabled(true);

            } else {
                JOptionPane.showMessageDialog(null, "Failed to add data to the database.");
            }
        }
        }
    }//GEN-LAST:event_AddActionPerformed

    private void AddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_AddMouseClicked
 
    public static void main(String args[]){
  
   
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new violationForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Add;
    public javax.swing.JComboBox<String> PR;
    public javax.swing.JButton PRINT;
    public javax.swing.JLabel PROGRAM;
    public javax.swing.JLabel SECTION;
    public javax.swing.JTextField ST;
    public javax.swing.JTextField ayc;
    public javax.swing.JLabel aycode;
    private java.awt.Button button1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    public javax.swing.JButton clear;
    public javax.swing.JButton delete;
    public javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    public javax.swing.JLabel name;
    public javax.swing.JTextField nm;
    public javax.swing.JButton remove;
    public javax.swing.JComboBox<String> san;
    public javax.swing.JLabel sanction;
    private java.awt.ScrollPane scrollPane1;
    private javax.swing.JTextField sd;
    public javax.swing.JButton select;
    private javax.swing.JTextField sid;
    public javax.swing.JLabel studentno;
    public javax.swing.JComboBox<String> ty;
    public javax.swing.JLabel type;
    public javax.swing.JButton update;
    public javax.swing.JComboBox<String> vio;
    public javax.swing.JLabel violation;
    public javax.swing.JTable violationTable;
    // End of variables declaration//GEN-END:variables
}
