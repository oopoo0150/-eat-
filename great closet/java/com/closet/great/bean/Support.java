package com.closet.great.bean;


import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonFormat;

@Alias("support")
public class Support {
  //고객지원 게시판 관리를 위한 bean(SPLIST_1을 기준)
	private int spnum;
	private String sptitle;
	private String spcontent;
	@JsonFormat(pattern = "yyyymmdd")
	private Timestamp spdate;
	private int spviews;
	private String spcate;
	private String spsid;
	
	public int getSpnum() {
		return spnum;
	}
	public void setSpnum(int spnum) {
		this.spnum = spnum;
	}
	public String getSptitle() {
		return sptitle;
	}
	public void setSptitle(String sptitle) {
		this.sptitle = sptitle;
	}
	public String getSpcontent() {
		return spcontent;
	}
	public void setSpcontent(String spcontent) {
		this.spcontent = spcontent;
	}
	public Timestamp getSpdate() {
		return spdate;
	}
	public void setSpdate(Timestamp spdate) {
		this.spdate = spdate;
	}
	public int getSpviews() {
		return spviews;
	}
	public void setSpviews(int spviews) {
		this.spviews = spviews;
	}
	public String getSpcate() {
		return spcate;
	}
	public void setSpcate(String spcate) {
		this.spcate = spcate;
	}
	public String getSpsid() {
		return spsid;
	}
	public void setSpsid(String spsid) {
		this.spsid = spsid;
	}
	
	
	

	
	
}
