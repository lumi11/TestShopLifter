package cz.muni.fi.pv243.shoplifter.service;

import java.util.List;

import javax.ejb.Local;

import cz.muni.fi.pv243.shoplifter.dto.AddressDTO;
import cz.muni.fi.pv243.shoplifter.others.Country;

@Local
public interface AddressService {

	void createAddress(AddressDTO addressDTO);
	void updateAddress(AddressDTO addressDTO);
	void removeAddress(AddressDTO addressDTO);
	AddressDTO getAddress(Long id);
	List<AddressDTO> getAllAddressess();
	List<AddressDTO> findAddressByCity(String city);
	List<AddressDTO> findAddressByStreet(String city, String street);
	List<AddressDTO> findAddressByStreetNumber(String city, String street, int streetNumber);
	List<AddressDTO> findAddressByZip(int zip);
	List<AddressDTO> findAddressByCountry(Country country);
}
