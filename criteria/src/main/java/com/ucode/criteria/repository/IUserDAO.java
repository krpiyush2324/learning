package com.ucode.criteria.repository;

import java.util.List;

import com.ucode.criteria.model.SearchCriteria;
import com.ucode.criteria.model.Users;

public interface IUserDAO {

	List<Users> searchUser(List<SearchCriteria> params);

	void save(Users entity);

}
