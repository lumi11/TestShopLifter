package cz.muni.fi.pv243.shoplifter.service;

import java.util.List;

import javax.ejb.Local;

import cz.muni.fi.pv243.shoplifter.dto.ShopItemDTO;

@Local
public interface ShopItemService {

	void createShopItem(ShopItemDTO shopItemDTO);
	void updateShopItem(ShopItemDTO shopItemDTO);
	void removeShopItem(ShopItemDTO shopItemDTO);
	ShopItemDTO getShopItem(Long id);
	List<ShopItemDTO> getAllShopItems();
	List<ShopItemDTO> findShopItemByName(String name);
}
