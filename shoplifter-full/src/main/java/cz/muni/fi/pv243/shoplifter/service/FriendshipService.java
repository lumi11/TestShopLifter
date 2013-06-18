package cz.muni.fi.pv243.shoplifter.service;

import java.util.List;

import javax.ejb.Local;

import cz.muni.fi.pv243.shoplifter.dto.FriendshipDTO;
import cz.muni.fi.pv243.shoplifter.dto.PersonDTO;
import cz.muni.fi.pv243.shoplifter.others.FriendshipStatus;

@Local
public interface FriendshipService {

	void createFriendship(); //admin
	void updateFriendship(FriendshipDTO friendship); //admin
	void removeFriendship(FriendshipDTO friendship);
	FriendshipDTO getFriendship(Long id);
	List<FriendshipDTO> getAllFriendships();
	List<FriendshipDTO> findfriendshipByStatus(FriendshipStatus status); //status  TODO mutualFriends
	void requestFriendship(PersonDTO applicant, PersonDTO recipient);
	void acceptFriendship();
	void denyFriendship();
}
