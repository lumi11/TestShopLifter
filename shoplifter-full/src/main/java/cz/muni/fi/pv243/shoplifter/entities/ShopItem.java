package cz.muni.fi.pv243.shoplifter.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Entity implementation class for Entity: ShopItem
 *
 */
@Entity

public class ShopItem implements Serializable {

	
	private static final long serialVersionUID = -4544585078777685923L;
   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String name;
	
	@NotNull
	@Min(1)
	private Integer count;
	
	@NotNull
	private Boolean isBought;

	public ShopItem() {
		super();
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public int getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}   
	public boolean isBought() {
		return this.isBought;
	}

	public void setBought(Boolean isBought) {
		this.isBought = isBought;
	}
	@Override
	public String toString() {
		return "ShopItem [id=" + id + ", name=" + name + ", count=" + count
				+ ", isBought=" + isBought + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + count;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isBought ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		ShopItem other = (ShopItem) obj;
		if (count != other.count)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isBought != other.isBought)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
   
}
