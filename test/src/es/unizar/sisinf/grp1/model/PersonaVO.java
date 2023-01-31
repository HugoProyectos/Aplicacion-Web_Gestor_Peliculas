package es.unizar.sisinf.grp1.model;
/**
 * tabla Personas
 * @author sisinf
 *
 */
public class PersonaVO {
private String Persona_id;
private String Nombre;
private String Genero;
private String Descripcion;

/**
 * Constructor
 * @param Persona_id
 * @param Nombre
 */
public PersonaVO(String Persona_id, String Nombre) {
 this.Persona_id = Persona_id;
 this.Nombre = Nombre;
}

public String getPersona_id() {
 return Persona_id;
}
public void setPersona_id(String Persona_id) {
 this.Persona_id = Persona_id;
}

public String getNombre() {
 return Nombre;
}
public void setNombre(String Nombre) {
 this.Nombre = Nombre;
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
