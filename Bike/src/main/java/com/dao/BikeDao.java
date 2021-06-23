package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.entity.BikesData;
import com.util.HibernateUtil;

public class BikeDao 
{
	static int a;
	static SessionFactory sessionFactory=null;

	private BikeDao() {}
	//
	private static final Logger logger = LogManager.getLogger(BikeDao.class);
	//it will save the data in database
	public static void save(BikesData bi) {
		BasicConfigurator.configure();  
		  logger.info("creating BikesData");
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(bi);
		session.getTransaction().commit();
		session.close();
		logger.info("BikesData created subbessfully "+bi.toString());

	}
	////////////savesr
	public static void savesr(BikesData bi) {
		BasicConfigurator.configure();  
		  logger.info("creating BikesData");
		bi.setSraId(ShowroomDao.b);
		logger.info(bi.toString());
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(bi);
		session.getTransaction().commit();
		session.close();
		logger.info("BikesData created subbessfully "+bi.toString());

	}
	//////////////

	//it display the displayAll details
	public static  void displayBikes(){
		List<BikesData> bikList=getBikes();
		for(BikesData bik:bikList)
		{
			BasicConfigurator.configure();  
			  logger.info(bik.toString());
		}
	}

	//
	public static List<BikesData> getBikes() {
		BasicConfigurator.configure();  
		  logger.info("Fetching bike");
		Session session=HibernateUtil.getSessionFactory().openSession();
		List<BikesData>	bik=session.createQuery("from BikesData").list();
		session.close();
		logger.info("Fetched "+bik.size());
		return bik;
	}
	//
	public static BikesData getbikById(int id) {
		a=id;
		BasicConfigurator.configure();  
		  logger.info("Fetching BikesData");
		Session session=HibernateUtil.getSessionFactory().openSession();
		BikesData bik=session.load(BikesData.class, id);
		logger.info(bik.toString());
		session.close();
		return bik;
	}
	//////////////////////////////
	public static BikesData getbikBy(int a) {
		BasicConfigurator.configure();  
		  logger.info("Fetching Customer");
		List<BikesData> bl=getBikes();
		BikesData bid=new BikesData();
		for(BikesData bd:bl)
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
	public static int getbikCostById(int a) {
		BasicConfigurator.configure();  
		  logger.info("Fetching bike cost");
		List<BikesData> bl=getBikes();
		int c = 0;
		for(BikesData bd:bl)
		{
			if(a==bd.getId()) 
			{
				logger.info("bike id "+a);
				c=bd.getBikeCost();
				logger.info("Fetching bike cost"+c);
				break;
			}
		}
		return c;
	}
///////////
	
	public static List<BikesData> getsrBikes(int w) {
		BasicConfigurator.configure();  
		  logger.info("Fetching sr bike");
		List<BikesData>	bik=getBikes();
		List<BikesData> srbd =new ArrayList<BikesData>();
		int q = 0;
		for(BikesData bd:bik)
		{
			logger.info(w);
			logger.info(bd.getSraId());
			if(w==bd.getSraId()) 
			{
				srbd.add(bd);
				q++;
			}
		}
		logger.info("Fetched sr "+q);
		return srbd;
	}
//////////
	
	//it will update particular id
	public static void update(BikesData bi) {
		BasicConfigurator.configure();
		logger.info("Updating BikesData");
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		BikesData bb=session.load(BikesData.class, bi.getId());
    	bb.setBikeName(bi.getBikeName());
    	bb.setBikeCost(bi.getBikeCost());
		bb.setBikeColor(bi.getBikeColor());
		bb.setBikeDescription(bi.getBikeDescription());
		bb.setAvailability(bi.getAvailability());
		logger.info(bi.toString());
		session.getTransaction().commit();
		session.close();
		logger.info("Updated");

	}

	//it delete the data
	public static void delete(int id) {
		BasicConfigurator.configure();  
		logger.info("delete bike");
		BikesData c=getbikById(id);
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(c);
		session.getTransaction().commit();
		session.close();	
		
	}

	
}
