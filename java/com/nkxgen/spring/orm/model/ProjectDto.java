package com.nkxgen.spring.orm.model;

import java.util.Date;

public class ProjectDto {
	private int projectId;
	private String projectName;
	private String projectDescription;
	private Date projectStartDate;
	private int projectManagerId;
	private String projectStatus;
	private Date projectLastUpdatedDate;

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public Date getProjectStartDate() {
		return projectStartDate;
	}

	public void setProjectStartDate(Date projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	public int getProjectManagerName() {
		return projectManagerId;
	}

	public void setProjectManagerName(int i) {
		this.projectManagerId = i;
	}

	public String getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}

	public Date getProjectLastUpdatedDate() {
		return projectLastUpdatedDate;
	}

	public void setProjectLastUpdatedDate(Date projectLastUpdatedDate) {
		this.projectLastUpdatedDate = projectLastUpdatedDate;
	}

	public static ProjectDto fromEntity(Project project) {
		ProjectDto projectDto = new ProjectDto();
		projectDto.setProjectId(project.getProjectId());
		projectDto.setProjectName(project.getProjectName());
		projectDto.setProjectDescription(project.getProjectDescription());
		projectDto.setProjectStartDate(project.getProjectStartDate());
		projectDto.setProjectManagerName((short) project.getProjectManager().getUserId());
		projectDto.setProjectStatus(project.getProjectStatus());
		projectDto.setProjectLastUpdatedDate(project.getProjectLastUpdatedDate());
		return projectDto;
	}
}
