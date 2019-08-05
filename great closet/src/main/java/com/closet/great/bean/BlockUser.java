package com.closet.great.bean;

import org.apache.ibatis.type.Alias;

@Alias("block")
public class BlockUser {
	//차단한 사용자 목록 출력을 위한 bean
	private int block_num;
	private String block_sid;//차단신청한 유저
	private String block_user;//차단당한 유저
	
	public int getBlock_num() {
		return block_num;
	}
	public void setBlock_num(int block_num) {
		this.block_num = block_num;
	}
	public String getBlock_sid() {
		return block_sid;
	}
	public void setBlock_sid(String block_sid) {
		this.block_sid = block_sid;
	}
	public String getBlock_user() {
		return block_user;
	}
	public void setBlock_user(String block_user) {
		this.block_user = block_user;
	}
	
	

}
