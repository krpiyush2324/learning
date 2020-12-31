package com.example.springbatchingdemo.listner;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.example.springbatchingdemo.model.Student;

@Component
public class JobCompletionNotificationListner extends JobExecutionListenerSupport {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public JobCompletionNotificationListner(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {

			List<Student> results = jdbcTemplate.query("SELECT first_name, last_name,email,age FROM student",
					new RowMapper<Student>() {
						@Override
						public Student mapRow(ResultSet rs, int row) throws SQLException {
							return new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
						}
					});

			for (Student person : results) {
				System.out.println("Found <" + person + "> in the database.");
			}

		}
	}
}
