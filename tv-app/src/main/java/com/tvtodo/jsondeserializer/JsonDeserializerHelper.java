package com.tvtodo.jsondeserializer;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.tvtodo.models.Show;

public class JsonDeserializerHelper<T> implements JsonDeserializer<T> {
	
	private String fieldName;
	
	public JsonDeserializerHelper(String fieldName) {
		super();
		this.setFieldName(fieldName);
	}
	@Override
	public T deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException {
		
		// Get the "content" element from the parsed JSON
        JsonElement content = je.getAsJsonObject().get(getFieldName());

        // Deserialize it. You use a new instance of Gson to avoid infinite recursion
        // to this deserializer
        return new Gson().fromJson(content, type);
		
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

}
