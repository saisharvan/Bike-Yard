package com.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.entity.BikesData;
import com.util.HibernateUtil;

public class BikeDao 
{
	static int a;
	static SessionFactory sessionFactory=null;

	private BikeDao() {}
	//it will save the data in database
	public static void save(BikesData bi) {
		System.out.println("creating BikesData");
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(bi);
		session.getTransaction().commit();
		session.close();
		System.out.println("BikesData created subbessfully "+bi.toString());

	}
	////////////savesr
	public static void savesr(BikesData bi) {
		System.out.println("creating BikesData");
		bi.setSraId(ShowroomDao.b);
		System.out.println(bi.toString());
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(bi);
		session.getTransaction().commit();
		session.close();
		System.out.println("BikesData created subbessfully "+bi.toString());

	}
	//////////////

	//it display the displayAll details
	public static  void displayBikes(){
		List<BikesData> bikList=getBikes();
		for(BikesData bik:bikList)
		{
			System.out.println(bik.toString());
		}
	}

	//
	public static List<BikesData> getBikes() {
		System.out.println("Fetching bike");
		Session session=HibernateUtil.getSessionFactory().openSession();
		List<BikesData>	bik=session.createQuery("from BikesData").list();
		session.close();
		System.out.println("Fetched "+bik.size());
		return bik;
	}
	//
	public static BikesData getbikById(int id) {
		a=id;
		System.out.println("Fetching BikesData");
		Session session=HibernateUtil.getSessionFactory().openSession();
		BikesData bik=session.load(BikesData.class, id);
		System.out.println(bik.toString());
		session.close();
		return bik;
	}
	//////////////////////////////
	public static BikesData getbikBy(int a) {
		System.out.println("Fetching Customer");
		List<BikesData> bl=getBikes();
		BikesData bid=new BikesData();
		for(BikesData bd:bl)
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
	public static int getbikCostById(int a) {
		System.out.println("Fetching bike cost");
		List<BikesData> bl=getBikes();
		int c = 0;
		for(BikesData bd:bl)
		{
			if(a==bd.getId()) 
			{
				System.out.println("bike id "+a);
				c=bd.getBikeCost();
				System.out.println("Fetching bike cost"+c);
				break;
			}
		}
		return c;
	}
///////////
	
	public static List<BikesData> getsrBikes(int w) {
		System.out.println("Fetching sr bike");
		List<BikesData>	bik=getBikes();
		List<BikesData> srbd =new ArrayList<BikesData>();
		int q = 0;
		for(BikesData bd:bik)
		{
			System.out.println(w);
			System.out.println(bd.getSraId());
			if(w==bd.getSraId()) 
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
	public static void update(BikesData bi) {
		System.out.println("Updating BikesData");
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		BikesData bb=session.load(BikesData.class, bi.getId());
    	bb.setBikeName(bi.getBikeName());
    	bb.setBikeCost(bi.getBikeCost());
		bb.setBikeColor(bi.getBikeColor());
		bb.setBikeDescription(bi.getBikeDescription());
		bb.setAvailability(bi.getAvailability());
		System.out.println(bi.toString());
		session.getTransaction().commit();
		session.close();
		System.out.println("Updated");

	}

	//it delete the data
	public static void delete(int id) {
		System.out.println("delete bike");
		BikesData c=getbikById(id);
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(c);
		session.getTransaction().commit();
		session.close();	
		
	}

	
}
