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
public class AdminController {
	
	private static final Logger logger = LogManager.getLogger(AdminController.class);  
	 
	
	@RequestMapping("/")
	public String a() 
	{
		return "admin/z";
	}
	@RequestMapping("/a")
	public String s() 
	{
		return "admin/index";
	}
	
	@RequestMapping("/add")
	public String sai(HttpServletRequest req,HttpServletResponse res) {
		if(req.getParameter("Id").equals("Share") && req.getParameter("Pass").equals("1998")) 
		{
			return "redirect:/home";
		}else
		{
			return "admin/try";
		}
	}
	
	@RequestMapping("/home")
	public String share() 
	{
		return "admin/view";
	}
	
	//it will retrieve the data after click views details
		@RequestMapping("/views")    
		public String viewsemp(Model m){    
			List<Customer> list=CustomerDao.getCustomers();    
			m.addAttribute("list",list);  
			return "admin/viewform";    
		}
		
		//it retrieve the edit form
		@RequestMapping("/edits/{id}")
		public String edit(@PathVariable int id,Model mv) {
			BasicConfigurator.configure();  
			 logger.info(id);
			Customer cus=AdminDao.getCustById(id);
			mv.addAttribute("customer", cus);
			return "admin/editcustomer";	
		}
		// It updates model object.   
		@SuppressWarnings({ })
		@RequestMapping(value="/edits/updatecustomer")    
		public String editsave(@ModelAttribute("customer") Customer cus){  
			BasicConfigurator.configure();  
			 logger.info("updating customers");
			CustomerDao.update(cus); 
			logger.info(cus);
			return "redirect:/views";    
		} 
		//it will remove the customer data
	    @RequestMapping(value="/deletecustomer/{id}")    
	    public String custdelete(@PathVariable int id){    
	        AdminDao.delete(id);    
	        return "redirect:/views";    
	    } 
	    
////////////////////////////////////////////////////////////
	    
	    @RequestMapping("/aview")    
		public String viewShowAdmins(Model m){    
			List<ShowRoomAdmin> list=ShowroomDao.getShowRoomAdmins();    
			m.addAttribute("list",list);  
			return "admin/viewShowAdmins";    
		}
	    
	  //it retrive the editform in showt
		@RequestMapping("/ashowedit/{id}")
		public String showtedit(@PathVariable int id,Model mv) {
			BasicConfigurator.configure();  
			 logger.info(id);
			ShowRoomAdmin show=ShowroomDao.getShowById(id);  
			mv.addAttribute("ShowRoomAdmin", show);
			return "ShowRoomAdmin/ashowedit";	
		}

		
		// It updates model object at showt
		@RequestMapping(value="/ashowedit/aupdateshowroom")    
		public String editsaveing(@ModelAttribute("ShowRoomAdmin") ShowRoomAdmin show){  
			BasicConfigurator.configure();  
			 logger.info("updating showroom");
			ShowroomDao.update(show);   
			 logger.info(show);
			return "redirect:/aview";    
		} 
		//it will remove the bike data
	    @RequestMapping(value="/ashowdelete/{id}")    
	    public String showroomdelete(@PathVariable int id){    
	    	AdminDao.sdelete(id);    
	        return "redirect:/aview";    
	    } 
	    
/////////////////////////////////////////////////////////////
	  //booking details of customer
		@RequestMapping("/allbookings") 
		public String bookings(Model m) 
		{
			List<BookingData> list=BookingDao.getbook();
			m.addAttribute("list",list);
			return "admin/bookings";
		}
///////////////////////////////////////////////////////////////
			
			//it will return the registration page
			@RequestMapping("/reg")
			public String showForm(Model mv) {
				mv.addAttribute("bike", new BikesData());	
				return "admin/addbike";	
			}

			//it will save the data into collection after oopen the data
			@RequestMapping(value="/save")    
			public String save(@ModelAttribute("bike") BikesData cus){
				BikeDao.save(cus);   
				return "redirect:/view";//will redirect to viewemp request mapping    
			}

			//it will retrive the data after click view details
			@RequestMapping("/view")    
			public String viewemp(Model m){    
				List<BikesData> list=BikeDao.getBikes();    
				m.addAttribute("list",list);  
				return "admin/viewbikes";    
			}
			
			
			
			//it retrive the editform
			@RequestMapping("/bedit/{id}")
			public String bedit(@PathVariable int id,Model mv) {
				BasicConfigurator.configure();  
				 logger.info(id);
				BikesData cus=BikeDao.getbikById(id);  
				mv.addAttribute("bike", cus);
				return "admin/bikeedit";	
			}
				
			
		    
		    @RequestMapping(value="/bedit/updatebike")    
		    public String editsave(@ModelAttribute("bike") BikesData cus){ 
		    	BasicConfigurator.configure();  
				 logger.info("updating bikes");
		    	BikeDao.update(cus);  
		    	 logger.info(cus);
		        return "redirect:/view";    
		    }    

		    
		    //it will remove the bike data
		    @RequestMapping(value="/deletebike/{id}")    
		    public String delete(@PathVariable int id){    
		    	BikeDao.delete(id);    
		        return "redirect:/view";    
		    } 
		  
		
		//
}