package com.finance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.finance.model.LoanApplicationDetails;
import com.finance.repository.CustomerRepository;
import com.finance.repository.LoanApplicationDetailsRepository;
import com.finance.repository.LoanAuthorityRepository;
import com.finance.repository.ManagerRepository;

@Service
public class LoanApplicationDetailsServiceImpl implements  LoanApplicationDetailsService{

	@Autowired
	CustomerRepository cust_repo;
	
	@Autowired
	ManagerRepository manager_repo;
	@Autowired
	LoanApplicationDetailsRepository lDet_repo;
	
	@Autowired
	LoanAuthorityRepository lAuth_repo;
	
	
	
	public List<LoanApplicationDetails> find()
	{
		return lDet_repo.findAll();
	}
	
	public void save(LoanApplicationDetails lDet) {
		lDet_repo.save(lDet);
	}
	
	public LoanApplicationDetails getLoanApplicationDetails(long cust_Accno) {
		return lDet_repo.findById(cust_Accno).get();
	}
	
	public void delete(long cust_Accno) {
		lDet_repo.deleteById(cust_Accno);
	}
	public void update(LoanApplicationDetails lDet) {
		List<LoanApplicationDetails> list_LoanApplicationDetails = find();
		for(LoanApplicationDetails cus: list_LoanApplicationDetails) {
			if(cus.getCust_Accno()==(lDet.getCust_Accno())){
				lDet_repo.save(lDet);
			}
			else {
				System.out.println("Wrong LoanApplicationDetails Id");
			}
		}
	}

	@Override
	public LoanApplicationDetails currentCustomerLoan(Long cust_accNo) {
		LoanApplicationDetails currentCustomerLoan=lDet_repo.currentCustomerLoan(cust_accNo);
		return currentCustomerLoan;
	}

	@Override
	public List<LoanApplicationDetails> currentCustomerLoanPending() {
		
		return lDet_repo.currentCustomerLoanPending();
	}

	@Override
	public List<LoanApplicationDetails> currentCustomerLoanAccepted() {
		return lDet_repo.currentCustomerLoanAccepted();
	}

	@Override
	public List<LoanApplicationDetails> currentCustomerLoanRejected() {
		return lDet_repo.currentCustomerLoanRejected();
	}

	@Override
	public List<LoanApplicationDetails> currentCustomerLoanAcceptedManager() {
		return lDet_repo.currentCustomerLoanAcceptedManager();

	}

	@Override
	public List<LoanApplicationDetails> currentCustomerLoanRejectedManager() {
		return lDet_repo.currentCustomerLoanRejectedManager();

	}

	@Override
	public List<LoanApplicationDetails> currentCustomerLoanPendingManager() {

		return lDet_repo.currentCustomerLoanPendingManager();
	}

	
	
	

	
}
