package com.practive.course.configure;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.practive.course.model.Credentials;
import com.practive.course.model.Student;

@Component
public class StudentValidator implements Validator {
	
	   public void validate(Object target, Errors errors) {
	    	 Student student = (Student) target;
	    
	    	 System.out.println(student.getMyname());
	    	 System.out.println("below");
	     //   ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
	        System.out.println("above");
	        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "field.required");
	        
	        if(student.getMyname().isEmpty()) {
	        	errors.rejectValue("myname", "NotEmpty");
	        }
	       
	       
	    }
	   
    public boolean supports(Class<?> clazz) {
        return Student.class.equals(clazz);
    }

 }