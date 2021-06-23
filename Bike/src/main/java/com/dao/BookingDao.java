package com.dao;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.controller.CustomerController;
import com.entity.*;
import com.util.HibernateUtil;

public class BookingDao {
	
	static int a;
	static SessionFactory sessionFactory=null;
	//
	private BookingDao() {}
	//
	private static final Logger logger = LogManager.getLogger(BookingDao.class); 
	//it will save the data in database
	public static void save(BookingData bi) {
		logger.info("creating BookingData");
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(bi);
		session.getTransaction().commit();
		session.close();
		logger.info("BookingData created subbessfully "+bi.toString());

	}
	//save customer booking data
	public static void savecusorder() {
		 int p=BikeDao.getbikCostById(CustomerController.bikeId);
		 logger.info("ccccccccccccccccccc"+p);
		 String status="In progress";
		BookingData bd = new BookingData(CustomerController.bikeId,CustomerController.cusId,CustomerController.showId,p,status);
		logger.info("creating BookingData");
		
		logger.info(bd.toString());
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(bd);
		session.getTransaction().commit();
		session.close();
		logger.info("BookingData created subbessfully "+bd.toString());

	}
	//////////////

	public static List<BookingData> getbook() {
		logger.info("Fetching bike");
		Session session=HibernateUtil.getSessionFactory().openSession();
		List<BookingData>	bik=session.createQuery("from BookingData").list();
		session.close();
		logger.info("Fetched "+bik.size());
		return bik;
	}
	//
	public static BookingData getbookById(int id) {
		a=id;
		logger.info("Fetching BookingData");
		Session session=HibernateUtil.getSessionFactory().openSession();
		BookingData bik=session.load(BookingData.class, id);
		logger.info(bik.toString());
		session.close();
		return bik;
	}
	//////////////////////////////
	public static BookingData getbooksBy(int a) {
		logger.info("Fetching Customer");
		List<BookingData> bl=getbook();
		BookingData bid=new BookingData();
		for(BookingData bd:bl)
		{
			if(a==bd.getId()) 
			{
				logger.info("bike id "+a);
				bid=bd;
				break;
			}
		}
		return bid;
	}
///////////
	public static List<BookingData> getbooks(int w) {
		logger.info("Fetching sr bike");
		List<BookingData>	bik=getbook();
		List<BookingData> srbd =new ArrayList<BookingData>();
		int q = 0;
		for(BookingData bd:bik)
		{
			logger.info(w);
			logger.info(bd.getShowadminId());
			if(w==bd.getShowadminId()) 
			{
				srbd.add(bd);
				q++;
			}
		}
		logger.info("Fetched sr "+q);
		return srbd;
	}
	///////////////////////////////////////////////////////////////////////////////////////
	public static List<BookingData> getcusbooks(int w) {
		logger.info("Fetching sr bike");
		List<BookingData>	bik=getbook();
		List<BookingData> srbd =new ArrayList<BookingData>();
		int q = 0;
		for(BookingData bd:bik)
		{
			logger.info(w);
			logger.info(bd.getCustomerId());
			if(w==bd.getCustomerId()) 
			{
				srbd.add(bd);
				q++;
			}
		}
		logger.info("Fetched sr "+q);
		return srbd;
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////
//////////
	
	//it will update particular id
	public static void update(BookingData bi) {
		logger.info("Updating BookingData");
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		BookingData bb=session.load(BookingData.class, bi.getId());
		bb.setStatus(bi.getStatus());
		logger.info(bi.toString());
		session.getTransaction().commit();
		session.close();
		logger.info("Updated");

	}

	//it delete the data
	public static void delete(int id) {
		logger.info("delete bike");
		BookingData c=getbookById(id);
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(c);
		session.getTransaction().commit();
		session.close();
		logger.info("deleted subbessfully");		
	}

}
