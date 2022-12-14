package com.study.service;

import com.study.domain.User;
import com.study.repository.UserRepository;

public class AccountService {
	private static AccountService instance = null;
	
	private AccountService() {}
	
	public static AccountService getInstance() {
		if (instance == null) {
			instance = new AccountService();
		}
		return instance;
	}

	
	public boolean idDuplicateUsername(String username) {
		User user = UserRepository.getInstance().findUserByUsername(username);
		return user != null;
	}
	
	public void register(User user) {
		UserRepository.getInstance().saveUser(user);
	}
	
	public User loadUserByUsername(String username) {
		return UserRepository.getInstance().findUserByUsername(username);
	}
	
	public boolean cheackPassword(User user, String password) {
		return user.getPassword().equals(password);
	}
}
