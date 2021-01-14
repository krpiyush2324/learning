package com.s3demo.s3demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class Config {

	@Value("${secretKey}")
	private String secretKey;

	@Value("${accesskey}")
	private String accesskey;


	@Bean
	public AmazonS3 getclient() {
		AWSCredentials credential = new BasicAWSCredentials(accesskey, secretKey);
		return AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credential))
				.withRegion(Regions.US_EAST_1).build();

	}

}
