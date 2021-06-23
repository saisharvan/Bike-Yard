package com.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dao.*;
import com.entity.*;


@Controller
public class CustomerController {
	
	public static int cusId;
	public static int showId;
	public static int bikeId;

	static int q;
	
	 private static final Logger logger = LogManager.getLogger(CustomerController.class);
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
		BasicConfigurator.configure();  
		  logger.info(id+" "+pass);
		return CustomerDao.checkIdPassword(id,pass);
		
	}

	//home 
	@RequestMapping("/hoome")
	public String saia() {
		return "customer/hoome";		
	}

	
	//it will return the registration page
	@RequestMapping("/regi")
	public String registration(Model mv) {
		mv.addAttribute("customer", new Customer());	
		return "customer/custregform";	
	}

	//it will save the data into collection after oopen the data
	@RequestMapping(value="/saves")    
	public String save(@ModelAttribute("customer") Customer cus){
		CustomerDao.save(cus);   
		return "redirect:/views";//will redirect to viewsemp request mapping    
	}
	//it will save the data into collection after open the login page
	@RequestMapping(value="/custsave")    
	public String customerSave(@ModelAttribute("customer") Customer cus){
		CustomerDao.save(cus);   
		return "redirect:/c";//will redirect to viewsemp request mapping    
	}

	//it give cus by id
	@RequestMapping("/profile")
	public String profile(Model mv) {
		BasicConfigurator.configure();  
		  logger.info("controller"+CustomerDao.a);
		Customer cus= CustomerDao.getCustBy();
		logger.info("after "+cus.getId());
		mv.addAttribute("cus",cus);
		return "customer/profile";	
	}

	//////////////////////////////order
	//
	@RequestMapping("/custshowrooms")    
	public String viewShowAdmins(Model m){    
		List<ShowRoomAdmin> list=ShowroomDao.getShowRoomAdmins();    
		m.addAttribute("list",list);  
		return "customer/custshowadmin";    
	}
	//
		@RequestMapping("/book/{id}")
		public String cap(@PathVariable int id,Model mv) {
			BikesData bd=BikeDao.getbikBy(id);
			mv.addAttribute("bik", bd);
			return "customer/cap";		
		}
	
		@RequestMapping("/bookc/{id}")
		public static String book(@PathVariable int id) {
			BasicConfigurator.configure();  
			  logger.info(id);
			bikeId=id;
			BookingDao.savecusorder();
			return "customer/sucess";	
		}//mv addAttribute("customer", cus)
		//vb
		@RequestMapping("/viewbooking")
		public String bookedData(Model mv) {
			List<BookingData> list=BookingDao.getcusbooks(cusId);
			mv.addAttribute("list",list);
			return "customer/bookings";		
		}
	/////////////////////////////////
	//it retrive the editform in cust
	@RequestMapping("/custedit/{id}")
	public String custedit(@PathVariable int id,Model mv) {
		logger.info(id);
		Customer cus=CustomerDao.getCustBy();  
		mv.addAttribute("customer", cus);
		return "customer/custedit";	
	}

	
	// It updates model object at cust
	@RequestMapping(value="/custedit/updatecustomer")    
	public String editsaveing(@ModelAttribute("customer") Customer cus){ 
		BasicConfigurator.configure();  
		  logger.info("updating");
		CustomerDao.update(cus);    
		logger.info(cus);
		return "redirect:/hoome";    
	} 
///////////////////////////////////////////////////
	
	@RequestMapping("/custview/{id}")    
	public static String sacustview(@PathVariable int id,Model m){   
		showId=id;
		List<BikesData> list=BikeDao.getsrBikes(id);    
		m.addAttribute("list",list);  
		return "customer/custviewbikes";    
	}
//////////////////////////////////////////////////

	//log out page
	@RequestMapping(value="/logout")    
	public String logout(){   
		CustomerDao.out();
		return "redirect:/c";    
	} 

}