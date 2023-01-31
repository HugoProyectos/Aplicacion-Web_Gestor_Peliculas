package es.unizar.sisinf.grp1.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import es.unizar.sisinf.grp1.db.ConnectionManager;
import es.unizar.sisinf.grp1.db.PoolConnectionManager;
public class DAOUserLista {
 private static String countByUserName = "SELECT count(*) cuenta FROM LISTA_USUARIO WHERE User_id = ? AND Lista_id = ?";
 //private static String findByUserName = "SELECT * FROM LISTA_USUARIO WHERE User_id = ? AND Lista_id = ?";

 private static String insertUserList = "INSERT INTO LISTA_USUARIO (User_id, Lista_id) VALUES (?, ?)";

public void insertUserList(UserListaVO userLista) {
    try {
        // Abrimos la conexión e inicializamos los parámetros
        Connection conn = ConnectionManager.getConnection();

        PreparedStatement countPs = conn.prepareStatement(countByUserName);
        PreparedStatement insert = conn.prepareStatement(insertUserList);
        
        countPs.setInt(1, userLista.getUser_Id());
        countPs.setInt(2,  userLista.getLista_id());
        
        insert.setInt(1, userLista.getUser_Id());
        insert.setInt(2,  userLista.getLista_id());

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