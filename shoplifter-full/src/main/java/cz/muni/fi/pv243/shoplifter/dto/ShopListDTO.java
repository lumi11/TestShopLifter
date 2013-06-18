package cz.muni.fi.pv243.shoplifter.dto;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

import cz.muni.fi.pv243.shoplifter.others.ShopListStatus;

public class ShopListDTO implements Serializable {

	private static final long serialVersionUID = -3201283267977875526L;
	
	private Long id;
	private List<ShopItemDTO> goods;
	private ShopListStatus status;
	private Date deadlineDate;
	private Time deadlineTime;
	private PersonDTO applicant;
	private PersonDTO buyer;
	private String reward;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getReward() {
		return this.reward;
	}

	public void setReward(String reward) {
		this.reward = reward;
	}
	public List<ShopItemDTO> getGoods() {
		return goods;
	}
	public void setGoods(List<ShopItemDTO> goods) {
		this.goods = goods;
	}
	public ShopListStatus getStatus() {
		return status;
	}
	public void setStatus(ShopListStatus status) {
		this.status = status;
	}
	public Date getDeadlineDate() {
		return deadlineDate;
	}
	public void setDeadlineDate(Date deadlineDate) {
		this.deadlineDate = deadlineDate;
	}
	public Time getDeadlineTime() {
		return deadlineTime;
	}
	public void setDeadlineTime(Time deadlineTime) {
		this.deadlineTime = deadlineTime;
	}
	public PersonDTO getBuyer() {
		return buyer;
	}
	public void setBuyer(PersonDTO buyer) {
		this.buyer = buyer;
	}
	public PersonDTO getApplicant() {
		return applicant;
	}
	public void setApplicant(PersonDTO applicant) {
		this.applicant = applicant;
	}
	@Override
	public String toString() {
		return "ShopList [id=" + id + ", goods=" + goods + ", status=" + status
				+ ", deadlineDate=" + deadlineDate + ", deadlineTime="
				+ deadlineTime + ", applicant=" + applicant + ", buyer="
				+ buyer + ", reward=" + reward + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((applicant == null) ? 0 : applicant.hashCode());
		result = prime * result + ((buyer == null) ? 0 : buyer.hashCode());
		result = prime * result
				+ ((deadlineDate == null) ? 0 : deadlineDate.hashCode());
		result = prime * result
				+ ((deadlineTime == null) ? 0 : deadlineTime.hashCode());
		result = prime * result + ((goods == null) ? 0 : goods.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((reward == null) ? 0 : reward.hashCode());
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
		ShopListDTO other = (ShopListDTO) obj;
		if (applicant == null) {
			if (other.applicant != null)
				return false;
		} else if (!applicant.equals(other.applicant))
			return false;
		if (buyer == null) {
			if (other.buyer != null)
				return false;
		} else if (!buyer.equals(other.buyer))
			return false;
		if (deadlineDate == null) {
			if (other.deadlineDate != null)
				return false;
		} else if (!deadlineDate.equals(other.deadlineDate))
			return false;
		if (deadlineTime == null) {
			if (other.deadlineTime != null)
				return false;
		} else if (!deadlineTime.equals(other.deadlineTime))
			return false;
		if (goods == null) {
			if (other.goods != null)
				return false;
		} else if (!goods.equals(other.goods))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (reward == null) {
			if (other.reward != null)
				return false;
		} else if (!reward.equals(other.reward))
			return false;
		if (status != other.status)
			return false;
		return true;
	}
}