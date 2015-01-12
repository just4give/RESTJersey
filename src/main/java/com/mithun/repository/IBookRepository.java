package com.mithun.repository;

import java.util.List;

import com.mithun.model.Book;

public interface IBookRepository {

	List<Book> getAllBooks();

	Book getBookById(String id);

	Book getBookByTitle(String title);
}
