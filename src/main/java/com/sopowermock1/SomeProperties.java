package com.sopowermock1;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SomeProperties {
	
	private static Properties props = new Properties();

	static {
		InputStream is = SomeProperties.class.getResourceAsStream("/some.properties");
		
		try {
			props.load(is);
			System.out.println("Properties.props.keySet() = " + props.keySet());			
		} catch (IOException e) {
			// How test this branch???
			System.out.println("Yes. We got here.");
			throw new RuntimeException(e);
		}
	}
	
	private SomeProperties() {}; // to makes life even harder...
	
	public static String getVersion() {
		return props.getProperty("version");
	}
}
