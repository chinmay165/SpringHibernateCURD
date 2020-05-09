package com.boraji.tutorial.spring.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.boraji.pojo.Bookpojo;
import com.boraji.tutorial.spring.model.BookEnty;

@Repository
public class BookDaoImp implements BookDao{
	
	@Autowired
	private SessionFactory sf;

	@Override
	public List<BookEnty> list() {
		// TODO Auto-generated method stub
		TypedQuery<BookEnty> bookQuery = sf.getCurrentSession().createQuery("from BookEnty");
		return bookQuery.getResultList();
	}

	@Override
	public void saveBook(Bookpojo bpojo) {
		// TODO Auto-generated method stub
		BookEnty bookEnty = new BookEnty();
		
		bookEnty.setName(bpojo.getName());
		bookEnty.setAuthor(bpojo.getAuthor());
		bookEnty.setPrice(bpojo.getPrice());
	
		sf.getCurrentSession().save(bookEnty);
		
	}

	@Override
	public BookEnty getBookDetails(Long hid_bId) {
		// TODO Auto-generated method stub
		BookEnty bEnty = sf.getCurrentSession().load(BookEnty.class, hid_bId);
		return bEnty;
	}

	@Override
	public void updateBook(Bookpojo bpojo) {
		// TODO Auto-generated method stub
		BookEnty bEnty = getBookDetails(bpojo.getBookId());
		bEnty.setName(bpojo.getName());
		bEnty.setAuthor(bpojo.getAuthor());
		bEnty.setPrice(bpojo.getPrice());
	}

	@Override
	public void deteleBook(Long hid_bId) {
		// TODO Auto-generated method stub
		BookEnty bEnty = null;
		Session session = sf.getCurrentSession();
		bEnty = session.load(BookEnty.class, hid_bId);
		session.delete(bEnty);
		
	}

}
