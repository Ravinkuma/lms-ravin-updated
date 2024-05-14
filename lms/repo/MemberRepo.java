package com.lms.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lms.entity.MemberEntity;

import jakarta.transaction.Transactional;
@Repository
public interface MemberRepo extends JpaRepository<MemberEntity, Integer> {



}
