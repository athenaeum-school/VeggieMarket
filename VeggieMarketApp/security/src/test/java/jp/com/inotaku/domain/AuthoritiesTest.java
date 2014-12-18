package jp.com.inotaku.domain;

import static org.junit.Assert.*;
import jp.com.inotaku.repository.AuthoritiesRepository;
import jp.com.inotaku.repository.UserRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/application-config.xml")
public class AuthoritiesTest {
	
	@Autowired
	private UserRepository userRipository;
	
	@Autowired
	private AuthoritiesRepository authoritiesRipository;
	
	private User user1;
	
	private Authorities authorities1;
	
	@Before
	public void init(){
		/*user1 = new User("user", "user", true);
		userRipository.save(user1);
		authorities1 = new Authorities("ROLE_USER");
		authoritiesRipository.save(authorities1);*/
		authorities1 = new Authorities();
		authoritiesRipository.save(authorities1);
	}

	@Test
	public void test() {
		System.out.println(authoritiesRipository.findAll());
	}

}
