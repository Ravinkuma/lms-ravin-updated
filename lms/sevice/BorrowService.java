package com.lms.sevice;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.entity.BookEntity;
import com.lms.entity.BorrowEntity;
import com.lms.entity.MemberEntity;
import com.lms.exceptions.BookNotAvailableException;
import com.lms.exceptions.MemberNotReisteredException;
import com.lms.repo.BookRepo;
import com.lms.repo.BorrowRepo;
import com.lms.repo.MemberRepo;

@Service
public class BorrowService {
	@Autowired
	 
	 BorrowRepo brr;
	@Autowired
	BookRepo br;
	 public String saveBorrowingDetails(BorrowEntity borrowEntity) {
	     brr.save(borrowEntity);
	     return "Borrowing Details saved successfully";
	 }
	 public List<BorrowEntity> retrieveBorrowed() {
			
			return brr.findAll();
		}
		public BorrowEntity retrieveOneBorrowedDetails(int id) {
			
			return brr.findById(id).get();
		}
		
		public BorrowEntity updateBorrowedDetails(int id, BorrowEntity borrowEntity) {
	        BorrowEntity bre1 = brr.findById(id).get();
	        bre1.setBookId(borrowEntity.getBookId());
	        bre1.setMemberId(borrowEntity.getMemberId());

	        return brr.save(bre1);
	    }
		
		public String delete(int id) {
			brr.deleteById(id);
			return "Borrowed with Id "+ id+ " is removed from table";
		}
		
		public String borrowBook(Integer bookId, Integer memberId) {
			// check book is available
			Optional<BookEntity> b=br.findById(bookId);
			if(b.isEmpty()) {
				throw new BookNotAvailableException("book with book id "+bookId+" is not available");
			}
			//borrow a book
			BorrowEntity be = new BorrowEntity();
			be.setBookId(bookId);
			be.setMemberId(memberId);
			be.setBorrowDate(new Date());
			brr.save(be);
			// update book quantity
			int quantityUpdated = brr.updateBookQuantity(bookId);
			if(quantityUpdated>0) {
			return "Book borrowed successfully";
			} else {
				return "Book could not borrowed";
			}
		}
}
