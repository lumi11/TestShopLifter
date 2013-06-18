package cz.muni.fi.pv243.shoplifter.service;

import java.util.List;

import javax.ejb.Local;

import cz.muni.fi.pv243.shoplifter.dto.AddressDTO;
import cz.muni.fi.pv243.shoplifter.dto.PersonDTO;

@Local
public interface PersonService {

	void createPerson(PersonDTO personDTO);
	void updatePerson(PersonDTO personDTO);
	void removePerson(PersonDTO personDTO);
	PersonDTO getPerson(Long id);
	PersonDTO getPersonByLogin(String login);
	List<PersonDTO> getAllPeople();
	List<PersonDTO> findPersonByName(String name);
	List<PersonDTO> findPersonBySurname(String surname);
	List<PersonDTO> findPersonByNameAndSurname(String name, String surname);
	List<PersonDTO> findPersonByAddress(AddressDTO address);
}
