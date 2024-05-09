package com.utils;

import com.vexceptions.VehicleExceptions;
import static com.vehiclevalidations.Vehiclevalidations.validatePollution;
public class VehicleUtils {
	public static String driveVehicle(int km) throws VehicleExceptions
	{
		int limit=21;
		if(km>150)
			validatePollution(limit);
		return "Driving Vehicle for "+km+" kilometers.." ;
		
	}
}
