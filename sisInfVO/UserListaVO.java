package es.unizar.sisinf.grp1.model;
/**
 * tabla users
 * @author sisinf
 *
 */
public class UserListaVO {
private int Lista_id;
private int User_id;
/**
 * Constructor
 * @param User_id
 * @param Lista_id
 */
public UserListaVO(int User_Id, int Lista_id) {
 this.User_id = User_Id;
 this.Lista_id = Lista_id;
}

public int getUser_Id() {
 return User_id;
}
public void setUser_Id(int User_Id) {
 this.User_id = User_Id;
}


public int getLista_id() {
 return Lista_id;
}
public void setLista_Id(int Lista_id) {
 this.Lista_id= Lista_id;
}
}