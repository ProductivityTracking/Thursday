package com.nkxgen.spring.orm.model;

import java.math.BigDecimal;
import java.sql.Date;

public class TaskInput {
	private String taskName;
	private Date taskCreationDateTime;
	private String taskType;
	private Integer referencedTaskId;
	private String taskCategory;
	private String taskDescription;
	private Integer taskCreatorId;
	private BigDecimal numberOfHoursRequired;
	private Date taskExpectedDateTime;
	private Date taskCompletedDateTime;
	private Integer taskSupervisorId;
	private String taskRemarks;
	private String taskStatus;
	private short projectId;
	private short moduleId;
	private int assignedUserId;
	private int taskId;

	// Constructors, getters, and setters

	public TaskInput() {
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Date getTaskCreationDateTime() {
		return taskCreationDateTime;
	}

	public void setTaskCreationDateTime(Date taskCreationDateTime) {
		this.taskCreationDateTime = taskCreationDateTime;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public Integer getReferencedTaskId() {
		return referencedTaskId;
	}

	public void setReferencedTaskId(Integer referencedTaskId) {
		this.referencedTaskId = referencedTaskId;
	}

	public String getTaskCategory() {
		return taskCategory;
	}

	public void setTaskCategory(String taskCategory) {
		this.taskCategory = taskCategory;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public Integer getTaskCreatorId() {
		return taskCreatorId;
	}

	public void setTaskCreatorId(Integer taskCreatorId) {
		this.taskCreatorId = taskCreatorId;
	}

	public BigDecimal getNumberOfHoursRequired() {
		return numberOfHoursRequired;
	}

	public void setNumberOfHoursRequired(BigDecimal numberOfHoursRequired) {
		this.numberOfHoursRequired = numberOfHoursRequired;
	}

	public Date getTaskExpectedDateTime() {
		return taskExpectedDateTime;
	}

	public void setTaskExpectedDateTime(Date taskExpectedDateTime) {
		this.taskExpectedDateTime = taskExpectedDateTime;
	}

	public Date getTaskCompletedDateTime() {
		return taskCompletedDateTime;
	}

	public void setTaskCompletedDateTime(Date taskCompletedDateTime) {
		this.taskCompletedDateTime = taskCompletedDateTime;
	}

	public Integer getTaskSupervisorId() {
		return taskSupervisorId;
	}

	public void setTaskSupervisorId(Integer taskSupervisorId) {
		this.taskSupervisorId = taskSupervisorId;
	}

	public String getTaskRemarks() {
		return taskRemarks;
	}

	public void setTaskRemarks(String taskRemarks) {
		this.taskRemarks = taskRemarks;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public short getProjectId() {
		return projectId;
	}

	public void setProjectId(short projectId) {
		this.projectId = projectId;
	}

	public short getModuleId() {
		return moduleId;
	}

	public void setModuleId(short moduleId) {
		this.moduleId = moduleId;
	}

	public Task toEntity() {
		Task task = new Task();
		task.setTaskId(this.taskId);

		User assignedUser = new User();
		assignedUser.setUserId(this.assignedUserId);
		task.setTaskSupervisor(assignedUser);

		task.setTaskName(this.taskName);
		task.setTaskCreationDateTime(this.taskCreationDateTime);
		task.setTaskType(this.taskType);

		Task referencedTask = new Task();
		referencedTask.setTaskId(this.referencedTaskId);
		task.setReferencedTask(referencedTask);

		task.setTaskCategory(this.taskCategory);
		task.setTaskDescription(this.taskDescription);

		User taskCreator = new User();
		taskCreator.setUserId(this.taskCreatorId);
		task.setTaskCreator(taskCreator);

		task.setNumberOfHoursRequired(this.numberOfHoursRequired);
		task.setTaskExpectedDateTime(this.taskExpectedDateTime);
		task.setTaskCompletedDateTime(this.taskCompletedDateTime);

		User taskSupervisor = new User();
		taskSupervisor.setUserId(this.taskSupervisorId);
		task.setTaskSupervisor(taskSupervisor);

		task.setTaskRemarks(this.taskRemarks);
		task.setTaskStatus(this.taskStatus);

		Project project = new Project();
		project.setProjectId(this.projectId);
		task.setProject(project);

		ProjectModule module = new ProjectModule();
		module.setModuleId(this.moduleId);
		task.setModule(module);

		return task;
	}

}
