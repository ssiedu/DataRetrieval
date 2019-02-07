package com.ssi;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class QBCFilterDemo {

	public static void main(String[] args) {
		Configuration config=new Configuration().configure();
		Session session=config.buildSessionFactory().openSession();
		Criteria cr=session.createCriteria(Vehicle.class);
		
		Criterion crt1=Restrictions.eq("vtype", "SUV");
		Criterion crt2=Restrictions.eq("vdesc", "Duster");
		//Criterion crt3=Restrictions.or(crt1,crt2);
		Criterion crt3=Restrictions.and(crt1,crt2);
		//Criterion crt1=Restrictions.like("vdesc","Toy%");
		
		cr.add(crt3);
		
		
		List<Vehicle> vlist=cr.list();
		for(Vehicle v:vlist){
			System.out.println(v);
		}
		
	}

}
