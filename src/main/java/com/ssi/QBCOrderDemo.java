package com.ssi;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;

public class QBCOrderDemo {

	public static void main(String[] args) {
		Configuration config=new Configuration().configure();
		Session session=config.buildSessionFactory().openSession();
		Criteria cr=session.createCriteria(Vehicle.class);
		
		Order ord1=Order.asc("vtype");
		Order ord2=Order.desc("regno");
		cr.addOrder(ord1);
		cr.addOrder(ord2);
		
		
		
		List<Vehicle> vlist=cr.list();
		for(Vehicle v:vlist){
			System.out.println(v);
		}
		
		
		
	}

}
