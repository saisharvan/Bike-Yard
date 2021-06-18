package com.dao;

import org.hibernate.Session;

import com.entity.Customer;
import com.entity.ShowRoomAdmin;
import com.util.HibernateUtil;

public class adminDao {
	
	//it delete the data
		public static void delete(int id) {
			System.out.println("delete customer");
			Customer c=getCustById(id);
			Session session=HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(c);
			session.getTransaction().commit();
			session.close();
			System.out.println("deleted successfully");		
		}
		public static Customer getCustById(int id) {
			
			System.out.println("Fetching Customer");
			Session session=HibernateUtil.getSessionFactory().openSession();
			Customer cust=session.load(Customer.class, id);
			session.close();
			return cust;
		}
		public static ShowRoomAdmin getShowById(int id) {
			
			System.out.println("Fetching ShowRoomAdmin");
			Session session=HibernateUtil.getSessionFactory().openSession();
			ShowRoomAdmin show=session.load(ShowRoomAdmin.class, id);
			session.close();
			return show;
		}
		//it delete the data
				public static void sdelete(int id) {
					System.out.println("delete ShowRoomAdmin");
					
					ShowRoomAdmin c=getShowById(id);
					Session session=HibernateUtil.getSessionFactory().openSession();
					session.beginTransaction();
					session.delete(c);
					session.getTransaction().commit();
					session.close();
					System.out.println("deleted successfully");		
				}

}
