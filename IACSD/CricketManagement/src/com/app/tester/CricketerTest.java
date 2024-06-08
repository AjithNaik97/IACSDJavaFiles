package com.app.tester;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.app.entity.Cricketer;
import com.app.utils.CricketUtils;
import com.app.utils.Validations;

public class CricketerTest {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			Map<String, Cricketer> cricketersmap = new HashMap<String, Cricketer>();
			boolean exists = false;
			while (!exists) {
				System.out.println("-------Menu-------");
				System.out.println(
						"1.Accept cricketer details.\n2.Update Cricketer's rating. \n3.Search Cricketer. \n4.Display all cricketers. \n5.Display all cricketers in sorted from by rating.\n6.Exit");
				System.out.print("Choose an option : ");
				try {
					switch(sc.nextInt())
					{
						case 1:
							System.out.println("Enter name,age,email id, phone, rating.");
							Cricketer c= Validations.inputvalidations(sc.next(),sc.nextInt(),sc.next(),sc.next(),sc.nextInt(),cricketersmap);
							cricketersmap.put(c.getEmail_id(), c);
							System.out.println("Cricketer details successfully added!");
							break;
							
						case 2:
							System.out.println("Enter the email and rating to be modified.");
							System.out.println(CricketUtils.updateRating(sc.next(),sc.nextInt(),cricketersmap));
							break;
							
						case 3:
							System.out.println("Enter cricketer's name: ");
							Cricketer c1= CricketUtils.searchByName(sc.next(),cricketersmap);
							System.out.println(c1);
							break;
							
						case 4:
							for(Cricketer c4:cricketersmap.values())
								System.out.println(c4);
							break;
							
						case 5:
							CricketUtils.sortByRating(cricketersmap);
							for(Cricketer c5: cricketersmap.values())
								System.out.println(c5);
							System.out.println();
							break;
							
						case 6:
							System.out.println("Exiting....");
							exists=true;
							break;
						
					}
				}catch(Exception e)
				 {
					 sc.nextLine();
					 System.out.println(e);
					 
				 }	
			
			
			}
		}

	}

}
