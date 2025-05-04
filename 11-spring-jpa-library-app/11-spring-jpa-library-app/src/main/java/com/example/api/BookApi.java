package com.example.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.BookDto;
import com.example.entity.Authour;
import com.example.entity.Book;
import com.example.entity.Genre;
import com.example.service.BookService;



@RestController
@RequestMapping("/books")
public class BookApi {
	@Autowired
	private BookService bookService;
	
	@PostMapping
	public Book addBook(@RequestBody BookDto bookDto){
		
	 return bookService.addBookService(bookDto);
	}
	@GetMapping
	public List<Book> allBooks(){
		 return bookService.allBooksService();
	}
    @GetMapping("/Genre")
	public List<Book> findByGenre(@RequestParam("genre") Genre genre){
		 return  bookService.searchByGenreService(genre);

	}
	
	
	
	
	
}

