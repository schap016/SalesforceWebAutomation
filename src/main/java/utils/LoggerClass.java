package utils;
 import org.apache.logging.log4j.LogManager;
 import org.apache.logging.log4j.Logger;
 
 
 
public class LoggerClass {
	
	//private static Logger logger = LogManager.getLogger(LoggerClass.class);
	
	public static void logInfoMessage(String string, Logger logger) {
		// TODO Auto-generated method stub

		logger.info(string);

	}
	
	public static void logErrorMessage(String string, Logger logger) {
		// TODO Auto-generated method stub

		logger.error(string);

	}
	

}
	