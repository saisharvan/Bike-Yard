package com.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import com.entity.Customer;
import com.util.HibernateUtil;


public class CustomerDao {
	public static int a;

	static SessionFactory sessionFactory=null;

	//it will save the data in database
	public static void save(Customer cus) {
		System.out.println("creating customer");
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(cus);
		session.getTransaction().commit();
		System.out.println("customer created successfully "+cus.toString());

	}


	//
	public static List<Customer> getCustomers() {
		System.out.println("Fetching Customer");
		Session session=HibernateUtil.getSessionFactory().openSession();
		List<Customer>	cust=session.createQuery("from Customer").list();
		session.close();
		System.out.println("Fetched "+cust.size());
		return cust;
	}
	

	public static Customer getCustById(int id) {
		a=id;
		System.out.println("Fetching Customer");
		Session session=HibernateUtil.getSessionFactory().openSession();
		Customer cust=session.load(Customer.class, id);
		//session.close();
		return cust;
	}
	///////////////*******************//////////////////
	public static String CheckIdPassword(String email,String pass) {
		List<Customer> custList=getCustomers();
		boolean che = false;
		for(Customer cust:custList)
		{
			String idd=cust.getEmail();
			String passs=cust.getPassword();
			if(email.equals(idd) && pass.equals(passs)) 
			{
				a=cust.getId();  
				System.out.println("checked id "+a);
				che=true;
			}
		}
			if(che==true) {
				return"redirect:/hoome";
			}
			else
			{
				return "customer/login";
			}
	}
		   
	//////////////////****************///////////////////

	//it will update particular id
	public static void update(Customer cus) {
		System.out.println("Updating Customer");
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Customer cc=session.load(Customer.class, a);
    	cc.setFirstname(cus.getFirstname());
    	cc.setLastname(cus.getLastname());
		cc.setAge(cus.getAge());
		cc.setGender(cus.getGender());
		cc.setEmail(cus.getEmail());
		cc.setNum(cus.getNum());
		cc.setAddress(cus.getAddress());
		System.out.println(cus.toString());
		session.getTransaction().commit();
		session.close();
		System.out.println("Updated");

	}

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

	

	public static int take() {
		System.out.println("dao"+a);
		return a;
	}
	public static void out() 
	{
		System.out.print(a);
		a=0;
		System.out.print(" is logged out");
	}
}