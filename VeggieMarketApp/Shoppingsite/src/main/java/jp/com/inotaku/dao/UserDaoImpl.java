package jp.com.inotaku.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import jp.com.inotaku.domain.User;

@Component
@Transactional(propagation = Propagation.REQUIRED)
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void addUser(User user) {
		em.persist(user);
	}

	@Override
	public User findByUserNameAndPassword(String userName, String password) {
		return (User) em
				.createQuery(
						"from User where userName = :userName and password = :password")
				.setParameter("userName", userName)
				.setParameter("password", password).getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUser() {
		return em.createQuery("from User").getResultList();
	}

	@Override
	public User findByUserName(String userName) {
		return (User) em.createQuery("from User where userName = :userName")
				.setParameter("userName", userName).getSingleResult();
	}

}
