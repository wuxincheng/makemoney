package com.makemoney.wechat.model;

/**
 * 用于生成JS-SDK权限验证签名的jsapi_ticket
 * 
 * @author wuxincheng
 * @date 2015年6月3日 下午9:59:39
 * @version V1.0
 */
public class JSApiTicket {

	private String ticket;

	private String expiresIn;

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public String getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(String expiresIn) {
		this.expiresIn = expiresIn;
	}

}
