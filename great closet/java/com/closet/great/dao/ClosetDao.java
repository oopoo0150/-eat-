package com.closet.great.dao;

import java.util.List;

import com.closet.great.bean.Closet;

public interface ClosetDao {

	List<Closet> getClosetList(String user);
	
	

}
