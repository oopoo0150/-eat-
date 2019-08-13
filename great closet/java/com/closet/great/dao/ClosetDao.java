package com.closet.great.dao;

import java.util.List;

import com.closet.great.bean.Closet;

public interface ClosetDao {

	List<Closet> getClosetList(String user);

	boolean closetInsert(Closet closet);

	boolean closetDelete(String string);

	boolean closetUpdate(Closet closet);
	
	

}
