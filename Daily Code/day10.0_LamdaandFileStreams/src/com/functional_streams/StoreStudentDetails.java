package com.functional_streams;

import static utils.StudentCollectionUtils.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import com.app.core.Student;

public class StoreStudentDetails {

	public static void main(String[] args) {
		//Suppose you have student details in a map. Can you store these details sorted as per the name in a text file, in a buffered manner?
		try(Scanner sc=new Scanner(System.in))
		{
			//get the populated amo from coll utils
			Map<String,Student> studentMap=populateMap(populateList());
			//function literal for the comparator
			Comparator<Student> comp=(s1,s2)->s1.getName().compareTo(s2.getName());
			//sort the student details as per name
			Stream<Student> sortedStream= studentMap.values()
			.stream()
			.sorted(comp);
			System.out.println("Enter the destination file name:");
			writeDetails(sortedStream,sc.nextLine());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
	
