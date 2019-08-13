package com.closet.great;

import java.io.IOException;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.mail.MailSender;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.closet.great.bean.Member;
import com.closet.great.bean.User;
import com.closet.great.service.MemberManagerment;

/**
 * Servlet implementation class MemberController
 */

@Controller
@SessionAttributes("mb")

public class MemberController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Autowired
    MemberManagerment mm;

	@Autowired
	HttpSession sesstion;
	
    @Autowired
    private JavaMailSender mailSender;
    
    ModelAndView mav;
    
    //회원가입
    @RequestMapping(value = "/UserInsert", method = RequestMethod.POST)
    public ModelAndView UserInsert(User us, HttpServletRequest request){
     		
    		
//    		String setfrom = "oopoo0150@gmail.com";         
//            String tomail  = request.getParameter("u_mail");
//            String title   = "인증번호";      // 제목
//            String content = "hi";     // 내용
//
//            try {
//                MimeMessage message = mailSender.createMimeMessage();
//                MimeMessageHelper messageHelper 
//                = new MimeMessageHelper(message, true, "UTF-8");
//
//                messageHelper.setFrom(setfrom);  // 보내는사람 생략하거나 하면 정상작동을 안함
//                messageHelper.setTo(tomail);     // 받는사람 이메일
//                messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
//                messageHelper.setText(content);  // 메일 내용
//
//
//                mailSender.send(message);
//             } catch(Exception e){
//                System.out.println(e);
//             }


            mav = mm.UserInsert(us);
        return mav;
    }
  //회원가입
    @RequestMapping(value = "/MemberInsert", method = RequestMethod.POST)
    public ModelAndView MemberInsert(Member mb, HttpServletRequest request){

            mav = mm.MemberInsert(mb);
        return mav;
    }
    //회원 탈퇴
    @RequestMapping(value = "/signup_exit", method = RequestMethod.POST)
    public ModelAndView signup_exit(String id){
            mav = mm.MemberDelete(id);
        return mav;
    }
    
    //아이디 찾기 페이지 이동
    @RequestMapping(value = "/findid", method = RequestMethod.GET)
    public String findid(){
    	
        return "find_id";
    }
    
    //아이디 찾기
    @RequestMapping(value = "/findedID", method = RequestMethod.POST)
    public ModelAndView findided(@RequestParam("s_name") String name, @RequestParam("s_mail") String mail){
            mav = mm.findid(name, mail);
        return mav;
    }
    
    //비밀번호 찾기 페이지 이동
    @RequestMapping(value = "/findpass", method = RequestMethod.GET)
    public String findpass(){
    	
        return "find_pass";
    }
    
    //비밀번호 찾기
    @RequestMapping(value = "/findedPASS", method = RequestMethod.POST)
    public ModelAndView findpass(@RequestParam("s_name") String name, @RequestParam("s_id") String id, @RequestParam("s_mail") String mail){
            mav = mm.findpass(name, id, mail);
        return mav;
    }
    
    
    //비밀번호 업데이트
    @RequestMapping(value = "/updatepass", method = RequestMethod.POST)
    public ModelAndView updatepass(@RequestParam("s_pass") String s_pass, @RequestParam("id") String id){
            mav = mm.updatepass(s_pass, id);
        return mav;
    }
    
//    //닉네임 중복 확인 ajax
//    @RequestMapping(value = "/signup/nickCheck", method = RequestMethod.GET)
//    @ResponseBody
//    public int nickCheck(@RequestParam("u_nick") String u_nick) {
//        int r = 0;
//        r = mm.usernickCheck(u_nick); 
//        return r;
//    }
    
    //닉네임 중복 확인 ajax
    @RequestMapping(value = "/signup2/nickCheck", method = RequestMethod.GET)
    @ResponseBody
    public int nickCheck2(@RequestParam("s_nick") String s_nick) {
        int r = 0;
        r = mm.usernickCheck(s_nick); 
        return r;
    }

//    //아이디 중복 확인 ajax
//    @RequestMapping(value = "/signup/idCheck", method = RequestMethod.GET)
//    @ResponseBody
//    public int idCheck(@RequestParam("u_id") String u_id) {
//        int r = 0;
//        r = mm.userIdCheck(u_id);   
//                    
//        return r;
//    }
    
    //아이디 중복 확인 ajax
    @RequestMapping(value = "/signup2/idCheck", method = RequestMethod.GET)
    @ResponseBody
    public int idCheck2(@RequestParam("s_id") String s_id) {
        int r = 0;
        r = mm.userIdCheck(s_id);   
                    
        return r;
    }

    //메일 중복 확인 ajax
    @RequestMapping(value = "/signup2/mailCheck", method = RequestMethod.GET)
    @ResponseBody
    public int mailCheck(@RequestParam("s_mail") String s_mail) {
        int r = 0;
    	r = mm.usermailCheck(s_mail);
    	
        return r;
    }
    

	 //로그인 	
   @RequestMapping(value = "/login_Access", method = RequestMethod.POST)
	public ModelAndView login(Member mb) {

		mav = mm.memberLogin(mb);
		return mav;
	}

   	//로그인 페이지로 이동
	@RequestMapping(value = "/logout")
	public String logout() {
		System.out.println(sesstion.getAttribute("id"));
		sesstion.invalidate();
		System.out.println(sesstion.getAttribute("id"));
		
		return "home";
	}
       
}
