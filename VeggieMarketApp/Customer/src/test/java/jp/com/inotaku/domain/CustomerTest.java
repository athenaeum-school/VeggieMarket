package jp.com.inotaku.domain;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import jp.com.inotaku.repository.CustomerRepository;
import jp.com.inotaku.repository.RoleRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/resources/spring/application-config.xml")
@TransactionConfiguration(defaultRollback = false)
@Transactional
@ActiveProfiles("dev")
public class CustomerTest {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Before
	public void setUp() {
		customerRepository.deleteAll();
		roleRepository.deleteAll();
		Role userRole = new Role();
		Role adminRole = new Role();
		adminRole.setRoleName("ROLE_ADMIN");
		userRole.setRoleName("ROLE_USER");
		roleRepository.save(adminRole);
		roleRepository.save(userRole);
		Customer customer = new Customer(1, "admin", "pass1",
				roleRepository.findAll());
		Customer customer2 = new Customer(2, "user", "pass2",
				roleRepository.findByRoleName("ROLE_USER"));
		customerRepository.save(customer);
		customerRepository.save(customer2);
	}

	@Test
	public void testSave() {
		assertThat(customerRepository.findAll().get(0).get(1).getRoleName(),
				is("ROLE_USER"));
		assertThat(customerRepository.findByCustomerName("admin").get(0).get(1)
				.getRoleName(), is("ROLE_USER"));
		System.out.println(customerRepository.findAll());
	}

	@Test
	public void testDelete() throws Exception {
		customerRepository.delete(customerRepository.findByCustomerName("user")
				.get(0));
		assertThat(customerRepository.findAll().size(), is(1));
	}
}
