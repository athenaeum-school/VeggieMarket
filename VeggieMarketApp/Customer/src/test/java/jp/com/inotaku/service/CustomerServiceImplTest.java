package jp.com.inotaku.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import jp.com.inotaku.domain.Customer;
import jp.com.inotaku.domain.Role;
import jp.com.inotaku.repository.CustomerRepository;
import jp.com.inotaku.repository.CustomerRepositoryStub;
import jp.com.inotaku.repository.RoleRepository;
import jp.com.inotaku.repository.RolerepositoryStub;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceImplTest {

	@InjectMocks
	private CustomerService customerService = new CustomerServiceImpl();

	@Mock
	private CustomerRepository customerRepository;

	@Mock
	private RoleRepository roleRepository;

	@Test
	public void findAllCustomerstest() {
		List<Customer> customers = new ArrayList<Customer>();
		doReturn(customers).when(customerRepository).findAll();
		List<Customer> actual = customerService.findAllCustomers();
		assertThat(actual, is(customers));
		verify(customerRepository).findAll();
	}

	@Test
	public void saveCustomertest() throws Exception {
		customerService.saveCustomer(new Customer());
		verify(customerRepository).save((Customer) anyObject());
	}

	@Test
	public void deleteCustomertest() throws Exception {
		customerService.deleteCustomer(1L);
		verify(customerRepository).delete(anyLong());
		verify(customerRepository, never()).delete((Customer) anyObject());
	}

	@Test
	public void saveUserCustomerStubtest() throws Exception {

		CustomerService customerService2 = new CustomerServiceImpl(
				new CustomerRepositoryStub(), new RolerepositoryStub());
		Customer customer = new Customer();
		customer.setCustomerId(1L);
		customer.setCustomerName("user");
		customer.setPassword("pass1");
		customerService2.saveUserCustomer(customer);
		List<Customer> customers = customerService2.findAllCustomers();
		assertThat(customers.get(0).get(0).getRoleName(), is("ROLE_USER"));

	}

	@Test
	public void saveUserCustomerMocktest() throws Exception {
		customerService.saveUserCustomer(new Customer());
		verify(customerRepository).save((Customer) anyObject());
		verify(roleRepository, times(2)).findByRoleName("ROLE_USER");
		verify(roleRepository).save((Role) anyObject());
	}

	@Test
	public void saveUserCustomerMock2test() throws Exception {
		Role role = new Role(1, "ROLE_USER", null);
		List<Role> roles = new ArrayList<Role>();
		roles.add(role);
		doReturn(roles).when(roleRepository).findByRoleName("ROLE_USER");
		customerService.saveCustomer(new Customer());
		verify(roleRepository, never()).save((Role) anyObject());
		verify(customerRepository).save((Customer) anyObject());
	}
}
