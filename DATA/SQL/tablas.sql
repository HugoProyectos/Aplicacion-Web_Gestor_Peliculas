/*Creating tables for postgreSQL database
*/

/*Usuario(
	nombre: cadena[60], NO NULO, UNICO, PK
contraseña: cadena[60], NO NULO);
*/
CREATE TABLE USUARIO(
    Nombre VARCHAR(60) NOT NULL PRIMARY KEY UNIQUE,
    Admin BOOLEAN NOT NULL,
    Password VARCHAR(60) NOT NULL
);

/*Seguir(
	clave primaria(User_id1, User_id2),
	User_id1: natural, clave ajena de Usuario,
	User_id2: natural, clave ajena de Usuario);
*/
CREATE TABLE SEGUIR (
    Nombre1 VARCHAR(60) NOT NULL,
    Nombre2 VARCHAR(60) NOT NULL,
    PRIMARY KEY (Nombre1, Nombre2),
    FOREIGN KEY (Nombre1) REFERENCES USUARIO(Nombre),
    FOREIGN KEY (Nombre2) REFERENCES USUARIO(Nombre)
);


/* Lista(
	Lista_id: natural, clave primaria;
	nombre: cadena[60], NO NULO, UNICO;);
*/
CREATE TABLE LISTA(
    Lista_id SERIAL PRIMARY KEY,
    Nombre VARCHAR(60) NOT NULL UNIQUE
);

/*Lista_Usuario(
	clave primaria(User_id, Lista_id),
	User_id: natural, clave ajena de Usuario,
	Lista_id: natural, clave ajena de Lista);
    */
CREATE TABLE LISTA_USUARIO(
    Nombre VARCHAR(60) NOT NULL,
    Lista_id INTEGER NOT NULL,
    PRIMARY KEY (Nombre, Lista_id),
    FOREIGN KEY (Nombre) REFERENCES USUARIO(Nombre),
    FOREIGN KEY (Lista_id) REFERENCES LISTA(Lista_id)
);

/*
Obra(
	Obra_id: cadena[60], clave primaria,
	titulo: cadena[60], NO NULO,
descripción: cadena[60], NO NULO,
género: cadena[60], NO NULO);

*/
CREATE TABLE OBRA(
    Obra_id SERIAL PRIMARY KEY,
    Titulo VARCHAR(60) NOT NULL,
    Descripcion VARCHAR(60) NOT NULL,
    Genero VARCHAR(60) NOT NULL,
    Image VARCHAR(60)
);

/*
Película(
   Obra_Id: cadena[60], clave primaria,
   Obra_Id: cadena[60], clave ajena de Obra);
   */
CREATE TABLE PELICULA(
    Obra_id INTEGER PRIMARY KEY,
    FOREIGN KEY (Obra_id) REFERENCES OBRA(Obra_id)
);

/*
Serie(
   Obra_Id: cadena[60], clave primaria,
   inicio: natural, NO NULO,
   final: natural, NO NULO,
   Obra_Id: cadena[60], clave ajena de Obra);
   */

CREATE TABLE SERIE(
    Obra_id INTEGER PRIMARY KEY,
    Inicio INTEGER NOT NULL,
    Final INTEGER NOT NULL,
    FOREIGN KEY (Obra_id) REFERENCES OBRA(Obra_id)
);

/*
Lista_Obra(
	clave primaria(Obra_Id, Lista_id),
	Obra_Id: cadena[60], clave ajena de Obra,
	Lista_id: natural, clave ajena de Lista);
    */
CREATE TABLE LISTA_OBRA(
    Obra_id INTEGER NOT NULL,
    Lista_id INTEGER NOT NULL,
    PRIMARY KEY (Obra_id, Lista_id),
    FOREIGN KEY (Obra_id) REFERENCES OBRA(Obra_id),
    FOREIGN KEY (Lista_id) REFERENCES LISTA(Lista_id)
);

/*
Persona(
	Persona_id: cadena[60], clave primaria,
	nombre: tpNombre, NO NULO);

*/
CREATE TABLE PERSONA(
    Persona_id SERIAL PRIMARY KEY,
    Nombre VARCHAR(60) NOT NULL
);
/*
Obra_Persona(
	clave primaria(Obra_Id, Persona_id),
	Obra_Id: cadena[60], clave ajena de Obra,
	Persona_id: cadena[60], clave ajena de Persona);
*/

CREATE TABLE OBRA_PERSONA(
    Obra_id INTEGER NOT NULL,
    Persona_id INTEGER NOT NULL,
    Relacion VARCHAR(60) NOT NULL,
    PRIMARY KEY (Obra_id, Persona_id),
    FOREIGN KEY (Obra_id) REFERENCES OBRA(Obra_id),
    FOREIGN KEY (Persona_id) REFERENCES PERSONA(Persona_id)
);

GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE USUARIO TO leerescribir;
GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE SEGUIR TO leerescribir; 
GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE LISTA TO leerescribir; 
GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE LISTA_USUARIO TO leerescribir; 
GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE OBRA TO leerescribir; 
GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE PELICULA TO leerescribir;
GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE SERIE TO leerescribir; 
GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE LISTA_OBRA TO leerescribir; 
GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE PERSONA TO leerescribir; 
GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE OBRA_PERSONA TO leerescribir; 


