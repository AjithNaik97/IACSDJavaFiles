package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

	@Query("select b from Book b where b.title=:title")
	public List<Book> searchBookbyTitle(@Param("title") String title);
}
