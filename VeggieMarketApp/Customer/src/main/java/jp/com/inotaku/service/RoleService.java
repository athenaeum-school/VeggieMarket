package jp.com.inotaku.service;

import java.util.List;

import jp.com.inotaku.domain.Role;

public interface RoleService {

	void saveRole(Role role);

	List<Role> findAllRole();
}
