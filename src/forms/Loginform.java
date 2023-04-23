
package forms;
import classes.Clasedelogin;
import classes.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import classes.Conectar;
import classes.Conectar.*;
import java.awt.Color;
import java.text.DecimalFormat;
import javax.management.Descriptor;
import java.awt.Image;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;
public class Loginform extends javax.swing.JFrame {
Conectar con;
 static String tipou="";
  static String nuser="";
   static String auser="";
    public Loginform() {
        setIconImage(new ImageIcon(getClass().getResource("/img/ico.png")).getImage());
        getContentPane().setBackground(Color.decode("#003366"));
        initComponents();
       // con=new Conectar();
        //Connection reg=con.getConnection();
        nom_user.requestFocus();
        //aqui esta el codigo que dice si esta conectada la base de datos
         this.setLocationRelativeTo(null);
 classes.Conectar objeto = new classes.Conectar();
  objeto.getConnection();
  
    }
     
public void IniciarS()
{       try {
            //este prepara consultas para login   
            ResultSet rs=null;
            PreparedStatement ps=null;
            classes.Conectar objeto= new classes.Conectar();
            String consultin="SELECT * FROM `Users` WHERE users.nom_user=(?) AND users.pass_user=MD5((?));";
            ps=objeto.getConnection().prepareStatement(consultin);
            String passwoll=String.valueOf(pass_user.getPassword());    
            ps.setString(1,nom_user.getText());
            ps.setString(2,passwoll);
            rs = ps.executeQuery();
            
        if (rs.next()) {
                                   
            //este para abrir y llamar algo desde otro form recuerda poner el objeto publico
            Menu abrir = new Menu();
            abrir.setVisible(true); 
            this.setVisible(false);
             tipou=rs.getString("tipo_user");
             nuser=rs.getString("nomb_em");
             auser=rs.getString("apelli_em");
           
            //con esto se definen los roles de usuario tipo desactivar algo
            if (tipou.equals("1")) 
            { //recibidor es un texboxx que te da el saludo
                 abrir.recibidor.setText("Bienvenido, Administrador: "+nuser+" "+auser);         
            Cuadraform.nombreuser(nuser, auser);
            Factinform.nombreuser(nuser, auser);
            FactinformC.nombreuser(nuser, auser);
            }
            if (tipou.equals("2")) 
            { 
                 
                abrir.recibidor.setText("Bienvenido, Empleado: "+nuser+" "+auser);  
                 Cuadraform.nombreuser(nuser, auser);
                 Factinform.nombreuser(nuser, auser);
                 FactinformC.nombreuser(nuser, auser);
                abrir.MenuEmp.setEnabled(false);
              abrir.artmen.setEnabled(false);
             }
            
             JOptionPane.showMessageDialog(null,"Bienvenido: "+nuser+" "+auser);
        }
        else{
            JOptionPane.showMessageDialog(null,"Error en contraseña o usuario");
        }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error"+e.toString());
        }}





   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Entrar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        nom_user = new javax.swing.JTextField();
        pass_user = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        enviador = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setForeground(java.awt.Color.white);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LOGIN");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Contraseña:");

        Entrar.setBackground(new java.awt.Color(0, 102, 255));
        Entrar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Entrar.setForeground(new java.awt.Color(255, 255, 255));
        Entrar.setText("Entrar");
        Entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EntrarActionPerformed(evt);
            }
        });
        Entrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                EntrarKeyPressed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 51, 51));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        nom_user.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nom_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nom_userActionPerformed(evt);
            }
        });
        nom_user.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nom_userKeyPressed(evt);
            }
        });

        pass_user.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pass_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pass_userActionPerformed(evt);
            }
        });
        pass_user.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pass_userKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("SDIM");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(enviador))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pass_user, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(150, 150, 150)
                            .addComponent(jLabel3))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(129, 129, 129)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(166, 166, 166)
                            .addComponent(jButton2))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(160, 160, 160)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(67, 67, 67)
                            .addComponent(nom_user, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(68, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(Entrar, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(1, 1, 1)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(nom_user, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(enviador))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pass_user, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Entrar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//ESTE ME PREGUNTA SI DESEO ELIMINAR EL ARTICULO 
int opcion = JOptionPane.showConfirmDialog(null, "Desea salir?", "Aviso", JOptionPane.YES_NO_OPTION);
if (opcion == 0) { //The ISSUE is here
 this.dispose();    }
else {
   System.out.print("no");}
    }//GEN-LAST:event_jButton2ActionPerformed

   
    private void nom_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nom_userActionPerformed
        
    }//GEN-LAST:event_nom_userActionPerformed

    private void EntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EntrarActionPerformed
        String Us=String.valueOf(nom_user.getText());
        if (Us.equals("")){
            JOptionPane.showMessageDialog(null,"NOMBRE VACIO");
        nom_user.requestFocus();
        }
        String CN=String.valueOf(pass_user.getPassword());

        if(CN.equals("")){
        JOptionPane.showMessageDialog(null,"Contraseña vacia");
        pass_user.requestFocus();
        }
        else{
        IniciarS();
        }
        
        
        //no me borres yo funciono para hacer el login con una clase
       // classes.Clasedelogin objetoClasedelogin=new classes.Clasedelogin();
      //  objetoClasedelogin.validaruser(nom_user,pass_user);     
    }//GEN-LAST:event_EntrarActionPerformed

    private void pass_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pass_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pass_userActionPerformed

    private void nom_userKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nom_userKeyPressed
        String Us=String.valueOf(nom_user.getText());
        if (evt.getKeyCode()==10) {
            if (Us.equals("")){
            JOptionPane.showMessageDialog(null,"NOMBRE VACIO");
        nom_user.requestFocus();
        }
            else{
            pass_user.requestFocus();}
            
        }
        
    }//GEN-LAST:event_nom_userKeyPressed

    private void pass_userKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pass_userKeyPressed
 String CN=String.valueOf(pass_user.getPassword());
        if (evt.getKeyCode()==10) {
            if (CN.equals("")){
            JOptionPane.showMessageDialog(null,"CONTRASEÑA VACIO");
        pass_user.requestFocus();
        }
            else{
          Entrar.requestFocus();}
            
        }        // TODO add your handling code here:
    }//GEN-LAST:event_pass_userKeyPressed

    private void EntrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EntrarKeyPressed
        if (evt.getKeyCode()==10) {
            IniciarS();
        }
    }//GEN-LAST:event_EntrarKeyPressed

    

    
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
            java.util.logging.Logger.getLogger(Loginform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Loginform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Loginform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Loginform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Loginform().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Entrar;
    public javax.swing.JLabel enviador;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField nom_user;
    private javax.swing.JPasswordField pass_user;
    // End of variables declaration//GEN-END:variables
}
