package com.hibernate.ProjectWithMaven.objectMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.hibernate.ProjectWithMaven.pojo.AuthorPojo;
import com.hibernate.ProjectWithMaven.pojo.BookPojo;
import com.hibernate.ProjectWithMaven.pojo.DayPojo;
import com.hibernate.ProjectWithMaven.pojo.SimpleTestCaseJsonPojo;

class JsonTest {

	String simpleTestCasejsonSource = "{\"title\": \"code from scracth\",\r\n" + "	\"author\": \"Jhon pascal\"}";

	private String dayScenerio1 = "{\"date\": \"2019-12-25\",\r\n" + "	\"name\": \"chrismas day\"}";

	private String auhtorScenerio1 = "{\"authorName\":\"jhon\",\"book\":[{\"title\":\"title1\",\"isprint\":\"true\",\"publishDate\":\"2019-12-25\"},{\"title\":\"title2\",\"isprint\":\"false\",\"publishDate\":\"2020-12-25\"}]}";

	@Test
	void parseTest() throws JsonMappingException, JsonProcessingException {
		JsonNode node = Json.parse(simpleTestCasejsonSource);
		// System.out.println("node from test class " + node);
		assertEquals(node.get("title").asText(), "code from scracth");
	}

	@Test
	void fromJsonTest() throws JsonMappingException, JsonProcessingException {
		JsonNode parse = Json.parse(simpleTestCasejsonSource);
		SimpleTestCaseJsonPojo pojo = Json.fromJson(parse, SimpleTestCaseJsonPojo.class);
		System.out.println("pojo is " + pojo);
		assertEquals(pojo.getTitle(), "code from scracth");

	}

	@Test
	void toJsonTest() {
		SimpleTestCaseJsonPojo pojo = new SimpleTestCaseJsonPojo();
		pojo.setTitle("welcome to java");
		System.out.println(pojo);

		JsonNode tojson = Json.tojson(pojo);
		// System.out.println("tojson method()" + tojson);
		assertEquals(tojson.get("title").asText(), "welcome to java");
	}

	@Test
	void stringify() throws JsonProcessingException {

		SimpleTestCaseJsonPojo pojo = new SimpleTestCaseJsonPojo();
		pojo.setTitle("welcome to java");
		JsonNode tojson = Json.tojson(pojo);

		String strinify = Json.strinify(tojson);
		String prettyPrint = Json.prettyPrint(tojson);
		System.out.println(strinify);
		System.out.println(prettyPrint);

	}

	@Test
	void dayTestScenerio1() throws JsonMappingException, JsonProcessingException {
		JsonNode parse = Json.parse(dayScenerio1);
		DayPojo pojo = Json.fromJson(parse, DayPojo.class);
		System.out.println("date is " + pojo.getDate());
		assertEquals(pojo.getDate().toString(), "2019-12-25");

	}

	@Test
	void authorTestScenerio2() throws JsonMappingException, JsonProcessingException {
		JsonNode parse = Json.parse(auhtorScenerio1);
		AuthorPojo pojo = Json.fromJson(parse, AuthorPojo.class);
		System.out.println("authorName is " + pojo.getAuthorName());

		for (BookPojo bp : pojo.getBook()) {
			System.out.println("title is " + bp.getTitle());
			System.out.println("is printed ? " + bp.isIsprint());
			System.out.println("Publish Date " + bp.getPublishDate());
		}

	}

}
