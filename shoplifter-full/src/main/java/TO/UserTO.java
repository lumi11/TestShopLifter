/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author martin
 */
public class UserTO implements Serializable {

    private String name;
    private String surrname;
    private Long id;
    private List<CartTO> userOrders = new ArrayList<CartTO>();
    private List<CartTO> fiendsOrders = new ArrayList<CartTO>();
    private List<CartTO> promised = new ArrayList<CartTO>();

    public UserTO() {
        name = "Jozko";
        surrname = "Mrkvicka";
        userOrders.add(new CartTO());
        fiendsOrders.add(new CartTO());
        promised.add(new CartTO());
        id = 1l;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<CartTO> getUserOrders() {
        return userOrders;
    }

    public void setUserOrders(List<CartTO> userOrders) {
        this.userOrders = userOrders;
    }

    public List<CartTO> getFiendsOrders() {
        return fiendsOrders;
    }

    public void setFiendsOrders(List<CartTO> fiendsOrders) {
        this.fiendsOrders = fiendsOrders;
    }

    public List<CartTO> getPromised() {
        return promised;
    }

    public void setPromised(List<CartTO> promised) {
        this.promised = promised;
    }
    
    
}
