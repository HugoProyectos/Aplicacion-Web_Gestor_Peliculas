package es.unizar.sisinf.grp1.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import es.unizar.sisinf.grp1.db.ConnectionManager;
import es.unizar.sisinf.grp1.db.PoolConnectionManager;
public class DAOLista {
 //private static String countByListaId = "SELECT count(*) cuenta FROM LISTA WHERE Lista_id = ?";
 //private static String findByListaId = "SELECT * FROM LISTA WHERE Lista_id = ?";

private static String insertLista = "INSERT INTO LISTA (Nombre) VALUES (?)";

public void insertarLista(ListaVO Lista) {
    try {
        // Abrimos la conexión e inicializamos los parámetros
        Connection conn = ConnectionManager.getConnection();

        PreparedStatement insert = conn.prepareStatement(insertLista);
        
        insert.setString(1, Lista.getNombre());

        // Ejecutamos la consulta
        ResultSet insertRs = insert.executeQuery();

        // liberamos los recursos utilizados
        insertRs.close();
        insert.close();
        PoolConnectionManager.releaseConnection(conn);

    } catch(SQLException se) {
    se.printStackTrace();
    } catch(Exception e) {
    e.printStackTrace(System.err);
    }

}

}