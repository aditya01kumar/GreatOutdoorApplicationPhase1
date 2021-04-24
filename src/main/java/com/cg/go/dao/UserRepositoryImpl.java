package com.cg.go.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.cg.go.entity.Userdata;

public class UserRepositoryImpl implements IUserRepository {
	public final EntityManagerFactory emf = com.cg.go.util.JpaUtil.getConnection();
	public final EntityManager entityManager = emf.createEntityManager();
	public final EntityTransaction transaction = entityManager.getTransaction();

	@Override
	public Userdata addUser(Userdata user) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(user);
		transaction.commit();
		return user;
	}

	@Override
	public Userdata loginUser(Userdata u) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Userdata userdata = entityManager.find(Userdata.class, u.getUserId());
		if (userdata == null) {
			return null;
		}

		if (userdata.getUserPassword().equals(u.getUserPassword())) {
			System.out.println("logged in");
			return userdata;
		}
		transaction.commit();
		return u;

	}

	@Override
	public Userdata logout(Userdata user) {
		return null;
	}

}
