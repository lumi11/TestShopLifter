package cz.muni.fi.pv243.shoplifter.dto;

import java.util.ArrayList;
import java.util.List;

import cz.muni.fi.pv243.shoplifter.entities.Address;
import cz.muni.fi.pv243.shoplifter.entities.Friendship;
import cz.muni.fi.pv243.shoplifter.entities.Person;
import cz.muni.fi.pv243.shoplifter.entities.ShopItem;
import cz.muni.fi.pv243.shoplifter.entities.ShopList;

public class DTOToEntity {

	public static Address addressDTOToAddress(AddressDTO addressDTO) {
		Address result = new Address();
		result.setCity(addressDTO.getCity());
		result.setCountry(addressDTO.getCountry());
		result.setId(addressDTO.getId());
		result.setStreet(addressDTO.getStreet());
		result.setStreetNumber(addressDTO.getStreetNumber());
		result.setZip(addressDTO.getZip());
		return result;
	}
	
	public static Friendship friendshipDTOToFriendship(FriendshipDTO friendshipDTO) {
		Friendship result = new Friendship();
		result.setApplicant(personDTOToPerson(friendshipDTO.getApplicant()));
		result.setId(friendshipDTO.getId());
		result.setRecipient(personDTOToPerson(friendshipDTO.getRecipient()));
		result.setStatus(friendshipDTO.getStatus());
		return result;
	}
	
	public static Person personDTOToPerson(PersonDTO personDTO) {
		Person result = new Person();
		result.setAddress(addressDTOToAddress(personDTO.getAddress()));
		result.setId(personDTO.getId());
		result.setLogin(personDTO.getLogin());
		result.setEmail(personDTO.getEmail());
		result.setName(personDTO.getName());
		result.setPassword(personDTO.getPassword());
		result.setPhone(personDTO.getPhone());
		result.setSurname(personDTO.getSurname());
		List<Person> tempList = new ArrayList<>();
		for (PersonDTO dto : personDTO.getFriends()) {
			tempList.add(personDTOToPerson(dto));
		}
		result.setFriends(tempList);
		List<Person> tempList1 = new ArrayList<>();
		for (PersonDTO dto : personDTO.getMyRequests()) {
			tempList1.add(personDTOToPerson(dto));
		}
		result.setMyRequests(tempList1);
		List<Person> tempList2 = new ArrayList<>();
		for (PersonDTO dto : personDTO.getRequestForMe()) {
			tempList2.add(personDTOToPerson(dto));
		}
		result.setRequestForMe(tempList2);
		return result;
	}
	
	public static ShopItem shopItemDTOToShopItem(ShopItemDTO shopItemDTO) {
		ShopItem result = new ShopItem();
		result.setBought(shopItemDTO.isBought());
		result.setCount(shopItemDTO.getCount());
		result.setId(shopItemDTO.getId());
		result.setName(shopItemDTO.getName());
		return result;
	}
	
	public static ShopList shopListDTOToShopList(ShopListDTO shopListDTO) {
		ShopList result = new ShopList();
		result.setApplicant(personDTOToPerson(shopListDTO.getApplicant()));
		result.setBuyer(personDTOToPerson(shopListDTO.getBuyer()));
		result.setDeadlineDate(shopListDTO.getDeadlineDate());
		result.setDeadlineTime(shopListDTO.getDeadlineTime());
		result.setId(shopListDTO.getId());
		result.setReward(shopListDTO.getReward());
		result.setStatus(shopListDTO.getStatus());
		List<ShopItem> tempList = new ArrayList<>();
		for (ShopItemDTO shopItemDTO : shopListDTO.getGoods()) {
			tempList.add(shopItemDTOToShopItem(shopItemDTO));
		}
		result.setGoods(tempList);
		return result;
	}
}
