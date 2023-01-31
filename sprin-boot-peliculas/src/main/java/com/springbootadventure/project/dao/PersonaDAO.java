
package com.springbootadventure.project.dao;


import com.springbootadventure.project.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository         //Para hacer referencia a las consultas a BD
@Transactional      //Sirve para poder realizar las consultas a BD
public class PersonaDAO {


    @Autowired
    @PersistenceContext
    private EntityManager em;




}