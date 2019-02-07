package com.ssi;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class QBCDemo {

	public static void main(String[] args) {
		
		Configuration config=new Configuration().configure();
		Session session=config.buildSessionFactory().openSession();
		
		Criteria cr=session.createCriteria(Customer.class);
		List<Customer> clist=cr.list();

		for(Customer c:clist){
			
			System.out.println(c.getCustId());
			System.out.println(c.getCname());
			System.out.println(c.getCaddress());
			List<Vehicle> list=c.getVehicles();
			for(Vehicle v:list){
				System.out.println(v.getRegno()+","+v.getVtype()+","+v.getVdesc());
			}
			System.out.println("______________________________________________");
		}
		
		
		
		
	}

}
