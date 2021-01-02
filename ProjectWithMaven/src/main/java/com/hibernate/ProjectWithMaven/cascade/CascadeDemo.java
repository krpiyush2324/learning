package com.hibernate.ProjectWithMaven.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.ProjectWithMaven.mapping.Answer;
import com.hibernate.ProjectWithMaven.mapping.Question;

public class CascadeDemo {

	public static void main(String[] args) {

		// factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		// question
		Question question = new Question();
		question.setQuestion("What is cascade");

		Answer answer = new Answer();
		answer.setAnswer(
				"cascade is a property in hibernate.when we save main entity then all associated entity will save automatically");
		answer.setQuestion(question);

		Answer answer1 = new Answer();
		answer1.setAnswer("It has many types such as ALL, PERSIST ETC ");
		answer1.setQuestion(question);

		List<Answer> list = new ArrayList<Answer>();
		list.add(answer);
		list.add(answer1);

		question.setAnswer(list);

		Session s = factory.openSession();

		Transaction t = s.beginTransaction();

		// save
		s.save(question);

		t.commit();
		s.close();

	}
}
