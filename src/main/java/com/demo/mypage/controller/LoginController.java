package com.demo.mypage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value="/login.do", method = RequestMethod.GET)
	public String login(Model model,
			@RequestParam(value="error", required=false) String error,
			@RequestParam(value="logout", required=false) String logout) {
		
		if(error != null) model.addAttribute("error", "아이디나 비밀번호가 맞지 않습니다");
		if(logout != null) model.addAttribute("logout", "로그아웃 되었습니다.");
		
		return "login";
	}
	
	@RequestMapping(value="/logout.do", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	        //request.getSession().invalidate();
	    }
	    return "redirect:/login.do?logout";
	}
	
	
	@RequestMapping("/session.do")
	public String session(HttpServletRequest req, HttpSession session) {
		//for session listener test
		session.invalidate();
		HttpSession newSession = req.getSession();
		newSession.setAttribute("username", "popopin");
		
		return "session";
	}
}
