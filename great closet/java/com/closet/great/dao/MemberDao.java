package com.closet.great.dao;

import java.util.HashMap;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.closet.great.bean.Member;
import com.closet.great.bean.User;

public interface MemberDao {

	int checkOverId(String u_id);

	int checkOvernick(String u_nick);

	boolean UserInsert(User us);

	int checkOvermail(String u_mail);

	String getSecurityPwd(String s_id);

	Member getMemberInfo(String s_id);

	int checkOvermail2(String u_mail);

	int checkOverId2(String u_id);

	int checkOvernick2(String u_nick);

	boolean MemberInsert(Member mb);

	void MemberDelete(String id);

	Member Seletefindid(HashMap<String, String> map);

	Member Seletefindpass(HashMap<String, String> map);

	void updatepass(HashMap<String, String> map);
	
	
}
