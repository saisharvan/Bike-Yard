package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.entity.ShowRoomAdmin;
import com.util.HibernateUtil;

public class ShowroomDao {
	private ShowroomDao() {}
	/////////////////
		public static int a;
		public static int b;
		
		static SessionFactory sessionFactory=null;

		//it will save the data in database
		public static void save(ShowRoomAdmin show) {
			System.out.println("creating ShowRoomAdmin");
			Session session=HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(show);
			session.getTransaction().commit();
			session.close();
			System.out.println("ShowRoomAdmin created successfully "+show.toString());
		}


		//
		public static List<ShowRoomAdmin> getShowRoomAdmins() {
			System.out.println("Fetching ShowRoomAdmin");
			Session session=HibernateUtil.getSessionFactory().openSession();
			List<ShowRoomAdmin>	show=session.createQuery("from ShowRoomAdmin").list();
			session.close();
			System.out.println("Fetched "+show.size());
			return show;
		}
		

		public static ShowRoomAdmin getShowById(int id) {
			
			System.out.println("Fetching ShowRoomAdmin");
			Session session=HibernateUtil.getSessionFactory().openSession();
			ShowRoomAdmin show=session.load(ShowRoomAdmin.class, id);
			System.out.println(show.toString());
			session.close();
			return show;
			}
		public static ShowRoomAdmin getShowBy() {
			System.out.println("Fetching Customer");
			List<ShowRoomAdmin> custList=getShowRoomAdmins();
			ShowRoomAdmin c=new ShowRoomAdmin();
			for(ShowRoomAdmin cust:custList)
			{
				if(a==cust.getShowRoomId()) 
				{
					System.out.println("show profile id "+a);
					c=cust;
					break;
				}
			}
			return c;
		}
		
		
		/////////////////////////////////
		public static String checkIdPassword(String email,String pass) {
			List<ShowRoomAdmin> showList=getShowRoomAdmins();
			boolean che = false;
			for(ShowRoomAdmin show:showList)
			{
				String idd=show.getEmail();
				String passs=show.getPassword();
				if(email.equals(idd) && pass.equals(passs)) 
				{
					a=show.getShowRoomId(); 
					b=a;
					System.out.println("checked id "+a);
					che=true;
				}
			}
				if(che==true) {
					return"redirect:/srhome";
				}
				else
				{
					return "ShowRoomAdmin/srlogin";
				}
		}
		/////////////////////////////////////

		//it will update particular id
		public static void update(ShowRoomAdmin show) {
			System.out.println("Updating ShowRoomAdmin");
			Session session=HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			ShowRoomAdmin cc=session.load(ShowRoomAdmin.class, a);
	    	cc.setUserName(show.getUserName());
	    	cc.setShowRoomName(show.getShowRoomName());
			cc.setShowRoomLocation(show.getShowRoomLocation());
			cc.setEmail(show.getEmail());
			cc.setShowRoomAddress(show.getShowRoomAddress());
			System.out.println(show.toString());
			session.getTransaction().commit();
			session.close();
			System.out.println("Updated");

		}

		//it delete the data
		public static void delete(int id) {
			System.out.println("delete ShowRoomAdmin");
			
			ShowRoomAdmin c=getShowById(id);
			Session session=HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(c);
			session.getTransaction().commit();
			session.close();
			System.out.println("deleted successfully");		
		}

		public static int take() {
			System.out.println("dao"+b);
			return b;
		}
		public static void out() 
		{
			System.out.print(a);
			a=0;
			System.out.print(" is logged out");
		}
	////////////////

}
