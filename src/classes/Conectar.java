
package classes;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class Conectar {
   //conectador de base de datos
    String url="jdbc:mysql://localhost/sistema_db"
            +"?useUnicode=true&use"+"JDBCCompliantTimezoneShift=true&useLegacyDatimeCode=false&"
            +"ServerTimezone=UTC";
    String user="root";
    String password="12345678";
    String driver="com.mysql.cj.jdbc.Driver";
    Statement st;
    ResultSet rs;
  
    //propiedad que conecta a la base de datos
    public Connection getConnection(){
        Connection con;   
        con=null;
        try{
        Class.forName(driver);
        con= DriverManager.getConnection(url,user,password);
        if(con!=null){
        System.out.println("CONECTADO");
      
        }}    
        catch(ClassNotFoundException |SQLException e){   
        System.out.println("ERROR!!"+e);   
        }
        return con;
    }
   
   }
    
    //public void desconectar(){
   // conn=null;}
    

