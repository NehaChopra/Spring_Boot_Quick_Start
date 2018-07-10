package com.scotch.io.CRUDJDBC.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.scotch.io.CRUDJDBC.dto.Book;

/**
 * 
 * @author nchopra
 *
 */
public interface BookDao {
	List<Book> getAllBooks();
	Book getBookById(int bookId);
	Boolean addBook(Book book);
	Boolean updateBook(Book book, int bookId);
	Boolean deleteBook(int bookId);
}
