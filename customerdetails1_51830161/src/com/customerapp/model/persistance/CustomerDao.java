package com.customerapp.model.persistance;

import java.util.List;

public interface CustomerDao {
	public List<Customer> getAllCustomer();
	public Customer getCustomerById(int id);
	public Customer addCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public Customer removeCustomer(int id);
}
