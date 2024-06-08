package com.app.customexception;

@SuppressWarnings("serial")
public class AuthenticationException extends RuntimeException {
	public AuthenticationException(String msg)
	{
		super(msg);
	}
}
