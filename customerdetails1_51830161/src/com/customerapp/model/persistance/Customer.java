package com.customerapp.model.persistance;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "customer_table161")
public class Customer {
	@Id
	@GeneratedValue
	private int id;
	@NotEmpty(message = "name cannot left blank")
	private String name;
	@NotEmpty(message = "address cannot left blank")
	private String address;
	@NotEmpty(message = "number cannot left blank")
	private String phno;
	@Email
	@NotEmpty(message = "email cannot left blank")
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}




	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Customer(String name, String address, String phno, String email) {

		this.name = name;
		this.address = address;
		this.phno = phno;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", address=" + address + ", phno=" + phno + ", email="
				+ email + "]";
	}

	public Customer() {

	}

}
