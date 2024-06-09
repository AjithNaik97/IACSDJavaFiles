package com.app.utils;

import com.app.customexception.AuthenticationException;
import com.app.customexception.AuthorizationException;
import com.app.customexception.CustomException;
import com.app.enums.Category;
import com.app.enums.Status;

public class Validation {

	public static int loginValidation(String loginId, String pass) throws AuthenticationException {
		if (loginId.equals("admin") && pass.equals("admin")) {
			return 0;
		}
		if (loginId.equals("c1") && pass.equals("c1")) {
			return 1;
		}
		throw new AuthenticationException("Invalid email or password!");
	}

	public static Category parseAndValidate(String category) throws CustomException {

		for (Category c : Category.values()) {
			if (c.name().equalsIgnoreCase(category)) {
				return c;
			}
		}
		throw new CustomException("No proper category");
	}

	public static Status parseAndValidateStatus(String status) throws CustomException {
		for (Status s : Status.values()) {
			if (s.name().equalsIgnoreCase(status)) {
				return s;
			}
		}
		throw new CustomException("Invalid status!");
	}
}
