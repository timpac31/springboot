package com.demo.mypage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.social.connect.Connection;
import org.springframework.social.google.api.Google;
import org.springframework.social.google.api.impl.GoogleTemplate;
import org.springframework.social.google.api.plus.Person;
import org.springframework.social.google.api.plus.PlusOperations;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.mypage.domain.OAuthUser;


@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private GoogleConnectionFactory googleConnectionFactory;
	@Autowired
	private OAuth2Parameters googleOAuth2Parameters;
	
	
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
	
	@RequestMapping(value = "/googleLogin.do", method = RequestMethod.GET)
	public String goGoogleSignUrl(HttpServletResponse response) {
		OAuth2Operations oauthOperations = googleConnectionFactory.getOAuthOperations();
		String url = oauthOperations.buildAuthorizeUrl(GrantType.AUTHORIZATION_CODE, googleOAuth2Parameters);
		//System.out.println("google login url : " + url);
		
		return "redirect:" + url;
	}
	
	@RequestMapping(value = "/oAuthCallback.do", method = RequestMethod.GET)
	public String getGoogleSignResponse(HttpServletRequest request, HttpServletResponse response) {
		String code = request.getParameter("code");
		
		OAuth2Operations oauthOperations = googleConnectionFactory.getOAuthOperations();
		AccessGrant accessGrant = oauthOperations.exchangeForAccess(code , googleOAuth2Parameters.getRedirectUri(), null);
		
		String accessToken = accessGrant.getAccessToken();
		Long expireTime = accessGrant.getExpireTime();
		if (expireTime != null && expireTime < System.currentTimeMillis()) {
			accessToken = accessGrant.getRefreshToken();
			System.out.printf("accessToken is expired. refresh token = {}", accessToken);
		}
		Connection<Google> connection = googleConnectionFactory.createConnection(accessGrant);
		Google google = connection == null ? new GoogleTemplate(accessToken) : connection.getApi();
		
		PlusOperations plusOperations = google.plusOperations();
		Person person = plusOperations.getGoogleProfile();
		
		OAuthUser oAuthUser = new OAuthUser();
		oAuthUser.setEmail(person.getAccountEmail());
		oAuthUser.setName(person.getDisplayName());
		oAuthUser.setGender(person.getGender());
		
		HttpSession session = request.getSession();
		session.setAttribute("oAuthUser", oAuthUser );
		
		return "index";
	}
	
	@RequestMapping(value = "/oAuthLogout.do", method = RequestMethod.GET)
	public String oAuthLogout(HttpServletRequest request, HttpSession session) {
		session.invalidate();

		//String url = request.getHeader("referer");
		return "redirect:https://www.google.com/accounts/Logout?continue=https://appengine.google.com/_ah/logout?continue=http://localhost:8080/";
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
