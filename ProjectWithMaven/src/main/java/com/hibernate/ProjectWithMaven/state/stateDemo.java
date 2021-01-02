package com.hibernate.ProjectWithMaven.state;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.ProjectWithMaven.Certificate;
import com.hibernate.ProjectWithMaven.Student;

public class stateDemo {

	public static void main(String[] args) {

		// Practical of hibernate :states
		// Transient
		// PSersistent
		// Detached
		// Remove

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Student st = new Student();
		st.setName("Jhon");
		st.setCity("california");
		st.setCerti(new Certificate("jpa", "2 month"));

		// student : transient
		Session ses = factory.openSession();
		Transaction tr = ses.beginTransaction();
		ses.save(st);
		// Student : Persistent - session ,databse

		st.setName("abc");

		tr.commit();
		ses.close();

		st.setName("sachine");
		System.out.println(st);

	}
}
