package com.bookshop.bookshopapi;

import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.print.attribute.standard.DateTimeAtCompleted;

public class Book {
	
	public Book(String id, String title, String authors, String categories, String isbn) {
		super();
		this.id = id;
		this.title = title;
		this.author = authors;
		this.categories = categories;
		this.isbn = isbn;
		this.dateTimeAdded = LocalDateTime.now().withNano(0).toString();
		this.lastModified = LocalDateTime.now().withNano(0).toString();
	}
	public Book() {
		super();
	}
	
	private String id;
	private String title;
	private String author;
	private String categories;
	private String isbn;
	//Admin fields
	private String dateTimeAdded;
	private String lastModified;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDateTimeAdded() {
		return dateTimeAdded;
	}
	public void setDateTimeAdded(String dateTimeAdded) {
		this.dateTimeAdded = dateTimeAdded;
	}
	public String getLastModified() {
		return lastModified;
	}
	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCategories() {
		return categories;
	}
	public void setCategories(String categories) {
		this.categories = categories;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString(){
		return this.id + " " + this.title + " " + this.author + " " + this.categories + " " + this.isbn;
	}
	
	


}
