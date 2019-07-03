package com.practive.course.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/admin",method=RequestMethod.GET)
public class AdminController {
	@GetMapping("/dashboard")
	public String getAdminDashboard() {
		return "admin/dashboard";
	}
}
