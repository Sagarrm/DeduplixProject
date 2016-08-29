package com.ixsight.deduplix.automation.utilities;

import java.net.MalformedURLException;

import com.j2bugzilla.base.Bug;
import com.j2bugzilla.base.BugFactory;
import com.j2bugzilla.base.BugzillaConnector;
import com.j2bugzilla.base.BugzillaException;
import com.j2bugzilla.base.ConnectionException;
import com.j2bugzilla.rpc.LogIn;
import com.j2bugzilla.rpc.ReportBug;

public class BugLogger {

	//public String bugZillaURL = "";
	
	public static void logBug(String testCaseID,String moduleName) throws ConnectionException, BugzillaException, MalformedURLException {
		
		BugzillaConnector conn = new BugzillaConnector();
		conn.connectTo("http://192.168.2.101/bugzilla/");
		
		LogIn logIn = new LogIn("sagar.mhetre@afourtech.com", "sagarm42");
		
		conn.executeMethod(logIn);
	
		Bug bug = new BugFactory().newBug()
				.setProduct("IxSight")
				.setComponent("Legacy Cluster")
				.setOperatingSystem("Windows 7")
				.setPlatform("PC")
				.setVersion("1.8.2")
				.setDescription("Failed testcase id: "+testCaseID)
				.setSummary("Failed module "+moduleName)
				.createBug();
		
		ReportBug report = new ReportBug(bug);
		conn.executeMethod(report);
		
		System.out.println("Bug ID: "+report.getID());
	}
	
}
