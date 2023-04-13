/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.TableRowSorter;import classes.Conectar;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.management.Descriptor;
import java.awt.Color;
import java.text.DecimalFormat;
import javax.management.Descriptor;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Clientform extends javax.swing.JFrame {
    Conectar con=new Conectar();
    Statement st;
    ResultSet rs;
    public Clientform() {
         setIconImage(new ImageIcon(getClass().getResource("/img/ico.png")).getImage());
        getContentPane().setBackground(Color.decode("#003366"));
        initComponents();
        cargatabla();
         buscarcli.requestFocus();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaclient = new javax.swing.JTable();
        nom_cliente = new javax.swing.JTextField();
        nuevata = new javax.swing.JButton();
        modificata = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        creata = new javax.swing.JButton();
        Elimanata = new javax.swing.JButton();
        credito_tipo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        buscarcli = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Clientes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        tablaclient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaclient.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tablaclient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaclientMouseClicked(evt);
            }
        });
        tablaclient.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaclientKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaclient);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        nuevata.setText("Nuevo");
        nuevata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevataActionPerformed(evt);
            }
        });

        modificata.setText("Modificar");
        modificata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificataActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre de cliente:");

        creata.setText("Crear");
        creata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creataActionPerformed(evt);
            }
        });

        Elimanata.setText("Eliminar");
        Elimanata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ElimanataActionPerformed(evt);
            }
        });

        credito_tipo.setText(" ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Credito Maximo: ");

        buscarcli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buscarcliKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Buscar:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(credito_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nom_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(jLabel2)
                                .addGap(89, 89, 89))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(creata, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)))
                        .addComponent(modificata)
                        .addGap(40, 40, 40)
                        .addComponent(Elimanata, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(nuevata, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(buscarcli, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscarcli, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(creata, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modificata, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Elimanata, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nuevata, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nom_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(credito_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(96, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void cargatabla(){
       Statement st;
        try {
             //esto carga la tabla de los empleados         
         Connection cargain = con.getConnection();
         DefaultTableModel modelt = new DefaultTableModel();
         TableRowSorter<TableModel> ordenartabla = new TableRowSorter<>(modelt);
         tablaclient.setRowSorter(ordenartabla);
         modelt.addColumn("ID cliente");
         modelt.addColumn("Nombre cliente");
         modelt.addColumn("Max.Credito");
         modelt.addColumn("Credito pendiente");
         modelt.addColumn("Facturas");
         tablaclient.setModel(modelt);
         String sql="select * from clientes";
         String[]datart=new String[5];
    try {
             st=cargain.createStatement();
             rs=st.executeQuery(sql);
             while(rs.next()){
             datart[0]=rs.getString(1);
             datart[1]=rs.getString(2);
             datart[2]=rs.getString(3);
             modelt.addRow(datart);
             //este codigo no deja editar la tabla OJOOOO!!!
             tablaclient.setDefaultEditor(Object.class, null);
             }
             tablaclient.setModel(modelt);
        } catch (SQLException e) {
            System.out.println("error"+e);
        }
    }
    catch (Exception e) {
       }    
   }

 public void agretabla(){
     Connection cargain = con.getConnection();
     String nomb_client = this.nom_cliente.getText();
     String cre_lim = this.credito_tipo.getText();
          

    try {
        classes.Conectar objeto= new classes.Conectar();
        String queris = "INSERT INTO clientes VALUES(?,?,?)";
        PreparedStatement insertar = objeto.getConnection().prepareStatement(queris);
        insertar.setString(1,"2");
        insertar.setString(2,nomb_client);
        insertar.setString(3,cre_lim);
        insertar.executeUpdate();
        JOptionPane.showMessageDialog(null,"El cliente: "+nomb_client+" ha sido Creado");
      
   }
  catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Error "+ex.toString());
        }}

 public void elimin(){
       try{
       String id=tablaclient.getValueAt(tablaclient.getSelectedRow(),0).toString();
       String nomus=tablaclient.getValueAt(tablaclient.getSelectedRow(),1).toString();
       String elin ="DELETE FROM clientes WHERE id_cliente="+id;
       classes.Conectar objeto= new classes.Conectar();
       Statement eliminar = objeto.getConnection().prepareStatement(elin);   
       int valor=eliminar.executeUpdate(elin);
           System.out.println(elin);
       if (valor==1)
       {
         JOptionPane.showMessageDialog(null,"El cliente: "+nomus+" ha sido ELIMINADO");
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
  
 public void limpiador(){
   
    nom_cliente.setText("");
    credito_tipo.setText("");
    buscarcli.setText("");
        
   }
 
 
    private void tablaclientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaclientMouseClicked
        //pasar de tabla client a textbox
        
        String nomus=tablaclient.getValueAt(tablaclient.getSelectedRow(),1).toString();
        String tipus=tablaclient.getValueAt(tablaclient.getSelectedRow(),2).toString();
       nom_cliente.setText(nomus);
       credito_tipo.setText(tipus);
    }//GEN-LAST:event_tablaclientMouseClicked

    private void tablaclientKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaclientKeyPressed
if (evt.getKeyCode()==27) {
       this.dispose();
       }     
    }//GEN-LAST:event_tablaclientKeyPressed

    private void nuevataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevataActionPerformed
limpiador();
    }//GEN-LAST:event_nuevataActionPerformed

    private void modificataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificataActionPerformed
       
    }//GEN-LAST:event_modificataActionPerformed

    private void creataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creataActionPerformed
agretabla();
cargatabla();
    }//GEN-LAST:event_creataActionPerformed

    private void ElimanataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ElimanataActionPerformed
elimin();
cargatabla();
limpiador();
    }//GEN-LAST:event_ElimanataActionPerformed

    private void buscarcliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarcliKeyPressed
        if (evt.getKeyCode()==27) {
       this.dispose();
       }  
    }//GEN-LAST:event_buscarcliKeyPressed

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
            java.util.logging.Logger.getLogger(Clientform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Clientform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Clientform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Clientform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Clientform().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Elimanata;
    private javax.swing.JTextField buscarcli;
    private javax.swing.JButton creata;
    private javax.swing.JTextField credito_tipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modificata;
    private javax.swing.JTextField nom_cliente;
    private javax.swing.JButton nuevata;
    private javax.swing.JTable tablaclient;
    // End of variables declaration//GEN-END:variables
}
