package com.nkxgen.spring.orm.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nkxgen.spring.orm.model.Module;
import com.nkxgen.spring.orm.dao.ModuleDAO;
import com.nkxgen.spring.orm.model.ModuleDTO;
import com.nkxgen.spring.orm.model.ModuleInput;
import com.nkxgen.spring.orm.model.ProjectTask;

@Service
@Transactional
public class ModuleService {
	private final ModuleDAO moduleDao;

	@Autowired
	public ModuleService(ModuleDAO moduleDAO) {
		this.moduleDao = moduleDAO;
	}

	public List<ModuleDTO> getModuleByProjId(Integer projId) {
		return moduleDao.getModuleDetailsByProjId(projId);
	}
	public void createModule(ModuleInput moduleinput) {
		// Additional business logic, if needed
		
		Module module= moduleinput.toEntity();
		moduleDao.save(module);
		
	}
	
}
