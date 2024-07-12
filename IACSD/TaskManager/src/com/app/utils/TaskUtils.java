package com.app.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.app.entity.Status;
import com.app.entity.Tasks;
import com.app.exceptions.CustomException;

public class TaskUtils {

	public static Tasks inputValidation(String tname, String tdesc, String tdate) throws CustomException {
		 LocalDate vtdate=LocalDate.parse(tdate);
		 return new Tasks(tname,tdesc,vtdate);
		
	}

	public static String deleteTask(int tid, List<Tasks> tasks) throws CustomException {
		Tasks tsk=new Tasks(tid);
		int index=tasks.indexOf(tsk);
		if(index==-1)
			throw new CustomException("No such task exists!");
		Tasks task=tasks.get(index);
		task.setActive(false);
		return "Task Successfully deleted";
	}

	public static String updateStatus(int tid, String status, List<Tasks> tasks) throws CustomException{
		Status vstatus=Status.valueOf(status.toUpperCase());
		Tasks tsk=new Tasks(tid);
		int index=tasks.indexOf(tsk);
		if(index==-1)
			throw new CustomException("No such task exists!");
		Tasks task=tasks.get(index);
	
		task.setStatus(vstatus);
		return "Task status updated successfully";
	}

	public static List<Tasks> pendingTasks(List<Tasks> tasks) throws CustomException {
		Status pstatus=Status.PENDING;
		List<Tasks> resultTasks = new ArrayList<Tasks>();
		for(Tasks t:tasks)
		{
			if(t.getStatus()==pstatus)
			{
				resultTasks.add(t);
			}
		}
		return resultTasks;
	}
	
	public static List<Tasks> pendingTasksToday(List<Tasks> tasks) throws CustomException {
		Status pstatus=Status.PENDING;
		List<Tasks> resultTasks = new ArrayList<Tasks>();
		for(Tasks t:tasks)
		{
			if(t.getStatus()==pstatus&&t.getTaskDate().equals(LocalDate.now()))
			{
				resultTasks.add(t);
			}
		}
		return resultTasks;
	}

	public static String checkstatus(List<Tasks> tasks, String status) throws CustomException{
		for(Status s:Status.values()) {
			if(s.name().equalsIgnoreCase(status)) {
				return "Valid status";
			}
		}
		throw new CustomException("Invalid status");
		
	}

	public static String setactive(String name, List<Tasks> tasks)throws CustomException {
//		for(Tasks t:tasks) {
//			if(t.getTaskName().equals(name)) {
//				t.setActive(false);
//				return "set successfully";
//			}
//		}
//		throw new CustomException("Invalid ");
		
		Tasks t=new Tasks(name);
		int index=tasks.indexOf(t);
		if(index==-1)
			throw new CustomException("Invalid name");
		Tasks tk=tasks.get(index);
		tk.setActive(false);
		return "set succesfully";
		
	}

	public static String checkDuplicate(int Id, List<Tasks> tasks)throws CustomException {
		Tasks t=new Tasks(Id);
		if(tasks.contains(t))
			throw new CustomException("Duplicate Id found");
		return "No Duplicate Id found";
	}

}
