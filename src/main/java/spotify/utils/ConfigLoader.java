package spotify.utils;

import java.util.Properties;

public class ConfigLoader {
	
	
	private final Properties properties;
	
	private static ConfigLoader configloader;
	
	private ConfigLoader() {
		
		properties = PropertyUtils.propertyLoader("./src/test/resources/config.properties");
	}
	
	
	public static ConfigLoader getInstance() {
		
		if(configloader==null) {
			configloader = new ConfigLoader();
		}
		return configloader;
	}
	
	public  String getGrantType() {
	     
		String prop = properties.getProperty("grant_type");
		
		if(prop!=null) {
			return prop;
		}
		else throw new RuntimeException("Property grant_type is not present in the config file");
	}
	
	public  String getRefreshToken() {
	     
		String prop = properties.getProperty("refresh_token");
		
		if(prop!=null) {
			return prop;
		}
		else throw new RuntimeException("Property refresh_token is not present in the config file");
	}
	
	public  String getUserId() {
	     
		String prop = properties.getProperty("user_id");
		
		if(prop!=null) {
			return prop;
		}
		else throw new RuntimeException("Property user_id is not present in the config file");
	}

}
