package com.ssi;

import java.util.List;




import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HQLDemo {
	public static void main(String args[]){
	Configuration config=new Configuration().configure();
	Session session=config.buildSessionFactory().openSession();
	
	String qr="from Vehicle where vtype='SUV' order by vdesc";
	
	Query query=session.createQuery(qr);
	List<Vehicle> vlist=query.list();
	for(Vehicle v:vlist){
		System.out.println(v);
		List<Customer> cust=v.getCustomers();
		for(Customer c:cust){
			System.out.println(c.getCname());
		}
	}
	}
}
