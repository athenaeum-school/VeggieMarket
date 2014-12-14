package jp.com.inotaku.controllerTest;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import jp.com.inotaku.controller.UserController;
import jp.com.inotaku.domain.User;
import jp.com.inotaku.service.ItemService;
import jp.com.inotaku.service.UserService;

import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;

public class UserControllerTest extends AbstractControllerTest {

	List<User> users = new ArrayList<User>();
	
	private UserService userService;
	
	@Test
	public void testToLoginView() {
	}

	@Test
	public void testOnSubmit() {
	}

	@Test
	public void testToUserEntryView() {
	}

	@Test
	public void testAddUser() {
		final User newUser =  new User();
		newUser.setUserName("Taro");
		newUser.setPassword("aaa");

		userService = mock(UserService.class);
		doAnswer(new Answer<Object>() {
			public Object answer(InvocationOnMock invocation) throws Throwable {
				users.add(newUser);
				return null;
			}
		}).when(userService).addUser(newUser);
		
		UserController userController = new UserController();
		ReflectionTestUtils.setField(userController, "userService", userService);
		
		BindingResult bindingResult = new BeanPropertyBindingResult(newUser, "user");
		ExtendedModelMap model = new ExtendedModelMap();
		String result = userController.addUser(newUser, bindingResult, model);
		assertThat("userEntrySuccess", is(result));
		
		assertThat("Taro", is(users.get(0).getUserName()));
		System.out.println(users);
		assertThat(1, is(users.size()));
		
	}

}
