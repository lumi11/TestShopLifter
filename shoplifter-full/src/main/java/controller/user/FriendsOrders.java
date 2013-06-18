/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import TO.CartTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author martin
 */
@ManagedBean
@ViewScoped
public class FriendsOrders implements Serializable {
    
    private List<CartTO> orders = new ArrayList<CartTO>();
    private List<CartTO> promised = new ArrayList<CartTO>();

    public FriendsOrders() {
        orders.add(new CartTO());
        orders.add(new CartTO());
        orders.add(new CartTO());
        orders.add(new CartTO());
        orders.add(new CartTO());
        
        promised.add(new CartTO());
        promised.add(new CartTO());
    }

    
    
    
    public List<CartTO> getOrders() {
        return orders;
    }

    public void setOrders(List<CartTO> orders) {
        this.orders = orders;
    }

    public List<CartTO> getPromised() {
        return promised;
    }

    public void setPromised(List<CartTO> promised) {
        this.promised = promised;
    }
    
    
}
