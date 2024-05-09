package com.fruitbasket;

import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
	
		/*
		Apple a=new Apple("Kashmiri","Red",2.35);
		System.out.println(a+a.taste()); //
		a.jam();
		
		Fruit f=new Apple("Big","Green",5.2);
		System.out.println(f.taste());  //upcasting Child class Apple inherits the properties of Base class Fruit.
		
		((Apple)f).jam(); //Downcasting as Fruit cannot inherits properties of Apple. So forcefully downcast.
		*/
		
		
		/*
		f[0]=new Apple("Kashmiri Apple","Red",5.3);
		f[1]=new Orange("Tangerine","Orange",3.5);
		f[2]=new Mango("Hafoos Mango","Yellow",1.6);
		
		for(int i=0;i<5;i++)
		{
			if(f[i] instanceof Apple)
			{
				System.out.println(f[i]);
				System.out.println(f[i].taste());
				((Apple)f[i]).jam();
			}
			
			if(f[i] instanceof Orange)
			{
				System.out.println(f[i]);
				System.out.println(f[i].taste());
				((Orange)f[i]).juice();
			}
			
			if(f[i] instanceof Mango)
			{
				System.out.println(f[i]);
				System.out.println(f[i].taste());
				((Mango)f[i]).pulp();
			}
			*/
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the size of the Basket: ");
		int size = in.nextInt();
		Fruit f[] = new Fruit[size];
		int c;
		int i = 0;
		do
		{
			System.out.println("---Menu---");
			System.out.println("1.Add Apple 2.Add Orange 3.Add Mango 4.Display all Fruit Names 5.Display all details of Fruit  6.Mark a fruit Stale 7.Mark all sour fruit stale 8.Display Fruit Speciality 9.Exit");
			try {
			c = in.nextInt();
				BasketValidation.checkBasket(i,size,c);
			
			switch (c)
			{
			case 1:
				System.out.println("Enter name of Apple");
				String aname = in.next();
				System.out.println("Enter color of Apple");
				String acolor = in.next();
				System.out.println("Enter weight of Apple");
				double aweight = in.nextDouble();
				System.out.println("Adding this Apple to basket.");
				f[i] = new Apple(aname, acolor, aweight);
				System.out.println("Successfully added.");
				i++;
				break;

			case 2:
				System.out.println("Enter name of Orange");
				String oname = in.next();
				System.out.println("Enter color of Orange");
				String ocolor = in.next();
				System.out.println("Enter weight of Orange");
				double oweight = in.nextDouble();
				System.out.println("Adding this Orange to basket.");
				f[i] = new Orange(oname, ocolor, oweight);
				System.out.println("Successfully added.");
				i++;
				break;

			case 3:
				System.out.println("Enter name of Mango");
				String mname = in.next();
				System.out.println("Enter color of Mango");
				String mcolor = in.next();
				System.out.println("Enter weight of Mango");
				double mweight = in.nextDouble();
				System.out.println("Adding this Mango to basket.");
				f[i] = new Mango(mname, mcolor, mweight);
				System.out.println("Successfully added.");
				i++;
				break;
			
			case 4:
				FruitUtility.displayAllFruit(f, i);
				break;
				
			case 5:
				FruitUtility.displayBasket(f, i);
				break;
				
			case 6:
				System.out.println("Enter the index of fruit which is stale: ");
				int ind=in.nextInt();
				if(ind>=i)
				{
					System.out.println("No such fruit in basket.");
				}
				else 
				{
					f[ind].setFresh(false);
					System.out.println("Fruit successfully marked as Stale.");
				}
				break;
			
			case 7:
				FruitUtility.markSourStale(f,i);
				System.out.println("All sour fruit is marked as stale successfully.");
				break;
				
				
			case 8:
				System.out.println("Enter the index of fruit to check speciality: ");
				int sind=in.nextInt();
				if(sind<i)
				{
					FruitUtility.displaySF(f,sind);
				}
				else
				{
					System.out.println("No such fruit in basket.");
				}
				
				break;
				
			case 9:
				System.out.println("Exiting...");
				return;
				
			default:
				System.out.println("Invalid Input!");
				break;
			}
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		} while (true);
		
		//
	}
}
