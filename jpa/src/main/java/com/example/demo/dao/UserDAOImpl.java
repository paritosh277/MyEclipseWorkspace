package com.example.demo.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;
import com.example.demo.entity.User;


@Repository
public class UserDAOImpl implements UserDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public UserDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}


	@Override
	public User save(User theUser) {
		
		User dbUser = entityManager.merge(theUser);
		
		//update with id from db....so we can get generated id for save/insert
		dbUser.setId(dbUser.getId());
		
		return dbUser;
	}


	@Override
	public User findByUsername(String username) {
//		User user = entityManager.find(User.class, username);
		
		System.out.println("UserDAOImpl findByUsername");
		
		TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.username = :usernamee", 
				User.class);
		
		query.setParameter("usernamee", username);
		
		User user = query.getSingleResult();
		
		//return employee
		return user;
	}
	
	

}
