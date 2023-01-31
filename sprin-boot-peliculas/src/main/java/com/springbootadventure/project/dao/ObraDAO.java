
package com.springbootadventure.project.dao;
/*

import com.springbootadventure.project.models.Obra;
import com.springbootadventure.project.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository         //Para hacer referencia a las consultas a BD
@Transactional      //Sirve para poder realizar las consultas a BD
public class ObraDAO {

    private static String findAll = "FROM Obra";

    private static String findByName = "FROM Obra WHERE Nombre = :Nombre";

    private static String findById = "FROM Obra WHERE Obra_id = :Obra_id";

    private static String findByFiltros = "FROM Obra WHERE Genero = :Genero"; //De momento pongo solo los generos

    private static String insertIntoObra = "INSERT INTO Obra (Obra_id, Nombre, Genero) VALUES (?,?,?)"; // Eso de momento con el genero solo

    private static String updateFromObra = "UPDATE Obra SET Nombre = :Nombre, Genero = :Genero WHERE Obra_id = :Obra_id";

    private static String deleteFromObra = "DELETE FROM Obra WHERE Obra_id = :Obra_id";

    @Autowired
    @PersistenceContext
    private EntityManager em;

    //Para mostrar todas las obras
    public List<Obra> listAllObras(){
        return em.createQuery(findAll).getResultList();
    }

    //Para las busquedas por id no se si esto nos hace falta
    public Obra ObrafindObraByid(String n){
        List<Obra> lista = em.createQuery(findById)
                .setParameter("Obra_id", n)
                .getResultList();

        //Si la query devuelve algo distinto a un solo resultado, esta mal
        if (lista.isEmpty() | lista.size() > 1) {
            return null;
        }

        //Devovler la pelicula con ese id
        return lista.get(0);
    }

    //Para las busquedas por texto del usuario
    public List<Obra> findObraByName(String n){
        List<Obra> lista = em.createQuery(findByName)
                .setParameter("Nombre", n)
                .getResultList();

        //Si la query no duvuelve resultado, no hay peliculas por ese nombre
        if (lista.isEmpty()) {
            return null;
        }

        //Devovler las peliculas con ese nombre
        return lista;
    }

    //Para las busquedas por filtros del usuario
    public List<Obra> findObraByFiltros(String n){
        List<Obra> lista = em.createQuery(findByFiltros)
                .setParameter("Genero", n)
                .getResultList();

        //Si la query no duvuelve resultado, no hay peliculas por ese nombre
        if (lista.isEmpty()) {
            return null;
        }

        //Devovler las peliculas con ese nombre
        return lista;
    }

    //El administrador puede introducir nuevas obra a la BD
    public boolean insertNewObra(Obra o){
        //Check if user is already in DB ...
        Obra tmp = findById(o.getObraId());
        if(tmp != null){
            return false;
        }
        //If not in DB, then insert in it
        em.createNativeQuery(insertIntoObra).setParameter(1, o.getObraId())
                .setParameter(2, o.getNombre()).setParameter(3,o.getGenero())
                .executeUpdate();
        return true;
    }

    //El administrador puede cambiar las obras de la BD
    public boolean updateObra(Obra o){
        //Check if user is already in DB ...
        Obra tmp = findById(o.getObraId());
        if(tmp != null){
            return false;
        }
        //If not in DB, then insert in it
        em.createNativeQuery(updateFromObra).setParameter("Nombre", o.getNombre())
                .setParameter("Genero", o.getGenero()).setParameter("Obra_id",o.getObraId())
                .executeUpdate();
        return true;
    }

    //El administrador puede eliminar obras de la BD
    public boolean deleteObra(Obra o){
        Obra tmp = findById(o.getObraId());
        if(tmp == null){
            return false;
        }

        em.createQuery(deleteFromObra).setParameter("Obra_id", o.getObraId()).executeUpdate();

        return true;
    }

}
*/