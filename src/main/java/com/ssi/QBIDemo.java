package com.ssi;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class QBIDemo {

	public static void main(String[] args) {

		Configuration config=new Configuration().configure();
		Session session=config.buildSessionFactory().openSession();
		Customer cust=session.get(Customer.class, "c112");
		if(cust!=null){
		System.out.println(cust.getCustId());
		System.out.println(cust.getCname());
		System.out.println(cust.getCaddress());
		List<Vehicle> list=cust.getVehicles();
		for(Vehicle v:list){
			System.out.println(v.getRegno()+","+v.getVtype()+","+v.getVdesc());
		}
		}
		else{
			System.out.println("Invalid Customer Id");
		}
		session.close();
		
		
	}

}
