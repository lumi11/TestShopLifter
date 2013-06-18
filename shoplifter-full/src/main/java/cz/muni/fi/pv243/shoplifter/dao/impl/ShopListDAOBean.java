package cz.muni.fi.pv243.shoplifter.dao.impl;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cz.muni.fi.pv243.shoplifter.dao.ShopListDAO;
import cz.muni.fi.pv243.shoplifter.entities.Person;
import cz.muni.fi.pv243.shoplifter.entities.ShopItem;
import cz.muni.fi.pv243.shoplifter.entities.ShopList;
import cz.muni.fi.pv243.shoplifter.others.ShopListStatus;

@Named
public @Stateless class ShopListDAOBean implements ShopListDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void createShopList(ShopList shopList) {
		validate(shopList);
		if (shopList.getId() != null) {
			throw new IllegalArgumentException("shopList id is set");
		}
		List<ShopItem> goods = new ArrayList<>();
		for (ShopItem shopItem : shopList.getGoods()) {
			goods.add(entityManager.find(ShopItem.class, shopItem.getId()));
		}
		shopList.setGoods(goods);
		shopList.setStatus(ShopListStatus.REQUIRED);
		
		Person applicant = entityManager.find(Person.class , shopList.getApplicant().getId());
		shopList.setApplicant(applicant);

		shopList.setBuyer(null); //default nie je ziadny kupujuci
		entityManager.persist(shopList);
	}

	@Override
	public void updateShopList(ShopList shopList) {
		validate(shopList);
		if (shopList.getId() == null) {
			throw new IllegalArgumentException("Cannot update shopList with null id");
		}
		ShopList find = entityManager.find(ShopList.class, shopList.getId());
		if (find == null) {
			throw new IllegalArgumentException("ShopList {0} is not in database, but attemt to update" + shopList);
		}
		if (!shopList.equals(find)) {
			throw new IllegalArgumentException(shopList + "update shopList");
		}
		entityManager.merge(shopList);
		entityManager.flush();
	}

	@Override
	public void removeShopList(ShopList shopList) {
		if (shopList == null || shopList.getId() == null) {
			throw new IllegalArgumentException("Remove shopList with wrong params");
		}
		ShopList result = entityManager.find(ShopList.class, shopList.getId());
		if (result == null) {
				throw new IllegalArgumentException("Remove: shopList is not in database");
		}
		entityManager.remove(result);
	}

	@Override
	public ShopList getShopList(Long id) {
		if (id == null) {
			throw new IllegalArgumentException("getShopList with null id");
		}
		ShopList result = entityManager.find(ShopList.class, id);
		if (result == null) {
			return null;
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ShopList> getAllShopLists() {
		List<ShopList> result;
		Query query = entityManager.createQuery("SELECT s FROM ShopList s ORDERED BY s.id");
		result = query.getResultList();
		for (ShopList shopList : result) {
			entityManager.detach(shopList);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ShopList> findShopListByApplicant(Person applicant) {
		if (applicant == null || applicant.getId() == null) {
			throw new IllegalArgumentException("applicant or applicant id is null");
		}
		List<ShopList> result;
		Query query = entityManager.createQuery("SELECT s FROM ShopList WHERE s.applicant LIKE :applicant ORDERED BY s.id");
		query.setParameter("applicant", applicant);
		result = query.getResultList();
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ShopList> findShopListByReward(String reward) {
		List<ShopList> result;
		Query query = entityManager.createQuery("SELECT s FROM ShopList WHERE s.reward LIKE :reward ORDERED BY s.id");
		query.setParameter("reward", reward);
		result = query.getResultList();
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ShopList> findShopListByDeadline(Date deadlineDate) {
		List<ShopList> result;
		Query query = entityManager.createQuery("SELECT s FROM ShopList WHERE s.deadlineDate LIKE :deadlineDate ORDERED BY s.id");
		query.setParameter("deadlineDate", deadlineDate);
		result = query.getResultList();
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ShopList> findShopListByDeadline(Date deadlineDate,
			Time deadlineTime) {
		List<ShopList> result;
		Query query = entityManager.createQuery("SELECT s FROM ShopList WHERE s.deadlineDate LIKE :deadlineDate AND s.deadlineTime LIKE :deadlineTime ORDERED BY s.id");
		query.setParameter("deadlineDate", deadlineDate);
		query.setParameter("deadlineTime", deadlineTime);
		result = query.getResultList();
		return result;

	}

	private void validate(ShopList shopList) {
		if (shopList == null) {
			throw new IllegalArgumentException("shopList is null");
		}
		if (shopList.getApplicant() == null) {
			throw new IllegalArgumentException("ShopList: applicant is null");
		}
		if (shopList.getGoods() == null) {
			throw new IllegalArgumentException("ShopList: goods are null");
		}
		if (shopList.getDeadlineDate() == null) {
			throw new IllegalArgumentException("ShopList: deadlineDate is null");
		}
	}
}