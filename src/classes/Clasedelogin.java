/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

//import com.mysql.cj.protocol.Resultset;
import forms.Loginform;
import forms.Menu;
import java.sql.PreparedStatement;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Tec
 */
public class Clasedelogin {
    
  
   
     
    public  void IniciarS(JTextField nom_user,JPasswordField pass_user){
          int cosasz=0;
        try {
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
            JOptionPane.showMessageDialog(null,"Bienvenido");
                        Menu abrir = new Menu();
            abrir.setVisible(true);
       
        }
        else{JOptionPane.showMessageDialog(null,"Error en contraseña o usuario");
        }
        
        
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error"+e.toString());
        }
    
    }
    
    
}
