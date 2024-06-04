package com.app.entity;

import java.time.LocalDate;

import com.app.enumclass.Brand;
import com.app.enumclass.Inkcolor;
import com.app.enumclass.Material;

public class Pen {
	private int id;
	private Brand brand;
	private String color;
	private Inkcolor icolor;
	private Material mtrl;
	private int stock;
	private LocalDate sudate;
	private LocalDate sldate;
	private double price;
	private double discount;
	
	public Pen(int id, Brand brand, String color, Inkcolor icolor, Material mtrl, int stock, LocalDate sudate,
			LocalDate sldate, double price, double discount) {
		super();
		this.id = id;
		this.brand = brand;
		this.color = color;
		this.icolor = icolor;
		this.mtrl = mtrl;
		this.stock = stock;
		this.sudate = sudate;
		this.sldate = sldate;
		this.price = price;
		this.discount = discount;
	}

	public Pen(int id) {
		super();
		this.id=id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Inkcolor getIcolor() {
		return icolor;
	}

	public void setIcolor(Inkcolor icolor) {
		this.icolor = icolor;
	}

	public Material getMtrl() {
		return mtrl;
	}

	public void setMtrl(Material mtrl) {
		this.mtrl = mtrl;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public LocalDate getSudate() {
		return sudate;
	}

	public void setSudate(LocalDate sudate) {
		this.sudate = sudate;
	}

	public LocalDate getSldate() {
		return sldate;
	}

	public void setSldate(LocalDate sldate) {
		this.sldate = sldate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "Pen [id=" + id + ", brand=" + brand + ", color=" + color + ", icolor=" + icolor + ", mtrl=" + mtrl
				+ ", stock=" + stock + ", sudate=" + sudate + ", sldate=" + sldate + ", price=" + price + ", discount="
				+ discount + "]";
	}
	
	
	 
	
	
	
}

