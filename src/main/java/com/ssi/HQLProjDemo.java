package com.ssi;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HQLProjDemo {
	public static void main(String args[]){
	Configuration config=new Configuration().configure();
	Session session=config.buildSessionFactory().openSession();
	
	String qr="select vtype,vdesc from Vehicle";
	Query query=session.createQuery(qr);
	
	List<Object[]> vlist=query.list();
	
	for(Object ar[]:vlist){
		for(Object obj:ar){
			System.out.println(obj);
		}
		System.out.println("____________________________________________________");
	}
	
	
	
	}
}
