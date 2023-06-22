package com.nkxgen.spring.orm.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nkxgen.spring.orm.dao.RoleDAO;
import com.nkxgen.spring.orm.model.Role;

@Component
@Transactional
public class RoleService {

	@Autowired
	private RoleDAO roleDAO;

	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}

	@Transactional
	public List<Role> getAllRoles() {
		return roleDAO.getAllRoles();
	}
}