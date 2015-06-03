package com.makemoney.wechat.model;

import com.makemoney.util.StringUtil;

/**
 * 公众号的全局唯一票据access_token
 * 
 * @author wuxincheng
 * @date 2015年6月3日 下午1:19:20
 * @version V1.0
 */
public class AccessToken {

	/** 获取到的凭证 */
	private String accessToken;

	/** 凭证有效时间，单位：秒 */
	private String expiresIn;
	
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

}
