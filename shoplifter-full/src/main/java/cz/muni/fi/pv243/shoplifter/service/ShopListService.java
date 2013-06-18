package cz.muni.fi.pv243.shoplifter.service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.ejb.Local;

import cz.muni.fi.pv243.shoplifter.dto.PersonDTO;
import cz.muni.fi.pv243.shoplifter.dto.ShopListDTO;

@Local
public interface ShopListService {

	void createShopList(ShopListDTO shopListDTO);
	void updateShopList(ShopListDTO shopListDTO);
	void removeShopList(ShopListDTO shopListDTO);
	ShopListDTO getShopList(Long id);
	List<ShopListDTO> getAllShopLists();
	List<ShopListDTO> findShopListByApplicant(PersonDTO applicant);
	List<ShopListDTO> findShopListByReward(String reward);
	List<ShopListDTO> findShopListByDeadline(Date deadlineDate);
	List<ShopListDTO> findShopListByDeadline(Date deadlineDate, Time deadlineTime);
}
