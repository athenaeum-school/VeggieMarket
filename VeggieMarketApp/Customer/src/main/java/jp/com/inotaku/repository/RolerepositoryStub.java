package jp.com.inotaku.repository;

import java.util.ArrayList;
import java.util.List;

import jp.com.inotaku.domain.Role;
import lombok.experimental.Delegate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class RolerepositoryStub implements RoleRepository {

	@Delegate
	private List<Role> roleList = new ArrayList<Role>();

	@Override
	public List<Role> findAll() {
		return roleList;
	}

	@Override
	public List<Role> findAll(Sort sort) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public List<Role> findAll(Iterable<Long> ids) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public <S extends Role> List<S> save(Iterable<S> entities) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void flush() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public <S extends Role> S saveAndFlush(S entity) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<Role> entities) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void deleteAllInBatch() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public Role getOne(Long id) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Page<Role> findAll(Pageable pageable) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public <S extends Role> S save(S entity) {
		roleList.add(entity);
		return null;
	}

	@Override
	public Role findOne(Long id) {
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
	public void delete(Role entity) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void delete(Iterable<? extends Role> entities) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void deleteAll() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public List<Role> findByRoleName(String roleName) {
		return roleList;

	}

}
