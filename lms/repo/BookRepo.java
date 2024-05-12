package com.lms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.entity.BookEntity;

@Repository
public interface BookRepo extends JpaRepository<BookEntity, Integer> {

}
