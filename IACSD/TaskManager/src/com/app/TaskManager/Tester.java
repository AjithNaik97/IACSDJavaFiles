package com.app.TaskManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.app.customordering.TasksDateComparator;
import com.app.entity.Tasks;
import com.app.utils.TaskUtils;

public class Tester {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			boolean exists = false;
			List<Tasks> tasks = new ArrayList<>();
			try {
				while (!exists) {
					System.out.println("---Menu---");
					System.out.println(
							"1. Add New Task\n2. Delete a task\n3. Update task status\n4. Display all pending tasks\n5. Display all pending tasks for today\n6. Display all tasks sorted by taskDate");
					System.out.print("Enter your choice:");
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter Task Name, Description, Task Date");
						tasks.add(TaskUtils.inputValidation(sc.next(),sc.next(),sc.next()));
						System.out.println("Task added successfully!");
						break;

					case 2:
						System.out.println("Enter taskId to be deleted");
						System.out.println(TaskUtils.deleteTask(sc.nextInt(),tasks));
						break;

					case 3:
						System.out.println("Enter Task Id and Status to which it needs to be updated:");
						System.out.println(TaskUtils.updateStatus(sc.nextInt(),sc.next(),tasks));
						break;

					case 4:
						System.out.println("Pending Tasks:");
						System.out.println(TaskUtils.pendingTasks(tasks));
						break;

					case 5:
						System.out.println("Today's Pending Tasks:");
						System.out.println(TaskUtils.pendingTasksToday(tasks));
						break;

					case 6:
						Collections.sort(tasks, new TasksDateComparator());
						System.out.println("Successfully sorted");
						System.out.println(tasks);
						break;
					case 7:
						System.out.println("Enter status:");
						System.out.println(TaskUtils.checkstatus(tasks,sc.next()));
						break;
					case 8:
						System.out.println("Enter name");
						System.out.println(TaskUtils.setactive(sc.next(),tasks));
						break;
						
					case 9:
						System.out.println("Enter id");
						System.out.println(TaskUtils.checkDuplicate(sc.nextInt(),tasks));
						break;
						
					default:
						System.out.println("Invalid Input!");
						break;
					}
				}
			} catch (Exception e) {
				sc.nextLine();
				System.out.println(e);
			}
		}

	}

}
