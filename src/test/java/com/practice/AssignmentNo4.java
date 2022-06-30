package com.practice;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentNo4 {
	
	public RemoteWebDriver driver;

	@Test
	public void assign4() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[@href=\"/windows\"]")).click();
		driver.findElement(By.xpath("//a[@href=\"/windows/new\"]")).click();
		String parentID=driver.getWindowHandle();
		Set<String>windows=driver.getWindowHandles();
		for(String window:windows) {
			
			if(!window.equalsIgnoreCase(parentID)) {
				driver.switchTo().window(window);
				break;
			}
		}
		System.out.println(driver.findElement(By.xpath("//h3")).getText());
		driver.switchTo().window(parentID);
		System.out.println(driver.findElement(By.xpath("//h3")).getText());


}
}
