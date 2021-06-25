package com.tcs.ecom.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.ecom.model.CustomerModel;
import com.tcs.ecom.repository.CustomerRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class CustomerServiceImpl {

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Autowired
	CustomerRepo customerRepo;

	public CustomerModel saveCustomerDetails(CustomerModel customerModel) {
		log.info("Inside CustomerServiceImpl :: Method - saveCustomerDetails");

		CustomerModel customerObj = new CustomerModel();
		try {
			customerObj = customerRepo.save(customerModel);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error in  CustomerServiceImpl :: Method - saveCustomerDetails :: Exception " + e.getMessage());
		}
		return customerObj;
	}

	public Optional<CustomerModel> getCustomerById(Integer id) {
		log.info("Inside CustomerServiceImpl :: Method - getCustomerById");
		Optional<CustomerModel> customerObj = null;
		try {
			customerObj = customerRepo.findById(id);
			return customerObj;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error in  CustomerServiceImpl :: Method - getCustomerById :: Exception " + e.getMessage());
		}
		return customerObj;
  }
	
	public List<CustomerModel> getCustomerDetails() {
		log.info("Inside CustomerServiceImpl :: Method - getCustomerDetails");

		List<CustomerModel> listCustomerDtls= new ArrayList<CustomerModel>();
		try {
				listCustomerDtls= (List<CustomerModel>) customerRepo.findAll();
				
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error in  CustomerServiceImpl :: Method - getCustomerDetails :: Exception " + e.getMessage());
		}
		return listCustomerDtls;
		
	}
	
}
