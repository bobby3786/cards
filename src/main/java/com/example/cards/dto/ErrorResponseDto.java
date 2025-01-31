package com.example.cards.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import io.swagger.v3.oas.annotations.media.Schema;

public class ErrorResponseDto {
	
	@Schema(
         description="API path invoked by client"			
	)
	private String apiPath;
	
	@Schema(
			description="Error code representing the error happened"
			)
	
	private HttpStatus errorCode;
	
	@Schema(
	         description="Error message representing the error happened"			
		)
	private String errorMessage;
	
	@Schema(
	         description="Error Time Representing the Error happened time"			
		)
	private LocalDateTime errorTime;

	public String getApiPath() {
		return apiPath;
	}

	public void setApiPath(String apiPath) {
		this.apiPath = apiPath;
	}

	public HttpStatus getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(HttpStatus errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public LocalDateTime getErrorTime() {
		return errorTime;
	}

	public void setErrorTime(LocalDateTime errorTime) {
		this.errorTime = errorTime;
	}

	public ErrorResponseDto(String apiPath, HttpStatus errorCode, String errorMessage, LocalDateTime errorTime) {
		super();
		this.apiPath = apiPath;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.errorTime = errorTime;
	}
	
	

}
