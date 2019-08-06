package com.closet.great.bean;

import org.apache.ibatis.type.Alias;

@Alias("closet")
public class Closet {
	private int c_num;
	private String c_name;
	private boolean c_open;
	private String c_sid;
	
	public int getC_num() {
		return c_num;
	}
	public void setC_num(int c_num) {
		this.c_num = c_num;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public boolean isC_open() {
		return c_open;
	}
	public void setC_open(boolean c_open) {
		this.c_open = c_open;
	}
	public String getC_sid() {
		return c_sid;
	}
	public void setC_sid(String c_sid) {
		this.c_sid = c_sid;
	}
	
	
	
}
