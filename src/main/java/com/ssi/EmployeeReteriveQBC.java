package com.ssi;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;

public class EmployeeReteriveQBC {

	public static void main(String[] args) {

		Configuration config = new Configuration().configure();
		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();

		// DATA RETERIVAL USING QBC
		Criteria cr = session.createCriteria(Employee.class);
		List<Employee> emps = cr.list();
		for (Employee emp : emps) {
			System.out.println(emp.getEmpno());
			System.out.println(emp.getEmpname());
			System.out.println(emp.getSal());
			System.out.println("___________________________________");

		}

		// ORDERING USING QBC
		Order ord1 = Order.asc("Empname");
		Order ord2 = Order.desc("Empno");
		cr.addOrder(ord1);
		cr.addOrder(ord2);
		List<Employee> list = cr.list();
		for (Employee e : list) {
			System.out.println(e);
		}

	}

}