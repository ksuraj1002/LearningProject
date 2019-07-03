package com.practive.course.service;

import com.practive.course.model.Credentials;
import com.practive.course.model.Student;

public interface AppService {

	void registerStudent(Student student, Credentials credential);

	void autologin(String username, String password);

}
