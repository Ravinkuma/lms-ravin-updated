package com.lms.sevice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.entity.MemberEntity;
import com.lms.exceptions.MemberNotReisteredException;
import com.lms.repo.BookRepo;
import com.lms.repo.MemberRepo;

@Service
public class MemberService {
 @Autowired
 
 MemberRepo mr;
 @Autowired
 BookRepo br;
 public String saveMember(MemberEntity memberEntity) {
     mr.save(memberEntity);
     return "Library member's infirmations saved successfully";
 }
 
 public List<MemberEntity> retrieveMembers() {
		
		return mr.findAll();
	}
	public MemberEntity retrieveOneMember(int id) {
		
		return mr.findById(id).get();
	}
	
	public MemberEntity updateMember(int id, MemberEntity memberEntity) {
        MemberEntity m1 = mr.findById(id).get();
        m1.setName(memberEntity.getName());
        m1.setMemberId(memberEntity.getMemberId());

        return mr.save(m1);
    }
	
	public String delete(int id) {
		mr.deleteById(id);
		return "Member with Id "+ id+ " is removed from table";
	}
	public String findMember(Integer Id, Integer bookId ) {
		// check member is registered or not 
		Optional<MemberEntity> m=mr.findById(Id);
		if(m.isEmpty()) {
			throw new MemberNotReisteredException("member with id "+Id+" is not registerd");
		}
		MemberEntity me = new MemberEntity();
		me.setContact(null);
		me.setMemberId(null);
		me.setName(null);
		mr.save(me);
		// update book quantity
		int quantityUpdated = mr.updateBookQuantity(Id);
		if(quantityUpdated>0) {
		return "Book borrowed successfully";
		} else {
			return "Book could not borrowed";
		}
	}

	
}
