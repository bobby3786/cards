package com.example.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
@Schema(name = "Cards",description = "Schema to hold Card information")
public class CardsDto {
	
	@NotEmpty(message = "Mobile Number can not be a null or empty")
	 @Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile number must be a 10 digits")
	 @Schema(description = "Mobile number of the Customer",example = "9182291822")
	private String mobileNumber;
	
	
	@NotEmpty(message = "Card Number can not be a null or empty")
	 @Pattern(regexp = "(^$|[0-9]{12})",message = "Mobile number must be a 12 digits")
	 @Schema(description = "Card number of the Customer",example = "548732457654")
	@Column(name = "card_number")
	private String cardNumber;

	
	@NotEmpty(message = "Card Type can not be null or empty")
	 @Schema(description = "Type  of the Card",example = "Credit card")
	@Column(name = "card_type")
	private String cardType;
	
	
	@Positive(message = "Total card limit  should be greater than zero")
	 @Schema(description = "Total  amount limit available against a card", example = "100000")
	@Column(name = "total_limit")
	private int totalLimit;
	
	
	@PositiveOrZero(message = "Total  amount used should be equal or greater than zero")
	 @Schema(description = "Total used amount", example = "1000")
	@Column(name = "amount_used")
	private int amountUsed;
	
	@PositiveOrZero(message = "Available amount  should be equal or greater than zero")
	 @Schema(description = "Available  amount ", example = "1000")
	@Column(name = "available_amount")
	private int availableAmount;

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

	@Override
	public String toString() {
		return "CardsDto [mobileNumber=" + mobileNumber + ", cardNumber=" + cardNumber + ", cardType=" + cardType
				+ ", totalLimit=" + totalLimit + ", amountUsed=" + amountUsed + ", availableAmount=" + availableAmount
				+ "]";
	}

	
	

}
