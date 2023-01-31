--Crear rol para no usar el root en la aplicacion
CREATE ROLE leerescribir;
GRANT CONNECT ON DATABASE peliculas TO leerescribir;
GRANT USAGE ON SCHEMA public TO leerescribir;

--Darle permisos al rol sobre la tabla que hara las consultas
GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE usuario TO leerescribir;

--Repetir por cada tabla creada
-- ...

--Crear el usuario que va a tener el rol
CREATE USER peliculas_user WITH PASSWORD 'peliculas_user';
GRANT leerescribir TO peliculas_user;