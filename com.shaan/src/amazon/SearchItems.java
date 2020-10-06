package amazon;

import org.apache.log4j.Logger;

import com.relevantcodes.extentreports.LogStatus;

public class SearchItems extends BaseTest
{
	private static final Logger  log = Logger.getLogger("SearchItem");
	
	public static void main(String[] args) throws Exception 
	{
		init();
		test = report.startTest("SearchItems");
		test.log(LogStatus.INFO, "Initilize the init method...");
		log.info("Initiliaze the init method...........");
		
		launchBrowser("chromeBrowser");
		log.info("launched the "+prop.getProperty("chromeBrowser") +" browser");
		test.log(LogStatus.INFO, "launched the browser " + prop.getProperty("chromeBrowser"));
		
		navigateUrl("amazonUrl");
		log.info("navigated to " + childInstance.getProperty("amazonUrl"));
		test.log(LogStatus.INFO, "navigate to amazon ");
		
		String expLink = "Best Seller";
		//varifyLink("Best Sellers", expLink);
	//	driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
	//	driver.findElement(By.name("field-keywords")).sendKeys("Java Core");
	//	driver.findElement(By.xpath("//input[@class='nav-input']")).click();
			
			selectElement("amazonDropDown_id", "Books");
			log.info("select the dropdown by locator key " + loc.getProperty("amazonDropDown_id"));
			
			enterText("amazonEnterText_name", "Core Java Books");
			log.info("entered the text 'Core Java Books' by locator key " + loc.getProperty("amazonEnterText_name"));
			
			clickElement("amazonClickElement_xpath");
			log.info("click on elements by locator key " + loc.getProperty("amazonClickElement_xpath"));
			getScreenShot();
			
			
		
		driver.close();
		log.info("closed the Browser");
		
		fis.close();
		log.info("close the fileinpusystem");
		
		report.endTest(test);
		report.flush();
		
	}

	

}
