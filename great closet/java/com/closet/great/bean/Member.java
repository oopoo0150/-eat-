package com.closet.great.bean;

import java.security.Timestamp;

import org.apache.ibatis.type.Alias;

@Alias("member")
public class Member {
	private String sid;         //-> 회원 아이디
	private String sname;       //-> 회원 실명이름
	private String snick;       //-> 회원 닉네임
	private String spass;       //-> 회원 비밀번호
	private String smail;       //-> 회원 메일
	private Timestamp sbirth;   	    //-> 회원 생년월일
	private String ssysname;    //-> 회원 사진 저장파일 이름
	private String soriname;    //-> 회원 실제 이름
	private int scomplain;    	//-> 회원 신고 횟수
	private String snotify;  	//-> 회원 제재여부 (제재가 되었나 안되었나 확인)
	
	//getter and setter
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSnick() {
		return snick;
	}
	public void setSnick(String snick) {
		this.snick = snick;
	}
	public String getSpass() {
		return spass;
	}
	public void setSpass(String spass) {
		this.spass = spass;
	}
	public String getSmail() {
		return smail;
	}
	public void setSmail(String smail) {
		this.smail = smail;
	}
	public Timestamp getSbirth() {
		return sbirth;
	}
	public void setSbirth(Timestamp sbirth) {
		this.sbirth = sbirth;
	}
	public String getSsysname() {
		return ssysname;
	}
	public void setSsysname(String ssysname) {
		this.ssysname = ssysname;
	}
	public String getSoriname() {
		return soriname;
	}
	public void setSoriname(String soriname) {
		this.soriname = soriname;
	}
	public int getScomplain() {
		return scomplain;
	}
	public void setScomplain(int scomplain) {
		this.scomplain = scomplain;
	}
	public String getSnotify() {
		return snotify;
	}
	public void setSnotify(String snotify) {
		this.snotify = snotify;
	}
	
	
}


