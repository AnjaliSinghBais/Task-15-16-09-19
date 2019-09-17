package com.ssi;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class QBCFilterProjection {

	public static void main(String[] args) {

		Configuration config = new Configuration().configure();
		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Employee.class);

		// FILTER USING QBC
		Criterion crt1 = Restrictions.eq("Empno", 1);
		Criterion crt2 = Restrictions.ilike("Empname", "a%");
		Criterion crt3 = Restrictions.or(crt1, crt2);
		// cr.add(crt1);
		// cr.add(crt2);
		cr.add(crt3);
		List<Employee> list = cr.list();
		for (Employee emp : list) {
			System.out.print(emp);
		}

		// PROJECTION USING QBC
		ProjectionList pList = Projections.projectionList();
		Projection p1 = Projections.property("Empname");
		Projection p2 = Projections.property("sal");
		pList.add(p1);
		pList.add(p2);
		cr.setProjection(pList);

		List<Object[]> prolist = cr.list();
		for (Object a[] : prolist) {
			for (Object obj : a)
				System.out.println(obj);
		}

	}

}
