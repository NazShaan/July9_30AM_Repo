package com.maven.homeMavenPractice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsAlert 
{
	public static void windowAlerts() throws Exception
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shahe\\OneDrive\\Desktop\\SeleniumNote\\Misc\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://transfer.pcloud.com");
		driver.manage().window().maximize();
		//Click on the addFile link
		//driver.findElement(By.xpath("//span[@data-translate='click_to_add_files'][@xpath='1']")).click();
		 driver.findElement(By.xpath("//span[contains(text(),'Click here to add files')]")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\shahe\\OneDrive\\Desktop\\uploadfile.exe");
		
		
	}
	public WindowsAlert()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shahe\\OneDrive\\Desktop\\SeleniumNote\\Misc\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.get("https://www.facebook.com");
	}
	
	public static void javaSrptExec()
	{
		
	}
	
	public static void main(String[] args) throws Exception {
		//WindowsAlert.windowAlerts();
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shahe\\OneDrive\\Desktop\\SeleniumNote\\Misc\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		js.executeScript("document.getElementById('email').value='nazrul.shaan@gmail.com'");
		js.executeScript("document.getElementById('pass').value='bangla'");
		js.executeScript("document.getElementById('u_0_b').click()");
		//WebElement element = driver.findElement(By.id("u_0_f"));
		//js.executeScript("document.getElementById('u_0_f').click();");
		//js.executeScript("arguments[0].click();", element);
		//js.executeScript("arguments[0].click();", element);
		//driver.findElement(By.xpath("//button[@id='u_0_b']")).click();
	}
}
