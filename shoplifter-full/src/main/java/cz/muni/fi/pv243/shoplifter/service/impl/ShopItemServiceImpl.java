package cz.muni.fi.pv243.shoplifter.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import cz.muni.fi.pv243.shoplifter.dao.ShopItemDAO;
import cz.muni.fi.pv243.shoplifter.dto.DTOToEntity;
import cz.muni.fi.pv243.shoplifter.dto.EntityToDTO;
import cz.muni.fi.pv243.shoplifter.dto.ShopItemDTO;
import cz.muni.fi.pv243.shoplifter.entities.ShopItem;
import cz.muni.fi.pv243.shoplifter.service.ShopItemService;

@Stateless(mappedName="ShopItemService", name="ShopItemService")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ShopItemServiceImpl implements ShopItemService {

	@EJB
	private ShopItemDAO shopItemDAO;
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createShopItem(ShopItemDTO shopItemDTO) {
		shopItemDAO.createShopItem(DTOToEntity.shopItemDTOToShopItem(shopItemDTO));
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void updateShopItem(ShopItemDTO shopItemDTO) {
		shopItemDAO.updateShopItem(DTOToEntity.shopItemDTOToShopItem(shopItemDTO));
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void removeShopItem(ShopItemDTO shopItemDTO) {
		shopItemDAO.removeShopItem(DTOToEntity.shopItemDTOToShopItem(shopItemDTO));
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ShopItemDTO getShopItem(Long id) {
		return EntityToDTO.shopItemToShopItemDTO(shopItemDAO.getShopItem(id));
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<ShopItemDTO> getAllShopItems() {
		List<ShopItemDTO> result = new ArrayList<>();
		for (ShopItem shopItem : shopItemDAO.getAllShopItems()) {
			result.add(EntityToDTO.shopItemToShopItemDTO(shopItem));
		}
		return result;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<ShopItemDTO> findShopItemByName(String name) {
		List<ShopItemDTO> result = new ArrayList<>();
		for (ShopItem shopItem : shopItemDAO.findShopItemByName(name)) {
			result.add(EntityToDTO.shopItemToShopItemDTO(shopItem));
		}
		return result;
	}
}