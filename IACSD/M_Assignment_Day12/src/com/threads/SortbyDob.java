package com.threads;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;
import static utils.IOUtils.*;

import com.app.core.Student;


public class SortbyDob implements Runnable {
	
	private Map<String, Student> student;
	public SortbyDob(Map<String,Student> student)
	{
		this.student=student;
	}
	Scanner sc=new Scanner(System.in);
	@Override
	public void run() {
		synchronized(student) {
		try {
			System.out.print("1.Enter the filename to be written:");
			
			Comparator<Student> comp = (s1,s2)->s1.getDob().compareTo(s2.getDob());
			Stream<Student> sortedstream= student.values()
			.stream()
			.sorted(comp);
			writeDetails(sortedstream,sc.next());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	}
}
