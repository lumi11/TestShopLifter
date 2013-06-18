package cz.muni.fi.pv243.shoplifter.dto;

import java.io.Serializable;

import cz.muni.fi.pv243.shoplifter.others.FriendshipStatus;

public class FriendshipDTO implements Serializable {

	private static final long serialVersionUID = -5145079592034026424L;
	
	private Long id;
	private FriendshipStatus status;
	private PersonDTO applicant;
	private PersonDTO recipient;
	
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
	public PersonDTO getApplicant() {
		return applicant;
	}
	public void setApplicant(PersonDTO applicant) {
		this.applicant = applicant;
	}
	public PersonDTO getRecipient() {
		return recipient;
	}
	public void setRecipient(PersonDTO recipient) {
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
		FriendshipDTO other = (FriendshipDTO) obj;
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
