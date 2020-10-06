package com.maven.homeMavenPractice;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmazonLandingPage extends TestBasics
{
	// to create a object of Logger class
	private static final Logger log = Logger.getLogger(AmazonLandingPage.class);
	
	@BeforeTest
	  public void beforeTest() throws Exception 
	{
		init();
		log.info("Initilizing the init methods............");
		
		launchBrowser("chromeBrowser");
		log.info("Launched the browser name " + prop.getProperty("chromeBrowser"));
		
		navigateUrl("amazonUrl");
		log.info("navigated to "+ childInstance.getProperty("amazonUrl"));
	  }
	
  @Test
  public void verifyLink() throws Exception
  {
	  String expectedLink = "New Release";		
		if(!verifyLink(expectedLink))
		{
			reportFailure("Both links are not equal....");
			log.info("Both links are equal..");
		}
		else
		{
			reportSuccess("Both links are equal....");
			log.info("Both links are equal...");
		}
  }
  

@AfterTest
  public void afterTest() throws Exception 
  {
	  driver.close();
	  fis.close();
  }
  		
}
