package com.scotch.io.CRUDJDBC.util;

public interface SQLQueries {
	
	String FETCH_BOOKS="SELECT bookId, bookTitle, bookCategory FROM books;";
	
	String FETCH_BOOKS_BY_ID="SELECT bookId, bookTitle, bookCategory FROM books WHERE bookId = ?;";

	String INSERT_BOOKS="INSERT INTO books(bookId, bookTitle, bookCategory) values (?, ?, ?);";
	
	String UPDATE_BOOKS="UPDATE books SET bookTitle = ?, bookCategory = ? WHERE bookId = ?;";
	
	String DELETE_BOOKS="DELETE FROM books WHERE bookId = ?;";
}
 

