package com.app.tester;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.app.customordering.EmployeeSortingByDoj;
import com.app.entity.Employee;
import com.app.utils.EmployeeUtils;
import com.app.utils.Validation;

public class Tester {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in))
		{
			List<Employee> emplist = new ArrayList<>();
			boolean exit=false;
			while(!exit) {
				System.out.println("1.Add full time employee\r\n"
						+ "2.Add part time employee\r\n"
						+ "3.Delete an employee by Emp Id\r\n"
						+ "4.Search employee details by Aadhaar number\r\n"
						+ "5.Display all employee details\r\n"
						+ "6.Display all employee details sorted by date of joining\r\n"
						+ "7.Exit"); 
				System.out.println("Enter your choice:");
				int c=sc.nextInt();
				try {
						switch(c)
						{
						case 1:
							//Name, Date of joining, Phone Number, Aadhaar number
							System.out.println("Enter Name, Date of Joining, Phone Number, Aadhar Number, Monthly Salary:" );
							Employee e=Validation.inputValidation(sc.next(),sc.next(),sc.next(),sc.next(),sc.nextDouble(),c);
							emplist.add(e);
							System.out.println("Full time employee details successfully added.");
							break;
							
						case 2:
							System.out.println("Enter Name, Date of Joining, Phone Number, Aadhar Number, Hourly Payment:" );
							Employee e1=Validation.inputValidation(sc.next(),sc.next(),sc.next(),sc.next(),sc.nextDouble(),c);
							emplist.add(e1);
							System.out.println("Part time employee details successfully added.");
							break;
							
						case 3:
							System.out.print("Enter Employee Id: ");
							System.out.println(EmployeeUtils.deleteEmployee(sc.nextInt(),emplist));
							break;
							
						case 4:
							System.out.println("Enter Aadhar Number:");
							System.out.println(EmployeeUtils.searchBy(sc.next(),emplist));
							break;
							
						case 5:
							System.out.println(emplist);
							break;
							
						case 6:
							Collections.sort(emplist, new EmployeeSortingByDoj());
							System.out.println("Sorted List");
							System.out.println(emplist);
							break;
							
						case 7:
							System.out.println("Exiting...!");
							exit=true;
							break;
							
						default:
							System.out.println("Invalid Input!");
							break;
							
						}
				}catch(Exception e) {
					sc.nextLine();
					System.out.println(e);
				}
			}
			
		}
	}

}
