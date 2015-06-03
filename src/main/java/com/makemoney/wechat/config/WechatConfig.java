package com.makemoney.wechat.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 微信配置信息读取
 * 
 * @author wuxincheng
 * @date 2015年6月2日 下午10:54:16
 * @version V1.0
 */
@Component
public class WechatConfig {

	@Value("#{wechatConfigSettings.appID}")
	private String appID;

	@Value("#{wechatConfigSettings.appSecret}")
	private String appSecret;

	@Value("#{wechatConfigSettings.token}")
	private String token;

	@Value("#{wechatConfigSettings.encodingAESKey}")
	private String encodingAESKey;

	@Value("#{wechatConfigSettings.accessTokenUrl}")
	private String accessTokenUrl;

	@Value("#{wechatConfigSettings.userInfoUrl}")
	private String userInfoUrl;

	@Value("#{wechatConfigSettings.authApiUrl}")
	private String authApiUrl;

	@Value("#{wechatConfigSettings.redirectUri}")
	private String redirectUri;

	@Value("#{wechatConfigSettings.redirectUri}")
	private String accessTokenByCodeUrl;

	@Value("#{wechatConfigSettings.jsapiTicketUrl}")
	private String jsapiTicketUrl;

	public String getAppID() {
		return appID;
	}

	public void setAppID(String appID) {
		this.appID = appID;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getEncodingAESKey() {
		return encodingAESKey;
	}

	public void setEncodingAESKey(String encodingAESKey) {
		this.encodingAESKey = encodingAESKey;
	}

	public String getAccessTokenUrl() {
		return accessTokenUrl;
	}

	public void setAccessTokenUrl(String accessTokenUrl) {
		this.accessTokenUrl = accessTokenUrl;
	}

	public String getUserInfoUrl() {
		return userInfoUrl;
	}

	public void setUserInfoUrl(String userInfoUrl) {
		this.userInfoUrl = userInfoUrl;
	}

	public String getAuthApiUrl() {
		return authApiUrl;
	}

	public void setAuthApiUrl(String authApiUrl) {
		this.authApiUrl = authApiUrl;
	}

	public String getRedirectUri() {
		return redirectUri;
	}

	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}

	public String getAccessTokenByCodeUrl() {
		return accessTokenByCodeUrl;
	}

	public void setAccessTokenByCodeUrl(String accessTokenByCodeUrl) {
		this.accessTokenByCodeUrl = accessTokenByCodeUrl;
	}

	public String getJsapiTicketUrl() {
		return jsapiTicketUrl;
	}

	public void setJsapiTicketUrl(String jsapiTicketUrl) {
		this.jsapiTicketUrl = jsapiTicketUrl;
	}

}
