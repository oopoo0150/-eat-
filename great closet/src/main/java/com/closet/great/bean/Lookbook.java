package com.closet.great.bean;

import java.sql.Timestamp;

public class Lookbook {
	private int lb_num;
	private String lb_filename;
	private boolean lb_cate;
	private Timestamp lb_date;
	private int lb_complain;
	private int lb_like;
	private String lb_sid;
	private int lbd_num;
	private int lbd_lbnum;
	private int lbd_cldnum;
	
	public int getLb_num() {
		return lb_num;
	}
	public void setLb_num(int lb_num) {
		this.lb_num = lb_num;
	}
	public String getLb_filename() {
		return lb_filename;
	}
	public void setLb_filename(String lb_filename) {
		this.lb_filename = lb_filename;
	}
	public boolean isLb_cate() {
		return lb_cate;
	}
	public void setLb_cate(boolean lb_cate) {
		this.lb_cate = lb_cate;
	}
	public Timestamp getLb_date() {
		return lb_date;
	}
	public void setLb_date(Timestamp lb_date) {
		this.lb_date = lb_date;
	}
	public int getLb_complain() {
		return lb_complain;
	}
	public void setLb_complain(int lb_complain) {
		this.lb_complain = lb_complain;
	}
	public int getLb_like() {
		return lb_like;
	}
	public void setLb_like(int lb_like) {
		this.lb_like = lb_like;
	}
	public String getLb_sid() {
		return lb_sid;
	}
	public void setLb_sid(String lb_sid) {
		this.lb_sid = lb_sid;
	}
	public int getLbd_num() {
		return lbd_num;
	}
	public void setLbd_num(int lbd_num) {
		this.lbd_num = lbd_num;
	}
	public int getLbd_lbnum() {
		return lbd_lbnum;
	}
	public void setLbd_lbnum(int lbd_lbnum) {
		this.lbd_lbnum = lbd_lbnum;
	}
	public int getLbd_cldnum() {
		return lbd_cldnum;
	}
	public void setLbd_cldnum(int lbd_cldnum) {
		this.lbd_cldnum = lbd_cldnum;
	}
	

}
