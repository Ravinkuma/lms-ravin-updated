package com.lms.repo;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lms.entity.BorrowEntity;
import jakarta.transaction.Transactional;

@Repository
public interface BorrowRepo extends JpaRepository<BorrowEntity, Integer> {
	@Transactional
	@Modifying
       @Query(value="update Book set quantity=quantity-1 where id=:bookId", nativeQuery=true)
	   int updateBookQuantity(Integer bookId);
	//@Transactional
	//@Modifying
    //@Query(value="select count(id) from borrowing where id=:bookId and member_id=:memberId", nativeQuery=true)
	//int checkBookWasBorrowed(Integer bookId, Integer memberId);
	//@Transactional
	//@Modifying
	@Query(value="select count(id) from borrowing where id=:bookId and member_id=:memberId", nativeQuery=true)
	 int checkBookWasBorrowed(Integer bookId, Integer memberId);
	
	@Transactional
	@Modifying
@Query(value="update Borrowing set return_date=current_timestamp() where id=:bookId and member_id=:memberId", nativeQuery=true)
	void updateReturnDate(Integer bookId, Integer memberId);
	

	
	
        
	
	
	   


}
