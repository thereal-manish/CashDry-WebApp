package com.finance.Controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.finance.model.LoanApplicationDetails;
import com.finance.service.LoanApplicationDetailsService;

@Controller

public class LoanApplicaionDetailsController {

	
	@Autowired
	LoanApplicationDetailsService loanApplicationDetailsService;

	@GetMapping("/LoanApplicationDetailsDetails")
	public List<LoanApplicationDetails> getLoanApplicationDetailsDetails() {
		return loanApplicationDetailsService.find();
	}

	@GetMapping("/{cust_Accno}")
	public LoanApplicationDetails getLoanApplicationDetailsDetailsById(
			@PathVariable(value = "cust_Accno") Long cust_Accno) {
		return loanApplicationDetailsService.getLoanApplicationDetails(cust_Accno);
	}

	@PostMapping("/newEducationLoanApplicationDetails")
	public Map<String, Object> newEducationLoanApplicationDetails(@RequestParam(value = "cust_Accno") long cust_Accno,
			@RequestParam(value = "cust_Name") String cust_Name,
			@RequestParam(value = "cust_loan_type") String cust_loan_type, 
			@RequestParam(value = "e_hsc_mark") int e_hsc_mark, 
			@RequestParam(value = "e_hsc_marksheet") String e_hsc_marksheet,
			@RequestParam(value = "e_fees") double e_fees, 
			@RequestParam(value = "e_bonofide") String e_bonofide,
			@RequestParam(value = "e_income") String e_income)

	{
		LoanApplicationDetails lAppDet = new LoanApplicationDetails(cust_Accno, cust_Name,cust_loan_type, e_hsc_mark, e_hsc_marksheet,
				e_fees, e_bonofide, e_income);
		loanApplicationDetailsService.save(lAppDet);
		Map<String, Object> map = new HashMap<>();
		map.put("Status", "Your Education Loan Application has been submitted successfully...!");
		return map;
	}

	@PostMapping("/newFarmerLoanApplicationDetails")
	public Map<String, Object> newFarmerLoanApplicationDetails(@RequestParam(value = "cust_Accno") long cust_Accno,
			@RequestParam(value = "cust_Name") String cust_Name,
			@RequestParam(value = "cust_loan_type") String cust_loan_type,
			@RequestParam(value = "f_farmer_id") String f_farmer_id, 
			@RequestParam(value = "f_farmer_id_photo") String f_farmer_id_photo,
			@RequestParam(value = "f_patta_no") String f_patta_no, 
			@RequestParam(value = "f_patta_photo") String f_patta_photo,
			@RequestParam(value = "f_need") String f_need,
			@RequestParam(value = "f_farmer_quotaion") double f_farmer_quotaion) 
	{
		LoanApplicationDetails lAppDet = new LoanApplicationDetails(cust_Accno, cust_Name,cust_loan_type, f_farmer_id, f_farmer_id_photo,
				f_patta_no, f_patta_photo, f_need, f_farmer_quotaion);
		loanApplicationDetailsService.save(lAppDet);
		Map<String, Object> map = new HashMap<>();
		map.put("Status", "Your Farmer Loan Application has been submitted successfully...!");
		return map;
	}

	@PostMapping("/newPersonalLoanApplicationDetails")
	public Map<String, Object> newPersonalLoanApplicationDetails(@RequestParam(value = "cust_Accno") long cust_Accno,
			@RequestParam(value = "cust_Name") String cust_Name,
			@RequestParam(value = "cust_loan_type") String cust_loan_type,
			@RequestParam(value = "p_salary") double p_salary, 
			@RequestParam(value = "p_payslip") String p_payslip,
			@RequestParam(value = "p_bankStatement") String p_bankStatement, 
			@RequestParam(value = "p_request_letter") String p_request_letter,
			@RequestParam(value = "p_need") String p_need,
			@RequestParam(value = "p_quotaion") String p_quotaion)

	{
		LoanApplicationDetails lAppDet = new LoanApplicationDetails(cust_Accno, cust_Name,cust_loan_type, p_salary, p_payslip,
				p_bankStatement, p_request_letter, p_need, p_quotaion);
		loanApplicationDetailsService.save(lAppDet);
		Map<String, Object> map = new HashMap<>();
		map.put("Status", "Your Personal Loan Application has been submitted successfully...!");
		return map;
	}

	@PostMapping("/newHomeLoanApplicationDetails")
	public Map<String, Object> newHomeLoanApplicationDetails(@RequestParam(value = "cust_Accno") long cust_Accno,
			@RequestParam(value = "cust_Name") String cust_Name,
			@RequestParam(value = "cust_loan_type") String cust_loan_type,
			@RequestParam(value = "h_patta_no") String h_patta_no, 
			@RequestParam(value = "h_landdocument") String h_landdocument,
			@RequestParam(value = "h_land_photos") String h_land_photos, 
			@RequestParam(value = "h_quotaion") double h_quotaion)
			
	{
		LoanApplicationDetails lAppDet = new LoanApplicationDetails(cust_Accno, cust_Name,cust_loan_type, h_patta_no, h_landdocument,
				h_land_photos, h_quotaion);
		loanApplicationDetailsService.save(lAppDet);
		Map<String, Object> map = new HashMap<>();
		map.put("Status", "Your Home Loan Application has been submitted successfully...!");
		return map;
	}

	@PostMapping("/newGoldLoanApplicationDetails")
	public Map<String, Object> addNewLoanApplicationDetails(@RequestParam(value = "cust_Accno") long cust_Accno,
			@RequestParam(value = "cust_Name") String cust_Name,
			@RequestParam(value = "cust_loan_type") String cust_loan_type,
			@RequestParam(value = "g_gold_weight") float g_gold_weight, 
			@RequestParam(value = "g_bill") String g_bill,
			@RequestParam(value = "g_bill_photo") String g_bill_photo)

	{
		LoanApplicationDetails lAppDet = new LoanApplicationDetails(cust_Accno, cust_Name,cust_loan_type, g_gold_weight, g_bill,
				g_bill_photo);
		loanApplicationDetailsService.save(lAppDet);
		Map<String, Object> map = new HashMap<>();
		map.put("Status", "Your Gold Loan Application has been submitted successfully...!");
		return map;
	}

}
