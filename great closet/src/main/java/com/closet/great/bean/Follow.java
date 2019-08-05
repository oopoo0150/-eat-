package com.closet.great.bean;

public class Follow {
	//팔로우, 팔로잉을 위한 bean
	private String f_following; //내가 팔로우 하는 유저
	private String f_follower;  //나를 팔로우하는 유저 
	
	public String getF_following() {
		return f_following;
	}
	public void setF_following(String f_following) {
		this.f_following = f_following;
	}
	public String getF_follower() {
		return f_follower;
	}
	public void setF_follower(String f_follower) {
		this.f_follower = f_follower;
	}
	
	

}
