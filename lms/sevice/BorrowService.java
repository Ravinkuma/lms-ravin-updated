package com.lms.sevice;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.entity.BookEntity;
import com.lms.entity.BorrowEntity;
import com.lms.exceptions.BookNotAvailableException;
import com.lms.exception2.MemberNotRegisteredException;
import com.lms.repo.BookRepo;
import com.lms.repo.BorrowRepo;

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
			int quantityUpdated = br.updateBookQuantity(bookId);
			if(quantityUpdated>0) {
			return "Book borrowed successfully";
			} else {
				return "Book could not borrowed";
			}
		}
		public String findMember(Integer bookId, Integer Id ) {
			// check member is registered or not 
			Optional<BorrowEntity> be=brr.findById(Id);
			if(be.isEmpty()) {
				throw new com.lms.exception2.MemberNotRegisteredException("member with Id "+Id+" not registerd");
			}
			BorrowEntity bee = new BorrowEntity();
			bee.setBookId(bookId);
			bee.setBorrowDate(new Date());
			//bee.setMemberId(memberId);
			brr.save(bee);
			// update book quantity
			int quantityUpdated = brr.updateBookQuantity(bookId);
			if(quantityUpdated>0) {
			return "Book borrowed successfully";
			} else {
				return "Book could not borrowed";
			}
		}

		public String returnBook(Integer bookId, Integer memberId) {
			BorrowEntity bee = new BorrowEntity();
			bee.setBookId(bookId);
			bee.setBorrowDate(new Date());
			bee.setReturnDate(new Date());
			bee.setMemberId(memberId);
			brr.save(bee);
			// check book is issued by librarian or not
			int bookCount=brr.checkBookWasBorrowed(bookId,memberId);
			if(bookCount>0) {
				//update return date 
				brr.updateReturnDate(bookId, memberId);
				//update book table 
				br.updateBookQuantity2(bookId);
				return "book with bookId "+bookId+ " returned by member with memberId "+memberId; 
			} else {
			     return "book with bookId "+bookId+" not borrowed by member "+memberId;
			}
		}
		
		}


