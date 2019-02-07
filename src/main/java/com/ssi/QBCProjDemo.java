package com.ssi;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

public class QBCProjDemo {

	public static void main(String[] args) {
		Configuration config=new Configuration().configure();
		Session session=config.buildSessionFactory().openSession();
		Criteria cr=session.createCriteria(Vehicle.class);
		
		
		ProjectionList pList=Projections.projectionList();
		Projection p1=Projections.property("vtype");
		Projection p2=Projections.property("vdesc");
		pList.add(p1); pList.add(p2);
		cr.setProjection(pList);
		
		List<Object[]> vlist=cr.list();
		
		
		for(Object ar[]:vlist){
			
			for(Object obj:ar){
				System.out.println(obj);
			}
			System.out.println("______________________________________________");
		}

		session.close();
	}
}
