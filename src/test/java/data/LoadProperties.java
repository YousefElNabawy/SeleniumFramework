package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties 
{
	// Load the properties file from the folder
	
	static String Path = System.getProperty("user.dir") + "\\src\\main\\java\\properties\\userdata properties";
	
	public static Properties userData = loadProperties(Path);

	private static Properties loadProperties(String path) 
	{
		Properties pro = new Properties();
		
		// Stream for reading file
		
		try {
			FileInputStream stream = new FileInputStream(path);
			pro.load(stream);
		} catch (FileNotFoundException e) {
			System.out.println("Error occurred: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error occurred: " + e.getMessage());
		}
		return pro;
	}
	
	
	
}
