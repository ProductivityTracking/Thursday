package com.nkxgen.spring.orm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nkxgen.spring.orm.dao.SprintDAO;
import com.nkxgen.spring.orm.model.FunctionalUnit;
import com.nkxgen.spring.orm.model.ModuleDTO;
import com.nkxgen.spring.orm.model.Sprint;
import com.nkxgen.spring.orm.model.SprintTasks;
import com.nkxgen.spring.orm.model.Task;

@Service
public class SprintService implements SprintServiceInt {
	private final SprintDAO sprintDAO;

	@Autowired
	public SprintService(SprintDAO sprintDAO) {
		this.sprintDAO = sprintDAO;
	}

	@Override
	public List<Sprint> getBacklogs() {
		return sprintDAO.getBaskLogs();
	}

	@Override
	public Sprint getSprintDetails(int sprintId) {
		return sprintDAO.getSprintDetails(sprintId);
	}

	@Override
	public List<Task> getTasks(int modlId) {
		return sprintDAO.getTasks(modlId);
	}

	@Override
	public List<Sprint> getAllSprints() {
		return sprintDAO.getAllSprints();
	}

	@Override
	public List<SprintTasks> getAllTasksBySprintId(Integer sprintId) {
		return sprintDAO.allTaskBySprintId(sprintId);
	}

	@Override
	public void storeSprint(Sprint sprint) {
		sprintDAO.storeSprint(sprint);
	}

	@Override
	public List<ModuleDTO> getSprintModulesByProjectId(int projectId) {
		return sprintDAO.getSprintModulesByProjectId(projectId);
	}

	@Override
	public List<FunctionalUnit> getFunctionalUnitsByModId(int modlId) {
		return sprintDAO.getFunctionalUnitsByModId(modlId);
	}
}
