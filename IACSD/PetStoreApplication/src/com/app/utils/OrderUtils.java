package com.app.utils;

import java.util.List;

import com.app.customexception.AuthorizationException;
import com.app.customexception.CustomException;
import com.app.customexception.OutOfStockException;
import com.app.entities.Order;
import com.app.entities.Pet;
import com.app.enums.Status;

public class OrderUtils {

	public static Order placeOrder(int petId, int qty, List<Pet> petlist)
			throws OutOfStockException, CustomException {
		Pet p = new Pet(petId);
		int index = petlist.indexOf(p);
		if (index != -1) {
			Pet pet = petlist.get(index);
			if (pet.getStocks()-qty >= 0) {
				int s=pet.getStocks();
				pet.setStocks(s-qty);
				return new Order(petId, qty);
			}
			throw new OutOfStockException("Pet not in stock");
		}
		throw new CustomException("No such Pet exits!");
	}

	public static Order checkOrder(int orderId, List<Order> orderlist) throws CustomException {
		Order o = new Order(orderId);
		int index = orderlist.indexOf(o);
		if (index != -1) {
			return orderlist.get(index);
		}
		throw new CustomException("No such order exists!");

	}

	public static String updateStatus(int orderId, String status, List<Order> orderlist,int u) throws CustomException,AuthorizationException{
		if(u==0)
		{
			Order o = new Order(orderId);
			int index = orderlist.indexOf(o);
			if (index != -1) {
				Order order=orderlist.get(index);
				Status vstatus=Validation.parseAndValidateStatus(status);
				order.setStatus(vstatus);
				return "Status successfully updated!";
			}
			throw new CustomException("No such order exists!");
		}
		throw new AuthorizationException("No authroziation to update order status!");
	}

}
