package com.app.customexception;

@SuppressWarnings("serial")
public class OutOfStockException extends RuntimeException {
	public OutOfStockException(String msg)
	{
		super(msg);
	}
}
