package com.closet.test2.bean;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;


@Alias("share")
public class ShareBoard {
	
	private int sb_num;
	private String sb_title;
	private String sb_sysname;
	private String sb_oriname;
	private String sb_content;
	private int sb_like;
	private int sb_views;
	private Timestamp sb_date;
	private int sb_complain;
	private String sb_sid;
	
	public int getSb_num() {
		return sb_num;
	}
	public void setSb_num(int sb_num) {
		this.sb_num = sb_num;
	}
	public String getSb_title() {
		return sb_title;
	}
	public void setSb_title(String sb_title) {
		this.sb_title = sb_title;
	}
	public String getSb_sysname() {
		return sb_sysname;
	}
	public void setSb_sysname(String sb_sysname) {
		this.sb_sysname = sb_sysname;
	}
	public String getSb_oriname() {
		return sb_oriname;
	}
	public void setSb_oriname(String sb_oriname) {
		this.sb_oriname = sb_oriname;
	}
	public String getSb_content() {
		return sb_content;
	}
	public void setSb_content(String sb_content) {
		this.sb_content = sb_content;
	}
	public int getSb_like() {
		return sb_like;
	}
	public void setSb_like(int sb_like) {
		this.sb_like = sb_like;
	}
	public int getSb_views() {
		return sb_views;
	}
	public void setSb_views(int sb_views) {
		this.sb_views = sb_views;
	}
	public Timestamp getSb_date() {
		return sb_date;
	}
	public void setSb_date(Timestamp sb_date) {
		this.sb_date = sb_date;
	}
	public int getSb_complain() {
		return sb_complain;
	}
	public void setSb_complain(int sb_complain) {
		this.sb_complain = sb_complain;
	}
	public String getSb_sid() {
		return sb_sid;
	}
	public void setSb_sid(String sb_sid) {
		this.sb_sid = sb_sid;
	}

}


