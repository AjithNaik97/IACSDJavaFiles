package com.app.tester;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.app.entity.Pen;
import com.app.validations.Validations;

public class Penstock {

	public static void main(String[] args) {
		try(Scanner sc= new Scanner(System.in)) {
		boolean exists=false;
		List<Pen> penlist = new ArrayList<Pen>();
		try{
			while(!exists)
			{
				System.out.println("-----Menu-----");
				System.out.println("1.Add new Pen \n2.Update stock of a Pen\n3.Set discount of 20% for all the pens which are not at all sold in last 3 months\n4.Remove Pens which arenever sold once listed in 9 months");
				System.out.println("Enter your choice: ");
				switch(sc.nextInt())
				{
					case 1:
						System.out.println("Enter ID,Brand,Color,InkColor,Material,Stock(Qty),Price");
						Pen newpen = Validations.inputValidations(sc.nextInt(),sc.next(),sc.next(),sc.next(),sc.next(),sc.nextInt(),sc.nextDouble());
						penlist.add(newpen);
						break;
					
					case 2:
						System.out.print("Enter the ID of the pen and new qty:");
						System.out.println(Validations.stockupdate(sc.nextInt(),sc.nextInt(),penlist));
						break;
						
					case 3:
						System.out.println(Validations.setDiscount(penlist));
						break;
						
					case 4:
						System.out.println(Validations.removePens(penlist));
						break;
					
					default:
						System.out.println("Invalid Input!!");
						break;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}
	}

}
