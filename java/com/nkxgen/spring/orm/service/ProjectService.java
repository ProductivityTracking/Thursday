package com.nkxgen.spring.orm.service;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nkxgen.spring.orm.dao.ProjectDAO;
import com.nkxgen.spring.orm.model.Project;
import com.nkxgen.spring.orm.model.ProjectDto;
import com.nkxgen.spring.orm.model.ProjectFilter;
import com.nkxgen.spring.orm.model.ProjectInput;

@Service
@Transactional
public class ProjectService {

	private final ProjectDAO projectDAO;

	@Autowired
	public ProjectService(ProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}

	public List<ProjectDto> getAllProjects() {
		return projectDAO.getAllProjects();
	}

	public List<ProjectDto> filterProjects(ProjectFilter projectFilter) {
		// TODO Auto-generated method stub
		return projectDAO.getFilterProjects(projectFilter);
	}

	public ProjectDto getProjectById(Integer projId) {
		return projectDAO.getProjectById(projId);
	}

	public void setNewProject(ProjectInput projectInput) {
		Date date=new Date(System.currentTimeMillis());
	//	Date sqlDate = new Date(System.currentTimeMillis());
		projectInput.setProjectStartDate(date);
		projectInput.setProjectStatus("O");
		Project project = projectInput.toEntity();
		projectDAO.setNewProject(project);
	}
	// Add methods for creating, updating, and deleting projects if needed
}