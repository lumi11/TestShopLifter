package cz.muni.fi.pv243.shoplifter.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cz.muni.fi.pv243.shoplifter.dao.AddressDAO;
import cz.muni.fi.pv243.shoplifter.entities.Address;
import cz.muni.fi.pv243.shoplifter.others.Country;


@Named
public @Stateless class AddressDAOBean implements AddressDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void createAddress(Address address) {
		validate(address);
		if (address.getId() != null) {
			throw new IllegalArgumentException("address id is set");
		}
		entityManager.persist(address);
	}

	@Override
	public void updateAddress(Address address) {
		validate(address);
		if (address.getId() == null) {
			throw new IllegalArgumentException("Cannot update address with null id");
		}
		Address find = entityManager.find(Address.class, address.getId());
		if (find == null) {
			throw new IllegalArgumentException("Address {0} is not in database, but attemt to update" + address);
		}
		if (!address.equals(find)) {
			throw new IllegalArgumentException(address + " update address");
		}
		entityManager.merge(find);
		entityManager.flush();
		// person <----> address bidirectional (hladanie ludi na rovnakej adrese)
	}

	@Override
	public void removeAddress(Address address) {
		if (address == null || address.getId() == null) {
			throw new IllegalArgumentException("remove address with wrong params");
		}
		Address result = entityManager.find(Address.class, address.getId());
		if (result == null) {
			throw new IllegalArgumentException("Remove: address is not in database");
		}
		entityManager.remove(result);
	}

	@Override
	public Address getAddress(Long id) {
		if (id == null) {
			throw new IllegalArgumentException("getAddress with null id");
		}
		Address result = entityManager.find(Address.class, id);
		if (result == null) {
			return null;
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Address> getAllAddressess() {
		List<Address> result;
		Query query = entityManager.createQuery("SELECT a FROM Address a ORDERED BY a.id");
		result = query.getResultList();
		for (Address address : result) {
			entityManager.detach(address);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Address> findAddressByCity(String city) {
		List<Address> result;
		Query query = entityManager.createQuery("SELECT a FROM Address a WHERE a.city LIKE :city ORDERED BY a.id");
		query.setParameter("city", city);
		result = query.getResultList();
		for (Address address : result) {
			entityManager.detach(address);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Address> findAddressByStreet(String city, String street) {
		List<Address> result;
		Query query = entityManager.createQuery("SELECT a FROM Address a WHERE a.city LIKE :city AND a.street LIKE :street ORDERED BY a.id");
		query.setParameter("city", city);
		query.setParameter("street", street);
		result = query.getResultList();
		for (Address address : result) {
			entityManager.detach(address);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Address> findAddressByStreetNumber(String city, String street,
			int streetNumber) {
		List<Address> result;
		Query query = entityManager.createQuery("SELECT a FROM Address a WHERE a.city LIKE :city AND a.street LIKE :street AND a.streetnumber LIKE :streetNumber ORDERED BY a.id");
		query.setParameter("city", city);
		query.setParameter("street", street);
		query.setParameter("streetNumber", streetNumber);
		result = query.getResultList();
		for (Address address : result) {
			entityManager.detach(address);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Address> findAddressByZip(int zip) {
		List<Address> result;
		Query query = entityManager.createQuery("SELECT a FROM Address a WHERE a.zip LIKE :zip ORDERED BY a.id");
		query.setParameter("zip", zip);
		result = query.getResultList();
		for (Address address : result) {
			entityManager.detach(address);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Address> findAddressByCountry(Country country) {
		List<Address> result;
		Query query = entityManager.createQuery("SELECT a FROM Address a WHERE a.country LIKE :country ORDERED BY a.id");
		query.setParameter("city", country);
		result = query.getResultList();
		for (Address address : result) {
			entityManager.detach(address);
		}
		return result;
	}

	private void validate(Address address) {
		if (address == null) {
			throw new IllegalArgumentException("Address is null");
		}
		if (address.getCity() == null) {
			throw new IllegalArgumentException("Address: city is null");
		}
		if (address.getStreet() == null) {
			throw new IllegalArgumentException("Address: street is null");
		}
		if (address.getStreetNumber() <= 0) {
			throw new IllegalArgumentException("Address: street number is not valid");
		}
		if (address.getZip() <= 0) {
			throw new IllegalArgumentException("Address: zip is not valid");
		}
		if (address.getCountry() == null) {
			throw new IllegalArgumentException("Address: country is null");
		}
	}
}