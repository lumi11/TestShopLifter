package cz.muni.fi.pv243.shoplifter.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cz.muni.fi.pv243.shoplifter.dao.ShopItemDAO;
import cz.muni.fi.pv243.shoplifter.entities.ShopItem;

@Named("shopItemBean")
public @Stateless class ShopItemDAOBean implements ShopItemDAO {

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public void createShopItem(ShopItem shopItem) {
		validate(shopItem);
		if (shopItem.getId() != null) {
			throw new IllegalArgumentException("shopItem id is set");
		}
		entityManager.persist(shopItem);
	}

	@Override
	public void updateShopItem(ShopItem shopItem) {
		validate(shopItem);
		if (shopItem.getId() == null) {
			throw new IllegalArgumentException("Cannot update shopItem with null id");
		}
		ShopItem find = entityManager.find(ShopItem.class, shopItem.getId());
		if (find == null) {
			throw new IllegalArgumentException("ShopItem {0} is not in database, but attemt to update." + shopItem);
		}
		if (!shopItem.equals(find)) {
			throw new IllegalArgumentException(shopItem + "update shopItem");
		}
		
		entityManager.merge(shopItem);
		entityManager.flush();
		//TODO updateOrCreate
	}

	@Override
	public void removeShopItem(ShopItem shopItem) {
		if (shopItem == null || shopItem.getId() == null) {
			throw new IllegalArgumentException("Remove shopItem with wrong params");
		}
		ShopItem result = entityManager.find(ShopItem.class, shopItem.getId());
		if (result == null) {
			throw new IllegalArgumentException("Remove: shopItem is not in database");
		}
		entityManager.remove(result);
	}

	@Override
	public ShopItem getShopItem(Long id) {
		if (id == null) {
			throw new IllegalArgumentException("getShopItem with null id");
		}
		ShopItem result = entityManager.find(ShopItem.class, id);
		if (result == null) {
			return null;
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ShopItem> getAllShopItems() {
		List<ShopItem> result;
		Query query = entityManager.createQuery("SELECT s FROM ShopItem s ORDERED BY s.id");
		result = query.getResultList();
		for (ShopItem shopItem : result) {
			entityManager.detach(shopItem);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ShopItem> findShopItemByName(String name) {
		List<ShopItem> result;
		Query query = entityManager.createQuery("SELECT s FROM ShopItem s WHERE s.name LIKE :name ORDERED by s.id");
		query.setParameter("name", name);
		result = query.getResultList();
		for (ShopItem shopItem : result) {
			entityManager.detach(shopItem);
		}
		return result;
	}
	
	private void validate(ShopItem shopItem) {
		if (shopItem == null) {
			throw new IllegalArgumentException("ShopItem is null");
		}
		if (shopItem.getName() == null) {
			throw new IllegalArgumentException("ShopItem: name is null");
		}
		if (shopItem.getCount() <= 0) {
			throw new IllegalArgumentException("ShopItem: count is zero or negative");
		}
	}

	@Override
	public String test(String text) {
		return "hallo " + text;
	}
}