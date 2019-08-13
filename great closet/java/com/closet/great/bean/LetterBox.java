package com.closet.great.bean;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

@Alias("letterbox")
public class LetterBox {
	private int BOX_DBNUM;
	private String BOX_TITLE;
	private int BOX_PRICE;
	private String BOX_BUYER;
	private String BOX_SELLER;
	private Date BOX_DATE;
	private int BOX_NUM;
	
	public int getBOX_DBNUM() {
		return BOX_DBNUM;
	}
	public void setBOX_DBNUM(int bOX_DBNUM) {
		BOX_DBNUM = bOX_DBNUM;
	}
	public String getBOX_TITLE() {
		return BOX_TITLE;
	}
	public void setBOX_TITLE(String bOX_TITLE) {
		BOX_TITLE = bOX_TITLE;
	}
	public int getBOX_PRICE() {
		return BOX_PRICE;
	}
	public void setBOX_PRICE(int bOX_PRICE) {
		BOX_PRICE = bOX_PRICE;
	}
	public String getBOX_BUYER() {
		return BOX_BUYER;
	}
	public void setBOX_BUYER(String bOX_BUYER) {
		BOX_BUYER = bOX_BUYER;
	}
	public String getBOX_SELLER() {
		return BOX_SELLER;
	}
	public void setBOX_SELLER(String bOX_SELLER) {
		BOX_SELLER = bOX_SELLER;
	}
	public Date getBOX_DATE() {
		return BOX_DATE;
	}
	public void setBOX_DATE(Date bOX_DATE) {
		BOX_DATE = bOX_DATE;
	}
	public int getBOX_NUM() {
		return BOX_NUM;
	}
	public void setBOX_NUM(int bOX_NUM) {
		BOX_NUM = bOX_NUM;
	}
}
