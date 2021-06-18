package com.util;

import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

import com.entity.BikesData;
import com.entity.Customer;
import com.entity.ShowRoomAdmin;

public class HibernateUtil {
	
	static SessionFactory sessionFactory=null;
	
	public static SessionFactory getSessionFactory(){
		if(sessionFactory==null)
		{
			Configuration c=new Configuration().addAnnotatedClass(Customer.class).addAnnotatedClass(BikesData.class).addAnnotatedClass(ShowRoomAdmin.class).configure("hibernate.cfg.xml");
			
			 sessionFactory=c.buildSessionFactory();
			
		}
		
		return sessionFactory;
	}

}
