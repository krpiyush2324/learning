package com.hibernate.ProjectWithMaven;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

	public static void main(String[] args) {
		// get() and load()

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = factory.openSession();

		Student student = session.get(Student.class, 101);
		
		Address load = session.load(Address.class, 1);
		System.out.println(load);

		System.out.println(student);
		session.close();
		factory.close();

	}

}
