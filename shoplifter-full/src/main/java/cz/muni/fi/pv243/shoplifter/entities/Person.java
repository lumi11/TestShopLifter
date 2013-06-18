package cz.muni.fi.pv243.shoplifter.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Entity implementation class for Entity: Person
 *
 */
/**
 * @author jajaja
 *
 */
@Entity

public class Person implements Serializable {
	private static final long serialVersionUID = -319310692026360485L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Pattern(regexp = "[A-Za-z]+", message = "must contain only letters")
	private String name;
	
	@NotNull
	@Pattern(regexp = "[A-Za-z]+", message = "must contain only letters")
	private String surname;
	
	private String phone;
	
	@Column(unique=true)
	@NotNull
	@NotEmpty
	@Pattern(regexp = "[0-9A-Za-z]+", message = "must contain only letters or numbers")
	private String login;
	
	@NotNull
	@NotEmpty
	@Size(min=8)
	private String password;
	
	@NotNull
	@Valid
	@OneToOne(targetEntity=Address.class,cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Address address;
	
	@Email
	@NotNull
	@NotEmpty
	private String email;
	
	@OneToMany(targetEntity=Person.class, cascade=CascadeType.ALL)
	private List<Person> friends;
	
	@OneToMany(targetEntity=Person.class, cascade=CascadeType.ALL)
	private List<Person> myRequests; //TODO rename
	
	@OneToMany(targetEntity=Person.class, cascade=CascadeType.ALL)
	private List<Person> requestForMe; //TODO rename
	
	
	public Person() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}   
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}   
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public List<Person> getFriends() {
		return friends;
	}
	
	public void setFriends(List<Person> friends) {
		this.friends = friends;
	}
	
	public List<Person> getMyRequests() {
		return myRequests;
	}
	
	public void setMyRequests(List<Person> myRequest) {
		this.myRequests = myRequest;
	}
	
	public List<Person> getRequestForMe() {
		return requestForMe;
	}
	
	public void setRequestForMe(List<Person> requestForMe) {
		this.requestForMe = requestForMe;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((friends == null) ? 0 : friends.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result
				+ ((myRequests == null) ? 0 : myRequests.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result
				+ ((requestForMe == null) ? 0 : requestForMe.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
		Person other = (Person) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (friends == null) {
			if (other.friends != null)
				return false;
		} else if (!friends.equals(other.friends))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (myRequests == null) {
			if (other.myRequests != null)
				return false;
		} else if (!myRequests.equals(other.myRequests))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (requestForMe == null) {
			if (other.requestForMe != null)
				return false;
		} else if (!requestForMe.equals(other.requestForMe))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", surname=" + surname
				+ ", phone=" + phone + ", login=" + login + ", password="
				+ password + ", address=" + address + ", email=" + email
				+ ", friends=" + friends + ", myRequests=" + myRequests
				+ ", requestForMe=" + requestForMe + "]";
	}
}