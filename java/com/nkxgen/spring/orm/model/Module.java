package com.nkxgen.spring.orm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t4_ProjectModules")
public class Module {
	@Id
	@Column(name = "modl_id")
	private int id;

	@Column(name = "modl_name")
	private String name;

	@Column(name = "modl_desc")
	private String description;

	@ManyToOne
	@JoinColumn(name = "modl_proj_id")
	private Project project;

	public Module() {
		// Default constructor required by JPA
	}

	public Module(String name, String description, Project project) {
		this.name = name;
		this.description = description;
		this.project = project;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public String toString() {
		return "Module{" + "id=" + id + ", name='" + name + '\'' + ", description='" + description + '\'' + ", project="
				+ project + '}';
	}

	public String getModl_desc() {
		// TODO Auto-generated method stub
		return description;
	}

}
