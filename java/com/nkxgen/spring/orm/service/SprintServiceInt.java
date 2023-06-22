package com.nkxgen.spring.orm.service;

import java.util.List;

import com.nkxgen.spring.orm.model.FunctionalUnit;
import com.nkxgen.spring.orm.model.ModuleDTO;
import com.nkxgen.spring.orm.model.Sprint;
import com.nkxgen.spring.orm.model.SprintTasks;
import com.nkxgen.spring.orm.model.Task;

public interface SprintServiceInt {
	List<Sprint> getBacklogs();

	Sprint getSprintDetails(int sprintId);

	List<Task> getTasks(int modlId);

	List<Sprint> getAllSprints();

	List<SprintTasks> getAllTasksBySprintId(Integer sprintId);

	void storeSprint(Sprint sprint);

	List<ModuleDTO> getSprintModulesByProjectId(int projectId);

	List<FunctionalUnit> getFunctionalUnitsByModId(int modlId);
}