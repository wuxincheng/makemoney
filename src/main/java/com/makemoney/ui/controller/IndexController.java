package com.makemoney.ui.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 赚了没
 */
@Controller
@RequestMapping("/index")
public class IndexController {
	private static Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@RequestMapping(value = "/")
	public String list(HttpServletRequest request, Model model) {
		logger.info("显示首页");
		
		return "index";
	}
	
}
