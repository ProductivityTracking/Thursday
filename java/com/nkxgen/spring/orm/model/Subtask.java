package com.nkxgen.spring.orm.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t4_subtasks")
@IdClass(SubtaskPrimaryKey.class)
public class Subtask {

	@Id
	@ManyToOne
	@JoinColumn(name = "task_id", referencedColumnName = "task_id")
	private Task task;

	@Id
	@Column(name = "sbts_id")
	private int subtaskId;

	@Column(name = "sbts_desc", length = 100)
	private String subtaskDescription;

	@Column(name = "sbts_noh")
	private double numberOfHours;

	@Column(name = "sbts_cre_date")
	private Date creationDate;

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public int getSubtaskId() {
		return subtaskId;
	}

	public void setSubtaskId(int subtaskId) {
		this.subtaskId = subtaskId;
	}

	public String getSubtaskDescription() {
		return subtaskDescription;
	}

	public void setSubtaskDescription(String subtaskDescription) {
		this.subtaskDescription = subtaskDescription;
	}

	public double getNumberOfHours() {
		return numberOfHours;
	}

	public void setNumberOfHours(double numberOfHours) {
		this.numberOfHours = numberOfHours;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

}