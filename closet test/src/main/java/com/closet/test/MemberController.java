package com.closet.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.closet.test.bean.Member;
import com.closet.test.service.MemberManagerment;

/**
 * Servlet implementation class MemberController
 */
@Controller
public class MemberController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Autowired
    MemberManagerment mm;
    
    ModelAndView mav;
    
    //회원가입
    @RequestMapping(value = "/MemberInsert", method = RequestMethod.POST)
    public ModelAndView MemberInsert(Member mb) {
        mav = mm.MemberInsert(mb);
        
        return mav;
    }
    
    //닉네임 중복 확인 ajax
        @RequestMapping(value = "/signup/nickCheck", method = RequestMethod.GET)
        @ResponseBody
        public int nickCheck(@RequestParam("s_nick") String s_nick) {
                    
                        
            return mm.usernickCheck(s_nick);
        }

    //아이디 중복 확인 ajax
    @RequestMapping(value = "/signup/idCheck", method = RequestMethod.GET)
    @ResponseBody
    public int idCheck(@RequestParam("s_id") String s_id) {
                
                    
        return mm.userIdCheck(s_id);
    }

    //메일 중복 확인 ajax
    @RequestMapping(value = "/signup/mailCheck", method = RequestMethod.GET)
    @ResponseBody
    public int mailCheck(@RequestParam("s_mail") String s_mail) {
                
                    
        return mm.usermailCheck(s_mail);
    }

}