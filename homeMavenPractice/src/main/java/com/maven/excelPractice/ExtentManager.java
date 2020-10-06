package com.maven.excelPractice;

import java.io.File;

import com.maven.homeMavenPractice.TestBasics;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager  extends TestBasics
{
	public static ExtentReports report;
	public static ExtentReports getInstance()
	{
		if(report==null)
		{
		 report = new ExtentReports(projectPath + "//" +d+".html" );
		 report.loadConfig(new File(projectPath + "//extentReportsConfig.xml"));
		report.addSystemInfo("Selenium language bindings" , "3.14").addSystemInfo("Environment", parentInstance.getProperty("env"));
		
		}
		 return  report;
	}
}
