package com.weixin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weixin.exception.WeiXinException;
import com.weixin.util.SignUtil;

/**
 * 接入微信公众号平台
 * 
 * @author wuxincheng
 */
@Controller
@RequestMapping("/weixin/notice")
public class WeixinController {
	private static Logger logger = LoggerFactory.getLogger(WeixinController.class);
	
	/**
	 * POST请求
	 */
	@RequestMapping(method = RequestMethod.POST)
	public void post(HttpServletRequest request, HttpServletResponse response, Model model) {
		
	}

	/**
	 * GET请求: 接入微信公众平台
	 */
	@RequestMapping(method = RequestMethod.GET)
	public void get(HttpServletRequest request, HttpServletResponse response, Model model) {
		logger.info("接收微信公众平台GET接入请求");
		
		String respCode = null;
		String respMsg = null;
		
		try {
			// 微信加密签名, signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数
			String signature = request.getParameter("signature");
			logger.info("加密签名 signature={}", signature);
			
			if (StringUtils.isEmpty(signature)) {
				logger.warn("加密签名signature为空");
				throw new WeiXinException(WeiXinException.ILLEGAL_PATTERN, "加密签名signature为空");
			}
	
			// 时间戳
			String timestamp = request.getParameter("timestamp");
			logger.info("时间戳 timestamp={}", timestamp);
			
			if (StringUtils.isEmpty(timestamp)) {
				logger.warn("时间戳timestamp为空");
				throw new WeiXinException(WeiXinException.ILLEGAL_PATTERN, "时间戳timestamp为空");
			}
	
			// 随机数
			String nonce = request.getParameter("nonce");
			logger.info("随机数 nonce={}", nonce);
			
			if (StringUtils.isEmpty(nonce)) {
				logger.warn("随机数nonce为空");
				throw new WeiXinException(WeiXinException.ILLEGAL_PATTERN, "随机数nonce为空");
			}
	
			// 随机字符串
			String echostr = request.getParameter("echostr");
			logger.info("随机字符串 echostr={}", echostr);
	
			if (StringUtils.isEmpty(echostr)) {
				logger.warn("随机字符串 echostr= 为空");
				throw new WeiXinException(WeiXinException.ILLEGAL_PATTERN, "随机字符串 echostr 为空");
			}
			
			// 原样返回echostr参数内容
			if (SignUtil.checkSignature(signature, timestamp, nonce)) {
				logger.info("微信公众平台接入成功");
				printResponse(response, echostr);
			} else {
				logger.error("微信公众平台接入失败");
			}
		} catch (WeiXinException e) {
			respCode = e.getCode();
			respMsg = e.getMessage();
			logger.error("处理微信请求数据异常", e);
			
			Map<String, String> responseData = new HashMap<String, String>();
			responseData.put("respCode", respCode);
			responseData.put("respMsg", respMsg);
			
			printResponse(response, responseData);
		} catch (Exception ex) {
			respCode = WeiXinException.SYSTEM_ERROR;
			respMsg = "系统异常";
			logger.error("系统异常", ex);
			
			Map<String, String> responseData = new HashMap<String, String>();
			responseData.put("respCode", respCode);
			responseData.put("respMsg", respMsg);
			
			printResponse(response, responseData);
		}
	}
	
	/**
	 * 输出响应报文
	 * 
	 * @param response
	 * @param rspCode
	 * @param rspMsg
	 */
	private void printResponse(HttpServletResponse response, String responseStr) {
		logger.info("返回微信公众平台应答报文 responseStr=\n{}", responseStr);
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			logger.error("网络通讯异常，返回微信公众平台报文失败");
		}
        out.print(responseStr);
	}
	
	/**
	 * 输出响应报文
	 * 
	 * @param response
	 * @param rspCode
	 * @param rspMsg
	 */
	private void printResponse(HttpServletResponse response, Map<String, String> responseData) {
		logger.info("返回微信公众平台应答报文 responseStr=\n{}", responseData);
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			logger.error("网络通讯异常，返回微信公众平台报文失败");
		}
        out.print(responseData);
	}

}
