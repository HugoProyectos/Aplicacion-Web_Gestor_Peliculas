package com.springbootadventure.project.controllers;

import com.springbootadventure.project.dao.UsuarioDAO;
import com.springbootadventure.project.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Repository
@RestController
public class UsuarioController {

    @Autowired
    UsuarioDAO udao;


    //----------------------------------------------------------------------------
    // Modo default
    //----------------------------------------------------------------------------
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String loginUsuario(@RequestBody Usuario usuario){
        System.out.println("\tAccediendo a login..." );
        System.out.println("\tLogueandose con " + usuario.getNombre() + " " + usuario.getPassword());

        Usuario usuarioLogueado = udao.findUserToLogin(usuario);
        if (usuarioLogueado != null) {
            return "OK";
        }
        return "FAIL";
    }

    //----------------------------------------------------------------------------
    // Modo api
    //----------------------------------------------------------------------------

    @RequestMapping(value = "api/allusers")
    public List<Usuario> getAllUsuarios(){
        System.out.println("\tAccediendo a api/allusers ..." );
        System.out.println("\tRecuperando todos los usuarios");
        return udao.listAllUsers();
    }

    /*
    @RequestMapping(value = "api/usuarioid/{id}")
    public Usuario getUsuario(@PathVariable Long id) {
        System.out.println("\tAccediendo a api/usuarioid ..." );
        System.out.println("\tUsuario a buscar con User_id=" + id.toString());

        //Find user in DB ...
        return udao.findUserById(id);
    }
    */

    @RequestMapping(value = "api/usuarionombre/{name}")
    public Usuario getUsuario(@PathVariable String name) {
        System.out.println("\tAccediendo a api/usuarionombre ..." );
        System.out.println("\tUsuario a buscar con Nombre=" + name);

        //Find user in DB ...
        return udao.findUserByName(name);
    }

    @RequestMapping(value = "api/registrar/{nombre}+{password}")
    public void registrarUsuario(@PathVariable String nombre, @PathVariable String password) {
        System.out.println("\tAccediendo a api/registrar/{nombre}+{password} ..." );
        System.out.println("\tUsuario a registrar: " + nombre + " " + password);

        Usuario u = new Usuario(nombre, password);

        if(udao.insertNewUser(u))
            System.out.println("\tOK!: Nuevo usuario registrado");
        else
            System.out.println("\tERROR!: Fallo al registrar el usuario.");

    }

    @RequestMapping(value = "api/eliminar/{nombre}")
    public void registrarUsuario(@PathVariable String nombre) {
        System.out.println("\tAccediendo a api/eliminar/{nombre} ..." );
        System.out.println("\tUsuario a eliminar: " + nombre);

        Usuario u = new Usuario(nombre);

        if(udao.deleteUser(u))
            System.out.println("\tOK!: Eliminado usuario ");
        else
            System.out.println("\tERROR!: Fallo al eliminar el usuario.");

    }

}
