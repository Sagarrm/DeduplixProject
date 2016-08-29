package com.ixsight.deduplix.automation.testscripts;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ixsight.deduplix.automation.utilities.BugLogger;
import com.ixsight.deduplix.automation.utilities.TestCaseReader;
import com.j2bugzilla.base.Bug;
import com.j2bugzilla.base.BugFactory;
import com.j2bugzilla.base.BugzillaConnector;
import com.j2bugzilla.base.BugzillaException;
import com.j2bugzilla.base.ConnectionException;
import com.j2bugzilla.rpc.LogIn;
import com.j2bugzilla.rpc.ReportBug;

public class LegacyCluster {
	
	@Test(dataProvider = "Testcase reader")
	public void preprocessMatch(String testCaseID,String projectName,String mode,String basetable,String inputtable,String moduleName,String subFeature,String PreprocessedStatus,String rule,String crossMatching ,String blocking,String matchedStatus,String testScenario,String dictionaries,String expected,String actual,String benchMarkingVesrionBaseBuildPath,String testingVersionCurrentBuildPath,String status,String pathForProjectFilesDedupliCurrent,String pathForProjectFilesDedupliBase,String CreatedBy ) throws ConnectionException, BugzillaException, MalformedURLException{
		
		if(testCaseID.equals("AUTO_TC_8")){
			System.out.println("Failed");
			BugLogger.logBug(testCaseID,moduleName);
			
		}
		
	}
	
	@DataProvider(name= "Testcase reader")
	public Object[][] readTestCases() throws IOException{
		System.out.println("In data provider");
		String testcases[][] = TestCaseReader.readTestCases();
		
		return testcases;
	}
}
