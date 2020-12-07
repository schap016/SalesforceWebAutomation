package utils;

import java.util.List;
import java.util.Map;


import java.io.IOException;
import java.io.PrintWriter;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.HashMap;

import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import utils.GlobalVariables;

public class TestRunner {
	
	

	 
	 //for printing stack trace 
	 
	 static private ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();

	  public static void setContentionTracing(boolean val) {
	    threadBean.setThreadContentionMonitoringEnabled(val);
	  }
	 
	  
	  private static String getTaskName(long id, String name) {
		    if (name == null) {
		      return Long.toString(id);
		    }
		    return id + " (" + name + ")";
		  }
	  
	 public static void printThreadInfo(PrintWriter stream, String title) {
		    final int STACK_DEPTH = 20;
		    boolean contention = threadBean.isThreadContentionMonitoringEnabled();
		    long[] threadIds = threadBean.getAllThreadIds();
		    stream.println("Process Thread Dump: " + title);
		    stream.println(threadIds.length + " active threads");
		    for (long tid : threadIds) {
		      ThreadInfo info = threadBean.getThreadInfo(tid, STACK_DEPTH);
		      if (info == null) {
		        stream.println("  Inactive");
		        continue;
		      }
		      stream.println("Thread " + getTaskName(info.getThreadId(), info.getThreadName()) + ":");
		      Thread.State state = info.getThreadState();
		      stream.println("  State: " + state);
		      stream.println("  Blocked count: " + info.getBlockedCount());
		      stream.println("  Waited count: " + info.getWaitedCount());
		      if (contention) {
		        stream.println("  Blocked time: " + info.getBlockedTime());
		        stream.println("  Waited time: " + info.getWaitedTime());
		      }
		      if (state == Thread.State.WAITING) {
		        stream.println("  Waiting on " + info.getLockName());
		      } else if (state == Thread.State.BLOCKED) {
		        stream.println("  Blocked on " + info.getLockName());
		        stream.println("  Blocked by "
		            + getTaskName(info.getLockOwnerId(), info.getLockOwnerName()));
		      }
		      stream.println("  Stack:");
		      for (StackTraceElement frame : info.getStackTrace()) {
		        stream.println("    " + frame.toString());
		      }
		    }
		    stream.flush();
		  }
	 
	 
	 
	 
	 
	 
	
	public static void main(String args[]) throws IOException {
				
			
		
		Map<String,List<String>> data = new HashMap<String,List<String>>(); 
		
		Map<String,String> user = new HashMap<String,String>(); 

		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		
		DataFile.createSuiteAndDataMap(suites, data, user);
		
		
		GlobalVariables.getGlobalVariables(data,user);
		

		TestNG testNg = new TestNG();

		testNg.setXmlSuites(suites);
		
		
		testNg.run();
		//TestRunner.printThreadInfo(new PrintWriter(System.out), "stackTrace");
		System.exit(0);
		
		
		
	}

}
