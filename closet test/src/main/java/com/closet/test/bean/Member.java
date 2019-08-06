package com.closet.test.bean;

import java.security.Timestamp;

import org.apache.ibatis.type.Alias;

@Alias("member")
public class Member {
	private String s_id;         //-> 회원 아이디
	private String s_name;       //-> 회원 실명이름
	private String s_nick;       //-> 회원 닉네임
	private String s_pass;       //-> 회원 비밀번호
	private String s_mail;       //-> 회원 메일
	private String s_birth;   	    //-> 회원 생년월일
	private String s_sysname;    //-> 회원 사진 저장파일 이름
	private String s_oriname;    //-> 회원 실제 이름
	private int s_complain;    	//-> 회원 신고 횟수
	private String s_notify;  	//-> 회원 제재여부 (제재가 되었나 안되었나 확인)
	public String getS_id() {
		return s_id;
	}
	public void setS_id(String s_id) {
		this.s_id = s_id;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getS_nick() {
		return s_nick;
	}
	public void setS_nick(String s_nick) {
		this.s_nick = s_nick;
	}
	public String getS_pass() {
		return s_pass;
	}
	public void setS_pass(String s_pass) {
		this.s_pass = s_pass;
	}
	public String getS_mail() {
		return s_mail;
	}
	public void setS_mail(String s_mail) {
		this.s_mail = s_mail;
	}
	public String getS_birth() {
		return s_birth;
	}
	public void setS_birth(String s_birth) {
		this.s_birth = s_birth;
	}
	public String getS_sysname() {
		return s_sysname;
	}
	public void setS_sysname(String s_sysname) {
		this.s_sysname = s_sysname;
	}
	public String getS_oriname() {
		return s_oriname;
	}
	public void setS_oriname(String s_oriname) {
		this.s_oriname = s_oriname;
	}
	public int getS_complain() {
		return s_complain;
	}
	public void setS_complain(int s_complain) {
		this.s_complain = s_complain;
	}
	public String getS_notify() {
		return s_notify;
	}
	public void setS_notify(String s_notify) {
		this.s_notify = s_notify;
	}
	
	//getter and setter
	
	
}


