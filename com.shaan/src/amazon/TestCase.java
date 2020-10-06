package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestCase extends BaseTest{

	public static void main(String[] args) throws Exception {
		init();
	//	System.setProperty("webdriver.chrome.driver", projectPath + "//chromedriver.exe");
	//	WebDriver driver = new ChromeDriver();
	//	driver.get("https://amazon.com");
		launchBrowser("edgeBrowser");
		System.out.println(prop.getProperty("edgeBrowser"));
		navigateUrl("axisbankUrl");
		WebElement popupWindow = driver.findElement(By.xpath("//div[@class='close_button']//span[contains(text(),'X')]"));
		if(popupWindow.isDisplayed())
		{
			popupWindow.click();
		}
		else 
		{
			System.out.println("No popup window displayed.");
		}
	


	}

}
