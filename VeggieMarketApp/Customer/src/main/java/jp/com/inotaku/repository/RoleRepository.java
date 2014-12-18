package jp.com.inotaku.repository;

import java.util.List;

import jp.com.inotaku.domain.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	List<Role> findByRoleName(String roleName);

}
