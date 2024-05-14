package com.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.entity.MemberEntity;
import com.lms.exceptions.BookNotAvailableException;
import com.lms.exceptions.MemberNotReisteredException;
import com.lms.sevice.MemberService;

@RestController
@RequestMapping("/Member")
public class MemberController {
@Autowired

MemberService ms;
@PostMapping("/save")
public String saveMember(@RequestBody MemberEntity memberEntity) {
	return ms.saveMember(memberEntity);
}

@GetMapping("/retrieve")
List<MemberEntity> retrieveMembers(){
	return ms.retrieveMembers();
}

@GetMapping("/retrieve/{id}")
MemberEntity retrieveOneMember(@PathVariable int id){
	return ms.retrieveOneMember(id);
}

@PutMapping("/update/{id}")
public MemberEntity updateMember(@PathVariable int id, @RequestBody MemberEntity memberEntity) {
    return ms.updateMember(id, memberEntity);
}

@DeleteMapping("/delete/{id}")
String delete(@PathVariable int id){
	return ms.delete(id);
}

}
