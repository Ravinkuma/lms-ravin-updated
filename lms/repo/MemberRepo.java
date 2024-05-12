package com.lms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lms.entity.MemberEntity;

import jakarta.transaction.Transactional;
@Repository
public interface MemberRepo extends JpaRepository<MemberEntity, Integer> {
@Transactional
@Modifying
// I DID NOT PUT ID IN QUERY PUTED ON END PONIT AND WORKING FINE 
@Query(value="update book set quantity=quantity-1", nativeQuery=true)
	int updateBookQuantity(Integer Id);

}
