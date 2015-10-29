package com.gesila.test.guard.json.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gesila.test.guard.json.model.GesilaJSONObject;

/**
 * 
 * @author robin
 *
 */
public class JSONUtils {

	private void createJSONObject(JSONObject respJsonObject, List<GesilaJSONObject> list) {

		Iterator<String> iter = respJsonObject.keySet().iterator();
		while (iter.hasNext()) {
			// --key
			String key = iter.next();
			GesilaJSONObject responseObject = new GesilaJSONObject();
			responseObject.setName(key);
			String value = respJsonObject.getString(key);
			char fchar = 0;
			if (!"".equals(value)) {
				char[] chars = value.toCharArray();
				fchar = chars[0];
			}
			if ('{' == fchar) {
				createJSONObject(JSONObject.parseObject(value), list);
			} else if ('[' == fchar) {
				JSONArray jsonArray = JSONObject.parseArray(value);
				ListIterator<Object> listIter = jsonArray.listIterator();
				List<GesilaJSONObject> currentList = new ArrayList<GesilaJSONObject>();
				while (listIter.hasNext()) {
					List<GesilaJSONObject> arrayList = new ArrayList<GesilaJSONObject>();
					Object object = listIter.next();
					// --创建虚拟节点对象
					GesilaJSONObject parentReponseObject = new GesilaJSONObject();
					createJSONObject((JSONObject) object, arrayList);
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
