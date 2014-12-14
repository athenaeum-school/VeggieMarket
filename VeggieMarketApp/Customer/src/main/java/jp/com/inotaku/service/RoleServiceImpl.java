package jp.com.inotaku.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.com.inotaku.domain.Role;
import jp.com.inotaku.repository.RoleRepository;

@Service("roleservice")
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public void saveRole(Role role) {
		role.setRoleName("ROLE_USER");
		roleRepository.save(role);
	}

	@Override
	public List<Role> findAllRole() {
		return roleRepository.findAll();
	}

}
