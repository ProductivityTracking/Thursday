package com.nkxgen.spring.orm.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SprintTasksId implements Serializable {

	@Column(name = "sprn_id")
	private int sprnId;

	@Column(name = "task_id")
	private int taskId;

	public SprintTasksId() {
	}

	public SprintTasksId(int sprnId, int taskId) {
		this.sprnId = sprnId;
		this.taskId = taskId;
	}

	// Getters and Setters

	public int getSprnId() {
		return sprnId;
	}

	public void setSprnId(int sprnId) {
		this.sprnId = sprnId;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	// Equals and HashCode (based on sprnId and taskId)

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		SprintTasksId other = (SprintTasksId) obj;
		return sprnId == other.sprnId && taskId == other.taskId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(sprnId, taskId);
	}
}
