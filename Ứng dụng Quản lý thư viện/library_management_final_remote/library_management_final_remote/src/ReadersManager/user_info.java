package ReadersManager;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.table.TableModel;

public class user_info extends javax.swing.JFrame {

   Connection conn =null;
   PreparedStatement ps = null;
   ResultSet rs = null;
   
    public user_info() {
        initComponents();
        loadDataCB();
        showUser();
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Reader Info");
    }
    
    public ArrayList<User> userList(){
        ArrayList<User> userList = new ArrayList<>();
        try{
           conn = DriverManager.getConnection("jdbc:mysql://sql6.freemysqlhosting.net:3306/sql6424812?useUnicode=true&characterEncoding=UTF-8", "sql6424812","iNCTFpyiiJ");
           String sql = "SELECT * FROM thedocgia";
           ps = conn.prepareStatement(sql); 
           rs = ps.executeQuery();
           User user;
           
           while (rs.next()){
            user= new User (rs.getInt("MADOCGIA"), rs.getString("HOTEN"), rs.getInt("MALOAIDOCGIA"), rs.getString("DIACHI"),rs.getString("EMAIL"),rs.getString("NGAYSINH"),rs.getString("NGAYLAPTHE") ,rs.getString("NGAYHETHAN"), rs.getDouble("TONGNODOCGIA") );
            userList.add(user);
        }
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        return userList;
    }

    private void reload(){
       idUser.setText("");
       nameUser.setText("");
       kindOfUser.setSelectedItem(1);
       address.setText("");
       email.setText("");
       dayCreate.setDate(null);
        dayOfBirth.setDate(null);
    }
    public void showUser(){
       
        String pattern = "###,###.###";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        
        ArrayList<User> list = userList();
        //int s = list.get(WIDTH).getKind();
        //check(s);
        DefaultTableModel model = (DefaultTableModel)userTable.getModel();
        Object[] row = new Object[9];
        for(int i=0; i<list.size();i++){
            row[0]= list.get(i).getId();
            row[1]= list.get(i).getName();
            int s = list.get(i).getKind();
           // check(s);
            row[2]= list.get(i).check(s);
            row[3]= list.get(i).getAddress();
            row[4]= list.get(i).getEmail();
            row[5]= list.get(i).getDayBirth();
            row[6]= list.get(i).getDayCre();
            row[7]= list.get(i).getDayExpiry();
            row[8]= decimalFormat.format(list.get(i).getDebt());
            model.addRow(row);
        }
     
        
    }
    
    
//    public void executeQuery(String query, String mess){
//        try{
//        conn = DriverManager.getConnection("jdbc:mysql://sql6.freemysqlhosting.net:3306/sql6424812?useUnicode=true&characterEncoding=UTF-8", "sql6424812","iNCTFpyiiJ");
//        Statement st;
//        st = (Statement) conn.createStatement();
//        if((st.executeUpdate(query))==1){
//            
//            JOptionPane.showMessageDialog(null, "Xóa thẻ độc giả thành công!");
//            
//            
//        }else{
//            JOptionPane.showMessageDialog(null, "Vui lòng chọn thẻ độc giả muốn xóa!");
//        }
//        
//        
//        }catch (Exception ex){
//            //JOptionPane.showMessageDialog(null, ex);
//            ex.printStackTrace();
//        }
//        
//    }
            
    
    public void loadDataCB(){
        
        String sql = "SELECT * FROM loaidocgia";
        try{    
        conn = DriverManager.getConnection("jdbc:mysql://sql6.freemysqlhosting.net:3306/sql6424812?useUnicode=true&characterEncoding=UTF-8", "sql6424812","iNCTFpyiiJ");
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        while(rs.next()){
            this.kindOfUser.addItem(rs.getString("TENLOAIDOCGIA"));           
        }  
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jFrame3 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanelInput = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        idUser = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        address = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        nameUser = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        addBtt = new javax.swing.JButton();
        updateBtt = new javax.swing.JButton();
        deleteBtt = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        idSearch = new javax.swing.JTextField();
        kindOfUser = new javax.swing.JComboBox<>();
        dayOfBirth = new com.toedter.calendar.JDateChooser();
        dayCreate = new com.toedter.calendar.JDateChooser();
        jScrollPane3 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

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

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame3Layout = new javax.swing.GroupLayout(jFrame3.getContentPane());
        jFrame3.getContentPane().setLayout(jFrame3Layout);
        jFrame3Layout.setHorizontalGroup(
            jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame3Layout.setVerticalGroup(
            jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(138, 182, 214));

        jLabel1.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(251, 224, 196));
        jLabel1.setText("READERS MANAGER");

        jPanelInput.setBackground(new java.awt.Color(251, 224, 196));

        jLabel2.setFont(new java.awt.Font("Rockwell", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(138, 182, 214));
        jLabel2.setText("ID: ");

        idUser.setEditable(false);
        idUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idUserActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Rockwell", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(138, 182, 214));
        jLabel3.setText("Name: ");

        jLabel4.setFont(new java.awt.Font("Rockwell", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(138, 182, 214));
        jLabel4.setText("Kind of reader: ");

        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });

        nameUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameUserActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Rockwell", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(138, 182, 214));
        jLabel5.setText("Address");

        jLabel6.setFont(new java.awt.Font("Rockwell", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(138, 182, 214));
        jLabel6.setText("Email: ");

        jLabel7.setFont(new java.awt.Font("Rockwell", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(138, 182, 214));
        jLabel7.setText("Date of birth:");

        jLabel8.setFont(new java.awt.Font("Rockwell", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(138, 182, 214));
        jLabel8.setText("Date create: ");

        addBtt.setBackground(new java.awt.Color(138, 182, 214));
        addBtt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        addBtt.setText("Add");
        addBtt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBttActionPerformed(evt);
            }
        });

        updateBtt.setBackground(new java.awt.Color(138, 182, 214));
        updateBtt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        updateBtt.setText("Update");
        updateBtt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBttActionPerformed(evt);
            }
        });

        deleteBtt.setBackground(new java.awt.Color(138, 182, 214));
        deleteBtt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        deleteBtt.setText("Delete");
        deleteBtt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBttActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Rockwell", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(138, 182, 214));
        jLabel9.setText("Search(ID):");

        idSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                idSearchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                idSearchKeyReleased(evt);
            }
        });

        kindOfUser.setToolTipText("");
        kindOfUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kindOfUserActionPerformed(evt);
            }
        });

        dayOfBirth.setDateFormatString("yyyy-MM-dd");
        dayOfBirth.setFocusTraversalPolicyProvider(true);

        dayCreate.setDateFormatString("yyyy-MM-dd");

        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã độc giả", "Họ tên", "Loại độc giả", "Địa chỉ", "Email", "Ngày sinh", "Ngày lập thẻ", "Ngày hết hạn", "Tổng nợ"
            }
        ));
        userTable.setDragEnabled(true);
        userTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(userTable);

        jButton1.setBackground(new java.awt.Color(138, 182, 214));
        jButton1.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jButton1.setText("Clear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelInputLayout = new javax.swing.GroupLayout(jPanelInput);
        jPanelInput.setLayout(jPanelInputLayout);
        jPanelInputLayout.setHorizontalGroup(
            jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInputLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInputLayout.createSequentialGroup()
                        .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelInputLayout.createSequentialGroup()
                                .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(idUser, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanelInputLayout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nameUser, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelInputLayout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(addBtt, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(20, 20, 20))
                            .addComponent(idSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9))
                    .addComponent(dayCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanelInputLayout.createSequentialGroup()
                            .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(kindOfUser, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dayOfBirth, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)))
                        .addGroup(jPanelInputLayout.createSequentialGroup()
                            .addComponent(updateBtt, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                            .addGap(62, 62, 62)
                            .addComponent(deleteBtt, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanelInputLayout.setVerticalGroup(
            jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInputLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kindOfUser, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(idUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nameUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dayOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelInputLayout.createSequentialGroup()
                        .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6)))
                        .addGap(21, 21, 21)
                        .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(dayCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(deleteBtt)
                                .addComponent(updateBtt)
                                .addComponent(addBtt)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(idSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(267, 267, 267)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(213, Short.MAX_VALUE))
            .addComponent(jPanelInput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void userTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTableMouseClicked
       
        int i = userTable.getSelectedRow();
       TableModel model = userTable.getModel();
       idUser.setText(model.getValueAt(i, 0).toString());
       nameUser.setText(model.getValueAt(i, 1).toString());
       kindOfUser.setSelectedItem(model.getValueAt(i, 2).toString());
       address.setText(model.getValueAt(i, 3).toString());
       email.setText(model.getValueAt(i, 4).toString());
       try {
           Date date =  new SimpleDateFormat("dd/MM/yyyy").parse((String)model.getValueAt(i, 5).toString());
           dayOfBirth.setDate(date);
       } catch (ParseException ex) {
           Logger.getLogger(user_info.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       try {
           Date date =  new SimpleDateFormat("dd/MM/yyyy").parse((String)model.getValueAt(i, 6).toString());
           dayCreate.setDate(date);
       } catch (ParseException ex) {
           Logger.getLogger(user_info.class.getName()).log(Level.SEVERE, null, ex);
       }
      
    }//GEN-LAST:event_userTableMouseClicked

    private void idSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idSearchKeyReleased
        try{
            //String sql = "SELECT * FROM thedocgia WHERE HOTEN LIKE '%" + idSearch.getText() + "%'";
            String sql = "SELECT * FROM thedocgia WHERE MADOCGIA ='"+idSearch.getText()+"'";//+",HOTEN ='"+idSearch.getText()+"'";
            conn = DriverManager.getConnection("jdbc:mysql://sql6.freemysqlhosting.net:3306/sql6424812?useUnicode=true&characterEncoding=UTF-8", "sql6424812","iNCTFpyiiJ");
            ps = conn.prepareStatement(sql);

            //       rs = ps.executeQuery(sql);
            //       jTable2.setModel(DbUtils.resultSetToTableModel(rs));
            //       conn.close();
            //
            ////       ps.setString(1, idSearch.getText());
            rs = ps.executeQuery();
            userTable.setModel(DbUtils.resultSetToTableModel(rs));
            ps.close();
            if (idSearch.getText().equals("")){

                showUser();
            }
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }

    }//GEN-LAST:event_idSearchKeyReleased

    private void idSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idSearchKeyPressed

    }//GEN-LAST:event_idSearchKeyPressed

    private void deleteBttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBttActionPerformed
        //       if(idUser.getText().equals("")){
            //           JOptionPane.showMessageDialog(null, "Vui lòng chọn độc giả muốn xóa!");
            //       }else{
            if(idUser.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please choose choose reader you want to delete!");
            }else{
                int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to delete?", "Notice", JOptionPane.YES_NO_OPTION);
                if(dialogResult == JOptionPane.YES_OPTION){

                    try{
                        conn = DriverManager.getConnection("jdbc:mysql://sql6.freemysqlhosting.net:3306/sql6424812?useUnicode=true&characterEncoding=UTF-8", "sql6424812","iNCTFpyiiJ");
                        Statement st;
                        String s= "DELETE FROM `thedocgia` WHERE MADOCGIA LIKE '%" + idUser.getText() + "%'";
                        st = (Statement) conn.createStatement();
                        if((st.executeUpdate(s))==1){

                            JOptionPane.showMessageDialog(null, "Delete successfully!");

                        }else{
                            JOptionPane.showMessageDialog(null, "Xóa không thành công!");
                        }

                    }catch (Exception ex){
                        //JOptionPane.showMessageDialog(null, ex);
                        ex.printStackTrace();
                    }
                    reload();
                    DefaultTableModel model = (DefaultTableModel)userTable.getModel();
                    model.setRowCount(0);
                    showUser();
                }

                
            }
    }//GEN-LAST:event_deleteBttActionPerformed

    private void updateBttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBttActionPerformed

        DefaultTableModel model = (DefaultTableModel)userTable.getModel();
     int select = userTable.getSelectedRow();
          
     if(select == -1){
          JOptionPane.showMessageDialog(null, "Please choose the reader you want to update!");
     }else{
        try {
            String sql =  "UPDATE thedocgia SET  HOTEN = ?,DIACHI = ?,EMAIL = ?,NGAYSINH = ?,NGAYLAPTHE = ?,NGAYHETHAN = ?, TONGNODOCGIA = ?,MALOAIDOCGIA = ? where MADOCGIA = ?";

            conn = DriverManager.getConnection("jdbc:mysql://sql6.freemysqlhosting.net:3306/sql6424812?useUnicode=true&characterEncoding=UTF-8", "sql6424812","iNCTFpyiiJ");
            ps = conn.prepareStatement(sql);
            ps.setString(1, nameUser.getText());
            ps.setString(2, address.getText());
            ps.setString(3, email.getText());

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            String dayB = sdf.format(dayOfBirth.getDate());
            ps.setString(4, dayB.toString());
            String dayCre = sdf.format(dayCreate.getDate());
            ps.setString(5, dayCre.toString());

            Date expiryDateF = new SimpleDateFormat("dd/MM/yyyy").parse(dayCre);
            Calendar cal = Calendar.getInstance();
            cal.setTime(expiryDateF);
            cal.add(Calendar.MONTH, 6); // Add 6 months
            expiryDateF = cal.getTime();
            String dayC = sdf.format(expiryDateF) ;
            ps.setString(6,dayC);

            ps.setString(7, "0");

            String temp =  kindOfUser.getSelectedItem().toString();
            if(temp.equals("X"))
            {
                ps.setString(8, "1");
            }else{
                ps.setString(8, "2");
            }
            ps.setString(9, idUser.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Update successfully!");
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        reload();
        model.setRowCount(0);
        showUser();
     }
    }//GEN-LAST:event_updateBttActionPerformed

    public static boolean isEmailValid(String email) {
      String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
      return email.matches(regex);
   }    
    
    private void addBttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBttActionPerformed
        if(nameUser.getText().equals("") ||nameUser.getText().equals("")||address.getText().equals("")||email.getText().equals(null)||dayOfBirth.getDateFormatString().equals(null)||dayCreate.getDateFormatString().equals("") ){
            JOptionPane.showMessageDialog(null, "Please enter full information!");
        }
            
        else if (!isEmailValid(email.getText().trim())) {
            JOptionPane.showMessageDialog(null, "Email is invalid! Please try again");    
             
        }else{

            try {
                String sql =  "INSERT INTO thedocgia"
                + "( HOTEN, DIACHI, EMAIL, NGAYSINH, NGAYLAPTHE,NGAYHETHAN,TONGNODOCGIA,MALOAIDOCGIA) "
                +"VALUES (?,?,?,?,?,?,?,?)";
                conn = DriverManager.getConnection("jdbc:mysql://sql6.freemysqlhosting.net:3306/sql6424812?useUnicode=true&characterEncoding=UTF-8", "sql6424812","iNCTFpyiiJ");
                ps = conn.prepareStatement(sql);
                ps.setString(1, nameUser.getText());
                ps.setString(2, address.getText());
                ps.setString(3, email.getText().trim());

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                String dayB = sdf.format(dayOfBirth.getDate());
                ps.setString(4, dayB.toString());
                String dayCre = sdf.format(dayCreate.getDate());
                ps.setString(5, dayCre.toString());

                Date expiryDateF = new SimpleDateFormat("dd/MM/yyyy").parse(dayCre);
                Calendar cal = Calendar.getInstance();
                cal.setTime(expiryDateF);
                cal.add(Calendar.MONTH, 6); // Add 6 months
                expiryDateF = cal.getTime();
                String dayC = sdf.format(expiryDateF) ;
                ps.setString(6,dayC);

                ps.setString(7, "0");

                String temp =  kindOfUser.getSelectedItem().toString();
                if(temp.equals("X"))
                {
                    ps.setString(8, "1");
                }else{
                    ps.setString(8, "2");
                }
              
                
               Date expiryDateB = new SimpleDateFormat("dd/MM/yyyy").parse(dayB);
               Calendar calBirth = Calendar.getInstance();
               calBirth.setTime(expiryDateB);
               int a = cal.get(Calendar.YEAR) -1;
               int b = calBirth.get(Calendar.YEAR) -1;
               
                if( a-b-1 < 18 ||  a-b-1 > 55){
                    JOptionPane.showMessageDialog(null,"The age of reader must be over 18 and less than 55!");
                }else{
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Add successfully!");
                }  
                
            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(null, ex);
            }
            reload();
            DefaultTableModel model = (DefaultTableModel)userTable.getModel();
            model.setRowCount(0);
            showUser();
        }
    }//GEN-LAST:event_addBttActionPerformed

    private void nameUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameUserActionPerformed

    }//GEN-LAST:event_nameUserActionPerformed

    private void idUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idUserActionPerformed

    }//GEN-LAST:event_idUserActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        ImageIcon icon = new ImageIcon(this.getClass().getClassLoader().getResource("assets/readers.png"));
        setIconImage(icon.getImage());       
    }//GEN-LAST:event_formWindowActivated

    private void kindOfUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kindOfUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kindOfUserActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        reload();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new user_info().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtt;
    private javax.swing.JTextField address;
    private com.toedter.calendar.JDateChooser dayCreate;
    private com.toedter.calendar.JDateChooser dayOfBirth;
    private javax.swing.JButton deleteBtt;
    private javax.swing.JTextField email;
    private javax.swing.JTextField idSearch;
    private javax.swing.JTextField idUser;
    private javax.swing.JButton jButton1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JFrame jFrame3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelInput;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JComboBox<String> kindOfUser;
    private javax.swing.JTextField nameUser;
    private javax.swing.JButton updateBtt;
    private javax.swing.JTable userTable;
    // End of variables declaration//GEN-END:variables
}
