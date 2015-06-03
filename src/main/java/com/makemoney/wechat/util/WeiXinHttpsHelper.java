package com.makemoney.wechat.util;

import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.makemoney.wechat.WechatRequestParam;
import com.makemoney.wechat.WechatResponseParam;
import com.makemoney.wechat.config.WechatConfig;
import com.makemoney.wechat.exception.WeiXinException;
import com.makemoney.wechat.model.AccessToken;
import com.makemoney.wechat.model.AccessTokenOAuth;
import com.makemoney.wechat.model.UserInfo;

/**
 * 微信HTTPS请求
 * 
 * @author wuxincheng
 * @date 2015年6月2日 下午3:46:05
 * @version V1.0
 */
@Component
public class WeiXinHttpsHelper {

	private static Logger logger = LoggerFactory.getLogger(WeiXinHttpsHelper.class);

	// private static final String REQUEST_METHOD_POST = "POST";
	private static final String REQUEST_METHOD_GET = "GET";

	@Resource
	private WechatConfig wechatConfig;

	public AccessToken getAccessToken() throws Exception {
		logger.info("根据AppID和AppSecret获取access token");

		// 获取access token
		String accessTokenUrl = wechatConfig.getAccessTokenUrl();
		accessTokenUrl = accessTokenUrl.replace(WechatRequestParam.APPID, wechatConfig.getAppID());
		accessTokenUrl = accessTokenUrl.replace(WechatRequestParam.APP_SECRET,
				wechatConfig.getAppSecret());

		logger.info("请求的URL地址 accessTokenUrl={}", accessTokenUrl);

		JSONObject responseJSON = HttpsClient.httpsRequest(accessTokenUrl, REQUEST_METHOD_GET, null);
		if (null == responseJSON) {
			logger.info("请求的返回信息为空");
			return null;
		}

		logger.info("请求的返回信息 responseJSONObject={}", responseJSON);

		String errcode = responseJSON.getString(WechatResponseParam.ERRCODE);
		if (!StringUtils.isEmpty(errcode)) {
			throw new WeiXinException(errcode, WeiXinReponseCode.getMessage(errcode));
		}
		
		AccessToken accessToken = new AccessToken();
		accessToken.setAccessToken(responseJSON.getString(WechatResponseParam.ACCESS_TOKEN));
		accessToken.setExpiresIn(responseJSON.getString(WechatResponseParam.EXPIRES_IN));

		return accessToken;
	}

	public AccessTokenOAuth getAccessTokenOAuth(String code) throws Exception {
		if (StringUtils.isEmpty(code)) {
			return null;
		}

		logger.info("根据code获取access token");

		String accessTokenUrl = wechatConfig.getAccessTokenByCodeUrl();
		accessTokenUrl = accessTokenUrl.replace(WechatRequestParam.APPID, wechatConfig.getAppID());
		accessTokenUrl = accessTokenUrl.replace(WechatRequestParam.SECRET,
				wechatConfig.getAppSecret());
		accessTokenUrl = accessTokenUrl.replace(WechatRequestParam.CODE, code);

		logger.info("请求的URL地址 accessTokenUrl={}", accessTokenUrl);
		
		JSONObject responseJSON = HttpsClient.httpsRequest(accessTokenUrl, REQUEST_METHOD_GET, null);
		if (null == responseJSON) {
			logger.info("请求的返回信息为空");
			return null;
		}
		
		logger.info("请求的返回信息 responseJSONObject={}", responseJSON);
		
		String errcode = responseJSON.getString(WechatResponseParam.ERRCODE);
		if (!StringUtils.isEmpty(errcode)) {
			throw new WeiXinException(errcode, WeiXinReponseCode.getMessage(errcode));
		}
		
		AccessTokenOAuth accessTokenOAuth = new AccessTokenOAuth();
		accessTokenOAuth.setAccessToken(responseJSON.getString(WechatResponseParam.ACCESS_TOKEN));
		accessTokenOAuth.setExpiresIn(responseJSON.getString(WechatResponseParam.EXPIRES_IN));
		accessTokenOAuth.setRefreshToken(responseJSON.getString(WechatResponseParam.REFRESH_TOKEN));
		accessTokenOAuth.setOpenid(responseJSON.getString(WechatResponseParam.OPENID));
		accessTokenOAuth.setScope(responseJSON.getString(WechatResponseParam.SCOPE));

		return accessTokenOAuth;
	}
	
	public Map<String, Object> refreshToken(String refreshToken) throws Exception {
		return null;
	}
	
	public UserInfo getUserInfo(String accessToken, String openid) throws Exception {
		if (StringUtils.isEmpty(accessToken) ||  StringUtils.isEmpty(openid)) {
			return null;
		}
		
		logger.info("拉取用户信息 accessToken={}, openid={}", accessToken, openid);
		
		String userInfoUrl = wechatConfig.getAccessTokenByCodeUrl();
		userInfoUrl = userInfoUrl.replace(WechatRequestParam.ACCESS_TOKEN, accessToken);
		userInfoUrl = userInfoUrl.replace(WechatRequestParam.OPENID, openid);
		
		JSONObject responseJSON = HttpsClient.httpsRequest(userInfoUrl, REQUEST_METHOD_GET, null);
		if (null == responseJSON) {
			logger.info("请求的返回信息为空");
			return null;
		}
		
		logger.info("请求的返回信息 responseJSONObject={}", responseJSON);
		
		String errcode = responseJSON.getString(WechatResponseParam.ERRCODE);
		if (!StringUtils.isEmpty(errcode)) {
			throw new WeiXinException(errcode, WeiXinReponseCode.getMessage(errcode));
		}
		
		UserInfo userInfo = new UserInfo();
		userInfo.setOpenid(responseJSON.getString(WechatResponseParam.OPENID));
		userInfo.setNickname(responseJSON.getString(WechatResponseParam.NICKNAME));
		userInfo.setSex(responseJSON.getString(WechatResponseParam.SEX));
		userInfo.setProvince(responseJSON.getString(WechatResponseParam.PROVINCE));
		userInfo.setCity(responseJSON.getString(WechatResponseParam.CITY));
		userInfo.setCountry(responseJSON.getString(WechatResponseParam.COUNTRY));
		userInfo.setHeadimgurl(responseJSON.getString(WechatResponseParam.HEADIMGURL));
		userInfo.setPrivilege(responseJSON.getString(WechatResponseParam.PRIVILEGE));
		
		return userInfo;
	}

}
