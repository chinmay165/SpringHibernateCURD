package com.boraji.pojo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

public class Bookpojo {

	
	private Long bookId;
	
	@Size(max = 20, min = 3,message = "name should be greater than 3")
	private String name;
	
	@NotBlank(message = "Author of Book can not be blank")
	private String author;
	
	@Range(min = 100, max = 9000, message = "Price should be between 100 to 9000")
	private float price;

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
}
