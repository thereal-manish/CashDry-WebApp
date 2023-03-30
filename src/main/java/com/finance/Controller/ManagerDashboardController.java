package com.finance.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.finance.model.Customer;
import com.finance.model.LoanApplicationDetails;
import com.finance.model.LoanAuthority;
import com.finance.service.CustomerService;
import com.finance.service.LoanApplicationDetailsService;
import com.finance.service.LoanAuthorityService;
import com.finance.service.ManagerService;

@Controller
@RequestMapping("/ManagerDashBoard")
public class ManagerDashboardController {

	@Autowired
	CustomerService customerService;
	@Autowired
	ManagerService managerService;
	@Autowired
	LoanAuthorityService loanAuthorityService;
	@Autowired
	LoanApplicationDetailsService loanAppService;

	@GetMapping("/managerdashboardDetails")
	public String managerDashBoard(Model model) {
		List<LoanApplicationDetails> listladpending =  loanAppService.currentCustomerLoanPendingManager();
		model.addAttribute("listladpending", listladpending);
		
		
		List<LoanApplicationDetails> listladaccepted =  loanAppService.currentCustomerLoanAcceptedManager();
		model.addAttribute("listladaccept", listladaccepted);
		

		
		List<LoanApplicationDetails> listladrejected =  loanAppService.currentCustomerLoanRejectedManager();
		model.addAttribute("listladreject", listladrejected);
		return "ManagerDashBoard/managerDashboard";

	}
	@GetMapping("/managerdashboardDetails-laa")
	public String managerDashBoardlaa(Model model) {
		List<LoanAuthority> listlaa = loanAuthorityService.find();
		model.addAttribute("listlaa", listlaa);
		
		List<LoanApplicationDetails> listlad =  loanAppService.find();
		model.addAttribute("listlad", listlad);
		
		
		
		return "ManagerDashBoard/loanAuthorityDetails";

	}
	@GetMapping("/managerdashboardDetails-cust")
	public String managerDashBoardcust(Model model) {
		List<Customer> listcustomer = customerService.find();
		model.addAttribute("listcustomer", listcustomer);
		
		return "ManagerDashBoard/customerDetails";

	}
	@GetMapping("/logout")
	public String custDashboradLogout() {
		return "index";
	}
	
	@GetMapping("editlaa/{loanAuth_Id}")
	public String showEditLAA(@PathVariable(name = "loanAuth_Id") String loanAuth_Id,Model mod) {
		
//System.out.println("before"+loanAuth_Id);
		
		LoanAuthority lauth = loanAuthorityService.currentLoanAuthority(loanAuth_Id);
//		System.out.println(lauth.getLoanAuth_Id());
		mod.addAttribute("loanAuthority",lauth);
	
		
		return "ManagerDashBoard/managerLoanAuthorityUpdate";
	}	
	
	@GetMapping("/deletelaa/{loanAuth_Id}")
	public String deleteLAA(@PathVariable(name = "loanAuth_Id") String loanAuth_Id) {
		loanAuthorityService.delete(loanAuth_Id);
		
		return "redirect:/ManagerDashBoard/managerdashboardDetails-laa";
	}
	@PostMapping("/savelaa/{loanAuth_Id}")
	public String saveLAA(@PathVariable("loanAuth_Id")String loanAuth_Id, @ModelAttribute("loanAuthority") LoanAuthority lauth,Model mod) {
		loanAuthorityService.save(lauth);

		
		return "redirect:/ManagerDashBoard/managerdashboardDetails-laa";
	}
	
	//Customer Controller
	
	@GetMapping("editcust/{cust_accNo}")
	public String showEditCust(@PathVariable(name = "cust_accNo") long cust_accNo,Model mod) {
		
		
		
		Customer customer = customerService.currentCustomer(cust_accNo);

		mod.addAttribute("customer",customer);
	
		
		return "ManagerDashBoard/managerCustomerUpdate";
	}	
	
	@GetMapping("/deletecust/{cust_accNo}")
	public String deleteCust(@PathVariable(name = "cust_accNo") long cust_accNo) {
		customerService.delete(cust_accNo);
		
		return "redirect:/ManagerDashBoard/managerdashboardDetails-cust";
	}
	@PostMapping("/savecust/{cust_accNo}")
	public String saveCust(@PathVariable("cust_accNo")long cust_accNo, @ModelAttribute("customer") Customer customer,Model mod) {
		customerService.save(customer);

		
		return "redirect:/ManagerDashBoard/managerdashboardDetails-cust";
	}
	@GetMapping("accepted/{cust_Accno}")
	public String loanAccept(@PathVariable("cust_Accno")Long cust_Accno, @ModelAttribute("cust_Accno") LoanApplicationDetails ldet,Model model) {
		System.out.println(cust_Accno);
		LoanApplicationDetails laaupdate=loanAppService.currentCustomerLoan(cust_Accno);
		laaupdate.setManagerStatus("accepted");
		loanAppService.save(laaupdate);
		return "redirect:/ManagerDashBoard/managerdashboardDetails";
	
	}
	@GetMapping("rejected/{cust_Accno}")
	public String loanReject(@PathVariable("cust_Accno")Long cust_Accno, @ModelAttribute("cust_Accno") LoanApplicationDetails ldet,Model model) {
		System.out.println(cust_Accno);
		LoanApplicationDetails laaupdate=loanAppService.currentCustomerLoan(cust_Accno);
		laaupdate.setManagerStatus("rejected");
		loanAppService.save(laaupdate);
		return "redirect:/ManagerDashBoard/managerdashboardDetails";
	
	}

}	