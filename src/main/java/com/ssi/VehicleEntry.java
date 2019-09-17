package com.ssi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class VehicleEntry {
	public static void main(String[] args) {

		Configuration config = new Configuration().configure();
		ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		SessionFactory sf = config.buildSessionFactory(sr);
		Session session = sf.openSession();

		Vehicle v1 = new Vehicle(12, "bullet", 1500000);
		Vehicle v2 = new Vehicle(13, "FZX", 1000000);
		Vehicle v3 = new Vehicle(14, "YAMAHA", 500000);

		Transaction tr = session.beginTransaction();
		session.save(v1);
		session.save(v2);
		session.save(v3);
		tr.commit();
		session.close();
		System.out.println("RECORD ADDED");

	}

}
