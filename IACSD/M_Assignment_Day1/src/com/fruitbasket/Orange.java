package com.fruitbasket;

public class Orange extends Fruit {
	public Orange(String name,String color,double weight)
	{
		super(name,color,weight);
	}
	
	public String taste()
	{
		return "Sour";
	}
	
	public void juice()
	{
		System.out.println(this.name+" "+this.weight+" juice is being extracted.");
	}
	
	@Override
	public String toString()
	{
		return super.toString();
	}
}
