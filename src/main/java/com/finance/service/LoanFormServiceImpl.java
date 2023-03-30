package com.finance.service;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;

import com.finance.model.LoanApplicationDetails;
import com.finance.repository.LoanApplicationDetailsRepository;
@Service
public class LoanFormServiceImpl implements LoanFormService {

	@Autowired
	LoanApplicationDetailsRepository lDet_repo;

	@Override
	public void setEducation(Long cust_Accno, String cust_Name, String cust_loan_type, int e_hsc_mark,
			MultipartFile e_hsc_marksheet, double e_fees, MultipartFile e_bonofide, MultipartFile e_income) {
		LoanApplicationDetails ldet = new LoanApplicationDetails();
		String e_hsc_marksheet_encoded = StringUtils.cleanPath(e_hsc_marksheet.getOriginalFilename());
		String e_bonofide_encoded = StringUtils.cleanPath(e_bonofide.getOriginalFilename());
		String e_income_encoded = StringUtils.cleanPath(e_income.getOriginalFilename());

		if (e_hsc_marksheet_encoded.contains("..") || e_bonofide_encoded.contains("..")
				|| e_income_encoded.contains("..")) {
			System.out.println("not a a valid file");
		}

		try {
			// setting encoded images
			ldet.setE_bonofide(Base64.getEncoder().encodeToString(e_bonofide_encoded.getBytes()));
			ldet.setE_hsc_marksheet(Base64.getEncoder().encodeToString(e_hsc_marksheet_encoded.getBytes()));
			ldet.setE_income(Base64.getEncoder().encodeToString(e_income_encoded.getBytes()));
		} catch (Throwable e) {
			throw new MultipartException("e", e);
		}
		// setting parameters
		ldet.setCust_Accno(cust_Accno);
		ldet.setCust_Name(cust_Name);
		ldet.setCust_loan_type(cust_loan_type);
		ldet.setE_hsc_mark(e_hsc_mark);
		ldet.setE_fees(e_fees);

		// saving object
		lDet_repo.save(ldet);
	}

	@Override
	public void setFarmer(Long cust_Accno, String cust_Name, String cust_loan_type, String f_farmer_id,
			MultipartFile f_farmer_id_photo, String f_patta_no, MultipartFile f_patta_photo, String f_need,
			double f_farmer_quotaion) {
		LoanApplicationDetails ldet = new LoanApplicationDetails();
		String f_farmer_id_photo_encoded = StringUtils.cleanPath(f_farmer_id_photo.getOriginalFilename());
		String f_patta_photo_encoded = StringUtils.cleanPath(f_patta_photo.getOriginalFilename());

		if (f_farmer_id_photo_encoded.contains("..") || f_patta_photo_encoded.contains("..")) {
			System.out.println("not a a valid file");
		}

		try {
			// setting encoded images
			ldet.setF_farmer_id_photo(Base64.getEncoder().encodeToString(f_farmer_id_photo_encoded.getBytes()));
			ldet.setF_patta_photo(Base64.getEncoder().encodeToString(f_patta_photo_encoded.getBytes()));
		} catch (Throwable e) {
			throw new MultipartException("e", e);
		}
		// setting parameters
		ldet.setCust_Accno(cust_Accno);
		ldet.setCust_Name(cust_Name);
		ldet.setCust_loan_type(cust_loan_type);
		ldet.setF_farmer_id(f_farmer_id);
		ldet.setF_patta_no(f_patta_no);
		ldet.setF_need(f_need);
		ldet.setF_farmer_quotaion(f_farmer_quotaion);

		// saving object
		lDet_repo.save(ldet);
	}

	@Override
	public void setPersonal(Long cust_Accno, String cust_Name, String cust_loan_type, double p_salary,
			MultipartFile p_payslip, MultipartFile p_bankStatement, MultipartFile p_request_letter, String p_need,
			String p_quotaion) {

		LoanApplicationDetails ldet = new LoanApplicationDetails();
		String p_payslip_encoded = StringUtils.cleanPath(p_payslip.getOriginalFilename());
		String p_bankStatement_encoded = StringUtils.cleanPath(p_bankStatement.getOriginalFilename());
		String p_request_letter_encoded = StringUtils.cleanPath(p_request_letter.getOriginalFilename());

		if (p_payslip_encoded.contains("..") || p_bankStatement_encoded.contains("..")
				|| p_request_letter_encoded.contains("..")) {
			System.out.println("not a a valid file");
		}

		try {
			// setting encoded images
			ldet.setP_payslip(Base64.getEncoder().encodeToString(p_payslip_encoded.getBytes()));
			ldet.setP_bankStatement(Base64.getEncoder().encodeToString(p_payslip_encoded.getBytes()));
			ldet.setP_request_letter(Base64.getEncoder().encodeToString(p_request_letter_encoded.getBytes()));
		} catch (Throwable e) {
			throw new MultipartException("e", e);
		}
		// setting parameters
		ldet.setCust_Accno(cust_Accno);
		ldet.setCust_Name(cust_Name);
		ldet.setCust_loan_type(cust_loan_type);
		ldet.setP_salary(p_salary);
		ldet.setP_need(p_need);
		ldet.setP_quotaion(p_quotaion);

		// saving object
		lDet_repo.save(ldet);
	}

	@Override
	public void setHome(Long cust_Accno, String cust_Name, String cust_loan_type, String h_patta_no,
			MultipartFile h_landdocument, MultipartFile h_land_photos, double h_quotaion) {

		LoanApplicationDetails ldet = new LoanApplicationDetails();
		String h_landdocument_encoded = StringUtils.cleanPath(h_landdocument.getOriginalFilename());
		String h_land_photos_encoded = StringUtils.cleanPath(h_land_photos.getOriginalFilename());

		if (h_landdocument_encoded.contains("..") || h_land_photos_encoded.contains("..")) {
			System.out.println("not a a valid file");
		}

		try {
			// setting encoded images
			ldet.setH_landdocument(Base64.getEncoder().encodeToString(h_landdocument_encoded.getBytes()));
			ldet.setH_land_photos(Base64.getEncoder().encodeToString(h_land_photos_encoded.getBytes()));
		} catch (Throwable e) {
			throw new MultipartException("e", e);
		}
		// setting parameters
		ldet.setCust_Accno(cust_Accno);
		ldet.setCust_Name(cust_Name);
		ldet.setCust_loan_type(cust_loan_type);
		ldet.setH_patta_no(h_patta_no);
		ldet.setH_quotaion(h_quotaion);

		// saving object
		lDet_repo.save(ldet);

	}

	@Override
	public void setGold(Long cust_Accno, String cust_Name, String cust_loan_type, float g_gold_weight, String g_bill,
			MultipartFile g_bill_photo) {

		LoanApplicationDetails ldet = new LoanApplicationDetails();
		String g_bill_photo_encoded = StringUtils.cleanPath(g_bill_photo.getOriginalFilename());

		if (g_bill_photo_encoded.contains("..")) {
			System.out.println("not a a valid file");
		}

		try {
			// setting encoded images
			ldet.setG_bill_photo(Base64.getEncoder().encodeToString(g_bill_photo_encoded.getBytes()));
		} catch (Throwable e) {
			throw new MultipartException("e", e);
		}
		// setting parameters
		ldet.setCust_Accno(cust_Accno);
		ldet.setCust_Name(cust_Name);
		ldet.setCust_loan_type(cust_loan_type);
		ldet.setG_gold_weight(g_gold_weight);

		// saving object
		lDet_repo.save(ldet);

	}

//	@Override
//	public void setEducation(Long cust_Accno, String cust_Name, String cust_loan_type, int e_hsc_mark,
//			String e_hsc_marksheet, double e_fees, String e_bonofide, String e_income) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void setFarmer(Long cust_Accno, String cust_Name, String cust_loan_type, String f_farmer_id,
//			String f_farmer_id_photo, String f_patta_no, String f_patta_photo, String f_need,
//			double f_farmer_quotaion) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void setPersonal(Long cust_Accno, String cust_Name, String cust_loan_type, double p_salary, String p_payslip,
//			String p_bankStatement, String p_request_letter, String p_need, String p_quotaio) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void setHome(Long cust_Accno, String cust_Name, String cust_loan_type, String h_patta_no,
//			String h_landdocument, String h_land_photos, double h_quotaion) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void setGold(Long cust_Accno, String cust_Name, String cust_loan_type, float g_gold_weight, String g_bill,
//			String g_bill_photo) {
//		// TODO Auto-generated method stub
//		
//	}

}
