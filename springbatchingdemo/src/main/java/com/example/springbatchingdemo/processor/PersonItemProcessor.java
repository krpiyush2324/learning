package com.example.springbatchingdemo.processor;

import org.springframework.batch.item.ItemProcessor;

import com.example.springbatchingdemo.model.Student;

public class PersonItemProcessor implements ItemProcessor<Student, Student> {

	@Override
	public Student process(Student person) throws Exception {
		// TODO Auto-generated method stub
		final String firstName = person.getFirstName().toUpperCase();
		final String lastName = person.getLastName().toUpperCase();

		System.out.println("converting person into transformationPerson ");
		final Student transformationPerson = new Student(firstName, lastName, person.getEmail(), person.getAge());

		return transformationPerson;
	}

}
