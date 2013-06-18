/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import TO.SettingsTO;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author martin
 */
@ManagedBean
@SessionScoped
public class Welcome implements Serializable {
    
    private String username;
    private String password;
    private SettingsTO newUser;

    public Welcome() {
        newUser = new SettingsTO();
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SettingsTO getNewUser() {
        return newUser;
    }

    public void setNewUser(SettingsTO newUser) {
        this.newUser = newUser;
    }
    
    
    public String login(){
        return "test".equals(username) ? "loginSucessful" : "loginFailed";
    }
    
    public String register(){
        return "register";
    }
    
    
    
}
