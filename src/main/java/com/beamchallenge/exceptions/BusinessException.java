package com.beamchallenge.exceptions;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private ErrorObj errorObj;
	
	public BusinessException(ErrorObj errorObj){
		super();
		this.errorObj = errorObj;
	}

	public ErrorObj getErrorObj() {
		return errorObj;
	}
	
}
