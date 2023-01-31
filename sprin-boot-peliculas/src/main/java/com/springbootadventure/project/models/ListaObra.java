package com.springbootadventure.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity     //Entidad que hace referencia a la BD
@Table(name = "UserLista")    //Obra_id de la tabla en la BD
public class ListaObra {
    //Campos del objeto UserLista

    @Id
    @Column(name = "Obra_id", unique = true)
    private String obra_id;

    @Id
    @Column(name = "Lista_id", unique = true)
    private String lista_id;

    public ListaObra(){

    }

    public ListaObra(String newObra_id, String newLista_id){
        obra_id = newObra_id;
        lista_id = newLista_id;
    }

    public String getObraId() {
        return obra_id;
    }

    public void setObraId(String Obra_id) {
        this.obra_id = Obra_id;
    }

    public String getListaId() {
        return lista_id;
    }

    public void setListaId(String lista_id) {
        this.lista_id = lista_id;
    }
}
