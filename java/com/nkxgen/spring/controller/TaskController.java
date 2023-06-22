package com.nkxgen.spring.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.nkxgen.spring.orm.model.TFilterCriteria;
import com.nkxgen.spring.orm.model.Task;
import com.nkxgen.spring.orm.model.TaskDto;
import com.nkxgen.spring.orm.service.TaskService;

@Controller
public class TaskController {

	private final TaskService taskService;

	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}


	@RequestMapping(value = "/tasksbyid", method = RequestMethod.GET)
	public String viewTasksForUser(Model model) {
		// Use the userId to fetch the tasks
		int userId = 1; // Replace with actual userId
		List<TaskDto> tasks = taskService.getTasksByUserId(userId);

		// Add the tasks to the model
		model.addAttribute("tasks", tasks);

		// Return the view name
		return "Taskslist"; // Replace with actual view name
	}

	@RequestMapping(value = "/tasks", method = RequestMethod.GET)
	public String viewAllTasks(Model model) {
		// Use the userId to fetch the tasks
		// Replace with actual userId
		List<TaskDto> tasks = taskService.getAllTasks();

		// Add the tasks to the model
		model.addAttribute("tasks", tasks);

		// Return the view name
		return "Taskslist"; // Replace with actual view name
	}

	@RequestMapping(value = "/taskdetailsbyid", method = RequestMethod.GET)
	public String getAllTasks(Model model) {

		List<TaskDto> tasks = taskService.getAllTasks();

		model.addAttribute("tasks", tasks);

		return "tasksdetailsbyid";
	}

	@RequestMapping(value = "/updateTaskStatus", method = RequestMethod.POST)
	public String updateTaskStatus(@RequestParam("taskId") int taskId, Model model) {
		// Retrieve the existing task from the database using the task ID
		Task task = taskService.getTaskById(taskId);
		model.addAttribute("task", task);
		return "Taskslist";
	}

	@RequestMapping(value = "/updateSuccess", method = RequestMethod.POST)
	public String updateTaskStatusSuccess(@RequestParam("taskId") int taskId) {

		// Retrieve the existing task from the database using the task ID
		Boolean task = taskService.updateStatus(taskId);

		// Update the task status

		// Redirect to the task list page or show a success message
		return "redirect:/tasks";
	}

	@PostMapping(value = "/Taskfilter", produces = "application/json")
	@ResponseBody
	public String PtfilterTasks(@Validated  TFilterCriteria filterCriteria, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			// Handle validation errors
			// Return appropriate error response
			return "Validation Error";
		}
		System.out.println(filterCriteria.getTaskSupervisorId());
		List<TaskDto> filteredTasks = taskService.PtfilterTasks(filterCriteria);

		Gson gson = new Gson();
		String json = gson.toJson(filteredTasks);

		// Return the JSON response
		return json;
	}

}
