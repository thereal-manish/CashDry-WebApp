package com.finance.service;

import org.springframework.web.multipart.MultipartFile;

public interface LoanFormService {
	
	public void setEducation(Long cust_Accno, String cust_Name, String cust_loan_type, int e_hsc_mark,
			MultipartFile e_hsc_marksheet, double e_fees, MultipartFile e_bonofide, MultipartFile e_income);
	public void setFarmer(Long cust_Accno, String cust_Name, String cust_loan_type, String f_farmer_id,
			MultipartFile f_farmer_id_photo, String f_patta_no, MultipartFile f_patta_photo, String f_need,
			double f_farmer_quotaion);
	public void setPersonal(Long cust_Accno, String cust_Name, String cust_loan_type, double p_salary,
			MultipartFile p_payslip, MultipartFile p_bankStatement, MultipartFile p_request_letter, String p_need, String p_quotaio);
	public void setHome(Long cust_Accno, String cust_Name, String cust_loan_type, String h_patta_no,
			MultipartFile h_landdocument, MultipartFile h_land_photos, double h_quotaion);
	public void setGold(Long cust_Accno, String cust_Name, String cust_loan_type, float g_gold_weight,
			String g_bill, MultipartFile g_bill_photo);

}
