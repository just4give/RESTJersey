package com.mithun.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Book {

	private String title;
	private int noOfPages;
	private List<Author> authors;
	
	
	public List<Author> getAuthors() {
		return authors;
	}
	public int getNoOfPages() {
		return noOfPages;
	}
	public String getTitle() {
		return title;
	}
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	public void setNoOfPages(int noOfPages) {
		this.noOfPages = noOfPages;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
