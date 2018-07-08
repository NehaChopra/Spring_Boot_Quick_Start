package com.scotch.io.CRUDJDBC.dao.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.scotch.io.CRUDJDBC.dao.BookDao;
import com.scotch.io.CRUDJDBC.dto.Book;
import com.scotch.io.CRUDJDBC.util.SQLQueries;

/**
 * 
 * @author nchopra
 *
 */
public class BookDaoImpl implements BookDao, SQLQueries {

	@Autowired
   private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Book> getAllBooks() {
		return jdbcTemplate.query(SQLQueries.FETCH_BOOKS, new BeanPropertyRowMapper<Book>(Book.class));
	}

	@Override
	public Book getBookById(int bookId) {
		return jdbcTemplate.queryForObject(SQLQueries.FETCH_BOOKS_BY_ID, new BeanPropertyRowMapper<Book>(Book.class));
	}

	@Override
	public Boolean addBook(Book book) {
		jdbcTemplate.update(SQLQueries.INSERT_BOOKS, book.getBookId(), book.getBookTitle(), book.getBookCategory());
		return true;
	}

	@Override
	public Boolean updateBook(Book book) {
		jdbcTemplate.update(SQLQueries.UPDATE_BOOKS, book.getBookId(), book.getBookTitle(), book.getBookCategory());
		return true;
	}

	@Override
	public Boolean deleteBook(int bookId) {
		jdbcTemplate.update(SQLQueries.DELETE_BOOKS, bookId);
		return true;
	}
}
