
package forms;
import classes.ColorealResaltar;
import classes.Conectar;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.table.TableColumnModel;

public final class Menu extends javax.swing.JFrame {
Conectar con=new Conectar();
    ColorealResaltar crd=new ColorealResaltar();
    ResultSet rs;
    public Menu() {
        //este pone un icono bien bonito XD
        setIconImage(new ImageIcon(getClass().getResource("/img/ico.png")).getImage());
        getContentPane().setBackground(Color.decode("#003366"));
        initComponents();
        cargatabla();
        cargafacta();
        cargaclient();
        cantis.setText("");
        this.setLocationRelativeTo(null);    
        alcontado.setSelected(true);
       }
    

    
    
   public void cargatabla(){
       Statement st;
       try {
             //esto carga la tabla de los articulos         
         Connection cargain = con.getConnection();
         DefaultTableModel modelt = new DefaultTableModel();
         TableRowSorter<TableModel> ordenartabla = new TableRowSorter<TableModel>(modelt);
         Tablaart.setRowSorter(ordenartabla);
         String sql="";
         modelt.addColumn("ID");
         modelt.addColumn("Descripcion");
         modelt.addColumn("Cantidad");
         modelt.addColumn("Compra");
         modelt.addColumn("Precio");
         modelt.addColumn("Reorden");
         modelt.addColumn("ITBIS");
         Tablaart.setModel(modelt);
         sql="select * from articulos";
         String[]datart=new String[7];
         
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
             Tablaart.setDefaultEditor(Object.class, null);
             Tablaart.requestFocus();
             Tablaart.setColumnSelectionInterval(0,0);
             Tablaart.setRowSelectionInterval(0,0);       
             
 
           }             
             Tablaart.setModel(modelt);
             //me cambia el color de una fila
           Tablaart.setDefaultRenderer(Object.class,crd);
        }
    catch (SQLException e) {
            System.out.println("error"+e);
        }
    }
    catch (Exception e) {
       }    
   }   
   public  void cargafacta(){
   
         DefaultTableModel modeltf = new DefaultTableModel();
         TableRowSorter<TableModel> ordenartabla = new TableRowSorter<TableModel>(modeltf);
         Tablapafact.setRowSorter(ordenartabla);
         modeltf.addColumn("Codigo");
         modeltf.addColumn("Descripción");
         modeltf.addColumn("Cantidad");
         modeltf.addColumn("Precio");
         modeltf.addColumn("ITBIS");
         modeltf.addColumn("Importe");
       
         
         Tablapafact.setModel(modeltf);
         
         
   }
   public  void cargaclient(){
         Statement st;
       try {
             //esto carga la tabla de los articulos         
         Connection cargain = con.getConnection();
         DefaultTableModel modelt = new DefaultTableModel();
         TableRowSorter<TableModel> ordenartabla;
         ordenartabla = new TableRowSorter<>(modelt);
         Clientabla.setRowSorter(ordenartabla);
         modelt.addColumn("ID");
         modelt.addColumn("Nombre");
         Clientabla.setModel(modelt);
         String sql="select * from clientes";
         TableColumnModel columnModel = Clientabla.getColumnModel();
          columnModel.getColumn(0).setPreferredWidth(1);
         String[]datart=new String[2];
         
    try {
             st=cargain.createStatement();
             rs=st.executeQuery(sql);
             while(rs.next()){
             datart[0]=rs.getString(1);
             datart[1]=rs.getString(2);
             modelt.addRow(datart);
             Clientabla.setDefaultEditor(Object.class, null);
           }             
             Clientabla.setModel(modelt);
                  }
    catch (SQLException e) {
            System.out.println("error"+e);
        }
    }
    catch (Exception e) {
       }
   }
   public  void eliminfact(){
   
           DefaultTableModel modeltf =(DefaultTableModel)Tablapafact.getModel();
           try {
              int select = Tablapafact.getSelectedRow();
              modeltf.removeRow(select);
          } catch (Exception ex) {
               System.out.println("ERROR NO SE HA ELIMINADO");
          }
        
   }
   //este hace que pase los datos de la tabla art a fact
   public void pasafact(){
    String cod_art=Tablaart.getValueAt(Tablaart.getSelectedRow(),0).toString();
    String Des_art=Tablaart.getValueAt(Tablaart.getSelectedRow(),1).toString();
    String Cant_art=Tablaart.getValueAt(Tablaart.getSelectedRow(),2).toString();
    String precio_art=Tablaart.getValueAt(Tablaart.getSelectedRow(),3).toString();
    
    idbuscar.setText(cod_art);
    buscar.setText(Des_art);
    cantis.requestFocus();
    cantis.setText("");
    Tablapafact.setDefaultEditor(Object.class, null); 
      }
   public void editafacp1(){
    String cod_art=Tablapafact.getValueAt(Tablapafact.getSelectedRow(),0).toString();
    String Des_art=Tablapafact.getValueAt(Tablapafact.getSelectedRow(),1).toString();
    String Cant_art=Tablapafact.getValueAt(Tablapafact.getSelectedRow(),2).toString();
    String precio_art=Tablapafact.getValueAt(Tablapafact.getSelectedRow(),3).toString();
    idbuscar.setText(cod_art);
    buscar.setText(Des_art);
    cantis.setText(Cant_art);
    
   }
   public void editafacp2(){


DefaultTableModel editin = (DefaultTableModel) Tablapafact.getModel();
String Des_art=Tablapafact.getValueAt(Tablapafact.getSelectedRow(),1).toString();
float Cant_art=Float.valueOf(Tablapafact.getValueAt(Tablapafact.getSelectedRow(),2).toString());
 if(Tablapafact.getSelectedRowCount()==1){
 //me trae los datos de la factura para editarlos
String submatoria="";
String submatoriac="";
float cantisft=Float.valueOf(cantis.getText());
boolean novmc=false;
int totalfila=Tablaart.getRowCount();
for(int i=0;i<(totalfila);i++){
    //AQUI ME VA CONTANDO PARA CONTROLAR EL NO AGREGAR DE MAS A LA FACTURA
             submatoria=String.valueOf(Tablaart.getValueAt(i,1));
             submatoriac=String.valueOf(Tablaart.getValueAt(i,2));
               float submatoriacf=Float.valueOf(submatoriac);
            if (submatoria.equals(Des_art)) {
               
                if (cantisft>submatoriacf) {
                    novmc=true;                    
                    
                }
                                   
                }                   
            }
 if (novmc==false) { 
     //SI ESTA CONDICION NO SE CUMPLE SIGNIFICA QUE HAY SUFICIENTES EN INVENTARIO PARA AGREGAR A LA FACTURA
 float precio_art=Float.valueOf(Tablapafact.getValueAt(Tablapafact.getSelectedRow(),3).toString());
 float impor_art=Float.valueOf(Tablapafact.getValueAt(Tablapafact.getSelectedRow(),5).toString());
 float itbis=Float.valueOf(Tablapafact.getValueAt(Tablapafact.getSelectedRow(),4).toString())/100; 
 //me edita los datos y me hace las operaciones
 float ncantis=Float.valueOf(cantis.getText());
 String ncantiss=String.valueOf(ncantis);
 float ncxp=Float.valueOf(ncantis*precio_art);
 float nitbis=((itbis*precio_art)*ncantis);
 float nimport=(nitbis+ncxp);
 editin.setValueAt(ncantiss,Tablapafact.getSelectedRow(),2);
 editin.setValueAt(nimport,Tablapafact.getSelectedRow(),5);
 calculata();
     System.out.println(submatoria+" "+submatoriac+" cant n:"+cantisft);
 }
 
 else if(novmc==true){
 JOptionPane.showMessageDialog(null,"No hay suficientes articulos en existencia para agregar" );
 }
    }}
   public void agretabla(){
     //estos agregan el texto
   DefaultTableModel modeloss=(DefaultTableModel)Tablapafact.getModel();
    String[]datfact=new String[6];
    String cod_art2=Tablaart.getValueAt(Tablaart.getSelectedRow(),0).toString();
    String Des_art2=Tablaart.getValueAt(Tablaart.getSelectedRow(),1).toString();
    String Cant_art2ints=Tablaart.getValueAt(Tablaart.getSelectedRow(),2).toString();
    float Cant_art2int= Float.valueOf(Cant_art2ints);
    float Cant_art2f=Float.valueOf(cantis.getText());
    String Cant_art2=String.valueOf(Cant_art2f);
    float Cant_art2ft=Float.valueOf(Cant_art2);
    
    String precio_art2=Tablaart.getValueAt(Tablaart.getSelectedRow(),4).toString();
    String ITBIS_2=Tablaart.getValueAt(Tablaart.getSelectedRow(),6).toString();
    //estos hacen las operaciones matematicas
    float cantint=Float.valueOf(Cant_art2);
    float precoint=Float.valueOf(precio_art2);
    float itbisint=Float.valueOf(ITBIS_2);
    float cxp=Float.valueOf(cantint*precoint)*(itbisint/100); 
    float importeint=(cantint*precoint)+cxp;
    String importing=String.valueOf(importeint);
    String itbising=String.valueOf(itbisint);
    //estos colocan los datos en la tabla
    //datfact[0]=cod_art2;
    if(Cant_art2ft>Cant_art2int){
    JOptionPane.showMessageDialog(null,"Este articulo no cuenta con inventario");  
    }
    else{
    datfact[0]=cod_art2;
    datfact[1]=Des_art2;
    datfact[2]=Cant_art2;
    datfact[3]=precio_art2;
    datfact[4]=itbising;
    datfact[5]=importing;
    modeloss.addRow(datfact);
    Tablapafact.setModel(modeloss);
   }}
   public void calculata(){
   
     //este es el que me saca el subtotal, total e itbis  
     
 float subtm=0;
 float totalm=0;
 float itbim=0;
 double itbid=0;
double roundOffitbis=0;
double roundOffsubtotal=0;
double roundOfftotal=0;
double redo=0;
 int totalfila=Tablapafact.getRowCount();
 for(int i=0;i<(totalfila);i++){
 float cantatoria=Float.valueOf((String.valueOf(Tablapafact.getValueAt(i,2))));
 float submatoria=Float.valueOf((String.valueOf(Tablapafact.getValueAt(i,3))));
 float tomatoria=Float.valueOf((String.valueOf(Tablapafact.getValueAt(i,5))));
 float itmatoria=Float.valueOf((String.valueOf(Tablapafact.getValueAt(i,4))));
 subtm+=submatoria*cantatoria;     
 totalm+=tomatoria;
 
 itbid+=(cantatoria*submatoria)*itmatoria/100;
 //este me redondea las cantidades
 redo =itbid;
 roundOffitbis= Math.round(redo * 100.0) / 100.0;
 
 
 //este me redondea las cantidades
 redo =subtm;
 roundOffsubtotal= Math.round(redo * 100.0) / 100.0;


 //este me redondea las cantidades
 redo =totalm;
 roundOfftotal= Math.round(redo * 100.0) / 100.0;

 
 
 }
    this.subtotal.setText("RD$ "+String.valueOf(roundOffsubtotal));
    this.total.setText("RD$ "+String.valueOf(roundOfftotal));
    this.itbisc.setText("RD$ "+String.valueOf(roundOffitbis));
   }
   public void buscatabla(){
       Statement st;
       try {
             //esto carga la tabla de los articulos         
         Connection cargain = con.getConnection();
         DefaultTableModel modelt = new DefaultTableModel();
         TableRowSorter<TableModel> ordenartabla = new TableRowSorter<TableModel>(modelt);
         Tablaart.setRowSorter(ordenartabla);
         String sql="";
         modelt.addColumn("ID");
         modelt.addColumn("Descripcion");
         modelt.addColumn("Cantidad");
         modelt.addColumn("Compra");
         modelt.addColumn("Precio");
         modelt.addColumn("Reorden");
         modelt.addColumn("ITBIS");
         Tablaart.setModel(modelt);
         int idb=Integer.valueOf(idbuscar.getText());
         System.out.println(idb);
         //esto busca los artiiculos por id
         sql="select * from articulos where cod_art like '%"+idb+"%'";        
         String[]datart=new String[7];
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
             Tablaart.setDefaultEditor(Object.class, null);
             Tablaart.requestFocus();
             Tablaart.setColumnSelectionInterval(0,0);
             Tablaart.setRowSelectionInterval(0,0);
             System.out.println(idb);
             }
              Tablaart.setModel(modelt);
        } catch (SQLException e) {
            System.out.println("error"+e);
        }
    }
    catch (Exception e) {
       }    
   }
   public void buscatabla1(){
       Statement st;
       try {
             //esto carga la tabla de los articulos         
         Connection cargain = con.getConnection();
         DefaultTableModel modelt = new DefaultTableModel();
         TableRowSorter<TableModel> ordenartabla = new TableRowSorter<TableModel>(modelt);
         Tablaart.setRowSorter(ordenartabla);
         String sql="";
         modelt.addColumn("ID");
         modelt.addColumn("Descripcion");
         modelt.addColumn("Cantidad");
         modelt.addColumn("Compra");
         modelt.addColumn("Precio");
         modelt.addColumn("Reorden");
         modelt.addColumn("ITBIS");
         Tablaart.setModel(modelt);
         String idb=String.valueOf(buscar.getText());
         System.out.println(idb);
         //esto busca los artiiculos por id
         sql="select * from articulos where des_art like '%"+idb+"%'";
         String[]datart=new String[7];
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
             Tablaart.setDefaultEditor(Object.class, null);
             Tablaart.requestFocus();
             Tablaart.setColumnSelectionInterval(0,0);
             Tablaart.setRowSelectionInterval(0,0);
             System.out.println(idb);
             }
              Tablaart.setModel(modelt);
        } catch (SQLException e) {
            System.out.println("error"+e);
        }
    }
    catch (Exception e) {
       }    
   } 
   public void limpiador(){
     idbuscar.setText("");
        buscar.setText("");
    } 
   public void agregar(){
 int totalfila=Tablapafact.getRowCount();
 for(int i=0;i<(totalfila);i++){
     System.out.println(totalfila);
 }
 
        if (totalfila>=0) {

        if (buscar.getText().equals("")) {
            
            JOptionPane.showMessageDialog(null,"No ha seleccionado el articulo");   
            buscar.requestFocus();
        }
       else if (cantis.getText().equals("") || cantis.getText().equals("0")) {
            JOptionPane.showMessageDialog(null, "No ha se ha especificado cantidad del articulo");
            cantis.requestFocus();
        }    
        else{        
         String desart=Tablaart.getValueAt(Tablaart.getSelectedRow(),0).toString();       
         Boolean aviso = false;       
         //esto permite que la tabla factura no se dupliquen los items
        
         for(int i = 0; i<Tablapafact.getRowCount(); i++){
        if(Tablapafact.getValueAt(i, 0).equals(desart)){
          aviso = true;
        String cachini=String.valueOf(Tablapafact.getValueAt(i,2));
        String cachini2=String.valueOf(Tablapafact.getValueAt(i,3));
        String cachini3=String.valueOf(Tablapafact.getValueAt(i,4));
        float sumin=Float.valueOf(cachini)+Float.valueOf(cantis.getText());
        float suxcha2 = sumin * Float.valueOf(cachini2); 
        float suxcha3=((suxcha2* Float.valueOf(cachini3))/100)+suxcha2;
        System.out.println(suxcha2+"nuevo sin itbis");
        System.out.println(suxcha3+"nuevo con itbis");
       //esto se encarga de que no se puede vender donde no hay xd
        String cantz =Tablaart.getValueAt(Tablaart.getSelectedRow(),2).toString();
        float cantx= Float.valueOf(cantz);
            System.out.println(i+" cant in "+cantz+"  cant n "+sumin);
          if (sumin>cantx) {
                JOptionPane.showMessageDialog(null,"Este articulo no cuenta con tanto inventario");
            }
           
            
            else{    
              //aqui ocurren las operaciones matematicas y se le pone el nuevo valor a pafact
        Tablapafact.setValueAt(sumin,i,2);
        Tablapafact.setValueAt(suxcha3,i,5);
        calculata();
         }}}
            
        if(aviso==false){
          //ESTO AGREGA LOS ARTICULOS PARA FACTURARLOS
            agretabla();
           cantis.setText("");
           buscar.setText("");
           Tablaart.requestFocus();
           idbuscar.setText("");
           calculata();
           cargatabla();
                   }
        }
        }
        else{
        JOptionPane.showMessageDialog(null, "No ha se ha especificado cantidad del articulo");
        buscar.requestFocus();
        }
       
   }
   
   
   
public void pasapafactar(){
      
  if (alcontado.isSelected()) {
    String tipovent="Al contado";
    Factinform abrirFC = new Factinform();     
    abrirFC.clientrc.setText(Busclient.getText());
    abrirFC.tipovent.setText(tipovent);
    DefaultTableModel tmfm=(DefaultTableModel)Tablapafact.getModel();
    abrirFC.Tablafactura.setModel(tmfm);
    abrirFC.subtfc.setText(String.valueOf(subtotal.getText()));
    abrirFC.totalfc.setText(String.valueOf(total.getText()));
    abrirFC.itbisfc.setText(String.valueOf(itbisc.getText())); 
    String totaltring= String.valueOf(total.getText().substring(4));
    float totalsp=Float.valueOf(totaltring)*-1;  
    abrirFC.devolvi.setText(String.valueOf(totalsp)); 
     abrirFC.setVisible(true);
    }
      else{
      String tipovent="A credito";
      FactinformC abrirFC = new FactinformC();     
    abrirFC.clientrc.setText(Busclient.getText());
    abrirFC.tipovent.setText(tipovent);
    DefaultTableModel tmfm=(DefaultTableModel)Tablapafact.getModel();
    abrirFC.Tablafactura.setModel(tmfm);
    abrirFC.subtfc.setText(String.valueOf(subtotal.getText()));
    abrirFC.totalfc.setText(String.valueOf(total.getText()));
    abrirFC.itbisfc.setText(String.valueOf(itbisc.getText())); 
    String totaltring= String.valueOf(total.getText().substring(4));
    float totalsp=Float.valueOf(totaltring)*-1;  
      abrirFC.setVisible(true);
      }
    
    
      
      
 //estos agregan el texto         
    
         
}



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tablaart = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tablapafact = new javax.swing.JTable();
        recibidor = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        buscar = new javax.swing.JTextField();
        cantis = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        addart = new javax.swing.JButton();
        idbuscar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        modifact = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        subtotal = new javax.swing.JTextField();
        itbisc = new javax.swing.JTextField();
        total = new javax.swing.JTextField();
        PASAAFACT = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        Busclient = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        Clientabla = new javax.swing.JTable();
        addclient = new javax.swing.JButton();
        acredito = new javax.swing.JRadioButton();
        alcontado = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Busid = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        clientmenu = new javax.swing.JMenuItem();
        MenuEmp = new javax.swing.JMenuItem();
        artmen = new javax.swing.JMenu();
        armeti = new javax.swing.JMenuItem();
        artmereg = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SDIM");
        setBackground(new java.awt.Color(0, 51, 102));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Articulos en inventario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(0, 51, 102));

        Tablaart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Tablaart.getTableHeader().setReorderingAllowed(false);
        Tablaart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaartMouseClicked(evt);
            }
        });
        Tablaart.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TablaartKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(Tablaart);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(0, 51, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Carrito de compras", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(0, 51, 102));

        Tablapafact.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Tablapafact.getTableHeader().setReorderingAllowed(false);
        Tablapafact.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablapafactMouseClicked(evt);
            }
        });
        Tablapafact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TablapafactKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(Tablapafact);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                .addContainerGap())
        );

        recibidor.setForeground(new java.awt.Color(255, 255, 255));
        recibidor.setText("SALUDOYUSER");

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Buscar ID: ");

        buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarKeyReleased(evt);
            }
        });

        cantis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cantisKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cantisKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantisKeyTyped(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cantidad:");

        addart.setText("Agregar");
        addart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addartActionPerformed(evt);
            }
        });

        idbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                idbuscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                idbuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idbuscarKeyTyped(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Buscar Articulo:");

        modifact.setText("Modificar");
        modifact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifactActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Subtotal:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ITBIS:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Total:");

        subtotal.setEditable(false);
        subtotal.setBackground(new java.awt.Color(0, 51, 102));
        subtotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        subtotal.setForeground(new java.awt.Color(51, 254, 0));
        subtotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        itbisc.setEditable(false);
        itbisc.setBackground(new java.awt.Color(0, 51, 102));
        itbisc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        itbisc.setForeground(new java.awt.Color(51, 254, 0));
        itbisc.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        total.setEditable(false);
        total.setBackground(new java.awt.Color(0, 51, 102));
        total.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        total.setForeground(new java.awt.Color(51, 254, 0));
        total.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        PASAAFACT.setText("Facturar(f)");
        PASAAFACT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PASAAFACTActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Cliente:");

        Busclient.setEditable(false);

        Clientabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Clientabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClientablaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(Clientabla);

        addclient.setText("+");
        addclient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addclientActionPerformed(evt);
            }
        });

        acredito.setBackground(new java.awt.Color(0, 51, 102));
        buttonGroup1.add(acredito);
        acredito.setForeground(new java.awt.Color(255, 255, 255));
        acredito.setText("Factura a Credito");

        alcontado.setBackground(new java.awt.Color(0, 51, 102));
        buttonGroup1.add(alcontado);
        alcontado.setForeground(new java.awt.Color(255, 255, 255));
        alcontado.setText("Factura al contado");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Id:");

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Nombre:");

        Busid.setEditable(false);
        Busid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BusidMouseClicked(evt);
            }
        });

        jMenuBar1.setBackground(new java.awt.Color(0, 51, 102));
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));

        jMenu1.setForeground(new java.awt.Color(255, 255, 255));
        jMenu1.setText("REGISTRAR");

        clientmenu.setText("CLIENTES");
        clientmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientmenuActionPerformed(evt);
            }
        });
        jMenu1.add(clientmenu);

        MenuEmp.setText("EMPLEADOS");
        MenuEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuEmpActionPerformed(evt);
            }
        });
        jMenu1.add(MenuEmp);

        artmen.setText("ARTICULOS");
        artmen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                artmenActionPerformed(evt);
            }
        });

        armeti.setText("TIPOS ARTICULOS");
        armeti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                armetiActionPerformed(evt);
            }
        });
        artmen.add(armeti);

        artmereg.setText("REG. ARTICULOS");
        artmereg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                artmeregActionPerformed(evt);
            }
        });
        artmen.add(artmereg);

        jMenu1.add(artmen);

        jMenuBar1.add(jMenu1);

        jMenu2.setForeground(new java.awt.Color(255, 255, 255));
        jMenu2.setText("CONSULTAS");

        jMenu5.setText("REPORTES");

        jMenuItem4.setText("INVENTARIO");
        jMenu5.add(jMenuItem4);

        jMenuItem5.setText("TIPOS DE ARTICULOS");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem5);

        jMenuItem6.setText("FACTURAS");
        jMenu5.add(jMenuItem6);

        jMenuItem7.setText("CLIENTES");
        jMenu5.add(jMenuItem7);

        jMenu2.add(jMenu5);

        jMenuBar1.add(jMenu2);

        jMenu6.setForeground(new java.awt.Color(255, 255, 255));
        jMenu6.setText("SESIÓN");
        jMenu6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu6ActionPerformed(evt);
            }
        });

        jMenuItem2.setText("CERRAR SESIÓN");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem2);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(recibidor)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(idbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cantis, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35)
                                        .addComponent(addart)
                                        .addGap(18, 18, 18)
                                        .addComponent(modifact)))))
                        .addContainerGap(359, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(subtotal)
                                    .addComponent(itbisc)
                                    .addComponent(total)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel4)
                                                    .addComponent(jLabel5)
                                                    .addComponent(jLabel6)
                                                    .addComponent(jLabel7)
                                                    .addComponent(jLabel8)
                                                    .addComponent(jLabel9))
                                                .addGap(150, 150, 150))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(Busid, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                                    .addComponent(Busclient))
                                                .addGap(18, 18, 18)
                                                .addComponent(addclient)))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(PASAAFACT, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(alcontado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(acredito)
                                .addGap(20, 20, 20))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(recibidor, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addGap(12, 12, 12)
                        .addComponent(Busid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Busclient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addclient))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cantis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addart)
                    .addComponent(jLabel3)
                    .addComponent(modifact))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(itbisc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(alcontado)
                            .addComponent(acredito))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PASAAFACT, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuEmpActionPerformed
       Empleform abrir = new Empleform();
       abrir.setVisible(true); 
       
    }//GEN-LAST:event_MenuEmpActionPerformed

    private void jMenu6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu6ActionPerformed
       
       
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu6ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
int opcion = JOptionPane.showConfirmDialog(null, "Desea cerrar sesión?", "Aviso", JOptionPane.YES_NO_OPTION);
if (opcion == 0) { //The ISSUE is here
  Loginform abrir = new Loginform();
        abrir.setVisible(true);
        this.setVisible(false);   }
else {
   System.out.print("no");}
    

           
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void artmeregActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_artmeregActionPerformed
         Artform abrir = new Artform();
        abrir.setVisible(true);
        
    }//GEN-LAST:event_artmeregActionPerformed

    private void TablaartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaartMouseClicked
       pasafact();
        
    }//GEN-LAST:event_TablaartMouseClicked

    private void TablapafactMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablapafactMouseClicked

        limpiador();
        editafacp1();
    }//GEN-LAST:event_TablapafactMouseClicked

    private void TablaartKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TablaartKeyPressed
 if (evt.getKeyCode()==32) {    
     pasafact();
       } 
        
    }//GEN-LAST:event_TablaartKeyPressed

    private void clientmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientmenuActionPerformed
        Clientform abrir = new Clientform();
        abrir.setVisible(true);
    }//GEN-LAST:event_clientmenuActionPerformed

    private void addartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addartActionPerformed
        agregar();
    }//GEN-LAST:event_addartActionPerformed

    private void cantisKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantisKeyPressed
         if (evt.getKeyCode()==10) {
         addart.requestFocus();
       }
       
    }//GEN-LAST:event_cantisKeyPressed

    private void idbuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idbuscarKeyPressed
if (evt.getKeyCode()==32) {    
     pasafact();
Tablaart.requestFocus();
}      
    }//GEN-LAST:event_idbuscarKeyPressed

    private void TablapafactKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TablapafactKeyPressed
 if (evt.getKeyCode()==127) {
//ESTE ME PREGUNTA SI DESEO ELIMINAR EL ARTICULO
     
     int opcion = JOptionPane.showConfirmDialog(null, "Desea eliminar este articulo ?", "Aviso", JOptionPane.YES_NO_OPTION);
if (opcion == 0) { //The ISSUE is here
   System.out.print("si");
      
        eliminfact();
        calculata();
        buscar.setText("");
        cantis.setText("");
        idbuscar.setText("");
}
else {
   System.out.print("no");
}
  
 }
        
    }//GEN-LAST:event_TablapafactKeyPressed

    private void artmenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_artmenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_artmenActionPerformed

    private void armetiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_armetiActionPerformed
        Tipartform abrir = new Tipartform();
        abrir.setVisible(true);
    }//GEN-LAST:event_armetiActionPerformed

    private void idbuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idbuscarKeyTyped
    
    int key = evt.getKeyChar();
    boolean numeros = key >= 48 && key <= 57;   
    if (!numeros)
    {
      evt.consume();
    }    
        
    }//GEN-LAST:event_idbuscarKeyTyped

    private void idbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idbuscarKeyReleased
   //Este buscar los articulos por id       
            buscatabla();
            this.idbuscar.requestFocus();
        if (evt.getKeyCode()==8) {
            if (idbuscar.getText().equals("")) {
                cargatabla();
                this.idbuscar.requestFocus();
            }            
        }
    
    
    
    }//GEN-LAST:event_idbuscarKeyReleased

    private void modifactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifactActionPerformed
         boolean aviso=false;
        for (int i= 0; i <=Tablapafact.getRowCount() ; i++) {
            aviso=true;
        }
        if (aviso==true) {
            JOptionPane.showMessageDialog(null,"NO HAY ARTICULOS PARA MODIFICAR");
        }
        else{
        String canx=String.valueOf(cantis.getText());
        if(buscar.getText().equals("")||buscar.getText().equals("0")){
        JOptionPane.showMessageDialog(null,"ARTICULO NO SELECCIONADO");
        Tablaart.requestFocus();
        }
        else if(canx.equals("")||canx.equals("0")){
           JOptionPane.showMessageDialog(null,"CANTIDAD NO PUEDE ESTAR VACIA O SER 0");
           cantis.requestFocus();
           
        }
        
        else{
        editafacp2();
       
        
        }}
    }//GEN-LAST:event_modifactActionPerformed

    private void buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyReleased
    if (evt.getKeyCode()==8)
    {
    cargatabla();
    buscar.requestFocus();
     }
    else{
    buscatabla1(); 
    buscar.requestFocus();}       
    }//GEN-LAST:event_buscarKeyReleased

    private void buscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyPressed
if (evt.getKeyCode()==10) {    
     pasafact();
Tablaart.requestFocus();
}          // TODO add your handling code here:
    }//GEN-LAST:event_buscarKeyPressed

    private void cantisKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantisKeyReleased
    
     
    }//GEN-LAST:event_cantisKeyReleased

    private void cantisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantisKeyTyped
    int key = evt.getKeyChar();
    boolean numeros = key >= 48 && key <= 57;   
    if (!numeros)
    {
       evt.consume();
   }
    }//GEN-LAST:event_cantisKeyTyped

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        TipartformR abrir = new TipartformR();
               abrir.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void addclientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addclientActionPerformed
 Clientform abrir = new Clientform();
        abrir.setVisible(true);
    }//GEN-LAST:event_addclientActionPerformed

    private void ClientablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClientablaMouseClicked
        
        String clienselec=Clientabla.getValueAt(Clientabla.getSelectedRow(),1).toString();
        String idselec=Clientabla.getValueAt(Clientabla.getSelectedRow(),0).toString();
        Busclient.setText(clienselec);
        Busid.setText(idselec);
    }//GEN-LAST:event_ClientablaMouseClicked

    private void PASAAFACTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PASAAFACTActionPerformed
 int i=0;
 for(i=0;i<Tablapafact.getRowCount();i++){
  }
        if(i<=0) {         
        JOptionPane.showMessageDialog(null,"No se han agregado articulos para facturar");          
            }   
        else if(Busclient.getText().equals("")||Busid.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"No se ha seleccionado cliente para facturar");
        }
        else{
        pasapafactar();
        }

    }//GEN-LAST:event_PASAAFACTActionPerformed

    private void BusidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BusidMouseClicked
   if(evt.getClickCount()==1){
        
        }
      if(evt.getClickCount()==2){
              
     cargaclient();
       
       }        
    }//GEN-LAST:event_BusidMouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField Busclient;
    public static javax.swing.JTextField Busid;
    private javax.swing.JTable Clientabla;
    public javax.swing.JMenuItem MenuEmp;
    private javax.swing.JButton PASAAFACT;
    public javax.swing.JTable Tablaart;
    public javax.swing.JTable Tablapafact;
    private javax.swing.JRadioButton acredito;
    private javax.swing.JButton addart;
    private javax.swing.JButton addclient;
    private javax.swing.JRadioButton alcontado;
    private javax.swing.JMenuItem armeti;
    public javax.swing.JMenu artmen;
    private javax.swing.JMenuItem artmereg;
    private javax.swing.JTextField buscar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField cantis;
    private javax.swing.JMenuItem clientmenu;
    private javax.swing.JTextField idbuscar;
    private javax.swing.JTextField itbisc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    public javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton modifact;
    public javax.swing.JLabel recibidor;
    private javax.swing.JTextField subtotal;
    private javax.swing.JTextField total;
    // End of variables declaration//GEN-END:variables
}
