package com.cg.go.service;

import javax.persistence.EntityManager;

import com.cg.go.dao.IUserRepository;
import com.cg.go.entity.Userdata;

public class UserServiceImpl implements IUserService {
	private IUserRepository userDao;

	@Override
	public Userdata addUser(Userdata user) {
		user = userDao.addUser(user);
		return user;
	}

	@Override
	public Userdata loginUser(Userdata u) {
		u = userDao.loginUser(u);
		return u;
	}

	@Override
	public Userdata logout(Userdata user) {
		user = userDao.logout(user);
		return user;
	}

}
