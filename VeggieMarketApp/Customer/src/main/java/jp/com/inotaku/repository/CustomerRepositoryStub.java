package jp.com.inotaku.repository;

import java.util.ArrayList;
import java.util.List;

import jp.com.inotaku.domain.Customer;
import lombok.experimental.Delegate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class CustomerRepositoryStub implements CustomerRepository {

	@Delegate
	private List<Customer> customerList = new ArrayList<Customer>();

	@Override
	public List<Customer> findAll() {
		return customerList;
	}

	@Override
	public List<Customer> findAll(Sort sort) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public List<Customer> findAll(Iterable<Long> ids) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public <S extends Customer> List<S> save(Iterable<S> entities) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void flush() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public <S extends Customer> S saveAndFlush(S entity) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<Customer> entities) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void deleteAllInBatch() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public Customer getOne(Long id) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Page<Customer> findAll(Pageable pageable) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public <S extends Customer> S save(S entity) {
		customerList.add(entity);
		return null;
	}

	@Override
	public Customer findOne(Long id) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public boolean exists(Long id) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public long count() {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public void delete(Long id) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void delete(Customer entity) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void delete(Iterable<? extends Customer> entities) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void deleteAll() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public List<Customer> findByCustomerName(String customerName) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
