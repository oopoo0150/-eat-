package com.closet.great;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.closet.great.service.MPSaleManagement;

@Controller
public class MPSaleController {
	
	ModelAndView mav;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	MPSaleManagement salem;
	
	@RequestMapping(value = "/saleList")
	public ModelAndView SaleList(String id, Integer pageNum, String cate) {
			
		String cid = session.getAttribute("id").toString();
		mav = salem.SaleList(cid, pageNum, cate); 
		
		return mav;
	}
	//선택값 삭제
		@RequestMapping(value = "/checkedItemDel", method = RequestMethod.POST)
		public boolean saleListDel(@RequestBody List<String> list) {		
			boolean result = false;		
		result = salem.saleListDel(list);	
			
			return result;
			
		}
		
	}

