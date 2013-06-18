package cz.muni.fi.pv243.shoplifter.dto;

import java.util.ArrayList;
import java.util.List;

import cz.muni.fi.pv243.shoplifter.entities.Address;
import cz.muni.fi.pv243.shoplifter.entities.Friendship;
import cz.muni.fi.pv243.shoplifter.entities.Person;
import cz.muni.fi.pv243.shoplifter.entities.ShopItem;
import cz.muni.fi.pv243.shoplifter.entities.ShopList;

public class EntityToDTO {

	public static AddressDTO addressToAddressDTO(Address address) {
		AddressDTO result = new AddressDTO();
		result.setCity(address.getCity());
		result.setCountry(address.getCountry());
		result.setId(address.getId());
		result.setStreet(address.getStreet());
		result.setStreetNumber(address.getStreetNumber());
		result.setZip(address.getZip());
		return result;
	}
	
	public static FriendshipDTO friendshipToFriendshipDTO(Friendship friendship) {
		FriendshipDTO result = new FriendshipDTO();
		result.setId(friendship.getId());
		result.setRecipient(personToPersonDTO(friendship.getRecipient()));
		result.setApplicant(personToPersonDTO(friendship.getApplicant()));
		result.setStatus(friendship.getStatus());
		return result;	
	}
	
	public static PersonDTO personToPersonDTO(Person person) {
		PersonDTO result = new PersonDTO();
		result.setId(person.getId());
		result.setAddress(addressToAddressDTO(person.getAddress()));
		result.setLogin(person.getLogin());
		result.setEmail(person.getEmail());
		result.setName(person.getName());
		result.setPassword(person.getPassword());
		result.setPhone(person.getPhone());
		result.setSurname(person.getSurname());
		List<PersonDTO> templist = new ArrayList<>();
		for (Person p : person.getFriends()) {
			templist.add(personToPersonDTO(p));
		}
		result.setFriends(templist);
		List<PersonDTO> templist1 = new ArrayList<>();
		for (Person p : person.getMyRequests()) {
			templist1.add(personToPersonDTO(p));
		}
		result.setMyRequests(templist1);
		List<PersonDTO> templist2 = new ArrayList<>();
		for (Person p : person.getRequestForMe()) {
			templist2.add(personToPersonDTO(p));
		}
		result.setRequestForMe(templist2);
		return result;
	}
	
	public static ShopItemDTO shopItemToShopItemDTO(ShopItem shopItem) {
		ShopItemDTO result = new ShopItemDTO();
		result.setId(shopItem.getId());
		result.setName(shopItem.getName());
		result.setCount(shopItem.getCount());
		result.setBought(shopItem.isBought());
		return result;
	}
	
	public static ShopListDTO shopListToShopListDTO(ShopList shopList) {
		ShopListDTO result = new ShopListDTO();
		result.setApplicant(personToPersonDTO(shopList.getApplicant()));
		result.setBuyer(personToPersonDTO(shopList.getBuyer()));
		result.setDeadlineDate(shopList.getDeadlineDate());
		result.setDeadlineTime(shopList.getDeadlineTime());
		result.setId(shopList.getId());
		result.setReward(shopList.getReward());
		result.setStatus(shopList.getStatus());
		List<ShopItemDTO> tempList = new ArrayList<>();
		for (ShopItem shopItem : shopList.getGoods()) {
			tempList.add(shopItemToShopItemDTO(shopItem));
		}
		result.setGoods(tempList);
		return result;
	}
}