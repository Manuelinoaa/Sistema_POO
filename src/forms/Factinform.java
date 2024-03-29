package forms;

import classes.Conectar;
import classes.lista_art;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.time.LocalDate.now;
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
public class Factinform extends javax.swing.JFrame {  
    Conectar con=new Conectar();
    
     ResultSet rs;
     static String nomb;
static String apes;

public static void nombreuser(String nom,String ape) {            
    nomb=nom;
    apes=ape;
 }
    public Factinform() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/img/ico.png")).getImage());
        getContentPane().setBackground(Color.decode("#003366")); 
        this.setLocationRelativeTo(null); 
        num_fact();
        pagando.requestFocus();
          }

        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        clientrc = new javax.swing.JLabel();
        pagando = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        totalfc = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Imprimir = new javax.swing.JButton();
        devolvi = new javax.swing.JTextField();
        subtfc = new javax.swing.JTextField();
        itbisfc = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tablafactura = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        num_fac = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tipovent = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        clienid = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Facturacion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        clientrc.setForeground(new java.awt.Color(255, 255, 255));
        clientrc.setText("aquivacliente");

        pagando.setBackground(new java.awt.Color(0, 51, 102));
        pagando.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pagando.setForeground(new java.awt.Color(51, 255, 0));
        pagando.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pagando.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pagandoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pagandoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pagandoKeyTyped(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("RECIBÍ:");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("DE VUELTA:");

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
        Imprimir.setEnabled(false);
        Imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImprimirActionPerformed(evt);
            }
        });

        devolvi.setEditable(false);
        devolvi.setBackground(new java.awt.Color(0, 51, 102));
        devolvi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        devolvi.setForeground(new java.awt.Color(51, 255, 0));
        devolvi.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        devolvi.setText("0");

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
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID:");

        clienid.setForeground(new java.awt.Color(255, 255, 255));
        clienid.setText("aquivaicli");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(clientrc)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(clienid)))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(tipovent)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(num_fac))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(subtfc)
                                .addComponent(itbisfc)
                                .addComponent(totalfc)
                                .addComponent(pagando)
                                .addComponent(devolvi, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(Imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(69, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel10))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(num_fac)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(subtfc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addGap(2, 2, 2)
                                .addComponent(itbisfc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                                .addComponent(totalfc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pagando, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addGap(11, 11, 11)
                                .addComponent(devolvi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tipovent)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(clientrc)
                                .addComponent(clienid)))
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        
    }//GEN-LAST:event_jLabel8MouseClicked

    private void ImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImprimirActionPerformed
        String totaltring= String.valueOf(totalfc.getText().substring(4));
        if(pagando.getText().isEmpty())
        {
            pagando.requestFocus();
            JOptionPane.showMessageDialog(null,"NO ESTÁ SALDANDO LA FACTURA PARA PASAR A IMPRIMIR" );
        }
        else{
            guardar_fact();
            guarda_detail();
            act_cont();
            desc_inv();
            imprimir();
            //este me manda un numero para una condicion y si se cumple me limpia el menu
            Menu.cierre("1");
            this.dispose();               
           


             
        }
    }//GEN-LAST:event_ImprimirActionPerformed

    private void pagandoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pagandoKeyTyped
        int key = evt.getKeyChar();
        boolean numeros = key >= 48 && key <= 57;
        if (!numeros)
        {
            evt.consume();
        }
    }//GEN-LAST:event_pagandoKeyTyped

    private void pagandoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pagandoKeyReleased
        String totaltring= String.valueOf(totalfc.getText().substring(4));
        String devolvitring= String.valueOf(totalfc.getText().substring(4));

        if(pagando.getText().isEmpty())
        {
            float totalsp=Float.valueOf(totaltring)*-1;
            devolvi.setText(String.valueOf(totalsp));
            Imprimir.setEnabled(false);
        }
        else{
            float devu,reci,totale=0;

            reci= Float.valueOf(pagando.getText());
            totale = Float.valueOf(totaltring);
            devu= reci-totale;
            if (devu<0){
                Imprimir.setEnabled(false);
            }
            else if (devu==0){
                Imprimir.setEnabled(true);
                devolvi.setText(String.valueOf(devu));
            }
            else{
                Imprimir.setEnabled(true);}
            devolvi.setText(String.valueOf(devu));

        }

    }//GEN-LAST:event_pagandoKeyReleased

    private void pagandoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pagandoKeyPressed
if (evt.getKeyCode()==27) {
    this.dispose();
}
       
    }//GEN-LAST:event_pagandoKeyPressed

    public void imprimir(){
ArrayList listaf=new ArrayList(); 
for (int i=0; i<Tablafactura.getRowCount();i++){ 
lista_art organizar = new lista_art(Tablafactura.getValueAt(i,0).toString(),Tablafactura.getValueAt(i,1).toString(),Tablafactura.getValueAt(i,2).toString(),Tablafactura.getValueAt(i,3).toString(),Tablafactura.getValueAt(i,4).toString(),Tablafactura.getValueAt(i,5).toString());
listaf.add(organizar);
}
        
 try {
System.out.println("1");
JasperReport reporte=(JasperReport)JRLoader.loadObjectFromFile("Factuta.jasper");
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
    parametro.put("pagando",String.valueOf("RD$ "+pagando.getText()));
    parametro.put("devolvi",String.valueOf("RD$ "+devolvi.getText())); 
    parametro.put("empleado",nomb+" "+apes); 
JRBeanCollectionDataSource listax= new JRBeanCollectionDataSource(listaf);
System.out.println("3");
  //JasperPrint jprint=JasperFillManager.fillReport(reporte,parametro,listax);
  JasperPrint jprint=JasperFillManager.fillReport(reporte,parametro,listax);
  System.out.println("4"); 
  //,new JRBeanCollectionDataSource(listaf)
  JasperViewer view = new JasperViewer(jprint,false);
  System.out.println("5"); 
  view.setVisible(true);
  System.out.println("6"); 
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
    
public void guardar_fact(){
 Connection cargain = con.getConnection();
   String nom_fac=String.valueOf(this.num_fac.getText());
   String tipo_fact=String.valueOf(this.tipovent.getText());
   String fecha=String.valueOf(now());
   String sub_totals= String.valueOf(subtfc.getText().substring(4));
   String itbiss= String.valueOf(itbisfc.getText().substring(4));
   String totals= String.valueOf(totalfc.getText().substring(4));
   float sub_total=Float.valueOf(sub_totals);
   float itbis=Float.valueOf(itbiss);
   float total=Float.valueOf(totals);
   String nom_cliente=String.valueOf(this.clientrc.getText());
   String id_cliente=String.valueOf(this.clienid.getText());
   
    System.out.println(sub_totals+" "+itbiss+"" +totals);
   
    try {
        classes.Conectar objeto= new classes.Conectar();
        String queris = "INSERT INTO factura VALUES(?,?,?,?,?,?,?,?,?)";                  
        PreparedStatement insertar = objeto.getConnection().prepareStatement(queris);
        insertar.setString(1,nom_fac);
        insertar.setString(2,tipo_fact);
        insertar.setString(3,fecha);
        insertar.setFloat(4,sub_total);
        insertar.setFloat(5,itbis);
        insertar.setFloat(6,total);
        insertar.setString(7,id_cliente);
        insertar.setString(8,nom_cliente);
        insertar.setInt(9,0);
        insertar.executeUpdate();
    }
  catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Error "+ex.toString());
        }
}
  public void guarda_detail(){
    
      for (int i = 0; i < Tablafactura.getRowCount(); i++) {
   String nom_fac=String.valueOf(this.num_fac.getText());
   String id_articulo=String.valueOf(Tablafactura.getValueAt(i,0));
   String des_art=String.valueOf(Tablafactura.getValueAt(i,1));
   String cantidads= String.valueOf(Tablafactura.getValueAt(i,2));
   String precios= String.valueOf(Tablafactura.getValueAt(i,3));
   String importes= String.valueOf(Tablafactura.getValueAt(i,5));
   float cantidad=Float.valueOf(cantidads);
   float precio=Float.valueOf(precios);
   float importe=Float.valueOf(importes);
          try {
         classes.Conectar objeto= new classes.Conectar();
              String queris = "INSERT INTO fac_detail VALUES(?,?,?,?,?,?,?)"; 
        PreparedStatement insertar = objeto.getConnection().prepareStatement(queris);
        insertar.setString(1,nom_fac);
        insertar.setString(2,id_articulo);
        insertar.setString(3,des_art);
        insertar.setFloat(4,cantidad);
        insertar.setFloat(5,precio);
        insertar.setFloat(6,importe);
        insertar.setInt(7,0);
         insertar.executeUpdate();
                    } catch (Exception e) {
          }       
      }
  
  }

  public  void act_cont(){
    try{
         Connection cargain = con.getConnection();                
      classes.Conectar objeto= new classes.Conectar();
         String modin="UPDATE contador SET id_factura=id_factura+1";
        Statement modificar = objeto.getConnection().prepareStatement(modin);   
       int valor=modificar.executeUpdate(modin);
    }
       catch 
       (SQLException e) 
       {
           System.out.print(e.toString());
       }
  
  }
    
public void desc_inv(){
    for (int i = 0; i <Tablafactura.getRowCount() ; i++) {
    //contador que me traiga los datos de la tabla y la bbd
    String  codtabla=String.valueOf(Tablafactura.getValueAt(i,0));
    String  destabla=String.valueOf(Tablafactura.getValueAt(i,1));
    String  cantabla=String.valueOf(Tablafactura.getValueAt(i,2));
    float  cantablaf=Float.valueOf(cantabla);
    float  artbbd=0;
    float  ncant;
    System.out.println(destabla+" "+cantabla +"este de la tabla");
   Statement st;
    //esto carga la tabla de los contador         
    Connection cargain = con.getConnection(); 
    try {st=cargain.createStatement();
        String sql="select cant_art from articulos where cod_art like'"+codtabla+"'";
          rs=st.executeQuery(sql);
          rs.next();
          artbbd=rs.getFloat("cant_art");
    System.out.println(artbbd+" este es el de la bbd");    
    }       
    catch (SQLException e) {
            System.out.println("error"+e);
        }
     ncant=artbbd-cantablaf;   

     
      try{                     
      classes.Conectar objeto= new classes.Conectar();
         String modin2="UPDATE articulos SET cant_art='"+ncant+"' where cod_art like '"+codtabla+"' ";
          System.out.println(modin2);        
        Statement modificar = objeto.getConnection().prepareStatement(modin2);   
       int valor=modificar.executeUpdate(modin2);
    }
       catch 
       (Exception e) 
       {
           System.out.print(e.toString());
       }
     
     
     
     
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
            java.util.logging.Logger.getLogger(Factinform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Factinform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Factinform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Factinform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Factinform().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Imprimir;
    public static javax.swing.JTable Tablafactura;
    public static javax.swing.JLabel clienid;
    public static javax.swing.JLabel clientrc;
    public static javax.swing.JTextField devolvi;
    public static javax.swing.JTextField itbisfc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel num_fac;
    private static javax.swing.JTextField pagando;
    public static javax.swing.JTextField subtfc;
    public static javax.swing.JLabel tipovent;
    public static javax.swing.JTextField totalfc;
    // End of variables declaration//GEN-END:variables
}
