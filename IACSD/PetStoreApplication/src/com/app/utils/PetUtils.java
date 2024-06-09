package com.app.utils;

import java.util.List;

import com.app.customexception.AuthorizationException;
import com.app.customexception.CustomException;
import com.app.entities.Pet;
import com.app.enums.Category;

public class PetUtils {
	// petId, name, category, unitPrice, stocks
	public static Pet addPet(int petId, String name, String category, double untiPrice, int stocks, int u) throws AuthorizationException {
		if (u == 0) {
			Category vcategory= Validation.parseAndValidate(category);
			return new Pet(petId,name,vcategory,untiPrice,stocks);
		}
		throw new AuthorizationException("No authroziation to add new pet!");
	}

	public static String updateDetails(int petId, String name, String category, double unitPrice, int stocks, int u, List<Pet> plist) throws CustomException {
		if(u==0) {
			Pet p =new Pet(petId);
			int index= plist.indexOf(p);
			if(index!=-1)
			{
				Pet pet = plist.get(index);
				pet.setName(name);
				Category vcategory= Validation.parseAndValidate(category);
				pet.setCategory(vcategory);
				pet.setUnitPrice(unitPrice);
				pet.setStocks(stocks);
				return "Pet details updated successfully";
			}
			throw new CustomException("No such Pet exists!");
		}
		throw new AuthorizationException("No authroziation to update pet details!");
		
	}

}
