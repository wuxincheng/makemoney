package com.makemoney.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JSON
 *
 * @author wuxincheng
 * @date 2015年6月3日 上午10:23:47
 * @version V1.0
 */
public class JSONHelper {

	private static ObjectMapper objectMapper = new ObjectMapper();

	public static <T> T parse(String json, Class<T> T) {
		try {
			return (T) objectMapper.readValue(json, T);
		} catch (Exception e) {
			return null;
		}
	}

	public static String generate(Map<String, Object> data) {
		try {
			return objectMapper.writeValueAsString(data);
		} catch (Exception e) {
			return null;
		}
	}

	public static Map<String, Object> parseJSON2Map(String jsonStr) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 最外层解析
		JSONObject json = JSONObject.fromObject(jsonStr);
		for (Object k : json.keySet()) {
			Object v = json.get(k);
			// 如果内层还是数组的话，继续解析
			if (v instanceof JSONArray) {
				List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
				@SuppressWarnings("unchecked")
				Iterator<JSONObject> it = ((JSONArray) v).iterator();
				while (it.hasNext()) {
					JSONObject json2 = it.next();
					list.add(parseJSON2Map(json2.toString()));
				}
				map.put(k.toString(), list);
			} else {
				map.put(k.toString(), v);
			}
		}
		return map;
	}
}
