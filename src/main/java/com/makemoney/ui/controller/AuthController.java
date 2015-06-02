package com.makemoney.ui.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.makemoney.ui.util.Constants;

/**
 * 赚了没
 */
@Controller
@RequestMapping("/auth")
public class AuthController {
	private static Logger logger = LoggerFactory.getLogger(AuthController.class);
	
	private static final String WEB_NAME = Constants.WEB_NAME;

	@RequestMapping(value = "/")
	public String list(HttpServletRequest request, Model model) {
		logger.info(WEB_NAME + "显示登录授权页面");
		
		String authUrl = null;
		
		model.addAttribute("authUrl", authUrl);
		
		return "auth";
	}
	
}