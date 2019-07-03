package com.practive.course.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.practive.course.model.Credentials;
import com.practive.course.model.Role;
import com.practive.course.model.Student;
import com.practive.course.repository.StudentRepository;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent>  {
	@Autowired BCryptPasswordEncoder passwordEncoder;
	@Autowired StudentRepository studentRepo;
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		Credentials credential=new Credentials();
		Student student = new Student();
		
		credential.setUsermobile("9958258691");
		credential.setRoles(Role.ADMIN);
		credential.setUsername("kadmin");
		credential.setPassword(passwordEncoder.encode("lalaji"));
		
		student.setEmail("ksuraj@gmail.com");
		student.setMobile("9958258691");
		student.setMyname("boss");
		
		student.setCred(credential);
		studentRepo.save(student);
	}

	
	
}
