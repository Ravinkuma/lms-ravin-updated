package com.lms.sevice;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.entity.MemberEntity;
import com.lms.repo.MemberRepo;

@Service
public class MemberService {
 @Autowired
 
 MemberRepo mr;
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
	
	//public MemberEntity updateMember(int id, MemberEntity memberEntity) {
      //  MemberEntity m1 = mr.findById(id).get();
       // m1.setName(memberEntity.getName());
       // m1.setMemberId(memberEntity.getMemberId());

       // return mr.save(m1);
    //}
	
	public String delete(int id) {
		mr.deleteById(id);
		return "Member with Id "+ id+ " is removed from table";
	}
	

	
}
