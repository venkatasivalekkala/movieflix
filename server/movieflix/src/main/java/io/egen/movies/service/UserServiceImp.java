package io.egen.movies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.movies.entity.User;
import io.egen.movies.exception.*;
import io.egen.movies.repository.UserRepository;

@Service
public class UserServiceImp implements UserService{
	@Autowired
	UserRepository userrepository;
	
	@Override
	@Transactional
	public User createUser(User user) throws UserAlreadyExistsException{
		User existing = userrepository.findByEmail(user.getEmail());
		if (existing != null) {
			throw new UserAlreadyExistsException("User already exists: " + user.getEmail());
		}
		return userrepository.createUser(user);
	}

	@Override
	@Transactional
	public User updateUser(String userId, User user) throws UserNotFoundException{
		User existing = userrepository.findById(userId);
		if (existing == null) {
			throw new UserNotFoundException("User with id:" + userId + " not found");
		}
		return userrepository.updateUser(userId, user);
	}

	@Override
	@Transactional
	public void deleteUser(String userId) throws UserNotFoundException{
		User existing = userrepository.findById(userId);
		if (existing == null) {
			throw new UserNotFoundException("User with id:" + userId + " not found");
		}
		userrepository.deleteUser(existing);
	}

	@Override
	public User findByEmail(String email) throws UserNotFoundException{
		User existing  = userrepository.findByEmail(email);
		if(existing!=null)
			return existing;
		else
			throw new UserNotFoundException("User with email:" + email+ " not found");
	}

	@Override
	public User findById(String userId) throws UserNotFoundException{
		User existing  = userrepository.findById(userId);
		if(existing!=null)
			return existing;
		else
			throw new UserNotFoundException("User with userId:" + userId+ " not found");
		
	}

	@Override
	public User findByEmailAndPassword(String email, String password) throws UserNotFoundException{
		User existing  =  userrepository.findByEmailAndPassword(email, password);
		if(existing!=null)
			return existing;
		else
			throw new UserNotFoundException("User with emaild and password combination not found: ");	
	}

	@Override
	public List<User> findAll() {
		return userrepository.findAll();
	}

	@Override
	public User findAdminByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		User existing  =  userrepository.findAdminByEmailAndPassword(email, password);
		if(existing!=null)
			return existing;
		else
			throw new UserNotFoundException("Admin with emaild and password combination not found: ");	

	}

}
