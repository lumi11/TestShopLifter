package cz.muni.fi.pv243.shoplifter.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import cz.muni.fi.pv243.shoplifter.dao.AddressDAO;
import cz.muni.fi.pv243.shoplifter.dto.AddressDTO;
import cz.muni.fi.pv243.shoplifter.dto.DTOToEntity;
import cz.muni.fi.pv243.shoplifter.dto.EntityToDTO;
import cz.muni.fi.pv243.shoplifter.entities.Address;
import cz.muni.fi.pv243.shoplifter.others.Country;
import cz.muni.fi.pv243.shoplifter.service.AddressService;

@TransactionManagement(TransactionManagementType.CONTAINER)
@Stateless(mappedName="AddressService", name="AddressService")
public class AddressServiceImpl implements AddressService {

	@EJB
	private AddressDAO addressDAO;
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createAddress(AddressDTO addressDTO) {
		addressDAO.createAddress(DTOToEntity.addressDTOToAddress(addressDTO));
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void updateAddress(AddressDTO addressDTO) {
		addressDAO.updateAddress(DTOToEntity.addressDTOToAddress(addressDTO));
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void removeAddress(AddressDTO addressDTO) {
		addressDAO.removeAddress(DTOToEntity.addressDTOToAddress(addressDTO));
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public AddressDTO getAddress(Long id) {
		return EntityToDTO.addressToAddressDTO(addressDAO.getAddress(id));
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<AddressDTO> getAllAddressess() {
		List<AddressDTO> result = new ArrayList<>();
		for (Address address : addressDAO.getAllAddressess()) {
			result.add(EntityToDTO.addressToAddressDTO(address));
		}
		return result;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<AddressDTO> findAddressByCity(String city) {
		List<AddressDTO> result = new ArrayList<>();
		for (Address address : addressDAO.findAddressByCity(city)) {
			result.add(EntityToDTO.addressToAddressDTO(address));
		}
		return result;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<AddressDTO> findAddressByStreet(String city, String street) {
		List<AddressDTO> result = new ArrayList<>();
		for (Address address : addressDAO.findAddressByStreet(city, street)) {
			result.add(EntityToDTO.addressToAddressDTO(address));
		}
		return result;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<AddressDTO> findAddressByStreetNumber(String city, String street,
			int streetNumber) {
		List<AddressDTO> result = new ArrayList<>();
		for (Address address : addressDAO.findAddressByStreetNumber(city, street, streetNumber)) {
			result.add(EntityToDTO.addressToAddressDTO(address));
		}
		return result;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<AddressDTO> findAddressByZip(int zip) {
		List<AddressDTO> result = new ArrayList<>();
		for (Address address : addressDAO.findAddressByZip(zip)) {
			result.add(EntityToDTO.addressToAddressDTO(address));
		}
		return result;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<AddressDTO> findAddressByCountry(Country country) {
		List<AddressDTO> result = new ArrayList<>();
		for (Address address : addressDAO.findAddressByCountry(country)) {
			result.add(EntityToDTO.addressToAddressDTO(address));
		}
		return result;
	}
}