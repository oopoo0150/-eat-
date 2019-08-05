package com.closet.great.bean;


import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

@Alias("suport")
public class Support {
  //고객지원 게시판 관리를 위한 bean
	private int no_num;
	private String no_title;
	private String no_content;
	private Timestamp no_date;
	private int no_views;
	private String no_cate;
	private String no_sid;
	
	public int getNo_num() {
		return no_num;
	}
	public void setNo_num(int no_num) {
		this.no_num = no_num;
	}
	public String getNo_title() {
		return no_title;
	}
	public void setNo_title(String no_title) {
		this.no_title = no_title;
	}
	public String getNo_content() {
		return no_content;
	}
	public void setNo_content(String no_content) {
		this.no_content = no_content;
	}
	public Timestamp getNo_date() {
		return no_date;
	}
	public void setNo_date(Timestamp no_date) {
		this.no_date = no_date;
	}
	public int getNo_views() {
		return no_views;
	}
	public void setNo_views(int no_views) {
		this.no_views = no_views;
	}
	public String getNo_cate() {
		return no_cate;
	}
	public void setNo_cate(String no_cate) {
		this.no_cate = no_cate;
	}
	public String getNo_sid() {
		return no_sid;
	}
	public void setNo_sid(String no_sid) {
		this.no_sid = no_sid;
	}
	
	
	
}
