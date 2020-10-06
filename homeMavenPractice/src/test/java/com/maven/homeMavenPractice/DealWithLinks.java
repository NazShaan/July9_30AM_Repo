package com.maven.homeMavenPractice;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DealWithLinks extends TestBasics
{

	public static void Links() throws Exception
	{
		init();
	//ExcelAPI e = new ExcelAPI("C:\\Users\\shahe\\Documents\\Links.xlsx");
	
	launchBrowser("chromeBrowser");
	navigateUrl("amazonUrl");
	List<WebElement> hlinks = driver.findElements(By.cssSelector("div#nav-xshop a"));
	//List<WebElement> allLinks = driver.findElements(By.tagName("a"));
	System.out.println(hlinks.size());
	Iterator<WebElement> links = hlinks.iterator();
	while(links.hasNext())
	{
		//System.out.println(links.next().getAttribute("innerHTML"));
		System.out.println(links.next().getText());
		
	}
	}
	public static void main(String[] args) throws Exception {
		Links();
		fis.close();
	}
	
}
