/*package com.practive.course.configure;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.practive.course.model.Credentials;

@Component
public class CredentialValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Credentials.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		 Credentials credential = (Credentials) target;
		    
    	 System.out.println(credential.getUsername());
    	 System.out.println("below");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        System.out.println("above");
		
	}
	
}

*/