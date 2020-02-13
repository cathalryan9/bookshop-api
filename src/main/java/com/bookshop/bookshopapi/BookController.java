package com.bookshop.bookshopapi;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.bookshop.bookshopapi.Book;

@RestController
public class BookController {
	static Book book1 = new Book("1", "Unlocking Android", "W. Frank Ableson, Charlie Collins, Robi Sen",
			"Open Source, Mobile", "1933988673");
	static Book book2 = new Book("2", "Android in Action, Second Edition", "W. Frank Ableson, Robi Sen", "Java", "1935182722");
	static ArrayList<Book> arrList = new ArrayList<Book>();

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot";
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/books{admin}")
	public String getBooks(@RequestParam boolean admin) {

		try {
			//Add first few books 
			if (arrList.size() == 0) {
				arrList.add(book1);
				arrList.add(book2);
			}
			
			JSONArray bookJsonArr = new JSONArray();
			for (Book book : arrList) {
				JSONObject JSONObj = new JSONObject();
				JSONObj.put("title", book.getTitle());
				JSONObj.put("author", book.getAuthor());
				JSONObj.put("isbn", book.getIsbn());
				JSONObj.put("id", book.getId());
				JSONObj.put("categories", book.getCategories());
				//check user role for additional fields
				if (admin) {
					JSONObj.put("lastModified", book.getLastModified());
					JSONObj.put("dateTimeAdded", book.getDateTimeAdded());
				}
				bookJsonArr.put(JSONObj);
			}
			return bookJsonArr.toString();
		} catch (Exception e) {
			return "Problem retreiving books";
		}
	}
	
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/books/{id}{admin}")
	public String getBook(@PathVariable String id, @RequestParam boolean admin) {
		try {
			//Add first few books on first request 
			if (arrList.size() == 0) {
				arrList.add(book1);
				arrList.add(book2);
			}

		for(Book book : arrList) {
			if(book.getId().equals(id)) {
				System.out.println("make json");
				JSONObject JSONObj = new JSONObject();
				JSONObj.put("title", book.getTitle());
				JSONObj.put("author", book.getAuthor());
				JSONObj.put("isbn", book.getIsbn());
				JSONObj.put("id", book.getId());
				JSONObj.put("categories", book.getCategories());
				//check user role for additional fields
				if (admin) {
					JSONObj.put("lastModified", book.getLastModified());
					JSONObj.put("dateTimeAdded", book.getDateTimeAdded());
				}
				return JSONObj.toString();
				
			}
		}
		}
		catch(Exception e) {
			return "Error retrieving book";
		}
		
		
		return "Book with id " + id + " not found";
		
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/books{admin}")
	public String postBooks(@RequestParam boolean admin, @RequestBody Book book) {
		try {
		System.out.println(book.toString());
		if (admin) {
			book.setLastModified(LocalDateTime.now().toString());
			book.setDateTimeAdded(LocalDateTime.now().toString());
			arrList.add(book);
		}
		return "Book has been added";
		}
		catch(Exception e) {
			return "Problem adding book";
		}
	}

}
