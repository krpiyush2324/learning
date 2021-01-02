package com.hibernate.ProjectWithMaven.pojo;

import java.time.LocalDate;

public class BookPojo {

	private String title;
	private boolean isprint;
	private LocalDate publishDate;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isIsprint() {
		return isprint;
	}

	public void setIsprint(boolean isprint) {
		this.isprint = isprint;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}

	@Override
	public String toString() {
		return "BookPojo [title=" + title + ", isprint=" + isprint + ", publishDate=" + publishDate + "]";
	}

}
