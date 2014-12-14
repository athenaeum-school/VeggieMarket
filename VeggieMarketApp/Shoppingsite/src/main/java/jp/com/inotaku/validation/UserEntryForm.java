package jp.com.inotaku.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import jp.com.inotaku.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

public class UserEntryForm implements ConstraintValidator<UserCheck, String> {

	@Autowired
	private UserService userService;
	
	@Override
	public void initialize(UserCheck constraintAnnotation) {
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return userService.isUnusedUserName(value);
	}

}
