package es.unizar.sisinf.grp1.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import es.unizar.sisinf.grp1.db.ConnectionManager;
import es.unizar.sisinf.grp1.db.PoolConnectionManager;
public class DAOPelicula {
 private static String countByPeliculaId = "SELECT count(*) cuenta FROM PELICULA WHERE Pelicula_id = ?";
 //private static String findByPeliculaId = "SELECT * FROM PELICULA WHERE Pelicula_id = ?";

private static String insertPelicula = "INSERT INTO PELICULA (Pelicula_id) VALUES (?)";
private static String deletePelicula = "DELETE FROM PELICULA WHERE Pelicula_id = ?";

public void insertarPelicula(PeliculaVO Pelicula) {
    try {
        // Abrimos la conexión e inicializamos los parámetros
        Connection conn = ConnectionManager.getConnection();

        PreparedStatement countPs = conn.prepareStatement(countByPeliculaId);
        PreparedStatement insert = conn.prepareStatement(insertPelicula);
        
        countPs.setString(1, Pelicula.getObra_id());
        insert.setString(1, Pelicula.getObra_id());

        // Ejecutamos la consulta
        ResultSet countRs = countPs.executeQuery();

        // Leemos cuántos registros tenemos
        countRs.next();
        int n = countRs.getInt(1);

        // Si no hay un resultado, insertamos el usuario
        if(n == 0) {
            ResultSet insertRs = insert.executeQuery();
            insertRs.close();
        }

        // liberamos los recursos utilizados
        insert.close();
        countRs.close();
        countPs.close();
        PoolConnectionManager.releaseConnection(conn);

    } catch(SQLException se) {
    se.printStackTrace();
    } catch(Exception e) {
    e.printStackTrace(System.err);
    }

}

public void deletePelicula(PeliculaVO Pelicula) {
        try {
        // Abrimos la conexión e inicializamos los parámetros
        Connection conn = ConnectionManager.getConnection();

        PreparedStatement countPs = conn.prepareStatement(countByPeliculaId);
        PreparedStatement delete = conn.prepareStatement(deletePelicula);
        
        countPs.setString(1, Pelicula.getObra_id());
        delete.setString(1, Pelicula.getObra_id());

        // Ejecutamos la consulta
        ResultSet countRs = countPs.executeQuery();

        // Leemos cuántos registros tenemos
        countRs.next();
        int n = countRs.getInt(1);

        // Si no hay un resultado, delete de Pelicula
        if(n == 0) {
            ResultSet deleteRs = delete.executeQuery();
            deleteRs.close();
        }

        // liberamos los recursos utilizados
        countRs.close();
        countPs.close();
        delete.close();
        PoolConnectionManager.releaseConnection(conn);

    } catch(SQLException se) {
    se.printStackTrace();
    } catch(Exception e) {
    e.printStackTrace(System.err);
    }
}

}