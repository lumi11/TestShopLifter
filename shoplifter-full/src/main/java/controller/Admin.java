/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import TO.SettingsTO;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author martin
 */
@ManagedBean
public class Admin {
    
    private List<SettingsTO> users = new ArrayList<SettingsTO>();

    public Admin() {
        users.add(new SettingsTO());
    
    }

    
    
    public List<SettingsTO> getUsers() {
        return users;
    }

    public void setUsers(List<SettingsTO> users) {
        this.users = users;
    }
    
    
    public void deleteUser(Long userId){
        return;

    }

    
    
    
    
    
}
