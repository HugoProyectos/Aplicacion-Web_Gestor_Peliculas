
package com.springbootadventure.project.dao;

/*
import com.springbootadventure.project.models.Lista;

import com.springbootadventure.project.models.Obra;
import com.springbootadventure.project.models.ListaObra;

import com.springbootadventure.project.models.Usuario;
import com.springbootadventure.project.models.UsuarioLista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository         //Para hacer referencia a las consultas a BD
@Transactional      //Sirve para poder realizar las consultas a BD
public class ListaDAO {

    private static String findById = "FROM Lista WHERE Lista_id = :Lista_id";

    private static String findByIdName = "FROM Lista WHERE Lista_id = :Lista_id AND Nombre = :Nombre";
    //Crear una lista de un usuario
    private static String insertIntoLista = "INSERT INTO Lista (Lista_id, Nombre) VALUES (?,?)"; // Eso de momento con el genero solo

    //Creo que no hemos puesto nada de borrar listas
    private static String deleteFromLista = "DELETE FROM Lista WHERE Lista_id = :Lista_id";

    private static String ListasByUser = "FROM UsuarioLista WHERE Nombre = :Nombre";

    private static String ObrasByLista = "FROM ListaObra WHERE Lista_id = :Lista_id";

    @Autowired
    @PersistenceContext
    private EntityManager em;

    //GENERALES
    //Para las busquedas por id no se si esto nos hace falta
    public Lista findListaByName(String id, String name){
        List<Lista> lista = em.createQuery(findByIdName)
                .setParameter("Lista_id", id).setParameter("Nombre", name)
                .getResultList();

        //Si la query devuelve algo distinto a un solo resultado, esta mal
        if (lista.isEmpty() | lista.size() > 1) {
            return null;
        }

        //Devovler la lista con ese id y nombre
        return lista.get(0);
    }

    //Para las busquedas por texto del usuario
    public Lista findListaById(String n){
        List<Lista> lista = em.createQuery(findById)
                .setParameter("Lista_id", n)
                .getResultList();

        //Si la query devuelve algo distinto a un solo resultado, esta mal
        if (lista.isEmpty() | lista.size() > 1) {
            return null;
        }

        //Devovler la lista con ese id y nombre
        return lista.get(0);
    }


    //LISTA
    //El usuario puede introducir nuevas Lista a la BD
    public boolean insertNewLista(Lista o){
        //Check if user is already in DB ...
        Lista tmp = findById(o.getListaId());
        if(tmp != null){
            return false;
        }
        //If not in DB, then insert in it
        em.createNativeQuery(insertIntoLista).setParameter(1, o.getListaId())
                .setParameter(2, o.getNombre())
                .executeUpdate();
        return true;
    }

    //El usuario puede eliminar Listas de la BD
    public boolean deleteLista(Lista o){
        Lista tmp = findById(o.getListaId());
        if(tmp == null){
            return false;
        }

        em.createQuery(deleteFromLista).setParameter("Lista_id", o.getListaId()).executeUpdate();

        return true;
    }

    //USUARIO-LISTA
    //devuelve la lista de id de lista para poder buscarlos en obras
    public List<UsuarioLista> findListasByUser(Usuario u){
        List<UsuarioLista> lista = em.createQuery(ListasByUser)
                .setParameter("Nombre", u.getNombre())
                .getResultList();

        //Si la query no duvuelve resultado, no hay peliculas por ese nombre
        if (lista.isEmpty()) {
            return null;
        }

        //Devovler las peliculas con ese nombre
        return lista;
    }

    //OBRA-LISTA
    public List<Obra> findObrasByLista(Lista l){
        List<Obra> lista = em.createQuery(ObrasByLista)
                .setParameter("Lista_id", l.getListaId())
                .getResultList();

        //Si la query no duvuelve resultado, no hay peliculas por ese nombre
        if (lista.isEmpty()) {
            return null;
        }

        //Devovler las peliculas con ese nombre
        return lista;
    }


}*/