package io.egen.movies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.movies.entity.User;
import io.egen.movies.exception.UserAlreadyExistsException;
import io.egen.movies.exception.UserNotFoundException;
import io.egen.movies.service.UserService;

@RestController
@RequestMapping(path = "users")
public class UserController {

	@Autowired
	private UserService userservice;
	
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<User> findAll(){
		return userservice.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User createUser(@RequestBody User user) throws UserAlreadyExistsException{
		return userservice.createUser(user);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "{userId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User updateUser(@PathVariable("userId") String userId, @RequestBody User user) throws UserNotFoundException{
		return userservice.updateUser(userId, user);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "{userId}")
	public void  deleteUser(@PathVariable("userId") String userId){
		userservice.deleteUser(userId);
	}
	
	
	@RequestMapping(method = RequestMethod.GET,path = "email/{email}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User findByEmail(@PathVariable("email") String email) throws UserNotFoundException{
		return userservice.findByEmail(email);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "userId/{userId}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User findById(@PathVariable("userId")  String userId) throws UserNotFoundException{
		return userservice.findById(userId);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "login/user",produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User checkUser(@RequestBody User user){
		return userservice.findByEmailAndPassword(user.getEmail(),user.getPassword());	
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "login/admin",produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User checkAdmin(@RequestBody User admin){
		return userservice.findAdminByEmailAndPassword(admin.getEmail(),admin.getPassword());	
	}
}
