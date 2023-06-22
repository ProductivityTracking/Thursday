package com.nkxgen.spring.orm.model;


public class ProjectTaskViewModel {
    private int taskId;
    private String taskName;
    private String taskCategory;
    private String taskDescription;
    private String taskStatus;
    private String projectName;

    // Constructors
    public ProjectTaskViewModel() {
    }

    public ProjectTaskViewModel(int taskId, String taskName, String taskCategory, String taskDescription, String taskStatus, String projectName) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskCategory = taskCategory;
        this.taskDescription = taskDescription;
        this.taskStatus = taskStatus;
        this.projectName = projectName;
    }

    // Getters and Setters
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

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
