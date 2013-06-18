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
public class ShopItemTO implements Serializable {

	private Long id;
    private String name;
    private Integer amount;
    private Boolean bought;


    public ShopItemTO() {
        name = "rozky";
        amount = 10;
        bought = false;
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



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}
}
