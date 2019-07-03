package com.practive.course.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/student",method=RequestMethod.GET)
public class StudentController {

	@GetMapping("/dashboard")
	public String getStudentDashboard() {
		return "dashboard";
	}
}
