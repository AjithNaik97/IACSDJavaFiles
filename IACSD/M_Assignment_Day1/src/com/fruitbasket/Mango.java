package com.fruitbasket;

public class Mango extends Fruit{
	public Mango(String name,String color,double weight)
	{
		super(name,color,weight);
	}
	
	public String taste()
	{
		return "Sweet.";
	}
	
	public void pulp()
	{
		System.out.println(this.name+" "+this.color+" pulp being created.");
	}
	
	@Override
	public String toString()
	{
		return super.toString();
	}

}
