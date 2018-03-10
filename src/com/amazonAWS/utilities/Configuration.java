package com.amazonAWS.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {

	private static Properties properties;

	static {
		try {
			properties = new Properties();
			FileInputStream input = new FileInputStream("./configuration.properties");
			properties.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String key) {
		return properties.getProperty(key);

	}
}
