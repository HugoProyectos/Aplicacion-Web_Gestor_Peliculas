package com.springbootadventure.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity     //Entidad que hace referencia a la BD
@Table(name = "Lista")    //Nombre de la tabla en la BD
public class Lista {
    //Campos del objeto Usuario

    @Id
    @Column(name = "Lista_Id", unique = true)
    private String lista_id;
    @Column(name = "Nombre")
    private String nombre;

    public Lista(){

    }

    public Lista(String newId){
        lista_id = newId;
    }

    public Lista(String newId, String newNombre){
        lista_id = newId;
        nombre = newNombre;
    }

    public String getListaId() {
        return lista_id;
    }

    public void setListaId(String lista_id) {
        this.lista_id = lista_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
