package com.closet.great.dao;

import com.closet.great.bean.Member;

public interface MemberDao {

	public boolean MemberInsert(Member mb);

	public int checkOverId(String s_id);

	public int checkOvernick(String s_nick);

	public int checkOvermail(String s_mail);
	
}
