package com.scotch.io.CRUDJDBC.dto;
/**
 * 
 * @author nchopra
 *
 */
public class Book {
	private String bookId;
	private String bookTitle;
	private String bookCategory;
	
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getBookCategory() {
		return bookCategory;
	}
	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookTitle=" + bookTitle + ", bookCategory=" + bookCategory+ "]";
	}
	
		
}
