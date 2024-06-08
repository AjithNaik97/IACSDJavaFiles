package com.app.utils;

import com.app.customexception.AuthenticationException;
import com.app.customexception.AuthorizationException;
import com.app.entities.Users;
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

	public static Category parseAndValidate(String category) throws AuthenticationException{
		Category vcategory= Category.valueOf(category.toUpperCase());
		if(vcategory!=null)
		{
			return vcategory;
		}
		throw new AuthenticationException("No proper category");
	}

	public static Status parseAndValidateStatus(String status) throws AuthorizationException {
		Status vstatus=Status.valueOf(status.toUpperCase());
		if(vstatus!=null)
			return vstatus;
		throw new AuthorizationException("Invalid status!");
	}
}
