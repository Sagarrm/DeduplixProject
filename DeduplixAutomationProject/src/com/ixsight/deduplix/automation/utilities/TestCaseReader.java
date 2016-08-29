package com.ixsight.deduplix.automation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class TestCaseReader {
	
	public static String[][] readTestCases() throws IOException{
		
		FileInputStream inps = new FileInputStream(new File("D:/Personal/Learning/DeduplixAutomationProject/testdata/Automation_TestCaseDocument.xls"));
		Workbook testCaseFile = new HSSFWorkbook(inps);
		
		Sheet sheet = testCaseFile.getSheet("Legacy Cluster");
		int rowCount = sheet.getLastRowNum();
		int fieldCount = sheet.getRow(0).getPhysicalNumberOfCells();
		
		System.out.println("No of Rows & fields: "+rowCount +"    "+fieldCount);
		String testCases[][] = new String[rowCount][fieldCount];
		
		for(int rowNum = 1;rowNum<=rowCount;rowNum++){
			for(int colNum = 0;colNum<fieldCount;colNum++){
				testCases[rowNum-1][colNum] = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			}
		}
		testCaseFile.close();
		
		return testCases;
		
		
	}
	
}
