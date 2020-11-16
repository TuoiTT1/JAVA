package com.vn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vn.entity.Book;

@Service
public interface BookService {

	List<Book> getAllBooks();
	Book getById(Integer id);
	Book save (Book book);
	void delete(Integer id); 
}
