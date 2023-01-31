package es.unizar.sisinf.grp1.model;
/**
 * tabla users
 * @author sisinf
 *
 */
public class ObraListaVO {
private int Lista_id;
private String Obra_id;
/**
 * Constructor
 * @param Obra_id
 * @param Lista_id
 */
public ObraListaVO(String Obra_id, int Lista_id) {
 this.Obra_id = Obra_id;
 this.Lista_id = Lista_id;
}

public String getObra_Id() {
 return Obra_id;
}
public void setObra_Id(String Obra_id) {
 this.Obra_id = Obra_id;
}


public int getLista_id() {
 return Lista_id;
}
public void setLista_Id(int Lista_id) {
 this.Lista_id= Lista_id;
}
}