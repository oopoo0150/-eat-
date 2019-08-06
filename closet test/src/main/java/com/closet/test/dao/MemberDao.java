package com.closet.test.dao;

import com.closet.test.bean.Member;

public interface MemberDao {

	int checkOverId(String s_id);

	int checkOvernick(String s_nick);

	boolean MemberInsert(Member mb);

	int checkOvermail(String s_mail);

	String getSecurityPwd(String s_id);

	Member getMemberInfo(String s_id);
	
}
