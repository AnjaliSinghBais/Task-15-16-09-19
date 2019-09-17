package com.ssi;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class HQLOrderFilterProject {

	public static void main(String[] args) {

		// HQL OREDERING
		Configuration config = new Configuration().configure();
		Session session = config.buildSessionFactory().openSession();
		String qr = "from Employee where Empno>1 order by sal";
		Query query = session.createQuery(qr);
		List<Employee> list = query.list();
		for (Employee emp : list) {
			System.out.println(emp);
		}
		System.out.println("_____________________________________");
	
		// HQL PROJECTION
		String q="select Empno,Empname from Employee";
		Query query1=session.createQuery(q);
		
		List<Object[]> vlist=query1.list();
		
		for(Object ar[]:vlist){
			for(Object obj:ar){
				System.out.println(obj);
			}
			System.out.println("_____________________________________");
		}

		
		String hql = "SELECT count(distinct Empname) FROM Employee ";
		Query query2 = session.createQuery(hql);
		List<Employee> list2 = query2.list();
		for (Employee emp1 : list2) {
			System.out.println(emp1);
		}
		
	}

}
