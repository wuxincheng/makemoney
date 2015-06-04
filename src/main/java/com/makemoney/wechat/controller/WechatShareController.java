package com.makemoney.wechat.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.makemoney.util.DateUtil;
import com.makemoney.util.StringUtil;
import com.makemoney.wechat.config.WechatConfig;
import com.makemoney.wechat.model.JSApiTicket;
import com.makemoney.wechat.util.WechatHttpsHelper;
import com.makemoney.wechat.util.WechatSignHelper;

/**
 * 分享接口
 * 
 * @author wuxincheng
 * @date 2015年6月4日 上午11:31:29
 * @version V1.0
 */
@Controller
@RequestMapping("/weixin/share")
public class WechatShareController {

	private static Logger logger = LoggerFactory.getLogger(WechatShareController.class);

	@Resource
	private WechatHttpsHelper wechatHttpsHelper;

	@Resource
	private WechatSignHelper wechatSignHelper;

	@Resource
	private WechatConfig wechatConfig;

	/**
	 * 微信JS-SDK获得初始化参数
	 */
	@RequestMapping(value = "/getJSSDKConfig")
	@ResponseBody
	public Map<String, Object> getJSSDKConfig(String shareUrl) {
		logger.info("微信JS-SDK获得初始化参数, 分享链接 shareUrl={}", shareUrl);

		String accessToken = null;
		try {
			// 获取全局的AccessToken
			accessToken = wechatHttpsHelper.getAccessTokenModel().getAccessToken();
			logger.info("获取到accessToken={}", accessToken);
		} catch (Exception e) {
			logger.error("获取全局的AccessToken异常", e);
		}

		JSApiTicket jsApiTicket = null;
		try {
			// 获取用于生成JS-SDK权限验证的签名
			jsApiTicket = wechatHttpsHelper.getJSApiTicket(accessToken);
		} catch (Exception e) {
			logger.error("获取JS-SDK权限验证的签名异常", e);
		}

		String timestamp = DateUtil.getCurrentTimestamp(); // 时间戳
		String nonceStr = StringUtil.getNonceStr(); // 随机字符串

		String signature = wechatSignHelper.getShareSignature(nonceStr, jsApiTicket.getTicket(),
				timestamp, shareUrl);

		// 封装返回数据
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("appId", wechatConfig.getAppID());
		param.put("timestamp", timestamp);
		param.put("nonceStr", nonceStr);
		param.put("signature", signature);

		return param;
	}

}
