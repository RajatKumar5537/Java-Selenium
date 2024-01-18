package com.AutomationJiviewsGeneric;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class configUtility {
	/**
	 * class using for read the data from properties file.
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public static String getCongigPropertyData(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream("./Configure/jiviLoginCredential.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String data = prop.getProperty(key);
		return data;
	}
}
