package com.tek.crm.genericutility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	public String getDataFromProperties(String key) throws Exception
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.get(key).toString();
		return value;
	}

}
