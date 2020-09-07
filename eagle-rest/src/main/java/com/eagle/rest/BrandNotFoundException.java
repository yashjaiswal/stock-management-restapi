package com.eagle.rest;

public class BrandNotFoundException extends RuntimeException{

	public BrandNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public BrandNotFoundException(String message) {
		super(message);
	}

	public BrandNotFoundException(Throwable cause) {
		super(cause);
	}
	

}
