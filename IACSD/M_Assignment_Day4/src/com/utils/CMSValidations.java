package com.utils;

import java.time.LocalDate;
import java.util.List;

import com.appexceptions.CMSException;
import com.cms.Customer;
import com.cms.ServicePlan;

public class CMSValidations {

	// add a method to validate all ips
	public static Customer validateCustomerInputs(String fname, String lname, String email, String password,
			double registrationAmount, String dob, String plan, List<Customer> customers) throws CMSException {
		// Email Validation
		CMSutility.validateEmailFormat(email);

		// 1. checkforduplicate
		CMSutility.checkForDupCustomer(email, customers);
		ServicePlan servicePlan = parseAndValidatePlanandCharges(plan, registrationAmount);
		LocalDate birthDate = LocalDate.parse(dob);

		// Password Validation
		String vpassword = CMSutility.validatePasswordFormat(password);

		//dob validation where age should be greater than 18
		
		CMSutility.checkforage(birthDate);
		
		// => all o/ps are valid , ret validated customer details to the caller
		return new Customer(fname, lname, email, vpassword, registrationAmount, birthDate, servicePlan);
	}

	// add a method to parse n validate plan and it's charges
	public static ServicePlan parseAndValidatePlanandCharges(String plan, double regAmount) throws CMSException {
		// 1. parse String(plan) -- > enum
		ServicePlan servicePlan = ServicePlan.valueOf(plan.toUpperCase());
		// => plan is valid, now check if reg amount is correct
		if (servicePlan.getCharges() == regAmount)
			return servicePlan;
		// => incorrect reg amount:throw custom exc
		throw new CMSException("Reg amount doesn't match with the chosen plan");
	}

}
