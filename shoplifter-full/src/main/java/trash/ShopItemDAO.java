/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trash;

import javax.faces.bean.ManagedBean;

/**
 *
 * @author martin
 */
@ManagedBean
public class ShopItemDAO {

    
    private String name;
    private Integer amount;
    private Boolean bought;

    public ShopItemDAO() {
       name = "rožky";
       amount = 10;
       bought = false;   
        System.err.println("shop item done");
    }

    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Boolean getBought() {
        return bought;
    }

    public void setBought(Boolean bought) {
        this.bought = bought;
    }
    
    
    
}
