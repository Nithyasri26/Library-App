package com.example.service;
import java.util.List;
import com.example.dto.BookDto;
import com.example.entity.Book;
import com.example.entity.Genre;
public interface BookService {
Book addBookService(BookDto book);


List<Book> allBooksService();
List<Book> searchByAuthourService(int authourId);
List<Book> searchByGenreService(Genre genre);
Book updateBookService(Book book,int bookId);
void removeBookService(int bookId);

List<Book> searchByBookNameService(String bookName);

}
