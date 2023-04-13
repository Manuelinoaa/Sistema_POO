package forms;

import classes.ColorealResaltar;
import java.sql.Connection;
import java.sql.*;
import javax.swing.JOptionPane;
import classes.Conectar;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Color;
public class Artform extends javax.swing.JFrame {
 ColorealResaltar crd=new ColorealResaltar();
    Conectar con;
    public Artform() {
        initComponents();
        con=new Conectar();
   Connection reg=con.getConnection();
    Statement st;
    ResultSet rs;
    cargatabla();
    cod_art.requestFocus();
    llenacombo();
    setIconImage(new ImageIcon(getClass().getResource("/img/ico.png")).getImage());
       getContentPane().setBackground(Color.decode("#003366"));
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        pre_vent = new javax.swing.JTextField();
        cod_art = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cant_art = new javax.swing.JTextField();
        punto_reorden = new javax.swing.JTextField();
        des_art = new javax.swing.JTextField();
        pre_com = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        agregar = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        actualiza = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        id_tipo = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tablaartt = new javax.swing.JTable();
        ITBIS = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Precio de venta:");

        pre_vent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pre_ventActionPerformed(evt);
            }
        });

        cod_art.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cod_artActionPerformed(evt);
            }
        });
        cod_art.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cod_artKeyPressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Punto de reorden:");

        punto_reorden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                punto_reordenActionPerformed(evt);
            }
        });

        des_art.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                des_artActionPerformed(evt);
            }
        });
        des_art.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                des_artKeyPressed(evt);
            }
        });

        pre_com.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pre_comActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Codigo del articulo:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cantidad del articulo:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Descripcion del articulo:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Precio de compra:");

        agregar.setText("Agregar");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        modificar.setText("Modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        actualiza.setText("Actualizar/Limpiar");
        actualiza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizaActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Tipo de articulo:");

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Articulos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(0, 51, 102));

        Tablaartt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Tablaartt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaarttMouseClicked(evt);
            }
        });
        Tablaartt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TablaarttKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(Tablaartt);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        ITBIS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0%", "2%", "8%", "9%", "16%", "18%", "28%" }));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("ITBIS:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(11, 11, 11)
                                            .addComponent(jLabel3)
                                            .addGap(18, 18, 18)
                                            .addComponent(cant_art, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(18, 18, 18)
                                                .addComponent(des_art, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(id_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cod_art, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(62, 62, 62)
                                        .addComponent(agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(actualiza))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(ITBIS, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(7, 7, 7))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(324, 324, 324)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(pre_vent, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(punto_reorden, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(pre_com, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(agregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(modificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(actualiza, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(pre_com, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(cod_art, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pre_vent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(punto_reorden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(des_art, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cant_art, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ITBIS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))))
                .addGap(61, 61, 61))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void cargatabla(){
       Statement st;
       ResultSet rs;
        try {
             //esto carga la tabla de los articulos         
         Connection cargain = con.getConnection();
         DefaultTableModel modelt = new DefaultTableModel();
         TableRowSorter<TableModel> ordenartabla = new TableRowSorter<TableModel>(modelt);
         Tablaartt.setRowSorter(ordenartabla);
         String sql="";
         modelt.addColumn("Codigo");
         modelt.addColumn("Descripcion");
         modelt.addColumn("Cantidad");
         modelt.addColumn("Compra");
         modelt.addColumn("Precio de venta");
         modelt.addColumn("Punto de reorden");
         modelt.addColumn("ITBIS");
         Tablaartt.setModel(modelt);
         sql="select * from articulos order by cod_art";
         String[]datart=new String[7];       
         //String cod_art=String.valueOf(id_tipo.getSelectedItem().toString());
            
    try {
             st=cargain.createStatement();
             rs=st.executeQuery(sql);
             while(rs.next()){
             datart[0]=rs.getString(1);
             datart[1]=rs.getString(2);
             datart[2]=rs.getString(3);
             datart[3]=rs.getString(4);
             datart[4]=rs.getString(5);
             datart[5]=rs.getString(6);
             datart[6]=rs.getString(8);
             modelt.addRow(datart);
         
             
             }
             Tablaartt.setModel(modelt);
             Tablaartt.setDefaultRenderer(Object.class,crd);
             Tablaartt.setDefaultEditor(Object.class, null);
           
             
        }
            catch (SQLException e) {
            System.out.println("error"+e);
        }
    }
    catch (Exception ex) {
        
        System.out.println("GOKUU"+ex);
       }    
    }
public void agretabla(){
     
 
    Connection cargain = con.getConnection();
    //OBTENER VALOR DEL COMBO
    String cod_artC=String.valueOf(id_tipo.getSelectedItem().toString());
    //OBTENER EL PRIMER CARACTER DEL COMBO
    String cod_art2= String.valueOf(cod_artC.substring(0,1));
    int cod_art2int=Integer.valueOf(cod_art2);
    //JUNTAR LOS 2 VALORES PARA QUE SEAN IGUALES
    String cod_art3=String.valueOf(cod_art2+cod_art.getText());
    //CONVERTIRLOS A INT
    int cod_art4 = Integer.valueOf(cod_art3);      
    String des_art = this.des_art.getText();
    float cant_art = Float.valueOf(this.cant_art.getText());
    float pre_com=Float.valueOf(this.pre_com.getText());
    float pre_vent=Float.valueOf(this.pre_vent.getText());
    float punto_reorden=Float.valueOf(this.punto_reorden.getText()); 
    //esto hace que el itbis funcione
    String itbiss=String.valueOf(ITBIS.getSelectedItem().toString());
    int itbix=itbiss.length();
    String itbiss2="";
    if (itbix>2) {
   itbiss2=String.valueOf(itbiss.substring(0,2));
       }
    else{
   itbiss2=String.valueOf(itbiss.substring(0,1));
       }
    //para no aceptar 2 articulos con el mismo id
    int itbint=Integer.valueOf(itbiss2);
    boolean dobleno=false;
    int totalfila=Tablaartt.getRowCount();
            for(int i=0;i<(totalfila);i++){
            String submatoria=String.valueOf(Tablaartt.getValueAt(i,0));
               
            if (submatoria.equals(cod_art3)) {
                    dobleno=true;
                }                   
            }
          if (dobleno==true) {
              JOptionPane.showMessageDialog(null,"El articulo: "+cod_art3+" ya está agregado");
          } 
          else{
    
    
    try { 
           
          
          
        classes.Conectar objeto= new classes.Conectar();
        String queris = "INSERT INTO articulos VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement insertar = objeto.getConnection().prepareStatement(queris);
        insertar.setInt(1,cod_art4);
        insertar.setString(2,des_art);
        insertar.setFloat(3,cant_art);
        insertar.setFloat(4,pre_com);
        insertar.setFloat(5,pre_vent);
        insertar.setFloat(6, punto_reorden);
        insertar.setFloat(7,cod_art2int);
        insertar.setFloat(8,itbint);
        insertar.executeUpdate();
        JOptionPane.showMessageDialog(null,"El articulo: "+des_art+" ha sido AÑADIDO");
        
        
   }
  catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Error "+ex.toString());
           System.out.println(itbint);
  }}    
}
public void llenacombo(){
Statement st;
       ResultSet rs;
        try {
             //esto carga la tabla de los articulos         
         Connection cargain = con.getConnection();
                 
         String sql="";
         sql="select * from tipo_art";
         String codigobox="";
         String tipobox="";
    try {
             st=cargain.createStatement();
             rs=st.executeQuery(sql);
             while(rs.next()){
             codigobox=rs.getString(1);
             tipobox=rs.getString(2);
                 System.out.println();
                  id_tipo.addItem(codigobox+"-"+tipobox);
            }
             
        }
            catch (SQLException e) {
            System.out.println("error"+e);
        }

        }catch (Exception e) {
       }    


} 

public void llenacombo2(){
Statement st;
 ResultSet rs;
//para devolverme el tipo de articulo
    String cod_arts=this.Tablaartt.getValueAt(this.Tablaartt.getSelectedRow(),0).toString();
    String tipoa=cod_arts.substring(0,1);
    String devtipo=""; 
    String cachin=cod_arts;
    String cachin3="";
     try {
 //esto carga la tabla de los articulos         
        Connection cargain = con.getConnection();    
        String sql="";
        sql="select * from tipo_art";     
         try {
//esto es para cuando toque el item el combo cambie
        int cachint=cachin.length();
            if (cachint>=3) {
                cachin3=cachin.substring(1,3);
              System.out.println(cachin3);              
            }
            else{
            cachin3=cachin.substring(1,2);
            }
st=cargain.createStatement();
    rs=st.executeQuery(sql);
 while(rs.next()){

    devtipo =rs.getString(1);                  

if (devtipo.equals(tipoa)) {

    int kontar=Integer.valueOf(devtipo);                           
                        this.id_tipo.setSelectedIndex(kontar-1);}         
        } }
     catch (SQLException e) {
     System.out.println("error"+e);}
     }catch (Exception e) { }    
 //selecionas algo y te lo devuelve en los text 
        String des_arts=Tablaartt.getValueAt(Tablaartt.getSelectedRow(),1).toString();
        String cant_arts=Tablaartt.getValueAt(Tablaartt.getSelectedRow(),2).toString();
        String pre_coms=Tablaartt.getValueAt(Tablaartt.getSelectedRow(),3).toString();
        String pre_vens=Tablaartt.getValueAt(Tablaartt.getSelectedRow(),4).toString();
        String punto_res=Tablaartt.getValueAt(Tablaartt.getSelectedRow(),5).toString();
        String itbist=Tablaartt.getValueAt(Tablaartt.getSelectedRow(),6).toString();
     
//este se selecciona el itbis automaticamente
        if(itbist.equals("0.0")){
        ITBIS.setSelectedIndex(0);
        }
        if(itbist.equals("2.0")){
        ITBIS.setSelectedIndex(1);
        }
        if(itbist.equals("8.0"))
        {
        ITBIS.setSelectedIndex(2);
        }
        if(itbist.equals("9.0")){
        ITBIS.setSelectedIndex(3);
        }
         if(itbist.equals("16.0")){
        ITBIS.setSelectedIndex(4);
        }
         if(itbist.equals("18.0")){
        ITBIS.setSelectedIndex(5);
        }
         if(itbist.equals("28.0")){
        ITBIS.setSelectedIndex(6);
        }
         
        cod_art.setText(cachin3);
        des_art.setText(des_arts);
        cant_art.setText(cant_arts);
        pre_com.setText(pre_coms);
        pre_vent.setText(pre_vens);
        punto_reorden.setText(punto_res);

}

public void elimin(){
       try{
           
       String id=Tablaartt.getValueAt(Tablaartt.getSelectedRow(),0).toString();
       String nomus=Tablaartt.getValueAt(Tablaartt.getSelectedRow(),1).toString();
       String elin ="DELETE FROM articulos WHERE cod_art="+id;
       classes.Conectar objeto= new classes.Conectar();
       Statement eliminar = objeto.getConnection().prepareStatement(elin);   
       int valor=eliminar.executeUpdate(elin);
       if (valor==1)
       {
         JOptionPane.showMessageDialog(null,"El articulo: "+nomus+" ha sido ELIMINADO");
        cod_art.setText("");
        des_art.setText("");
        cant_art.setText("");
        pre_vent.setText("");
        pre_com.setText("");
        punto_reorden.setText("");
        id_tipo.setSelectedIndex(0);
        ITBIS.setSelectedIndex(0);
       }       
       else{
               System.out.println("id "+id);           
               }}
       catch 
       (SQLException e) 
       {
           System.out.print(e.toString());
       }
}   
   
public void modifica(){
    try{
         Connection cargain = con.getConnection();
    //OBTENER VALOR DEL COMBO
    String cod_artC=String.valueOf(id_tipo.getSelectedItem().toString());
    //OBTENER EL PRIMER CARACTER DEL COMBO
    String cod_art2= String.valueOf(cod_artC.substring(0,1));
    int cod_art2int=Integer.valueOf(cod_art2);
    //JUNTAR LOS 2 VALORES PARA QUE SEAN IGUALES
    String cod_art3=String.valueOf(cod_art2+cod_art.getText());
    //CONVERTIRLOS A INT
    int cod_art4 = Integer.valueOf(cod_art3); 
        
       String cod_arte= String.valueOf(cod_art4);
       String des_arte= des_art.getText();
       String can_arte= cant_art.getText();
       String pre_come=pre_com.getText();
       String pre_vente=pre_vent.getText();
       String punto_reordene=punto_reorden.getText();
       String itbiss=String.valueOf(ITBIS.getSelectedItem().toString());
    int itbix=itbiss.length();
    String itbiss2="";
    if (itbix>2) {
   itbiss2=String.valueOf(itbiss.substring(0,2));
       }
    else{
   itbiss2=String.valueOf(itbiss.substring(0,1));
       }
    
    int itbint=Integer.valueOf(itbiss2);
                    
      String modin="UPDATE articulos SET des_art='"+des_art.getText()+"',cant_art='"+cant_art.getText()+"',pre_com='"+pre_com.getText()+"',pre_vent='"+pre_vent.getText()+"',punto_reorden='"+punto_reorden.getText()+"',itbis='"+String.valueOf(itbint)+"' WHERE `articulos`.`cod_art` ="+cod_arte+";";
       classes.Conectar objeto= new classes.Conectar();
       Statement modificar = objeto.getConnection().prepareStatement(modin);   
       int valor=modificar.executeUpdate(modin);
       if (valor==1)
       {
         JOptionPane.showMessageDialog(null,"El articulo: "+cod_arte+" ha sido MODIFICADO");
                
       }       
       else{
               JOptionPane.showMessageDialog(null,"El articulo: "+cod_arte+" No existe");
               }}
       catch 
       (SQLException e) 
       {
           System.out.print(e.toString());
       }

}
    void vaciono(){
     if(cod_art.getText().equals(""))
        {JOptionPane.showMessageDialog(null,"CODIGO DE ARTICULO EN BLANCO");
         cod_art.requestFocus();
         return;
        }
     else if(des_art.getText().equals(""))
        {JOptionPane.showMessageDialog(null,"DESCRIPCIÓN DE ARTICULO VACIO");
         des_art.requestFocus();
         return;
        }
     
     else if(cant_art.getText().equals(""))
        {JOptionPane.showMessageDialog(null,"CANTIDAD VACIO");
         cant_art.requestFocus();
         return;
        }
      else if(pre_com.getText().equals(""))
        {JOptionPane.showMessageDialog(null,"PRECIO DE COMPRA  VACIO");
         pre_com.requestFocus();
         return;
        }
     else if(pre_vent.getText().equals(""))
        {JOptionPane.showMessageDialog(null,"PRECIO DE VENTA VACIO");
         pre_vent.requestFocus();
         return;
        }
    
     else if(des_art.getText().equals(""))
        {JOptionPane.showMessageDialog(null,"PRECIO DE DESCUENTO VACIO");
         des_art.requestFocus();
         return;
        }
     else if(punto_reorden.getText().equals(""))
        {JOptionPane.showMessageDialog(null,"PUNTO DE REORDEN VACIO");
         punto_reorden.requestFocus();
         return;
        }
    //else{JOptionPane.showMessageDialog(null,"AGREGADO CON EXITO");}
    
    
    }
    
    public void limpiador(){
     cod_art.setText("");
        des_art.setText("");
        pre_com.setText("");
        pre_vent.setText("");
        cant_art.setText("");    
        punto_reorden.setText("");
        id_tipo.setSelectedIndex(0);        
     ITBIS.setSelectedIndex(0);
    
    }
    
    private void pre_ventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pre_ventActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pre_ventActionPerformed

    private void cod_artActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cod_artActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cod_artActionPerformed

    private void punto_reordenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_punto_reordenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_punto_reordenActionPerformed

    private void pre_comActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pre_comActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pre_comActionPerformed

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        if (cod_art.getText().equals("")) {
          vaciono();             
        }
        else if(des_art.getText().equals("")) {
          vaciono();             
        }
         else if(cant_art.getText().equals("")) {
          vaciono();             
        }
          else if(pre_com.getText().equals("")) {
          vaciono();             
        }
           else if(pre_vent.getText().equals("")) {
          vaciono();             
        }
            else if(punto_reorden.getText().equals("")) {
          vaciono();             
        }          
        else{
        agretabla();
        cargatabla();
        limpiador();
        }
    }//GEN-LAST:event_agregarActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
      int opcion = JOptionPane.showConfirmDialog(null, "Desea modificar este articulo ?", "Aviso", JOptionPane.YES_NO_OPTION);
if (opcion == 0) {
 System.out.print("si");
  vaciono();
       modifica();
       cargatabla();
       limpiador();      
}
else {
   System.out.print("no");
} 
        
        
        
        
      
    }//GEN-LAST:event_modificarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed

        
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
        
        
      
    }//GEN-LAST:event_eliminarActionPerformed

    private void actualizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizaActionPerformed
        cargatabla();
        cod_art.setText("");
        des_art.setText("");
        pre_com.setText("");
        pre_vent.setText("");
        cant_art.setText("");    
        punto_reorden.setText("");
        id_tipo.setSelectedIndex(0);        
     ITBIS.setSelectedIndex(0);
    }//GEN-LAST:event_actualizaActionPerformed

    private void TablaarttKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TablaarttKeyPressed
if (evt.getKeyCode()==27) {
            
              this.dispose();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_TablaarttKeyPressed

    private void des_artKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_des_artKeyPressed
      // TODO add your handling code here:
    }//GEN-LAST:event_des_artKeyPressed

    private void cod_artKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cod_artKeyPressed
if (evt.getKeyCode()==27) {
            
              this.dispose();
        }          // TODO add your handling code here:
    }//GEN-LAST:event_cod_artKeyPressed

    private void TablaarttMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaarttMouseClicked
       
         llenacombo2();
    }//GEN-LAST:event_TablaarttMouseClicked

    private void des_artActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_des_artActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_des_artActionPerformed

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
            java.util.logging.Logger.getLogger(Artform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Artform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Artform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Artform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Artform().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ITBIS;
    private javax.swing.JTable Tablaartt;
    private javax.swing.JButton actualiza;
    private javax.swing.JButton agregar;
    private javax.swing.JTextField cant_art;
    private javax.swing.JTextField cod_art;
    private javax.swing.JTextField des_art;
    private javax.swing.JButton eliminar;
    private javax.swing.JComboBox<String> id_tipo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modificar;
    private javax.swing.JTextField pre_com;
    private javax.swing.JTextField pre_vent;
    private javax.swing.JTextField punto_reorden;
    // End of variables declaration//GEN-END:variables

 }