package com.hibernate.ProjectWithMaven.mapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo {

	public static void main(String[] args) {

		// factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		// question
		Question question = new Question();
		question.setQuestion("What is Java");

		Answer answer = new Answer();
		answer.setAnswer("Java is a programming language");
		answer.setQuestion(question);

		Answer answer1 = new Answer();
		answer1.setAnswer("Hibernate is an ORM");
		answer1.setQuestion(question);

		List<Answer> list = new ArrayList<Answer>();
		list.add(answer);
		list.add(answer1);

		question.setAnswer(list);

		Session s = factory.openSession();

		Transaction t = s.beginTransaction();

		// save
		s.save(question);
		s.save(answer);
		s.save(answer1);

		t.commit();
		s.close();

	}
}
