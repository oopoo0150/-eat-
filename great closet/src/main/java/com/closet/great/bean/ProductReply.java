package com.closet.great.bean;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

//중고 거래 댓글 bean
@Alias("productReply")
public class ProductReply {
	private int dbr_no; //중고 게시글 댓글 번호
	private String dbr_content; //중고 게시글 댓글 내용
	private Timestamp dbr_date; //중고 게시글 댓글작성 날짜
	private int dbr_complain; //중고 게시글 신고 수
	private int dbr_sbno; //중고 게시글 번호
	private String dbr_sid; //중고 게시글 댓글 작성자 아이디
	
	public int getDbr_no() {
		return dbr_no;
	}
	public void setDbr_no(int dbr_no) {
		this.dbr_no = dbr_no;
	}
	public String getDbr_content() {
		return dbr_content;
	}
	public void setDbr_content(String dbr_content) {
		this.dbr_content = dbr_content;
	}
	public Timestamp getDbr_date() {
		return dbr_date;
	}
	public void setDbr_date(Timestamp dbr_date) {
		this.dbr_date = dbr_date;
	}
	public int getDbr_complain() {
		return dbr_complain;
	}
	public void setDbr_complain(int dbr_complain) {
		this.dbr_complain = dbr_complain;
	}
	public int getDbr_sbno() {
		return dbr_sbno;
	}
	public void setDbr_sbno(int dbr_sbno) {
		this.dbr_sbno = dbr_sbno;
	}
	public String getDbr_sid() {
		return dbr_sid;
	}
	public void setDbr_sid(String dbr_sid) {
		this.dbr_sid = dbr_sid;
	}
}
