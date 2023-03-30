package com.finance.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.finance.model.Customer;
import com.finance.model.LoanApplicationDetails;
import com.finance.service.CustomerService;
import com.finance.service.LoanApplicationDetailsService;
import com.finance.service.LoanAuthorityService;
import com.finance.service.LoanFormService;
import com.finance.service.ManagerService;

@Controller
@RequestMapping("/CustDashBoard")
public class CustomerDashboardController {

	@Autowired
	CustomerService customerService;
	@Autowired
	ManagerService managerService;
	@Autowired
	LoanAuthorityService loanAuthorityService;
	@Autowired
	LoanApplicationDetailsService lDet_service;
	@Autowired
	public LoanFormService lfs;
	
	
	LoanApplicationDetails lDet;

	@GetMapping("/custdashboardDetails")
	public String CustAuthDashBoard() {
		
		return "CustomerDashboard/customerDashboard";

	}
	
//	@GetMapping("/custdashboardDetails1")
//	public String CustAuthDashBoard1() {
//		
//		return "redirect:/custdashboardDetails";
//
//	}
	
	@GetMapping("custdashboardDetails/showEducation")
	public String educationForm() {
		return "LoanForms/EducationLoanForm";
	}
	
	@GetMapping("custdashboardDetails/showFarmer")
	public String farmerForm() {
		return "LoanForms/FarmerLoanForm";
	}
	
	@GetMapping("custdashboardDetails/showGold")
	public String goldForm() {
		return "LoanForms/GoldLoanForm";
	}
	
	@GetMapping("custdashboardDetails/showHome")
	public String homeForm() {
		return "LoanForms/HomeLoanForm";
	}
	
	@GetMapping("custdashboardDetails/showPersonal")
	public String personalForm() {
		return "LoanForms/PersonalLoanForm";
	}

	@GetMapping("logout")
	public String custDashboradLogout() {
		return "index";
	}	
	@GetMapping("custdashboardDetails/AllLoanForms")
	public String loanForms(){
		return "LoanForms/LoanCard";
		
	}
	
	@GetMapping("custdashboardDetails/{cust_accNo}")
	public String getCustomerDetailsById(@PathVariable(value = "cust_accNo") Long cust_accNo, Model mod) {
		Customer currentCustomer=customerService.currentCustomer(cust_accNo);
		LoanApplicationDetails lDets= lDet_service.currentCustomerLoan(cust_accNo);
		mod.addAttribute("currentCustloanApp", lDets);
		mod.addAttribute("currentCust",currentCustomer);
		return "CustomerDashboard/customerDashboard";
	}
	
	
	

	@PostMapping("custdashboardDetails/educationFill")
	public String newEducation(@RequestParam("cust_Accno") Long cust_Accno, 
			@RequestParam("cust_Name") String cust_Name,
			@RequestParam("cust_loan_type") String cust_loan_type, 
			@RequestParam("e_hsc_mark") int e_hsc_mark, 
			@RequestParam("e_hsc_marksheet") MultipartFile e_hsc_marksheet,
			@RequestParam("e_fees") double e_fees, 
			@RequestParam("e_bonofide") MultipartFile e_bonofide, 
			@RequestParam("e_income") MultipartFile e_income)
			 {
		lfs.setEducation(cust_Accno, cust_Name, cust_loan_type, e_hsc_mark,
				e_hsc_marksheet, e_fees, e_bonofide, e_income);
		return "redirect:/customerloginPage";
	}
	
	@PostMapping("custdashboardDetails/farmerFill")
	public String newFormer(@RequestParam("cust_Accno") Long cust_Accno, 
			@RequestParam("cust_Name") String cust_Name,
			@RequestParam("cust_loan_type") String cust_loan_type, 
			@RequestParam("f_farmer_id") String f_farmer_id, 
			@RequestParam("f_farmer_id_photo") MultipartFile f_farmer_id_photo,
			@RequestParam("f_patta_no") String f_patta_no, 
			@RequestParam("f_patta_photo") MultipartFile f_patta_photo, 
			@RequestParam("f_need") String f_need,
			@RequestParam("f_farmer_quotaion") double f_farmer_quotaion) {
		
		lfs.setFarmer(cust_Accno, cust_Name, cust_loan_type, f_farmer_id, f_farmer_id_photo, f_patta_no, f_patta_photo, f_need,f_farmer_quotaion );
	return "redirect:/customerloginPage";

	}
	
	@PostMapping("custdashboardDetails/homeFill")
	public String newHomer(@RequestParam("cust_Accno") Long cust_Accno, 
			@RequestParam("cust_Name") String cust_Name,
			@RequestParam("cust_loan_type") String cust_loan_type, 
			@RequestParam("h_patta_no") String h_patta_no, 
			@RequestParam("h_landdocument") MultipartFile h_landdocument,
			@RequestParam("h_land_photos") MultipartFile h_land_photos, 
			@RequestParam("h_quotaion") double h_quotaion 
			) {
		lfs.setHome(cust_Accno, cust_Name, cust_loan_type, h_patta_no, h_landdocument, h_land_photos, h_quotaion);
		return "redirect:/customerloginPage";
	}

	
	@PostMapping("custdashboardDetails/personalFill")
	public String newPersonal(@RequestParam("cust_Accno") Long cust_Accno, 
			@RequestParam("cust_Name") String cust_Name,
			@RequestParam("cust_loan_type") String cust_loan_type, 
			@RequestParam("p_salary") double p_salary, 
			@RequestParam("p_payslip") MultipartFile p_payslip,
			@RequestParam("p_bankStatement") MultipartFile p_bankStatement, 
			@RequestParam("p_request_letter") MultipartFile p_request_letter, 
			@RequestParam("p_need") String p_need,
			@RequestParam("p_quotaion") String p_quotaion) {
		lfs.setPersonal(cust_Accno, cust_Name, cust_loan_type, p_salary, p_payslip, p_bankStatement,p_request_letter , p_need, p_quotaion);
		return "redirect:/customerloginPage";
	}

	
	
	@PostMapping("custdashboardDetails/goldFill")
	public String newGold(@RequestParam("cust_Accno") Long cust_Accno, 
			@RequestParam("cust_Name") String cust_Name,
			@RequestParam("cust_loan_type") String cust_loan_type, 
			@RequestParam("g_gold_weight") float g_gold_weight, 
			@RequestParam("g_bill") String g_bill,
			@RequestParam("g_bill_photo") MultipartFile g_bill_photo 
			) {
		lfs.setGold(cust_Accno, cust_Name, cust_loan_type, g_gold_weight,g_bill,g_bill_photo);
		return "redirect:/customerloginPage";
	}
	
	
}	