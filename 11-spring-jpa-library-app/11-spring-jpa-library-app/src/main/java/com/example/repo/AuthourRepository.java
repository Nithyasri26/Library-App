package com.example.repo;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entity.Authour;
import com.example.entity.Book;
public interface AuthourRepository extends JpaRepository<Authour, Integer> {

	List<Authour> findByName(String name);
	
	@Query(value="select * from book where author_id=:id", nativeQuery=true)
	List<Book> searchBooks(@Param("id") int authourId);
}
 