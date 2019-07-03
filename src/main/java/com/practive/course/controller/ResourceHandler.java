package com.practive.course.controller;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.practive.course.configure.StudentValidator;
import com.practive.course.model.Credentials;
import com.practive.course.model.Role;
import com.practive.course.model.Student;
import com.practive.course.repository.CredentialsRepository;
import com.practive.course.repository.StudentRepository;
import com.practive.course.service.AppService;

@Controller
public class ResourceHandler {
	@Autowired AppService appService;
	@Autowired StudentValidator validator;
	@Autowired StudentRepository studentRepo;
	@Autowired CredentialsRepository credRepository;
	
	@GetMapping("/")
	public String getIndexwithSlash() {
		return "redirect:/index";
	}
	
	@GetMapping("/index")
	public String getIndexwithoutSlash() {
		return "index";
	}
	
	@GetMapping("/registration")
	public String getRegister(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("cred", new Credentials());
		return "registration";
	}
	
	@PostMapping("/registration")
	public String postRegister(Student student,Credentials credential,BindingResult bindingResult,RedirectAttributes redirect) {
		String password=credential.getPassword();
		appService.registerStudent(student, credential);
		try{
			System.out.println(credential.getPassword());
			appService.autologin(credential.getUsername(),password);
		}catch(Exception e) {
			System.out.println("if exception is "+e.getMessage());
		}
		System.out.println("above");
		return "redirect:/dashboard";
	}
	
	@GetMapping("/dashboard")
	public String getDashboard(Principal principal) {
		Credentials credential=credRepository.findUserDetails(principal.getName());
		System.out.println("role is here "+credential.getRoles().toString());
		return "redirect:/"+credential.getRoles().toString().toLowerCase()+"/dashboard";
	}
	
	@GetMapping("/failure")
	public String getFailure() {
		return "failure";
	}
	
	@GetMapping("/login")
	public String getLogin(Optional<String> errors ) {
		
		return "/login";
	}
}
