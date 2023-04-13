/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import classes.Conectar;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.sql.*;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.Color;
import java.text.DecimalFormat;
import javax.management.Descriptor;
import java.awt.Image;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import javax.swing.ImageIcon;
import java.text.DateFormat;
import java.text.ParseException; 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JDialog;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
public class TipartformR extends javax.swing.JFrame {
    
     Conectar con;
    //este declara la variable de conexion
    public TipartformR() {
     setIconImage(new ImageIcon(getClass().getResource("/img/ico.png")).getImage());
     getContentPane().setBackground(Color.decode("#003366"));
     initComponents();
     con=new Conectar();
    Connection reg=con.getConnection();
     this.setLocationRelativeTo(null);
    Statement st;
    ResultSet rs;
    cargatabla();
    jPanel2.setVisible(false);

    }

   public void cargatabla(){
       Statement st;
       Statement st2;
       ResultSet rs;
       ResultSet rs2;
        try {
             //esto carga la tabla de los articulos         
         Connection cargain = con.getConnection();
         DefaultTableModel modelt = new DefaultTableModel();
         TableRowSorter<TableModel> ordenartabla = new TableRowSorter<TableModel>(modelt);
         tabltipart.setRowSorter(ordenartabla);
         String sql="";
         modelt.addColumn("ID");
         modelt.addColumn("Tipo de articulo");
         modelt.addColumn("Modo de distribución");
         modelt.addColumn("Cantidad");
         tabltipart.setModel(modelt);
         sql="select * from tipo_art";
         
         String[]datart=new String[4];   
         
         
         
    try {
             st=cargain.createStatement();
             st2=cargain.createStatement();
             rs=st.executeQuery(sql);
             
             while(rs.next()){
             datart[0]=rs.getString(1);
             datart[1]=rs.getString(2);
             datart[2]=rs.getString(3);
             String sqlc="SELECT COUNT(*) FROM articulos a INNER JOIN tipo_art b on a.id_ti_art=b.id_ti_art WHERE a.id_ti_art="+rs.getString(1)+"";
             rs2=st2.executeQuery(sqlc);
             while(rs2.next()){
             datart[3]=rs2.getString(1);
             }
             
             modelt.addRow(datart);
             tabltipart.setDefaultEditor(Object.class, null);
             
             }
             tabltipart.setModel(modelt);
        }
            catch (SQLException e) {
            System.out.println("error"+e);
        }
    }
    catch (Exception e) {
       }    
    }
   
   
  
public void buscatabla1(){
       Statement st;
       ResultSet rs;
       try {
             //esto carga la tabla de los articulos         
         Connection cargain = con.getConnection();
         DefaultTableModel modelt = new DefaultTableModel();
         TableRowSorter<TableModel> ordenartabla = new TableRowSorter<TableModel>(modelt);
         tabltipart.setRowSorter(ordenartabla);
         String sql="";
         modelt.addColumn("ID");
         modelt.addColumn("Tipo de articulo");
         modelt.addColumn("Modo de distribución");
         modelt.addColumn("Cantidad");
         tabltipart.setModel(modelt);
         String idb=String.valueOf(this.id_ti_art.getText());
         System.out.println(idb);
         //esto busca los artiiculos por id
         sql="select * from tipo_art where id_ti_art like '%"+idb+"%'";
           String[]datart=new String[7];
    try {
             st=cargain.createStatement();
             rs=st.executeQuery(sql);
             while(rs.next()){
             datart[0]=rs.getString(1);
             datart[1]=rs.getString(2);
             datart[2]=rs.getString(3);
             //este me cuenta los articulos de ese tipo
             ResultSet rs2;
             Statement st2;
             st2=cargain.createStatement();
             String sqlc="SELECT COUNT(*) FROM articulos a INNER JOIN tipo_art b on a.id_ti_art=b.id_ti_art WHERE a.id_ti_art="+rs.getString(1)+"";
             rs2=st2.executeQuery(sqlc);
             while(rs2.next()){
             datart[3]=rs2.getString(1);
             }
             
                           
             modelt.addRow(datart);
             tabltipart.setDefaultEditor(Object.class, null);
             tabltipart.requestFocus();
             tabltipart.setColumnSelectionInterval(0,0);
             tabltipart.setRowSelectionInterval(0,0);
             System.out.println(idb);
             }
              tabltipart.setModel(modelt);
        } catch (SQLException e) {
            System.out.println("error"+e);
        }
    }
    catch (Exception e) {
       }    
   }      
   
public void buscatabla2(){
       Statement st;
       ResultSet rs;
       try {
             //esto carga la tabla de los articulos         
         Connection cargain = con.getConnection();
         DefaultTableModel modelt = new DefaultTableModel();
         TableRowSorter<TableModel> ordenartabla = new TableRowSorter<TableModel>(modelt);
         tabltipart.setRowSorter(ordenartabla);
         String sql="";
           modelt.addColumn("ID");
         modelt.addColumn("Tipo de articulo");
         modelt.addColumn("Modo de distribución");
         modelt.addColumn("Cantidad");
         tabltipart.setModel(modelt);
         String idb=String.valueOf(this.tipo_art.getText());
         System.out.println(idb);
         //esto busca los artiiculos por id
         sql="select * from tipo_art where tipo_art like '%"+idb+"%'";
         String[]datart=new String[7];
    try {
             st=cargain.createStatement();
             rs=st.executeQuery(sql);
             while(rs.next()){
             datart[0]=rs.getString(1);
             datart[1]=rs.getString(2);
             datart[2]=rs.getString(3);
             ResultSet rs2;
             Statement st2;
             st2=cargain.createStatement();
             String sqlc="SELECT COUNT(*) FROM articulos a INNER JOIN tipo_art b on a.id_ti_art=b.id_ti_art WHERE a.id_ti_art="+rs.getString(1)+"";
             rs2=st2.executeQuery(sqlc);
             while(rs2.next()){
             datart[3]=rs2.getString(1);
             }
             
           
             modelt.addRow(datart);
             tabltipart.setDefaultEditor(Object.class, null);
             tabltipart.requestFocus();
             tabltipart.setColumnSelectionInterval(0,0);
             tabltipart.setRowSelectionInterval(0,0);
             System.out.println(idb);
             }
              tabltipart.setModel(modelt);
        } catch (SQLException e) {
            System.out.println("error"+e);
        }
    }
    catch (Exception e) {
       }    
   }


public void cargatabla2(){
       Statement st;
       ResultSet rs;
       
        try {
             //esto carga la tabla de los articulos         
         Connection cargain = con.getConnection();
         DefaultTableModel modelt = new DefaultTableModel();
         TableRowSorter<TableModel> ordenartabla = new TableRowSorter<>(modelt);
         tablaartc.setRowSorter(ordenartabla);
         modelt.addColumn("cod_art");
         modelt.addColumn("des_Art");
         modelt.addColumn("cant_art");
         modelt.addColumn("pre_com");
         modelt.addColumn("Importe");
         
         tablaartc.setModel(modelt);
         String idtipart=tabltipart.getValueAt(tabltipart.getSelectedRow(),0).toString();
         String sql="SELECT cod_art,des_art,cant_art,pre_com FROM articulos a INNER JOIN tipo_art b on a.id_ti_art=b.id_ti_art WHERE a.id_ti_art="+idtipart+"";
         String[]datart=new String[6];                   
          try {
                
             st=cargain.createStatement();
             rs=st.executeQuery(sql);
             while(rs.next()){
             datart[0]=rs.getString(1);
             datart[1]=rs.getString(2);
             datart[2]=rs.getString(3);
             datart[3]=rs.getString(4);
             float cxp=rs.getFloat(3)*rs.getFloat(4);
            // String cxps=String.valueOf(cxp);
             datart[4]=String.valueOf(cxp);
                          
             modelt.addRow(datart);
             tablaartc.setDefaultEditor(Object.class, null);
                    }
             tablaartc.setModel(modelt);
        }
            catch (SQLException e) {
            System.out.println("error"+e);
        }
    }
    catch (Exception e) {
       }    
    }
public void cuentabla(){
String idticuent=tabltipart.getValueAt(tabltipart.getSelectedRow(),0).toString();             
int totalfila=tabltipart.getRowCount();
 for(int i=0;i<(totalfila);i++){
 float submatoria=Float.valueOf((String.valueOf(tabltipart.getValueAt(i,0))));   
 float act=Float.valueOf(id_ti_art.getText());
     if (submatoria==act) {
         
     }
 System.out.println(submatoria+" "+act);
 }
  
   


}

 public void imprimir(){
     //este es para imprimir
     //aqui estoy trayendo las variables   
        String idtipart=tabltipart.getValueAt(tabltipart.getSelectedRow(),0).toString();
        String tipus=tabltipart.getValueAt(tabltipart.getSelectedRow(),1).toString();
        String distrups=tabltipart.getValueAt(tabltipart.getSelectedRow(),2).toString();
        String cantis=tabltipart.getValueAt(tabltipart.getSelectedRow(),3).toString();            
         
////este es el que me saca el subtotal, total e itbis  
     
float subtm=0;
float totalm=0;
float cantm=0;
double roundOffsubtotal=0;
double roundOffcant=0;
double roundOfftotal=0;
double redo=0;
double redo3=0;

 int totalfila=tablaartc.getRowCount();
 for(int i=0;i<(totalfila);i++){
 float submatoria=Float.valueOf((String.valueOf(tablaartc.getValueAt(i,2))));
 float cantatoria=Float.valueOf((String.valueOf(tablaartc.getValueAt(i,3))));
 float cantatoria2=Float.valueOf((String.valueOf(tablaartc.getValueAt(i,2))));
 float tomatoria=Float.valueOf((String.valueOf(tablaartc.getValueAt(i,4))));
 
 subtm+=submatoria*cantatoria;     
 totalm+=tomatoria;
 cantm+=cantatoria2;
 //este me redondea las cantidades
 redo =subtm;
 roundOffsubtotal= Math.round(redo * 100.0) / 100.0;
 //este me redondea las cantidades
 redo =totalm;
 roundOfftotal= Math.round(redo * 100.0) / 100.0;
 
 redo3 =cantm;
 roundOffcant= Math.round(redo3 * 100.0) / 100.0;
     
 }
  
  String subtotalf="RD$ "+String.valueOf(roundOffsubtotal);
  String totalf="RD$ "+String.valueOf(roundOfftotal);
  String cantf=String.valueOf(roundOffcant);
  String  cuentaf=String.valueOf(totalfila); 
  if (cantis.equals("0")) {
         JOptionPane.showMessageDialog(null,"ESTE TIPO DE ARTICULO  NO CUENTA CON INVENTARIO");
              }
     
     
     else{
     try {
         con=new Conectar();
    Connection reg=con.getConnection();
    JasperReport reporte = null;
    Map parametro = new HashMap();
    //aqui se recogen los parametros
//    //recuerda compilar el reporte cada vez que agregues un parametro
   parametro.put("id_ti_art",idtipart);
   parametro.put("tipo_art","-"+tipus);
   parametro.put("total_costo",totalf);
   parametro.put("total_art",cantf);
   parametro.put("total_ti_art",cuentaf);
   String path ="src\\report\\Reportat.jasper";
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
 }
      
  public void limpiador(){
     id_ti_art.setText("");
        tipo_art.setText("");
    }     
 
  void vaciono(){
     if(id_ti_art.getText().equals(""))
        {JOptionPane.showMessageDialog(null,"CODIGO DE ARTICULO EN BLANCO");
         id_ti_art.requestFocus();
         return;
        }
     else if(tipo_art.getText().equals(""))
        {JOptionPane.showMessageDialog(null,"DESCRIPCIÓN DE ARTICULO VACIO");
         tipo_art.requestFocus();
         return;
        }    
    
    
    }
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabltipart = new javax.swing.JTable();
        tipo_art = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        id_ti_art = new javax.swing.JTextField();
        Imprint = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaartc = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipos de articulos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(0, 51, 102));

        tabltipart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabltipart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabltipartMouseClicked(evt);
            }
        });
        tabltipart.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabltipartKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabltipart);

        tipo_art.setEditable(false);
        tipo_art.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tipo_artKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tipo de articulo:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ID del tipo:");

        id_ti_art.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                id_ti_artKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                id_ti_artKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                id_ti_artKeyTyped(evt);
            }
        });

        Imprint.setText("IMPRIMIR [P]");
        Imprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImprintActionPerformed(evt);
            }
        });

        tablaartc.setBackground(new java.awt.Color(0, 51, 102));
        tablaartc.setForeground(new java.awt.Color(0, 51, 102));
        tablaartc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaartc.setFocusable(false);
        tablaartc.setGridColor(new java.awt.Color(0, 51, 102));
        tablaartc.setOpaque(false);
        tablaartc.setRequestFocusEnabled(false);
        tablaartc.setRowSelectionAllowed(false);
        tablaartc.setSelectionBackground(new java.awt.Color(0, 51, 102));
        tablaartc.setSelectionForeground(new java.awt.Color(0, 51, 102));
        tablaartc.setShowHorizontalLines(false);
        tablaartc.setShowVerticalLines(false);
        tablaartc.setUpdateSelectionOnSort(false);
        tablaartc.setVerifyInputWhenFocusTarget(false);
        jScrollPane2.setViewportView(tablaartc);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(id_ti_art, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tipo_art, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(249, 249, 249)
                        .addComponent(Imprint)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(id_ti_art, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tipo_art, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(Imprint)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void tabltipartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabltipartMouseClicked
        String idtipart=tabltipart.getValueAt(tabltipart.getSelectedRow(),0).toString();
        String tipus=tabltipart.getValueAt(tabltipart.getSelectedRow(),1).toString();
        String distrups=tabltipart.getValueAt(tabltipart.getSelectedRow(),2).toString();
        id_ti_art.setText(idtipart);
        tipo_art.setText(tipus);
       
    }//GEN-LAST:event_tabltipartMouseClicked

    private void id_ti_artKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_id_ti_artKeyReleased
        if (evt.getKeyCode()==8)
        {
           buscatabla1();
        this.id_ti_art.requestFocus();
        }
        else{
            buscatabla1();
            this.id_ti_art.requestFocus();
        }
    }//GEN-LAST:event_id_ti_artKeyReleased

    private void id_ti_artKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_id_ti_artKeyPressed
             
        if (evt.getKeyCode()==27) {

            this.dispose();
        }
        
        if (evt.getKeyCode()==80) {
            Imprint.doClick();
                        
        }
    }//GEN-LAST:event_id_ti_artKeyPressed

    private void tipo_artKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tipo_artKeyReleased
        if (evt.getKeyCode()==8)
        {
            buscatabla2();
            
        this.tipo_art.requestFocus();
        }
        else{
            buscatabla2();
            
            this.tipo_art.requestFocus();
        }
    }//GEN-LAST:event_tipo_artKeyReleased

    private void ImprintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImprintActionPerformed
                
        if (id_ti_art.getText().equals("")) {
          vaciono();             
        }
        else if(id_ti_art.getText().equals("")) {
          vaciono();             
        }
                  
        else{
        cuentabla();
        limpiador();
        cargatabla2();
        imprimir();
        
        }
        
        
        
    }//GEN-LAST:event_ImprintActionPerformed

    private void tabltipartKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabltipartKeyPressed
       if (evt.getKeyCode()==32) {    
        String idtipart=tabltipart.getValueAt(tabltipart.getSelectedRow(),0).toString();
        String tipus=tabltipart.getValueAt(tabltipart.getSelectedRow(),1).toString();
        String distrups=tabltipart.getValueAt(tabltipart.getSelectedRow(),2).toString();
        id_ti_art.setText(idtipart);
        tipo_art.setText(tipus);
        Imprint.requestFocus();
       } 
        
     
    }//GEN-LAST:event_tabltipartKeyPressed

    private void id_ti_artKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_id_ti_artKeyTyped
    int key = evt.getKeyChar();
    boolean numeros = key >= 48 && key <= 57 ;   
    if (!numeros)
    {
      evt.consume();
    }
    }//GEN-LAST:event_id_ti_artKeyTyped

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
            java.util.logging.Logger.getLogger(TipartformR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TipartformR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TipartformR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TipartformR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TipartformR().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Imprint;
    private javax.swing.JTextField id_ti_art;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaartc;
    private javax.swing.JTable tabltipart;
    private javax.swing.JTextField tipo_art;
    // End of variables declaration//GEN-END:variables
}
