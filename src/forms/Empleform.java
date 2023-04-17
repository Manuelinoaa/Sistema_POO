/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;
import classes.Conectar;
import com.sun.tools.javac.Main;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import forms.Loginform;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.text.DecimalFormat;
import javax.management.Descriptor;
import java.awt.Image;
import javax.swing.ImageIcon;
public class Empleform extends javax.swing.JFrame {
    
    
    
    
    
Conectar con=new Conectar();
Statement st;
ResultSet rs;
    public Empleform() {
        setIconImage(new ImageIcon(getClass().getResource("/img/ico.png")).getImage());
        getContentPane().setBackground(Color.decode("#003366"));
        initComponents();
       String ab=null;
       pass_user.setText("");
       pass_user.setEnabled(false); 
       this.setLocationRelativeTo(null);
 cargatabla();
    }

    public void cargatabla(){
       Statement st;
        try {
             //esto carga la tabla de los articulos         
         Connection cargain = con.getConnection();
         DefaultTableModel modelt = new DefaultTableModel();
         TableRowSorter<TableModel> ordenartabla = new TableRowSorter<TableModel>(modelt);
         Tablaemp.setRowSorter(ordenartabla);
         String sql="";
         modelt.addColumn("ID");
         modelt.addColumn("Usuario");
        // modelt.addColumn("Contraseña de usuario");
         modelt.addColumn("Tipo de usuario");
         modelt.addColumn("Nombre");
         modelt.addColumn("Apellido");
         Tablaemp.setModel(modelt);
         sql="select * from users";
         String[]datart=new String[6];       
    try {
             st=cargain.createStatement();
             rs=st.executeQuery(sql);
             while(rs.next()){
             datart[0]=rs.getString(1);
             datart[1]=rs.getString(2);
            // datart[2]=rs.getString(3);
             datart[2]=rs.getString(4);
             datart[3]=rs.getString(5);
             datart[4]=rs.getString(6);
             modelt.addRow(datart);
             }
             Tablaemp.setModel(modelt);
             Tablaemp.setDefaultEditor(Object.class, null);
        }
            catch (SQLException e) {
            System.out.println("error"+e);
        }
    }
    catch (Exception e) {
       }    
    }
   public void agretabla(){
     Connection cargain = con.getConnection();
     String nomb_em = this.nomb_em.getText();
     String apelli_em = this.apelli_em.getText();
     String nom_user = this.nom_user.getText();
     String pass_userx=String.valueOf(pass_user.getPassword());  
     String ab = null;
    if (jRadioButton1.isSelected())
         {  ab="1";
           }
       else{ ab ="2";
       }
    String tipo_user=String.valueOf(ab);
    try {
        classes.Conectar objeto= new classes.Conectar();
        String queris = "INSERT INTO users VALUES(?,?,MD5(?),?,?,?)";
        PreparedStatement insertar = objeto.getConnection().prepareStatement(queris);
        insertar.setString(1,"0");
        insertar.setString(2,nom_user);
        insertar.setString(3,pass_userx);
        insertar.setString(4,tipo_user);
        insertar.setString(5,nomb_em);
        insertar.setString(6, apelli_em);
        insertar.executeUpdate();
        JOptionPane.showMessageDialog(null,"El usuario: "+nom_user+" ha sido Creado");
        
        
   }
  catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Error "+ex.toString());
        }}
   
 
   public void elimin(){
       try{
       String id=Tablaemp.getValueAt(Tablaemp.getSelectedRow(),0).toString();
       String nomus=Tablaemp.getValueAt(Tablaemp.getSelectedRow(),1).toString();
       String elin ="DELETE FROM users WHERE id_user="+id;
       classes.Conectar objeto= new classes.Conectar();
       Statement eliminar = objeto.getConnection().prepareStatement(elin);   
       int valor=eliminar.executeUpdate(elin);
       if (valor==1)
       {
         JOptionPane.showMessageDialog(null,"El usuario: "+nomus+" ha sido ELIMINADO");
        nom_user.setText("");
        nomb_em.setText("");
        apelli_em.setText("");
        jRadioButton1.setSelected(true);
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
   
   public void modifica(){
    try{
       String id=Tablaemp.getValueAt(Tablaemp.getSelectedRow(),0).toString();
       String nomus=Tablaemp.getValueAt(Tablaemp.getSelectedRow(),1).toString();
       String passwoll=String.valueOf(pass_user.getPassword());
       String ab = null;
       if (jRadioButton2.isSelected())
         {  ab="1";
           }
       else{ ab ="2";
       }
        if (chepsw.isSelected()) {
       String tiers=String.valueOf(ab);
      String modin="UPDATE users SET nom_user ='"+nom_user.getText()+"',pass_user=MD5('"+passwoll+"'),tipo_user='"+tiers+"',nomb_em='"+nomb_em.getText()+"',apelli_em='"+apelli_em.getText()+"' WHERE `users`.`id_user` ="+id+";";
       classes.Conectar objeto= new classes.Conectar();
       Statement modificar = objeto.getConnection().prepareStatement(modin);   
       int valor=modificar.executeUpdate(modin);
       if (valor==1)
       {
         JOptionPane.showMessageDialog(null,"El usuario con ID: "+id+" ha sido MODIFICADO");
           System.out.println(tiers);
       limpiador();
       }       
       else{
               System.out.println("NO ERROSS");
               }
        }
        else{
        String tiers=String.valueOf(ab);
      String modin="UPDATE users SET nom_user ='"+nom_user.getText()+"',tipo_user='"+tiers+"',nomb_em='"+nomb_em.getText()+"',apelli_em='"+apelli_em.getText()+"' WHERE `users`.`id_user` ="+id+";";
       classes.Conectar objeto= new classes.Conectar();
       Statement modificar = objeto.getConnection().prepareStatement(modin);   
       int valor=modificar.executeUpdate(modin);
       if (valor==1)
       {
         JOptionPane.showMessageDialog(null,"El usuario con ID: "+id+" ha sido MODIFICADO");
           System.out.println(tiers);
       
       }       
       else{
               System.out.println("NO ERROSS");
               }
        }          
        
    }
    catch 
       (SQLException e) 
       {
           System.out.print(e.toString());
       } 
        
       
    }
       
   
   public void limpiador(){
   
    nom_user.setText("");
        nomb_em.setText("");
        apelli_em.setText("");
        pass_user.setText("");
        jRadioButton1.setSelected(true);
        chepsw.setSelected(false);
        pass_user.setEnabled(false);
   }
   
   
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tablaemp = new javax.swing.JTable();
        nomb_em = new javax.swing.JTextField();
        apelli_em = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nom_user = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        pass_user = new javax.swing.JPasswordField();
        nuevata = new javax.swing.JButton();
        modificata = new javax.swing.JButton();
        creata = new javax.swing.JButton();
        Elimanata = new javax.swing.JButton();
        chepsw = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Empleados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(0, 51, 102));
        jPanel1.setToolTipText("");

        Tablaemp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Tablaemp.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        Tablaemp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaempMouseClicked(evt);
            }
        });
        Tablaemp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TablaempKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(Tablaemp);

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
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Apellido:");

        nom_user.setText(" ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre de usuario:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Contraseña:");

        jRadioButton1.setBackground(new java.awt.Color(0, 52, 102));
        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Empleado");

        jRadioButton2.setBackground(new java.awt.Color(0, 52, 102));
        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText("Administrador");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tipo de usuario:");

        nuevata.setText("Actualizar/Limpiar");
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

        chepsw.setBackground(new java.awt.Color(0, 52, 102));
        chepsw.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        chepsw.setForeground(new java.awt.Color(255, 255, 255));
        chepsw.setText("Cambiar contreseña?");
        chepsw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chepswActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(creata, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(modificata))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(apelli_em, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                    .addComponent(nomb_em, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                    .addComponent(nom_user)
                                    .addComponent(pass_user))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jRadioButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton2)
                                .addGap(42, 42, 42))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        .addComponent(jLabel5))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(chepsw))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Elimanata)
                                        .addGap(30, 30, 30)
                                        .addComponent(nuevata)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(1, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(creata, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modificata, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Elimanata, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nuevata, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1)
                    .addComponent(nomb_em, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton1)
                    .addComponent(apelli_em, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nom_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pass_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(chepsw))
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    
    
    
    
    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
    
    }//GEN-LAST:event_formKeyPressed

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
      
           
            
        
    }//GEN-LAST:event_formKeyTyped

    private void creataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creataActionPerformed
        agretabla();
        cargatabla();
        limpiador();
    }//GEN-LAST:event_creataActionPerformed

    private void TablaempMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaempMouseClicked
        String nomus=Tablaemp.getValueAt(Tablaemp.getSelectedRow(),1).toString();
        String tipus=Tablaemp.getValueAt(Tablaemp.getSelectedRow(),2).toString();
        String nomes=Tablaemp.getValueAt(Tablaemp.getSelectedRow(),3).toString();
        String apes=Tablaemp.getValueAt(Tablaemp.getSelectedRow(),4).toString();
        nom_user.setText(nomus);
        if (tipus.equals("1")) {
            jRadioButton2.setSelected(true);
        }
        else{
            jRadioButton1.setSelected(true);}
        nomb_em.setText(nomes);
        apelli_em.setText(apes);
        chepsw.setSelected(false);
        pass_user.setEnabled(false);
    }//GEN-LAST:event_TablaempMouseClicked

    private void ElimanataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ElimanataActionPerformed
       elimin();
       cargatabla();
    }//GEN-LAST:event_ElimanataActionPerformed

    private void nuevataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevataActionPerformed
        cargatabla();
        limpiador();
        pass_user.setText("");        pass_user.setText("");        pass_user.setText("");    }//GEN-LAST:event_nuevataActionPerformed

    private void modificataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificataActionPerformed
//aqui comprueba que la contraseña no este vacio o si no desea cambiarla
//tambien modifica la tabla 
        if (chepsw.isSelected()) {
           String passwoll=String.valueOf(pass_user.getPassword());
            if (passwoll.equals("")) {
            JOptionPane.showMessageDialog(null,"Si no desea cambiar contraseña desactive la opción cambiar contraseñá");
            
            }
            else{
                modifica();
                cargatabla();
                limpiador();
                
            }
                 
        }
        else if(chepsw.isSelected()==false) {
                modifica();
                cargatabla();
                limpiador();
                
        }

      
        

    }//GEN-LAST:event_modificataActionPerformed

    private void TablaempKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TablaempKeyPressed
          if (evt.getKeyCode()==27) {
            
              this.dispose();
        }
    }//GEN-LAST:event_TablaempKeyPressed

    private void chepswActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chepswActionPerformed
        if (chepsw.isSelected()==true) {
            pass_user.setEnabled(true);   
             
        }
        else if (chepsw.isSelected()==false) {
            pass_user.setEnabled(false);   
             
        }
             
        
    }//GEN-LAST:event_chepswActionPerformed
    
    public static void main(String args[]) {
       
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
            java.util.logging.Logger.getLogger(Empleform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Empleform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Empleform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Empleform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Empleform().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Elimanata;
    private javax.swing.JTable Tablaemp;
    private javax.swing.JTextField apelli_em;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox chepsw;
    private javax.swing.JButton creata;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modificata;
    private javax.swing.JTextField nom_user;
    private javax.swing.JTextField nomb_em;
    private javax.swing.JButton nuevata;
    private javax.swing.JPasswordField pass_user;
    // End of variables declaration//GEN-END:variables
}
