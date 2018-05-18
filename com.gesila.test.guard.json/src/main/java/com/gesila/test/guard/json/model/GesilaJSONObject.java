package com.gesila.test.guard.json.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author robin
 *
 */
public class GesilaJSONObject {

	List<GesilaJSONObject> gesilaJSONObjects = new ArrayList<GesilaJSONObject>();

	public String name;

	public String value;

	public void addResponseObject(GesilaJSONObject gesilaJSONObject) {
		gesilaJSONObjects.add(gesilaJSONObject);
	}
	
	public GesilaJSONObject(){

	}

	/**
	 * 序号
	 * @param id
	 */
	public GesilaJSONObject(String id){
		this.name=id;
	}
	
	public List<GesilaJSONObject> getGesilaJSONObjects() {
		return gesilaJSONObjects;
	}

	public void setGesilaJSONObjects(List<GesilaJSONObject> gesilaJSONObjects) {
		this.gesilaJSONObjects = gesilaJSONObjects;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
