/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author martin
 */
@ManagedBean
@SessionScoped
public class UserInfo implements Serializable {
    
    private String name;
    private String surrname;
    private String searching;

    public UserInfo() {
        name = "Jojo";
        surrname = "Mrkvovy";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurrname() {
        return surrname;
    }

    public void setSurrname(String surrname) {
        this.surrname = surrname;
    }

    public String getSearching() {
        return searching;
    }

    public void setSearching(String searching) {
        this.searching = searching;
    }
    
    
}
