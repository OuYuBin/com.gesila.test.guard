package com.gesila.test.guard.json.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gesila.test.guard.json.model.GesilaJSONObject;

/**
 * 
 * @author robin
 *
 */
public class GesilaJSONUtils {

	/**
	 * 
	 * @param jsonString
	 * @return
	 */
	public static JSONObject createJSONObject(String jsonString) {
		JSONObject jsonObject = null;
		if (!"".equals(jsonString) && jsonString != null) {
			char[] responseChars = jsonString.toCharArray();
			char firstChar = responseChars[0];
			if ('{' == firstChar) {
				jsonObject = JSONObject.parseObject(jsonString);
			} else {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("name", jsonString);
				jsonObject = new JSONObject(map);
			}
		}
		return jsonObject;
	}

	/**
	 * 
	 * @param jsonObject
	 * @param list
	 */
	public static void createGesilaJSONObject(JSONObject jsonObject, List<GesilaJSONObject> list) {
		if (jsonObject != null) {
			Iterator<String> iter = jsonObject.keySet().iterator();
			while (iter.hasNext()) {
				// --key
				String key = iter.next();
				GesilaJSONObject responseObject = new GesilaJSONObject("");
				responseObject.setName(key);
				String value = jsonObject.getString(key);
				char fchar = 0;
				if (!"".equals(value)&&StringUtils.isNotEmpty(value)) {
					char[] chars = value.toCharArray();
					fchar = chars[0];
				}
				if ('{' == fchar) {
					createGesilaJSONObject(JSONObject.parseObject(value), list);
				} else if ('[' == fchar) {
					JSONArray jsonArray = JSONObject.parseArray(value);
					ListIterator<Object> listIter = jsonArray.listIterator();
					List<GesilaJSONObject> currentList = new ArrayList<GesilaJSONObject>();
					int i=0;
					while (listIter.hasNext()) {
						List<GesilaJSONObject> arrayList = new ArrayList<GesilaJSONObject>();
						Object object = listIter.next();
						// --创建虚拟节点对象
						GesilaJSONObject parentReponseObject = new GesilaJSONObject(i+"");
						createGesilaJSONObject((JSONObject) object, arrayList);
						parentReponseObject.setGesilaJSONObjects(arrayList);
						currentList.add(parentReponseObject);
						i++;
					}
					responseObject.setGesilaJSONObjects(currentList);
					list.add(responseObject);
				} else {
					responseObject.setValue(value);
					list.add(responseObject);
				}
			}
		}
	}

	public static String createGesilaJSONOString(JSONObject jsonObject) {
		return JSONObject.toJSONString(jsonObject);
	}
}
