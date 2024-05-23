package com.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.entity.BorrowEntity;
import com.lms.exceptions.BookNotAvailableException;
import com.lms.exception2.BookNotIsuedException;
import com.lms.exception2.MemberNotRegisteredException;
import com.lms.sevice.BorrowService;

@RestController
@RequestMapping("/Borrowing")
public class BorrowController {

	@Autowired

	BorrowService brs;
	@PostMapping("/save")
	public String saveBorrowingDetails(@RequestBody BorrowEntity borrowEntity) {
		return brs.saveBorrowingDetails(borrowEntity);
	}
	
	@GetMapping("/retrieve")
	List<BorrowEntity> retrieveBorrrowed(){
		return brs.retrieveBorrowed();
	}

	@GetMapping("/retrieve/{id}")
	BorrowEntity retrieveOneBorrowedDetails(@PathVariable int id){
		return brs.retrieveOneBorrowedDetails(id);
	}

	@PutMapping("/update/{id}")
	public BorrowEntity updateBorrowedDetails(@PathVariable int id, @RequestBody BorrowEntity borrowEntity) {
	    return brs.updateBorrowedDetails(id, borrowEntity);
	}

	@DeleteMapping("/delete/{id}")
	String delete(@PathVariable int id){
		return brs.delete(id);
	}
	@PatchMapping("/borrow/{bookId}/{memberId}")
	ResponseEntity<Object> borrowBook(@PathVariable Integer bookId, @PathVariable Integer memberId){
		String message = "";
		try {
			message=brs.borrowBook(bookId, memberId);
		}catch(BookNotAvailableException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("book with book id "+bookId+" is not available");
		}
		return ResponseEntity.status(HttpStatus.OK).body(message);
		
	}
	@PatchMapping("/borrow2/{bookId}/{Id}")
	ResponseEntity<Object> findMember(@PathVariable Integer bookId, @PathVariable Integer Id){
		String message = "";
		try {
			message=brs.findMember(bookId, Id);
		}catch(com.lms.exception2.MemberNotRegisteredException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("member with Id "+Id+" is not registerd");
		}
		return ResponseEntity.status(HttpStatus.OK).body(message);
		
	}
	@PutMapping("/return/{bookId}/{memberId}")
	ResponseEntity<Object> returnBook(@PathVariable Integer bookId, @PathVariable Integer memberId){
		String message = "";
		try {
			message=brs.returnBook(bookId, memberId);
		}catch(com.lms.exception2.BookNotIsuedException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("book with book id "+bookId+" is not borrowed by member ");
		}
		return ResponseEntity.status(HttpStatus.OK).body(message);
		
	}
	
	}

