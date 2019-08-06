package com.test.closet.dao;

import com.test.closet.bean.Member;

public interface MemberDao {

	int checkOverId(String s_id);

	int checkOvernick(String s_nick);

	boolean MemberInsert(Member mb);

	int checkOvermail(String s_mail);
	
}
