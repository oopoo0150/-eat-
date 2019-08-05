package com.closet.great.bean;

import org.apache.ibatis.type.Alias;

@Alias("clothes")
public class Clothes {
	
	private	int cl_num;
	private String cl_name;
	private String cl_style;
	private int cl_cnum;
	
	public int getCl_num() {
		return cl_num;
	}
	public void setCl_num(int cl_num) {
		this.cl_num = cl_num;
	}
	public String getCl_name() {
		return cl_name;
	}
	public void setCl_name(String cl_name) {
		this.cl_name = cl_name;
	}
	public String getCl_style() {
		return cl_style;
	}
	public void setCl_style(String cl_style) {
		this.cl_style = cl_style;
	}
	public int getCl_cnum() {
		return cl_cnum;
	}
	public void setCl_cnum(int cl_cnum) {
		this.cl_cnum = cl_cnum;
	}
	
	
}
