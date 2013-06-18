package cz.muni.fi.pv243.shoplifter.dao;

import java.util.List;

import javax.ejb.Local;

import cz.muni.fi.pv243.shoplifter.entities.Address;
import cz.muni.fi.pv243.shoplifter.entities.Person;

@Local
public interface PersonDAO {

	void createPerson(Person person);
	void updatePerson(Person person);
	void removePerson(Person person);
	Person getPerson(Long id);
	Person getPersonByLogin(String login);
	List<Person> getAllPeople();
	List<Person> findPersonByName(String name);
	List<Person> findPersonBySurname(String surname);
	List<Person> findPersonByNameAndSurname(String name, String surname);
	List<Person> findPersonByAddress(Address address);
}
