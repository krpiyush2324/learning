package com.hibernate.ProjectWithMaven.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.ProjectWithMaven.Student;

public class FirstLevelCacheDemo {

	public static void main(String[] args) {

		// factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		// by default first level cache enabled

		Session ses = factory.openSession();

		Student student = ses.get(Student.class, 2);
		System.out.println(student);

		Student student1 = ses.get(Student.class, 2);
		System.out.println(student1);
		ses.close();
		factory.close();
	}
}
