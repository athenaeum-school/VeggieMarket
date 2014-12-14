package jp.com.inotaku.service;

import java.util.List;

import jp.com.inotaku.domain.User;

public interface UserService {

	public abstract List<User> getUserList();

	public abstract User getUserByUserNameAndPassword(String userName,
			String password);

	public abstract void addUser(User user);
	
	boolean isUnusedUserName(String userName);


}