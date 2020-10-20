package com.abhirup.pradhan.controller;

import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	@Autowired
	private OrderService ordS;
	
	Set<Product> productslist;
	Restaurant restaurant;
	
	/****************************adminlogin************************/
	@RequestMapping("/Admin.html")
	public ModelAndView admin(ModelAndView mv) {
		mv.setViewName("Admin");
		return mv;
	}
	@PostMapping("/adminlogin")
	public ModelAndView adminlogin(String id,String pswd,HttpServletRequest req,HttpServletResponse res,ModelAndView mv) {
		if(id.equals("abhirup@gmail.com") && pswd.equals("1234")) {
			setCookie(res,"admin",id);
		}
		return index(mv,req);
	}
	
	@RequestMapping("/adminlogout")
	public ModelAndView adminlogout(HttpServletResponse res,HttpServletRequest req,ModelAndView mv) {
		try {
			deleteCookie(res,"admin");
		}catch(Exception e) {
			
		}
		return index(mv,req);
	}
	/*****************************Cookie***************************/
	
	public void setCookie(HttpServletResponse response, String id, String idval) {
		Cookie cookie = new Cookie(id,idval);
		cookie.setMaxAge(60*60*24*7);
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
	
	/**********************customer login************************/

	@PostMapping("/customerlogin")
	public ModelAndView cusLogin(String emailid, String upswd ,ModelAndView mv,HttpServletResponse response,HttpServletRequest req) {
		Customer customer = cusS.getCustomer(emailid);
		if(customer!=null && emailid.equals(customer.getCustomer_Id()) && upswd.equals(customer.getCustomer_Password())) {
			setCookie(response,"cusid",customer.getCustomer_Id());
		}else {
			mv.setViewName("rejection");
		}
		return index(mv,req);
	}
	
	@GetMapping("/customerlogout")
	public ModelAndView cusLogOut(ModelAndView mv,HttpServletResponse response, HttpServletRequest request) {
		deleteCookie(response,"cusid");
		return index(mv,request);
	}
	
	
	/**********************employee login************************/
	@PostMapping("/employeelogin")
	public ModelAndView empLogin(String emailid, String upswd ,ModelAndView mv,HttpServletResponse response,HttpServletRequest req) {
		Employee employee = empS.getEmployee(emailid);
		if(employee != null && emailid.equals(employee.getEmployee_Id()) && upswd.equals(employee.getEmployee_Password()) && (employee.getWorking()==1)) {
			setCookie(response,"empid",employee.getEmployee_Id());
			employee.setActive(1);
			empS.addEmployee(employee);
		}else {
			mv.setViewName("rejection");
		}
		return index(mv,req);
	}
	
	@GetMapping("/employeelogout")
	public ModelAndView empLogout(ModelAndView mv,HttpServletResponse response, HttpServletRequest request) {
		try {
		String id = getCookie(request,"empid");
		Employee emp = empS.getEmployee(id);
		emp.setActive(0);
		empS.addEmployee(emp);
		}catch(Exception e){
			
		}
		deleteCookie(response,"empid");
		return index(mv,request);
	}
	
	/**********************restaurant login**********************/
	
	@PostMapping("/restaurantlogin")
	public ModelAndView restLogin(String emailid, String upswd ,ModelAndView mv,HttpServletResponse response,HttpServletRequest req) {
		Restaurant rest = resS.getRestaurant(emailid);
		if(rest != null && emailid.equals(rest.getRestaurant_Id()) && upswd.equals(rest.getRestaurant_Password()) && (rest.getActive()==1)) {
			setCookie(response,"restid",rest.getRestaurant_Id());
			rest.setRestaurant_Open(1);
			resS.addRestaurant(rest);
		}else {
			mv.setViewName("rejection");
		}
		return index(mv,req);
	}
	
	@GetMapping("/restaurantlogout")
	public ModelAndView restLogOut(ModelAndView mv,HttpServletResponse response, HttpServletRequest request) {
		try {
		String id = getCookie(request,"restid");
		Restaurant rest = resS.getRestaurant(id);
		rest.setRestaurant_Open(0);
		resS.addRestaurant(rest);
		}catch(Exception e){
			
		}
		deleteCookie(response,"restid");
		return index(mv,request);
	}	
	/****************************customer**********************/
	
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
	/****************************employee**********************/

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
	
	/****************************restaurant********************/
	
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
	/****************************product***********************/
	
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
	
	/*****************************pages***********************/
	
	@RequestMapping("/")
	public ModelAndView index(ModelAndView mv,HttpServletRequest req) {
		mv.setViewName("index");
		String cust="",emp="",rest="",admin="";
		try {cust=getCookie(req,"cusid");}catch(Exception e) {}
		try {emp=getCookie(req,"empid");}catch(Exception e) {}
		try {rest=getCookie(req,"restid");}catch(Exception e) {}
		try {admin=getCookie(req,"admin");}catch(Exception e) {}
		boolean cust1=true,emp1=true,rest1=true,admin1=true;
		if(cust.equals(""))
			cust1=false;
		if(emp.equals(""))
			emp1=false;
		if(rest.equals(""))
			rest1=false;
		if(admin.equals(""))
			admin1=false;
		mv.addObject("cust",cust1);
		mv.addObject("emp",emp1);
		mv.addObject("rest",rest1);
		mv.addObject("admin",admin1);
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
	
/******************************** Order ********************************/
	@RequestMapping("/allrestaurant")
	public ModelAndView index14(ModelAndView mv) {
		mv.setViewName("AllRestaurants");
		mv.addObject("restaurants", resS.getRestaurants());
		return mv;
	}
	
	@GetMapping("/listoffood")
	public ModelAndView index15(String id , ModelAndView mv) {
		mv.setViewName("Foods");
		restaurant = resS.getRestaurant(id);
		mv.addObject("products", restaurant.getProduct());
		productslist = new HashSet<Product>();
		return mv;
	}
	
	@GetMapping("/addptoord")
	public ModelAndView index16(int id , ModelAndView mv) {
		mv.setViewName("Order");
		Product product = proS.getProduct(id);
		boolean exist = false;
		for ( Product p : productslist) {
			if(p.getProduct_Id() == product.getProduct_Id()) {
				exist = true;
				break;
			}
		}
		if(!exist) {
			productslist.add(product);
		}
		mv.addObject("productlist", productslist);
		double price=0;
		for(Product p: productslist) 
			price = price + p.getProduct_Price();
		mv.addObject("price", price);
		if(ordS.getOrders()==null) {
			List<OrderDet> orders = new ArrayList<OrderDet>();
			orders.add(new OrderDet());
			mv.addObject("orderlist",orders);
		}else {
			mv.addObject("orderlist",ordS.getOrders());	
		}
		mv.addObject("orderlist",ordS.getOrders());
		return mv;
	}
	
	@RequestMapping("/order")
	public ModelAndView orderProd(HttpServletRequest req){
		Customer customer = new Customer();
		Employee employee = new Employee();
		try {
			customer = cusS.getCustomer(getCookie(req,"cusid"));
			employee = empS.getEmployee(getCookie(req,"empid"));
		}catch(Exception e){
			
		}
		OrderDet newOrder = new OrderDet();
		newOrder.setRestaurant(restaurant);
		newOrder.setCustomer(customer);
		newOrder.setEmployee(employee);
		newOrder.setDate(new Date());
		newOrder.setProduct(productslist);
		double price=0;
		for(Product p: productslist) 
			price = price + p.getProduct_Price();
		newOrder.setPrice(price);
		ordS.addOrder(newOrder);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Order");
		mv.addObject("productslist", new HashSet<Product>());
		mv.addObject("price",0);
		mv.addObject("orderlist",ordS.getOrders());
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
			System.out.println("rest excep");
		}
		try {
			System.out.println(getCookie(req,"admin"));
		}catch(Exception e) {
			System.out.println("admin excep");
		}
	}
}
