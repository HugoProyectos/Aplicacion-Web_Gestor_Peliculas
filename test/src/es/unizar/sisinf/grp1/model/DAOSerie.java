package es.unizar.sisinf.grp1.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import es.unizar.sisinf.grp1.db.ConnectionManager;
import es.unizar.sisinf.grp1.db.PoolConnectionManager;
public class DAOSerie {
 private static String countBySerieId = "SELECT count(*) cuenta FROM SERIE WHERE Serie_id = ?";
 //private static String findBySerieId = "SELECT * FROM SERIE WHERE Serie_id = ?";

private static String updateSerie = "UPDATE SERIE SET Inicio = ?, Final = ? WHERE Obra_id = ?";
private static String insertSerie = "INSERT INTO SERIE (Serie_id, Inicio, Fin) VALUES (?, ?, ?)";
private static String deleteSerie = "DELETE FROM SERIE WHERE Serie_id = ?";

public void insertarSerie(SerieVO Serie) {
    try {
        // Abrimos la conexión e inicializamos los parámetros
        Connection conn = ConnectionManager.getConnection();

        PreparedStatement countPs = conn.prepareStatement(countBySerieId);
        PreparedStatement insert = conn.prepareStatement(insertSerie);
        
        countPs.setString(1, Serie.getObra_id());
        insert.setString(1, Serie.getObra_id());
        insert.setInt(2, Serie.getInicio());
        insert.setInt(3, Serie.getFinal());

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

public void deleteSerie(SerieVO Serie) {
        try {
        // Abrimos la conexión e inicializamos los parámetros
        Connection conn = ConnectionManager.getConnection();

        PreparedStatement countPs = conn.prepareStatement(countBySerieId);
        PreparedStatement delete = conn.prepareStatement(deleteSerie);
        
        countPs.setString(1, Serie.getObra_id());
        delete.setString(1, Serie.getObra_id());

        // Ejecutamos la consulta
        ResultSet countRs = countPs.executeQuery();

        // Leemos cuántos registros tenemos
        countRs.next();
        int n = countRs.getInt(1);

        // Si no hay un resultado, delete de Serie
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

public void cambiarSerie(SerieVO Serie) {
    try {
        // Abrimos la conexión e inicializamos los parámetros
        Connection conn = ConnectionManager.getConnection();

        PreparedStatement countPs = conn.prepareStatement(countBySerieId);
        PreparedStatement update = conn.prepareStatement(updateSerie);
        
        countPs.setString(1, Serie.getObra_id());
        update.setInt(1, Serie.getInicio());
        update.setInt(2, Serie.getFinal());
        update.setString(3, Serie.getObra_id());

        // Ejecutamos la consulta
        ResultSet countRs = countPs.executeQuery();

        // Leemos cuántos registros tenemos
        countRs.next();
        int n = countRs.getInt(1);

        // Si hay un resultado, insertamos el usuario
        if(n == 1) {
            ResultSet updateRs = update.executeQuery();
            updateRs.close();
        }

        // liberamos los recursos utilizados
        
        update.close();
        countRs.close();
        countPs.close();
        PoolConnectionManager.releaseConnection(conn);

    } catch(SQLException se) {
    se.printStackTrace();
    } catch(Exception e) {
    e.printStackTrace(System.err);
    }

}

}