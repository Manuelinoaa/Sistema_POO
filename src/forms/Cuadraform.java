/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import classes.Conectar;
import static forms.Loginform.auser;
import static forms.Loginform.nuser;
import static forms.Menu.Tablaart;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.time.LocalDate.now;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
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
public class Cuadraform extends javax.swing.JFrame {
Conectar con=new Conectar();
    ResultSet rs;
     
    public Cuadraform() {
        initComponents();
        cargatabla();
        cargatabla2();
        DefaultTableModel modelt = new DefaultTableModel();
        String fecha=String.valueOf(now());
        String year=String.valueOf(now()).substring(0, 4);
        String moth=String.valueOf(now()).substring(5, 7);
        String day=String.valueOf(now()).substring(8,10);
        ano.setText(year);
        mes.setText(moth);
        dia.setText(day);   
setIconImage(new ImageIcon(getClass().getResource("/img/ico.png")).getImage());
getContentPane().setBackground(Color.decode("#003366"));}
String fecha=String.valueOf(now());
static String nomb;
static String apes;

public static void nombreuser(String nom,String ape) {            
    nomb=nom;
    apes=ape;
    }

     public void cargatabla(){
       Statement st;
    
       try {
             //esto carga la tabla de los articulos         
         Connection cargain = con.getConnection();
         DefaultTableModel modelt = new DefaultTableModel();
         TableRowSorter<TableModel> ordenartabla = new TableRowSorter<TableModel>(modelt);
         tablap.setRowSorter(ordenartabla);
         String sql="";
         modelt.addColumn("FACTURA #:");
         modelt.addColumn("TIPO DE VENTA");
         modelt.addColumn("FECHA");
         modelt.addColumn("TOTAL");
         tablap.setModel(modelt);
         sql="select * from factura where fecha like '"+fecha+"'";
           System.out.println(sql);
         String[]datart=new String[7];
         
    try {
             st=cargain.createStatement();
             rs=st.executeQuery(sql);
             while(rs.next()){
             datart[0]=rs.getString(1);
             datart[1]=rs.getString(2);
             datart[2]=rs.getString(3);
             datart[3]=rs.getString(4);
             modelt.addRow(datart);
             tablap.requestFocus();
             tablap.setColumnSelectionInterval(0,0);
             tablap.setRowSelectionInterval(0,0);       
             
           }             
             tablap.setModel(modelt);
            tablap.setDefaultEditor(Object.class, null);
          
        }
    catch (SQLException e) {
            System.out.println("error"+e);
        }
    }
    catch (Exception e) {
       }    
   }   
     
     
   public void cargatabla2(){
       Statement st;
       try {
             //esto carga la tabla de los articulos         
         Connection cargain = con.getConnection();
         DefaultTableModel modelt = new DefaultTableModel();
         TableRowSorter<TableModel> ordenartabla = new TableRowSorter<TableModel>(modelt);
         cuadres.setRowSorter(ordenartabla);
         String sql="";
         modelt.addColumn("CUADRE #:");
         modelt.addColumn("FECHA DE CIERRE");
         modelt.addColumn("FECHA DE CUADRE");
         modelt.addColumn("TOTAL");
         cuadres.setModel(modelt);
         sql="select * from cuadre";
           System.out.println(sql);
         String[]datart=new String[7];
         
    try {
             st=cargain.createStatement();
             rs=st.executeQuery(sql);
             while(rs.next()){
             datart[0]=rs.getString(1);
             datart[1]=rs.getString(2);
             datart[2]=rs.getString(3);
             datart[3]=rs.getString(4);
             modelt.addRow(datart);
             cuadres.requestFocus();
             cuadres.setColumnSelectionInterval(0,0);
             cuadres.setRowSelectionInterval(0,0);       
             
           }             
             cuadres.setModel(modelt);
            cuadres.setDefaultEditor(Object.class, null);
          
        }
    catch (SQLException e) {
            System.out.println("error"+e);
        }
    }
    catch (Exception e) {
       }    
   }     
     
     
     public void cuadrest(){
        int i = 0;
        String tipovent;
        String dinero;
        float dinerof;
        float totalf=0;
        String totalfs;
        String fecha=String.valueOf(now());
        String fechau=String.valueOf(ano.getText())+"-"+String.valueOf(mes.getText())+"-"+String.valueOf(dia.getText());
        for (i=0; i <tablap.getRowCount(); i++) {
        dinero = tablap.getValueAt(i,3).toString();
        tipovent = tablap.getValueAt(i,1).toString();
        
        if (tipovent.equals("Al contado")) {
             dinerof = Float.valueOf(dinero);
             totalf=totalf+dinerof;
            }
             
         }
        totalfs=String.valueOf(totalf);
 
     Connection cargain = con.getConnection();
          

    try {
        classes.Conectar objeto= new classes.Conectar();
        String queris = "INSERT INTO cuadre VALUES(?,?,?,?)";
        PreparedStatement insertar = objeto.getConnection().prepareStatement(queris);
        int x;
        
        insertar.setInt(1,0);
        insertar.setString(2,fechau);
        insertar.setString(3,fecha);
        insertar.setFloat(4,totalf);
        insertar.executeUpdate();
        JOptionPane.showMessageDialog(null,"El cuadre del "+fechau+" ha sido Creado");
      
   }
  catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Error "+ex.toString());
        }
     
             System.out.println(totalf+" total de c");
             System.out.println(i);
             
     
     
     }       
        
        
        
             
             
    
     
   public void buscatabla(){
       Statement st;
       try {
             //esto carga la tabla de los articulos         
         Connection cargain = con.getConnection();
         DefaultTableModel modelt = new DefaultTableModel();
         TableRowSorter<TableModel> ordenartabla = new TableRowSorter<TableModel>(modelt);
         tablap.setRowSorter(ordenartabla);
         String sql="";
         modelt.addColumn("FACTURA #:");
         modelt.addColumn("TIPO DE VENTA");
         modelt.addColumn("FECHA");
         modelt.addColumn("TOTAL");
         tablap.setModel(modelt);
         String fechau=String.valueOf(ano.getText())+"-"+String.valueOf(mes.getText())+"-"+String.valueOf(dia.getText());
         //esto busca los cuadres por fecha
         sql="select * from factura where fecha like '"+fechau+"'"; 
         
         String[]datart=new String[7];
    try {
             st=cargain.createStatement();
             rs=st.executeQuery(sql);
             while(rs.next()){
             datart[0]=rs.getString(1);
             datart[1]=rs.getString(2);
             datart[2]=rs.getString(3);
             datart[3]=rs.getString(4);
             modelt.addRow(datart);
             tablap.setDefaultEditor(Object.class, null);
              tablap.setColumnSelectionInterval(0,0);
             tablap.setRowSelectionInterval(0,0);
                         }
              tablap.setModel(modelt);
        } catch (SQLException e) {
            System.out.println("error"+e);
        }
    }
    catch (Exception e) {
       }    
   }  
     
   
    public  void imprimir(){
         //este es para imprimir
     //aqui estoy trayendo las variables   
   String idcuadre=cuadres.getValueAt(cuadres.getSelectedRow(),0).toString();
        String fechaccx=cuadres.getValueAt(cuadres.getSelectedRow(),1).toString();
        String fechacc=cuadres.getValueAt(cuadres.getSelectedRow(),2).toString();
        String total=cuadres.getValueAt(cuadres.getSelectedRow(),3).toString();            
        String aten=nomb+" "+ apes;           
         
     try {
         con=new Conectar();
    Connection reg=con.getConnection();
    JasperReport reporte = null;
    Map parametro = new HashMap();
    //aqui se recogen los parametros
//    //recuerda compilar el reporte cada vez que agregues un parametro
   parametro.put("num_cuadre",idcuadre);
   parametro.put("date_cuadre",fechacc);
   parametro.put("total_cuadre",total);
  parametro.put("date_cierre",fechaccx);
  parametro.put("aten",aten);
    String path ="src\\report\\CuadreCaja.jasper";
   reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
   JasperPrint jprint=JasperFillManager.fillReport(reporte,parametro,reg);
   JasperViewer view = new JasperViewer(jprint,false);
   view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
   view.setVisible(true);
         } 
     
     
     catch(JRException ex) 
     {
         System.out.println("bujujuj");
     //  Logger.getLogger(TipartformR.class.getName()).log(Level.SEVERE,null,ex);  
         
     }
    }
    
    public void pasacuadre(){
     String fechac="";
     String fecha=String.valueOf(now());
     String fechau=String.valueOf(ano.getText())+"-"+String.valueOf(mes.getText())+"-"+String.valueOf(dia.getText());
     int contis=0;
     Statement st;
     ResultSet rs;
        if (tablap.getRowCount()<=0) {
            JOptionPane.showMessageDialog(null," NO HAY ACTIVIDADES PARA CUADRAR" );
        }
     
        else{
     
        try {
             //esto carga la tabla de los articulos         
         Connection cargain = con.getConnection();
       
        String sql="SELECT COUNT(*) FROM cuadre WHERE fecha_cuadre LIKE '"+fechau+"'";      
            System.out.println(sql);   
        st=cargain.createStatement();
        rs=st.executeQuery(sql);
        while(rs.next()){
             contis=rs.getInt(1); 
             }
            if (contis>0) {
                JOptionPane.showMessageDialog(null, "ESTA FECHA YA SE CUADRÓ");
            }
            else{
                cuadrest();
                cargatabla2();
            }
        
        
        }
        
            catch (SQLException e) {
            System.out.println("error"+e);
        }
    }
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablap = new javax.swing.JTable();
        cuadrex = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        cuadres = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        ano = new javax.swing.JTextField();
        mes = new javax.swing.JTextField();
        dia = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        imprimix = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tablap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablap);

        cuadrex.setText("Cuadrar");
        cuadrex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuadrexActionPerformed(evt);
            }
        });

        cuadres.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        cuadres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cuadresMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(cuadres);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cierre de caja");

        ano.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                anoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                anoKeyTyped(evt);
            }
        });

        mes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mesKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mesKeyTyped(evt);
            }
        });

        dia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                diaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                diaKeyTyped(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Año");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mes");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Dia");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cuadres");

        imprimix.setText("Imprimir");
        imprimix.setEnabled(false);
        imprimix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimixActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(29, 29, 29)
                                    .addComponent(jLabel2)
                                    .addGap(37, 37, 37))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(ano, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(mes, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(dia, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cuadrex)
                                    .addGap(49, 49, 49))))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
                                .addComponent(jScrollPane2))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(235, 235, 235)
                        .addComponent(imprimix)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cuadrex, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(imprimix)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cuadrexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuadrexActionPerformed
       
        pasacuadre();
                   
    }//GEN-LAST:event_cuadrexActionPerformed

    private void diaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_diaKeyReleased
         buscatabla();
    }//GEN-LAST:event_diaKeyReleased

    private void mesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mesKeyReleased
buscatabla();        // TODO add your handling code here:
    }//GEN-LAST:event_mesKeyReleased

    private void anoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_anoKeyReleased
buscatabla();        // TODO add your handling code here:
    }//GEN-LAST:event_anoKeyReleased

    private void cuadresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cuadresMouseClicked
imprimix.setEnabled(true);
       
    }//GEN-LAST:event_cuadresMouseClicked

    private void imprimixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimixActionPerformed
imprimir();        // TODO add your handling code here:
    }//GEN-LAST:event_imprimixActionPerformed

    private void anoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_anoKeyTyped
    int key = evt.getKeyChar();
    boolean numeros = key >= 48 && key <= 57;   
    if (!numeros)
    {
      evt.consume();
    }        // TODO add your handling code here:
    }//GEN-LAST:event_anoKeyTyped

    private void mesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mesKeyTyped
    int key = evt.getKeyChar();
    boolean numeros = key >= 48 && key <= 57;   
    if (!numeros)
    {
      evt.consume();
    }        // TODO add your handling code here:
    }//GEN-LAST:event_mesKeyTyped

    private void diaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_diaKeyTyped
    int key = evt.getKeyChar();
    boolean numeros = key >= 48 && key <= 57;   
    if (!numeros)
    {
      evt.consume();
    }        // TODO add your handling code here:
    }//GEN-LAST:event_diaKeyTyped

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
            java.util.logging.Logger.getLogger(Cuadraform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cuadraform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cuadraform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cuadraform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cuadraform().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ano;
    private javax.swing.JTable cuadres;
    private javax.swing.JButton cuadrex;
    private javax.swing.JTextField dia;
    private javax.swing.JButton imprimix;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField mes;
    private javax.swing.JTable tablap;
    // End of variables declaration//GEN-END:variables
}
