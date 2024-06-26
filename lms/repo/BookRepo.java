package com.lms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lms.entity.BookEntity;

import jakarta.transaction.Transactional;

@Repository
public interface BookRepo extends JpaRepository<BookEntity, Integer> {
	@Transactional
	@Modifying
       @Query(value="update Book set quantity=quantity-1 where id=:bookId", nativeQuery=true)
	   int updateBookQuantity(Integer bookId);

@Transactional
@Modifying
@Query(value="update book set quantity=quantity+1 where id=:bookId", nativeQuery=true)
	void updateBookQuantity2(Integer bookId);

     
	
	

        
        

}
