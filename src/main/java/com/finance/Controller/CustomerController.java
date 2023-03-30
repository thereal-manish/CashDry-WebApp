package com.finance.Controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.finance.model.Customer;
import com.finance.repository.CustomerRepository;
import com.finance.service.CustomerService;

@Controller

public class CustomerController {

	@Autowired
	CustomerService customerService;
	@Autowired
	CustomerRepository cust_repo;

	@GetMapping("/customerLogin")
	public String customerCard() {
		return "customerCard";

	}

	@GetMapping("/creatAccountRegistration")
	public String createAccount() {
		return "createAccount";
	}
	

	@PostMapping("/registrationSuccess")
	public String newCustomer(@RequestParam("cust_fname") String cust_fname, 
			@RequestParam("cust_lname") String cust_lname,
			@RequestParam("cust_dob") String cust_dob, 
			@RequestParam("cust_phone") long cust_phone, 
			@RequestParam("cust_email") String cust_email,
			@RequestParam("cust_address") String cust_address, 
			@RequestParam("cust_photo") MultipartFile cust_photo, 
			@RequestParam("cust_signPhoto") MultipartFile cust_signPhoto,
			@RequestParam("cust_aadhar") long cust_aadhar, 
			@RequestParam("cust_aadharPhoto") MultipartFile cust_aadharPhoto, 
			@RequestParam("cust_pan") String cust_pan,
			@RequestParam("cust_panPhoto") MultipartFile cust_panPhoto, 
			@RequestParam("cust_pass") String cust_pass, 
			@RequestParam("cust_confirmPass") String cust_confirmPass)
	{
		customerService.setCustomer( cust_fname, cust_lname, cust_dob, cust_phone, cust_email, cust_address, cust_photo, cust_signPhoto, cust_aadhar, cust_aadharPhoto, cust_pan, cust_panPhoto, cust_pass, cust_confirmPass);

		return "redirect:/customerloginPage";
	}

	@GetMapping("/customerDetails")
	public List<Customer> getCustomerDetails() {
		return customerService.find();
	}

	@GetMapping("/customerloginPage")
	public String showForm(Customer customer) {
		return "customerlogin";
	}

//	@PostMapping("/customerloginPageValidation")
//	public String getValidation(@Valid @ModelAttribute("customer") Customer customer, BindingResult br, Model model) {
//		if (br.hasErrors()) {
//			return "customerlogin";
//		} else {
//
//			List<Customer> list = cust_repo.findAll();
//			String pass = "";
//			model.addAttribute("customer", customer);
//			
//			
//			
//			for (Customer c : list) {
//				System.out.println(c.toString());
//				String mail = c.getCust_email();
//				if (mail.equals(customer.getCust_email())) {
//					pass = c.getCust_pass();
//					if (pass.equals(customer.getCust_pass())) {
//		
//						return "redirect:/CustDashBoard/custdashboardDetails";
//					} else {
//						model.addAttribute("nopassword", "Invalid Password");
//						return "customerlogin";
//					}
//
//				} else {
//					model.addAttribute("nouser", "No such user found,Please Sign-up");
//					return "customerlogin";
//				}
//				
//			}
//
//			return "customerlogin";
//		}
//
//	}
	
	@PostMapping("/customerloginPageValidation")
	public String getValidation(@Valid @ModelAttribute("customer") Customer customer, BindingResult br, Model model) {
		if (br.hasErrors()) {
			return "customerlogin";
		} 
		else if(customerService.authenticateCustomer(customer.getCust_email(),customer.getCust_pass())==true){
			Customer custLogin=customerService.retrieveCustomer(customer.getCust_email(),customer.getCust_pass());
			
			model.addAttribute("CurrentCustomer",custLogin);
		return "redirect:/CustDashBoard/custdashboardDetails/" +custLogin.getCust_accNo();
		} 
		else {
			String error="Please Enter Valid USERNAME or PASSWORD";
			model.addAttribute("nouser",error);
			return "customerlogin";
			}
	}
	

	

	@PostMapping("/newCustomer")
	public Map<String, Object> addNewCustomer(@RequestParam(value = "cust_accNo") long cust_accNo,
			@RequestParam(value = "cust_fname") String cust_fname,
			@RequestParam(value = "cust_lname") String cust_lname, @RequestParam(value = "cust_dob") String cust_dob,
			@RequestParam(value = "cust_phone") Long cust_phone, @RequestParam(value = "cust_email") String cust_email,
			@RequestParam(value = "cust_address") String cust_address,
			@RequestParam(value = "cust_photo") String cust_photo,
			@RequestParam(value = "cust_signPhoto") String cust_signPhoto,
			@RequestParam(value = "cust_aadhar") long cust_aadhar,
			@RequestParam(value = "cust_aadharPhoto") String cust_aadharPhoto,
			@RequestParam(value = "cust_pan") String cust_pan,
			@RequestParam(value = "cust_panPhoto") String cust_panPhoto,
			@RequestParam(value = "cust_pass") String cust_pass,
			@RequestParam(value = "cust_confirmPass") String cust_confirmPass)

	{
		Customer cust = new Customer(cust_accNo, cust_fname, cust_lname, cust_dob, cust_phone, cust_email, cust_address,
				cust_photo, cust_signPhoto, cust_aadhar, cust_aadharPhoto, cust_pan, cust_panPhoto, cust_pass,
				cust_confirmPass);
		customerService.save(cust);
		Map<String, Object> map = new HashMap<>();
		map.put("Status", "Sucessfully added....!");
		return map;
	}

	@PutMapping("/updateCustomer")
	public Customer updateCustomer(@RequestBody Customer customer) {
		customerService.update(customer);
		return customer;
	}

	@DeleteMapping("/deleteCustomer/{cust_accNo}")
	public Map<String, Object> deleteCustomer(@PathVariable(value = "cust_accNo") long cust_accNo) {
		customerService.delete(cust_accNo);
		Map<String, Object> map = new HashMap<>();
		map.put("Status", "Sucessfully deleted....!");
		return map;
	}
}
