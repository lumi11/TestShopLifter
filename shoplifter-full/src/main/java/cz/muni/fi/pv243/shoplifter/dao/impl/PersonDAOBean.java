package cz.muni.fi.pv243.shoplifter.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cz.muni.fi.pv243.shoplifter.dao.PersonDAO;
import cz.muni.fi.pv243.shoplifter.entities.Address;
import cz.muni.fi.pv243.shoplifter.entities.Person;

@Named
public @Stateless class PersonDAOBean implements PersonDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void createPerson(Person person) {
		validate(person);
		if (person.getId() != null) {
			throw new IllegalArgumentException("person id set");
		}
		Address address = entityManager.find(Address.class, person.getAddress().getId());
		person.setAddress(address);
		
		List<Person> friends = new ArrayList<>();
		for (Person person2 : person.getFriends()) {
			friends.add(entityManager.find(Person.class, person2.getId()));
		}
		person.setFriends(friends);
		
		List<Person> myRequests = new ArrayList<>();
		for (Person person2 : person.getMyRequests()) {
			friends.add(entityManager.find(Person.class, person2.getId()));
		}
		person.setFriends(myRequests);
		
		List<Person> requestForMe = new ArrayList<>();
		for (Person person2 : person.getRequestForMe()) {
			friends.add(entityManager.find(Person.class, person2.getId()));
		}
		person.setFriends(requestForMe);
		entityManager.persist(person);
	}

	@Override
	public void updatePerson(Person person) {
		if (person.getId() == null) {
			throw new IllegalArgumentException("Cannot update person with null id");
		}
		validate(person);
		Person find = entityManager.find(Person.class, person.getId());
		if (find == null) {
				throw new IllegalArgumentException("Person {0} is not in database, but attemt to update" + person);
		}
		if (!person.equals(find)) {
			throw new IllegalArgumentException(person + " update person");
		}
		entityManager.merge(person);
		entityManager.flush();
	}

	@Override
	public void removePerson(Person person) {
		if (person == null || person.getId() == null) {
			throw new IllegalArgumentException("Remove person with wrong params");
		}
		Person result = entityManager.find(Person.class, person.getId());
		if (result == null) {
			throw new IllegalArgumentException("Remove: person is not in database");
		}
		entityManager.remove(result);
	}

	@Override
	public Person getPerson(Long id) {
		if (id == null) {
			throw new IllegalArgumentException("getPerson with null id");
		}
		Person result = entityManager.find(Person.class, id);
		if (result == null) {
			return null;
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> getAllPeople() {
		List<Person> result;
		Query query = entityManager.createQuery("SELECT p FROM Person p ORDERED BY p.id");
		result = query.getResultList();
		for (Person person : result) {
			entityManager.detach(person);
		}
		return result;
	}

	@Override
	public Person getPersonByLogin(String login) {
		if (login == null) {
			throw new IllegalArgumentException("getPersonByLogin with null login");
		}
		Person result;
		Query query = entityManager.createQuery("SELECT p FROM Person p WHERE p.login LIKE :login ");
		query.setParameter("login", login);
		result = (Person) query.getSingleResult();
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> findPersonByName(String name) {
		if (name == null) {
			throw new IllegalArgumentException("findPersonByName: name is null");
		}
		List<Person> result;
		Query query = entityManager.createQuery("SELECT p FROM Person p WHERE p.name LIKE :name ORDERED BY p.id");
		query.setParameter("name", name);
		result = query.getResultList();
		for (Person person : result) {
			entityManager.detach(person);
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Person> findPersonBySurname(String surname) {
		if (surname == null) {
			throw new IllegalArgumentException("findPersonBySurname: surname is null");
		}
		List<Person> result;
		Query query = entityManager.createQuery("SELECT p FROM Person p WHERE p.surname LIKE :surname ORDERED BY p.id");
		query.setParameter("name", surname);
		result = query.getResultList();
		for (Person person : result) {
			entityManager.detach(person);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> findPersonByNameAndSurname(String name, String surname) {
		if (name == null) {
			throw new IllegalArgumentException("findPersonByNameAndSurname: name is null");
		}
		if (surname == null) {
			throw new IllegalArgumentException("findPersonBynameAndSurname: surname is null");
		}
		List<Person> result;
		Query query = entityManager.createQuery("SELECT p FROM Person p WHERE p.name LIKE :name AND p.surname LIKE :sORDERED BY p.id");
		query.setParameter("name", name);
		query.setParameter("surname", surname);
		result = query.getResultList();
		for (Person person : result) {
			entityManager.detach(person);
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Person> findPersonByAddress(Address address) {
		if (address == null || address.getId() == null) {
			throw new IllegalArgumentException("address or address id is null");
		}
		List<Person> result;
		Query query = entityManager.createQuery("SELECT p FROM Person p WHERE p.address LIKE :address");
		query.setParameter("address", address);
		result = query.getResultList();
		for (Person person : result) {
			entityManager.detach(person);
		}
		return result;
	}

	private void validate(Person person) {
		if (person == null) {
			throw new IllegalArgumentException("person is null");
		}
		if (person.getName() == null) {
			throw new IllegalArgumentException("Person: name is null");
		}
		if (person.getSurname() == null) {
			throw new IllegalArgumentException("Person: surname is null");
		}
		if (person.getLogin() == null) {
			throw new IllegalArgumentException("Person: login is null");
		}
	}
}
