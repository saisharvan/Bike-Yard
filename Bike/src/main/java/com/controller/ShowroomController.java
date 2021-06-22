package com.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.dao.*;
import com.entity.*;

@Controller
public class ShowroomController {
	
	int a=ShowroomDao.take();
	//
	@RequestMapping("/s")
	public String s() 
	{
		return "ShowRoomAdmin/index";
	}
	//
	@RequestMapping("/srlogin")
	public String login() {
		return "ShowRoomAdmin/srlogin";	
	}


	//for home
	@RequestMapping("/srsee")
	public String sai(HttpServletRequest req,HttpServletResponse res) {
		String id=req.getParameter("Id");
		String pass=req.getParameter("Pass");
		System.out.println(id+" "+pass);
		
		return ShowroomDao.CheckIdPassword(id,pass);
		
	}

	//home 
	@RequestMapping("/srhome")
	public String saia() {
		return "ShowRoomAdmin/home";		
	}

	//it will return the registration page
	@RequestMapping("/showreg")
	public String registration(Model mv) {
		mv.addAttribute("ShowRoomAdmin", new ShowRoomAdmin());	
		return "ShowRoomAdmin/showregform";	
	}

	//it will save the data into collection after open the login page
	@RequestMapping(value="/showsave")    
	public String showRoomAdminsave(@ModelAttribute("ShowRoomAdmin") ShowRoomAdmin show){
		ShowroomDao.save(show);   
		return "redirect:/s";//will redirect to viewsemp request mapping    
	}

	//it give show by id
	@RequestMapping("/srprofile")
	public String profile(Model mv) {
		int id=a;
		ShowRoomAdmin show= ShowroomDao.getShowBy();
		System.out.println("after "+show.toString());
		mv.addAttribute("sho",show);
		return "ShowRoomAdmin/profile";	
	}

	
	//it retrive the editform in showt
	@RequestMapping("/showedit/{id}")
	public String showtedit(@PathVariable int id,Model mv) {
		System.out.println(id);
		ShowRoomAdmin show=ShowroomDao.getShowBy();  
		mv.addAttribute("ShowRoomAdmin", show);
		return "ShowRoomAdmin/showedit";	
	}

	
	// It updates model object at showt
	@RequestMapping(value="/showedit/updateshowroom")    
	public String editsaveing(@ModelAttribute("ShowRoomAdmin") ShowRoomAdmin show){  
		System.out.println("updating");
		ShowroomDao.update(show);    
		System.out.println(show);
		return "redirect:/srhome";    
	} 
	
	//it is use for ShowRoomAdmin
	@RequestMapping("/showview")    
	public String showview(Model m){    
		List<BikesData> list=BikeDao.getsrBikes(ShowroomDao.b);    
		m.addAttribute("list",list);  
		return "ShowRoomAdmin/viewbikessr";    
	}

	//booking details of customer
	@RequestMapping("/bookings") 
	public String bookings(Model m) 
	{
		List<BookingData> list=BookingDao.getbooks(ShowroomDao.b);
		m.addAttribute("list",list);
		return "ShowRoomAdmin/viewbookings";
	}

	//log out page
	@RequestMapping(value="/srlogout")    
	public String logout(){   
		ShowroomDao.out();
		return "redirect:/s";    
	} 

	//it will return the registration page
		@RequestMapping("/regsr")
		public String showBikeForm(Model mv) {
			mv.addAttribute("bike", new BikesData());	
			return "ShowRoomAdmin/addbikesr";	
		}

		//it will save the data into collection after oopen the data
		@RequestMapping(value="/savesr")    
		public String save(@ModelAttribute("bike") BikesData cus){
			cus.setSraId(a);
			System.out.println(cus.toString());
			BikeDao.savesr(cus);   
			return "redirect:/showview";//will redirect to viewemp request mapping    
		}

		
		
		//it retrive the editform
		@RequestMapping("/editsr/{id}")
		public String edit(@PathVariable int id,Model mv) {
			System.out.println(id);
			BikesData cus=BikeDao.getbikById(id);  
			mv.addAttribute("bike", cus);
			return "ShowRoomAdmin/bikeeditsr";	
		}
		
	    
	    @RequestMapping(value="/editsr/updatebikesr",method = RequestMethod.POST)    
	    public String editsave(@ModelAttribute("bike") BikesData cus){  
	    	System.out.println("updating");
	    	BikeDao.update(cus);    
	        System.out.println(cus);
	        return "redirect:/showview";    
	    }    

	    
	    //it will remove the data
	    @RequestMapping(value="/deletebikesr/{id}")    
	    public String delete(@PathVariable int id){   
	    	BikeDao.delete(id);    
	        return "redirect:/showview";    
	    } 
	  
}
