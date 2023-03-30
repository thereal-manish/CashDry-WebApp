package com.finance.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.finance.model.LoanApplicationDetails;
import com.finance.service.CustomerService;
import com.finance.service.LoanApplicationDetailsService;
import com.finance.service.LoanAuthorityService;
import com.finance.service.ManagerService;

@Controller
@RequestMapping("/LAADashBoard")
public class LoanAuthorityDashboardController {

	@Autowired
	CustomerService customerService;
	@Autowired
	ManagerService managerService;
	@Autowired
	LoanAuthorityService loanAuthorityService;
	
	@Autowired
	LoanApplicationDetailsService ldetservice;

	@GetMapping("/LAAdashboardDetails")
	public String LoanAuthDashBoard(Model model) {
		List<LoanApplicationDetails> listlad =  ldetservice.find();
		model.addAttribute("listlad", listlad);
		
		List<LoanApplicationDetails> listladpending =  ldetservice.currentCustomerLoanPending();
		model.addAttribute("listladp", listladpending);
		
		List<LoanApplicationDetails> listladaccepted =  ldetservice.currentCustomerLoanAccepted();
		model.addAttribute("listlada", listladaccepted);
		
		List<LoanApplicationDetails> listladrejected =  ldetservice.currentCustomerLoanRejected();
		model.addAttribute("listladr", listladrejected);
		
		
		return "LoanAuthorityDashboard/laaDashboard";

	}
	@GetMapping("/logout")
	public String custDashboradLogout() {
		return "index";
	}
//	@GetMapping("/LAAdashboardDetails-laa")
//	public String managerDashBoardlaa() {
//		
//		return "ManagerDashBoard/loanAuthorityDetails";
//
//	}
//	@GetMapping("/managerdashboardDetails-cust")
//	public String managerDashBoardcust() {
//		
//		return "ManagerDashBoard/customerDetails";
//
//	}
	
	@GetMapping("accepted/{cust_Accno}")
	public String loanAccept(@PathVariable("cust_Accno")Long cust_Accno, @ModelAttribute("cust_Accno") LoanApplicationDetails ldet,Model model) {
		System.out.println(cust_Accno);
		LoanApplicationDetails laaupdate=ldetservice.currentCustomerLoan(cust_Accno);
		laaupdate.setAuthorityStatus("accepted");
		ldetservice.save(laaupdate);
		return "redirect:/LAADashBoard/LAAdashboardDetails";
	
	}
	@GetMapping("rejected/{cust_Accno}")
	public String loanReject(@PathVariable("cust_Accno")Long cust_Accno, @ModelAttribute("cust_Accno") LoanApplicationDetails ldet,Model model) {
		System.out.println(cust_Accno);
		LoanApplicationDetails laaupdate=ldetservice.currentCustomerLoan(cust_Accno);
		laaupdate.setAuthorityStatus("rejected");
		ldetservice.save(laaupdate);
		return "redirect:/LAADashBoard/LAAdashboardDetails";
	
	}
}	