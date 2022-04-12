
package DebtNote;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Debt extends javax.swing.JFrame {

   Connection conn =null;
   PreparedStatement ps = null;
   ResultSet rs = null;
   DebtNote debtNote = new DebtNote();
    public Debt() {
        initComponents();
        showUser();
        this.setLocationRelativeTo(null);
        this.setTitle("Fine Management");
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
    }

    
    public ArrayList<FineList> fineLists(){
        ArrayList<FineList> fineLists = new ArrayList<>();
        try{
           conn = DriverManager.getConnection("jdbc:mysql://localhost/sql6424812?useUnicode=true&characterEncoding=UTF-8", "root","");
           String sql = "SELECT * FROM phieuthutienphat";
           ps = conn.prepareStatement(sql); 
           rs = ps.executeQuery();
           FineList fine;
           
           while (rs.next()){
            fine= new FineList (rs.getInt("ID"), rs.getInt("MADOCGIA"), rs.getInt("TIENTHU"),rs.getInt("CONLAI") );
            fineLists.add(fine);
         
         }
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        return fineLists;
    }
    public void showUser(){
       
        ArrayList<FineList> list = fineLists();
        //int s = list.get(WIDTH).getKind();
        //check(s);
        DefaultTableModel model = (DefaultTableModel)fineTable.getModel();
        Object[] row = new Object[9];
        for(int i=0; i<list.size();i++){
            row[0]= list.get(i).getId();
            row[1]= list.get(i).getIdReader();
            row[2]= list.get(i).getTiendong();
            row[3]= list.get(i).getConlai();
            model.addRow(row);
        }
   
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        fineTable = new javax.swing.JTable();
        addDebt = new javax.swing.JButton();
        deleteDebt = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        reloadDebt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new javax.swing.ImageIcon(getClass().getClassLoader().getResource("assets/fine_receipts.png")).getImage());

        jPanel1.setBackground(new java.awt.Color(251, 224, 196));

        fineTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã phiếu", "Mã độc giả", "Tiền thu", "Tổng nợ còn lại"
            }
        ));
        jScrollPane1.setViewportView(fineTable);

        addDebt.setBackground(new java.awt.Color(138, 182, 214));
        addDebt.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        addDebt.setText("Add");
        addDebt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDebtActionPerformed(evt);
            }
        });

        deleteDebt.setBackground(new java.awt.Color(138, 182, 214));
        deleteDebt.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        deleteDebt.setText("Delete");
        deleteDebt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteDebtActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(138, 182, 214));

        jLabel1.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("FINE MANAGEMENT");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        reloadDebt.setBackground(new java.awt.Color(138, 182, 214));
        reloadDebt.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        reloadDebt.setText("Reload");
        reloadDebt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reloadDebtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteDebt, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addDebt, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reloadDebt, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(addDebt)
                        .addGap(26, 26, 26)
                        .addComponent(deleteDebt)
                        .addGap(26, 26, 26)
                        .addComponent(reloadDebt))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addDebtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDebtActionPerformed
        debtNote.setVisible(true);
    }//GEN-LAST:event_addDebtActionPerformed

    private void reloadDebtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reloadDebtActionPerformed
        DefaultTableModel model = (DefaultTableModel)fineTable.getModel();
        model.setRowCount(0);
        showUser();       
    }//GEN-LAST:event_reloadDebtActionPerformed
    
    private void deleteDebtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteDebtActionPerformed
            
         DefaultTableModel model = (DefaultTableModel)fineTable.getModel();
          int select = fineTable.getSelectedRow();
          
          if(select == -1){
              JOptionPane.showMessageDialog(null, "Please choose fine receipts!");
          }else{
          try {
            String sql =  "UPDATE thedocgia SET TONGNODOCGIA = TONGNODOCGIA + ? where MADOCGIA = ?";

            conn = DriverManager.getConnection("jdbc:mysql://localhost/sql6424812?useUnicode=true&characterEncoding=UTF-8", "root","");
            ps = conn.prepareStatement(sql);
            ps.setString(1, model.getValueAt(select, 2).toString());
            ps.setString(2, model.getValueAt(select, 1).toString());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Delete successfully!");
           
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
          
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost/sql6424812?useUnicode=true&characterEncoding=UTF-8", "root","");
 
            String s= "DELETE FROM phieuthutienphat WHERE ID = ?";
            ps = conn.prepareStatement(s);
            ps.setString(1, model.getValueAt(select, 0).toString());
            ps.executeUpdate();

        }catch (Exception ex){
            ex.printStackTrace();
        }
        
         model.removeRow(select);
    }//GEN-LAST:event_deleteDebtActionPerformed
    }
    
    
    public static void main(String args[]) {
        
      try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Debt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Debt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Debt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Debt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Debt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addDebt;
    private javax.swing.JButton deleteDebt;
    private javax.swing.JTable fineTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton reloadDebt;
    // End of variables declaration//GEN-END:variables
}
