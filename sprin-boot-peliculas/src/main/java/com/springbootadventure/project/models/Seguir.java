package com.springbootadventure.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity     //Entidad que hace referencia a la BD
@Table(name = "Seguir")    //nombre1 de la tabla en la BD
public class Seguir {
    //Campos del objeto Seguir

    @Id
    @Column(name = "nombre1")
    private String nombre1;

    @Id
    @Column(name = "nombre2")
    private String nombre2;

    public Seguir(){

    }

    public Seguir(String newNombre1, String newListaId){
        nombre1 = newNombre1;
        nombre2 = newListaId;
    }

    public String getnombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }
}
