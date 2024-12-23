package com.api.book.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.dao.BookRepository;
import com.api.book.entities.Book;

@Component
public class BookService {

//	private static List<Book> list= new ArrayList<>();
//	
//	static {
//		list.add(new Book(100,"Java core","ABC"));
//		list.add(new Book(200,"Java OOPs","LMN"));
//		list.add(new Book(300,"Java Spring","PQR"));
//	}
	
	@Autowired
	private BookRepository bookRepository;
	
	//get all books
	public List<Book> getAllBooks(){
		List<Book> list=(List<Book>) this.bookRepository.findAll();
		return list;
	}
	
	
	//get single book by id
	public Book getBookById(int id) {
		
		Book book=null;
		try {
//			book =list.stream().filter(e->e.getId()==id).findFirst().get();
			book=this.bookRepository.findById(id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	
	//adding the book
	public Book addBook(Book b) {
//		list.add(b);
//		return b;
		
		Book result=bookRepository.save(b);
		return result;
	}
	
	//Delete book by id
	public void deleteBook(int id) {

//		list =list.stream().filter(book->book.getId()!=id).collect(Collectors.toList());
		bookRepository.deleteById(id);
		
	}
	
	//Update book by id
	public void updateBook(Book book, int id) {
		
//		list =list.stream().map(e->{
//			if(e.getId()==id) {
//				e.setTitle(book.getTitle());
//				e.setAuthor(book.getAuthor());
//			}
//			return e;
//		}).collect(Collectors.toList());
		
		book.setId(id);
		bookRepository.save(book);
	}
}
