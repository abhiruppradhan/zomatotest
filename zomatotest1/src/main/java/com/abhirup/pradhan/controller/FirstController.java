package com.abhirup.pradhan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.abhirup.pradhan.model.*;
import com.abhirup.pradhan.service.*;

@RestController
public class FirstController {
	
	@Autowired
	private CustomerService cusS;
	@Autowired
	private EmployeeService empS;
	@Autowired
	private OrderService ordS;
	@Autowired
	private ProductService prodS;
	@Autowired
	private RestaurantService ResS;
	
	
	@RequestMapping("/")
	public ModelAndView index(ModelAndView mv) {
		mv.setViewName("index");
		return mv;
	}
	@RequestMapping("/CustomerLogin.html")
	public ModelAndView index2(ModelAndView mv) {
		mv.setViewName("CustomerLogin");
		return mv;
	}
	@RequestMapping("/EmployeeLogin.html")
	public ModelAndView index3(ModelAndView mv) {
		mv.setViewName("EmployeeLogin");
		return mv;
	}
	@RequestMapping("/CustomerReg.html")
	public ModelAndView index4(ModelAndView mv) {
		mv.setViewName("CustomerReg");
		return mv;
	}
	@RequestMapping("/EmployeeReg.html")
	public ModelAndView index5(ModelAndView mv) {
		mv.setViewName("EmployeeReg");
		return mv;
	}
	
	
	
	@PostMapping("/createcustomer")
	public void addCustomer(Customer customer) {
		cusS.addCustomer(customer);
	}
	
	@GetMapping("/getcustomers")
	public ModelAndView getCustomers(ModelAndView mv) {
		mv.setViewName("Customers");
		mv.addObject("customers",cusS.getCustomers());
		return mv;
	}

	@PostMapping("/createemployee")
	public void addEmployee(Employee employee) {
		empS.addEmployee(employee);
	}
	
	@GetMapping("/getemployees")
	public ModelAndView getEmployees(ModelAndView mv) {
		mv.setViewName("Employees");
		mv.addObject("employees",empS.getEmployees());
		return mv;
	}
	
	@PostMapping("/customerlogin")
	public ModelAndView cusLogin(String emailid, String upswd ,ModelAndView mv) {
		Customer customer = cusS.getCustomer(emailid);
		if(customer!=null && emailid.equals(customer.getCustomer_Id()) && upswd.equals(customer.getCustomer_Password())) {
			mv.setViewName("welcome");
			mv.addObject("user", customer.getCustomer_Id());
		}else {
			mv.setViewName("rejection");
		}
		return mv;
	}
	
	@PostMapping("/employeelogin")
	public ModelAndView empLogin(String emailid, String upswd ,ModelAndView mv) {
		Employee employee = empS.getEmployee(emailid);
		if(employee != null && emailid.equals(employee.getEmployee_Id()) && upswd.equals(employee.getEmployee_Password())) {
			mv.setViewName("welcome");
			mv.addObject("user", employee.getEmployee_Id());
		}else {
			mv.setViewName("rejection");
		}
		return mv;
	}
}
