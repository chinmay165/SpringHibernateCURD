package com.boraji.tutorial.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.boraji.pojo.Bookpojo;
import com.boraji.tutorial.spring.model.BookEnty;


public interface BookService {

	List<BookEnty> list();

	void saveBook(Bookpojo bpojo);

	Bookpojo getBookDetails(Long hid_bId);

	void updateBook(Bookpojo bpojo);

	String deteleBook(Long hid_bId);

}
