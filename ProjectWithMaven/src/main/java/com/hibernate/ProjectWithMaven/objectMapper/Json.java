package com.hibernate.ProjectWithMaven.objectMapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class Json {

	private static ObjectMapper objectMapper = getDefaultMapper();

	/**
	 * return Object mapper object
	 * 
	 * @return
	 */
	private static ObjectMapper getDefaultMapper() {
		ObjectMapper defaultMapper = new ObjectMapper();
		// -----some configuration
		defaultMapper.registerModules(new JavaTimeModule());
		defaultMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return defaultMapper;
	}

	/**
	 * return jsonNode from String
	 * 
	 * @param src
	 * @return
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	@SuppressWarnings("unused")
	public static JsonNode parse(String src) throws JsonMappingException, JsonProcessingException {
		return objectMapper.readTree(src);
	}

	/**
	 * convert jsonNode to POJO class
	 * 
	 * @param <A>
	 * @param node
	 * @param clazz
	 * @return
	 * @throws JsonProcessingException
	 */
	public static <A> A fromJson(JsonNode node, Class<A> clazz) throws JsonProcessingException {
		return objectMapper.treeToValue(node, clazz);

	}

	/**
	 * convert Object into JsonNode
	 * 
	 * @param obj
	 * @return
	 */
	public static JsonNode tojson(Object obj) {
		return objectMapper.valueToTree(obj);
	}

	/**
	 * convert jsonNode into string
	 * 
	 * @param node
	 * @return
	 * @throws JsonProcessingException
	 */
	public static String strinify(JsonNode node) throws JsonProcessingException {

		ObjectWriter objectWriter = objectMapper.writer();
		String writeValueAsString = objectWriter.writeValueAsString(node);
		return writeValueAsString;

	}

	/**
	 * ConvertJson into Json
	 * 
	 * @param node
	 * @return
	 * @throws JsonProcessingException
	 */
	public static String prettyPrint(JsonNode node) throws JsonProcessingException {

		ObjectWriter objectWriter = objectMapper.writer();
		objectWriter.with(SerializationFeature.INDENT_OUTPUT);
		String writeValueAsString = objectWriter.writeValueAsString(node);
		return writeValueAsString;

	}
}
