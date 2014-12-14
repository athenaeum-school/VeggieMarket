package jp.com.inotaku.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import jp.com.inotaku.domain.User;
import jp.com.inotaku.service.UserService;

public class LoginValidator implements ConstraintValidator<Login, User> {
	
	@Autowired
	private UserService userService;

	@Override
	public void initialize(Login constraintAnnotation) {
		
	}

	@Override
	public boolean isValid(User value, ConstraintValidatorContext context) {
		try {
			userService.getUserByUserNameAndPassword(value.getUserName(), value.getPassword());
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
