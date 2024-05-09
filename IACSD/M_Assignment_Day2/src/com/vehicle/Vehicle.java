package com.vehicle;

import java.time.LocalDate;
import java.util.Date;

public class Vehicle {
	private String chasisNo;
	private Color color;
	private double price;
	private LocalDate manufactureDate;
	private LocalDate insuranceexpireDate;
	private double pollutionlevel;
	
	public Vehicle(String chasisNo,Color color,double price,LocalDate manufactureDate,LocalDate insuranceexpireDate,double pollutionlevel)
	{
		this.chasisNo=chasisNo;
		this.color=color;
		this.price=price;
		this.manufactureDate=manufactureDate;
		this.insuranceexpireDate=insuranceexpireDate;
		this.pollutionlevel=pollutionlevel;
	}
	
	@Override
	public String toString() {
		return "Vehicle [chasisNo=" + chasisNo + ", color=" + color + ", price=" + price + ", manufactureDate="
				+ manufactureDate + ", insuranceexpireDate=" + insuranceexpireDate + ", pollutionlevel="
				+ pollutionlevel + "]";
	}
}
