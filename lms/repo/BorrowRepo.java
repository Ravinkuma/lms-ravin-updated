package com.lms.repo;

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
	// I DID NOT PUT ID IN QUERY PUTED ON END PONIT AND WORKING FINE 
	@Query(value="update book set quantity=quantity-1", nativeQuery=true)
		int updateBookQuantity1(Integer memberId);
@Query(value="update book set quantity= quantity+1", nativeQuery=true)
int increaseBookQuantity(Integer bookId);


}
