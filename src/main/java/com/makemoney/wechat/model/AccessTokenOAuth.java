package com.makemoney.wechat.model;

import com.makemoney.util.StringUtil;

/**
 * 网页授权票据access_token
 * 
 * @author wuxincheng
 * @date 2015年6月3日 下午1:19:20
 * @version V1.0
 */
public class AccessTokenOAuth {

	/** 获取到的凭证 */
	private String accessToken;

	/** 凭证有效时间，单位：秒 */
	private String expiresIn;

	/** 用户刷新access_token */
	private String refreshToken;

	/** 用户唯一标识，请注意，在未关注公众号时，用户访问公众号的网页，也会产生一个用户和公众号唯一的OpenID */
	private String openid;

	/** 用户授权的作用域 */
	private String scope;
	
	@Override
    public String toString() {
        return StringUtil.toStringShort(this);
    }

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(String expiresIn) {
		this.expiresIn = expiresIn;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

}
