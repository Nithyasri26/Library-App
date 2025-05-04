package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.example.dto.BookDto;
import com.example.entity.Authour;
import com.example.entity.Book;
import com.example.entity.Genre;
import com.example.exception.AuthourNotFoundException;
import com.example.exception.BookNotFoundException;
import com.example.repo.AuthourRepository;
import com.example.repo.BookRepository;
@Component
public class BookServiceImpl implements BookService {
     @Autowired
     private BookRepository bookRepo;
     @Autowired
     private AuthourRepository authourRepo;
	@Override
	public Book addBookService(BookDto bookDto) {
		
Optional<Authour> authourOpt=authourRepo.findById(bookDto.getAuthourId());
if(authourOpt.isPresent()) {
	Authour a=authourOpt.get();


		Book b=new Book();
		b.setBookName(bookDto.getBookName());
		b.setCost(bookDto.getCost());
		b.setGenre(bookDto.getGenre());
		b.setStock(bookDto.getStock());
		b.setAuthour(a);
		return bookRepo.save(b);
	}

else
	throw new AuthourNotFoundException("Authour not found");
	}
	
	@Override
	public List<Book> allBooksService() {
		// TODO Auto-generated method stub
		return bookRepo.findAll() ;
	}

	@Override
	public List<Book> searchByAuthourService(int authourId) {
		// TODO Auto-generated method stub
		return null;
		
		
	}

	@Override
	public List<Book> searchByGenreService(Genre genre) {
		// TODO Auto-generated method stub
		return bookRepo.findByGenre(genre);
	}

	@Override
	public Book updateBookService(Book book, int bookId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeBookService(int bookId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Book> searchByBookNameService(String bookName) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public void removeBookService(int bookId) {
//		// TODO Auto-generated method stub
//		bookRepo.deleteById(bookId);
//	}

//	@Override
//	public List<Book> searchByBookNameService(String bookName) {
//		// TODO Auto-generated method stub
//		return bookRepo.findByName(bookName);
//	}

	

 
}
