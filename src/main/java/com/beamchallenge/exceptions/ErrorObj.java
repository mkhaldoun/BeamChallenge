package com.beamchallenge.exceptions;

public class ErrorObj {

	private String errorMessage;
	private int errorCode;
	
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
	@Override
	public String toString() {
		return "ErrorObj [errorMessage=" + errorMessage + ", errorCode=" + errorCode + "]";
	}
	
	
}
