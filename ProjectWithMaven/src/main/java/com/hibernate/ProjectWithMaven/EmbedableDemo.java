package com.hibernate.ProjectWithMaven;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbedableDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Student st = new Student();
		st.setName("Jhon");
		st.setCity("california");

		Certificate certi = new Certificate();
		certi.setCourse("Android");
		certi.setDuration("6 month");
		st.setCerti(certi);

		Student st1 = new Student();
		st1.setName("Jack");
		st1.setCity("New york");

		Certificate certificate = new Certificate();
		certificate.setCourse("hibernate");
		certificate.setDuration("2 month");
		st1.setCerti(certificate);

		Session ses = factory.openSession();
		Transaction trans = ses.beginTransaction();

		// save Object
		ses.save(st);
		ses.save(st1);

		trans.commit();
		ses.close();
	}

}
