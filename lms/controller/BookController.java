package com.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.entity.BookEntity;
import com.lms.sevice.BookService;

@RestController
@RequestMapping("/Library")
public class BookController {

	@Autowired
	BookService bs; // dependency injection
	
	@PostMapping("/save")
	public String saveBook(@RequestBody BookEntity bookEntity) {
		return bs.saveBook(bookEntity);
  }
	
	@GetMapping("/retrieve")
    List<BookEntity> retrieveBooks(){
    	return bs.retrieveBooks();
    }
    
    @GetMapping("/retrieve/{id}")
    BookEntity retrieveOneBook(@PathVariable int id){
    	return bs.retrieveOneBook(id);
    }
    
    @DeleteMapping("/delete/{id}")
    String delete(@PathVariable int id){
    	return bs.delete(id);
    }
    
    @PutMapping("/update/{id}")
    public BookEntity updateBook(@PathVariable int id, @RequestBody BookEntity bookEntity) {
        return bs.updateBook(id, bookEntity);
    }
    
}
