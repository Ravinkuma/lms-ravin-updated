package com.lms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="Member")
public class MemberEntity {

	@Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
 private int id;
	
	@Column(name = "Name")
	private String name;
	    @Column(name = "Contact")
	private String contact;
	    @Column(name = "MemberId")
	    private String memberId;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getContact() {
			return contact;
		}
		public void setContact(String contact) {
			this.contact = contact;
		}
		public String getMemberId() {
			return memberId;
		}
		public void setMemberId(String memberId) {
			this.memberId = memberId;
		}
	    
	    
}
