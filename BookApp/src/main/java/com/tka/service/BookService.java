package com.tka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tka.entity.Book;
import com.tka.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookrepo;

	// 1. Add Book
	public Book addBook(Book book) {
		return bookrepo.save(book);
	}

	// 2. Fetch All Books
	public List<Book> allBooks() {
		return bookrepo.findAll();
	}

	// 3. Fetch All Programming Books
	public List<Book> allProgrammingBooks() {
		return bookrepo.findByCategory("Programming");
	}

	// 4. Fetch All Java Books
	public List<Book> allJavaBooks() {
		return bookrepo.findByCategory("Java");
	}

	// 5. Fetch Book By ID
	public Book bookById(int id) {
		return bookrepo.findById(id).get();
	}

	// 6. Fetch Books By Author
	public List<Book> booksByAuthor(String author) {
		return bookrepo.findByAuthor(author);
	}

	// 7. Highest Price Book
	public Book highPriceBook() {
		return bookrepo.findTopByOrderByPriceDesc();
	}

	// 8. Highest Rating Book
	public Book highRatingBook() {
		return bookrepo.findTopByOrderByRatingDesc();
	}

	// 9. Update Price
	public Book updatePrice(int id, double price) {

		Book book = bookrepo.findById(id).get();
		book.setPrice(price);

		return bookrepo.save(book);
	}

	// 10. Update Rating
	public Book updateRating(int id, double rating) {

		Book book = bookrepo.findById(id).get();
		book.setRating(rating);

		return bookrepo.save(book);
	}

	// 11. Update Category
	public Book updateCategory(int id, String category) {

		Book book = bookrepo.findById(id).get();
		book.setCategory(category);

		return bookrepo.save(book);
	}

	// 12. Delete Book By ID
	public String deleteBook(int id) {
		bookrepo.deleteById(id);
		return "Book deleted successfully";
	}

	// 13. Delete Books By Author
	@Transactional
	public String deleteByAuthor(String author) {
		bookrepo.deleteByAuthor(author);
	    return "Books deleted successfully";
	}

	// 14. Top 3 Highest Rating Books
	public List<Book> top3RatingBooks() {
		return bookrepo.findTop3ByOrderByRatingDesc();
	}

	// 15. Premium Books
	public List<Book> premiumBooks() {
		return bookrepo.findByPriceGreaterThanAndRatingGreaterThan(1000, 4);
	}

}
