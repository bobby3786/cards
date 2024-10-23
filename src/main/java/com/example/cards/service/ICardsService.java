package com.example.cards.service;

import com.example.cards.dto.CardsDto;

public interface ICardsService {
	public void createCard(String mobileNumber);
	public CardsDto fetchCard(String mobileNumber);
	public boolean updateCard(CardsDto cardsDto);
	public boolean deleteCard(String mobileNumber) ;

}
