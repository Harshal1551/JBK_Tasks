package com.tka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tka.entity.Book;
import com.tka.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookservice;
	
	 // 1. Add Book
	@PostMapping("/add-book")
	public Book addBook(@RequestBody Book book) {
		return bookservice.addBook(book);	
	} 
	
	// 2. Fetch All Books
	@GetMapping("/all-books")
	public List<Book> allBooks() {
		return bookservice.allBooks();
	}
	
	// 3. Fetch All Programming Books
	@GetMapping("/all-programming-books")
	public List<Book> allProgrammingBooks() {
		return bookservice.allProgrammingBooks();
	}
	
	//4. Fetch All Java Books
	@GetMapping("/all-java-books")
	public List<Book> allJavaBooks(){
		return bookservice.allJavaBooks();
	}
	
	// 5.Fetch Book by Id
	@GetMapping("/book/{id}")
	public Book bookById(@PathVariable int id) {
		return bookservice.bookById(id);
	}
	
	// 6.Fetch Book by Author
	@GetMapping("/author/{author}")
	public List<Book> booksById(@PathVariable String author) {
		return bookservice.booksByAuthor(author); 
	}
	
	// 7.Fetch highest price book
	@GetMapping("/high-price-book")
	public Book highPriceBook() {
		return bookservice.highPriceBook();
	}
	
	// 8.Fetch highest rating book
	@GetMapping("/high-rating-book")
	public Book highRatingBook() {
		return bookservice.highRatingBook();
	}
	
	// 9. Update Book Price By Id
	@PutMapping("/update-price/{id}/{price}")
	public Book updatePrice(@PathVariable int id, @PathVariable double price) {
		return bookservice.updatePrice(id, price);
	}
	
	// 10. Update Book Rating by Id
	@PutMapping("/update-rating/{id}/{rating}")
	public Book updateRating(@PathVariable int id, @PathVariable double rating) {
		return bookservice.updateRating(id, rating);
	}
	 
	//11. Update book category by Id
	@PutMapping("/update-category/{id}/{category}")
	public Book updateCategory(@PathVariable int id, @PathVariable String category) {
		return bookservice.updateCategory(id, category);
	}
	
	// 12. Delete Book by Id
	@DeleteMapping("/delete-book/{id}")
	public String deleteBook(@PathVariable int id) {
		return bookservice.deleteBook(id);
	}
	
	 // 13. Delete Books By Author
	@DeleteMapping("/delete-author/{author}")
	public String deleteByAuthor(@PathVariable String author) {
		return bookservice.deleteByAuthor(author);
	}
	
	// 14. Top 3 highest rating books
	@GetMapping("/top-3-rating")
	public List<Book> top3RatingBooks(){
		return bookservice.top3RatingBooks();
	}
	
	 // 15. Premium books
	@GetMapping("/premium-books")
	public List<Book> premiumBooks(){
		return bookservice.premiumBooks();
	}
	
	
	 
}
