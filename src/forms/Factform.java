/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import classes.Conectar;
import static forms.Cuadraform.apes;
import static forms.Cuadraform.nomb;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Tec
 */
public class Factform extends javax.swing.JFrame {
Conectar con=new Conectar();
      
    public Factform() {
        initComponents();
        cargaclient();
        cargamf();
        setIconImage(new ImageIcon(getClass().getResource("/img/ico.png")).getImage());
        getContentPane().setBackground(Color.decode("#003366"));
         this.setLocationRelativeTo(null);    
    }
 public  void cargaclient(){
         Statement st;
         ResultSet rs;
         Statement st2;
         ResultSet rs2;
       try {
             //esto carga la tabla de los articulos         
         Connection cargain = con.getConnection();
         DefaultTableModel modelt = new DefaultTableModel();
         TableRowSorter<TableModel> ordenartabla;
         ordenartabla = new TableRowSorter<>(modelt);
         factclient.setRowSorter(ordenartabla);
         modelt.addColumn("ID");
         modelt.addColumn("Nombre");
         modelt.addColumn("Facturas");
         factclient.setModel(modelt);
         String sql="select * from clientes";
         
          TableColumnModel columnModel = factclient.getColumnModel();
          columnModel.getColumn(0).setPreferredWidth(1);
         String[]datart=new String[4];
         
    try {
             st=cargain.createStatement();
             rs=st.executeQuery(sql);
             while(rs.next()){
             datart[0]=rs.getString(1);
             datart[1]=rs.getString(2);
             String sql2="SELECT COUNT(*) FROM factura WHERE `id_cliente` like'"+datart[0]+"'";
             st2=cargain.createStatement();
             rs2=st2.executeQuery(sql2);            
             while(rs2.next()){
             datart[2]=rs2.getString(1);
                     }
             modelt.addRow(datart);
             factclient.setDefaultEditor(Object.class, null);
           }             
             factclient.setModel(modelt);
                  }
    catch (SQLException e) {
            System.out.println("error"+e);
        }
    }
    catch (Exception e) {
       }
   }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        factclient = new javax.swing.JTable();
        busfc = new javax.swing.JTextField();
        imprimirfact = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        facturasm = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        pasafact = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Clientes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(0, 51, 102));

        factclient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(factclient);

        busfc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                busfcKeyReleased(evt);
            }
        });

        imprimirfact.setText("Imprimir Facturas");
        imprimirfact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirfactActionPerformed(evt);
            }
        });

        facturasm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(facturasm);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Buscar Cliente:");

        pasafact.setText("Mostrar Facturas");
        pasafact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasafactActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(busfc, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(74, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(imprimirfact)
                        .addGap(213, 213, 213))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(pasafact)
                        .addGap(219, 219, 219))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(225, 225, 225))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addComponent(busfc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pasafact)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imprimirfact)
                .addGap(5, 5, 5))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Reporte de facturas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void busfcKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_busfcKeyReleased
buscatabla();        // TODO add your handling code here:
    }//GEN-LAST:event_busfcKeyReleased

    private void pasafactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasafactActionPerformed
pasapvf();        // TODO add your handling code here:
    }//GEN-LAST:event_pasafactActionPerformed

    private void imprimirfactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirfactActionPerformed
imprimir();        // TODO add your handling code here:
    }//GEN-LAST:event_imprimirfactActionPerformed

    public void cargamf(){
    
      DefaultTableModel modelt2 = new DefaultTableModel();
         TableRowSorter<TableModel> ordenartabla;
         ordenartabla = new TableRowSorter<>(modelt2);
         facturasm.setRowSorter(ordenartabla);
         modelt2.addColumn("Fact #:");
         modelt2.addColumn("Tipo de venta");
         modelt2.addColumn("Fecha");
         modelt2.addColumn("Total");
         facturasm.setModel(modelt2);
    }
    
    
    
    public void buscatabla(){
       Statement st;
       Statement st2;
       ResultSet rs;
       ResultSet rs2;
       try {
             //esto carga la tabla de los articulos         
         Connection cargain = con.getConnection();
         DefaultTableModel modelt = new DefaultTableModel();
         TableRowSorter<TableModel> ordenartabla = new TableRowSorter<TableModel>(modelt);
         factclient.setRowSorter(ordenartabla);
         String sql="";
        modelt.addColumn("ID");
         modelt.addColumn("Nombre");
         modelt.addColumn("Facturas");
         factclient.setModel(modelt);
         String cliente=String.valueOf(busfc.getText());
         //esto busca los cuadres por fecha
         sql="select * from clientes where nom_cliente like '%"+cliente+"%' OR id_cliente like '%"+cliente+"%'"; 
         
         String[]datart=new String[5];
    try {
             st=cargain.createStatement();
             rs=st.executeQuery(sql);
             while(rs.next()){
             datart[0]=rs.getString(1);
             datart[1]=rs.getString(2);
             String sql2="SELECT COUNT(*) FROM factura WHERE `id_cliente` like'"+datart[0]+"'";
             st2=cargain.createStatement();
             rs2=st2.executeQuery(sql2);            
             while(rs2.next()){
             datart[2]=rs2.getString(1);
                     }                       
             modelt.addRow(datart);
             factclient.setDefaultEditor(Object.class, null);
             factclient.setColumnSelectionInterval(0,0);
             factclient.setRowSelectionInterval(0,0);
                         }
             factclient.setModel(modelt);
        } catch (SQLException e) {
            System.out.println("error"+e);
        }
    }
    catch (Exception e) {
       }    
   }  
    
    
    public void pasapvf(){
     Statement st;
    ResultSet rs;
         
       try {
             //esto carga la tabla de los articulos         
         Connection cargain = con.getConnection();
         DefaultTableModel modelt = new DefaultTableModel();
         TableRowSorter<TableModel> ordenartabla;
         ordenartabla = new TableRowSorter<>(modelt);
         facturasm.setRowSorter(ordenartabla);
         modelt.addColumn("Fact #:");
         modelt.addColumn("Tipo de venta");
         modelt.addColumn("Fecha");
         modelt.addColumn("Total");
         String cod_cliente=factclient.getValueAt(factclient.getSelectedRow(),0).toString();
         facturasm.setModel(modelt);
         String sql="select nom_fact,tipo_fact,fecha,total from factura where id_cliente like '"+cod_cliente+"'";
         TableColumnModel columnModel = facturasm.getColumnModel();
         columnModel.getColumn(0).setPreferredWidth(1);
         String[]datart=new String[5];
         
    try {
             st=cargain.createStatement();
             rs=st.executeQuery(sql);
             while(rs.next()){
             datart[0]=rs.getString(1);
             datart[1]=rs.getString(2);
             datart[2]=rs.getString(3);
             datart[3]=rs.getString(4);
             modelt.addRow(datart);
             facturasm.setDefaultEditor(Object.class, null);
           }             
             facturasm.setModel(modelt);
                  }
    catch (SQLException e) {
            System.out.println("error"+e);
        }
    }
    catch (Exception e) {
       }
    
    
    }
    
    
    public  void imprimir(){
     //este es para imprimir
     //aqui estoy trayendo las variables   
//        String idfactura=facturasm.getValueAt(facturasm.getSelectedRow(),0).toString();
//        String total=facturasm.getValueAt(facturasm.getSelectedRow(),3).toString();
           
       String idfactura="1";
        String total="1";
     try {
   con=new Conectar();
    Connection reg=con.getConnection();
    JasperReport reporte = null;
    Map parametro = new HashMap();
    //aqui se recogen los parametros
   //recuerda compilar el reporte cada vez que agregues un parametro
   parametro.put("id_fact",idfactura);
   parametro.put("total",total);
    String path ="src\\report\\rfactuta.jasper";
   reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
   JasperPrint jprint=JasperFillManager.fillReport(reporte,parametro,reg);
   JasperViewer view = new JasperViewer(jprint,false);
   view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
   view.setVisible(true);
         } 
     
     
     catch(JRException ex) 
     {
         System.out.println("bujujuj");
         System.out.println(ex);  
         
     }
    }
    
    
  
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
            java.util.logging.Logger.getLogger(Factform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Factform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Factform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Factform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Factform().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField busfc;
    private javax.swing.JTable factclient;
    private javax.swing.JTable facturasm;
    private javax.swing.JButton imprimirfact;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton pasafact;
    // End of variables declaration//GEN-END:variables
}
