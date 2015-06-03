package com.makemoney.ui.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.makemoney.wechat.WechatRequestParam;
import com.makemoney.wechat.WechatResponseParam;
import com.makemoney.wechat.config.WechatConfig;
import com.makemoney.wechat.util.WeiXinConstants;

/**
 * 赚了没
 */
@Controller
@RequestMapping("/auth")
public class AuthController {
	private static Logger logger = LoggerFactory.getLogger(AuthController.class);

	@Resource
	private WechatConfig wechatConfig;

	@RequestMapping(value = "/")
	public String list(HttpServletRequest request, Model model) {
		logger.info("显示登录授权页面");

		String authUrl = wechatConfig.getAuthApiUrl();
		authUrl = authUrl.replace(WechatRequestParam.APPID, wechatConfig.getAppID())
				.replace(WechatRequestParam.REDIRECT_URI, wechatConfig.getRedirectUri())
				.replace(WechatRequestParam.SCOPE, WeiXinConstants.AUTH_SCOPE_USERINFO);

		model.addAttribute("authUrl", authUrl);

		return "auth";
	}
	
	@RequestMapping(value = "/check", method = RequestMethod.GET)
	public void receviewAuthCode(HttpServletRequest request, Model model){
		String code = request.getParameter(WechatResponseParam.CODE);
		String state = request.getParameter(WechatResponseParam.STATE);
		
		if (StringUtils.isEmpty(state)) {
			
		}
		
		if (StringUtils.isEmpty(code)) {
			// 可以使用Code用作唯一标识
		}
		
		// TODO 保存
	}

}
