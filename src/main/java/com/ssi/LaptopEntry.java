package com.ssi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mysql.jdbc.Util;

public class LaptopEntry {
	public static void main(String[] args) {
		
		Configuration config = new Configuration().configure();
		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();
		
		Laptop l1 = new Laptop("L111", "DELL", 50000);
		Laptop l2 = new Laptop("L112", "HCL", 70000);
		Laptop l3 = new Laptop("L113", "HP", 40000);

		Transaction tr = session.beginTransaction();
		session.save(l1);
		session.save(l2);
		session.save(l3);
		tr.commit();
		session.close();
		System.out.println("RECORD ADDED");

	}

}
