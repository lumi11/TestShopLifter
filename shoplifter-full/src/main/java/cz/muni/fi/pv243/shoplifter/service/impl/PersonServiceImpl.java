package cz.muni.fi.pv243.shoplifter.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import cz.muni.fi.pv243.shoplifter.dao.PersonDAO;
import cz.muni.fi.pv243.shoplifter.dto.AddressDTO;
import cz.muni.fi.pv243.shoplifter.dto.DTOToEntity;
import cz.muni.fi.pv243.shoplifter.dto.EntityToDTO;
import cz.muni.fi.pv243.shoplifter.dto.PersonDTO;
import cz.muni.fi.pv243.shoplifter.entities.Person;
import cz.muni.fi.pv243.shoplifter.service.PersonService;

@Stateless(mappedName="PersonService", name="PersonService")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class PersonServiceImpl implements PersonService{

	@EJB
	private PersonDAO personDAO;
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createPerson(PersonDTO personDTO) {
		personDAO.createPerson(DTOToEntity.personDTOToPerson(personDTO));
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void updatePerson(PersonDTO personDTO) {
		personDAO.updatePerson(DTOToEntity.personDTOToPerson(personDTO));
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void removePerson(PersonDTO personDTO) {
		personDAO.removePerson(DTOToEntity.personDTOToPerson(personDTO));
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public PersonDTO getPerson(Long id) {
		return EntityToDTO.personToPersonDTO(personDAO.getPerson(id));
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<PersonDTO> getAllPeople() {
		List<PersonDTO> result = new ArrayList<>();
		for (Person person : personDAO.getAllPeople()) {
			result.add(EntityToDTO.personToPersonDTO(person));
		}
		return result;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public PersonDTO getPersonByLogin(String login) {
		return EntityToDTO.personToPersonDTO(personDAO.getPersonByLogin(login));
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<PersonDTO> findPersonByName(String name) {
		List<PersonDTO> result = new ArrayList<>();
		for (Person person : personDAO.findPersonByName(name)) {
			result.add(EntityToDTO.personToPersonDTO(person));
		}
		return result;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<PersonDTO> findPersonBySurname(String surname) {
		List<PersonDTO> result = new ArrayList<>();
		for (Person person : personDAO.findPersonBySurname(surname)) {
			result.add(EntityToDTO.personToPersonDTO(person));
		}
		return result;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<PersonDTO> findPersonByNameAndSurname(String name,
			String surname) {
		List<PersonDTO> result = new ArrayList<>();
		for (Person person : personDAO.findPersonByNameAndSurname(name, surname)) {
			result.add(EntityToDTO.personToPersonDTO(person));
		}
		return result;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<PersonDTO> findPersonByAddress(AddressDTO address) {
		List<PersonDTO> result = new ArrayList<>();
		for (Person person : personDAO.findPersonByAddress(DTOToEntity.addressDTOToAddress(address))) {
			result.add(EntityToDTO.personToPersonDTO(person));
		}
		return result;
	}
}