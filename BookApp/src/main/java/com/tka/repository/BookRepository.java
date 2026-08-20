package com.tka.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tka.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	// 3 & 4. Programming / Java Books
	List<Book> findByCategory(String category);

	// 6. Books by Author
	List<Book> findByAuthor(String author);

	// 7. Highest Price Book
	Book findTopByOrderByPriceDesc();

	// 8. Highest Rating Book
	Book findTopByOrderByRatingDesc();

	// 13. Delete Books by Author
	void deleteByAuthor(String author);

	// 14. Top 3 Highest Rating Books
	List<Book> findTop3ByOrderByRatingDesc();

	// 15. Premium Books
	List<Book> findByPriceGreaterThanAndRatingGreaterThan(double price, double rating);

}
