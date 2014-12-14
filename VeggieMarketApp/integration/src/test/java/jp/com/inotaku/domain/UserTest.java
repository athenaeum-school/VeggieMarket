package jp.com.inotaku.domain;

import static org.junit.Assert.*;
<<<<<<< HEAD
=======
import static org.hamcrest.CoreMatchers.*;

import java.util.List;

>>>>>>> Customer
import jp.com.inotaku.dao.BlogDao;
import jp.com.inotaku.domain.User;
import jp.com.inotaku.repository.UserRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/application-config.xml")
public class UserTest {

	@Autowired
	private UserRepository userRipository;
	
	private User user1;
	private User user2;
	
	@Before
	public void init(){
		user1 = new User("user", "user", true);
		user2 = new User("admin", "admin", true);
		userRipository.save(user1);
		userRipository.save(user2);
	}
	
	@Test
	public void test() {
		List<User> userList = userRipository.findAll();
		assertThat(userList.size(), is(2));
		assertThat(userList.get(0).getUserName(), is("user"));
		User newUser = userRipository.findOne("admin");
		assertThat(newUser.getPassword(), is(user2.getPassword()));
		
	}

}
