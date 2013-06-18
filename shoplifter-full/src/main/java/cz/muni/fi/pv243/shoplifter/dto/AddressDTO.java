package cz.muni.fi.pv243.shoplifter.dto;

import java.io.Serializable;

import cz.muni.fi.pv243.shoplifter.others.Country;

public class AddressDTO implements Serializable {

	private static final long serialVersionUID = 3222954128268157913L;

	private Long id;
	private String city;
	private String street;
	private Integer streetNumber;
	private Integer zip;
	private Country country;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}  
	
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}   
	
	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	
	public int getStreetNumber() {
		return this.streetNumber;
	}

	public void setStreetNumber(Integer streetNumber) {
		this.streetNumber = streetNumber;
	}
	
	public int getZip() {
		return this.zip;
	}

	public void setZip(Integer zip) {
		this.zip = zip;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + streetNumber;
		result = prime * result + zip;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddressDTO other = (AddressDTO) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country != other.country)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		if (streetNumber != other.streetNumber)
			return false;
		if (zip != other.zip)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", city=" + city + ", street=" + street
				+ ", streetNumber=" + streetNumber + ", zip=" + zip
				+ ", country=" + country + "]";
	}
}