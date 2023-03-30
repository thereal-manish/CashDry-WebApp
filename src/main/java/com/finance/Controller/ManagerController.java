package com.finance.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.finance.model.Manager;
import com.finance.service.CustomerService;
import com.finance.service.ManagerService;

@Controller

public class ManagerController {
	
	
	@Autowired
	ManagerService managerService;
	
	@GetMapping("/employeeLogin")
	public String employeeLogin() {
		return "employeeCard";
	}

	@GetMapping("/managerDetails")
	public List<Manager> getManagerDetails() {
		return managerService.find();
	}

	@GetMapping("/managerloginPage")
	public String showForm(Manager manager) {
		return "managerlogin";
	}

	@PostMapping("/managerloginPageValidation")
	public String getValidation(@Valid @ModelAttribute("manager") Manager manager, BindingResult br, Model model) {
		if (br.hasErrors()) {
			return "managerlogin";
		} else {

			List<Manager> list = managerService.find();
			String pass = "";
			for (Manager m : list) {

				String mail = m.getM_email();
				if (mail.equals(manager.getM_email())) {
					pass = m.getM_password();
				}
				else
				{
					model.addAttribute("nouser", "Manager account not found,Please contact admin");
					return "managerlogin";
				}
				if(pass.equals(manager.getM_password())) {
					return "redirect:/ManagerDashBoard/managerdashboardDetails";
				}
				else
				{
					model.addAttribute("nopassword", "Invalid Password");
					return "managerlogin";
				}
				
			}

			
			return "managerlogin";
		}

	}

	@GetMapping("/{managerId}")
	public Manager getmanagerDetailsById(@PathVariable(value = "managerId") String managerId) {
		return managerService.getManager(managerId);
	}

	@PostMapping("/newManager")
	public Map<String, Object> addNewManager(@RequestParam(value = "managerId") String managerId,
			@RequestParam(value = "m_name") String m_name, @RequestParam(value = "m_email") String m_email,
			@RequestParam(value = "m_address") String m_address,
			@RequestParam(value = "m_phoneNumber") Long m_phoneNumber,
			@RequestParam(value = "m_password") String m_password) {
		Manager m = new Manager(managerId, m_name, m_email, m_address, m_phoneNumber, m_password);
		managerService.save(m);
		Map<String, Object> map = new HashMap<>();
		map.put("Status", "Sucessfully added....!");
		return map;
	}

	@PutMapping("/updateManager")
	public Manager updateManager(@RequestBody Manager manager) {
		managerService.update(manager);
		return manager;
	}

	@DeleteMapping("/deleteManager/{managerId}")
	public Map<String, Object> deleteManager(@PathVariable(value = "managerId") String managerId) {
		managerService.delete(managerId);
		Map<String, Object> map = new HashMap<>();
		map.put("Status", "Sucessfully deleted....!");
		return map;
	}

}
