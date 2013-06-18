package cz.muni.fi.pv243.shoplifter.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import cz.muni.fi.pv243.shoplifter.others.FriendshipStatus;

/**
 * Entity implementation class for Entity: Friendship
 *
 */
@Entity

public class Friendship implements Serializable {

	private static final long serialVersionUID = 5652672120742088637L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private FriendshipStatus status;
	
	@NotNull
	@Valid
	private Person applicant;
	
	@NotNull
	@Valid
	private Person recipient;
	
	public Friendship() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public FriendshipStatus getStatus() {
		return status;
	}
	public void setStatus(FriendshipStatus status) {
		this.status = status;
	}
	public Person getApplicant() {
		return applicant;
	}
	public void setApplicant(Person applicant) {
		this.applicant = applicant;
	}
	public Person getRecipient() {
		return recipient;
	}
	public void setRecipient(Person recipient) {
		this.recipient = recipient;
	}
	@Override
	public String toString() {
		return "Friendship [id=" + id + ", status=" + status + ", applicant="
				+ applicant + ", recipient=" + recipient + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((applicant == null) ? 0 : applicant.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((recipient == null) ? 0 : recipient.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Friendship other = (Friendship) obj;
		if (applicant == null) {
			if (other.applicant != null)
				return false;
		} else if (!applicant.equals(other.applicant))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (recipient == null) {
			if (other.recipient != null)
				return false;
		} else if (!recipient.equals(other.recipient))
			return false;
		if (status != other.status)
			return false;
		return true;
	}

}
