package com.makemoney.ui.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.makemoney.util.Constants;

/**
 * 赚了没
 */
@Controller
@RequestMapping("/index")
public class IndexController {
	private static Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	private static final String WEB_NAME = Constants.WEB_NAME;

	@RequestMapping(value = "/")
	public String list(HttpServletRequest request, Model model) {
		logger.info(WEB_NAME + "显示首页");
		
		return "index";
	}
	
}
