//package com.closet.great.util;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.net.URLEncoder;
//import java.util.*;
//
//import javax.servlet.http.HttpServletResponse;
//import javax.websocket.MessageHandler.Whole;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.MultipartHttpServletRequest;
//
////import com.closet.great.dao.MemberDao;
//
//@Component
//public class FileProcess {
//
//	@Autowired
//	//private MemberDao bDao;//파일 정보 저장을 위래 사용
//
//	public boolean upFile(MultipartHttpServletRequest multi, int bnum) {
//		String root = multi.getSession().getServletContext().getRealPath("/");
//		String path = root + "resources/files/";
//		
//		//폴더 생성
//		File dir = new File(path);
//		if (!dir.isDirectory()) {
//			dir.mkdir();
//		}
//		
//		// 파일이 2개 이상일때
//		Iterator<String> files = multi.getFileNames();
//		
//		Map<String, String> fMap = new HashMap<String, String>();
//		
//		//글번호를 map에 저장
//		fMap.put("bnum", String.valueOf(bnum));
//		
//		boolean f = false;
//		
//		//파일을 여러개 처리해야 하기때문에 반복
//		while(files.hasNext()) {
//			String fileName = files.next();
//			
//			MultipartFile mf = 	multi.getFile(fileName);
//			//원래 파일 이름
//			String oriName = mf.getOriginalFilename();
//			fMap.put("oriFileName", oriName);
//			//실제 저장할 파일 이름 생성
//			String sysName = System.currentTimeMillis()+oriName.substring(oriName.lastIndexOf("."));
//			fMap.put("sysFileName", sysName);
//			
//			try {
//				//파일업로드
//				mf.transferTo(new File(path + sysName));
//				//파일저장
//				//f = bDao.fileInsert(fMap);
//			} catch (IOException e) {
//					e.printStackTrace();
//			}
//			
//		}
//		
//		return false;
//	}
//
//	public void downFile(String path, String oriFileName, HttpServletResponse resp) throws Exception{
//		//한글 깨짐 방지
//		String downFiel = URLEncoder.encode(oriFileName, "UTF-8");
//		
//		File file = new File(path);
//		
//		InputStream is = new FileInputStream(file);
//		resp.setContentType("application/octet-stream");
//		resp.setHeader("content-Disposition", "attachment; filename=\""+downFiel+"\"");
//		OutputStream os = resp.getOutputStream();
//		//출력은 byte타입
//		byte[] buffer = new byte[1024];
//		int length;
//		while ((length = is.read(buffer)) != -1) {
//			os.write(buffer,0,length);
//		}
//		
//		os.flush();
//		os.close();
//		is.close();
//	}
//	
//	
//}
//
//
//
//
//
//
//
//
//
//
//
