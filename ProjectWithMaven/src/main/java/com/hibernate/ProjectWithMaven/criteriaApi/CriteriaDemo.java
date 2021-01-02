package com.hibernate.ProjectWithMaven.criteriaApi;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.hibernate.ProjectWithMaven.Student;

public class CriteriaDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Session s = new Configuration().configure().buildSessionFactory().openSession();
		Criteria createCriteria = s.createCriteria(Student.class);
//		createCriteria.add(Restrictions.eq("certi.course", "h"));
		createCriteria.add(Restrictions.gt("id", 1));
		List<Student> list = createCriteria.list();

		list.stream().forEach(st -> System.out.println(st.getName()));
		s.close();
	}

}
