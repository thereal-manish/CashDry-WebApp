package com.finance.service;

import java.util.List;
import java.util.Optional;

import com.finance.model.Customer;
import com.finance.model.LoanAuthority;
import com.finance.model.Manager;

public interface ManagerService {

	public List<Manager> find();

	public void save(Manager m);

	public Manager getManager(String managerId);

	public void delete(String managerId);

	public void update(Manager m);

	public Manager currentManager(String managerId);
	

}
