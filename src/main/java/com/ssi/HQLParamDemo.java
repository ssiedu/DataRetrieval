package com.ssi;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HQLParamDemo {
	public static void main(String args[]){
	Configuration config=new Configuration().configure();
	Session session=config.buildSessionFactory().openSession();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter Choice : ");
	String ch=sc.next();
	
	String qr="from Vehicle where vtype=:vt";
	Query query=session.createQuery(qr);
	query.setParameter("vt", ch);
	List<Vehicle> vlist=query.list();
	for(Vehicle v:vlist){
		System.out.println(v);
	}
	}
}
