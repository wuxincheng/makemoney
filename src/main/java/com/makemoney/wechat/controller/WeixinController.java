package com.makemoney.wechat.controller;

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

import com.makemoney.wechat.WechatResponseParam;
import com.makemoney.wechat.exception.WeiXinException;
import com.makemoney.wechat.util.MessageUtil;
import com.makemoney.wechat.util.SignUtil;
import com.makemoney.wechat.util.WeiXinConstants;

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
	public void post(HttpServletRequest request, HttpServletResponse response) {
		logger.info("接收微信公众平台请求");

		Map<String, String> requestMap = null;
		try {
			requestMap = MessageUtil.parseXml(request);
			logger.info("接收微信数据 requestMap={}", requestMap);
		} catch (Exception ex) {
			logger.error("解析微信数据异常", ex);
		}
			
		try {
			if (null == requestMap || requestMap.size() < 1) {
				throw new WeiXinException(WeiXinException.ILLEGAL_PATTERN, "接收到数据为空");
			}

			// 消息类型
			String msgType = requestMap.get(WechatResponseParam.MSG_TYPE);
			// 事件类型
			String event = requestMap.get(WechatResponseParam.EVENT);
		
			if (StringUtils.isEmpty(msgType)) {
				throw new WeiXinException(WeiXinException.ILLEGAL_PATTERN, "消息类型msgType为空");
			}
			
			if (StringUtils.isEmpty(event)) {
				throw new WeiXinException(WeiXinException.ILLEGAL_PATTERN, "事件类型event为空");
			}
			
			if (WeiXinConstants.MSG_TYPE_EVENT.equals(event)) {
				if (WeiXinConstants.EVENT_SUBSCRIBE.equals(msgType)) {

				}

				if (WeiXinConstants.EVENT_UNSUBSCRIBE.equals(msgType)) {

				}
			} else {
				throw new WeiXinException(WeiXinException.ILLEGAL_PATTERN, "未知消息类型");
			}
		} catch (WeiXinException e) {
			logger.error(e.getCode() + ": " + e.getMessage(), e);
		}
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
				throw new WeiXinException(WeiXinException.ILLEGAL_PATTERN, "加密签名signature为空");
			}

			// 时间戳
			String timestamp = request.getParameter("timestamp");
			logger.info("时间戳 timestamp={}", timestamp);

			if (StringUtils.isEmpty(timestamp)) {
				throw new WeiXinException(WeiXinException.ILLEGAL_PATTERN, "时间戳timestamp为空");
			}

			// 随机数
			String nonce = request.getParameter("nonce");
			logger.info("随机数 nonce={}", nonce);

			if (StringUtils.isEmpty(nonce)) {
				throw new WeiXinException(WeiXinException.ILLEGAL_PATTERN, "随机数nonce为空");
			}

			// 随机字符串
			String echostr = request.getParameter("echostr");
			logger.info("随机字符串 echostr={}", echostr);

			// 不校验echostr

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
