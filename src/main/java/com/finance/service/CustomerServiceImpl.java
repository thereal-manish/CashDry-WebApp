package com.finance.service;

import java.io.*;
import java.util.Base64;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;

import com.finance.model.Customer;
import com.finance.model.LoanApplicationDetails;
import com.finance.repository.CustomerRepository;
import com.finance.repository.LoanApplicationDetailsRepository;
import com.finance.repository.LoanAuthorityRepository;
import com.finance.repository.ManagerRepository;





@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository cust_repo;
	
	@Autowired
	ManagerRepository manager_repo;
	@Autowired
	LoanAuthorityRepository lAuth_repo;
	
	@Autowired
	LoanApplicationDetailsRepository lDet_repo;
	
	@Override
	public void setCustomer( String cust_fname, String cust_lname, String cust_dob, Long cust_phone,
			String cust_email, String cust_address, MultipartFile cust_photo, MultipartFile cust_signPhoto,
			Long cust_aadhar, MultipartFile cust_aadharPhoto, String cust_pan, MultipartFile cust_panPhoto,
			String cust_pass, String cust_confirmPass) {
		
		Customer cus = new Customer();
		//encoding images
		String cust_photo_encoded = StringUtils.cleanPath(cust_photo.getOriginalFilename());
		String cust_signPhoto_encoded = StringUtils.cleanPath(cust_signPhoto.getOriginalFilename());
		String cust_aadharPhoto_encoded = StringUtils.cleanPath(cust_aadharPhoto.getOriginalFilename());
		String cust_panPhoto_encoded = StringUtils.cleanPath(cust_panPhoto.getOriginalFilename());
		
		if(cust_photo_encoded.contains("..") || cust_signPhoto_encoded.contains("..") || cust_aadharPhoto_encoded.contains("..") || cust_panPhoto_encoded.contains("..") )
		{
			System.out.println("not a a valid file");
		}
		try {
			//setting encoded images
			cus.setCust_photo(Base64.getEncoder().encodeToString(cust_photo_encoded.getBytes()));
			cus.setCust_signPhoto(Base64.getEncoder().encodeToString(cust_signPhoto_encoded.getBytes()));
			cus.setCust_aadharPhoto(Base64.getEncoder().encodeToString(cust_aadharPhoto_encoded.getBytes()));
			cus.setCust_panPhoto(Base64.getEncoder().encodeToString(cust_panPhoto_encoded.getBytes()));
		
		
		} catch (Throwable e) {
			throw new MultipartException("e",e); 
		}
		//setting parameters
		cus.setCust_fname(cust_fname);
		cus.setCust_lname(cust_lname);
		cus.setCust_dob(cust_dob);
		cus.setCust_phone(cust_phone);
		cus.setCust_email(cust_email);
		cus.setCust_address(cust_address);
		cus.setCust_aadhar(cust_aadhar);
		cus.setCust_pan(cust_pan);
		cus.setCust_pass(cust_pass);
		cus.setCust_confirmPass(cust_confirmPass);
		//saving object
		cust_repo.save(cus);
	}
	
	
	public List<Customer> find()
	{
		return cust_repo.findAll();
	}
	
	public void save(Customer cust) {
		cust_repo.save(cust);
	}
	
	public Customer getCustomer(Long cust_accNo) {
		return cust_repo.findById(cust_accNo).get();
	}
	
	public void delete(Long cust_accNo) {
		cust_repo.deleteById(cust_accNo);
	}
	public void update(Customer cust) {
		List<Customer> list_customer = find();
		for(Customer cus: list_customer) {
			if(cus.getCust_accNo()==(cust.getCust_accNo())){
				cust_repo.save(cust);
			}
			else {
				System.out.println("Wrong Customer Id");
			}
		}
	}

	public boolean authenticateCustomer(String cust_email,String cust_pass){
		Customer customer = cust_repo.validateCustomer(cust_email,cust_pass);
		if (customer == null) {
			return false;
		}
		return true;
	}
	public Customer retrieveCustomer(String cust_email,String cust_pass){
		Customer customer = cust_repo.validateCustomer(cust_email,cust_pass);
		return customer;
	}


	@Override
	public Customer currentCustomer(Long cust_accNo) {
		Customer currentCustomer=cust_repo.currentCustomer(cust_accNo);
		
		return currentCustomer;
	}


	@Override
	public Customer get(Long cust_accNo) {
		
		return cust_repo.findById(cust_accNo).get();
	}

	


}
