package com.ncs.model;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Response {

	

	
	private JsonObject data;
	

	public JsonElement getData() {
		return data;
	}

	public void setData(JsonObject candidateList) {
		this.data = candidateList;
	}

}
