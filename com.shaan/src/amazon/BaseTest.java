package amazon;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
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
import org.openqa.selenium.remote.DesiredCapabilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest 
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
			System.setProperty("webdriver.edge.driver", projectPath + "//drivers//msedgedriver.exe");
			EdgeOptions options = new EdgeOptions();
			
			
			
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("disable-infobars", true);
			caps.setCapability("--disable-notifications", true);
			
			driver = new EdgeDriver(options);
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
	
	
	//*********************************************************************************
	
	public static void selectElement(String locator, String selectItem)
	{
		getElement(locator).sendKeys(selectItem);
	}
	
	public static void enterText(String locator, String textVal)
	{
		getElement(locator).sendKeys(textVal);
	}
	
	
	public static void clickElement(String locator)
	{
		getElement(locator).click();
	}
	
	
	
	
	//********************************************************************************
	
	public static void getScreenShot() throws Exception
	{
		 File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 FileHandler.copy(screen, new File("C:\\Users\\shahe\\OneDrive\\Desktop\\Screenshots\\"+d +".png"));
		 
		 test.log(LogStatus.INFO, "Screen Shot -->" + test.addScreenCapture("C:\\Users\\shahe\\OneDrive\\Desktop\\Screenshots\\"+d +".png"));
	}
	
	//*******************************************************************************
	
	public static void varifyLink(String linkText, String expLink) throws Exception 
	{
		
		String actLink =driver.findElement(By.linkText(linkText)).getAttribute("innerHTML");
		if(actLink.equalsIgnoreCase(expLink))
		{
			
			successReport();
		}
		else
		{
			failureReport();
		}
		
	}

	public static void failureReport() throws Exception
	{
		test.log(LogStatus.FAIL, "Link is not equal.");
		getScreenShot();
		
		
	}

	public static void successReport() 
	{
		test.log(LogStatus.PASS, "Link is equal.");
		
	}

	
	
}
