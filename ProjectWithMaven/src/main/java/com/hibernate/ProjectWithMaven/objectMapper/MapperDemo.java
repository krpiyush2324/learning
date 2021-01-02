package com.hibernate.ProjectWithMaven.objectMapper;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MapperDemo {

	public static void main(String[] args) throws JsonProcessingException {
		// TODO Auto-generated method stub

		Map<String, String> map = new HashMap<String, String>();
		map.put("key", "value");
		System.out.println(map);

		ObjectMapper mapper = new ObjectMapper();
		String writeValueAsString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
		System.out.println("after serialization \n" + writeValueAsString);

		System.out.println("=================deserilization======================");

		String jsonInput = "{\"key\": \"value\"}";
		System.out.println(jsonInput);

		TypeReference<HashMap<String, String>> typerefs = new TypeReference<HashMap<String, String>>() {
		};
		HashMap<String, String> readValue = mapper.readValue(jsonInput, typerefs);
		System.out.println(readValue);
		TypeReference<HashMap<String, String>> typeRef = new TypeReference<HashMap<String, String>>() {
		};
		Map<String, String> maps = mapper.readValue(jsonInput, typeRef);

		System.out.println("after deserization\n " + maps);
	}

}
