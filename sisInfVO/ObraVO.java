package es.unizar.sisinf.grp1.model;
/**
 * tabla Obras
 * @author sisinf
 *
 */
public class ObraVO {
private String Obra_id;
private String Titulo;
private String Genero;
private String Descripcion;

/**
 * Constructor
 * @param Obra_id
 * @param Titulo
 * @param Genero
 * @param Descripcion
 */
public ObraVO(String Obra_id, String Titulo, String Genero, String Descripcion) {
 this.Obra_id = Obra_id;
 this.Titulo = Titulo;
 this.Genero = Genero;
 this.Descripcion = Descripcion;
}

public String getObra_id() {
 return Obra_id;
}
public void setObra_id(String Obra_id) {
 this.Obra_id = Obra_id;
}

public String getTitulo() {
 return Titulo;
}
public void setTitulo(String Titulo) {
 this.Titulo = Titulo;
}

public String getGenero() {
 return Genero;
}
public void setGenero(String Genero) {
 this.Genero = Genero;
}

public String getDescripcion() {
 return Descripcion;
}
public void setDescripcion(String Descripcion) {
 this.Descripcion = Descripcion;
}
}
