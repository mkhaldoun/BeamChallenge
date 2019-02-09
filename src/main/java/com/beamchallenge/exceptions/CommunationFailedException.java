package com.beamchallenge.exceptions;

public class CommunationFailedException extends Exception {

	private static final long serialVersionUID = -5406787577427691670L;
	
	private ErrorObj errorObj;
	
	public CommunationFailedException(ErrorObj errorObj){
		super();
		this.errorObj = errorObj;
	}

	public ErrorObj getErrorObj() {
		return errorObj;
	}

	
}
