package com.app.exceptions;


@SuppressWarnings("serial")
public class CustomException extends RuntimeException{
	public CustomException(String mesg) {
		super(mesg);
	}
}
