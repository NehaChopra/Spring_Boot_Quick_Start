package com.scotch.io.CRUDJDBC.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scotch.io.CRUDJDBC.dto.Book;
import com.scotch.io.CRUDJDBC.service.BookService;

/**
 * 
 * @author nchopra
 *
 */
@RestController
@RequestMapping("/api/v1/")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("books")
	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book> books = bookService.getAllBooks();
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}
	
	/*
	 * @PathVariable is to obtain some placeholder from the URI (Spring call it an URI Template) 
	 * @RequestParam is to obtain an parameter from the URI as well. @RequestParam annotation used for accessing the query parameter values from the request.
	 * @RequestMapping(value="/user/{userId}/invoices", method = RequestMethod.GET)
		public List<Invoice> listUsersInvoices(
		            @PathVariable("userId") int user,
		            @RequestParam(value = "date", required = false) Date dateOrNull) {
		  ...
		}
	 */
	
	@GetMapping("books/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("bookId") Integer bookId) {
		Book books = bookService.getBookById(bookId);
		return new ResponseEntity<Book>(books, HttpStatus.OK);
	}
	
	@PostMapping("books")
	public ResponseEntity<Void> addBook(@RequestBody Book book) {
		Boolean result = bookService.addBook(book);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("books")
	public ResponseEntity<Void> updateBook(@RequestBody Book book) {
		Boolean result = bookService.updateBook(book);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	@DeleteMapping("books")
	public ResponseEntity<Void> deleteBook(@PathVariable("bookId") Integer bookId) {
		Boolean result = bookService.deleteBook(bookId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
