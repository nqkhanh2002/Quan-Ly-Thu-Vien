
package DebtNote;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
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
import javax.swing.table.TableModel;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
/**
 *
 * @author ASUS
 */
public class DebtNote extends javax.swing.JFrame {
   Connection conn =null;
   PreparedStatement ps = null;
   ResultSet rs = null;

    public DebtNote() {
     
        initComponents();
        showUser();
        jTextFieldId.setVisible(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Fine Receipts");
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
    }
    
    public static String removeVietnameseLetters(String str) {
    str = str.replaceAll("à|á|ạ|ả|ã|â|ầ|ấ|ậ|ẩ|ẫ|ă|ằ|ắ|ặ|ẳ|ẵ", "a");
    str = str.replaceAll("è|é|ẹ|ẻ|ẽ|ê|ề|ế|ệ|ể|ễ", "e");
    str = str.replaceAll("ì|í|ị|ỉ|ĩ", "i");
    str = str.replaceAll("ò|ó|ọ|ỏ|õ|ô|ồ|ố|ộ|ổ|ỗ|ơ|ờ|ớ|ợ|ở|ỡ", "o");
    str = str.replaceAll("ù|ú|ụ|ủ|ũ|ư|ừ|ứ|ự|ử|ữ", "u");
    str = str.replaceAll("ỳ|ý|ỵ|ỷ|ỹ", "y");
    str = str.replaceAll("đ", "d");
    str = str.replaceAll("À|Á|Ạ|Ả|Ã|Â|Ầ|Ấ|Ậ|Ẩ|Ẫ|Ă|Ằ|Ắ|Ặ|Ẳ|Ẵ", "A");
    str = str.replaceAll("È|É|Ẹ|Ẻ|Ẽ|Ê|Ề|Ế|Ệ|Ể|Ễ", "E");
    str = str.replaceAll("Ì|Í|Ị|Ỉ|Ĩ", "I");
    str = str.replaceAll("Ò|Ó|Ọ|Ỏ|Õ|Ô|Ồ|Ố|Ộ|Ổ|Ỗ|Ơ|Ờ|Ớ|Ợ|Ở|Ỡ", "O");
    str = str.replaceAll("Ù|Ú|Ụ|Ủ|Ũ|Ư|Ừ|Ứ|Ự|Ử|Ữ", "U");
    str = str.replaceAll("Ỳ|Ý|Ỵ|Ỷ|Ỹ", "Y");
    str = str.replaceAll("Đ", "D");
    return str;
}
    
    public void printBill(){
        String name = removeVietnameseLetters(jTextFieldNameDebt.getText());
        String debt = jTextFieldDebt.getText();
        String money = jTextFieldMoney.getText();
        String rest = jTextFieldRest.getText();
        String id = jTextFieldId.getText();
        
        String path = "D:\\";
                        Document doc = new Document() {};
                        try{
                            PdfWriter.getInstance(doc, new FileOutputStream(path+"PHIEUTHUNODOCGIASO"+id+".pdf"));
                            doc.open();
                            Paragraph p1 = new Paragraph("                                           FINE RECEIPTS\n");
                            doc.add(p1);
                            Paragraph p2 = new Paragraph("                      ****************************************************************************");
                            doc.add(p2);
                            Paragraph p3 = new Paragraph("\t    *Information " + "\nName: "+name +"\nTotal debt: "+ debt);
                            doc.add(p3);
                            doc.add(p2);
                            Paragraph p5 = new Paragraph("\t    *Details " + "\nPaid Money : "+money +"\nTotal Remaining Debt: "+rest+"vnd");
                            doc.add(p5);
                            doc.add(p2);
   
                            doc.add(p2);

                        }
                        catch(Exception e){
                            JOptionPane.showMessageDialog(null, e);
                        }
                        doc.close();
                        int a = JOptionPane.showConfirmDialog(null, "Do you want to print the bill?", "Info", JOptionPane.YES_NO_OPTION);
                        
                        if (a == 0){
                            try
                            {
                                if ((new File(path+"PHIEUTHUNODOCGIASO"+id+".pdf")).exists()){
                                    Process p = Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " +"D:\\"+id+".pdf");
                                    
                                }else{
                                    JOptionPane.showMessageDialog(null, "File isn't exist.");
                                }
                            }
                            catch(Exception e)
                            {
                                JOptionPane.showMessageDialog(null, e);
                            }
                        }
    }
    
    
    
    
    public ArrayList<DebtList> debtLists(){
        ArrayList<DebtList> debtLists = new ArrayList<>();
        try{
           conn = DriverManager.getConnection("jdbc:mysql://sql6.freemysqlhosting.net:3306/sql6424812?useUnicode=true&characterEncoding=UTF-8", "sql6424812","iNCTFpyiiJ");
           String sql = "SELECT * FROM thedocgia";
           ps = conn.prepareStatement(sql); 
           rs = ps.executeQuery();
           DebtList debt;
           
           while (rs.next()){
            debt= new DebtList (rs.getInt("MADOCGIA"), rs.getString("HOTEN"), rs.getInt("TONGNODOCGIA") );
            if(rs.getInt("TONGNODOCGIA") != 0){
            debtLists.add(debt);
            }
         }
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        return debtLists;
    }
    public void showUser(){
       
        ArrayList<DebtList> list = debtLists();
        //int s = list.get(WIDTH).getKind();
        //check(s);
        DefaultTableModel model = (DefaultTableModel)jTableDebt.getModel();
        Object[] row = new Object[9];
        for(int i=0; i<list.size();i++){
            row[0]= list.get(i).getId();
            row[1]= list.get(i).getName();
            row[2]= list.get(i).getDebt();
            model.addRow(row);
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanelDebt = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDebt = new javax.swing.JTable();
        jTextFieldNameDebt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldDebt = new javax.swing.JTextField();
        jTextFieldMoney = new javax.swing.JTextField();
        jTextFieldRest = new javax.swing.JTextField();
        jButtonAddDebt = new javax.swing.JButton();
        jButtonReload = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButtonReload1 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new javax.swing.ImageIcon(getClass().getClassLoader().getResource("assets/fine_receipts.png")).getImage());

        jPanelDebt.setBackground(new java.awt.Color(251, 224, 196));

        jTableDebt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên độc giả", "Tổng nợ"
            }
        ));
        jTableDebt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDebtMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableDebt);

        jTextFieldNameDebt.setEditable(false);
        jTextFieldNameDebt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNameDebtActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(138, 182, 214));
        jLabel1.setText("Name:");

        jLabel3.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(138, 182, 214));
        jLabel3.setText("Paid Money: ");

        jTextFieldDebt.setEditable(false);
        jTextFieldDebt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDebtActionPerformed(evt);
            }
        });

        jTextFieldMoney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMoneyActionPerformed(evt);
            }
        });
        jTextFieldMoney.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldMoneyKeyPressed(evt);
            }
        });

        jTextFieldRest.setEditable(false);
        jTextFieldRest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldRestActionPerformed(evt);
            }
        });

        jButtonAddDebt.setBackground(new java.awt.Color(138, 182, 214));
        jButtonAddDebt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonAddDebt.setText("Add fine receipts");
        jButtonAddDebt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddDebtActionPerformed(evt);
            }
        });

        jButtonReload.setBackground(new java.awt.Color(138, 182, 214));
        jButtonReload.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonReload.setText("Clear");
        jButtonReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReloadActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(138, 182, 214));

        jLabel2.setBackground(new java.awt.Color(138, 182, 214));
        jLabel2.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("FINE RECEIPTS");

        jTextFieldId.setText(" ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4))
        );

        jLabel7.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(138, 182, 214));
        jLabel7.setText("Total Debt: ");

        jLabel8.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(138, 182, 214));
        jLabel8.setText("Total Remaining Debt:");
        jLabel8.setToolTipText("");

        jButtonReload1.setBackground(new java.awt.Color(138, 182, 214));
        jButtonReload1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonReload1.setText("Calculate");
        jButtonReload1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReload1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDebtLayout = new javax.swing.GroupLayout(jPanelDebt);
        jPanelDebt.setLayout(jPanelDebtLayout);
        jPanelDebtLayout.setHorizontalGroup(
            jPanelDebtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDebtLayout.createSequentialGroup()
                .addContainerGap(96, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
            .addGroup(jPanelDebtLayout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addGroup(jPanelDebtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jButtonAddDebt)
                    .addGroup(jPanelDebtLayout.createSequentialGroup()
                        .addGroup(jPanelDebtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(65, 65, 65)))
                .addGap(18, 18, 18)
                .addGroup(jPanelDebtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonReload1)
                    .addComponent(jButtonReload)
                    .addComponent(jTextFieldRest, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDebt, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNameDebt, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelDebtLayout.setVerticalGroup(
            jPanelDebtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDebtLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanelDebtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNameDebt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanelDebtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldDebt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanelDebtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldMoney, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanelDebtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonReload1)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldRest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanelDebtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddDebt)
                    .addComponent(jButtonReload))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelDebt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelDebt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNameDebtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNameDebtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNameDebtActionPerformed

    private void jTextFieldDebtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDebtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDebtActionPerformed

    private void jTextFieldMoneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMoneyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMoneyActionPerformed

    private void jTextFieldRestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldRestActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldRestActionPerformed

   
    private void jButtonAddDebtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddDebtActionPerformed
        
     DefaultTableModel model = (DefaultTableModel)jTableDebt.getModel();
     int select = jTableDebt.getSelectedRow();
          
     if(select == -1){
         JOptionPane.showMessageDialog(null, "Please choose a reader!");
     }else if(jTextFieldMoney.getText().equals("")|| jTextFieldRest.getText().equals("")){
          JOptionPane.showMessageDialog(null, "Please enter full information!");
     }else{
      try {
                String sql =  "INSERT INTO phieuthutienphat"
                + "(MADOCGIA, TIENTHU, CONLAI) VALUES (?,?,?)";
                conn = DriverManager.getConnection("jdbc:mysql://sql6.freemysqlhosting.net:3306/sql6424812?useUnicode=true&characterEncoding=UTF-8", "sql6424812","iNCTFpyiiJ");
                ps = conn.prepareStatement(sql);
                ps.setString(1, jTextFieldId.getText());
                ps.setString(2, jTextFieldMoney.getText());
                ps.setString(3, jTextFieldRest.getText());
                
                ps.executeUpdate();
               //JOptionPane.showMessageDialog(null, "test!");
    }
      
            catch (Exception ex){
                JOptionPane.showMessageDialog(null, ex);
            }
      
        try {
            String sql =  "UPDATE thedocgia SET TONGNODOCGIA = ? where MADOCGIA = ?";

            conn = DriverManager.getConnection("jdbc:mysql://sql6.freemysqlhosting.net:3306/sql6424812?useUnicode=true&characterEncoding=UTF-8", "sql6424812","iNCTFpyiiJ");
            ps = conn.prepareStatement(sql);
            
            ps.setString(1, jTextFieldRest.getText());
            ps.setString(2, jTextFieldId.getText());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Successfully!");
          
    }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        printBill();
        
        model.setRowCount(0);
        showUser();
        
     }
    }//GEN-LAST:event_jButtonAddDebtActionPerformed

    private void jTableDebtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDebtMouseClicked
       
       int i = jTableDebt.getSelectedRow();
       TableModel model = jTableDebt.getModel();
       
       jTextFieldId.setText(model.getValueAt(i, 0).toString());
       jTextFieldNameDebt.setText(model.getValueAt(i,1).toString());
       jTextFieldDebt.setText(model.getValueAt(i, 2).toString());
      
       jTextFieldMoney.setText("");
       jTextFieldRest.setText("");
       
    }//GEN-LAST:event_jTableDebtMouseClicked

    private void reload(){
         jTextFieldNameDebt.setText("");
        jTextFieldDebt.setText("");
        jTextFieldMoney.setText("");
        jTextFieldRest.setText("");
    }
    
    private void jButtonReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReloadActionPerformed
    
       reload();
        
    }//GEN-LAST:event_jButtonReloadActionPerformed

    private void calculateRemaining() {
        int debt =  Integer.parseInt(jTextFieldDebt.getText());
        int money = Integer.parseInt(jTextFieldMoney.getText());
        if(jTextFieldNameDebt.getText().equals("")){
                  JOptionPane.showMessageDialog(null, "Please choose reader!");
            }else if(money>debt){
                 JOptionPane.showMessageDialog(null, "The amount paid cannot be greater than the amount owed!");
            }else{  
                String rest = Integer.toString(debt -money);
                jTextFieldRest.setText(rest);

           }
    }
    
    private void jTextFieldMoneyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldMoneyKeyPressed
         
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            calculateRemaining();
        }
    }//GEN-LAST:event_jTextFieldMoneyKeyPressed

    private void jButtonReload1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReload1ActionPerformed
            calculateRemaining();
    }//GEN-LAST:event_jButtonReload1ActionPerformed

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
            java.util.logging.Logger.getLogger(DebtNote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DebtNote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DebtNote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DebtNote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DebtNote().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddDebt;
    private javax.swing.JButton jButtonReload;
    private javax.swing.JButton jButtonReload1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelDebt;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableDebt;
    private javax.swing.JTextField jTextFieldDebt;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldMoney;
    private javax.swing.JTextField jTextFieldNameDebt;
    private javax.swing.JTextField jTextFieldRest;
    // End of variables declaration//GEN-END:variables
}
