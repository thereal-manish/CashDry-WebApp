package com.finance.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.finance.model.Customer;
import com.finance.model.LoanAuthority;
import com.finance.model.Manager;
import com.finance.repository.CustomerRepository;
import com.finance.repository.LoanAuthorityRepository;
import com.finance.repository.ManagerRepository;
import com.finance.service.CustomerService;
import com.finance.service.LoanAuthorityService;
import com.finance.service.ManagerService;



@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	CustomerRepository cust_repo;
	@Autowired
	LoanAuthorityRepository loanAuth_repo;
	@Autowired
	ManagerRepository mana_repo;
	@Autowired
	CustomerService cusService;
	@Autowired
	LoanAuthorityService laaService;
	@Autowired
	ManagerService manaService;
	
	
	@GetMapping("/dashBoard")
	public String adminDashborad(Model model) {
		List<Manager> listmanager = manaService.find();
		model.addAttribute("listmanager", listmanager);
		List<LoanAuthority> listlaa = laaService.find();
		model.addAttribute("listlaa", listlaa);
		return "AdminDashBoard/AdminDashboard";
	}
	@GetMapping("/manager")
	public String adminDashboradManager(Model model) {
		List<Manager> listmanager = manaService.find();
		model.addAttribute("listmanager", listmanager);
		return "AdminDashBoard/adminManagerDetails";
		
	}
	
//	@RequestMapping("/")
//	public String viewHomePage(Model model) {
//		List<Manager> listmanager = manaService.find();
//		model.addAttribute("listmanager", listmanager);
//		
//		return  "AdminDashBoard/AdminDashboard";
//	}
	@GetMapping("/authority")
	public String adminDashboradAuthority(Model model) {
		List<LoanAuthority> listlaa = laaService.find();
		model.addAttribute("listlaa", listlaa);
		return "AdminDashBoard/adminLoanAuthorityDetails";
	}
	@GetMapping("/customer")
	public String adminDashboradCustomer(Model model) {
		List<Customer> listcustomer = cusService.find();
		model.addAttribute("listcustomer", listcustomer);
		model.addAttribute("pic", "/images/customer.png");
		model.addAttribute("sign","/images/sign.png");
		return "AdminDashBoard/adminCustomerDetails";
	}
	@GetMapping("/logout")
	public String adminDashboradLogout() {
		return "index";
	}
	
	@GetMapping("/manageUpdate")
	public String updateManage() {
		
		return "AdminDashBoard/adminManagerUpdate";
	}
	@GetMapping("/manageDelete")
	public String DeleteManage() {
		
		return "adminCustomerUpdate";
	}
	
	@GetMapping("/loanAuthUpdate")
	public String updateLoanAuth() {
		
		return "adminCustomerUpdate";
	}
//	@GetMapping("/loanAuthUpdate")
//	public String deleteLoanAuth() {
//		
//		return "adminCustomerDelete";
//	}
//	
	@GetMapping("/managerAdd")
	public String addManagers() {
		
		
		return "AdminDashBoard/adminManagerAdd";
	}
	
	@GetMapping("/laaAdd")
	public String addLaa() {
		
		
		return "AdminDashBoard/adminLoanAuthorityAdd";
	}

	
	
	
	@RequestMapping(value = "/saveCus", method = RequestMethod.POST)
	public String saveCust(@ModelAttribute("customer") Customer customer) {
		cusService.save(customer);
		
		return "redirect:/dashBoard";
	}
	
	@RequestMapping("/editCus/{id}")
	public ModelAndView showCust(@PathVariable(name = "id") Long id) {
		
		ModelAndView mav = new ModelAndView("adminCustomerUpdate");
		
		Customer customer1 = cusService.get(id);
		
		mav.addObject("customer", customer1);
		
		return mav;
	}	
	
	@RequestMapping("/deleteCus/{id}")
	public String deleteProduct(@PathVariable(name = "id") Long id) {
		cusService.delete(id);
		
		return "redirect:/dashBoard";
	}
	
	@PostMapping("/addingLoanAuthority")
	public String addingLoanAuthority(@ModelAttribute("loanAuthority") LoanAuthority Laa,Model mod) {
	
		laaService.save(Laa);

		mod.addAttribute("loanAuthority",Laa);
		
		return "redirect:/admin/dashBoard";
	}
	
	@RequestMapping(value = "/saveLaa", method = RequestMethod.POST)
	public String saveLoanAuth(@ModelAttribute("loan_Auth") LoanAuthority loanAuth) {
		laaService.save(loanAuth);
		
		return "redirect:/dashBoard";
	}
	
	@RequestMapping("/editLaa/{id}")
	public ModelAndView showEditLoanAuth(@PathVariable(name = "id") String id) {
		
		ModelAndView mav = new ModelAndView("adminLoanAuthorityUpdate");
		
		LoanAuthority loan_auth = laaService.getLoanAuthority(id);
		
		mav.addObject("loanAutho", loan_auth);
		
		return mav;
	}	
	
	@RequestMapping("/deleteLaa/{id}")
	public String deleteLaa(@PathVariable(name = "id") String id) {
		laaService.delete(id);
		
		return "redirect:/dashBoard";
	}
	
	//manager methods
	@PostMapping("/addingManager")
	public String addingManager(@ModelAttribute("manager") Manager manager,Model mod) {
		System.out.println(manager.getM_name());
		manaService.save(manager);
		mod.addAttribute("manager",manager);
		
		return "redirect:/admin/dashBoard";
	}

	@PostMapping("/savemana/{managerId}")
	public String savemana(@PathVariable("managerId")String managerId, @ModelAttribute("manager") Manager manager,Model mod) {
		System.out.println("saved");
		manaService.save(manager);
		System.out.println("after saved");

		
		return "redirect:/admin/dashBoard";
	}
	
	@GetMapping("editmana/{managerId}")
	public String showEditMana(@PathVariable(name = "managerId") String managerId,Model mod) {
		
		Manager manager = manaService.currentManager(managerId);
		
		mod.addAttribute("manager",manager);
	
		
		return "AdminDashBoard/adminManagerUpdate";
	}	
	
	@GetMapping("/deletemana/{managerId}")
	public String deletemana(@PathVariable(name = "managerId") String managerId) {
		manaService.delete(managerId);
		
		return "redirect:/admin/dashBoard";
	}
	
	
	
	
	//laa methods
	@PostMapping("/addinglaa")
	public String addingLAA(@ModelAttribute("loanAuhtority") LoanAuthority lauth,Model mod) {
		laaService.save(lauth);
		mod.addAttribute("loanAuthority",lauth);
		
		return "redirect:/admin/dashBoard";
	}

	@PostMapping("/savelaa/{loanAuth_Id}")
	public String saveLAA(@PathVariable("loanAuth_Id")String loanAuth_Id, @ModelAttribute("loanAuthority") LoanAuthority lauth,Model mod) {
		laaService.save(lauth);

		
		return "redirect:/admin/dashBoard";
	}
	
	@GetMapping("editlaa/{loanAuth_Id}")
	public String showEditLAA(@PathVariable(name = "loanAuth_Id") String loanAuth_Id,Model mod) {
		
//System.out.println("before"+loanAuth_Id);
		
		LoanAuthority lauth = laaService.currentLoanAuthority(loanAuth_Id);
//		System.out.println(lauth.getLoanAuth_Id());
		mod.addAttribute("loanAuthority",lauth);
	
		
		return "AdminDashBoard/adminLoanAuthorityUpdate";
	}	
	
	@GetMapping("/deletelaa/{loanAuth_Id}")
	public String deleteLAA(@PathVariable(name = "loanAuth_Id") String loanAuth_Id) {
		laaService.delete(loanAuth_Id);
		
		return "redirect:/admin/dashBoard";
	}
	
}
