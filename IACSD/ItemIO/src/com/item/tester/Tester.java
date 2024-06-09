package com.item.tester;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.item.entity.Item;
import com.items.utils.Validation;

public class Tester {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			List<Item> itemlist = new ArrayList<>();
			boolean exit = false;

			while (!exit) {
				try {
					System.out.println("1.Add 5 Items\n2.Exit.\n3.Display all items.");
					System.out.print("Enter you choice:");
					switch (sc.nextInt()) {
					case 1:
						for (int i = 0; i < 5; i++) {
							System.out.println("Enter Item Code, Description, Price, Shipment Date:");
							Item item = Validation.inputValidation(sc.next(), sc.next(), sc.nextDouble(), sc.next());
							itemlist.add(item);
						}
						break;

					case 2:
						System.out.println("Exiting...");
						exit = true;
						
						Validation.writeDetails(itemlist);
						break;

					case 3:
						itemlist.forEach(it -> System.out.println(it));
						break;
						
					case 4:
						List<Item> rlist= Validation.readDetails();
						rlist.forEach(rl->System.out.println(rl));
						break;
						
					default:
						System.out.println("Invalid Input");
						break;
					}

				} catch (Exception e) {
					sc.nextLine();
					System.out.println(e);
				}
			}
		}

	}
}
