package com.vehiclevalidations;

import java.time.LocalDate;
import java.util.Date;

import com.vehicle.Color;
import com.vehicle.Vehicle;
import com.vexceptions.VehicleExceptions;

public class Vehiclevalidations  {
	public static Vehicle validateInputs(String chasisNo, String color, double price, String manufactureDate,
			String insuranceexpireDate, double pollutionlevel) throws VehicleExceptions {
		Color vcolor = Vehiclevalidations.validateColor(color);
		LocalDate vmanufactureDate = LocalDate.parse(manufactureDate);
		LocalDate vinsuranceexpireDate = LocalDate.parse(insuranceexpireDate);
		Vehiclevalidations.validatePollution(pollutionlevel);

		return new Vehicle(chasisNo, vcolor, price, vmanufactureDate, vinsuranceexpireDate, pollutionlevel);
	}

	public static Color validateColor(String color) throws VehicleExceptions {
		if(Color.valueOf(color) != null)
			return Color.valueOf(color);
		throw new VehicleExceptions("Invalid Color");
	}

	public static void validatePollution(double pollutionlevel) throws VehicleExceptions {
		if (pollutionlevel > 20)
			throw new VehicleExceptions("Pollution Level exceeding limit!");
	}

}
