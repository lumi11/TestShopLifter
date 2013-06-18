package TO;

import cz.muni.fi.pv243.shoplifter.dto.PersonDTO;
import cz.muni.fi.pv243.shoplifter.dto.ShopItemDTO;

public class DTOToTO {

	public static ProfileTO toProfile(PersonDTO personDTO) {
		ProfileTO result = new ProfileTO();
		result.setName(personDTO.getName());
		result.setSurrname(personDTO.getSurname());
		result.setCity(personDTO.getAddress().getCity());
		result.setStreet(personDTO.getAddress().getStreet());
		result.setStreetNo(String.valueOf(personDTO.getAddress().getStreetNumber()));
		result.setZipCode(String.valueOf(personDTO.getAddress().getZip()));
		return result;
	}
	
	public static ShopItemTO toShopItem(ShopItemDTO shopItemDTO) {
		ShopItemTO result = new ShopItemTO();
		result.setName(shopItemDTO.getName());
		result.setAmount(shopItemDTO.getCount());
		result.setBought(shopItemDTO.isBought());
		return result;
	}
	
	public static UserTO toUser(PersonDTO personDTO) {
		UserTO result = new UserTO();
		result.setName(personDTO.getName());
		result.setSurrname(personDTO.getSurname());
		//TODO
		return result;
	}
	
	public static SettingsTO toSettings(PersonDTO personDTO) {
		SettingsTO result  = new SettingsTO();
		result.setName(personDTO.getName());
		result.setSurrname(personDTO.getSurname());
		result.setEmail(personDTO.getEmail());
		result.setUsrname(personDTO.getLogin());
		result.setPassword(personDTO.getPassword());
		result.setCity(personDTO.getAddress().getCity());
		result.setStreet(personDTO.getAddress().getStreet());
		result.setStreetNo(String.valueOf(personDTO.getAddress().getStreetNumber()));
		result.setZipCode(String.valueOf(personDTO.getAddress().getZip()));
		return result;
	}
}
