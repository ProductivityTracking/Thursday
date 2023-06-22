package com.nkxgen.spring.orm.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.nkxgen.spring.orm.model.PTFilterCriteria;
import com.nkxgen.spring.orm.model.ProjectTask;
import com.nkxgen.spring.orm.model.ProjectTaskDTO;

@Component
@Transactional
public class ProjectTaskdao {
	@PersistenceContext
	private EntityManager entityManager;

	public ProjectTask save(ProjectTask projectTask) {
		System.out.println(projectTask);
		entityManager.persist(projectTask);
		return projectTask;
	}

	public ProjectTask findById(int taskId) {
		return entityManager.find(ProjectTask.class, taskId);
	}

	public void delete(ProjectTask projectTask) {
		entityManager.remove(projectTask);
	}

	public List<ProjectTaskDTO> getProjectTaskDTOList() {
		TypedQuery<ProjectTask> query = entityManager.createQuery("SELECT pt FROM ProjectTask pt", ProjectTask.class);
		List<ProjectTask> projectTasks = query.getResultList();

		List<ProjectTaskDTO> convertedTasks = projectTasks.stream().map(ProjectTaskDTO::fromEntity)
				.collect(Collectors.toList());

		return convertedTasks;
	}

	public ProjectTaskDTO getProjectTaskById(int taskId) {
		ProjectTask projectTask = findById(taskId);
		if (projectTask == null) {
			return null;
		}

		return ProjectTaskDTO.fromEntity(projectTask);
	}

	public List<ProjectTaskDTO> filterTasks(PTFilterCriteria filterCriteria) {
		Short projectId = filterCriteria.getProjectId();
		Integer resourceId = filterCriteria.getResourceId();

		List<ProjectTask> filteredTasks;

		if (projectId != null && resourceId != null) {
			// Filter by both project and resource
			TypedQuery<ProjectTask> query = entityManager.createQuery(
					"SELECT pt FROM ProjectTask pt WHERE pt.project.id = :projectId AND pt.assignedUser.id = :resourceId",
					ProjectTask.class);
			query.setParameter("projectId", projectId);
			query.setParameter("resourceId", resourceId);
			filteredTasks = query.getResultList();
		} else if (projectId == null && resourceId != null) {
			// Filter by resource only
			TypedQuery<ProjectTask> query = entityManager.createQuery(
					"SELECT pt FROM ProjectTask pt WHERE pt.assignedUser.id = :resourceId", ProjectTask.class);
			query.setParameter("resourceId", resourceId);
			filteredTasks = query.getResultList();

		} else if (projectId != null && resourceId == null) {
			// Filter by project only
			TypedQuery<ProjectTask> query = entityManager
					.createQuery("SELECT pt FROM ProjectTask pt WHERE  pt.project.id  = :projectId", ProjectTask.class);
			query.setParameter("projectId", projectId);
			filteredTasks = query.getResultList();
		} else {
			// No filtering criteria provided, retrieve all tasks
			TypedQuery<ProjectTask> query = entityManager.createQuery("SELECT pt FROM ProjectTask pt",
					ProjectTask.class);
			filteredTasks = query.getResultList();
		}

		List<ProjectTaskDTO> filteredTaskDTOs = new ArrayList<>();
		for (ProjectTask projectTask : filteredTasks) {
			ProjectTaskDTO dto = ProjectTaskDTO.fromEntity(projectTask);
			filteredTaskDTOs.add(dto);
		}

		return filteredTaskDTOs;
	}

	// Other methods for fetching, updating, and deleting project tasks
}