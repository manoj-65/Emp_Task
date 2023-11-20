package com.ty.emp_task.dto;

public class Task {
	private int taskId;
	private String deadLine;
	private String description;

	public Task() {
		super();
	}

	public Task(int taskId, String deadLine, String desc) {
		super();
		this.taskId = taskId;
		this.deadLine = deadLine;
		this.description = desc;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(String deadLine) {
		this.deadLine = deadLine;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", deadLine=" + deadLine + ", description=" + description + "]";
	}

}
