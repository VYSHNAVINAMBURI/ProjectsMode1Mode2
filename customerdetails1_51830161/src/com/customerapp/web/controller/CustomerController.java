package com.customerapp.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.customerapp.model.persistance.Customer;
import com.customerapp.model.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	/*@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "redirect:login";
	}*/

	@RequestMapping(value = "allcustomers", method = RequestMethod.GET)
	public String getcustomers(ModelMap map) {
		map.addAttribute("customers", customerService.getAllCustomer());
		return "all_customers";
	}

	@RequestMapping(value = "addcustomer", method = RequestMethod.GET)
	public String addCustomerGet(ModelMap map) {
		map.addAttribute("customer", new Customer());
		return "addcustomer";
	}

	@RequestMapping(value = "addcustomer", method = RequestMethod.POST)
	public String addCustomerUpdatePost(@Valid Customer customer, BindingResult bindingresult) {
		if (bindingresult.hasErrors()) {
			return "addcustomer";
		} else {
			if (customer.getId() == 0) {
				customerService.addCustomer(customer);
			} else {
				customerService.updateCustomer(customer);
			}

			return "redirect:allcustomers";

		}
	}
	@RequestMapping(value="delete",method=RequestMethod.GET)
	public String deleteCustomer(HttpServletRequest req){
		int id=Integer.parseInt(req.getParameter("id"));
		customerService.removeCustomer(id);
		return "redirect:allcustomers";
	}
	//update get part
	@RequestMapping(value="update",method=RequestMethod.GET)
	public String updateCustomerGet(HttpServletRequest req,ModelMap map){
		int id=Integer.parseInt(req.getParameter("id"));
		Customer customerToBeUpdate=customerService.getCustomerById(id);
		map.addAttribute("customer", customerToBeUpdate);
		return "addcustomer";
	}
	
}

