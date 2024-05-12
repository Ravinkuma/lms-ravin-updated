package com.lms.sevice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.entity.BookEntity;
import com.lms.repo.BookRepo;

@Service
public class BookService {
  @Autowired
   BookRepo br; 
  //create
  
  /*
   public  BookEntity createBook(BookEntity book) {
        return br.save(book);
    }
    */
  public String saveBook(BookEntity bookEntity) {
      br.save(bookEntity);
      return "Book's infirmations saved successfully";
  }
  
  public List<BookEntity> retrieveBooks() {
		
		return br.findAll();
	}
	public BookEntity retrieveOneBook(int id) {
		
		return br.findById(id).get();
	}
	
	public String delete(int id) {
		br.deleteById(id);
		return "Book with BookId "+ id+ " is removed from table";
	}
	
	public BookEntity updateBook(int id, BookEntity bookEntity) {
        BookEntity b1 = br.findById(id).get();
        b1.setAuthor(bookEntity.getAuthor());
        b1.setQuantity(bookEntity.getQuantity());

        return br.save(b1);
    }
    
}
