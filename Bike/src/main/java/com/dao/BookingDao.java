package com.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.controller.CustomerController;
import com.entity.*;
import com.util.HibernateUtil;
public class BookingDao {
	
	static int a;
	static SessionFactory sessionFactory=null;

	//it will save the data in database
	public static void save(BookingData bi) {
		System.out.println("creating BookingData");
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(bi);
		session.getTransaction().commit();
		System.out.println("BookingData created subbessfully "+bi.toString());

	}
	//save customer booking data
	public static void savecus() {
		 int p=0;
		 String status="In progress";
		BookingData bd = new BookingData(CustomerController.bikeId,CustomerController.CusId,CustomerController.ShowId,p,status);
		System.out.println("creating BookingData");
		
		System.out.println(bd.toString());
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(bd);
		session.getTransaction().commit();
		System.out.println("BookingData created subbessfully "+bd.toString());

	}
	//////////////
/*
	//it display the displayAll details
	public static  void displaybook(){
		List<BookingData> bikList=getbook();
		for(BookingData bik:bikList)
		{
			System.out.println(bik.toString());
		}
	}
*/
	//
	public static List<BookingData> getbook() {
		System.out.println("Fetching bike");
		Session session=HibernateUtil.getSessionFactory().openSession();
		List<BookingData>	bik=session.createQuery("from BookingData").list();
		session.close();
		System.out.println("Fetched "+bik.size());
		return bik;
	}
	//
	public static BookingData getbookById(int id) {
		a=id;
		System.out.println("Fetching BookingData");
		Session session=HibernateUtil.getSessionFactory().openSession();
		BookingData bik=session.load(BookingData.class, id);
		System.out.println(bik.toString());
		session.close();
		return bik;
	}
	//////////////////////////////
	public static BookingData getbooksBy(int a) {
		System.out.println("Fetching Customer");
		List<BookingData> bl=getbook();
		BookingData bid=new BookingData();
		for(BookingData bd:bl)
		{
			if(a==bd.getId()) 
			{
				System.out.println("bike id "+a);
				bid=bd;
				break;
			}
		}
		return bid;
	}
///////////
	public static List<BookingData> getbooks(int w) {
		System.out.println("Fetching sr bike");
		List<BookingData>	bik=getbook();
		List<BookingData> srbd =new ArrayList<BookingData>();
		int q = 0;
		for(BookingData bd:bik)
		{
			System.out.println(w);
			System.out.println(bd.getShowadminId());
			if(w==bd.getShowadminId()) 
			{
				srbd.add(bd);
				q++;
			}
		}
		System.out.println("Fetched sr "+q);
		return srbd;
	}
//////////
	
	//it will update particular id
	public static void update(BookingData bi) {
		System.out.println("Updating BookingData");
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		BookingData bb=session.load(BookingData.class, bi.getId());
		bb.setStatus(bi.getStatus());
		System.out.println(bi.toString());
		session.getTransaction().commit();
		session.close();
		System.out.println("Updated");

	}

	//it delete the data
	public static void delete(int id) {
		System.out.println("delete bike");
		BookingData c=getbookById(id);
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(c);
		session.getTransaction().commit();
		session.close();
		System.out.println("deleted subbessfully");		
	}

}
