package com.boraji.tutorial.spring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.boraji.pojo.Bookpojo;
import com.boraji.tutorial.spring.model.BookEnty;


public interface BookDao {

	List<BookEnty> list();

	void saveBook(Bookpojo bpojo);

	BookEnty getBookDetails(Long hid_bId);

	void updateBook(Bookpojo bpojo);

	void deteleBook(Long hid_bId);

}
