package com.fruitbasket;

public class Apple extends Fruit{
	
	public Apple(String name,String color,double weight) {
		super(name,color,weight);
	}

	public String taste()
	{
		return "Sweet and sour";
	}
	
	public void jam()
	{
		System.out.println(this.name+" Apple jam is being made.");
	}
	
	@Override
	public String toString()
	{
		return super.toString();
	}
}
