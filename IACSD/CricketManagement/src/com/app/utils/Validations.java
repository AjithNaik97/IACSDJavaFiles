package com.app.utils;

import java.util.Map;

import com.app.entity.Cricketer;
import com.app.exception.CustomException;

public class Validations {

	public static Cricketer inputvalidations(String name, int age, String email, String phone, int rating, Map<String, Cricketer> cmap)
			throws CustomException {
		checkForDuplicateEmail(email,cmap);
		checkValidPhone(phone);
		
		return new Cricketer(name, age, email, phone, rating);
	}

	public static void checkValidPhone(String phone) throws CustomException {
		if(phone.length()!=10)
			throw new CustomException("Invalid phone number!");
		
	}

	public static void checkForDuplicateEmail(String email, Map<String, Cricketer> cmap) throws CustomException {
		if(cmap.containsKey(email))
		throw new CustomException("Email already exists!");
	}

}
