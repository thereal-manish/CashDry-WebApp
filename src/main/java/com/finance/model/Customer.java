package com.finance.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long cust_accNo;
	private String cust_fname;
	private String cust_lname;
	private String cust_dob;
	private long cust_phone;
	@Email(regexp="^(.+)@(.+)$", message="Enter valid email")
	private String cust_email;
	private String cust_address;
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String cust_photo;
	private String cust_signPhoto;
	private long cust_aadhar;
	private String cust_aadharPhoto;
	private String cust_pan;
	private String cust_panPhoto;
	@Pattern(regexp="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,15}" , message="Enter valid Password")
	private String cust_pass;
	@Pattern(regexp="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,15}" , message="Enter valid Password")
	private String cust_confirmPass;
	
//	LoanAuthority loanAuth;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cus_ref_accNo" ,referencedColumnName = "cust_accNo")
	LoanApplicationDetails loanApplication;

	public Customer() {

	}

	public Customer(long cust_accNo, String cust_fname, String cust_lname, String cust_dob, long cust_phone,
			String cust_email, String cust_address, String cust_photo, String cust_signPhoto, long cust_aadhar,
			String cust_aadharPhoto, String cust_pan, String cust_panPhoto, String cust_pass, String cust_confirmPass) {
		super();
		this.cust_accNo = cust_accNo;
		this.cust_fname = cust_fname;
		this.cust_lname = cust_lname;
		this.cust_dob = cust_dob;
		this.cust_phone = cust_phone;
		this.cust_email = cust_email;
		this.cust_address = cust_address;
		this.cust_photo = cust_photo;
		this.cust_signPhoto = cust_signPhoto;
		this.cust_aadhar = cust_aadhar;
		this.cust_aadharPhoto = cust_aadharPhoto;
		this.cust_pan = cust_pan;
		this.cust_panPhoto = cust_panPhoto;
		this.cust_pass = cust_pass;
		this.cust_confirmPass = cust_confirmPass;
	}

	public long getCust_accNo() {
		return cust_accNo;
	}

	public void setCust_accNo(long cust_accNo) {
		this.cust_accNo = cust_accNo;
	}

	public String getCust_fname() {
		return cust_fname;
	}

	public void setCust_fname(String cust_fname) {
		this.cust_fname = cust_fname;
	}

	public String getCust_lname() {
		return cust_lname;
	}

	public void setCust_lname(String cust_lname) {
		this.cust_lname = cust_lname;
	}

	public String getCust_dob() {
		return cust_dob;
	}

	public void setCust_dob(String cust_dob) {
		this.cust_dob = cust_dob;
	}

	public long getCust_phone() {
		return cust_phone;
	}

	public void setCust_phone(long cust_phone) {
		this.cust_phone = cust_phone;
	}

	public String getCust_email() {
		return cust_email;
	}

	public void setCust_email(String cust_email) {
		this.cust_email = cust_email;
	}

	public String getCust_address() {
		return cust_address;
	}

	public void setCust_address(String cust_address) {
		this.cust_address = cust_address;
	}

	public String getCust_photo() {
		return cust_photo;
	}

	public void setCust_photo(String cust_photo) {
		this.cust_photo = cust_photo;
	}

	public String getCust_signPhoto() {
		return cust_signPhoto;
	}

	public void setCust_signPhoto(String cust_signPhoto) {
		this.cust_signPhoto = cust_signPhoto;
	}

	public long getCust_aadhar() {
		return cust_aadhar;
	}

	public void setCust_aadhar(long cust_aadhar) {
		this.cust_aadhar = cust_aadhar;
	}

	public String getCust_aadharPhoto() {
		return cust_aadharPhoto;
	}

	public void setCust_aadharPhoto(String cust_aadharPhoto) {
		this.cust_aadharPhoto = cust_aadharPhoto;
	}

	public String getCust_pan() {
		return cust_pan;
	}

	public void setCust_pan(String cust_pan) {
		this.cust_pan = cust_pan;
	}

	public String getCust_panPhoto() {
		return cust_panPhoto;
	}

	public void setCust_panPhoto(String cust_panPhoto) {
		this.cust_panPhoto = cust_panPhoto;
	}

	public String getCust_pass() {
		return cust_pass;
	}

	public void setCust_pass(String cust_pass) {
		this.cust_pass = cust_pass;
	}

	public String getCust_confirmPass() {
		return cust_confirmPass;
	}

	public void setCust_confirmPass(String cust_confirmPass) {
		this.cust_confirmPass = cust_confirmPass;
	}

	@Override
	public String toString() {
		return "Customer [cust_accNo=" + cust_accNo + ", cust_fname=" + cust_fname + ", cust_lname=" + cust_lname
				+ ", cust_dob=" + cust_dob + ", cust_phone=" + cust_phone + ", cust_email=" + cust_email
				+ ", cust_address=" + cust_address + ", cust_photo=" + cust_photo + ", cust_signPhoto=" + cust_signPhoto
				+ ", cust_aadhar=" + cust_aadhar + ", cust_aadharPhoto=" + cust_aadharPhoto + ", cust_pan=" + cust_pan
				+ ", cust_panPhoto=" + cust_panPhoto + ", cust_pass=" + cust_pass + ", cust_confirmPass="
				+ cust_confirmPass + "]";
	}
	
	
}
