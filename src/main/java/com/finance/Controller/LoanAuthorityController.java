package com.finance.Controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.finance.model.Customer;
import com.finance.model.LoanAuthority;
import com.finance.service.LoanAuthorityService;

@Controller

public class LoanAuthorityController {
	
	@Autowired
	LoanAuthorityService loanAuthorityService;
	
	@GetMapping("/loanAuthorityDetails")
	public List<LoanAuthority> getloanAuthorityDetails(){
		return loanAuthorityService.find();
	}
	
	@GetMapping("/{loanAuth_Id}")
	public LoanAuthority getloanAuthorityDetailsById(@PathVariable(value="loanAuth_Id") String loanAuth_Id) {
		return loanAuthorityService.getLoanAuthority(loanAuth_Id);
	}
	
	@GetMapping("/loanAuthorityloginPage")
	public String showForm(LoanAuthority loanAuthority) {
		return "loanauthoritylogin";
	}
	
	@PostMapping("/loanAuthorityloginPageValidation")
	public String getValidation(@Valid @ModelAttribute("loanAuthority") LoanAuthority loanAuthority, BindingResult br, Model model) {
		if (br.hasErrors()) {
			return "loanauthoritylogin";
		} else {

			List<LoanAuthority> list = loanAuthorityService.find();
			String pass = "";
			for (LoanAuthority l : list) {

				String mail = l.getLoanAuth_email();
				if (mail.equals(loanAuthority.getLoanAuth_email())) {
					pass = l.getLoanAuth_password();
				}
				else
				{
					model.addAttribute("nouser", "No Authorities found ");
					return "loanauthoritylogin";
				}
				if(pass.equals(loanAuthority.getLoanAuth_password())) {
					return "redirect:/LAADashBoard/LAAdashboardDetails";
				}
				else
				{
					model.addAttribute("nopassword", "Invalid Password");
					return "loanauthoritylogin";
				}
				
			}

			
			return "loanauthoritylogin";
		}

	}
	@PostMapping("/newloanAuthority")
	public Map<String,Object> addNewloanAuthority(@RequestParam (value="loanAuth_Id") String loanAuth_Id,
			@RequestParam (value="loanAuth_name") String loanAuth_name,
			@RequestParam (value="loanAuth_email") String loanAuth_email,
			@RequestParam (value="loanAuth_address") String loanAuth_address,
			@RequestParam (value="loanAuth_phoneNumber") Long loanAuth_phoneNumber,
			@RequestParam (value="loanAuth_password") String loanAuth_password,
			@RequestParam (value="loanAuth_department") String loanAuth_department){
		LoanAuthority lau = new LoanAuthority( loanAuth_Id,  loanAuth_name,  loanAuth_email,  loanAuth_address,
				 loanAuth_phoneNumber,  loanAuth_password,  loanAuth_department);
		loanAuthorityService.save(lau);
		Map<String,Object> map = new HashMap<>();
		map.put("Status", "Sucessfully added....!");
		return map;
	}
	@PutMapping("/updateloanAuthority")
	public LoanAuthority updateloanAuthority(@RequestBody LoanAuthority loanAuthority) {
		loanAuthorityService.update(loanAuthority);
		return loanAuthority;
	}
	
	@DeleteMapping("/deleteloanAuthority/{loanAuth_Id}")
	public Map<String,Object> deleteloanAuthority(@PathVariable(value="loanAuth_Id") String loanAuth_Id)
	{
		loanAuthorityService.delete(loanAuth_Id);
		Map<String,Object> map = new HashMap<>();
		map.put("Status", "Sucessfully deleted....!");
		return map;
	}
}
