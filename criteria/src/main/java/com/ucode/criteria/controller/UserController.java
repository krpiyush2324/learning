package com.ucode.criteria.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ucode.criteria.model.SearchCriteria;
import com.ucode.criteria.model.Users;
import com.ucode.criteria.repository.IUserDAO;

@RestController
public class UserController {

	@Autowired
	private IUserDAO api;

	@RequestMapping(method = RequestMethod.GET, value = "/users")
	@ResponseBody
	public List<Users> findAll(@RequestParam(value = "search", required = false) String search) {
		List<SearchCriteria> params = new ArrayList<SearchCriteria>();
		System.out.println("request " + search);
		if (search != null) {
			Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
			Matcher matcher = pattern.matcher(search + ",");
			System.out.println("matcer in controller = " + matcher);
			while (matcher.find()) {
				params.add(new SearchCriteria(matcher.group(1), matcher.group(2), matcher.group(3)));
				System.out.println(matcher.group(1));
				System.out.println(matcher.group(2));
				System.out.println(matcher.group(3));
			}
		}
		return api.searchUser(params);
	}

}
