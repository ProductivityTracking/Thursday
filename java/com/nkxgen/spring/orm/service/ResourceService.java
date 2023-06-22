package com.nkxgen.spring.orm.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.nkxgen.spring.orm.dao.ResourceDAO;
import com.nkxgen.spring.orm.model.ResourceFilter;
import com.nkxgen.spring.orm.model.User;
import com.nkxgen.spring.orm.model.UserDto;
import com.nkxgen.spring.orm.model.UserInput;

@Component
@Transactional
public class ResourceService {

	private final ResourceDAO resourceDAO;

	@Autowired
	public ResourceService(ResourceDAO resourceDAO) {
		this.resourceDAO = resourceDAO;
	}

	public List<UserDto> getAllResources() {
		return resourceDAO.getAllResources();
	}

	public List<UserDto> filterResources(ResourceFilter ResourceFilter) {
		Short roleFilter = ResourceFilter.getRoleFilter();
		Short projectFilter = ResourceFilter.getProjectFilter();
		System.out.println("in service ");
		System.out.println("roleFilter is " + roleFilter);
		System.out.println("projectFilter is " + projectFilter);
		List<UserDto> UserDto = resourceDAO.filterResources(roleFilter, projectFilter);
		return UserDto;
	}

	public User getResourceByDisplayName(String displayName) {
		return resourceDAO.getResourceByDisplayName(displayName);
	}

	public void addUser(UserInput userinput) {
		User user = userinput.toEntity();
		resourceDAO.addUser(user);
	}

	public void save(UserInput existingResource) {

		existingResource.setUserCreationDate(existingResource.getUserCreationDate());
		existingResource.setUserLastUpdatedDate(new Date());

		User user = existingResource.toEntity();
		resourceDAO.saveUser(user);

	}

	public List<User> getAllProjManagers() {
		return resourceDAO.getAllProjManagers();
	}

	public List<User> getUsersByProjectId(int projectId) {
		List<User> user = resourceDAO.getUsersByProjectId(projectId);
		return user;
	}
}