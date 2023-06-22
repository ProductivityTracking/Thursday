package com.nkxgen.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.nkxgen.spring.orm.model.ProjectDto;
import com.nkxgen.spring.orm.model.ProjectFilter;
import com.nkxgen.spring.orm.model.ProjectInput;
import com.nkxgen.spring.orm.model.User;
import com.nkxgen.spring.orm.service.ProjectService;
import com.nkxgen.spring.orm.service.ResourceService;

@RestController
public class ProjectController {
	private final ProjectService projectService;
	private final ResourceService resourceService;

	@Autowired
	public ProjectController(ProjectService projectService,ResourceService resourceService) {
		this.projectService = projectService;
		this.resourceService=resourceService;
	}

	@RequestMapping(value = "/projects", method = RequestMethod.GET)
	public String getAllProjects(Model model) {
		List<ProjectDto> projectDto = projectService.getAllProjects();

		model.addAttribute("projectDto", projectDto);
		return "emplist";
	}

	@RequestMapping(value = "/projectfilter", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String filterProjects(@Validated ProjectFilter projectFilter) {
		System.out.println(projectFilter.getProjectId());
		System.out.println(projectFilter.getStatus());
		System.out.println("System.out.println(\"getFilterProjects called\"); called");
		
		
		List<ProjectDto> filteredProjects = projectService.filterProjects(projectFilter);
		System.out.println("filteredProjects");

		Gson gson = new Gson();
		String json = gson.toJson(filteredProjects);

		return json;
	}
	@RequestMapping(value = "/savenewproject", method = RequestMethod.GET)
	public String setNewProjectData(@Validated ProjectInput projectInput, Model model) {
		System.out.println("proj manager " + projectInput.getProjectManager());
		projectService.setNewProject(projectInput);
		return "redirect:/projects";

	}

	@RequestMapping(value = "/projectDetails", method = RequestMethod.GET)
	public String projectDetails(@RequestParam("projectId") Integer projectId, Model model) {
		// Retrieve the selected sprint details from the database and add them to the model
		ProjectDto projectDto = projectService.getProjectById(projectId);
		model.addAttribute("projectDto", projectDto);
		System.out.println("here " + projectDto);
		// Return the appropriate view or redirect
		return "projectDetails"; // Replace with your desired view name
	}

	@RequestMapping(value = "/createproject", method = RequestMethod.GET)
	public String setNewProject(Model model) {
		List<User> allMngs = resourceService.getAllProjManagers();
		System.out.println("proj mngs " + allMngs);
		System.out.println("add new project jsp called");
		model.addAttribute("allMngs", allMngs);
		return "safety";
	}

	@RequestMapping(value = "/resourceDetailsByProjId", method = RequestMethod.GET)
	public String getResourceDetailsByProjectId(@RequestParam("projectId") int projectId, Model model) {
		List<User> resources = resourceService.getUsersByProjectId(projectId);
		System.out.println("resources " + resources);
		model.addAttribute("resources", resources);
		return "projectResourceDetails";
	}

}
// @PostMapping
// public ProjectDto createProject(@RequestBody ProjectInput projectInput) {
// return projectService.createProject(projectInput);
// }