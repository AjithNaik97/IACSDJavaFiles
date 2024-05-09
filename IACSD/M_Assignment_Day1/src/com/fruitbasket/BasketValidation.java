package com.fruitbasket;

public class BasketValidation {
	public static void checkBasket(int i,int size,int c) throws CustomExceptionClass
	{
		if(i>=size&&c<=3)
		{
			throw new CustomExceptionClass("No more Fruits can be added. Basket Full!!!");
		}
	}

}
