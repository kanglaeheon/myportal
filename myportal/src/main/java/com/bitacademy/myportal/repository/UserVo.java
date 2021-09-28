package com.bitacademy.myportal.repository;

import java.util.Date;

public class UserVo {
	private long no;	//	Primary Key
	private String name;	//	사용자 이름
	private String email;	//	사용자 Email
	private String password;	//	사용자 비밀번호
	private String gender;	//	사용자 성별
	private Date createdAt;	//	사용자 가입일
	
	//	getters/setters
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	//	toString()
	@Override
	public String toString() {
		return "UserVo [no=" + no + ", name=" + name + ", email=" + email + ", password=" + password + ", gender="
				+ gender + ", createdAt=" + createdAt + "]";
	}
	
}
