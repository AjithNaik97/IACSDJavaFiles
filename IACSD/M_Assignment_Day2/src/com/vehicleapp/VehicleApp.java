package com.vehicleapp;

import java.util.Date;
import java.util.Scanner;
import static com.vehiclevalidations.Vehiclevalidations.validateInputs;
import com.vehicle.Color;
import com.vehicle.Vehicle;
import static com.utils.VehicleUtils.driveVehicle;
public class VehicleApp {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in))
		{
		Vehicle[] arr = new Vehicle[5];
		int i = 0;
		boolean exit = false;
		while (!exit) {
			try {
				System.out.println("1.Add new Vehicle 2.Drive a Vehicle 0.Exit");
				System.out.print("Your choice: ");
				switch (sc.nextInt()) {
				case 1:
					System.out.println("Enter the details:");
					System.out.println("Chasis No,Color,Price,Manufacture Date,Insurance expire Date,Pollution level");
					arr[++i]=validateInputs(sc.next(),sc.next(),sc.nextDouble(),sc.next(),sc.next(),sc.nextDouble());
					break;
				case 2:
					System.out.print("Enter the distance of ride in Kilometers: ");
					System.out.println(driveVehicle(sc.nextInt()));
					break;
				
				case 0:
					exit=true;
					System.out.println("Exiting ...");
					break;
					
				default:
					System.out.println("Invalid Input!");
					break;
				}
			} catch (Exception e) {
				sc.nextLine();
			}
		}
		
		}
	}

}
