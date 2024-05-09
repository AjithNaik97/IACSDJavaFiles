package com.functional_streams;

import static utils.StudentCollectionUtils.populateList;
import static utils.StudentCollectionUtils.populateMap;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import com.app.core.Student;
import com.app.core.Subject;

public class Test5 {

	public static void main(String[] args) {
		// display sum of squares of the even nos between 1-100
		int result= IntStream.range(1, 101) //IntStream of numbers from 1-100
		.filter(i->i%2==0) //IntStream : evens
		.map(i->i*i) //IntStream : sq of evens
		.sum(); //terminal op :reduce
		System.out.println("Sum= "+result);
		System.out.println("************************************************************************");

		/*display sum of gpas of all passed Students */
		//get populated map of studentsm display all
		Map<String, Student> studentMap=populateMap(populateList());
		//display all elements from map
		studentMap.forEach((k,v)->System.out.println(v));
		
		double gsum= studentMap.values() 
		.stream()  //Stream of all students
		.filter(s->s.getGpa()>6) //Stream<Student> : passed only
		.mapToDouble(g->g.getGpa()) //DoubleStream
		.sum();
		System.out.println("Sum of GPA= "+gsum);
		System.out.println("************************************************************************");
		
		/*Display the student details from the list of students sorted as per the dob*/
		//Get populated list
		List<Student> list=populateList();
		Comparator<Student> comp= (s1,s2) ->s1.getDob().compareTo(s2.getDob());
		list.stream()
		.sorted(comp)
		.forEach(s->System.out.println(s));
		
		System.out.println("************************************************************************");
		/*Print the name of Student topper*/
		//map --collection --stream--filter(subject) --max(Comparator)
		// --get
		
		Student stu=studentMap.values() //Collection<Student>
		.stream()
		.filter(s->s.getSubject()==Subject.DBT)
		.max((s1,s2)-> ((Double)s1.getGpa()).compareTo(s2.getGpa()))
		.get();
		System.out.println("Subject Topper of DBT="+stu.getName());
		System.out.println("************************************************************************");

		

		
	}

}
