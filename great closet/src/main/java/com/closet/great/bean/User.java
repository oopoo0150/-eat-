package com.closet.great.bean;

import org.apache.ibatis.type.Alias;

@Alias("user")
public class User {
	private String u_id;         //-> 회원 아이디
	private String u_name;       //-> 회원 실명이름
	private String u_nick;       //-> 회원 닉네임
	private String u_pass;       //-> 회원 비밀번호
	private String u_mail;       //-> 회원 메일
	private int u_birth;   	    //-> 회원 생년월일
	private String u_sysname;    //-> 회원 사진 저장파일 이름
	private String u_oriname;    //-> 회원 실제 이름
	
	
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_nick() {
		return u_nick;
	}
	public void setU_nick(String u_nick) {
		this.u_nick = u_nick;
	}
	public String getU_pass() {
		return u_pass;
	}
	public void setU_pass(String u_pass) {
		this.u_pass = u_pass;
	}
	public String getU_mail() {
		return u_mail;
	}
	public void setU_mail(String u_mail) {
		this.u_mail = u_mail;
	}
	public int getU_birth() {
		return u_birth;
	}
	public void setU_birth(int u_birth) {
		this.u_birth = u_birth;
	}
	public String getU_sysname() {
		return u_sysname;
	}
	public void setU_sysname(String u_sysname) {
		this.u_sysname = u_sysname;
	}
	public String getU_oriname() {
		return u_oriname;
	}
	public void setU_oriname(String u_oriname) {
		this.u_oriname = u_oriname;
	}
	
	
}
