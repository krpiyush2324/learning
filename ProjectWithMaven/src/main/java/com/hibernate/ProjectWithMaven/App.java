package com.hibernate.ProjectWithMaven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("project started....");

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = factory.openSession();
		Transaction beginTransaction = session.beginTransaction();

		// creating student
		Student st = new Student();
		st.setName("Jhon");
		st.setCity("california");
		session.save(st);

		// creating object for address

		Address address = new Address();
		address.setCity("Delihi");
		address.setStreet("street1");
		address.setOpen(true);
		address.setX(123.34);
		address.setAdded(new Date());
		// reading image

		@SuppressWarnings("resource")
		FileInputStream fis = new FileInputStream("src/main/java/image.png");
		byte[] data = new byte[fis.available()];
		fis.read(data);
		address.setImage(data);

		session.save(address);

		beginTransaction.commit();
		session.close();
		factory.close();
		System.out.println("done");

	}
}
