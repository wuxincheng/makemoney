package com.makemoney.ui.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fund")
public class FundAskController {

	private static Logger logger = LoggerFactory.getLogger(FundAskController.class);
	
	@RequestMapping(value = "/ask")
	public String list(HttpServletRequest request, Model model) {
		logger.info("向好友提问");
		
		return "ask";
	}
	
}
