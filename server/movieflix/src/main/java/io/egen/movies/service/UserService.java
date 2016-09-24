package io.egen.movies.service;

import java.util.List;

import io.egen.movies.entity.User;

public interface UserService {
	User createUser(User user);
	User updateUser(String userId,User user);
	void  deleteUser(String userId);
	User findByEmail(String userId);
	User findById(String userId);
	User findByEmailAndPassword(String email, String password);
	User findAdminByEmailAndPassword(String email, String password);
	List<User> findAll();
		
}
