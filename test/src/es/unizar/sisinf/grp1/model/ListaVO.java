package es.unizar.sisinf.grp1.model;
/**
 * tabla Listas
 * @author sisinf
 *
 */
public class ListaVO {
private String Nombre;
private int Lista_id;
/**
 * Constructor
 * @param Nombre
 * @param Lista_id
 */
public ListaVO(String Nombre, int Lista_id) {
 this.Nombre = Nombre;
 this.Lista_id = Lista_id;
}

public String getNombre() {
 return Nombre;
}
public void setNombre(String Nombre) {
 this.Nombre = Nombre;
}

public int getLista_id() {
 return Lista_id;
}
public void setLista_id(int Lista_id) {
 this.Lista_id = Lista_id;
}
}
