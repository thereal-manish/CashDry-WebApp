package com.finance.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class LoanApplicationDetails {

	@Id
	private Long cust_Accno;
	private String cust_Name;
	private String cust_loan_type;

	// education loan
	private int e_hsc_mark;
	private String e_hsc_marksheet;
	private double e_fees;
	private String e_bonofide;
	private String e_income;

	// Farmer Loan
	private String f_farmer_id;
	private String f_farmer_id_photo;
	private String f_patta_no;
	private String f_patta_photo;
	private String f_need;
	private double f_farmer_quotaion;

	// Personal Loan
	private double p_salary;
	private String p_payslip;
	private String p_bankStatement;
	private String p_request_letter;
	private String p_need;
	private String p_quotaion;

	// Home Loan
	private String h_patta_no;
	private String h_landdocument;
	private String h_land_photos;
	private double h_quotaion;

	// Gold Loan
	private float g_gold_weight;
	private String g_bill;
	private String g_bill_photo;
	
	private String AuthorityStatus;
	private String ManagerStatus;
	
	
	public LoanApplicationDetails() {

	}

	public LoanApplicationDetails(Long cust_Accno, String cust_Name, String cust_loan_type, int e_hsc_mark,
			String e_hsc_marksheet, double e_fees, String e_bonofide, String e_income) {
		super();
		this.cust_Accno = cust_Accno;
		this.cust_Name = cust_Name;
		this.cust_loan_type = cust_loan_type;
		this.e_hsc_mark = e_hsc_mark;
		this.e_hsc_marksheet = e_hsc_marksheet;
		this.e_fees = e_fees;
		this.e_bonofide = e_bonofide;
		this.e_income = e_income;
	}

	public LoanApplicationDetails(Long cust_Accno, String cust_Name, String cust_loan_type, String f_farmer_id,
			String f_farmer_id_photo, String f_patta_no, String f_patta_photo, String f_need,
			double f_farmer_quotaion) {
		super();
		this.cust_Accno = cust_Accno;
		this.cust_Name = cust_Name;
		this.cust_loan_type = cust_loan_type;
		this.f_farmer_id = f_farmer_id;
		this.f_farmer_id_photo = f_farmer_id_photo;
		this.f_patta_no = f_patta_no;
		this.f_patta_photo = f_patta_photo;
		this.f_need = f_need;
		this.f_farmer_quotaion = f_farmer_quotaion;
	}

	public LoanApplicationDetails(Long cust_Accno, String cust_Name, String cust_loan_type, double p_salary,
			String p_payslip, String p_bankStatement, String p_request_letter, String p_need, String p_quotaion) {
		super();
		this.cust_Accno = cust_Accno;
		this.cust_Name = cust_Name;
		this.cust_loan_type = cust_loan_type;
		this.p_salary = p_salary;
		this.p_payslip = p_payslip;
		this.p_bankStatement = p_bankStatement;
		this.p_request_letter = p_request_letter;
		this.p_need = p_need;
		this.p_quotaion = p_quotaion;
	}

	public LoanApplicationDetails(Long cust_Accno, String cust_Name, String cust_loan_type, String h_patta_no,
			String h_landdocument, String h_land_photos, double h_quotaion) {
		super();
		this.cust_Accno = cust_Accno;
		this.cust_Name = cust_Name;
		this.cust_loan_type = cust_loan_type;
		this.h_patta_no = h_patta_no;
		this.h_landdocument = h_landdocument;
		this.h_land_photos = h_land_photos;
		this.h_quotaion = h_quotaion;
	}

	public LoanApplicationDetails(Long cust_Accno, String cust_Name, String cust_loan_type, float g_gold_weight,
			String g_bill, String g_bill_photo) {
		super();
		this.cust_Accno = cust_Accno;
		this.cust_Name = cust_Name;
		this.cust_loan_type = cust_loan_type;
		this.g_gold_weight = g_gold_weight;
		this.g_bill = g_bill;
		this.g_bill_photo = g_bill_photo;
	}

	public Long getCust_Accno() {
		return cust_Accno;
	}

	public void setCust_Accno(Long cust_Accno) {
		this.cust_Accno = cust_Accno;
	}

	public String getCust_Name() {
		return cust_Name;
	}

	public void setCust_Name(String cust_Name) {
		this.cust_Name = cust_Name;
	}


	public String getCust_loan_type() {
		return cust_loan_type;
	}

	public void setCust_loan_type(String cust_loan_type) {
		this.cust_loan_type = cust_loan_type;
	}

	public int getE_hsc_mark() {
		return e_hsc_mark;
	}

	public void setE_hsc_mark(int e_hsc_mark) {
		this.e_hsc_mark = e_hsc_mark;
	}

	public String getE_hsc_marksheet() {
		return e_hsc_marksheet;
	}

	public void setE_hsc_marksheet(String e_hsc_marksheet) {
		this.e_hsc_marksheet = e_hsc_marksheet;
	}

	public double getE_fees() {
		return e_fees;
	}

	public void setE_fees(double e_fees) {
		this.e_fees = e_fees;
	}

	public String getE_bonofide() {
		return e_bonofide;
	}

	public void setE_bonofide(String e_bonofide) {
		this.e_bonofide = e_bonofide;
	}

	public String getE_income() {
		return e_income;
	}

	public void setE_income(String e_income) {
		this.e_income = e_income;
	}

	public String getF_farmer_id() {
		return f_farmer_id;
	}

	public void setF_farmer_id(String f_farmer_id) {
		this.f_farmer_id = f_farmer_id;
	}

	public String getF_farmer_id_photo() {
		return f_farmer_id_photo;
	}

	public void setF_farmer_id_photo(String f_farmer_id_photo) {
		this.f_farmer_id_photo = f_farmer_id_photo;
	}

	public String getF_patta_no() {
		return f_patta_no;
	}

	public void setF_patta_no(String f_patta_no) {
		this.f_patta_no = f_patta_no;
	}

	public String getF_patta_photo() {
		return f_patta_photo;
	}

	public void setF_patta_photo(String f_patta_photo) {
		this.f_patta_photo = f_patta_photo;
	}

	public String getF_need() {
		return f_need;
	}

	public void setF_need(String f_need) {
		this.f_need = f_need;
	}

	public double getF_farmer_quotaion() {
		return f_farmer_quotaion;
	}

	public void setF_farmer_quotaion(double f_farmer_quotaion) {
		this.f_farmer_quotaion = f_farmer_quotaion;
	}

	public double getP_salary() {
		return p_salary;
	}

	public void setP_salary(double p_salary) {
		this.p_salary = p_salary;
	}

	public String getP_payslip() {
		return p_payslip;
	}

	public void setP_payslip(String p_payslip) {
		this.p_payslip = p_payslip;
	}

	public String getP_bankStatement() {
		return p_bankStatement;
	}

	public void setP_bankStatement(String p_bankStatement) {
		this.p_bankStatement = p_bankStatement;
	}

	public String getP_request_letter() {
		return p_request_letter;
	}

	public void setP_request_letter(String p_request_letter) {
		this.p_request_letter = p_request_letter;
	}

	public String getP_need() {
		return p_need;
	}

	public void setP_need(String p_need) {
		this.p_need = p_need;
	}

	public String getP_quotaion() {
		return p_quotaion;
	}

	public void setP_quotaion(String p_quotaion) {
		this.p_quotaion = p_quotaion;
	}

	public String getH_patta_no() {
		return h_patta_no;
	}

	public void setH_patta_no(String h_patta_no) {
		this.h_patta_no = h_patta_no;
	}

	public String getH_landdocument() {
		return h_landdocument;
	}

	public void setH_landdocument(String h_landdocument) {
		this.h_landdocument = h_landdocument;
	}

	public String getH_land_photos() {
		return h_land_photos;
	}

	public void setH_land_photos(String h_land_photos) {
		this.h_land_photos = h_land_photos;
	}

	public double getH_quotaion() {
		return h_quotaion;
	}

	public void setH_quotaion(double h_quotaion) {
		this.h_quotaion = h_quotaion;
	}

	public float getG_gold_weight() {
		return g_gold_weight;
	}

	public void setG_gold_weight(float g_gold_weight) {
		this.g_gold_weight = g_gold_weight;
	}

	public String getG_bill() {
		return g_bill;
	}

	public void setG_bill(String g_bill) {
		this.g_bill = g_bill;
	}

	public String getG_bill_photo() {
		return g_bill_photo;
	}

	public void setG_bill_photo(String g_bill_photo) {
		this.g_bill_photo = g_bill_photo;
	}

	public String getAuthorityStatus() {
		return AuthorityStatus;
	}

	public void setAuthorityStatus(String authorityStatus) {
		AuthorityStatus = authorityStatus;
	}

	public String getManagerStatus() {
		return ManagerStatus;
	}

	public void setManagerStatus(String managerStatus) {
		ManagerStatus = managerStatus;
	}

	@Override
	public String toString() {
		return "LoanApplicationDetails [cust_Accno=" + cust_Accno + ", cust_Name=" + cust_Name + ", cust_loan_type="
				+ cust_loan_type + ", e_hsc_mark=" + e_hsc_mark + ", e_hsc_marksheet=" + e_hsc_marksheet + ", e_fees="
				+ e_fees + ", e_bonofide=" + e_bonofide + ", e_income=" + e_income + ", f_farmer_id=" + f_farmer_id
				+ ", f_farmer_id_photo=" + f_farmer_id_photo + ", f_patta_no=" + f_patta_no + ", f_patta_photo="
				+ f_patta_photo + ", f_need=" + f_need + ", f_farmer_quotaion=" + f_farmer_quotaion + ", p_salary="
				+ p_salary + ", p_payslip=" + p_payslip + ", p_bankStatement=" + p_bankStatement + ", p_request_letter="
				+ p_request_letter + ", p_need=" + p_need + ", p_quotaion=" + p_quotaion + ", h_patta_no=" + h_patta_no
				+ ", h_landdocument=" + h_landdocument + ", h_land_photos=" + h_land_photos + ", h_quotaion="
				+ h_quotaion + ", g_gold_weight=" + g_gold_weight + ", g_bill=" + g_bill + ", g_bill_photo="
				+ g_bill_photo + ", AuthorityStatus=" + AuthorityStatus + ", ManagerStatus=" + ManagerStatus + "]";
	}

}
