package com.closet.test2.util;

public class replyCompare {
	
	private String id;
	private String writer; // 작성자
	private String boardName;
	private String boardDelName;
	private int num;
	private int rnum;
	
	public replyCompare(String id, String writer, String boardName,String boardDelName , int num, int rnum) {
		this.id = id;
		this.writer = writer;
		this.boardName = boardName;
		this.boardDelName = boardDelName;
		this.num = num;
		this.rnum = rnum;
	}
	
	
	public String makeHtmlcompare() {
		StringBuffer sb = new StringBuffer();
		if(id.equals(writer)) { // 상세 화면에 글쓴이가 들어갈 때 (수정, 삭제)
			// 수정
			sb.append("<input type='button' onclick='fn_editReply('"+ id +"')' value='수정'>");
			
			// 삭제
			//sb.append("<input type=\"button\" onclick=\"replyDelete(${info.in_num})\" value=\"write\"><br>");
			sb.append("<input type='button' onclick='replyDelete("+ rnum +")' value='삭제'>");
		}
		else if(id.equals("ADMIN")) { // 상세 화면에 글쓴이가 들어갈 때 (수정, 삭제)
			
			// 수정
			sb.append("<a href='" + boardName +
					"?num=" + num +
					"'>수정</a>");
			
			// 삭제
			sb.append("<a href='" + boardDelName +
					"?num=" + num +
					"'>삭제</a>");
			
			
			

			
		}
		else if(!id.equals(writer)) { // 상세 화면에 글쓴이 제외 들어갈 때
			// 신고
			sb.append("<a href='" + "info" +
//					"?id=" + id + 
					"'>신고 화면 만들면 바꿔줘</a>");
		}
		
		
		return sb.toString();
	}

//	public String makeHtmlpaging() {
//		//전체 페이지 갯수
//		int totalPage = (maxNum % listCount > 0) 
//				? maxNum / listCount + 1 : maxNum / listCount;
//		//전체 페이지 그룹 갯수
//		int totalGroup = (totalPage % pageCount > 0)
//				? totalPage / pageCount + 1 : totalPage / pageCount;
//		//현재 페이지가 속해 있는 그룹 번호
//		int curGroup = (pageNum % pageCount > 0)
//				? pageNum / pageCount + 1 : pageNum / pageCount;
//		
//		return makeHtml(curGroup, totalPage);
//	}
//
//	private String makeHtml(int curGroup, int totalPage) {
//		StringBuffer sb = new StringBuffer();
//		
//		//현재 그룹의 시작  페이지 번호
//		int start = (curGroup * pageCount) 
//				- (pageCount - 1);
//		//현재 그룹의 끝 페이지 번호
//		int end = (curGroup * pageCount >= totalPage)
//				? totalPage : curGroup * pageCount;
//		//이전 그룹으로 이동
//		if(start != 1) {
//			sb.append("<a href='" + boardName 
//					+ "?pageNum=" + (start - 1) + "'>");
//			sb.append("[이전]</a>");
//		}
//		//페이지 번호들에 대한 처리
//		for(int i = start; i <= end; i++) {
//			if(pageNum != i) {//현재 페이지가 아니면 링크 설정
//				sb.append("<a href='" + boardName 
//						+ "?pageNum=" + i + "'>");
//				sb.append(" [ " + i + " ]</a>");
//			}
//			else {
//				sb.append("<font style='color:red;'>");
//				sb.append(" [ " + i + " ]</font>");
//			}
//		}
//		//다음 그룹으로 이동
//		if(end != totalPage) {
//			sb.append("<a href='" + boardName 
//					+ "?pageNum=" + (end + 1) + "'>");
//			sb.append("[다음]</a>");
//		}
//		
//		return sb.toString();
}






