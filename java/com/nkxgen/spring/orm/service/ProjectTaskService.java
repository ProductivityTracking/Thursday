package com.nkxgen.spring.orm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nkxgen.spring.orm.dao.ProjectTaskdao;
import com.nkxgen.spring.orm.model.PTFilterCriteria;
import com.nkxgen.spring.orm.model.ProjectTask;
import com.nkxgen.spring.orm.model.ProjectTaskDTO;

@Service
public class ProjectTaskService {
	private final ProjectTaskdao projectTaskdao;

	@Autowired
	public ProjectTaskService(ProjectTaskdao projectTaskdao) {
		this.projectTaskdao = projectTaskdao;
	}

	public ProjectTask createProjectTask(ProjectTask projectTask) {
		// Additional business logic, if needed
		return projectTaskdao.save(projectTask);
	}

	// public List<ProjectTask> getAllProjectTasks() {
	// return projectTaskdao.getProjectTaskDTOList();
	// }

	public List<ProjectTaskDTO> getProjectTaskDTOList() {
		// TODO Auto-generated method stub
		return projectTaskdao.getProjectTaskDTOList();
	}

	public ProjectTaskDTO getProjectTaskById(int taskId) {
		// TODO Auto-generated method stub
		return projectTaskdao.getProjectTaskById(taskId);
	}

	public List<ProjectTaskDTO> filterTasks(PTFilterCriteria filterCriteria) {

		return projectTaskdao.filterTasks(filterCriteria);
	}

	// Other service methods for updating, deleting project tasks
}