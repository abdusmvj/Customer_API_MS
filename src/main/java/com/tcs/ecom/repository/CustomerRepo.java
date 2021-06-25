package com.tcs.ecom.repository;

import org.springframework.data.repository.CrudRepository;

import com.tcs.ecom.model.CustomerModel;

public interface CustomerRepo extends CrudRepository<CustomerModel, Integer> {
	
	

}
