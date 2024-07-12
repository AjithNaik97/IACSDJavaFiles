package com.app.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Book;
import com.app.repository.BookRepository;

@Service
@Transactional
public class BookServiceImpl implements IBookService {

	@Autowired
	private BookRepository repo;

	@Override
	public Book insert(Book b) {
		return repo.save(b);
	}

	@Override
	public List<Book> retirveAll() {
		return repo.findAll().stream().collect(Collectors.toList());
	}

	@Override
	public boolean update(Book b) {
		if (repo.existsById(b.getId())) {
			repo.save(b);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteByTitle(String title) {
		List<Book> blist = repo.searchBookbyTitle(title);
		if (!blist.isEmpty()) {
			for (Book b1 : blist) {
				repo.deleteById(b1.getId());
			}
			return true;
		}
		return false;
	}

}
