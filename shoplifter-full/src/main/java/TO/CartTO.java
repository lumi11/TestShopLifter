/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TO;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author martin
 */
public class CartTO implements Serializable {

	private Long id;
    private List<ShopItemTO> items = new ArrayList<ShopItemTO>();
    private String userName;
    private String userSurrname;
    private Date deadline;
    private String shopper;
    private Date shoppedTime;
    private String reward;
    
    public CartTO() {
        items.add(new ShopItemTO());
        items.add(new ShopItemTO());
        userName = "Michal";
        userSurrname = "Matejovsky";
        deadline = Calendar.getInstance().getTime();
        shopper = "Gejza Lakatos";
        shoppedTime = Calendar.getInstance().getTime();
        reward = "Šanghaj Cola";
        
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }
    
    

    public Date getShoppedTime() {
        return shoppedTime;
    }

    public void setShoppedTime(Date shoppedTime) {
        this.shoppedTime = shoppedTime;
    }
    
    

    public String getShopper() {
        return shopper;
    }

    public void setShopper(String shopper) {
        this.shopper = shopper;
    }
    
    

    public List<ShopItemTO> getItems() {
        return items;
    }

    public void setItems(List<ShopItemTO> items) {
        this.items = items;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurrname() {
        return userSurrname;
    }

    public void setUserSurrname(String userSurrname) {
        this.userSurrname = userSurrname;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    
    
    
}
