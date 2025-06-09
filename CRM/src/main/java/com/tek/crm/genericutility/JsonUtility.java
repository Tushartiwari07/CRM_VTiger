package com.tek.crm.genericutility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {
	public String getDataFromJson(String key) throws FileNotFoundException, IOException, ParseException
	{
		JSONParser jsp= new JSONParser();
		Object obj = jsp.parse(new FileReader(".\\src\\test\\resources\\VtigerTestData.json"));
		JSONObject jobj=(JSONObject)obj;
		String value = jobj.get(key).toString();
		return value;
	}

}
