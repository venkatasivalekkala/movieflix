package io.egen.movies.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
@NamedQueries({ 
		@NamedQuery(name = "User.findAll", query = "SELECT e FROM User e"),
		@NamedQuery(name = "User.findByEmail", query = "SELECT e FROM User e where e.email like :email"),
		@NamedQuery(name = "User.findByUserId", query = "SELECT e FROM User e where e.userId like :userId"),
		@NamedQuery(name = "User.findByEmailAndPassword", query = "SELECT e FROM User e where e.email like :email and e.password like :password and e.role ='User'"),
		@NamedQuery(name = "User.findAdminByEmailAndPassword", query = "SELECT e FROM User e where e.email like :email and e.password like :password and e.role ='Admin'")
})
public class User {

	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	private String userId;
	private String username;
	private String firstName;
	private String lastName;
	private String password;
	@Column(unique = true)
	private String email;
	private String role;
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", firstName=" + firstName + ", lastName="
				+ lastName + ", password=" + password + ", email=" + email + "]";
	}
}
