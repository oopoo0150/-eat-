package com.closet.great.bean;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

//중고 상품 거래를 위한 bean
@Alias("product")
public class Product {
	private int dbnum;
	private String dbtitle;
	private String dbcontent;
	private Timestamp dbdate;
	private int dbviews;
	private String dbcate;
	private String dbsid;
	private int dbprice;
	private int dbcomplain;
	public int getDbnum() {
		return dbnum;
	}
	public void setDbnum(int dbnum) {
		this.dbnum = dbnum;
	}
	public String getDbtitle() {
		return dbtitle;
	}
	public void setDbtitle(String dbtitle) {
		this.dbtitle = dbtitle;
	}
	public String getDbcontent() {
		return dbcontent;
	}
	public void setDbcontent(String dbcontent) {
		this.dbcontent = dbcontent;
	}
	public Timestamp getDbdate() {
		return dbdate;
	}
	public void setDbdate(Timestamp dbdate) {
		this.dbdate = dbdate;
	}
	public int getDbviews() {
		return dbviews;
	}
	public void setDbviews(int dbviews) {
		this.dbviews = dbviews;
	}
	public String getDbcate() {
		return dbcate;
	}
	public void setDbcate(String dbcate) {
		this.dbcate = dbcate;
	}
	public String getDbsid() {
		return dbsid;
	}
	public void setDbsid(String dbsid) {
		this.dbsid = dbsid;
	}
	public int getDbprice() {
		return dbprice;
	}
	public void setDbprice(int dbprice) {
		this.dbprice = dbprice;
	}
	public int getDbcomplain() {
		return dbcomplain;
	}
	public void setDbcomplain(int dbcomplain) {
		this.dbcomplain = dbcomplain;
	}
	
}
