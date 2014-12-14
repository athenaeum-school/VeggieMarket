package jp.com.inotaku.domain.customer;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;

import jp.com.inotaku.domain.Customer;
import jp.com.inotaku.service.CustomerService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/spring/application*.xml")
@Transactional
public class CustomerTest {

	@Autowired
	private CustomerService customerService;
	
	private Customer customer1;
	private Customer customer2;
	
	@Before
	public void init(){
		customer1 = new Customer(1, 1, "0001");
		customer2 = new Customer(2, 2, "0002");
		customerService.saveCustomer(customer1);
		customerService.saveCustomer(customer2);
	}
	
	@Test
	public void test() {
		List<Customer> customers = customerService.findAllCustomers();
		assertThat(customers.get(0).getCustomerId(), is(1L));
		assertThat(customers.get(1).getLocaleCode(), is("0002"));
		
	}

}
