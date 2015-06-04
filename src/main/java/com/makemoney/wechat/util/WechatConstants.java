package com.makemoney.wechat.util;

public class WechatConstants {

	/** Token(令牌) */
	// public static final String TOKEN = "insidetiger";
	
	/** 应用授权作用域: 不弹出授权页面，直接跳转 */
	public static final String AUTH_SCOPE_BASE = "snsapi_base";
	
	/** 应用授权作用域: 弹出授权页面 */
	public static final String AUTH_SCOPE_USERINFO = "snsapi_userinfo";
	
	/** 消息类型: event */
	public static final String MSG_TYPE_EVENT = "event";
	
	/** 事件类型: subscribe(订阅) */
	public static final String EVENT_SUBSCRIBE = "subscribe";
	
	/** 事件类型: unsubscribe(取消订阅) */
	public static final String EVENT_UNSUBSCRIBE = "unsubscribe";
	
	/** 事件类型: CLICK */
	public static final String EVENT_CLICK = "CLICK";

}
