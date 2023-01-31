package com.springbootadventure.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity     //Entidad que hace referencia a la BD
@Table(name = "Obra")    //Nombre de la tabla en la BD
public class Obra {
    //Campos del objeto Usuario

    @Id
    @Column(name = "Obra_Id", unique = true)
    private String obra_id;

    @Column(name = "Titulo")
    private String titulo;

    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "Genero")
    private String[] genero;

    public Obra(){

    }

    public Obra(String newId){
        obra_id = newId;
    }

    public Obra(String newId, String newtitulo){
        obra_id = newId;
        titulo = newtitulo;
    }

    public String getObraId() {
        return obra_id;
    }

    public void setObraId(String Obra_id) {
        this.obra_id = Obra_id;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public String[] getGenero() {
        return genero;
    }

    public void setGenero(String[] genero) {
        this.genero = genero;
    }

}