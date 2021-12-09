package util;

import java.io.FileInputStream;
import java.util.Properties;

public class DataProvider {
	
	public static String getTestData(String propfile, String propname) {
		Properties props = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(propfile);
			props.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return props.getProperty(propname);
	}
}
