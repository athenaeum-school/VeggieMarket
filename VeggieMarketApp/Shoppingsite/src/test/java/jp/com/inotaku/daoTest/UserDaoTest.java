package jp.com.inotaku.daoTest;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;


import jp.com.inotaku.dao.UserDao;
import jp.com.inotaku.domain.User;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/*.xml")
public class UserDaoTest {

	@Autowired
	private UserDao userDao;

	private User user1;
	private User user2;

	@Before
	public void setup() {
		user1 = new User("ユーザー1", "pass1");
		user2 = new User("ユーザー2", "bbb");
	}

	@Test
	public void testAddUser() {
		userDao.addUser(user1);
		userDao.addUser(user2);
		List<User> userList = userDao.getAllUser();
		assertThat("ユーザー1", is(userList.get(0).getUserName()));
		assertThat("bbb", is(userList.get(1).getPassword()));
	}

	@Test
	public void testFindByUserNameAndPassword() {
		User newUser1 = userDao.findByUserNameAndPassword("ユーザー1", "pass1");
		assertThat("ユーザー1", is(newUser1.getUserName()));
		try {
			User newuser2 = userDao.findByUserNameAndPassword("a", "b");
			System.out.println(newuser2);
		} catch (Exception e) {
		}

	}

}
