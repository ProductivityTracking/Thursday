package com.nkxgen.spring.orm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.nkxgen.spring.orm.model.Role;

@Component
public class RoleDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Role> getAllRoles() {
		return entityManager.createQuery("SELECT r FROM Role r", Role.class).getResultList();
	}

	public Role findById(short id) {
		return entityManager.find(Role.class, id);
	}
}