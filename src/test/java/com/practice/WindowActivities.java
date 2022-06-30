package com.practice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowActivities {
	
	public RemoteWebDriver driver;
	
	@Test
	public void window() {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.get("https://www.google.com");
		driver.navigate().to("https://www.myntra.com");
		driver.navigate().back();
		driver.navigate().forward();
		
		
		
	}

}
