package com.springbootadventure.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity     //Entidad que hace referencia a la BD
@Table(name = "ObraPersona")    //persona_id de la tabla en la BD
public class ObraPersona {
    //Campos del objeto ObraPersona

    @Id
    @Column(name = "persona_id", unique = true)
    private String persona_id;

    @Id
    @Column(name = "obra_id", unique = true)
    private String obra_id;

    public ObraPersona(){

    }

    public ObraPersona(String newPersona_id, String newObra_id){
        persona_id = newPersona_id;
        obra_id = newObra_id;
    }

    public String getPersonaId() {
        return persona_id;
    }

    public void setPersonaId(String persona_id) {
        this.persona_id = persona_id;
    }

    public String getObraId() {
        return obra_id;
    }

    public void setObraId(String obra_id) {
        this.obra_id = obra_id;
    }
}
