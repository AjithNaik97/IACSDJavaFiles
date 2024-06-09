package com.app.utils;

import java.util.List;

import com.app.customeexception.CustomException;
import com.app.entity.Employee;

public class EmployeeUtils {

	public static String deleteEmployee(int empId, List<Employee> emplist) {
		Employee emp = new Employee(empId);
		int index = emplist.indexOf(emp);
		if (index != -1) {
			Employee eemp = emplist.remove(index);
			return eemp + " Successfully removed!";
		}
		throw new CustomException("No such employee exist!");
	}

	public static Employee searchBy(String aadharNo, List<Employee> emplist) {
//		Employee emp =new Employee(aadharNo);
//		int index=emplist.indexOf(emp);
//		if(index!=-1)
//			return emplist.get(index);
		for (Employee e : emplist) {
			if (e.getAadharNo().equals(aadharNo)) {
				return e;
			}
		}
		throw new CustomException("No such Employee exists!");
	}

}
