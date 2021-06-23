package com.dao;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.entity.Customer;
import com.entity.ShowRoomAdmin;
import com.util.HibernateUtil;

public class AdminDao {
	private AdminDao(){}
	 private static final Logger logger = LogManager.getLogger(AdminDao.class); 
	//it delete the data
		public static void delete(int id) {
			BasicConfigurator.configure();  
			  logger.info("delete customer");
			Customer c=getCustById(id);
			Session session=HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(c);
			session.getTransaction().commit();
			session.close();
			logger.info("deleted successfully");		
		}
		public static Customer getCustById(int id) {
			BasicConfigurator.configure();  
			  logger.info("Fetching Customer");
			Session session=HibernateUtil.getSessionFactory().openSession();
			Customer cust=session.load(Customer.class, id);
			session.close();
			return cust;
		}
		public static ShowRoomAdmin getShowById(int id) {
			BasicConfigurator.configure();  
			  logger.info("Fetching ShowRoomAdmin");
			Session session=HibernateUtil.getSessionFactory().openSession();
			ShowRoomAdmin show=session.load(ShowRoomAdmin.class, id);
			session.close();
			return show;
		}
		//it delete the data
				public static void sdelete(int id) {
					BasicConfigurator.configure();  
					  logger.info("delete ShowRoomAdmin");
					ShowRoomAdmin c=getShowById(id);
					Session session=HibernateUtil.getSessionFactory().openSession();
					session.beginTransaction();
					session.delete(c);
					session.getTransaction().commit();
					session.close();
					logger.info("deleted successfully");		
				}

}
