package com.nkxgen.spring.orm.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.nkxgen.spring.orm.model.Module;
import com.nkxgen.spring.orm.model.ModuleDTO;
import com.nkxgen.spring.orm.model.ProjectTask;

@Component
public class ModuleDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public List<ModuleDTO> getModuleDetailsByProjId(Integer projId) {
		short getProjectId = projId.shortValue();
		TypedQuery<Module> query = entityManager
				.createQuery("SELECT pt FROM Module pt WHERE pt.project.projectId = :proj_id", Module.class);
		query.setParameter("proj_id", getProjectId);

		List<Module> modules = query.getResultList();
		List<ModuleDTO> moduleDTOList = new ArrayList<>();

		for (Module module : modules) {
			ModuleDTO moduleDTO = ModuleDTO.fromEntity(module);
			moduleDTOList.add(moduleDTO);
		}

		return moduleDTOList;
	}
	
	public void save(Module module) {
		System.out.println(module);
		entityManager.persist(module);
	
	}

}
