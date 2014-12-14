package jp.com.inotaku.service;

import java.util.List;

import jp.com.inotaku.dao.UserDao;
import jp.com.inotaku.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> getUserList(){
		return userDao.getAllUser();
	}
	
	@Override
	public User getUserByUserNameAndPassword(String userName, String password){
		return userDao.findByUserNameAndPassword(userName, password);
	}
	
	@Override
	public void addUser(User user){
		userDao.addUser(user);
	}

	@Override
	public boolean isUnusedUserName(String userName) {
		try {
			userDao.findByUserName(userName);
		} catch (Exception e) {
			return true;
		}
		return false;
	}

}
