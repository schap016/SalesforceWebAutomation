package utils;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import utils.PropertiesReader;

public class GlobalVariables{	
	
	public static String URL = null;
	public static String adminUserName = null;
	public static String adminPassword = null;
	public static String salesUserName = null;
	public static String salesPassword = null;
	
	public static Map<String, String> User = null;
	
	public static Map<String,List<String>> testdata = null;
	
	public static void getGlobalVariables(Map<String,List<String>> data, Map<String,String> user) throws IOException{
		
		PropertiesReader props = new PropertiesReader();
		
		Hashtable<Object,Object> props1 = props.getProperties();
		
		URL = (String) props1.get("URL");
		adminUserName = (String) props1.get("AdminUserName");
		adminPassword = (String) props1.get("AdminPassword");
		salesUserName = (String) props1.get("SalesUser");
		salesPassword = (String) props1.get("SalesUserPassword");		
		testdata = data;
		User = user;
		
		
			
	}
	
		
	
}