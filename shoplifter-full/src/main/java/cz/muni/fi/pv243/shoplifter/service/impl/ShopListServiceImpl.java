package cz.muni.fi.pv243.shoplifter.service.impl;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import cz.muni.fi.pv243.shoplifter.dao.ShopListDAO;
import cz.muni.fi.pv243.shoplifter.dto.DTOToEntity;
import cz.muni.fi.pv243.shoplifter.dto.EntityToDTO;
import cz.muni.fi.pv243.shoplifter.dto.PersonDTO;
import cz.muni.fi.pv243.shoplifter.dto.ShopListDTO;
import cz.muni.fi.pv243.shoplifter.entities.ShopList;
import cz.muni.fi.pv243.shoplifter.service.ShopListService;

@Stateless(mappedName="ShopListService", name="ShopListService")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ShopListServiceImpl implements ShopListService {

	@EJB
	private ShopListDAO shopListDAO;
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createShopList(ShopListDTO shopListDTO) {
		shopListDAO.createShopList(DTOToEntity.shopListDTOToShopList(shopListDTO));
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void updateShopList(ShopListDTO shopListDTO) {
		shopListDAO.updateShopList(DTOToEntity.shopListDTOToShopList(shopListDTO));
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void removeShopList(ShopListDTO shopListDTO) {
		shopListDAO.removeShopList(DTOToEntity.shopListDTOToShopList(shopListDTO));
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ShopListDTO getShopList(Long id) {
		return EntityToDTO.shopListToShopListDTO(shopListDAO.getShopList(id));
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<ShopListDTO> getAllShopLists() {
		List<ShopListDTO> result = new ArrayList<>();
		for (ShopList shopList : shopListDAO.getAllShopLists()) {
			result.add(EntityToDTO.shopListToShopListDTO(shopList));
		}
		return result;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<ShopListDTO> findShopListByApplicant(PersonDTO applicant) {
		List<ShopListDTO> result = new ArrayList<>();
		for (ShopList shopList : shopListDAO.findShopListByApplicant(DTOToEntity.personDTOToPerson(applicant))) {
			result.add(EntityToDTO.shopListToShopListDTO(shopList));
		}
		return result;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<ShopListDTO> findShopListByReward(String reward) {
		List<ShopListDTO> result = new ArrayList<>();
		for (ShopList shopList : shopListDAO.findShopListByReward(reward)) {
			result.add(EntityToDTO.shopListToShopListDTO(shopList));
		}
		return result;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<ShopListDTO> findShopListByDeadline(Date deadlineDate) {
		List<ShopListDTO> result = new ArrayList<>();
		for (ShopList shopList : shopListDAO.findShopListByDeadline(deadlineDate)) {
			result.add(EntityToDTO.shopListToShopListDTO(shopList));
		}
		return result;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<ShopListDTO> findShopListByDeadline(Date deadlineDate,
			Time deadlineTime) {
		List<ShopListDTO> result = new ArrayList<>();
		for (ShopList shopList : shopListDAO.findShopListByDeadline(deadlineDate, deadlineTime)) {
			result.add(EntityToDTO.shopListToShopListDTO(shopList));
		}
		return result;
	}
}