package com.tcs.ecom.controller;

import java.util.List;
public class ApiResponse {
	    private String responseCode;
	    private String message;
	    private String status;
	    private Object customerDetail;
	    // private List<Object> customerDetailsList;
	    
 	   public ApiResponse(String responseCode, String message, String status, Object customerDetail) {
			super();
			this.responseCode = responseCode;
			this.message = message;
			this.status = status;
			this.customerDetail = customerDetail;
			
		}

 	  

//		public ApiResponse(String responseCode, String message, String status, List<Object> customerDetailsList) {
//		super();
//		this.responseCode = responseCode;
//		this.message = message;
//		this.status = status;
//		this.customerDetailsList = customerDetailsList;
//	}



		public ApiResponse(String responseCode, String message, String status) {
	        super();
	        
	        this.message = message;
	        this.status = status;
	        this.responseCode = responseCode;
	    }
	    


		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		/**
		 * @return the status
		 */
		public String getStatus() {
			return status;
		}

		/**
		 * @param status the status to set
		 */
		public void setStatus(String status) {
			this.status = status;
		}

		/**
		 * @return the responseCode
		 */
		public String getResponseCode() {
			return responseCode;
		}

		/**
		 * @param responseCode the responseCode to set
		 */
		public void setResponseCode(String responseCode) {
			this.responseCode = responseCode;
		}



		/**
		 * @return the customerDetail
		 */
		public Object getCustomerDetail() {
			return customerDetail;
		}



		/**
		 * @param customerDetail the customerDetail to set
		 */
		public void setCustomerDetail(Object customerDetail) {
			this.customerDetail = customerDetail;
		}



//		/**
//		 * @return the customerDetailsList
//		 */
//		public List<Object> getCustomerDetailsList() {
//			return customerDetailsList;
//		}
//
//
//
//		/**
//		 * @param customerDetailsList the customerDetailsList to set
//		 */
//		public void setCustomerDetailsList(List<Object> customerDetailsList) {
//			this.customerDetailsList = customerDetailsList;
//		}

		
}
