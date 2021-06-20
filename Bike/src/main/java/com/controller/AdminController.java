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
import org.springframework.web.servlet.ModelAndView;
import com.dao.*;
import com.entity.*;

@Controller
public class AdminController {
	
	
	
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
	
	//it will retrive the data after click views details
		@RequestMapping("/views")    
		public String viewsemp(Model m){    
			List<Customer> list=CustomerDao.getCustomers();    
			m.addAttribute("list",list);  
			return "admin/viewform";    
		}
		
		//it retrive the editform
		@RequestMapping("/edits/{id}")
		public String edit(@PathVariable int id,Model mv) {
			System.out.println(id);
			Customer cus=adminDao.getCustById(id);
			mv.addAttribute("customer", cus);
			return "admin/editcustomer";	
		}
		// It updates model object.   
		@RequestMapping(value="/edits/updatecustomer")    
		public String editsave(@ModelAttribute("customer") Customer cus){  
			System.out.println("updating");
			CustomerDao.update(cus);    
			System.out.println(cus);
			return "redirect:/views";    
		} 
		//it will remove the customer data
	    @RequestMapping(value="/deletecustomer/{id}")    
	    public String custdelete(@PathVariable int id){    
	        adminDao.delete(id);    
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
			System.out.println(id);
			ShowRoomAdmin show=ShowroomDao.getShowById(id);  
			mv.addAttribute("ShowRoomAdmin", show);
			return "ShowRoomAdmin/ashowedit";	
		}

		
		// It updates model object at showt
		@RequestMapping(value="/ashowedit/aupdateshowroom")    
		public String editsaveing(@ModelAttribute("ShowRoomAdmin") ShowRoomAdmin show){  
			System.out.println("updating");
			ShowroomDao.update(show);    
			System.out.println(show);
			return "redirect:/aview";    
		} 
		//it will remove the bike data
	    @RequestMapping(value="/ashowdelete/{id}")    
	    public String showroomdelete(@PathVariable int id){    
	    	adminDao.sdelete(id);    
	        return "redirect:/aview";    
	    } 
	    
/////////////////////////////////////////////////////////////
			
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
				System.out.println(id);
				BikesData cus=BikeDao.getbikById(id);  
				mv.addAttribute("bike", cus);
				return "admin/bikeedit";	
			}
				
			
		    
		    @RequestMapping(value="/bedit/updatebike")    
		    public String editsave(@ModelAttribute("bike") BikesData cus){  
		    	System.out.println("updating");
		    	BikeDao.update(cus);    
		        System.out.println(cus);
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