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

}
