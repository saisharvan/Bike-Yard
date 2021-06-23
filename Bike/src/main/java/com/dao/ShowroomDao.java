package com.dao;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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
		//
		private static final Logger logger = LogManager.getLogger(ShowroomDao.class); 
		//it will save the data in database
		public static void save(ShowRoomAdmin show) {
			logger.info("creating ShowRoomAdmin");
			Session session=HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(show);
			session.getTransaction().commit();
			session.close();
			logger.info("ShowRoomAdmin created successfully "+show.toString());
		}


		//
		public static List<ShowRoomAdmin> getShowRoomAdmins() {
			logger.info("Fetching ShowRoomAdmin");
			Session session=HibernateUtil.getSessionFactory().openSession();
			List<ShowRoomAdmin>	show=session.createQuery("from ShowRoomAdmin").list();
			session.close();
			logger.info("Fetched "+show.size());
			return show;
		}
		

		public static ShowRoomAdmin getShowById(int id) {
			
			logger.info("Fetching ShowRoomAdmin");
			Session session=HibernateUtil.getSessionFactory().openSession();
			ShowRoomAdmin show=session.load(ShowRoomAdmin.class, id);
			logger.info(show.toString());
			session.close();
			return show;
			}
		public static ShowRoomAdmin getShowBy() {
			logger.info("Fetching Customer");
			List<ShowRoomAdmin> custList=getShowRoomAdmins();
			ShowRoomAdmin c=new ShowRoomAdmin();
			for(ShowRoomAdmin cust:custList)
			{
				if(a==cust.getShowRoomId()) 
				{
					logger.info("show profile id "+a);
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
					logger.info("checked id "+a);
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
			logger.info("Updating ShowRoomAdmin");
			Session session=HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			ShowRoomAdmin cc=session.load(ShowRoomAdmin.class, a);
	    	cc.setUserName(show.getUserName());
	    	cc.setShowRoomName(show.getShowRoomName());
			cc.setShowRoomLocation(show.getShowRoomLocation());
			cc.setEmail(show.getEmail());
			cc.setShowRoomAddress(show.getShowRoomAddress());
			logger.info(show.toString());
			session.getTransaction().commit();
			session.close();
			logger.info("Updated");

		}

		//it delete the data
		public static void delete(int id) {
			logger.info("delete ShowRoomAdmin");
			
			ShowRoomAdmin c=getShowById(id);
			Session session=HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(c);
			session.getTransaction().commit();
			session.close();
			logger.info("deleted successfully");		
		}

		public static int take() {
			logger.info("dao"+b);
			return b;
		}
		public static void out() 
		{
			logger.info(a);
			a=0;
			logger.info(" is logged out");
		}
	////////////////

}
