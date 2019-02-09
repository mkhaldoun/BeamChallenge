package com.beamchallenge.exceptions;

import javax.ws.rs.WebApplicationException;

public class ApplicationException extends WebApplicationException   {

	private static final long serialVersionUID = -7845776182971896382L;

	private String errorMessage;
	private int errorCode;

	public ApplicationException(String errorMessage, int errorCode) {
		super();
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
}
