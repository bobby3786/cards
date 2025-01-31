package com.example.cards.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "cards")
public class Cards extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cardId;
	
	@Column(name = "mobile_number")
	private String mobileNumber;
	
	@Column(name = "card_number")
	private String cardNumber;

	@Column(name = "card_type")
	private String cardType;
	
	@Column(name = "total_limit")
	private int totalLimit;
	
	@Column(name = "amount_used")
	private int amountUsed;
	
	@Column(name = "available_amount")
	private int availableAmount;

	public Long getCardId() {
		return cardId;
	}

	public void setCardId(Long cardId) {
		this.cardId = cardId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public int getTotalLimit() {
		return totalLimit;
	}

	public void setTotalLimit(int totalLimit) {
		this.totalLimit = totalLimit;
	}

	public int getAmountUsed() {
		return amountUsed;
	}

	public void setAmountUsed(int amountUsed) {
		this.amountUsed = amountUsed;
	}

	public int getAvailableAmount() {
		return availableAmount;
	}

	public void setAvailableAmount(int availableAmount) {
		this.availableAmount = availableAmount;
	}

	public Cards(Long cardId, String mobileNumber, String cardNumber, String cardType, int totalLimit, int amountUsed,
			int availableAmount) {
		super();
		this.cardId = cardId;
		this.mobileNumber = mobileNumber;
		this.cardNumber = cardNumber;
		this.cardType = cardType;
		this.totalLimit = totalLimit;
		this.amountUsed = amountUsed;
		this.availableAmount = availableAmount;
	}

	
	
	public Cards() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Cards [cardId=" + cardId + ", mobileNumber=" + mobileNumber + ", cardNumber=" + cardNumber
				+ ", cardType=" + cardType + ", totalLimit=" + totalLimit + ", amountUsed=" + amountUsed
				+ ", availableAmount=" + availableAmount + "]";
	}

	
}
