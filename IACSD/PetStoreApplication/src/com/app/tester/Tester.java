package com.app.tester;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.app.entities.Order;
import com.app.entities.Pet;
import com.app.utils.OrderUtils;
import com.app.utils.PetUtils;
import com.app.utils.Validation;

public class Tester {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			List<Pet> petlist = new ArrayList<>();
			List<Order> orderlist = new ArrayList<>();
			int u = -1;
			boolean exit = false;
			int a;
			while (!exit) {
				System.out.println("----Menu----");
				System.out.println("1.Login.\r\n" + "2.Add new Pet.\r\n" + "3.Update Pet details.\r\n"
						+ "4.Display all available pets.\r\n" + "5.Order a Pet.\r\n"
						+ "6.Check order status by Order Id.\r\n" + "7.Update order status.\r\n" + "8.Exit.");
				System.out.print("Enter your choice:");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter login ID and password:");
						u = Validation.loginValidation(sc.next(), sc.next());
						System.out.println("Login successfull!");
						break;

					case 2:
						// petId, name, category, unitPrice, stocks
						System.out.println("Enter Pet ID, Name, Category, Unit Price, Stocks.");
						Pet p = Validation.inputValidations(sc.nextInt(), sc.next(), sc.next(), sc.nextDouble(),
								sc.nextInt(), u, petlist);
						petlist.add(p);
						System.out.println("Pet data added successfully!");
						break;

					case 3:
						System.out.println("Enter petID and details to be updated:");
						System.out.println(PetUtils.updateDetails(sc.nextInt(), sc.next(), sc.next(), sc.nextDouble(),
								sc.nextInt(), u, petlist));
						break;

					case 4:
						System.out.println(petlist);
						break;

					case 5:
						System.out.println("Enter the details of the pet:");
						System.out.println("PetId, Quantity");
						Order o = OrderUtils.placeOrder(sc.nextInt(), sc.nextInt(), petlist);
						orderlist.add(o);
						System.out.println("Order placed successfully!");
						System.out.println("Here's your order ID: " + o.getOrderId());
						break;

					case 6:
						System.out.print("Enter Order ID:");
						Order o1 = OrderUtils.checkOrder(sc.nextInt(), orderlist);
						System.out.println(o1.getStatus());
						break;

					case 7:
						System.out.println("Enter orderId and Status to be updated:");
						System.out.println(OrderUtils.updateStatus(sc.nextInt(), sc.next(), orderlist, u));
						break;

					case 8:
						System.out.println("Exiting...");
						exit = true;
						break;

					default:
						System.out.println("Invalid Input!");
						break;
					}
				} catch (Exception e) {
					System.out.println(e);
					sc.nextLine();
				}
			}
		}

	}

}
