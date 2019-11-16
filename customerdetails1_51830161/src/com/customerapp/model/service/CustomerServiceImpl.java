package com.customerapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.customerapp.model.persistance.Customer;
import com.customerapp.model.persistance.CustomerDao;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao dao;
	
	@Override
	public List<Customer> getAllCustomer() {
		return dao.getAllCustomer();
	}

	@Override
	public Customer getCustomerById(int id) {
		Customer customer=dao.getCustomerById(id);
		if(customer==null){
			throw new CustomerNotFoundException("customer with id: "+id+"is not found");
		}
		return customer;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		return dao.addCustomer(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		
		return dao.updateCustomer(customer);
	}

	@Override
	public Customer removeCustomer(int id) {
		// TODO Auto-generated method stub
		return dao.removeCustomer(id);
	}

}
