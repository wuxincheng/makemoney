package com.makemoney.wechat.util;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.makemoney.util.SignBuilderUtil;
import com.makemoney.wechat.WechatRequestParam;
import com.makemoney.wechat.config.WechatConfig;

/**
 * 微信签名帮助类
 * 
 * @author wuxincheng
 * @date 2015年6月4日 下午2:17:21
 * @version V1.0
 */
@Component
public class WechatSignHelper {

	@Resource
	private WechatConfig wechatConfig;

	/**
	 * 验证签名串
	 * 
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @return
	 */
	public boolean checkSignature(String signature, String timestamp, String nonce) {

		String[] signPrepareValues = { wechatConfig.getToken(), timestamp, nonce };

		String sign = SignBuilderUtil.getSignature(signPrepareValues);

		return sign != null ? signature.equals(sign) : false;
	}
	
	public String getShareSignature(String noncestr, String ticket, String timestamp, String url){
		// 封装待签名Map
		Map<String, String> signParam = new HashMap<String, String>();
		signParam.put(WechatRequestParam.NONCESTR, noncestr);
		signParam.put(WechatRequestParam.JSAPI_TICKET, ticket);
		signParam.put(WechatRequestParam.TIMESTAMP, timestamp);
		signParam.put(WechatRequestParam.URL, url);
		
		return SignBuilderUtil.sortingMapToStr(signParam, null, null, true);
	}

}
