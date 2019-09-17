package com.ssi;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class DMLOperations {

	public static void main(String[] args) {
		Configuration config = new Configuration().configure();
		ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		SessionFactory sf = config.buildSessionFactory(sr);
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Query qry = session.createQuery("delete from Employee where Empno=:no");
		qry.setParameter("no", 3);
		int res = qry.executeUpdate();
		tr.commit();
		System.out.println("Command successfully executed....");
		System.out.println("Numer of records effected due to delete query" + res);

		Query qry1 = session.createQuery("update from Employee set sal=900000 where Empno=2");
		int res1 = qry1.executeUpdate();
		Transaction tr1 = session.beginTransaction();
		tr1.commit();
		System.out.println("Command successfully updated....");
	}

}
