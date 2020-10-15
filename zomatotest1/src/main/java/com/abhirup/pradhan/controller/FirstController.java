package com.abhirup.pradhan.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.abhirup.pradhan.model.*;
import com.abhirup.pradhan.service.*;

@RestController
public class FirstController {
	
	@Autowired
	private CustomerService cusS;
	@Autowired
	private EmployeeService empS;
	@Autowired
	private ProductService proS;
	@Autowired
	private RestaurantService resS;
	
	
	/*****************************Cookie***************************/
	
	public void setCookie(HttpServletResponse response, String id, String idval) {
		Cookie cookie = new Cookie(id,idval);
		cookie.setMaxAge(60*60);
		response.addCookie(cookie);
	}
	
	public void deleteCookie(HttpServletResponse response, String id) {
		Cookie cookie = new Cookie(id,null);
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}
	
	public String getCookie(HttpServletRequest request, String id) throws Exception {
		return WebUtils.getCookie(request, id).getValue();
	} 
	
	/***************************login*****************************/
	
	
	
	/*****************************pages***********************/
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
		Customer cus = new Customer();
		mv.addObject("customer",cus);
		mv.addObject("act","createcustomer");
		return mv;
	}

	@RequestMapping("/EmployeeReg.html")
	public ModelAndView index5(ModelAndView mv) {
		mv.setViewName("EmployeeReg");
		Employee emp = new Employee();
		mv.addObject("employee", emp);
		mv.addObject("act2","createemployee");
		return mv;
	}
	
	@RequestMapping("/RestaurantReg.html")
	public ModelAndView index6(ModelAndView mv) {
		mv.setViewName("RestaurantReg");
		Restaurant res = new Restaurant();
		mv.addObject("rest", res);
		mv.addObject("act3","createrestaurant");
		return mv;
	}
	
	@RequestMapping("/RestaurantLogin.html")
	public ModelAndView index7(ModelAndView mv) {
		mv.setViewName("RestaurantLogin");
		return mv;
	}
	
	@RequestMapping("/ProductAdd.html")
	public ModelAndView index8(ModelAndView mv) {
		mv.setViewName("ProductAdd");
		mv.addObject("product",new Product());
		mv.addObject("act4","addproduct");
		return mv;
	}
	
	@RequestMapping("/editcustomer1")
	public ModelAndView index10(String id,ModelAndView mv) {
		mv.setViewName("CustomerReg");
		Customer customer = cusS.getCustomer(id);
		mv.addObject("customer",customer);
		mv.addObject("act","editcustomer");
		return mv;
	}
	
	@RequestMapping("/editemployee1")
	public ModelAndView index11(String id,ModelAndView mv) {
		mv.setViewName("EmployeeReg");
		Employee emp = empS.getEmployee(id);
		mv.addObject("employee",emp);
		mv.addObject("act2","editemployee");
		return mv;
	}
	
	@RequestMapping("/editrestaurant1")
	public ModelAndView index12(String id,ModelAndView mv) {
		mv.setViewName("RestaurantReg");
		Restaurant res = resS.getRestaurant(id);
		mv.addObject("rest", res);
		mv.addObject("act3","editrestaurant");
		return mv;
	}
	
	@RequestMapping("/editproduct1")
	public ModelAndView index13(int id,ModelAndView mv) {
		mv.setViewName("ProductAdd");
		Product pro = proS.getProduct(id);
		mv.addObject("product", pro);
		mv.addObject("act4","editproduct");
		return mv;
	}
	/********************************get details and add details************************/
	
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
	
	@PostMapping("/editcustomer")
	public ModelAndView editCustomer(Customer customer,ModelAndView mv) {
		cusS.editCustomer(customer);
		return getCustomers(mv);
	}
	
	@GetMapping("/deletecustomer")
	public ModelAndView deleteCustomer(String id, ModelAndView mv) {
		cusS.deleteCustomer(id);
		return getCustomers(mv);
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

	
	@PostMapping("/editemployee")
	public ModelAndView editEmp(Employee emp,ModelAndView mv) {
		empS.editEmployee(emp);
		return getEmployees(mv);
	}
	
	@GetMapping("/deleteemployee")
	public ModelAndView deleteEmp(String id, ModelAndView mv) {
		empS.deleteEmployee(id);
		return getEmployees(mv);
	}
	
	@PostMapping("/createrestaurant")
	public void addRestaurant(Restaurant restaurant) {
		resS.addRestaurant(restaurant);
	}
	
	@GetMapping("/getrestaurants")
	public ModelAndView getRestaurants(ModelAndView mv) {
		mv.setViewName("Restaurants");
		mv.addObject("restaurants",resS.getRestaurants());
		return mv;
	}
	
	@PostMapping("/editrestaurant")
	public ModelAndView editRes(Restaurant res,ModelAndView mv) {
		resS.editRestaurant(res);
		return getRestaurants(mv);
	}
	
	@GetMapping("/deleterestaurant")
	public ModelAndView deleteRes(String id, ModelAndView mv) {
		Set<Product> products = new HashSet<Product>(resS.getRestaurant(id).getProduct());
		resS.deleteRestaurant(id);
		proS.deleteProduct(products);
		return getRestaurants(mv);
	}
	
	@PostMapping("/addproduct")
	public void addProduct(Product product,HttpServletRequest req) {
		try {
			String rest = getCookie(req,"restid");
			Restaurant restaurant = resS.getRestaurant(rest);
			restaurant.getProduct().add(product);
			proS.addProduct(product);
			resS.addRestaurant(restaurant);
		}catch(Exception e) {
			
		}
	}
	
	@PostMapping("/editproduct")
	public ModelAndView editProduct(Product product,ModelAndView mv,HttpServletRequest req) {
		proS.editProduct(product);
		return getProducts(req,mv);
	}
	
	@GetMapping("/deleteproduct")
	public ModelAndView deleteProduct(int id , ModelAndView mv, HttpServletRequest req) {
		try {
		Restaurant rest = resS.getRestaurant(getCookie(req,"restid"));
		Product pro = proS.getProduct(id);
		rest.getProduct().remove(pro);
		resS.editRestaurant(rest);
		proS.deleteOneproduct(id);
		}catch(Exception e) {
			
		}
		return getProducts(req,mv);
	}
	@GetMapping("/getproducts")
	public ModelAndView getProducts(HttpServletRequest req,ModelAndView mv) {
		mv.setViewName("Products");
		try {
		String id = getCookie(req,"restid");
		Restaurant rest = resS.getRestaurant(id);
		mv.addObject("products",rest.getProduct());
		}catch(Exception e) {
		Restaurant rest = new Restaurant();
		mv.addObject("products",rest.getProduct());
		}
		return mv;
	}

	@PostMapping("/customerlogin")
	public ModelAndView cusLogin(String emailid, String upswd ,ModelAndView mv,HttpServletResponse response) {
		Customer customer = cusS.getCustomer(emailid);
		if(customer!=null && emailid.equals(customer.getCustomer_Id()) && upswd.equals(customer.getCustomer_Password())) {
			mv.setViewName("welcome");
			setCookie(response,"cusid",customer.getCustomer_Id());
			mv.addObject("user", customer.getCustomer_Id());
		}else {
			mv.setViewName("rejection");
		}
		return mv;
	}
	
	@GetMapping("/customerlogout")
	public ModelAndView cusLogOut(HttpServletResponse response, HttpServletRequest request) {
		deleteCookie(response,"cusid");
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	
	@PostMapping("/employeelogin")
	public ModelAndView empLogin(String emailid, String upswd ,ModelAndView mv,HttpServletResponse response) {
		Employee employee = empS.getEmployee(emailid);
		if(employee != null && emailid.equals(employee.getEmployee_Id()) && upswd.equals(employee.getEmployee_Password())) {
			setCookie(response,"empid",employee.getEmployee_Id());
			employee.setActive(1);
			empS.addEmployee(employee);
			mv.setViewName("welcome");
			mv.addObject("user", employee.getEmployee_Id());
		}else {
			mv.setViewName("rejection");
		}
		return mv;
	}
	
	@GetMapping("/employeelogout")
	public ModelAndView cusLogOutEmp(HttpServletResponse response, HttpServletRequest request) {
		try {
		String id = getCookie(request,"empid");
		Employee emp = empS.getEmployee(id);
		emp.setActive(0);
		empS.addEmployee(emp);
		}catch(Exception e){
			
		}
		deleteCookie(response,"empid");
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}	
	
	@PostMapping("/restaurantlogin")
	public ModelAndView restLogin(String emailid, String upswd ,ModelAndView mv,HttpServletResponse response) {
		Restaurant rest = resS.getRestaurant(emailid);
		if(rest != null && emailid.equals(rest.getRestaurant_Id()) && upswd.equals(rest.getRestaurant_Password())) {
			setCookie(response,"restid",rest.getRestaurant_Id());
			rest.setRestaurant_Open(1);
			resS.addRestaurant(rest);
			mv.setViewName("welcome");
			mv.addObject("user", rest.getRestaurant_Id());
		}else {
			mv.setViewName("rejection");
		}
		return mv;
	}
	
	@GetMapping("/restaurantlogout")
	public ModelAndView restLogOutEmp(HttpServletResponse response, HttpServletRequest request) {
		try {
		String id = getCookie(request,"restid");
		Restaurant rest = resS.getRestaurant(id);
		rest.setRestaurant_Open(0);
		resS.addRestaurant(rest);
		}catch(Exception e){
			
		}
		deleteCookie(response,"restid");
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}	
	
	@GetMapping("/cookiedet")
	public void cookiedt(HttpServletRequest req) {
		try {
			System.out.println(getCookie(req,"cusid"));
		}catch(Exception e) {
			System.out.println("cus excep");
		}
		try {
			System.out.println(getCookie(req,"empid"));
		}catch(Exception e) {
			System.out.println("emp excep");
		}
		try {
			System.out.println(getCookie(req,"restid"));
		}catch(Exception e) {
			System.out.println("cus excep");
		}
	}
}
