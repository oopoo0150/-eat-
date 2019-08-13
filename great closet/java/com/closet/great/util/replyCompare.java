package com.closet.great.util;

public class replyCompare {

	private String id;
	private String writer; // 작성자
	private String boardName;
	private String boardDelName;
	private int num;
	private int rnum;
	private String content;

	public replyCompare(String id, String writer, String boardName,String boardDelName , int num, int rnum, String content) {
		this.id = id;
		this.writer = writer;
		this.boardName = boardName;
		this.boardDelName = boardDelName;
		this.num = num; // 게시글 번호
		this.rnum = rnum; // 댓글 번호
		this.content = content;
	}


	public String makeHtmlcompare() {
		StringBuffer sb = new StringBuffer();
		if(id.equals(writer)) { // 상세 화면에 글쓴이가 들어갈 때 (수정, 삭제)
			// 수정

			//sb.append("<input type='button' onclick='editReply("+ id +")' value='수정'>"); 
			sb.append("<a class='replyUpdate' data-toggle='modal' data-num="+ num +" data-rnum="+rnum+" data-content ="+ content +" href=\"#replyUpdate\"\r\n" + 
					">수정</a>");



			/*
			sb.append("<td><input type=\"button\" id=\"updateReply\" name=\"updateReply\"\r\n" + 
					"      value=\"댓글 수정\"\r\n" + 
					"      onClick=\"updateChangeReply(27,g)\"></td>");
			sb.append("<input type='button' id='updateReply' name='updateReply' value='댓글 수정'" + 
					"onClick='updateChangeReply(27, g)'></td>");

			 */
			sb.append("<a onclick='replyDelete("+ rnum +")'>삭제</a>");

		}
		else if(id.equals("ADMIN")) { // 상세 화면에 글쓴이가 들어갈 때 (수정, 삭제)

			// 수정
			sb.append("<a class='replyUpdate' data-toggle='modal' data-inum="+ num +" data-rnum="+rnum+" data-content ="+ content +" href=\"#replyUpdate\"\r\n" + 
					">수정</a>");

			// 삭제
			sb.append("<a onclick='replyDelete("+ rnum +")'>삭제</a>");




		}
		else if(!id.equals(writer)) { // 상세 화면에 글쓴이 제외 들어갈 때
			// 신고
			sb.append("<a href='" + "info" +
					//					"?id=" + id + 
					"'>신고 화면 만들면 바꿔줘</a>");
		}


		return sb.toString();
	}
}








