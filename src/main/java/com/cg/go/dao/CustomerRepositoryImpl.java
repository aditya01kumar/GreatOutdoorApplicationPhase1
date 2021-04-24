package com.cg.go.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.cg.go.entity.Customer;

public class CustomerRepositoryImpl implements ICustomerRepository {
	public final EntityManagerFactory emf = com.cg.go.util.JpaUtil.getConnection();
	public final EntityManager entityManager = emf.createEntityManager();
	public final EntityTransaction transaction = entityManager.getTransaction();

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> list = new ArrayList<Customer>();
		list = entityManager.createQuery("select c from Customer c", Customer.class).getResultList();
		return list;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		transaction.begin();
		entityManager.persist(customer);
		transaction.commit();
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		transaction.begin();
		entityManager.merge(customer);
		transaction.commit();
		return customer;
	}

	@Override
	public Customer removeCustomer(Customer customer) {
		transaction.begin();
		entityManager.remove(customer);
		transaction.commit();
		return customer;
	}

	@Override
	public Customer viewCustomer(Customer customer) {
		transaction.begin();
		Customer customerObject = entityManager.find(Customer.class, customer.getCustomerId());
		transaction.commit();
		return customerObject;
	}

}
