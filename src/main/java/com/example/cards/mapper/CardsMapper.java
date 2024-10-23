package com.example.cards.mapper;

import com.example.cards.dto.CardsDto;
import com.example.cards.entity.Cards;

public class CardsMapper {
	
	public static CardsDto mapToCardsDto(Cards cards,CardsDto cardsDto) {
		cardsDto.setMobileNumber(cards.getMobileNumber());
		cardsDto.setAmountUsed(cards.getAmountUsed());
		cardsDto.setAvailableAmount(cards.getAvailableAmount());
		cardsDto.setCardNumber(cards.getCardNumber());
		cardsDto.setCardType(cards.getCardType());
		cardsDto.setTotalLimit(cards.getTotalLimit());
		
		return cardsDto;
	}

	public static Cards mapToCards(CardsDto cardsDto,Cards cards) {
		cards.setMobileNumber(cardsDto.getMobileNumber());
		cards.setAmountUsed(cardsDto.getAmountUsed());
		cards.setAvailableAmount(cardsDto.getAvailableAmount());
		cards.setCardNumber(cardsDto.getCardNumber());
		cards.setCardType(cardsDto.getCardType());
		cards.setTotalLimit(cardsDto.getTotalLimit());
		
		return cards;
	}

}
