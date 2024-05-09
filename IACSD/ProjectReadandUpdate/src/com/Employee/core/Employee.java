package com.Employee.core;

import java.time.LocalDate;

public class Employee {
	private int empId;
	private String ename;
	private String deptId;
	private String designation;
	private double salary;
	private LocalDate joinDate;
	
	public Employee(int empid,String ename,String deptId,String designation, double salary,LocalDate joinDate)
	{
		this.empId=empId;
		this.ename=ename;
		this.deptId=deptId;
		this.designation=designation;
		this.salary=salary;
		this.joinDate=joinDate;
	}
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", ename=" + ename + ", deptId=" + deptId + ", designation=" + designation
				+ ", salary=" + salary + ", joinDate=" + joinDate + "]";
	
		
	
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}
}


