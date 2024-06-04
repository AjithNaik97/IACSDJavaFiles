package com.app.validations;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import com.app.entity.Pen;
import com.app.enumclass.Brand;
import com.app.enumclass.Inkcolor;
import com.app.enumclass.Material;
import com.app.exceptions.CustomException;

public class Validations {
	public static Pen inputValidations()
	{
		return null;
	}

	public static Pen inputValidations(int id, String brand, String color, String icolor, String material, int stock,
			double price) throws CustomException {
			Brand vbrand = parseAndValidateBrand(brand);
			Inkcolor vicolor=parseAndValidateInkColor(icolor);
			Material vmaterial=parseAndValidateMaterial(material);
			LocalDate sudate= LocalDate.now();
			LocalDate sldate= LocalDate.now();
			int discount=0;
		
		return new Pen(id,vbrand,color,vicolor,vmaterial,stock,sudate,sldate,price,discount);
	}

	private static Material parseAndValidateMaterial(String material) throws CustomException {
		Material vmaterial = Material.valueOf(material.toUpperCase());
		if(vmaterial!=null)
			return vmaterial;
		throw new CustomException("Invalid Material!!");
	}

	private static Inkcolor parseAndValidateInkColor(String icolor) throws CustomException {
		Inkcolor vicolor = Inkcolor.valueOf(icolor.toUpperCase());
		if(vicolor!=null)
			return vicolor;
		throw new CustomException("Invalid Inkcolor!!");
	}

	private static Brand parseAndValidateBrand(String brand) throws CustomException {
		Brand vbrand = Brand.valueOf(brand.toUpperCase());
		if(vbrand!=null)	
		return vbrand;
		throw new CustomException("Invalid brand!");
	}

	public static String stockupdate(int id, int qty, List<Pen> plist) {
		Pen p=new Pen(id);
		int index= plist.indexOf(p);
		if(index==-1)
			throw new CustomException("No such Pen found");
		Pen pens=plist.get(index);
		pens.setStock(qty);
		pens.setSudate(LocalDate.now());
		return "Stock successfully updated";
	}

	public static List<Pen> setDiscount(List<Pen>plist) {
		LocalDate currentdate = LocalDate.now();
		LocalDate threemonthsago = currentdate.minusMonths(3);
		
		for(Pen p:plist)
		{
			if(p.getSldate().isBefore(threemonthsago))
			{
				double price=p.getPrice();
				double discount=0.2*price;
				p.setPrice(discount);
			}
		}
		
		return plist;
	}

	public static String removePens(List<Pen> penlist) {
		LocalDate currentdate = LocalDate.now();
		LocalDate ninemonthsago = currentdate.minusMonths(9);
		
		Iterator<Pen> itr =penlist.iterator();
		while(itr.hasNext())
		{
			Pen p=itr.next();
			if(p.getSudate().isBefore(ninemonthsago))
			{
				itr.remove();
			}
		}
		return "Pens removed successfully!";
	}
}
