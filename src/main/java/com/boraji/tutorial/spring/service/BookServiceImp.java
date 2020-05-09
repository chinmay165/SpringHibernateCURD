package com.boraji.tutorial.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boraji.pojo.Bookpojo;
import com.boraji.tutorial.spring.dao.BookDao;
import com.boraji.tutorial.spring.model.BookEnty;

@Service
public class BookServiceImp implements BookService{
	
	@Autowired
	private BookDao bDao;

	@Transactional
	public List<BookEnty> list() {
		// TODO Auto-generated method stub
		return bDao.list();
	}

	@Transactional
	public void saveBook(Bookpojo bpojo) {
		// TODO Auto-generated method stub
		bDao.saveBook(bpojo);
		
	}

	@Transactional
	public Bookpojo getBookDetails(Long hid_bId) {
		// TODO Auto-generated method stub
		Bookpojo bpojo = new Bookpojo();
		BookEnty bEnty = bDao.getBookDetails(hid_bId);
		bpojo.setBookId(bEnty.getBookId());
		bpojo.setName(bEnty.getName());
		bpojo.setAuthor(bEnty.getAuthor());
		bpojo.setPrice(bEnty.getPrice());
		return bpojo;
	}

	@Transactional
	public void updateBook(Bookpojo bpojo) {
		// TODO Auto-generated method stub
		//BookEnty bEnty = bDao.getBookDetails(bpojo.getBookId());
		 bDao.updateBook(bpojo);
	}

	@Transactional
	public String deteleBook(Long hid_bId) {
		// TODO Auto-generated method stub
		try {
			bDao.deteleBook(hid_bId);
			return "REcord dleted";
		}catch(Exception e) {
			e.printStackTrace();
			return "Failed";
		}
		
	}

	

}
