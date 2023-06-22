package com.nkxgen.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductivityController {
	@Autowired
	public void start() {

	}

	/*
	 * @RequestMapping(value = "/") public String dummy(Model model) { System.out.println("here"); return "hello"; }
	 */

	@RequestMapping(value = "/prod", method = RequestMethod.GET)
	public String index(Model model) {
		return "productivity";
	}

	@RequestMapping(value = "/dash", method = RequestMethod.GET)
	public String dash(Model model) {
		return "dash";
	}

	@RequestMapping(value = "/ana", method = RequestMethod.GET)
	public String analytics(Model model) {
		return "ana";
	}

	@RequestMapping(value = "/pastdue", method = RequestMethod.GET)
	public String pastdue(Model model) {
		return "pastdue";
	}

	@RequestMapping(value = "/resource", method = RequestMethod.GET)
	public String resource(Model model) {
		return "AddResource";
	}

	@RequestMapping(value = "/project", method = RequestMethod.GET)
	public String project(Model model) {
		System.out.println("project called");
		return "project";
	}

	// @RequestMapping(value = "/sprint", method = RequestMethod.GET)
	// public String sprint(Model model) {
	// System.out.println("project called");
	// return "sprint_home";
	// }

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String getdashboard(Model model) {
		System.out.println("project called");
		return "dashboard";
	}

	@RequestMapping(value = "/analytics", method = RequestMethod.GET)
	public String getanalytics(Model model) {
		System.out.println("project called");
		return "analytics";
	}

	// @RequestMapping(value = "/backlog", method = RequestMethod.GET)
	// public String getmodules(Model model) {
	// System.out.println("backlog called");
	// return "backlog";
	// }
}