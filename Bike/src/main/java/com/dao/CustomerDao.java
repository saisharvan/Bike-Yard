package com.dao;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.controller.CustomerController;
import com.entity.BikesData;
import com.entity.Customer;
import com.util.HibernateUtil;


public class CustomerDao {
	private CustomerDao() {}
	public static int a;

	static SessionFactory sessionFactory=null;

	private static final Logger logger = LogManager.getLogger(CustomerDao.class); 
	//it will save the data in database
	public static void save(Customer cus) {
		logger.info("creating customer");
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(cus);
		session.getTransaction().commit();
		session.close();
		logger.info("customer created successfully "+cus.toString());

	}


	//
	public static List<Customer> getCustomers() {
		logger.info("Fetching Customer");
		Session session=HibernateUtil.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<Customer>	cust=session.createQuery("from Customer").list();
		session.close();
		logger.info("Fetched "+cust.size());
		return cust;
	}
	

	public static Customer getCustById(int id) {
		a=id;
		logger.info("Fetching Customer by id");
		Session session=HibernateUtil.getSessionFactory().openSession();
		Customer cust=session.load(Customer.class, id);
		session.close();
		return cust;
	}
	////////////////////////
	public static BikesData book() 
	{
		Customer cus=CustomerDao.getCustBy(); 
		int bk=cus.getBookId();
		return BikeDao.getbikBy(bk);
	}
	////////////////////////
	public static Customer getCustBy() {
		logger.info("Fetching Customer using particular id");
		List<Customer> custList=getCustomers();
		Customer c=new Customer();
		for(Customer cust:custList)
		{
			if(a==cust.getId()) 
			{
				logger.info("profile id "+a);
				c=cust;
				break;
			}
		}
		return c;
	}
	///////////////*******************//////////////////
	public static String checkIdPassword(String email,String pass) {
		List<Customer> custList=getCustomers();
		boolean che = false;
		for(Customer cust:custList)
		{
			String idd=cust.getEmail();
			String passs=cust.getPassword();
			if(email.equals(idd) && pass.equals(passs)) 
			{
				a=cust.getId(); 
				CustomerController.cusId=cust.getId();
				logger.info("checked id "+a);
				che=true;
				break;
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
		logger.info("Updating Customer");
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
		if(cus.getBookId() != 0) 
		{
			cc.setBookId(cus.getBookId());
		}else {cc.setBookId(0);}
		logger.info(cus.toString());
		session.getTransaction().commit();
		session.close();
		logger.info("Updated");

	}

	//it delete the data
	public static void delete(int id) {
		logger.info("delete customer");
		Customer c=getCustById(id);
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(c);
		session.getTransaction().commit();
		session.close();
		logger.info("deleted successfully");		
	}

	

	public static int take() {
		logger.info("dao"+a);
		return a;
	}
	public static void out() 
	{
		logger.info(a);
		a=0;
		logger.info(" is logged out");
	}
}