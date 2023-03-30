package com.finance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.finance.model.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
//	@Query("select from Customer where cust_email =:cust_email")
//	List<Customer> findByCus_email(@Param("cust_email") String cust_email);

	@Query("from Customer where cust_email=:cust_email AND cust_pass=:cust_pass")
	public Customer validateCustomer(@Param(value="cust_email") String cust_email, @Param(value="cust_pass") String cust_pass);
	
	@Query("from Customer where cust_accNo=:cust_accNo")
	public Customer currentCustomer(@Param(value="cust_accNo") Long cust_accNo) ;
	
	
}
