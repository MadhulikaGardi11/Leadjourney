package com.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentNo6 {

	public RemoteWebDriver driver;

	@Test
	public void assign6() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

		driver.get("https://rahulshettyacademy.com/AutomationPractice");
		driver.findElement(By.id("checkBoxOption2")).click();
		String nameofcheckbox = driver.findElement(By.xpath("//label[@for=\"benz\"]")).getText();
		System.out.println(nameofcheckbox);

		List<WebElement> list =driver.findElements(By.xpath("//select[@id=\"dropdown-class-example\"]//option"));
		for(int i=0;i<list.size();i++) {
			
			String dropdownlist=list.get(i).getText();
			
			if(nameofcheckbox.contains(dropdownlist)) {
				
				list.get(i).click();
				
			}
		}
		
		driver.findElement(By.xpath("//input[@name=\"enter-name\"]")).sendKeys(nameofcheckbox);
		driver.findElement(By.id("alertbtn")).click();
		String text=driver.switchTo().alert().getText();
		
		System.out.println(text);
		String altname=text.split(", ")[0].split(" ")[1];
		System.out.println(altname); 
		
		if(text.contains(nameofcheckbox)) {
			
			driver.switchTo().alert().accept();
		}else {
			
			System.out.println("wrong Alert.........");
		}
		
		
	}

}
