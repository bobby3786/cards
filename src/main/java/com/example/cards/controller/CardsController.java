package com.example.cards.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cards.constants.CardsConstants;
import com.example.cards.dto.CardsContactInfoDto;
import com.example.cards.dto.CardsDto;
import com.example.cards.dto.ErrorResponseDto;
import com.example.cards.dto.ResponseDto;
import com.example.cards.service.ICardsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

@RestController
@Tag(name = "CRUD  REST APIs  for Loans in EazyBank",
   description = "CRUD REST APIs on eazy bank to CREATE,UPDATE, FETCH AND DELETE loan details"
		)
@RequestMapping(path = "/api")
@Validated
public class CardsController {
	
	@Autowired
	private ICardsService iCardsService;
	
	@Autowired
	private CardsContactInfoDto cardsContactInfoDto;
	
	@Operation(
			summary = "Create Card REST API"
			,description = "Rest Api to create new Card inside EazyBank"
			)
	@ApiResponses({
			@ApiResponse(
					responseCode = "201",
					description = "HTTP Status CREATED"
					),
			@ApiResponse(
					responseCode = "500",
			         description = "HTTP Status Internal Server Error",
			 content = @Content(
					 schema = @Schema(implementation = ErrorResponseDto.class)
					 )
	)}
			
			)
	@PostMapping("/create")
	public ResponseEntity<ResponseDto>  createCard(@Valid @RequestParam
			@Pattern(regexp = "(^$|[0-9]{10})",message = "MobileNumber must be 10 digits")
			String mobileNumber){
		iCardsService.createCard(mobileNumber);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(new ResponseDto(CardsConstants.STATUS_201,CardsConstants.MESSAGE_201));
	}
	
	@Operation(
			summary = "FETCH Loan REST API"
			,description = "Rest Api to fetch new loan inside EazyBank"
			)
	@ApiResponses({
			@ApiResponse(
					responseCode = "201",
					description = "HTTP Status CREATED"
					),
			@ApiResponse(
					responseCode = "500",
			         description = "HTTP Status Internal Server Error",
			 content = @Content(
					 schema = @Schema(implementation = ErrorResponseDto.class)
					 )
	)}
			
			)
	
	@GetMapping("/fetch")
	public ResponseEntity<CardsDto> fetchCardDetails(@Valid @RequestParam
			@Pattern(regexp = "(^$|[0-9]{10})",message = "MobileNumber must be 10 digits")
	String mobileNumber
			){
		CardsDto cardsDto = iCardsService.fetchCard(mobileNumber);
		return ResponseEntity.status(HttpStatus.OK).body(cardsDto);
	}
	
	@Operation(
			summary = "Create Card REST API"
			,description = "Rest Api to create new Card inside EazyBank"
			)
	@ApiResponses({
			@ApiResponse(
					responseCode = "201",
					description = "Http Status created"
					),
			@ApiResponse(
					responseCode = "417",
					description = "Expectation Failed"
					),
			@ApiResponse(
					responseCode = "500",
			         description = "HTTP Status Internal Server Error",
			 content = @Content(
					 schema = @Schema(implementation = ErrorResponseDto.class)
					 )
	)}
			
			)
	@PutMapping("/update")
	public ResponseEntity<ResponseDto> updateCardDetails(@Valid@RequestBody CardsDto cardsDto){
		boolean isUpdated = iCardsService.updateCard(cardsDto);
		if(isUpdated) {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new ResponseDto(CardsConstants.MESSAGE_200,CardsConstants.MESSAGE_200));
		}else {
			return ResponseEntity
					.status(HttpStatus.EXPECTATION_FAILED)
					.body(new ResponseDto(CardsConstants.STATUS_417,CardsConstants.MESSAGE_417_UPDATE));
					
		}
	}
	@Operation(
			summary = "delete Card REST API"
			,description = "Rest Api to delete Card details based on a mobileNumber"
			)
	@ApiResponses({
			@ApiResponse(
					responseCode = "201",
					description = "Http Status created"
					),
			@ApiResponse(
					responseCode = "417",
					description = "Expectation Failed"
					),
			@ApiResponse(
					responseCode = "500",
			         description = "HTTP Status Internal Server Error",
			 content = @Content(
					 schema = @Schema(implementation = ErrorResponseDto.class)
					 )
	)}
			
			)
	@DeleteMapping("/delete")
	public ResponseEntity<ResponseDto> deleteCardsDetails(@Valid @RequestParam
			@Pattern(regexp = "(^$|[0-9]{10})",message = "MobileNumber must be 10 digits")
                         String mobileNumber
			                          ){
		boolean isDeleted = iCardsService.deleteCard(mobileNumber);
		if(isDeleted) {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new ResponseDto(CardsConstants.MESSAGE_200,CardsConstants.MESSAGE_200));
		}else {
			return ResponseEntity
					.status(HttpStatus.EXPECTATION_FAILED)
					.body(new ResponseDto(CardsConstants.STATUS_417,CardsConstants.MESSAGE_417_DELETE));
					
		}
		
	}
	
	@Operation(
			summary = "FETCH cards REST API"
			,description = "Rest Api to fetch new cards inside EazyBank"
			)
	@ApiResponses({
			@ApiResponse(
					responseCode = "201",
					description = "HTTP Status CREATED"
					),
			@ApiResponse(
					responseCode = "500",
			         description = "HTTP Status Internal Server Error",
			 content = @Content(
					 schema = @Schema(implementation = ErrorResponseDto.class)
					 )
	)}
			
			)
	
	@GetMapping("/contact-info")
	public ResponseEntity<CardsContactInfoDto> getContactInfo(){
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(cardsContactInfoDto);
	}

}
