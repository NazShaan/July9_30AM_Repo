package com.maven.homeMavenPractice;

import com.relevantcodes.extentreports.LogStatus;

public class AmazonVerifyLink extends TestBasics
{
	
	public static void main(String[] args) throws Exception {
		init();
		test = report.startTest("AmazonVerifylink");
		test.log(LogStatus.INFO, "initilizing the extent report......");
		test.log(LogStatus.INFO, "initilizing the init all properties and methods..");
		launchBrowser("chromeBrowser");
		test.log(LogStatus.INFO, "launched the browser " + prop.getProperty("chromeBrowser"));
		navigateUrl("amazonUrl");
		
		if(verifyLink("New Release"))
		{
			reportSuccess("both link are equals");
		}
		else
		{
			reportFailure("links are not equals");
		}
		driver.quit();
		report.endTest(test);
		report.flush();
	
		
	}
}
