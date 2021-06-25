package com.tcs.ecom.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.ecom.model.CustomerModel;
import com.tcs.ecom.services.CustomerServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class CustomerController {
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(CustomerController.class);

	
	@Autowired
	CustomerServiceImpl customerServiceImpl;
	
	@RequestMapping(value = "/customer" ,  method= RequestMethod.POST)
  	public ResponseEntity<?> addCustomerDetails
  						(@RequestHeader(name = "transactionalId") String transactionalId,
  						 @RequestBody CustomerModel addCustomerRequest){
  						 		
		log.info("Inside Class - CustomerController :: Method - addCustomerDetails :: transaction ID : "+transactionalId);
		
		try {
			if(addCustomerRequest!=null) {
				customerServiceImpl.saveCustomerDetails(addCustomerRequest);
				log.info("End Class - CustomerController :: Method - addCustomerDetails :: transaction ID : "+transactionalId);
				return ResponseEntity.ok(new ApiResponse("000", "Customer Details Save successfully","true"));
			}else {
				throw new Exception("Customer Entity Request object null");
			}
		
	}catch(Exception e) {
		e.printStackTrace();
		return ResponseEntity.badRequest().body(new ApiResponse("500",e.getMessage(), "fail"));
	}
		
 }
	
	@GetMapping(value = "/customer/{customerId}", produces = "application/json; charset=UTF-8") 
	@ResponseBody
	private ResponseEntity<?> getCustomerDetailsById(
			@RequestHeader String transactionalId,
			@PathVariable("customerId") Integer customerId) {   
	
	
	log.info("Inside Class - CustomerController  :: Method - getCustomerDetailsById:: transaction ID : "+transactionalId);
		try {
			
		    return ResponseEntity.ok(new ApiResponse("000", "Success","true",customerServiceImpl.getCustomerById(customerId)));
		}catch(Exception e) {
			e.printStackTrace();
			log.error("Error in  CustomerController :: Method - getCustomerDetailsById :: Exception - "+e.getMessage());
			return ResponseEntity.badRequest().body(new ApiResponse("500",e.getMessage(), "fail"));
		}
	}  
	
	@GetMapping(path = "/getAllCustomerInfo", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public ResponseEntity<?> getAllCustomerInfo(@RequestHeader String transactionalId) {
	log.info("Inside Class - CustomerController  :: Method - getCustomerDetailsById  :: transaction ID : "+transactionalId);
		List<CustomerModel> cstomerInfoList = new ArrayList<CustomerModel>();
		try {
		cstomerInfoList = customerServiceImpl.getCustomerDetails();
		if(cstomerInfoList.size()>0) {
			return ResponseEntity.ok(new ApiResponse("000", "Success","true",cstomerInfoList));
		}else{
			return ResponseEntity.badRequest().body(new ApiResponse("111","No Data Found...!", "fail"));
		}
		
		}catch(Exception e) {
			e.printStackTrace();
			log.error("Error in  CustomerController :: Method - getAllCustomerInfo :: Exception - "+e.getMessage());
			return ResponseEntity.badRequest().body(new ApiResponse("500",e.getMessage(), "fail"));
		}
	}
}
