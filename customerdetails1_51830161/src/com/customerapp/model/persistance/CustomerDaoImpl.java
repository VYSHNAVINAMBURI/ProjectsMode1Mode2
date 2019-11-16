package com.customerapp.model.persistance;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDaoImpl implements CustomerDao{
	@Autowired
	private SessionFactory factory;
	
	private Session getSession() {
		return factory.getCurrentSession();
	}
	
	@SuppressWarnings(value="unchecked")
	@Override
	public List<Customer> getAllCustomer() {
		return getSession().createQuery("from Customer").list();
	}

	@Override
	public Customer getCustomerById(int id) {
		return (Customer) getSession().get(Customer.class,id);
	}

	@Override
	public Customer addCustomer(Customer customer) {
		getSession().save(customer);
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		getSession().update(customer);
		return customer;
	}

	@Override
	public Customer removeCustomer(int id) {
		Customer customerTobeDeleted = getCustomerById(id);
		getSession().delete(customerTobeDeleted);

		return customerTobeDeleted;
	}

}
