package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class DataFile {

	
	
	 public static void createSuiteAndDataMap(List<XmlSuite> suites, Map<String,List<String>> data, Map<String, String> users) {
		 String filePath = "C:\\SmokeObservations.xlsx";
			List<String> classNamesTestNames = new ArrayList<String>();
			classNamesTestNames = GetData.getClassNamesTestNames("TestNames", "ClassName", filePath);
			
			// Create Suite Object 
			XmlSuite xmlSuite = new XmlSuite();
			xmlSuite.setName("TestNgSeleniumSuite");
			xmlSuite.setParallel("false");

			for (int i = 0; i < classNamesTestNames.size(); i += 4) {
				
				String variables = classNamesTestNames.get(i+2);
				
				String user = classNamesTestNames.get(i+3);
				
				List<String> dataVariables  = Arrays.asList(variables.split(";"));
							
				
				XmlTest xmlTest = new XmlTest(xmlSuite);
				xmlTest.setName(classNamesTestNames.get(i + 1));

				// create class object and hook it to test object 
				XmlClass xmlClass = new
				XmlClass(classNamesTestNames.get(i));
				
				// populate data object
				data.put(classNamesTestNames.get(i+1), dataVariables);
				

				//populate user map
				users.put(classNamesTestNames.get(i+1),user);
				
				// create testMethod based on testNames and hook it to class object 
				XmlInclude
				method = new XmlInclude(classNamesTestNames.get(i + 1));

				List<XmlInclude> testMethods = new ArrayList<XmlInclude>();
				testMethods.add(method);
				xmlClass.setIncludedMethods(testMethods);

				List<XmlClass> xmlClasses = new ArrayList<XmlClass>();
				xmlClasses.add(xmlClass);
				xmlTest.setXmlClasses(xmlClasses);
		 
		
			}

			suites.add(xmlSuite);
		
			//return suites;
			
	 }
	
}
