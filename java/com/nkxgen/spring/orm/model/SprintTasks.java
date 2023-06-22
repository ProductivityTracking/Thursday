package com.nkxgen.spring.orm.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T4_SprintTasks")
public class SprintTasks {
	@EmbeddedId
	private SprintTasksId id;

	@ManyToOne
	@JoinColumn(name = "sprn_id", insertable = false, updatable = false)
	private Sprint sprint;

	@ManyToOne
	@JoinColumn(name = "task_id", insertable = false, updatable = false)
	private Task task;

	@ManyToOne
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	private User user;

	public SprintTasks(SprintTasksId id, Sprint sprint, Task task, User user) {
		this.id = id;
		this.sprint = sprint;
		this.task = task;
		this.user = user;
	}

	public SprintTasks() {
		super();
	}

	public SprintTasksId getId() {
		return id;
	}

	public void setId(SprintTasksId id) {
		this.id = id;
	}

	public Sprint getSprint() {
		return sprint;
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	// Constructors, other properties, and methods

	public int getUserId() {
		return user.getUserId();
	}

	public int getTaskId() {
		return task.getTaskId();

		// Getters and setters for user and task
	}

	public void setUser(User user) {
		this.user = user;
	}
}
