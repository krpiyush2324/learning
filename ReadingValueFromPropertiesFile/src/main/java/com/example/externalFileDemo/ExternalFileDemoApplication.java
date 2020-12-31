package com.example.externalFileDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExternalFileDemoApplication implements CommandLineRunner {

//	@Value("${name}")
//	private String name;
//	
//	@Value("${myapp.language}")
//	private String lang;
	
	@Autowired
	MyProperties props;
	
	public static void main(String[] args) {
		SpringApplication.run(ExternalFileDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("My name is " + props.getName());
		System.out.println("My project language is " + props.getMyapp().getLanguage());
	}

}
