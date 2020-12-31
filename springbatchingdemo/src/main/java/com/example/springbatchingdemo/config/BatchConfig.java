package com.example.springbatchingdemo.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.example.springbatchingdemo.listner.JobCompletionNotificationListner;
import com.example.springbatchingdemo.model.Student;
import com.example.springbatchingdemo.processor.PersonItemProcessor;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	public DataSource dataSource;

	@Bean
	public FlatFileItemReader<Student> reader() {

		FlatFileItemReader<Student> reader = new FlatFileItemReader<Student>();
		reader.setResource(new ClassPathResource("person.csv"));
		reader.setLineMapper(new DefaultLineMapper<Student>() {
			{
				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						setNames(new String[] { "firstName", "lastName", "email", "age" });
					}
				});
				setFieldSetMapper(new BeanWrapperFieldSetMapper<Student>() {
					{
						setTargetType(Student.class);
					}
				});
			}
		});
		return reader;
	}

	@Bean
	public PersonItemProcessor processor() {
		return new PersonItemProcessor();
	}

	@Bean
	public JdbcBatchItemWriter<Student> writer() {
		JdbcBatchItemWriter<Student> writer = new JdbcBatchItemWriter<Student>();
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Student>());
		writer.setSql("INSERT INTO student(first_name,last_name,email,age) VALUES(:firstName,:lastName,:email,:age)");
		writer.setDataSource(dataSource);
		return writer;
	}

	@Bean
	public Job importUserJob(JobCompletionNotificationListner listner) {

		return jobBuilderFactory.get("importUserJob").incrementer(new RunIdIncrementer()).listener(listner)
				.flow(step1()).end().build();

	}

	@Bean
	public Step step1() {

		return stepBuilderFactory
				.get("step1")
				.<Student, Student>chunk(10)
				.reader(reader())
				.processor(processor())
				.writer(writer())
				.faultTolerant()
				.skipLimit(10)
				.skip(RuntimeException.class)
				.build();
	}

}
