package com.scotch.io.CRUDJDBC.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scotch.io.CRUDJDBC.dao.BookDao;
import com.scotch.io.CRUDJDBC.dto.Book;
import com.scotch.io.CRUDJDBC.service.BookService;

/**
 * 
 * @author nchopra
 *
 */
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookDao bookDao;
	
	@Override
	public List<Book> getAllBooks() {
		return bookDao.getAllBooks();
	}

	@Override
	public Book getBookById(int bookId) {
		return bookDao.getBookById(bookId);
	}

	@Override
	public Boolean addBook(Book book) {
		return bookDao.addBook(book);
	}

	@Override
	public Boolean updateBook(Book book, int bookId) {
		return bookDao.updateBook(book, bookId);
	}

	@Override
	public Boolean deleteBook(int bookId) {
		return bookDao.deleteBook(bookId);
	}
	
}
