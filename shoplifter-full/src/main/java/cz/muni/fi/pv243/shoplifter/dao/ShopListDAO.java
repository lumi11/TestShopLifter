package cz.muni.fi.pv243.shoplifter.dao;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.ejb.Local;

import cz.muni.fi.pv243.shoplifter.entities.Person;
import cz.muni.fi.pv243.shoplifter.entities.ShopList;

@Local
public interface ShopListDAO {

	void createShopList(ShopList shopList);
	void updateShopList(ShopList shopList);
	void removeShopList(ShopList shopList);
	ShopList getShopList(Long id);
	List<ShopList> getAllShopLists();
	List<ShopList> findShopListByApplicant(Person applicant);
	List<ShopList> findShopListByReward(String reward);
	List<ShopList> findShopListByDeadline(Date deadlineDate);
	List<ShopList> findShopListByDeadline(Date deadlineDate, Time deadlineTime);
}
