package com.springbootadventure.project.models;

import javax.persistence.*;

@Entity     //Entidad que hace referencia a la BD
@Table(name = "usuario")    //Nombre de la tabla en la BD
public class Usuario {
    //Campos del objeto Usuario

    /*
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column(name = "User_id")
    private Long id;
    */

    @Id
    @Column(name = "Nombre", unique = true)
    private String nombre;
    @Column(name = "Password")
    private String password;

    public Usuario(){

    }

    public Usuario(String newNombre){
        nombre = newNombre;
    }

    public Usuario(String newNombre, String newPass){
        nombre = newNombre;
        password = newPass;
    }
    /*
    public Usuario(Long newId, String newNombre, String newPass){
        id = newId;
        nombre = newNombre;
        password = newPass;
    }
    */

    /*
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    */

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
