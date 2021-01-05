package com.example.drooltest.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.drooltest.model.Bridge;
import com.example.drooltest.model.Education;
import com.example.drooltest.model.Home;
import com.example.drooltest.model.LoanResult;
import com.example.drooltest.model.LoanType;
import com.example.drooltest.model.Product;
import com.example.drooltest.model.Shop;
import com.example.drooltest.util.Utils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class Controller {

	@Autowired
	KieContainer kieContainer;

	@Autowired
	Utils utils;

	@Autowired
	ResourceLoader resourceLoader;

	@PostMapping("/discount")
	public Product getDiscount(@RequestBody Product request) {
		Product product = new Product();
		product.setCardType(request.getCardType());
		product.setEvent(request.getEvent());

		KieSession kSession = kieContainer.newKieSession("first-ksession-rule");
		kSession.insert(product);
		kSession.fireAllRules();
		return product;
	}

	@PostMapping("/discount/buyer")
	public Product getDiscountForPlatinumUSer(@RequestBody Product request) {
		Product product = new Product();
		product.setCardType(request.getCardType());
		product.setFirstTime(true);
		product.setBuyer(request.getBuyer());

		KieSession kSession = kieContainer.newKieSession("first-ksession-rule");
		kSession.insert(product);
		kSession.fireAllRules();
		return product;
	}

	@PostMapping("/loanType")
	public LoanResult getLoan(@RequestBody LoanType request) {
		System.out.println(request.getBridge());

		ObjectMapper mapper = new ObjectMapper();
		Object res = request.getBridge().getName().equals("bridge")
				? mapper.convertValue(request.getBridge(), Bridge.class)
				: request.getEducation().equals("be") ? mapper.convertValue(request.getEducation(), Education.class)
						: request.getHome().equals("home") ? mapper.convertValue(request.getHome(), Home.class)
								: new BigDecimal("40");
		System.out.println("result" + res);

		KieSession kSession = kieContainer.newKieSession("first-ksession-rule");
		FactHandle insert = kSession.insert(res);
		FactHandle insert2 = kSession.insert(new LoanResult());
		System.out.println("insert" + insert + "insert 2" + insert2);
		int fireAllRules = kSession.fireAllRules();
		System.out.println("rule " + fireAllRules);

		LoanResult loanResult = new LoanResult();
		return loanResult;
	}

	@PostMapping("/shop")
	public Shop getShopDeatil(@RequestBody Shop request) {

		Shop shop = new Shop();
		shop.setShopName(request.getShopName());

		List<Product> productList = new ArrayList<Product>();

		request.getProduct().stream().forEach(p -> {
			Product product = new Product();
			product.setCardType(p.getCardType());
			product.setFirstTime(true);
			product.setEvent(p.getEvent());
			productList.add(p);
		});

		shop.setProduct(productList);
		KieSession kSession = kieContainer.newKieSession("first-ksession-rule");
		kSession.insert(shop);
		kSession.fireAllRules();
		return shop;
	}

	@GetMapping("/getJson")
	public HashMap<String, Object> getJsonValue() throws IOException {
//		Object globalVariables = utils.getGlobalVariables().get("address");
//		System.out.println(globalVariables);
//		String[] split = globalVariables.toString().split(",");
//		Stream.of(split).forEach(System.out::println);
//		return globalVariables;

		HashMap<String, Object> globalVariable = null;
		ObjectMapper mapper = new ObjectMapper();
		String path = "rules/backUp.json";

		ResourceLoader resource = new DefaultResourceLoader();
		org.springframework.core.io.Resource resource2 = resource.getResource("classpath:" + path);

		Reader reader = new InputStreamReader(resource2.getInputStream());
		System.out.println("reader ouput " + reader.toString());
		String fileData = FileCopyUtils.copyToString(reader);
		System.out.println(" filedate is " + fileData);

		TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {
		};
		HashMap<String, Object> readValue = mapper.readValue(fileData, typeRef);
		return readValue;
	}

	@GetMapping("getdrlfile")
	public List<String> getFile() throws IOException {

		List<String> fileList = new ArrayList<>();
		String path = "classpath:" + File.separator + "rules" + File.separator;
		ClassLoader classLoader = this.getClass().getClassLoader();
		System.out.println("classloader " + classLoader);
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(classLoader);
		System.out.println("resolver" + resolver);
		Resource[] resources = null;
		
		// reading file form classpath
		try {
			resources = resolver.getResources(path + File.separator + "*.drl");
			System.out.println(resources);

		} catch (Exception e) {
			e.printStackTrace();
		}

		for (Resource file : resources) {
			System.out.println(file.getFilename());
			fileList.add(file.getFilename());
		}

		// reading the data from file
		for (String fileName : fileList) {
			Resource res = resourceLoader.getResource(path + File.separator + fileName);
			Reader reader = new InputStreamReader(res.getInputStream());
			String fileData = FileCopyUtils.copyToString(reader);
			System.out.println("filedata " + fileData);
		}
		return fileList;
	}
}
