package io.egen.movies.repository;

import java.util.List;

import io.egen.movies.entity.User;

public interface  UserRepository {
	User createUser(User user);
	User updateUser(String userId,User user);
	void  deleteUser(User user);
	User findByEmail(String userId);
	User findById(String userId);
	User findByEmailAndPassword(String email, String password);
	User findAdminByEmailAndPassword(String email, String password);
	List<User> findAll();
	User getUser(String email, String password);		
}
