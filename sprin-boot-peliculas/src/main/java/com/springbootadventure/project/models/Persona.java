package com.springbootadventure.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity     //Entidad que hace referencia a la BD
@Table(name = "persona")    //Nombre de la tabla en la BD
public class Persona {
    //Campos del objeto Usuario

    @Id
    @Column(name = "Persona_Id", unique = true)
    private String persona_id;
    @Column(name = "Nombre")
    private String nombre;

    public Persona(){

    }

    public Persona(String newId){
        persona_id = newId;
    }

    public Persona(String newId, String newNombre){
        persona_id = newId;
        nombre = newNombre;
    }

    public String getPersonaId() {
        return persona_id;
    }

    public void setPersonaId(String persona_id) {
        this.persona_id = persona_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
