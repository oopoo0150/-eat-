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

import com.closet.great.dao.ImgDao;


@Component
public class FileProcess {
	
	@Autowired
	private ImgDao iDao;//파일 정보 저장을 위해 사용
	
	public  Map<String, String> upFile(MultipartHttpServletRequest multi) {
		// 파일을 저장할 절대 경로 찾기
		String root = multi.getSession().getServletContext().getRealPath("/");//(resources 전 까지)
		String path = root + "resources/files/";
		
		// 폴더 생성
		File dir = new File(path);
		if(!dir.isDirectory()) {
			dir.mkdir();
		}
		
		// 파일이 2개 이상일 때
		Iterator<String> files = multi.getFileNames(); 
		
		Map<String, String> fMap = new HashMap<String, String>();
		
		// 글번호를 map에 저장
		//-----------------------------fMap.put("bnum", String.valueOf(bnum));
		
		//boolean f = false;
		
		// 파일을 여러개 처리해야 하기 때문에 반복

		
		while(files.hasNext()) {
			String fileName = files.next();
			
			MultipartFile mf = multi.getFile(fileName);
			// 원래 파일 이름
			String oriName = mf.getOriginalFilename();
			fMap.put("oriFileName", oriName);
			// a.txt
			// 실제 저장할 파일 이름 생성
			String sysName = System.currentTimeMillis() + oriName.substring(oriName.lastIndexOf("."));
			//1123234354.txt
			fMap.put("sysFileName", sysName);
			
			try {
				mf.transferTo(new File(path + sysName));
				// 파일 데이터 저장
			}catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		return fMap;
	}
	
	public HashMap<String, String> closetupFile(MultipartHttpServletRequest multi) {
		//파일을 저장할 절대 경로 찾기
		String root = multi.getSession().
				getServletContext().getRealPath("/");
		System.out.println(root);
		
		String path = root + "resources/files/";

		//폴더 생성
		File dir = new File(path);
		if(!dir.isDirectory()) {
			dir.mkdir();
		}

		//파일이 2개 이상일 때
		Iterator<String> files = multi.getFileNames();

		HashMap<String, String> fMap = new HashMap<String, String>();

		//글번호를 map에 저장

		//파일을 여러개 처리해야 하기 때문에 반복
		while(files.hasNext()) {
			String fileName = files.next();

			MultipartFile mf = multi.getFile(fileName);
			//원래 파일 이름
			String oriName = mf.getOriginalFilename();
			fMap.put("oriFileName", oriName);
			//a.txt
			//실제 저장할 파일 이름 생성
			String sysName = System.currentTimeMillis()
					+ oriName.substring
					(oriName.lastIndexOf("."));
			//1123234354.txt
			fMap.put("sysFileName", sysName);

			
			try {
				mf.transferTo(new File(path + sysName));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return fMap;

	}


}









