package com.hibernate.ProjectWithMaven.pojo;

import java.util.List;

public class AuthorPojo {

	private String authorName;
	private List<BookPojo> book;

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public List<BookPojo> getBook() {
		return book;
	}

	public void setBook(List<BookPojo> book) {
		this.book = book;
	}

}
