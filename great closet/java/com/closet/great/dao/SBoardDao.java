package com.closet.great.dao;

import java.util.List;

import com.closet.great.bean.ShareBoard;
import com.closet.great.bean.ShareReply;

public interface SBoardDao {

	boolean writeInsert(ShareBoard share);

	List<ShareBoard> getBoardList(int num);

	int getBoardCount(int num);

	ShareBoard getContents(Integer num);

	boolean delete(Integer num);

	boolean updateInsert(ShareBoard share);

	boolean replyInsert(ShareReply share);

	List<ShareReply> getReplyList(int num);

	void ClickBoard(Integer num);

}
