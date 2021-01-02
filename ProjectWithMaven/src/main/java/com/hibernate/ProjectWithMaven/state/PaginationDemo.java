package com.hibernate.ProjectWithMaven.state;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.ProjectWithMaven.Student;

public class PaginationDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = factory.openSession();

		String query = "from Student";
		Query createQuery = session.createQuery(query);

		// Implementing pagination
		createQuery.setFirstResult(0);
		createQuery.setMaxResults(2);

		List<Student> list = createQuery.list();

		list.parallelStream().forEach(s -> System.out.println(s.getName() + " "+ s.getCity()));

		session.close();
		factory.close();
	}
}
