package com.mithun.repository;

import java.util.ArrayList;
import java.util.List;

import com.mithun.model.Book;

public class BookRepositoryStub implements IBookRepository{

	public List<Book> getAllBooks() {
		List<Book> listOfBooks = new ArrayList<Book>();
		Book spring = new Book();
		spring.setTitle("Spring MVC");
		spring.setNoOfPages(20);
		
		Book maven = new Book();
		maven.setTitle("Maven Fundamentals");
		maven.setNoOfPages(30);
		listOfBooks.add(spring);
		listOfBooks.add(maven);
		return listOfBooks;
	}

	public Book getBookById(String id) {
		Book spring = new Book();
		spring.setTitle("REST Fundamentals");
		spring.setNoOfPages(45);
		return spring;
	}

	public Book getBookByTitle(String title) {
		Book spring = new Book();
		spring.setTitle("REST Fundamentals");
		spring.setNoOfPages(45);
		return spring;
	}

}
