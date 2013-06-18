/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TO;

import java.io.Serializable;

/**
 *
 * @author martin
 */
public class BuingItemTO implements Serializable {
    
    private String item;
    private Integer amount;
    private String user;
    private Boolean missing;
    private Long id;

    public BuingItemTO() {
        item = "rožky";
        amount = 10;
        user = "Jano";
        id = new Long(1l);
        missing = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    

    
    public Boolean getMissing() {
        return missing;
    }

    public void setMissing(Boolean missing) {
        this.missing = missing;
    }

    
    
    
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BuingItemTO other = (BuingItemTO) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
