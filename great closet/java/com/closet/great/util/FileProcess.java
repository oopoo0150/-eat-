package com.closet.great.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.*;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.closet.great.dao.ProductDao;

@Component
public class FileProcess {

	@Autowired
	private ProductDao pDao; //첨부 파일의 정보를 저장하기 위해서 사용

	public boolean upFile(MultipartHttpServletRequest multi, int db_num) {
		//파일 저장할 절대 경로
		String root = multi.getSession().getServletContext().getRealPath("/");
		String path = root + "resources/files/";
		
		//폴더 생성
		File dir = new File(path);
		if(!dir.isDirectory()) {
			dir.mkdir();
		}
		
		//파일 2개 이상
		Iterator<String> pfiles = multi.getFileNames();
		
		Map<String, String> pfMap = new HashMap<String, String>();
		
		//글번호를 map에 저장
		pfMap.put("db_num", String.valueOf(db_num));
		
		boolean f = false;
		
		//여러개 파일 반복
		while(pfiles.hasNext()) {
			String fileName = pfiles.next();
			
			MultipartFile mf = multi.getFile(fileName);
			//원래 이름
			String dbi_oriName = mf.getOriginalFilename();
			pfMap.put("dbi_oriName", dbi_oriName);
			
			//실제 저장 이름 생성
			String dbi_sysName = System.currentTimeMillis() + dbi_oriName.substring(dbi_oriName.lastIndexOf("."));			
			pfMap.put("dbi_sysName", dbi_sysName);
			
			try {
				mf.transferTo(new File(path + dbi_sysName));
				//파일 데이터 저장
				f = pDao.fileInsert(pfMap);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		return f;
	}

	public void downFileP(String path, String dbi_oriName, HttpServletResponse resp) throws Exception{
		//한글 깨짐 방지
		String downFileP = URLEncoder.encode(dbi_oriName, "UTF-8");
		
		File file = new File(path);
		
		InputStream is = new FileInputStream(file);
		resp.setContentType("application/octet-stream");
		resp.setHeader("content-Disposition", "attachment; file=\"" + downFileP + "\"");
		
		OutputStream os = resp.getOutputStream();
		
		//바이트 단위로 출력
		byte[] buffer = new byte[1024];
		int length;
		while((length = is.read(buffer)) != -1) {
			os.write(buffer, 0, length);
		}
		os.flush();
		os.close();
		is.close();		
	}

//	public Map<String, String> upFile(MultipartHttpServletRequest multi) {
//		//저장할 절대 경로 구하기
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
//		//fMap.put("db_num", String.valueOf(db_num));
//		
//		//boolean f = false;
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
//				//f = pDao.fileInsert(fMap);
//			} catch (IOException e) {
//					e.printStackTrace();
//			}
//			
//		}
//		
//		return fMap;
//	}

//	public void downFile(String path, String oriFileName, HttpServletResponse resp) throws Exception{
//		//한글 깨짐 방지
//		String downFiel = URLEncoder.encode(oriFileName, "UTF-8");
//		
//		File file = new File(path);
//		
//		InputStream is = new FileInputStream(file);
//		resp.setContentType("application/octet-stream");
//		resp.setHeader("content-Disposition", "attachment; filename=\""+downFiel+"\"");
//		
//		OutputStream os = resp.getOutputStream();
//		//출력은 byte타입
//		byte[] buffer = new byte[1024];
//		int length;
//		while ((length = is.read(buffer)) != -1) {
//			os.write(buffer,0,length);
//		}
//		os.flush();
//		os.close();
//		is.close();
//	}	
}




