package com.app.utils;

import java.time.LocalDate;

import com.app.customeexception.CustomException;
import com.app.entity.EmpType;
import com.app.entity.Employee;

public class Validation {

	public static Employee inputValidation(String name, String doj, String phoneNo, String aadharNo, double salary,
			int c) throws CustomException {
		LocalDate vdoj = LocalDate.parse(doj);
		if (!phoneNo.matches("^[0-9]*$")) {
			throw new CustomException("Invalid Phone number!");
		}
		if (!aadharNo.matches("^[0-9]{12}$")) {
			throw new CustomException("Invalid Aadhar number!");
		}
		if (c == 1)
			return new Employee(name, vdoj, phoneNo, aadharNo, EmpType.FTE, salary, 0.0);
		else
			return new Employee(name, vdoj, phoneNo, aadharNo, EmpType.PTE, 0.0, salary);
	}

}
