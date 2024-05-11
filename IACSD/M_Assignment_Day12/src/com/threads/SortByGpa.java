package com.threads;

import static utils.IOUtils.writeDetails;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import com.app.core.Student;
import com.app.core.Subject;

public class SortByGpa implements Runnable {
	private Map<String, Student> student;

	public SortByGpa(Map<String, Student> student) {
		this.student = student;
	}

	Scanner scn = new Scanner(System.in);

	@Override
	public void run() {
		synchronized (student) {
			try {
				System.out.print("2.Enter the subject:");
				Subject chosenSubject = Subject.valueOf(scn.next().toUpperCase());
				Comparator<Student> comp = (s1, s2) -> ((Double) s1.getGpa()).compareTo(s2.getGpa());
				Stream<Student> sortedstream = student.values().stream()
						.filter(sub -> sub.getSubject() == chosenSubject).sorted(comp);
				System.out.println("2.Enter the filename to print sorted data: ");
				writeDetails(sortedstream, scn.next());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}