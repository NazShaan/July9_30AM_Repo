package com.maven.homeMavenPractice;

import org.openqa.selenium.By;

public class CrossBrowserTest extends TestBasics{

	public static void main(String[] args) throws Exception {
		init();
		launchBrowser("edgeBrowser");
		System.out.println(prop.getProperty("edgeBrowser"));
		driver.get("https://www.axisbank.com");
	//	WebElement popupWindow = driver.findElement(By.xpath("//div[@class='close_button']//span[contains(text(),'X')]"));
		if(driver.findElement(By.xpath("//div[@class='close_button']//span[contains(text(),'X')]")).isDisplayed())
		{
			driver.findElement(By.xpath("//div[@class='close_button']//span[contains(text(),'X')]")).click();
		}
		else 
		{
			System.out.println("No popup window displayed.");
		}
	

	}

}
