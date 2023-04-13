package classes;
public class lista_art {
private String codigo;
 private  String descripcion;
 private  String cantidad;
 private  String precio;
 private  String itbis;
 private  String importe;

 public lista_art(String codigo,String descripcion,String cantidad,String precio,String itbis,String importe)
{
this.codigo=codigo;
this.descripcion=descripcion;
this.cantidad=cantidad;
this.precio=precio;
this.itbis=itbis;
this.importe=importe;
}


public String getcodigo(){
return codigo;
}

public void setcodigo(String codigo){
this.codigo=codigo;
}

public String getdescripcion(){
return descripcion;
}

public void setdescripcion(String descripcion){
this.descripcion=descripcion;
}

public String getcantidad(){
return cantidad;
}

public void setcantidad(String cantidad){
this.cantidad=cantidad;
}

public String getprecio(){
return precio;
}

public void setprecio(String precio){
this.precio=precio;
}

public String getitbis(){
return itbis;
}

public void setitbis(String itbis){
this.itbis=itbis;
}

public String getimporte(){
return importe;
}
public void setimporte(String importe){
this.importe=importe;
}






}

