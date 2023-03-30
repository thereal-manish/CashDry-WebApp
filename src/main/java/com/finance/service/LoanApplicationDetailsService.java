package com.finance.service;

import java.util.List;

import com.finance.model.LoanApplicationDetails;

public interface LoanApplicationDetailsService {

	public List<LoanApplicationDetails> find();

	public void save(LoanApplicationDetails lDet);

	public LoanApplicationDetails getLoanApplicationDetails(long cust_Accno);

	public void delete(long cust_Accno);

	public void update(LoanApplicationDetails lDet);

	public LoanApplicationDetails currentCustomerLoan(Long cust_accNo);

	public List<LoanApplicationDetails> currentCustomerLoanPending();
	
	public List<LoanApplicationDetails> currentCustomerLoanAccepted();
	
	public List<LoanApplicationDetails> currentCustomerLoanRejected();
	
	public List<LoanApplicationDetails> currentCustomerLoanAcceptedManager();
	
	public List<LoanApplicationDetails> currentCustomerLoanRejectedManager();
	
	public List<LoanApplicationDetails> currentCustomerLoanPendingManager();
	

	
}
