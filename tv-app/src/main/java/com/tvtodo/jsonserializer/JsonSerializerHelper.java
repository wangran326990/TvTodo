package com.tvtodo.jsonserializer;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class JsonSerializerHelper<T> implements JsonSerializer<T> {
	
	//private Class<T> clz;
	private Map<String, String>  propertyMap;
	private JsonObject jsonObject = new JsonObject();
	public JsonSerializerHelper( Map<String, String> map) {
		//this.clz = clz;
		this.propertyMap =map;
	}
	
	@Override
	public JsonElement serialize(T src, Type type, JsonSerializationContext context) {
		JsonElement obj=null;
		try {
			obj = serializeHelper(src,context);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
	
	private JsonElement serializeHelper(T src, JsonSerializationContext context) throws Exception{
		
		Map<String,PropertyDescriptor> listOfSerializedProperty = new HashMap<>();
		for (PropertyDescriptor pd : Introspector.getBeanInfo(src.getClass()).getPropertyDescriptors()) {
				String key =pd.getName();
				if(propertyMap.containsKey(key)){
					listOfSerializedProperty.put(propertyMap.get(key), pd);
				}							  
		}
		for(Map.Entry<String,PropertyDescriptor> pd: listOfSerializedProperty.entrySet()){
			Object obj = pd.getValue().getReadMethod().invoke(src);
			if(obj==null){
				//JsonElement jsonElement = context.serialize(new Object());
				jsonObject.add(pd.getKey(), JsonNull.INSTANCE);
			}
			else if (obj instanceof String) {
				String value = (String) obj;
				jsonObject.addProperty(pd.getKey(), value);
			}
			
			else if(obj instanceof Number){
				Number value = (Number) obj;
				jsonObject.addProperty(pd.getKey(), value);
			}
			else if (obj instanceof Boolean) {
				Boolean value = (Boolean) obj;
				jsonObject.addProperty(pd.getKey(), value);
			}
			
			else if (obj instanceof Character) {
				Character value = (Character) obj;
				jsonObject.addProperty(pd.getKey(), value);
			}
			
			else if(obj.getClass().isArray()){
				Object[] objs = (Object[]) obj;
				jsonObject.add(pd.getKey(), generateJsonArray(objs));
			}else{
				JsonElement jsonElement = context.serialize(obj);
				jsonObject.add(pd.getKey(),jsonElement);
			}
		}
		return jsonObject;
		
	}
	
	public JsonArray generateJsonArray( Object[] obj){
		Class<?> clz = obj.getClass().getComponentType();
		JsonArray jsonArray = new JsonArray();	
		try {
			Object elementObj = Class.forName(clz.toString());
			if (elementObj instanceof String) {
				for(String str : (String[])obj){
					jsonArray.add(str);
				}
			}
			
			if(elementObj instanceof Number){
				for(Number num : (Number[])obj){
					jsonArray.add(num);
				}
			}
			if (elementObj instanceof Boolean) {
				for(Boolean ch : (Boolean[])obj){
					jsonArray.add(ch);
				}
			}
			
			if (elementObj instanceof Character) {
				for(Character ch : (Character[])obj){
					jsonArray.add(ch);
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return jsonArray;
	}
	

}
