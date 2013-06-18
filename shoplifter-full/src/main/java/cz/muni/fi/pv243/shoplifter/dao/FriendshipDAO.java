package cz.muni.fi.pv243.shoplifter.dao;

import java.util.List;

import javax.ejb.Local;

import cz.muni.fi.pv243.shoplifter.entities.Friendship;
import cz.muni.fi.pv243.shoplifter.entities.Person;
import cz.muni.fi.pv243.shoplifter.others.FriendshipStatus;

@Local
public interface FriendshipDAO {

	void createFriendship(); //admin
	void updateFriendship(Friendship friendship); //admin
	void removeFriendship(Friendship friendship);
	Friendship getFriendship(Long id);
	List<Friendship> getAllFriendships();
	List<Friendship> findfriendshipByStatus(FriendshipStatus status); //status mutualFriends
	void requestFriendship(Person applicant, Person recipient);
	void acceptFriendship();
	void denyFriendship();
}
