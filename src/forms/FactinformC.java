/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import classes.Conectar;
import classes.lista_art;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRMapArrayDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
public class FactinformC extends javax.swing.JFrame {  
    Conectar con=new Conectar();
    ResultSet rs;
    public FactinformC() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/img/ico.png")).getImage());
        getContentPane().setBackground(Color.decode("#003366")); 
        this.setLocationRelativeTo(null); 
        num_fact();
       
    }

        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        clientrc = new javax.swing.JLabel();
        totalfc = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Imprimir = new javax.swing.JButton();
        subtfc = new javax.swing.JTextField();
        itbisfc = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tablafactura = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        num_fac = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tipovent = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Facturacion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        clientrc.setForeground(new java.awt.Color(255, 255, 255));
        clientrc.setText("aquivacliente");

        totalfc.setEditable(false);
        totalfc.setBackground(new java.awt.Color(0, 51, 102));
        totalfc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        totalfc.setForeground(new java.awt.Color(51, 255, 0));
        totalfc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        totalfc.setText("0");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("SUBTOTAL");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ITBIS");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("TOTAL");

        Imprimir.setText("Facturar/Imprimir");
        Imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImprimirActionPerformed(evt);
            }
        });

        subtfc.setEditable(false);
        subtfc.setBackground(new java.awt.Color(0, 51, 102));
        subtfc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        subtfc.setForeground(new java.awt.Color(51, 255, 51));
        subtfc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        subtfc.setText("0");

        itbisfc.setEditable(false);
        itbisfc.setBackground(new java.awt.Color(0, 51, 102));
        itbisfc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        itbisfc.setForeground(new java.awt.Color(51, 255, 0));
        itbisfc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        itbisfc.setText("0");

        Tablafactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(Tablafactura);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Número de FACTURA:");

        num_fac.setForeground(new java.awt.Color(255, 255, 255));
        num_fac.setText("aquivanf");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cliente:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Tipo de venta:");

        tipovent.setForeground(new java.awt.Color(255, 255, 255));
        tipovent.setText("aquivatipovent");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clientrc))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(tipovent))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(num_fac))
                                .addContainerGap(67, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(Imprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(subtfc, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                .addComponent(itbisfc)
                                .addComponent(totalfc))
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel2)
                    .addComponent(jLabel10))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(num_fac)
                    .addComponent(clientrc)
                    .addComponent(tipovent))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel5)
                        .addGap(13, 13, 13)
                        .addComponent(subtfc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addGap(2, 2, 2)
                        .addComponent(itbisfc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(totalfc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(Imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(101, 101, 101))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void imprimir(){
ArrayList listaf=new ArrayList(); 
for (int i=0; i<Tablafactura.getRowCount();i++){ 
lista_art organizar = new lista_art(Tablafactura.getValueAt(i,0).toString(),Tablafactura.getValueAt(i,1).toString(),Tablafactura.getValueAt(i,2).toString(),Tablafactura.getValueAt(i,3).toString(),Tablafactura.getValueAt(i,4).toString(),Tablafactura.getValueAt(i,5).toString());
listaf.add(organizar);
}
        
 try {
System.out.println("1");
JasperReport reporte=(JasperReport)JRLoader.loadObjectFromFile("FactutaC.jasper");
System.out.println("2");
    HashMap parametro = new HashMap();
    //aqui se recogen los parametros
    //recuerda compilar el reporte cada vez que agregues un parametro
    int contarr=0;
    for (int i = 0; i <Tablafactura.getRowCount();i++) {
        contarr=contarr+1;
     }
    parametro.put("client",String.valueOf(clientrc.getText()));
    parametro.put("sub_total",String.valueOf(subtfc.getText()));
    parametro.put("total_itbis",String.valueOf(itbisfc.getText()));
    parametro.put("total",String.valueOf(totalfc.getText()));
    parametro.put("total_art",String.valueOf(contarr));
    parametro.put("tipovent",String.valueOf(tipovent.getText()));
    parametro.put("num_fact",String.valueOf(num_fac.getText()));  
JRBeanCollectionDataSource listax= new JRBeanCollectionDataSource(listaf);
  //JasperPrint jprint=JasperFillManager.fillReport(reporte,parametro,listax);
  JasperPrint jprint=JasperFillManager.fillReport(reporte,parametro,listax);
    //,new JRBeanCollectionDataSource(listaf)
  JasperViewer view = new JasperViewer(jprint,false);
  view.setVisible(true);
 
}  
catch(JRException ex) {
JOptionPane.showMessageDialog(null,""+ex.getMessage());
System.out.println("aqui");   
}
    }
public void num_fact()
{       Statement st;
         //esto carga la tabla de los contador         
         Connection cargain = con.getConnection(); 
         String id_factura="";
    try {st=cargain.createStatement();
        String sql="select id_factura from contador";
          rs=st.executeQuery(sql);
          rs.next();
          id_factura=rs.getString("id_factura");
           }             
    catch (SQLException e) {
            System.out.println("error"+e);
        }
    int secuencia = Integer.parseInt(id_factura);
    secuencia=secuencia+1;
    num_fac.setText(String.valueOf(secuencia));

}
    


    

    private void ImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImprimirActionPerformed
      
             imprimir();
        
        
    }//GEN-LAST:event_ImprimirActionPerformed

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
            java.util.logging.Logger.getLogger(FactinformC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FactinformC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FactinformC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FactinformC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FactinformC().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Imprimir;
    public javax.swing.JTable Tablafactura;
    public javax.swing.JLabel clientrc;
    public javax.swing.JTextField itbisfc;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel num_fac;
    public javax.swing.JTextField subtfc;
    public javax.swing.JLabel tipovent;
    public javax.swing.JTextField totalfc;
    // End of variables declaration//GEN-END:variables
}
