package com.fruitbasket;

@SuppressWarnings("serial")
public class CustomExceptionClass extends Exception {
	public CustomExceptionClass(String mesg) {
		super(mesg);
	}
}
