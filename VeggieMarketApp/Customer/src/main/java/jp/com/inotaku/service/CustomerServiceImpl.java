package jp.com.inotaku.service;

import java.util.List;

import jp.com.inotaku.domain.Customer;
import jp.com.inotaku.domain.Role;
import jp.com.inotaku.repository.CustomerRepository;
import jp.com.inotaku.repository.RoleRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@NoArgsConstructor
@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public List<Customer> findAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public void saveCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	@Override
	public void deleteCustomer(long customerId) {
		customerRepository.delete(customerId);
	}

	@Override
	public void saveUserCustomer(Customer customer) {

		if (roleRepository.findByRoleName("ROLE_USER").size() == 0) {
			Role role = new Role();
			role.setRoleName("ROLE_USER");
			roleRepository.save(role);
		}
		customer.setRoleList(roleRepository.findByRoleName("ROLE_USER"));
		customerRepository.save(customer);
	}

}
