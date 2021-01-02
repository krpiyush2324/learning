package com.hibernate.ProjectWithMaven.manytomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToManyDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml").buildSessionFactory();

		Employee employee = new Employee();
		employee.setName("Rajesh");

		Employee employee1 = new Employee();
		employee1.setName("Jhon");

		Project project = new Project();
		project.setProjectName("library mangament");

		Project project1 = new Project();
		project1.setProjectName("school mangament");

		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(employee);
		employeeList.add(employee1);

		List<Project> projectList = new ArrayList<Project>();
		projectList.add(project);
		projectList.add(project1);
		employee.setProject(projectList);
		project.setEmployee(employeeList);

		Session s = factory.openSession();
		Transaction t = s.beginTransaction();

		s.save(employee);
		s.save(employee1);
		s.save(project);
		s.save(project1);

		t.commit();
		s.close();
	}

}
