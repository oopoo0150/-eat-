package com.closet.great.bean;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonFormat;

//중고 거래 댓글 bean
@Alias("productReply")
public class ProductReply {
	private int dbr_num; //중고 게시글 댓글 번호
	private String dbr_content; //중고 게시글 댓글 내용
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "Asia/Seoul")
	private Timestamp dbr_date; //중고 게시글 댓글작성 날짜
	private int dbr_complain; //중고 게시글 댓글 신고 수
	private int dbr_dbnum; //중고 게시글 번호
	private String dbr_sid; //중고 게시글 댓글 작성자 아이디
	
	public int getDbr_num() {
		return dbr_num;
	}
	public void setDbr_num(int dbr_num) {
		this.dbr_num = dbr_num;
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
	public int getDbr_dbnum() {
		return dbr_dbnum;
	}
	public void setDbr_dbnum(int dbr_dbnum) {
		this.dbr_dbnum = dbr_dbnum;
	}
	public String getDbr_sid() {
		return dbr_sid;
	}
	public void setDbr_sid(String dbr_sid) {
		this.dbr_sid = dbr_sid;
	}
	
}
