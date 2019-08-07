package com.closet.great.bean;

import org.apache.ibatis.type.Alias;

//중고거래 게시글 상품 이미지 저장 bean
@Alias("productImg")
public class ProductImg {
	private int dbi_no; //중고 거래 상품 이미지 번호
	private String dbi_sysname; //이미지 저장할 때 변경해서 저장하는 시스템이름
	private String dbi_oriname; //이미지 실제 이름
	private int dbi_dbno; //중고 거래 상품 게시판 번호
	
	public int getDbi_no() {
		return dbi_no;
	}
	public void setDbi_no(int dbi_no) {
		this.dbi_no = dbi_no;
	}
	public String getDbi_sysname() {
		return dbi_sysname;
	}
	public void setDbi_sysname(String dbi_sysname) {
		this.dbi_sysname = dbi_sysname;
	}
	public String getDbi_oriname() {
		return dbi_oriname;
	}
	public void setDbi_oriname(String dbi_oriname) {
		this.dbi_oriname = dbi_oriname;
	}
	public int getDbi_dbno() {
		return dbi_dbno;
	}
	public void setDbi_dbno(int dbi_dbno) {
		this.dbi_dbno = dbi_dbno;
	}
}
