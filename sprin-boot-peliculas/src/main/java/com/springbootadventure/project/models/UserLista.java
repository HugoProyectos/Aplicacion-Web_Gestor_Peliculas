package com.springbootadventure.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity     //Entidad que hace referencia a la BD
@Table(name = "UserLista")    //nombre de la tabla en la BD
public class UserLista {
    //Campos del objeto UserLista

    @Id
    @Column(name = "nombre", unique = true)
    private String nombre;

    @Id
    @Column(name = "Lista_id", unique = true)
    private String lista_id;

    public UserLista(){

    }

    public UserLista(String newNombre, String newListaId){
        nombre = newNombre;
        lista_id = newListaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getListaId() {
        return lista_id;
    }

    public void setListaId(String lista_id) {
        this.lista_id = lista_id;
    }
}
