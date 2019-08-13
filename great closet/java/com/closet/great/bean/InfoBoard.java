package com.closet.great.bean;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonFormat;


@Alias("info")
public class InfoBoard {

	private int in_num;
	private String in_cate;
	private String in_title;
	private String in_content;
	//@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "Asia/Seoul")
	private Timestamp in_date;
	private int in_views;
	private int in_complain;
	private String in_sid;
	
	// 사진 파일
//	private int ini_num;
//	private String ini_sysname;
//	private String ini_oriname;
//	private int ini_innum;
//	
	
	public int getIn_num() {
		return in_num;
	}
	public void setIn_num(int in_num) {
		this.in_num = in_num;
	}
	public String getIn_cate() {
		return in_cate;
	}
	public void setIn_cate(String in_cate) {
		this.in_cate = in_cate;
	}
	public String getIn_title() {
		return in_title;
	}
	public void setIn_title(String in_title) {
		this.in_title = in_title;
	}
	public String getIn_content() {
		return in_content;
	}
	public void setIn_content(String in_content) {
		this.in_content = in_content;
	}
	public Timestamp getIn_date() {
		return in_date;
	}
	public void setIn_date(Timestamp in_date) {
		this.in_date = in_date;
	}
	public int getIn_views() {
		return in_views;
	}
	public void setIn_views(int in_views) {
		this.in_views = in_views;
	}
	public int getIn_complain() {
		return in_complain;
	}
	public void setIn_complain(int in_complain) {
		this.in_complain = in_complain;
	}
	public String getIn_sid() {
		return in_sid;
	}
	public void setIn_sid(String in_sid) {
		this.in_sid = in_sid;
	}
//	public int getIni_num() {
//		return ini_num;
//	}
//	public void setIni_num(int ini_num) {
//		this.ini_num = ini_num;
//	}
//	public String getIni_sysname() {
//		return ini_sysname;
//	}
//	public void setIni_sysname(String ini_sysname) {
//		this.ini_sysname = ini_sysname;
//	}
//	public String getIni_oriname() {
//		return ini_oriname;
//	}
//	public void setIni_oriname(String ini_oriname) {
//		this.ini_oriname = ini_oriname;
//	}
//	public int getIni_innum() {
//		return ini_innum;
//	}
//	public void setIni_innum(int ini_innum) {
//		this.ini_innum = ini_innum;
//	}

}

