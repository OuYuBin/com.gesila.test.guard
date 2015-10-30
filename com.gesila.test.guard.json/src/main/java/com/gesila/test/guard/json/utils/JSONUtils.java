package com.gesila.test.guard.json.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gesila.test.guard.json.model.GesilaJSONObject;

/**
 * 
 * @author robin
 *
 */
public class JSONUtils {

	/**
	 * 
	 * @param jsonString
	 * @return
	 */
	public static JSONObject createJSONObject(String jsonString) {
		JSONObject jsonObject = null;
		char[] responseChars = jsonString.toCharArray();
		char firstChar = responseChars[0];
		if ('{' == firstChar) {
			jsonObject = JSONObject.parseObject(jsonString);
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("name", jsonString);
			jsonObject = new JSONObject(map);
		}
		return jsonObject;
	}

	/**
	 * 
	 * @param jsonObject
	 * @param list
	 */
	public static void createGesilaJSONObject(JSONObject jsonObject, List<GesilaJSONObject> list) {

		Iterator<String> iter = jsonObject.keySet().iterator();
		while (iter.hasNext()) {
			// --key
			String key = iter.next();
			GesilaJSONObject responseObject = new GesilaJSONObject();
			responseObject.setName(key);
			String value = jsonObject.getString(key);
			char fchar = 0;
			if (!"".equals(value)) {
				char[] chars = value.toCharArray();
				fchar = chars[0];
			}
			if ('{' == fchar) {
				createGesilaJSONObject(JSONObject.parseObject(value), list);
			} else if ('[' == fchar) {
				JSONArray jsonArray = JSONObject.parseArray(value);
				ListIterator<Object> listIter = jsonArray.listIterator();
				List<GesilaJSONObject> currentList = new ArrayList<GesilaJSONObject>();
				while (listIter.hasNext()) {
					List<GesilaJSONObject> arrayList = new ArrayList<GesilaJSONObject>();
					Object object = listIter.next();
					// --创建虚拟节点对象
					GesilaJSONObject parentReponseObject = new GesilaJSONObject();
					createGesilaJSONObject((JSONObject) object, arrayList);
					parentReponseObject.setGesilaJSONObjects(arrayList);
					currentList.add(parentReponseObject);
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
