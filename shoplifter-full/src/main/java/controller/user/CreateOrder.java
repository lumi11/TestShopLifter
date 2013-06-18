/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import TO.CartTO;
import TO.ShopItemTO;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import cz.muni.fi.pv243.shoplifter.dto.ShopItemDTO;
import cz.muni.fi.pv243.shoplifter.service.ShopItemService;

/**
 *
 * @author martin
 */
@ManagedBean
@SessionScoped
public class CreateOrder implements Serializable{


    private CartTO compilingCart = new CartTO();
    private ShopItemTO compilingItem = new ShopItemTO();
    private ShopItemDTO item = new ShopItemDTO();
    @EJB
    private ShopItemService itemService;
    
    @PostConstruct
    public void init() {
    	item.setName("mlieko");
    	item.setCount(2);
    	item.setBought(false);
    	itemService.createShopItem(item);
    }
    
    public CreateOrder() {
        compilingItem.setAmount(new Integer(100));
        compilingItem.setName("Salama");
    }


    public CartTO getCompilingCart() {
        return compilingCart;
    }

    public void setCompilingCart(CartTO compilingCart) {
        this.compilingCart = compilingCart;
    }

    public ShopItemTO getCompilingItem() {
        return compilingItem;
    }

    public void setCompilingItem(ShopItemTO compilingItem) {
        this.compilingItem = compilingItem;
    }
    

    public String addItemToCart() {
        compilingCart.getItems().add(compilingItem);
        compilingItem = new ShopItemTO();
        compilingItem.setAmount(200);
        compilingItem.setName("Salama a slanina");
        return "createOrder";
    }
    
    public void removeItemFromCart(Long itemId){
        
    }
    

    public void createOrder() {
        compilingCart = new CartTO();
    }
}
