package es.unizar.sisinf.grp1.model;
/**
 * tabla Peliculas
 * @author sisinf
 *
 */
public class PeliculaVO {
private String Obra_id;

/**
 * Constructor
 * @param Obra_id
 */
public PeliculaVO(String Obra_id) {
 this.Obra_id = Obra_id;
}

public String getObra_id() {
 return Obra_id;
}
public void setObra_id(String Obra_id) {
 this.Obra_id = Obra_id;
}

}
