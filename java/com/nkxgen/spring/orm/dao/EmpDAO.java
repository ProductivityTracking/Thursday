package com.nkxgen.spring.orm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.nkxgen.spring.orm.model.Employee;

@Component
public class EmpDAO {

    @PersistenceContext
    private EntityManager em;

    public void persist(Employee emp) {
        em.persist(emp);
    }

    public List<Employee> getAllEmployees() {
        String jpql = "SELECT e FROM Employee e";
        Query query = em.createQuery(jpql);
        return query.getResultList();
    }

    public boolean deleteEmployeeById(int id) {
        Employee employee = em.find(Employee.class, id);
        if (employee != null) {
            em.remove(employee);
            return true;
        }
        return false;
    }

    @Transactional
    public boolean updateEmployee(Employee emp) {
        Employee existingEmployee = em.find(Employee.class, emp.getEmpNo());
        if (existingEmployee != null) {
            // Update the existing employee with the new values
            existingEmployee.setEName(emp.getEName());
            existingEmployee.setSalary(emp.getSalary());
            existingEmployee.setJob(emp.getJob());
            existingEmployee.setDeptNo(emp.getDeptNo());

            // Persist the changes to the database
            em.merge(existingEmployee);

            return true;
        }

        return false;
    }

}
