package io.swagger.server.api.verticle;

import io.swagger.server.api.model.Customer;

public class DefaultApiImpl implements DefaultApi {

	@Override
	public Customer rhcustomerDelete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer rhcustomerGet() {
		// TODO Auto-generated method stub
		Customer customer= new Customer();
		customer.setName("kavitha");
		customer.setId(123);
		customer.setCategory("premier");
		customer.setRegion("Americas");
		return customer;
	}

	@Override
	public Customer rhcustomerPost(Customer body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer rhcustomerPut(Customer body) {
		// TODO Auto-generated method stub
		return null;
	}

}
