package com.abhirup.pradhan.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.abhirup.pradhan.model.*;
import com.abhirup.pradhan.service.*;

@RestController
public class SecondController {
	
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
	
	
	
	
}
