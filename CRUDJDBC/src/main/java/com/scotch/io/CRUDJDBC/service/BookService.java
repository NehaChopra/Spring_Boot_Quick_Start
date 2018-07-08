package com.scotch.io.CRUDJDBC.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.scotch.io.CRUDJDBC.dto.Book;

/**
 * 
 * @author nchopra
 *
 */
@Service
public interface BookService {
	List<Book> getAllBooks();
	Book getBookById(int bookId);
	Boolean addBook(Book book);
	Boolean updateBook(Book book);
	Boolean deleteBook(int bookId);
}
