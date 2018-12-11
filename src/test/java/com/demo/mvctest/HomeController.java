package com.demo.mvctest;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.board.controller.BoardController;

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping(value="/home.do", method=RequestMethod.GET)
	public String home(Locale locale, Model model, @RequestParam String username) {
		logger.info("{} welcome home the client locale is {}", username, locale);
		Date date = new Date();
		DateFormat format = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = format.format(date);
		
		model.addAttribute("serverTime", formattedDate);
		return "home";
	}
}
