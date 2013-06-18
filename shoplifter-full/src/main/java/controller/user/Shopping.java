/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import TO.BuingItemTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author martin
 */
@ManagedBean
@SessionScoped
public class Shopping implements Serializable {

    private List<BuingItemTO> promisedOrders = new ArrayList<BuingItemTO>();
    private List<BuingItemTO> myOrders = new ArrayList<BuingItemTO>();
    private Long missnigItemID;

    @PostConstruct
    public void init() {
        promisedOrders.add(new BuingItemTO());
        promisedOrders.add(new BuingItemTO());
        promisedOrders.add(new BuingItemTO());
        
        myOrders.add(new BuingItemTO());
        myOrders.add(new BuingItemTO());
    }

    public List<BuingItemTO> getPromisedOrders() {
        return promisedOrders;
    }

    public void setPromisedOrders(List<BuingItemTO> promisedOrders) {
        this.promisedOrders = promisedOrders;
    }

    public Long getMissnigItemID() {
        return missnigItemID;
    }

    public void setMissnigItemID(Long missnigItemID) {
        this.missnigItemID = missnigItemID;
    }

    public List<BuingItemTO> getMyOrders() {
        return myOrders;
    }

    public void setMyOrders(List<BuingItemTO> myOrders) {
        this.myOrders = myOrders;
    }

    public String missingItem(Long itemId) {
        //TODO: replace with real code
        System.err.println("removing"+ itemId);
        for (BuingItemTO buingItemTO : promisedOrders) {
            if (buingItemTO.getId().equals(itemId)) {
                promisedOrders.remove(buingItemTO);
                System.err.println("helele");
                break;

            }

        }
        /*   for (Iterator<BuingItemTO> it = promisedOrders.iterator(); it.hasNext();) {
         BuingItemTO buingItemTO = it.next();
            
         }*/
        return "shopping";
    }
}
