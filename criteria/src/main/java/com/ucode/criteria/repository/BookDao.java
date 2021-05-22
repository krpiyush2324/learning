//package com.ucode.criteria.repository;
//
//import java.util.List;
//import javax.persistence.EntityManager;
//import javax.persistence.TypedQuery;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Predicate;
//import javax.persistence.criteria.Root;
//
//import org.springframework.stereotype.Repository;
//
//import com.ucode.criteria.model.Book;
//
//import lombok.NoArgsConstructor;
//
//@Repository
//@NoArgsConstructor
//public class BookDao {
//
//	EntityManager em;
//	
//	
//	 List<Book> findBooksByAuthorNameAndTitle(String authorName, String title) {
//	        CriteriaBuilder cb = em.getCriteriaBuilder();
//	        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
//
//	        Root<Book> book = cq.from(Book.class);
//	        Predicate authorNamePredicate = cb.equal(book.get("author"), authorName);
//	        Predicate titlePredicate = cb.like(book.get("title"), "%" + title + "%");
//	        cq.where(authorNamePredicate, titlePredicate);
//
//	        TypedQuery<Book> query = em.createQuery(cq);
//	        return query.getResultList();
//	    }
//}
