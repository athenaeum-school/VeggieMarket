package jp.com.inotaku.dao;

import java.util.List;

import jp.com.inotaku.domain.User;


public interface UserDao {
	
	List<User> getAllUser();

	void addUser(User user);
	
	User findByUserNameAndPassword(String userName, String password);
	
	User findByUserName(String userName);
}
