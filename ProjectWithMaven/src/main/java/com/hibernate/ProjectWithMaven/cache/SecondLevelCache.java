package com.hibernate.ProjectWithMaven.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.ProjectWithMaven.Student;

public class SecondLevelCache {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		// factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		// by default first level cache enabled

		// first
		Session ses1 = factory.openSession();

		Student student1 = ses1.get(Student.class, 2);
		System.out.println(student1);
		ses1.close();

		// second
		Session ses2 = factory.openSession();

		Student student2 = ses2.get(Student.class, 2);
		System.out.println(student2);
		ses1.close();
		ses2.close();

		factory.close();

	}

}
