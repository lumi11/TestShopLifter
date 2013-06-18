package TO;

import cz.muni.fi.pv243.shoplifter.dto.AddressDTO;
import cz.muni.fi.pv243.shoplifter.dto.PersonDTO;
import cz.muni.fi.pv243.shoplifter.dto.ShopItemDTO;

public class TOToDTO{

	public static PersonDTO fromProfile(ProfileTO profileTO) {
		PersonDTO result = new PersonDTO();
		AddressDTO address = new AddressDTO();
		address.setCity(profileTO.getCity());
		address.setStreet(profileTO.getStreet());
		address.setStreetNumber(Integer.valueOf(profileTO.getStreetNo()));
		result.setName(profileTO.getName());
		result.setSurname(profileTO.getSurrname());
		result.setAddress(address);
		return result;
	}
	
	public static ShopItemDTO fromShopItem(ShopItemTO shopItemTO) {
		ShopItemDTO result = new ShopItemDTO();
		result.setName(shopItemTO.getName());
		result.setCount(shopItemTO.getAmount());
		result.setBought(shopItemTO.getBought());
		return result;
	}
	
	public static PersonDTO fromSettings(SettingsTO settingsTO) {
		PersonDTO result = new PersonDTO();
		AddressDTO address = new AddressDTO();
		address.setCity(settingsTO.getCity());
		address.setStreet(settingsTO.getStreet());
		address.setStreetNumber(Integer.valueOf(settingsTO.getStreetNo()));
		result.setName(settingsTO.getName());
		result.setSurname(settingsTO.getSurrname());
		result.setAddress(address);
		result.setLogin(settingsTO.getUsrname());
		result.setEmail(settingsTO.getEmail());
		result.setPassword(settingsTO.getPassword());
		return result;
	}
}
