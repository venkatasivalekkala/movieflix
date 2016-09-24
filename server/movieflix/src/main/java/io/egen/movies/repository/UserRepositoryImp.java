package io.egen.movies.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import io.egen.movies.entity.User;


@Repository
public class UserRepositoryImp implements UserRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public User createUser(User user) {
		 em.persist(user);
		 return user;
	}

	@Override
	public User updateUser(String userId, User user) {
		return em.merge(user);
	}

	@Override
	public void deleteUser(User user) {
		em.remove(user);
	}

	@Override
	public User findByEmail(String email) {
		TypedQuery<User> query = em.createNamedQuery("User.findByEmail", User.class);
		query.setParameter("email", email);
		List<User> users = query.getResultList();
		if (users != null && users.size() == 1) {
			return users .get(0);
		}
		return null;
	}

	@Override
	public User findById(String userId) {
		TypedQuery<User> query = em.createNamedQuery("User.findByUserId", User.class);
		query.setParameter("userId", userId);
		List<User> users = query.getResultList();
		if (users != null && users.size() == 1) {
			return users .get(0);
		}
		return null;
	}

	
	@Override
	public User getUser(String email, String password) {
		TypedQuery<User> query = em.createNamedQuery("User.check", User.class);
		query.setParameter("pemail", email);
		query.setParameter("pPassword", password);
		return query.getSingleResult();
	}
	
	@Override
	public User findByEmailAndPassword(String email, String password) {
		TypedQuery<User> query = em.createNamedQuery("User.findByEmailAndPassword", User.class);
		query.setParameter("email", email);
		query.setParameter("password", password);
		List<User> users = query.getResultList();
		if (users != null && users.size() == 1) {
			return users .get(0);
		}
		return null;
	}

	@Override
	public List<User> findAll() {
		TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
		return query.getResultList();
	}

	@Override
	public User findAdminByEmailAndPassword(String email, String password) {
		TypedQuery<User> query = em.createNamedQuery("User.findAdminByEmailAndPassword", User.class);
		query.setParameter("email", email);
		query.setParameter("password", password);
		List<User> users = query.getResultList();
		if (users != null && users.size() == 1) {
			return users .get(0);
		}
		return null;
	}

}
