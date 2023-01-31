package es.unizar.sisinf.grp1.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import es.unizar.sisinf.grp1.db.ConnectionManager;
import es.unizar.sisinf.grp1.db.PoolConnectionManager;
public class DAOUser {
 private static String countByUserName = "SELECT count(*) cuenta FROM USUARIO WHERE username = ?";
 private static String findByUserName = "SELECT * FROM USUARIO WHERE username = ?";
 private static String updateUserName = "UPDATE Nombre FROM USUARIO WHERE username = ?";
 private static String updateUserPassword = "UPDATE Password FROM USUARIO WHERE username = ?";

 private static String insertUser = "INSERT INTO USUARIO (Nombre, Password) VALUES (?, ?)";

 
 public boolean validateUser(UserVO user) {
    boolean result = false;
    try {
    // Abrimos la conexión e inicializamos los parámetros
    Connection conn = ConnectionManager.getConnection();

    PreparedStatement countPs = conn.prepareStatement(countByUserName);
    PreparedStatement findPs = conn.prepareStatement(findByUserName);
    
    countPs.setString(1, user.getNombre());
    findPs.setString(1, user.getNombre());

    // Ejecutamos la consulta
    ResultSet findRs = findPs.executeQuery();
    ResultSet countRs = countPs.executeQuery();

    // Leemos cuántos registros tenemos
    countRs.next();
    int n = countRs.getInt(1);
    System.out.println("Número de registros: " + n);

    // Si solo hay un resultado, la query es correcta
    if(n == 1) {
        // Comparamos contraseñas
        findRs.next();
        String dbpwd = findRs.getString("password");
        if (dbpwd.contentEquals(user.getPassword())) {
            result = true;
        }
    }
    // liberamos los recursos utilizados
    findRs.close();
    findPs.close();
    countRs.close();
    countPs.close();
    PoolConnectionManager.releaseConnection(conn);
    } catch(SQLException se) {
    se.printStackTrace();
    } catch(Exception e) {
    e.printStackTrace(System.err);
    }
    return result;
 }

public void actualizarUser(UserVO user) {
    try {
        // Abrimos la conexión e inicializamos los parámetros
        Connection conn = ConnectionManager.getConnection();

        PreparedStatement updateNombre = conn.prepareStatement(updateUserName);
        PreparedStatement updatePassword = conn.prepareStatement(updateUserPassword);
        
        updateNombre.setString(1, user.getNombre());
        updatePassword.setString(1, user.getPassword());

        // Ejecutamos la consulta
        ResultSet updateNombreRs = updateNombre.executeQuery();
        ResultSet updatePasswordRs = updatePassword.executeQuery();

        // liberamos los recursos utilizados
        updateNombreRs.close();
        updateNombre.close();
        updatePasswordRs.close();
        updatePassword.close();
        PoolConnectionManager.releaseConnection(conn);



    } catch(SQLException se) {
    se.printStackTrace();
    } catch(Exception e) {
    e.printStackTrace(System.err);
    }

}

public void insertarUser(UserVO user) {
    try {
        // Abrimos la conexión e inicializamos los parámetros
        Connection conn = ConnectionManager.getConnection();

        PreparedStatement countPs = conn.prepareStatement(countByUserName);
        PreparedStatement insert = conn.prepareStatement(insertUser);
        
        countPs.setString(1, user.getNombre());
        insert.setString(1, user.getNombre());
        insert.setString(2, user.getPassword());

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