package cz.muni.fi.pv243.shoplifter.dao;

import java.util.List;

import javax.ejb.Local;

import cz.muni.fi.pv243.shoplifter.entities.Address;
import cz.muni.fi.pv243.shoplifter.others.Country;

@Local
public interface AddressDAO {
	
	void createAddress(Address address);
	void updateAddress(Address address);
	void removeAddress(Address address);
	Address getAddress(Long id);
	List<Address> getAllAddressess();
	List<Address> findAddressByCity(String city);
	List<Address> findAddressByStreet(String city, String street);
	List<Address> findAddressByStreetNumber(String city, String street, int streetNumber);
	List<Address> findAddressByZip(int zip);
	List<Address> findAddressByCountry(Country country);
}
