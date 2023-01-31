package es.unizar.sisinf.grp1.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import es.unizar.sisinf.grp1.db.ConnectionManager;
import es.unizar.sisinf.grp1.db.PoolConnectionManager;
public class DAOObra {
 private static String countByObraId = "SELECT count(*) cuenta FROM OBRA WHERE Obra_id = ?";
 //private static String findByObraId = "SELECT * FROM OBRA WHERE Obra_id = ?";

private static String updateObra = "UPDATE OBRA SET Titulo = ?, Descripcion = ?, Genero = ?, WHERE Obra_id = ?";
private static String insertObra = "INSERT INTO OBRA (Obra_id,Titulo,Descripcion,Genero ) VALUES (?,?,?,?)";
private static String deleteObra = "DELETE FROM Obra WHERE Obra_id = ?";

public void insertarObra(ObraVO Obra) {
    try {
        // Abrimos la conexión e inicializamos los parámetros
        Connection conn = ConnectionManager.getConnection();

        PreparedStatement countPs = conn.prepareStatement(countByObraId);
        PreparedStatement insert = conn.prepareStatement(insertObra);
        
        countPs.setString(1, Obra.getObra_id());
        insert.setString(1,Obra.getObra_id());
        insert.setString(2,Obra.getTitulo());
        insert.setString(3,Obra.getDescripcion());
        insert.setString(4,Obra.getGenero());

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

public void deleteObra(ObraVO Obra) {
        try {
        // Abrimos la conexión e inicializamos los parámetros
        Connection conn = ConnectionManager.getConnection();

        PreparedStatement countPs = conn.prepareStatement(countByObraId);
        PreparedStatement delete = conn.prepareStatement(deleteObra);
        
        countPs.setString(1, Obra.getObra_id());
        delete.setString(1, Obra.getObra_id());

        // Ejecutamos la consulta
        ResultSet countRs = countPs.executeQuery();

        // Leemos cuántos registros tenemos
        countRs.next();
        int n = countRs.getInt(1);

        // Si no hay un resultado, delete de obra
        if(n == 1) {
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


public void cambiarObra(ObraVO Obra) {
    try {
        // Abrimos la conexión e inicializamos los parámetros
        Connection conn = ConnectionManager.getConnection();

        PreparedStatement countPs = conn.prepareStatement(countByObraId);
        PreparedStatement update = conn.prepareStatement(updateObra);
        
        countPs.setString(1, Obra.getObra_id());
        
        update.setString(1,Obra.getTitulo());
        update.setString(2,Obra.getDescripcion());
        update.setString(3,Obra.getGenero());
        update.setString(4,Obra.getObra_id());
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