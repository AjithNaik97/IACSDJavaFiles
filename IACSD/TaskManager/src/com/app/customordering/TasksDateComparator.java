package com.app.customordering;

import java.util.Comparator;

import com.app.entity.Tasks;

public class TasksDateComparator implements Comparator<Tasks> {
	@Override
	public int compare(Tasks t1, Tasks t2)
	{
		return t1.getTaskDate().compareTo(t2.getTaskDate());
	}
}
