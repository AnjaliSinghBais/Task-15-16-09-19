package com.ssi;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class SQL {

	public static void main(String[] args) {
		
		// DATA RETRIEVAL USING SQL
		Configuration config = new Configuration().configure();
		ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		SessionFactory sf = config.buildSessionFactory(sr);
		Session session =sf.openSession();
		String sql = "Select * from Employee";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Employee.class);
		List<Employee> list = query.list();
		for (Employee emp : list) {
			System.out.println(emp);
		}
	}

}
