package com.cg.go.service;

import java.util.ArrayList;
import java.util.List;

import com.cg.go.dao.ICustomerRepository;
import com.cg.go.entity.Customer;

public class CustomerServiceImpl implements ICustomerService  {
	private ICustomerRepository daoCustomer;
	@Override
	public List<Customer> getAllCustomers() {
		//List<Customer> list=new ArrayList<Customer>();
		return daoCustomer.getAllCustomers();
		//return list;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		return  daoCustomer.addCustomer(customer);
		//return customerObject;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return daoCustomer.updateCustomer(customer);
		//customerObject;
	}

	@Override
	public Customer removeCustomer(Customer customer) {
		return daoCustomer.removeCustomer(customer);
		//return customerObject;
	}

	@Override
	public Customer viewCustomer(Customer customer) {
		return daoCustomer.viewCustomer(customer);
		//return customerObject;
	}

}
