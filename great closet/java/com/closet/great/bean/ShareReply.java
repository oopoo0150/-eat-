package com.closet.great.bean;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonFormat;


@Alias("shareReply")
public class ShareReply {
	private int sbr_num;
	private String sbr_content;
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "Asia/Seoul")
	private Timestamp sbr_date;
	private int sbr_complain;
	private int sbr_sbnum;
	private String sbr_sid;
	private String compare;
	
	public String getCompare() {
		return compare;
	}
	public void setCompare(String compare) {
		this.compare = compare;
	}
	public int getSbr_num() {
		return sbr_num;
	}
	public void setSbr_num(int sbr_num) {
		this.sbr_num = sbr_num;
	}
	public String getSbr_content() {
		return sbr_content;
	}
	public void setSbr_content(String sbr_content) {
		this.sbr_content = sbr_content;
	}
	public Timestamp getSbr_date() {
		return sbr_date;
	}
	public void setSbr_date(Timestamp sbr_date) {
		this.sbr_date = sbr_date;
	}
	public int getSbr_complain() {
		return sbr_complain;
	}
	public void setSbr_complain(int sbr_complain) {
		this.sbr_complain = sbr_complain;
	}
	public int getSbr_sbnum() {
		return sbr_sbnum;
	}
	public void setSbr_sbnum(int sbr_sbnum) {
		this.sbr_sbnum = sbr_sbnum;
	}
	public String getSbr_sid() {
		return sbr_sid;
	}
	public void setSbr_sid(String sbr_sid) {
		this.sbr_sid = sbr_sid;
	}
	
}
