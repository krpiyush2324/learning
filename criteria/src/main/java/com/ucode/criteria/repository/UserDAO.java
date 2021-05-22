package com.ucode.criteria.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.ucode.criteria.model.SearchCriteria;
import com.ucode.criteria.model.Users;
import com.ucode.criteria.service.UserSearchQueryCriteriaConsumer;

@Repository
public class UserDAO implements IUserDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Users> searchUser(List<SearchCriteria> params) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Users> query = builder.createQuery(Users.class);
		Root r = query.from(Users.class);

		Predicate predicate = builder.conjunction();
		UserSearchQueryCriteriaConsumer searchConsumer = new UserSearchQueryCriteriaConsumer(predicate, builder, r);
		System.out.println("searchConsumer = "+ searchConsumer);
		params.stream().forEach(searchConsumer);
		predicate = searchConsumer.getPredicate();
		query.where(predicate);
		List<Users> result = entityManager.createQuery(query).getResultList();
		return result;
	}
	

	@Override
	public void save(Users entity) {
		entityManager.persist(entity);
	}

}
