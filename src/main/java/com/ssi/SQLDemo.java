package com.ssi;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class SQLDemo {
	public static void main(String args[]){
		//System.out.println(args[0]+","+args[1]);
	Configuration config=new Configuration().configure();
	Session session=config.buildSessionFactory().openSession();
	
	String qr="select * from vehicle";
	SQLQuery query=session.createSQLQuery(qr);
	query.addEntity(Vehicle.class);
	List<Vehicle> vlist=query.list();
	for(Vehicle v:vlist){
		System.out.println(v);
	}
	

	
	
	/*List<Object[]> vlist=query.list();
	for(Object ar[]:vlist){
		for(Object obj:ar)
		System.out.println(obj);
		System.out.println("_________________________________________________");
	}*/
	
	}
}
