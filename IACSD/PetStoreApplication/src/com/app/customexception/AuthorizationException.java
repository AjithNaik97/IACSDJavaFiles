package com.app.customexception;

@SuppressWarnings("serial")
public class AuthorizationException extends RuntimeException {
	public AuthorizationException(String msg)
	{
		super(msg);
	}
}
