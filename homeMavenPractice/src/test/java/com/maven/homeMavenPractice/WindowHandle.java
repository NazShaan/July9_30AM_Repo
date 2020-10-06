package com.maven.homeMavenPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle 
{
	 public static void windowHandle()
	 {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\shahe\\OneDrive\\Desktop\\SeleniumNote\\Misc\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("http://www.hdfcbank.com");
			
	 }

}
