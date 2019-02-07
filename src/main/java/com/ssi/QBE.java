package com.ssi;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;

public class QBE {

	public static void main(String[] args) {
		
		Configuration config=new Configuration().configure();
		Session session=config.buildSessionFactory().openSession();
		Criteria cr=session.createCriteria(Vehicle.class);
		
		Vehicle v1=new Vehicle();
		v1.setVtype("SDCar");
		
		Example ex=Example.create(v1);
		cr.add(ex);
		
		List<Vehicle> vlist=cr.list();
		System.out.println(vlist.size());
		for(Vehicle v:vlist){
			System.out.println(v);
		}
		
		
	}

}
