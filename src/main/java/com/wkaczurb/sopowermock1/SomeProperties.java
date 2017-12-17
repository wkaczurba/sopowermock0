package com.wkaczurb.sopowermock1;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class SomeProperties {
	
	private static Properties props = new Properties();

	static {
		URL url = SomeProperties.class.getResource("some.properties");
		System.out.println("url" + url.getPath());
		
		InputStream is = SomeProperties.class.getResourceAsStream("some.properties");
		
		try {
			System.out.println("Properties.staticBlock got ResoursceStream");
			props.load(is);
		} catch (IOException e) {
			System.out.println("Properties.staticBlock: IOException");
			// How test this branch???
			e.printStackTrace();
		}
	}
	
	public static String getVersion() {
		return props.getProperty("version");
	}
	
	// ...
}
