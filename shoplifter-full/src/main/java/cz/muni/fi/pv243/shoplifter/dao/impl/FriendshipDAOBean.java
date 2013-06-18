package cz.muni.fi.pv243.shoplifter.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cz.muni.fi.pv243.shoplifter.dao.FriendshipDAO;
import cz.muni.fi.pv243.shoplifter.entities.Friendship;
import cz.muni.fi.pv243.shoplifter.entities.Person;
import cz.muni.fi.pv243.shoplifter.others.FriendshipStatus;

@Named
public @Stateless class FriendshipDAOBean implements FriendshipDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	private Friendship friendship;
	
	public FriendshipDAOBean() {
		friendship = new Friendship();
	}

	@Override
	public void createFriendship() {
		validate(friendship);
		if (friendship.getId() != null) {
			throw new IllegalArgumentException("friendship id is set");
		}
		if (friendship.getStatus().equals(FriendshipStatus.ACCEPTED)) {
			List<Person> tempList = friendship.getApplicant().getFriends();
			tempList.add(friendship.getRecipient());
			friendship.getApplicant().setFriends(tempList);
			tempList = friendship.getRecipient().getFriends();
			tempList.add(friendship.getApplicant());
			friendship.getRecipient().setFriends(tempList);
			tempList = null;
			entityManager.persist(friendship);
		} else {
			throw new IllegalArgumentException("friendship is not accepted");
		}
	}

	@Override
	public void updateFriendship(Friendship friendship) {
		validate(friendship);
		if (friendship.getId() == null) {
			throw new IllegalArgumentException("Cannot update friendship with null id");
		}
		Friendship find = entityManager.find(Friendship.class, friendship.getId());
		if (find == null) {
			throw new IllegalArgumentException("Friendship {0} is not in database, but attemt to update." + friendship);
		}
		if (!friendship.equals(find)) {
			throw new IllegalArgumentException(friendship + "update friendship");
		}
		
		entityManager.merge(friendship);
		entityManager.flush();
	}

	@Override
	public void removeFriendship(Friendship friendship) {
		if (friendship == null || friendship.getId() == null) {
			throw new IllegalArgumentException("remove friendship with wrong params");
		}
		Friendship result = entityManager.find(Friendship.class, friendship.getId());
		if (result == null) {
			throw new IllegalArgumentException("Remove: friendship is not in database");
		}
		Person applicant = entityManager.find(Person.class, friendship.getApplicant().getId());
		Person recipient = entityManager.find(Person.class, friendship.getRecipient().getId());
		applicant.getFriends().remove(recipient);
		recipient.getFriends().remove(applicant);
		entityManager.merge(applicant);
		entityManager.merge(recipient);
		entityManager.remove(friendship);
//		entityManager.flush();
	}

	@Override
	public Friendship getFriendship(Long id) {
		if (id == null) {
			throw new IllegalArgumentException("getFriendship with null id");
		}
		Friendship result = entityManager.find(Friendship.class, id);
		if (result == null) {
			return null;
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Friendship> getAllFriendships() {
		List<Friendship> result;
		Query query = entityManager.createQuery("SELECT f FROM Friendship f ORDERED BY f.id");
		result = query.getResultList();
		for (Friendship friendship : result) {
			entityManager.detach(friendship);
		}
		return result;
	}

	@Override
	public void requestFriendship(Person applicant, Person recipient) {
		List<Person> tempList = new ArrayList<>(applicant.getMyRequests());
		tempList.add(recipient);
		applicant.setMyRequests(tempList);
		
		List<Person> tempList1 = new ArrayList<>(recipient.getRequestForMe());
		tempList1.add(applicant);
		recipient.setRequestForMe(tempList1);
		
		friendship.setApplicant(applicant);
		friendship.setRecipient(recipient); //TODO update applicant amd recipient
		friendship.setStatus(FriendshipStatus.REQUESTED);
	}

	@Override
	public void acceptFriendship() {
		friendship.setStatus(FriendshipStatus.ACCEPTED);
	}

	@Override
	public void denyFriendship() {
		friendship.setStatus(FriendshipStatus.DENIED);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Friendship> findfriendshipByStatus(FriendshipStatus status) {
		List<Friendship> result;
		Query query = entityManager.createQuery("SELECT f FROM Friendship f WHERE f.status LIKE :status ORDERED BY f.id");
		query.setParameter("status", status);
		result = query.getResultList();
		for (Friendship friendship : result) {
			entityManager.detach(friendship);
		}
		return result;
	}
	
	private void validate(Friendship friendship) {
		if (friendship.getApplicant() == null) {
			throw new IllegalArgumentException("friendship: applicant is null");
		}
		if (friendship.getRecipient() == null) {
			throw new IllegalArgumentException("friendship: recipient is null");
		}
	}
}