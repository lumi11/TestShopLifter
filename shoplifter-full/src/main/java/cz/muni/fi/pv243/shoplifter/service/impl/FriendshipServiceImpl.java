package cz.muni.fi.pv243.shoplifter.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import cz.muni.fi.pv243.shoplifter.dao.FriendshipDAO;
import cz.muni.fi.pv243.shoplifter.dto.DTOToEntity;
import cz.muni.fi.pv243.shoplifter.dto.EntityToDTO;
import cz.muni.fi.pv243.shoplifter.dto.FriendshipDTO;
import cz.muni.fi.pv243.shoplifter.dto.PersonDTO;
import cz.muni.fi.pv243.shoplifter.entities.Friendship;
import cz.muni.fi.pv243.shoplifter.others.FriendshipStatus;
import cz.muni.fi.pv243.shoplifter.service.FriendshipService;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class FriendshipServiceImpl implements FriendshipService {

	@EJB
	private FriendshipDAO friendshipDAO;
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createFriendship() {
		friendshipDAO.createFriendship();
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void updateFriendship(FriendshipDTO friendshipDTO) {
		friendshipDAO.updateFriendship(DTOToEntity.friendshipDTOToFriendship(friendshipDTO));
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void removeFriendship(FriendshipDTO friendshipDTO) {
		friendshipDAO.removeFriendship(DTOToEntity.friendshipDTOToFriendship(friendshipDTO));
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public FriendshipDTO getFriendship(Long id) {
		return EntityToDTO.friendshipToFriendshipDTO(friendshipDAO.getFriendship(id));
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<FriendshipDTO> getAllFriendships() {
		List<FriendshipDTO> result = new ArrayList<>();
		for (Friendship friendship : friendshipDAO.getAllFriendships()) {
			result.add(EntityToDTO.friendshipToFriendshipDTO(friendship));
		}
		return result;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void requestFriendship(PersonDTO applicant, PersonDTO recipient) {
		friendshipDAO.requestFriendship(DTOToEntity.personDTOToPerson(applicant),
				DTOToEntity.personDTOToPerson(recipient));
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void acceptFriendship() {
		friendshipDAO.acceptFriendship();
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void denyFriendship() {
		friendshipDAO.denyFriendship();
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<FriendshipDTO> findfriendshipByStatus(FriendshipStatus status) {
		List<FriendshipDTO> result = new ArrayList<>();
		for (Friendship friendship : friendshipDAO.findfriendshipByStatus(status)) {
			result.add(EntityToDTO.friendshipToFriendshipDTO(friendship));
		}
		return result;
	}
}