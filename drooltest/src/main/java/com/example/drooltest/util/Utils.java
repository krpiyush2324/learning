package com.example.drooltest.util;

import java.io.File;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Utils {

	private List<String> getRuleFilesList(String loanRuleType, String ruleVersion) {
		List<String> ruleFilesList = new ArrayList<>();
		ClassLoader classLoader = this.getClass().getClassLoader();
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(classLoader);
		Resource[] resources = null;
		try {
			resources = resolver
					.getResources("classpath:" + "com" + File.separator + "sample" + File.separator + "rules"
							+ File.separator + ruleVersion + File.separator + loanRuleType + File.separator + "*.drl");
		} catch (IOException e) {
			// log.error("Error while fetching rule files");
			e.printStackTrace();
		}
		for (Resource resource : resources) {
			ruleFilesList.add(resource.getFilename());
		}
		return ruleFilesList;
	}

	/**
	 * read the value from json file
	 * @return
	 * @throws IOException
	 */
	public static HashMap<String, Object> getGlobalVariables() throws IOException {
		HashMap<String, Object> globalVariables = null;
		ObjectMapper mapper = new ObjectMapper();
		String pathGlobal = "rules/backUp.json";
		Reader reader = new InputStreamReader(getResource(pathGlobal).getInputStream());
		String filedata = FileCopyUtils.copyToString(reader);
		TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {
		};
		globalVariables = mapper.readValue(filedata, typeRef);

		return globalVariables;
	}

	public static Resource getResource(String path) throws IOException {

		ResourceLoader resourceLoader = new DefaultResourceLoader();
		return resourceLoader.getResource("classpath:" + path);

	}
}
