/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trash;

import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author martin
 */
@ManagedBean
public class CartDAO {

    
    private List<ShopItemDAO> items; 
    private String userName;
    private String userSurrname;
    private Date deadline;

    public CartDAO() {
        userName = "Jozko";
        userSurrname = "Mrkvicka";
        deadline = new Date();
        items.add(new ShopItemDAO());
        System.err.println("cart dato done");
   }
    
    

    public List<ShopItemDAO> getItems() {
        return items;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserSurrname() {
        return userSurrname;
    }

    public Date getDeadline() {
        return deadline;
    }
          
    

}
