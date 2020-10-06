package com.maven.homeMavenPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeDriverOptions {

	public static void main(String[] args) {
		// to work with the Edge browser we need to use the selenium version  4.0.0-alpha-5 and above maybe.
		//because form that version the addarguments working with options.
		System.setProperty("webdriver.edge.driver", "C:\\Users\\shahe\\Documents\\SeleniumNote\\msedgedriver.exe");
		EdgeOptions options = new EdgeOptions();
		
		//to specify the actual profile folder
		options.addArguments("user-data-dir=C:\\Users\\shahe\\AppData\\Local\\Microsoft\\Edge\\User Data\\Profile 1");
		
		//to maximized & disable web notifications
		options.addArguments("--start-maximized");
		options.addArguments("--disable-notifications");
		
		WebDriver driver = new EdgeDriver(options);
		
		driver.get("https://www.axisbank.com");
		
		System.out.println("Test successful");
		driver.quit();
	
	}
}
