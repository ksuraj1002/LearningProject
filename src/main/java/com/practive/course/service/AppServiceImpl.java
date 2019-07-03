package com.practive.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.practive.course.model.Credentials;
import com.practive.course.model.Role;
import com.practive.course.model.Student;
import com.practive.course.repository.StudentRepository;

@Service
public class AppServiceImpl implements AppService {
	@Autowired StudentRepository studentRepo;
	@Autowired BCryptPasswordEncoder passwordEncoder;
	@Autowired JavaMailSender mailSender;
	@Autowired UserDetailsService userDetailsService;
	@Autowired AuthenticationManager authenticationManager;
	@Override
	public void registerStudent(Student student, Credentials credential) {
		credential.setUsermobile(student.getMobile());
		credential.setRoles(Role.STUDENT);
		credential.setPassword(passwordEncoder.encode(credential.getPassword()));
		student.setCred(credential);
		studentRepo.save(student);
		if(student!=null) {
			System.out.println("is it null");
			sendConfirmationEmail(student.getEmail().toString());
		}
	}
	
	public void sendConfirmationEmail(String email) {
		SimpleMailMessage sm= new SimpleMailMessage();
		sm.setTo(email);
		sm.setSubject("Confirmation message");
		sm.setText("You have successfully registered");
		mailSender.send(sm);
		System.out.println(".......done");
	}

	@Override
	public void autologin(String username, String password) {
		UserDetails userDetails=userDetailsService.loadUserByUsername(username);
		UsernamePasswordAuthenticationToken token=new UsernamePasswordAuthenticationToken(username, password, userDetails.getAuthorities());
		authenticationManager.authenticate(token);
		if(token.isAuthenticated()) {
			SecurityContextHolder.getContext().setAuthentication(token);
		}
	}
}