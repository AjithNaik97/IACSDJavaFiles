package com.app.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {
	//Name, Date of joining, Phone Number, Aadhaar number
	private int empId;
	private String name;
	private LocalDate doj;
	private String phoneNo;
	private String aadharNo;
	private EmpType type;
	private double monthlySalary;
	private double hourlyPayment;
	private static int counter=100;
	
	public Employee(String name, LocalDate doj, String phoneNo, String aadharNo, EmpType type,
			double monthlySalary, double hourlyPayment) {
		super();
		this.empId = ++counter;
		this.name = name;
		this.doj = doj;
		this.phoneNo = phoneNo;
		this.aadharNo = aadharNo;
		this.type = type;
		this.monthlySalary = monthlySalary;
		this.hourlyPayment = hourlyPayment;
	}

	public Employee(int empId2) {
		this.empId=empId2;
	}

	public Employee(String aadharNo2) {
		this.aadharNo=aadharNo2;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(aadharNo, other.aadharNo) || empId == other.empId;
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public EmpType getType() {
		return type;
	}

	public void setType(EmpType type) {
		this.type = type;
	}

	public double getMonthlySalary() {
		return monthlySalary;
	}

	public void setMonthlySalary(double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}

	public double getHourlyPayment() {
		return hourlyPayment;
	}

	public void setHourlyPayment(double hourlyPayment) {
		this.hourlyPayment = hourlyPayment;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", doj=" + doj + ", phoneNo=" + phoneNo + ", aadharNo="
				+ aadharNo + ", type=" + type + ", monthlySalary=" + monthlySalary + ", hourlyPayment=" + hourlyPayment
				+ "]\n";
	}
	
	
	
	
	
	
}
