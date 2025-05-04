package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dto.BookDto;
import com.example.entity.Book;
import com.example.entity.Genre;

public interface BookRepository extends JpaRepository<Book, Integer> {

//List<Book> findByName( String name);
List<Book> findByGenre(Genre genre);
}

