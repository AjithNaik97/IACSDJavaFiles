package com.tester;

import java.util.HashMap;
import java.util.Map;
import static utils.StudentCollectionUtils.*;
import com.app.core.Student;
import com.threads.SortByGpa;
import com.threads.SortbyDob;

public class Tester {

	public static void main(String[] args) throws InterruptedException {
		
		Map<String,Student> studentmap=populateMap(populateList());
		
		SortbyDob sbd=new SortbyDob(studentmap);
		SortByGpa sbg=new SortByGpa(studentmap);
		
		Thread t1=new Thread(sbd ,"t1");
		Thread t2=new Thread(sbg,"t2");
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();

	}

}
