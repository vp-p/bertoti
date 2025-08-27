package com.example.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

}

@RestController
@RequestMapping("/books")
class RestApiDemoController {
	private List<Book> books = new ArrayList<>();

	public RestApiDemoController() {
		books.addAll(List.of(
				new Book("A Náusea", 165),
				new Book("Memórias Póstumas de Brascubas", 321),
				new Book("O Estrangeiro", 98),
				new Book("Livro 4", 400)
		));
	}

	@GetMapping
	Iterable<Book> getBooks() {
		return books;
	}

	@GetMapping("/{id}")
	Optional<Book> getBookById(@PathVariable String id) {
		for (Book b: books) {
			if (b.getId().equals(id)) {
				return Optional.of(b);
			}
		}

		return Optional.empty();
	}

	@PostMapping
		Book postBook(@RequestBody Book book) {
		books.add(book);
		return book;
	}

	@PutMapping("/{id}")
	ResponseEntity<Book> putBook(@PathVariable String id,
									 @RequestBody Book Book) {
		int BookIndex = -1;

		for (Book c: books) {
			if (c.getId().equals(id)) {
				BookIndex = books.indexOf(c);
				books.set(BookIndex, Book);
			}
		}

		return (BookIndex == -1) ?
				new ResponseEntity<>(postBook(Book), HttpStatus.CREATED) :
				new ResponseEntity<>(Book, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	void deleteBook(@PathVariable String id) {
		books.removeIf(c -> c.getId().equals(id));
	}
}

class Book {
	private final String id;
	private String name;
	private Integer pages;
	
	public Book(String id, String name, Integer pages) {
		this.id = id;
		this.name = name;
		this.pages = pages;
	}

	public Book(String name, Integer pages) {
		this(UUID.randomUUID().toString(), name, pages);
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	
}