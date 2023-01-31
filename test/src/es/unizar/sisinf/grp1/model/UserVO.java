package es.unizar.sisinf.grp1.model;
/**
 * tabla users
 * @author sisinf
 *
 */
public class UserVO {
private String Nombre;
private String Password;
private int User_id;
/**
 * Constructor
 * @param Nombre
 * @param Password
 * @param User_id
 */
public UserVO(String Nombre, String Password, int User_Id) {
 this.Nombre = Nombre;
 this.Password = Password;
 this.User_id = User_Id;
}

public String getNombre() {
 return Nombre;
}
public void setNombre(String Nombre) {
 this.Nombre = Nombre;
}

public String getPassword() {
 return Password;
}
public void setPassword(String Password) {
 this.Password = Password;
}

public int getUser_Id() {
 return User_id;
}
public void setUser_Id(int User_Id) {
 this.User_id= User_Id;
}
}