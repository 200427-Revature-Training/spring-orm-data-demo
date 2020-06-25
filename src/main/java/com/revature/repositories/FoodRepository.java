package com.revature.repositories;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.entities.Food;

/**
 * Transaction Propagation Levels
 * 
 * REQUIRED - Will use existing transaction or create a one if one does not exist.
 * MANDATORY - Will use existing transaction or throw an error if one does not exist.
 * SUPPORTS - Will use existing transaction or execute non-transactionally if one does not exist.
 * NEVER - Will throw an exception if there is a transaction, executes non-transactionally if one
 * 			does not exist.
 * REQUIRE_NEW - Will always create a new transaction, even if one exists.
 * NESTED - Creates transaction within current transaction and operates on that transaction.
 * NOT_SUPPORTED - Will ignore transactions ongoing and execute non-transactionally.
 * 
 */

@Repository
public class FoodRepository {
	
	
	@Autowired
	EntityManager em;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public Food save(Food food) {
		Session session = em.unwrap(Session.class);
		session.save(food);
		return food;
	}
	
	public Optional<Food> getFoodById(int id) {
		Session session = em.unwrap(Session.class);
		Food food = session.get(Food.class, id);
		return Optional.ofNullable(food);
	}
}
