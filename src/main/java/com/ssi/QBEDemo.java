package com.ssi;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;

public class QBEDemo {
public static void main(String args[]){
	Configuration config=new Configuration().configure();
	Session session=config.buildSessionFactory().openSession();
	Criteria cr=session.createCriteria(Vehicle.class);
	
	Vehicle vehicle=new Vehicle();
	vehicle.setVtype("SUV");
	
	Example example=Example.create(vehicle);
	
	cr.add(example);
	
	List<Vehicle> vlist=cr.list();
	for(Vehicle v:vlist){
		System.out.println(v);
	}
}
}
