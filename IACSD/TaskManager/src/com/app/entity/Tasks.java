package com.app.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Tasks {
	private int taskId;
	private String taskName;
	private String description;
	private LocalDate taskDate;
	private Status status;
	private boolean active;
	private static int counter=100;

	public Tasks(String taskName, String description, LocalDate taskDate) {
		this.taskId=++counter;
		this.taskName = taskName;
		this.description = description;
		this.taskDate = taskDate;
		this.status = Status.PENDING;
		this.active = true;
	}

	public Tasks(int tid) {
		super();
		taskId = tid;
	}

	public Tasks(String name) {
		this.taskName=name;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getTaskDate() {
		return taskDate;
	}

	public void setTaskDate(LocalDate taskDate) {
		this.taskDate = taskDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	

//    @Override
//    public int hashCode() {
//        return Objects.hash(taskId);
//    }

	@Override
	public int hashCode() {
		return Objects.hash(taskId, taskName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tasks other = (Tasks) obj;
		return taskId == other.taskId || Objects.equals(taskName, other.taskName);
	}

	@Override
	public String toString() {
		return "Tasks [taskId=" + taskId + " taskName=" + taskName + ", description=" + description + ", taskDate="
				+ taskDate + ", status=" + status + ", active=" + active + "]\n";
	}

}
