/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jwt.cookie;

/**
 *
 * @author MINEDUCYT
 */
public class User {
    private int id;
    private String name;
    private String lastName;
    private String email;
    private String userName;
    private String password;
    private String confirmarPassword_aux;

    public User() {
    }

    public User(int id, String name, String lastName, String email, String userName, String password, String confirmarPassword_aux) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.confirmarPassword_aux = confirmarPassword_aux;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmarPassword_aux() {
        return confirmarPassword_aux;
    }

    public void setConfirmarPassword_aux(String confirmarPassword_aux) {
        this.confirmarPassword_aux = confirmarPassword_aux;
    }
    
    
}
