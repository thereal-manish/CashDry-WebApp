package com.finance.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.finance.model.Customer;
import com.finance.model.Manager;


public interface CustomerService {
	
	public void setCustomer( String cust_fname,String cust_lname,String cust_dob, Long cust_phone,
			String cust_email, String cust_address,
			MultipartFile cust_photo, MultipartFile cust_signPhoto,Long cust_aadhar, MultipartFile cust_aadharPhoto,String cust_pan,MultipartFile cust_panPhoto, String cust_pass,
			String cust_confirmPass);
	public List<Customer> find();
	public void save(Customer cust);
	public Customer getCustomer(Long cust_accNo);
	public void delete(Long cust_accNo);
	public void update(Customer cust);
	public boolean authenticateCustomer(String cust_email,String cust_pass);
	public Customer retrieveCustomer(String cust_email,String cust_pass);
	public Customer currentCustomer(Long cust_accNo);
	
	public Customer get(Long cust_accNo);
	
	
		

}
