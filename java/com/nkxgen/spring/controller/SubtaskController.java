package com.nkxgen.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nkxgen.spring.orm.service.SubtaskService;

@Controller
public class SubtaskController {

	@Autowired
	public SubtaskService subtaskService;

	@RequestMapping(value = "/saveSubtask", method = RequestMethod.GET)
	public String saveSubtask(Model model) {
		// public String saveSubtask(@Validated SubtaskInput subtaskInput,Model model) {
		// System.out.println("this is the object " + subtaskInput.getNumberOfHours());
		// subtaskService.setNewSubTask(subtaskInput);
		// Convert SubtaskDto to Subtask entity
		return "Tasklist";
	}

	@RequestMapping(value = "/createSubtask", method = RequestMethod.GET)
	public String getSubtaskform(Model model) {
		// Retrieve the existing task from the database using the task ID

		return "createsubtask";
	}
}
