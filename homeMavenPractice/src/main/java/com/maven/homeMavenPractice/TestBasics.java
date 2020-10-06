package com.maven.homeMavenPractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class TestBasics 
{
	public static WebDriver driver;
	public static String projectPath = System.getProperty("user.dir");
	
	public static Properties prop;
	public static FileInputStream fis;
	public static Properties parentInstance;
	public static Properties childInstance;
	public static Properties loc;
	public static WebElement element;
	public static String d;
	public static ExtentTest test;
	public static ExtentReports report;
	public static Properties log4j;
	
	//*********************************************************************
	
	public static void init() throws Exception
	{
		fis = new FileInputStream(projectPath + "//data.properties");
		prop = new Properties();
		prop.load(fis);
		
		fis = new FileInputStream(projectPath + "//environment.properties");
		parentInstance = new Properties();
		parentInstance.load(fis);
		
		String e = parentInstance.getProperty("env");
		
		fis = new FileInputStream(projectPath + "//" +e +".properties");
		childInstance = new Properties();
		childInstance.load(fis);
		
		fis = new FileInputStream(projectPath + "//locators.properties");
		loc = new Properties();
		loc.load(fis);
		
		fis = new FileInputStream(projectPath + "//log4jConfigurator.properties");
		PropertyConfigurator.configure(fis);
		
		report =ExtentManager.getInstance();
	}
	
	static 
	{
		Date dt = new Date();
		 d = dt.toString().replace(" ", "_").replace(":", "_");
	}
	
	
	
	//**********************************************************************
	public static void launchBrowser(String browserName)
	{
		if(prop.getProperty(browserName).equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", projectPath + "//drivers//chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("user-data-dir=C:\\Users\\shahe\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 2");
			options.getBrowserName();
			options.addArguments("start-maximized");
			//to set download directory
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("download.default_directory", projectPath +"//drivers");
			options.setExperimentalOption("prefs", prefs);
			//to disable web notifications
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
			
		}
		else if (prop.getProperty(browserName).equals("firefuox"))
		{
			System.setProperty("webdriver.gecko.driver", projectPath + "//drivers//geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(prop.getProperty(browserName).equals("edge"))
		{
	
			// to work with the Edge browser we need to use the selenium version  4.0.0-alpha-5 and above maybe.
			//because form that version the addarguments working with options.
			//System.setProperty("webdriver.edge.driver", projectPath + "//drivers//msedgedriver.exe");
			System.setProperty("webdriver.edge.driver", "C:\\Users\\shahe\\OneDrive\\Desktop\\SeleniumNote\\msedgedriver.exe");
			EdgeOptions options = new EdgeOptions();
			
			//to specify the actual profile folder
			options.addArguments("user-data-dir=C:\\Users\\shahe\\AppData\\Local\\Microsoft\\Edge\\User Data\\Profile 1");
			
			//to maximized & disable web notifications
			options.addArguments("--start-maximized");
			options.addArguments("--disable-notifications");
			
			WebDriver driver = new EdgeDriver(options);
		}
		
		
		
	}
	
	//************************************************************************

	public static void navigateUrl(String urls) 
	{
			//driver.manage().window().maximize();
			driver.get(childInstance.getProperty(urls));
	}
	
	//************************************************************************
	
	
	public static WebElement getElement(String locator_id)
	{
			if(locator_id.endsWith("_id"))
			{
				element = driver.findElement(By.id(loc.getProperty(locator_id)));
			}
			else if(locator_id.endsWith("_class"))
			{
				element =driver.findElement(By.className(loc.getProperty(locator_id)));
			}
			else if(locator_id.endsWith("_name"))
			{
				element =driver.findElement(By.name(loc.getProperty(locator_id)));
			}
			else if(locator_id.endsWith("_xpath"))
			{
				element =driver.findElement(By.xpath(loc.getProperty(locator_id)));
			}
			else if(locator_id.endsWith("_css"))
			{
				element =driver.findElement(By.cssSelector(loc.getProperty(locator_id)));
			}
			else if(locator_id.endsWith("_linkText"))
			{
				element =driver.findElement(By.linkText(loc.getProperty(locator_id)));
			}
			else if(locator_id.endsWith("_partialLinkText"))
			{
				element =driver.findElement(By.partialLinkText(loc.getProperty(locator_id)));
			}
			return element;
			
			
	}
	
		public static boolean verifyLink(String expectedLink) 
		{
			String actualLink = driver.findElement(By.linkText("New Releases")).getAttribute("innerHTML");
			if(expectedLink.equals(actualLink))
				return true;
			else
			return false;
		}
	
	public static void getScreenShot() throws Exception
	{
		
		Date dt=new Date();
		System.out.println(dt);
		String dateFormat=dt.toString().replace(":", "_").replace(" ", "_")+".png";		
		File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(scrFile, new File(projectPath+"\\Screens\\"+dateFormat));
		
		test.log(LogStatus.INFO, "Screenshot --->" +test.addScreenCapture(projectPath+"\\Screens\\"+dateFormat));
	}
	
		public static void reportFailure(String failureMsg) throws Exception 
		{
			
			test.log(LogStatus.FAIL, failureMsg);
			getScreenShot();
		}

		public static void reportSuccess(String successMsg) throws Exception {
			
			System.out.println(successMsg);
			
		}
		

	

}
