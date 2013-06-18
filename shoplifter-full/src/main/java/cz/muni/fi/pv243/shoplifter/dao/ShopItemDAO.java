package cz.muni.fi.pv243.shoplifter.dao;

import java.util.List;

import javax.ejb.Local;

import cz.muni.fi.pv243.shoplifter.entities.ShopItem;

@Local
public interface ShopItemDAO {

	void createShopItem(ShopItem shopItem);
	void updateShopItem(ShopItem shopItem);
	void removeShopItem(ShopItem shopItem);
	ShopItem getShopItem(Long id);
	List<ShopItem> getAllShopItems();
	List<ShopItem> findShopItemByName(String name);
	String test(String text);
}
