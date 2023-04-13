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
import javax.swing.ImageIcon;

/**
 *
 * @author Tec
 */
public class Tipartform extends javax.swing.JFrame {
    
     Conectar con;
    //este declara la variable de conexion
    public Tipartform() {
         setIconImage(new ImageIcon(getClass().getResource("/img/ico.png")).getImage());
        getContentPane().setBackground(Color.decode("#003366"));
     initComponents();
     con=new Conectar();
    Connection reg=con.getConnection();
     this.setLocationRelativeTo(null);
    Statement st;
    ResultSet rs;
    cargatabla();
    id_ti_art.requestFocus();
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
   
   
   
   public void agretabla(){
     Statement st;
       Statement st2;
       ResultSet rs;
       ResultSet rs2;
    Connection cargain = con.getConnection();
    int id_ti_art = Integer.valueOf(this.id_ti_art.getText());
    String tipo_art = this.tipo_art.getText();
    String dist_art = this.dist_art.getSelectedItem().toString();
    //desde aqui para no aceptar dobles
    boolean dobleno=false;
    String sql="select * from tipo_art";
    String CONINT="";
    try {
             st=cargain.createStatement();
             rs=st.executeQuery(sql);
             while(rs.next()){
             CONINT=rs.getString(1);
                 if (CONINT.equals(this.id_ti_art.getText())) {
                     dobleno=true;
                 }
             }
    }
    catch (SQLException e) {
            System.out.println("error"+e);}
    
    
 
 if (dobleno==true) {
              JOptionPane.showMessageDialog(null,"El articulo: "+id_ti_art+" ya está agregado");
          }            
 else{
      //hasta aqui para no aceptar dobles
     try {
    classes.Conectar objeto= new classes.Conectar();
        String queris = "INSERT INTO tipo_art VALUES(?,?,?)";
        PreparedStatement insertar = objeto.getConnection().prepareStatement(queris);
       insertar.setInt(1,id_ti_art);
       insertar.setString(2,tipo_art);
       insertar.setString(3,dist_art);
       insertar.executeUpdate();
       JOptionPane.showMessageDialog(null,"El tipo de articulo: "+tipo_art+" ha sido AÑADIDO");      
        
   }
  catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Error "+ex.toString());}
 limpiador();         
 }

   }
   public void elimin(){
       try{
       String id=tabltipart.getValueAt(tabltipart.getSelectedRow(),0).toString();
       String nomus=tabltipart.getValueAt(tabltipart.getSelectedRow(),1).toString();
       String elin ="DELETE FROM tipo_art WHERE id_ti_art="+id;
       classes.Conectar objeto= new classes.Conectar();
       Statement eliminar = objeto.getConnection().prepareStatement(elin);   
       int valor=eliminar.executeUpdate(elin);
       if (valor==1)
       {
         JOptionPane.showMessageDialog(null,"El tipo de articulo: "+nomus+" ha sido ELIMINADO");
        id_ti_art.setText("");
        tipo_art.setText("");
           }       
       else{
               System.out.println("NO ERROSS");
               }}
       catch 
       (SQLException e) 
       {
           System.out.print(e.toString());
       }
       
   }
   
   void vaciono(){
     if(id_ti_art.getText().equals(""))
        {JOptionPane.showMessageDialog(null,"CODIGO DE ARTICULO EN BLANCO");
         id_ti_art.requestFocus();
         return;
        }
     else if(tipo_art.getText().equals(""))
        {JOptionPane.showMessageDialog(null,"TIPO DE ARTICULO VACIO");
         tipo_art.requestFocus();
         return;
        }
   }
      public void limpiador(){
     id_ti_art.setText("");
        tipo_art.setText("");                  
     dist_art.setSelectedIndex(0);
    
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
             
             
             
             
             
             //datart[3]=rs.getString(4);          
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

 public void modifica(){
    try{
       String idtipm=id_ti_art.getText();
       String tipoam=tipo_art.getText();
       String distm=String.valueOf(dist_art.getSelectedItem());
       System.out.println(" hey"+distm);
       String modin="UPDATE tipo_art SET tipo_art='"+this.tipo_art.getText()+"',dist_art='"+distm+"' WHERE `tipo_art`.`id_ti_art`="+idtipm+";";
       classes.Conectar objeto= new classes.Conectar();
       Statement modificar = objeto.getConnection().prepareStatement(modin);   
       int valor=modificar.executeUpdate(modin);
       if (valor==1)
       {
         JOptionPane.showMessageDialog(null,"El articulo ha sido MODIFICADO");
       limpiador();
       }       
       else{
               System.out.println("NO ERROSS");
               }}
       catch 
       (SQLException e) 
       {
           System.out.print(e.toString());
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
        jLabel3 = new javax.swing.JLabel();
        dist_art = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        id_ti_art = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        agregata = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

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
        jScrollPane1.setViewportView(tabltipart);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tipo_art.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tipo_artKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tipo de articulo:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tipo de distribucion de articulo:");

        dist_art.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Unidad", "Libras", "Kilogramos", "Paquete" }));

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
        });

        jButton1.setText("Eliminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        agregata.setText("Agregar");
        agregata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregataActionPerformed(evt);
            }
        });

        jButton3.setText("Actualizar/Limpiar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Modificar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(dist_art, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel1))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(id_ti_art, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tipo_art, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(agregata, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)))))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(agregata, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(id_ti_art, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tipo_art, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(dist_art, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregataActionPerformed
 if (id_ti_art.getText().equals("")) {
          vaciono();             
        }
        else if(tipo_art.getText().equals("")) {
          vaciono();                                      
        }          
        else{
        agretabla();
        cargatabla();      
        }
        
        
     
    }//GEN-LAST:event_agregataActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
     cargatabla();
     limpiador();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
int opcion = JOptionPane.showConfirmDialog(null, "Desea eliminar este articulo ?", "Aviso", JOptionPane.YES_NO_OPTION);
if (opcion == 0) { //The ISSUE is here
   System.out.print("si");
       elimin();  
 cargatabla();
        
       limpiador();
}
else {
   System.out.print("no");
}
        
        
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tabltipartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabltipartMouseClicked
        String idtipart=tabltipart.getValueAt(tabltipart.getSelectedRow(),0).toString();
        String tipus=tabltipart.getValueAt(tabltipart.getSelectedRow(),1).toString();
        String distrups=tabltipart.getValueAt(tabltipart.getSelectedRow(),2).toString();
        id_ti_art.setText(idtipart);
        tipo_art.setText(tipus);
         if(distrups.equals("Unidad")){
        dist_art.setSelectedIndex(0);
        }
        if(distrups.equals("Libras")){
        dist_art.setSelectedIndex(1);
        }
        if(distrups.equals("Kilogramos"))
        {
        dist_art.setSelectedIndex(2);
        }
        if(distrups.equals("Paquete")){
        dist_art.setSelectedIndex(3);
        }    
    }//GEN-LAST:event_tabltipartMouseClicked

    private void id_ti_artKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_id_ti_artKeyPressed
        if (evt.getKeyCode()==27) {
            
              this.dispose();
        }    
    }//GEN-LAST:event_id_ti_artKeyPressed

    private void id_ti_artKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_id_ti_artKeyReleased
if (evt.getKeyCode()==8)
    {
    cargatabla();
    
     }
    else{
    buscatabla1(); 
     this.id_ti_art.requestFocus();
}
    }//GEN-LAST:event_id_ti_artKeyReleased

    private void tipo_artKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tipo_artKeyReleased
      if (evt.getKeyCode()==8)
    {
    cargatabla();
    
     }
    else{
    buscatabla2(); 
     this.tipo_art.requestFocus();
}
    }//GEN-LAST:event_tipo_artKeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    int opcion = JOptionPane.showConfirmDialog(null, "Desea modificar este articulo ?", "Aviso", JOptionPane.YES_NO_OPTION);
if (opcion == 0) { //The ISSUE is here
 System.out.print("si");
  vaciono();
       modifica();
       cargatabla();
       limpiador();      
}
else {
   System.out.print("no");
}         
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Tipartform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tipartform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tipartform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tipartform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tipartform().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregata;
    private javax.swing.JComboBox<String> dist_art;
    private javax.swing.JTextField id_ti_art;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabltipart;
    private javax.swing.JTextField tipo_art;
    // End of variables declaration//GEN-END:variables
}
