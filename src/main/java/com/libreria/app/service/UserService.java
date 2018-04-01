package com.libreria.app.service;

import com.libreria.app.model.User;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
}
