package com.finance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.finance.model.LoanApplicationDetails;


public interface LoanApplicationDetailsRepository extends JpaRepository<LoanApplicationDetails, Long>{

	@Query("from LoanApplicationDetails where cust_accNo=:cust_accNo")
	public LoanApplicationDetails currentCustomerLoan(@Param(value="cust_accNo") Long cust_accNo) ;
	
	@Query("from LoanApplicationDetails where AuthorityStatus=null")
	public List<LoanApplicationDetails> currentCustomerLoanPending();

	@Query("from LoanApplicationDetails where AuthorityStatus='accepted'")
	public List<LoanApplicationDetails> currentCustomerLoanAccepted();

	@Query("from LoanApplicationDetails where AuthorityStatus='rejected'")
	public List<LoanApplicationDetails> currentCustomerLoanRejected();
	
	
	@Query("from LoanApplicationDetails where AuthorityStatus='accepted' AND ManagerStatus=null")
	public List<LoanApplicationDetails> currentCustomerLoanPendingManager();
	
	@Query("from LoanApplicationDetails where ManagerStatus='accepted'")
	public List<LoanApplicationDetails> currentCustomerLoanAcceptedManager();

	@Query("from LoanApplicationDetails where ManagerStatus='rejected'")
	public List<LoanApplicationDetails> currentCustomerLoanRejectedManager();
	
	
}
