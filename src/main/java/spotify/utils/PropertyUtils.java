package spotify.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {
	
	
	public static Properties propertyLoader(String filePath) {
		
		 Properties prop = new Properties();
		 BufferedReader br;
		 
		 try {
			 br = new BufferedReader(new FileReader(filePath));
			 try {
				 
				 prop.load(br);
				 br.close();
			 }catch(IOException e) {
				 throw new RuntimeException("Failed to load prop file "+ filePath);
			 }
			 
		 }
		 catch(FileNotFoundException e) {
			 throw new RuntimeException("File not found at "+ filePath);
		 }
		 return prop;
		
	}

}
