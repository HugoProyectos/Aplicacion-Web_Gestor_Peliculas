package es.unizar.sisinf.grp1.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import es.unizar.sisinf.grp1.db.ConnectionManager;
import es.unizar.sisinf.grp1.db.PoolConnectionManager;
public class DAOObraLista {
 private static String countByUserName = "SELECT count(*) cuenta FROM LISTA_OBRA WHERE Obra_id = ? AND Lista_id = ?";
 //private static String findByUserName = "SELECT * FROM LISTA_OBRA WHERE Obra_id = ? AND Lista_id = ?";

 private static String insertObraList = "INSERT INTO LISTA_OBRA (Obra_id, Lista_id) VALUES (?, ?)";

public void insertObraList(ObraListaVO obraLista) {
    try {
        // Abrimos la conexión e inicializamos los parámetros
        Connection conn = ConnectionManager.getConnection();

        PreparedStatement countPs = conn.prepareStatement(countByUserName);
        PreparedStatement insert = conn.prepareStatement(insertObraList);
        
        countPs.setString(1, obraLista.getObra_Id());
        countPs.setInt(2,obraLista.getLista_id());

        insert.setString(1, obraLista.getObra_Id());
        insert.setInt(2, obraLista.getLista_id());

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
        countRs.close();
        countPs.close();
        
        insert.close();
        PoolConnectionManager.releaseConnection(conn);

    } catch(SQLException se) {
    se.printStackTrace();
    } catch(Exception e) {
    e.printStackTrace(System.err);
    }

}



}