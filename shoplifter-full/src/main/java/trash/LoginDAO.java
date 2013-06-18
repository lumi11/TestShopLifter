/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trash;

/**
 *
 * @author martin
 */
public class LoginDAO {
 
    private String username;
    private String password;
    private SecurityRole role;
    private Long userId;

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

    public SecurityRole getRole() {
        return role;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    
    
}
