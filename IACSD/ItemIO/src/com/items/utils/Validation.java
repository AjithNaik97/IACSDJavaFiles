package com.items.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.item.customexception.CustomException;
import com.item.entity.Item;

public class Validation {

	public static Item inputValidation(String itemcode, String description, double price, String sdate)
			throws CustomException {
		LocalDate vsdate = LocalDate.parse(sdate);
		return new Item(itemcode, description, price, vsdate);
	}

	public static void writeDetails(List<Item> itemlist) throws IOException{
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("items_code.ser")))
		{
			Comparator<Item> compare=((d1,d2)->d1.getShipmentDate().compareTo(d2.getShipmentDate()) );
			List<Item> ritemlist= itemlist.stream()
			.sorted(compare)
			.collect(Collectors.toList());
			out.writeObject(ritemlist);
		}
		
	}

	public static List<Item> readDetails() throws IOException, ClassNotFoundException {
		try(ObjectInputStream in=new ObjectInputStream(new FileInputStream("items_code.ser"))){
			return (List<Item>)in.readObject();
		}
	}

}
