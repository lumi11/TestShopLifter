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
public class UserOrders implements Serializable {

    
    private List<CartTO> finished = new ArrayList<CartTO>();
    private List<CartTO> promisedToUser = new ArrayList<CartTO>();
    private List<CartTO> waiting = new ArrayList<CartTO>();

    public UserOrders() {
    
    
        finished.add(new CartTO());
        finished.add(new CartTO());

        promisedToUser.add(new CartTO());
        promisedToUser.add(new CartTO());
        promisedToUser.add(new CartTO());

        waiting.add(new CartTO());
        waiting.add(new CartTO());
        waiting.add(new CartTO());
        waiting.add(new CartTO());

    }

    
    
    public List<CartTO> getFinished() {
        return finished;
    }

    public void setFinished(List<CartTO> finished) {
        this.finished = finished;
    }

    public List<CartTO> getPromisedToUser() {
        return promisedToUser;
    }

    public void setPromisedToUser(List<CartTO> promisedToUser) {
        this.promisedToUser = promisedToUser;
    }

    public List<CartTO> getWaiting() {
        return waiting;
    }

    public void setWaiting(List<CartTO> waiting) {
        this.waiting = waiting;
    }
    
    
    
}
