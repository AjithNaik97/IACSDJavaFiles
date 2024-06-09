package com.app.customeexception;

@SuppressWarnings("serial")
public class CustomException extends RuntimeException{
	public CustomException(String mesg)
	{
		super(mesg);
	}

}
