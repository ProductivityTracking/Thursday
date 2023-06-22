package com.nkxgen.spring.orm.model;

import java.sql.Date;

public class SubtaskDto {

	private Integer taskId;
	private Integer subtaskId;
	private String subtaskDescription;
	private Double numberOfHours;
	private Date creationDate;

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public Integer getSubtaskId() {
		return subtaskId;
	}

	public void setSubtaskId(Integer subtaskId) {
		this.subtaskId = subtaskId;
	}

	public String getSubtaskDescription() {
		return subtaskDescription;
	}

	public void setSubtaskDescription(String subtaskDescription) {
		this.subtaskDescription = subtaskDescription;
	}

	public Double getNumberOfHours() {
		return numberOfHours;
	}

	public void setNumberOfHours(Double numberOfHours) {
		this.numberOfHours = numberOfHours;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date date) {
		this.creationDate = date;
	}

	public static SubtaskDto fromEntity(Subtask subtask) {
		SubtaskDto subDto = new SubtaskDto();
		subDto.setSubtaskId(subtask.getSubtaskId());
		subDto.setSubtaskDescription(subtask.getSubtaskDescription());
		subDto.setNumberOfHours(subtask.getNumberOfHours());
		subDto.setCreationDate(subtask.getCreationDate());
		return subDto;
	}
}