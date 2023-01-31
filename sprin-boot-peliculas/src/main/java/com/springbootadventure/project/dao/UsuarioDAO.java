
package com.springbootadventure.project.dao;


import com.springbootadventure.project.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository         //Para hacer referencia a las consultas a BD
@Transactional      //Sirve para poder realizar las consultas a BD
public class UsuarioDAO {

    private static String findAll = "FROM Usuario";
    //private static String findById = "FROM Usuario WHERE User_id = :User_id";
    private static String findByName = "FROM Usuario WHERE Nombre = :Nombre";
    private static String findByNameAndPassword = "FROM Usuario WHERE Nombre = :Nombre AND Password = :Password";
    private static String inserIntoUsers = "INSERT INTO Usuario (Nombre, Password) VALUES (?,?)";
    private static String deleteUserByName = "DELETE FROM Usuario  WHERE Nombre = :Nombre";
    //private static String countByUserName = "SELECT count(*) cuenta FROM USUARIO WHERE username = ?";
    //private static String findByUserName = "SELECT * FROM USUARIO WHERE username = ?";
    //private static String updateUserName = "UPDATE Nombre FROM USUARIO WHERE username = ?";
    //private static String updateUserPassword = "UPDATE Password FROM USUARIO WHERE username = ?";

    @Autowired
    @PersistenceContext
    private EntityManager em;

    public List<Usuario> listAllUsers(){

        //List<Usuario> usuarios = em.createQuery(query).getResultList();

        return em.createQuery(findAll).getResultList();
    }

    /*
    public Usuario findUserById(Long id){
        List<Usuario> lista = em.createQuery(findById)
                                .setParameter("User_id", id)
                                .getResultList();

        //Si la query devuelve algo distinto a un solo resultado, esta mal
        if (lista.isEmpty() | lista.size() > 1) {
            return null;
        }

        //Devovler el unico elemento de la lista
        return lista.get(0);
    }
    */


    public Usuario findUserByName(String n){
        List<Usuario> lista = em.createQuery(findByName)
                .setParameter("Nombre", n)
                .getResultList();

        //Si la query devuelve algo distinto a un solo resultado, esta mal
        if (lista.isEmpty() | lista.size() > 1) {
            return null;
        }

        //Devovler el unico elemento de la lista
        return lista.get(0);
    }

    public boolean insertNewUser(Usuario u){
        //Check if user is already in DB ...
        Usuario tmp = findUserByName(u.getNombre());
        if(tmp != null){
            return false;
        }
        //If not in DB, then insert in it
        em.createNativeQuery(inserIntoUsers).setParameter(1, u.getNombre())
                                            .setParameter(2, u.getPassword())
                                            .executeUpdate();
        return true;
    }


    public Usuario findUserToLogin(Usuario u){

        List<Usuario> lista = em.createQuery(findByNameAndPassword)
                .setParameter("Nombre", u.getNombre())
                .setParameter("Password", u.getPassword())
                .getResultList();

        if (lista.isEmpty() | lista.size() > 1) {
            return null;
        }

        return lista.get(0);
    }

    public boolean deleteUser(Usuario u){
        Usuario tmp = findUserByName(u.getNombre());
        if(tmp == null){
            return false;
        }

        em.createQuery(deleteUserByName).setParameter("Nombre", u.getNombre()).executeUpdate();

        return true;
    }


}