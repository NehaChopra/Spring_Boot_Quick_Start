package com.scotch.io.CRUDJDBC.service;

import java.util.List;

import com.scotch.io.CRUDJDBC.dto.Book;

/**
 * 
 * @author nchopra
 *
 */
public interface BookService {
	List<Book> getAllBooks();
	Book getBookById(int bookId);
	Boolean addBook(Book book);
	Boolean updateBook(Book book, int bookId);
	Boolean deleteBook(int bookId);
}
