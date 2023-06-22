package com.nkxgen.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nkxgen.spring.orm.model.Employee;
import com.nkxgen.spring.orm.service.EmpService;

@Controller
public class EmpCRUDController {

	EmpService eserv;

	@Autowired
	 public EmpCRUDController(EmpService empserv) {
	 eserv = empserv;
	 }

	/**
	 * selects the Add New Employee view to render by returning its name.
	 */
	@RequestMapping(value = "/emplist", method = RequestMethod.GET)
	public String getAllEmployees(Model model) {
		System.out.println("Employees List JSP Requested");

		// get all employees from DAO
		List<Employee> empList = eserv.listAll();

		// set it to the model
		model.addAttribute("elist", empList);

		// call the view
		return "emplist";
	}

	@RequestMapping(value = "/addnewemp", method = RequestMethod.GET)
	public String addNewEmployee(Model model) {
		System.out.println("Add New Emp JSP Requested");
		return "newemp";
	}

	@RequestMapping(value = "/savenewemp", method = RequestMethod.POST)
	public String saveNewEmployee(@Validated Employee emp, Model model) {
		System.out.println("Save New Employee Page Requested");
		// get all employees from DAO
		eserv.add(emp);

		// set it to the model
		model.addAttribute("emp", emp);

		return "saveempsuccess";
	}

	@RequestMapping(value = "/deleteemp", method = RequestMethod.GET)
	public String deleteEmployee(Model model) {
		System.out.println("delete  Emp JSP Requested");
		return "deleteemp";
	}

	@RequestMapping(value = "/deleteemp", method = RequestMethod.POST)
	public String deleterecord(@Validated Employee emp, Model model) {
		System.out.println("delete Employee Page Requested");
		// get all employees from DAO
		boolean b = eserv.delete(emp);

		// set it to the model
		if (b) {
			model.addAttribute("emp", emp);
		}
		return "deletenewsuccess";
	}

}