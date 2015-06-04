package com.makemoney.wechat.util;

import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.makemoney.util.HttpsClient;
import com.makemoney.wechat.WechatRequestParam;
import com.makemoney.wechat.WechatResponseParam;
import com.makemoney.wechat.config.WechatConfig;
import com.makemoney.wechat.exception.WechatException;
import com.makemoney.wechat.model.AccessToken;
import com.makemoney.wechat.model.AccessTokenOAuth;
import com.makemoney.wechat.model.JSApiTicket;
import com.makemoney.wechat.model.UserInfo;

/**
 * 微信HTTPS请求
 * 
 * @author wuxincheng
 * @date 2015年6月2日 下午3:46:05
 * @version V1.0
 */
@Component
public class WechatHttpsHelper {

	private static Logger logger = LoggerFactory.getLogger(WechatHttpsHelper.class);

	// private static final String REQUEST_METHOD_POST = "POST";
	private static final String REQUEST_METHOD_GET = "GET";

	@Resource
	private WechatConfig wechatConfig;

	/**
	 * 根据AppID和AppSecret获取全局的AccessToken
	 */
	public AccessToken getAccessTokenModel() throws Exception {
		logger.info("根据AppID和AppSecret获取access token");

		// 处理请求获取access token地址
		String accessTokenUrl = wechatConfig.getAccessTokenUrl();
		accessTokenUrl = accessTokenUrl.replace(WechatRequestParam.APPID, wechatConfig.getAppID());
		accessTokenUrl = accessTokenUrl.replace(WechatRequestParam.APP_SECRET,
				wechatConfig.getAppSecret());

		logger.info("请求的URL地址 accessTokenUrl={}", accessTokenUrl);

		// 发送GET请求并处理返回数据
		JSONObject responseJSON = HttpsClient.httpsRequest(accessTokenUrl, REQUEST_METHOD_GET, null);
		if (null == responseJSON) {
			logger.info("请求的返回信息为空");
			return null;
		}

		logger.info("请求的返回信息 responseJSONObject={}", responseJSON);

		String errcode = responseJSON.getString(WechatResponseParam.ERRCODE);
		if (!StringUtils.isEmpty(errcode)) { // 处理错误返回码与返回信息
			throw new WechatException(errcode, WechatReponseCode.getMessage(errcode));
		}
		
		// 封装返回的数据
		AccessToken accessToken = new AccessToken();
		accessToken.setAccessToken(responseJSON.getString(WechatResponseParam.ACCESS_TOKEN));
		accessToken.setExpiresIn(responseJSON.getString(WechatResponseParam.EXPIRES_IN));

		return accessToken;
	}

	/**
	 * 根据Code获取授权登录的AccessToken
	 */
	public AccessTokenOAuth getAccessTokenOAuthModel(String code) throws Exception {
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
			throw new WechatException(errcode, WechatReponseCode.getMessage(errcode));
		}
		
		AccessTokenOAuth accessTokenOAuth = new AccessTokenOAuth();
		accessTokenOAuth.setAccessToken(responseJSON.getString(WechatResponseParam.ACCESS_TOKEN));
		accessTokenOAuth.setExpiresIn(responseJSON.getString(WechatResponseParam.EXPIRES_IN));
		accessTokenOAuth.setRefreshToken(responseJSON.getString(WechatResponseParam.REFRESH_TOKEN));
		accessTokenOAuth.setOpenid(responseJSON.getString(WechatResponseParam.OPENID));
		accessTokenOAuth.setScope(responseJSON.getString(WechatResponseParam.SCOPE));

		return accessTokenOAuth;
	}
	
	/**
	 * 刷新token, 目前先不实现
	 */
	public Map<String, Object> refreshToken(String refreshToken) throws Exception {
		return null;
	}
	
	/**
	 * 获取用户详细信息
	 */
	public UserInfo getUserInfoModel(String accessToken, String openid) throws Exception {
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
			throw new WechatException(errcode, WechatReponseCode.getMessage(errcode));
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

	/**
	 * 获取用于生成JS-SDK权限验证的签名
	 */
	public JSApiTicket getJSApiTicket(String accessToken) throws Exception {
		if (StringUtils.isEmpty(accessToken)) {
			return null;
		}
		
		logger.info("用于生成JS-SDK权限验证的签名 accessToken={}", accessToken);

		String jsapiTicketUrl = wechatConfig.getJsapiTicketUrl();
		jsapiTicketUrl = jsapiTicketUrl.replace(WechatRequestParam.APPID, accessToken);

		logger.info("请求的URL地址 accessTokenUrl={}", jsapiTicketUrl);
		
		JSONObject responseJSON = HttpsClient.httpsRequest(jsapiTicketUrl, REQUEST_METHOD_GET, null);
		if (null == responseJSON) {
			logger.info("请求的返回信息为空");
			return null;
		}
		
		logger.info("请求的返回信息 responseJSONObject={}", responseJSON);
		
		String errcode = responseJSON.getString(WechatResponseParam.ERRCODE);
		if (!WechatReponseCode.REQUEST_SUCCESS.equals(errcode)) {
			throw new WechatException(errcode, WechatReponseCode.getMessage(errcode));
		}
		
		JSApiTicket jsApiTicket = new JSApiTicket();
		jsApiTicket.setTicket(responseJSON.getString(WechatResponseParam.TICKET));
		jsApiTicket.setExpiresIn(responseJSON.getString(WechatResponseParam.EXPIRES_IN));

		return jsApiTicket;
	}
 
	// TODO 分享接口加签实现
	
}
