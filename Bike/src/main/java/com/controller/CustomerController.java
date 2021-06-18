package com.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.dao.*;
import com.entity.*;


@Controller
public class CustomerController {

	static int q;
	
	//
	@RequestMapping("/c")
	public String c() 
	{
		return "customer/index";
	}
	//
	@RequestMapping("/login")
	public String login() {
		return "customer/login";	
	}


	//for home
	@RequestMapping("/see")
	public String sai(HttpServletRequest req,HttpServletResponse res) {
		String id=req.getParameter("Id");
		String pass=req.getParameter("Pass");
		System.out.println(id+" "+pass);
		return CustomerDao.CheckIdPassword(id,pass);
		
	}

	//home 
	@RequestMapping("/hoome")
	public String saia() {
		return "customer/hoome";		
	}

	//it will return the registration page
	@RequestMapping("/regs")
	public String showForm(Model mv) {
		mv.addAttribute("customer", new Customer());	
		return "registrationform";	
	}
	//it will return the registration page
	@RequestMapping("/regi")
	public String registration(Model mv) {
		mv.addAttribute("customer", new Customer());	
		return "customer/custregform";	
	}

	//it will save the data into collection after oopen the data
	@RequestMapping(value="/saves",method = RequestMethod.POST)    
	public String save(@ModelAttribute("customer") Customer cus){
		CustomerDao.save(cus);   
		return "redirect:/views";//will redirect to viewsemp request mapping    
	}
	//it will save the data into collection after open the login page
	@RequestMapping(value="/custsave",method = RequestMethod.POST)    
	public String Customersave(@ModelAttribute("customer") Customer cus){
		CustomerDao.save(cus);   
		return "redirect:/c";//will redirect to viewsemp request mapping    
	}

	//it give cus by id
	@RequestMapping("/profile")
	public String profile(Model mv) {
		System.out.println("controller"+CustomerDao.a);
		Customer cus= CustomerDao.getCustById(CustomerDao.a);
		//System.out.println("after "+cus.getId());
		mv.addAttribute("cus",cus);
		return "customer/profile";	
	}

	
	//it retrive the editform in cust
	@RequestMapping("/custedit/{id}")
	public String custedit(@PathVariable int id,Model mv) {
		System.out.println(id);
		Customer cus=CustomerDao.getCustById(id);  
		mv.addAttribute("customer", cus);
		return "customer/custedit";	
	}

	
	// It updates model object at cust
	@RequestMapping(value="/custedit/updatecustomer",method = RequestMethod.POST)    
	public String editsaveing(@ModelAttribute("customer") Customer cus){  
		System.out.println("updating");
		CustomerDao.update(cus);    
		System.out.println(cus);
		return "redirect:/hoome";    
	} 
	
	///it is use for customer
	@RequestMapping("/custview")    
	public String custview(Model m){    
		List<BikesData> list=BikeDao.getBikes();    
		m.addAttribute("list",list);  
		return "customer/custviewbikes";    
	}


	//log out page
	@RequestMapping(value="/logout")    
	public String logout(){   
		CustomerDao.out();
		return "redirect:/c";    
	} 

}