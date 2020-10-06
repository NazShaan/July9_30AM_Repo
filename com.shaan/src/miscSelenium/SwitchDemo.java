package miscSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import amazon.BaseTest;

public class SwitchDemo extends BaseTest{

	public static void main(String[] args) throws Exception {
		
		init();
		launchBrowser("edgeBrowser");
		navigateUrl("seleniumApi");
		
		WebElement frame1 = driver.findElement(By.xpath("//frame[@name='packageListFrame']"));
		driver.switchTo().frame(frame1);
		
		driver.findElement(By.linkText("java.util")).click();
		driver.switchTo().defaultContent();
		
		

	}

}
