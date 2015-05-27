package com.weixin.exception;

public class WeiXinException extends Exception {

	private static final long serialVersionUID = 566839376511643217L;

	/** 系统默认异常类型 */
	public static final String SYSTEM_ERROR = "9999";
	
	/** 请求参数异常类型 */
	public static final String ILLEGAL_PATTERN = "1000";

	private String code = null;

	public WeiXinException() {
	}
	
	public WeiXinException(Throwable cause) {
		super(cause);
	}

	public WeiXinException(String message, Throwable cause) {
		super(message, cause);
	}

	public WeiXinException(String code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}

	public WeiXinException(String code, String message) {
		super(message);
		this.code = code;
	}

	public WeiXinException(String message) {
		super(message);
	}
	
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
