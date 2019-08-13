package com.closet.great.bean;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonFormat;

//중고 상품 거래를 위한 bean
@Alias("product")
public class Product {
	private int drownum; //상품 게시글 번호
	private int db_num; //상품 게시글 고유 아이디
	private String db_title; //상품 게시글 제목
	private String db_content; //상품 게시글 내용
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "Asia/Seoul")
	private Timestamp db_date; //상품 게시글 작성 날짜
	private int db_views; //상품 게시글 조회수
	private String db_cate; //상품 게시글 말머리(거래완료, 거래중, 거래가능, 기간만료)
	private String db_sid; //상품 게시글 작성자 아이디
	private int db_price; //상품 가격
	private int db_complain; //상품 게시글 신고 수
	
	
	public int getDrownum() {
		return drownum;
	}
	public void setDrownum(int drownum) {
		this.drownum = drownum;
	}
	public int getDb_num() {
		return db_num;
	}
	public void setDb_num(int db_num) {
		this.db_num = db_num;
	}
	public String getDb_title() {
		return db_title;
	}
	public void setDb_title(String db_title) {
		this.db_title = db_title;
	}
	public String getDb_content() {
		return db_content;
	}
	public void setDb_content(String db_content) {
		this.db_content = db_content;
	}
	public Timestamp getDb_date() {
		return db_date;
	}
	public void setDb_date(Timestamp db_date) {
		this.db_date = db_date;
	}
	public int getDb_views() {
		return db_views;
	}
	public void setDb_views(int db_views) {
		this.db_views = db_views;
	}
	public String getDb_cate() {
		return db_cate;
	}
	public void setDb_cate(String db_cate) {
		this.db_cate = db_cate;
	}
	public String getDb_sid() {
		return db_sid;
	}
	public void setDb_sid(String db_sid) {
		this.db_sid = db_sid;
	}
	public int getDb_price() {
		return db_price;
	}
	public void setDb_price(int db_price) {
		this.db_price = db_price;
	}
	public int getDb_complain() {
		return db_complain;
	}
	public void setDb_complain(int db_complain) {
		this.db_complain = db_complain;
	}
}
