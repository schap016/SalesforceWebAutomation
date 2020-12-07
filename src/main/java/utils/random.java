package utils;

import java.util.Arrays;
import java.util.List;

public class random {
	
	
	
	
	public static void main(String args[]) {
		
		//String user = "10\"\" Tablet;13\" Laptop";
		
		String product = "TABLET10";
		
		
		String xpath = "//span[contains(text(),'"+product+"')]"+"/../../preceding-sibling::th";
		
		//List<String> arrs = Arrays.asList(user.split(";"));
		
		//System.out.println(arrs);
		
		
		
		System.out.println(xpath);
	}

}
