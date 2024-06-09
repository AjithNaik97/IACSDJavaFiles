package com.app.customexception;

@SuppressWarnings("serial")
public class CustomException extends RuntimeException {
	public CustomException(String msg)
	{
		super(msg);
	}
}
