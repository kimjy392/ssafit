package com.ssafy.edu.vue.dto;

import java.io.Serializable;

public class Member implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3271507863636163756L;

	private int memberid;
	private String email;
	private String password;
	private String name;
	
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Member(int memberid, String email, String password, String name) {
		super();
		this.memberid = memberid;
		this.email = email;
		this.password = password;
		this.name = name;
	}


	public Member(int memberid, String email, String name) {
		super();
		this.memberid = memberid;
		this.email = email;
		this.name = name;
	}


	public Member(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}


	public int getMemberid() {
		return memberid;
	}


	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Member [memberid=" + memberid + ", email=" + email + ", password=" + password + ", name=" + name + "]";
	}


	

}
