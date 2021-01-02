	package com.hibernate.ProjectWithMaven.state;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.ProjectWithMaven.Student;

public class HqlDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = factory.openSession();

		// HQL Syntax
		String query = "from Student as s where s.name= :n ";

		@SuppressWarnings("rawtypes")
		Query createQuery = session.createQuery(query);
		createQuery.setParameter("n", "abc");

		List<Student> list = createQuery.list();

		list.stream().forEach(s -> System.out.println(s.getName()));

		Transaction tx = session.beginTransaction();
		// delete query
//		Query createQuery2 = session.createQuery("delete from Student as s where s.name =: n");
//		createQuery2.setParameter("n", "abc");
//		int executeUpdate = createQuery2.executeUpdate();
//		System.out.println(executeUpdate);

		// Update Query
		Query createQuery2 = session.createQuery("update Student as s set name=:n");
		createQuery2.setParameter("n", "piyush");
		int executeUpdate = createQuery2.executeUpdate();
		System.out.println(executeUpdate);

		// JOIN QUERY in HQL

		Query q3 = session
				.createQuery("select q.question,q.questionId,a.answer from Question as q INNER JOIN q.answer as a");
		List<Object[]> resultList = q3.getResultList();

		for (Object[] arr : resultList) {
			System.out.println(Arrays.toString(arr));
		}
		tx.commit();
		session.close();
	}

}
