package com.practice;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentNo3 {

	public RemoteWebDriver driver;

	@Test
	public void assign3() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		String name [] = {"iphone","Samsung" , "Nokia" , "Blackberry"};
		 List mobilename = Arrays.asList(name);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/loginpagePractise");
		driver.findElement(By.cssSelector("input#username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("input#password")).sendKeys("learning");
		driver.findElement(By.xpath("//input[@value=\"user\"]")).click();
		// driver.switchTo().alert().dismiss();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("okayBtn")));
		driver.findElement(By.cssSelector("button#okayBtn")).click();
		WebElement list = driver.findElement(By.xpath("//select[@class=\"form-control\"]"));
		Select option = new Select(list);
		option.selectByVisibleText("Consultant");
		driver.findElement(By.cssSelector("input#terms")).click();
		driver.findElement(By.xpath("//input[@value=\"Sign In\"]")).click();
		
		List<WebElement> mobiles=driver.findElements(By.xpath("//h4[@class=\"card-title\"]/a"));
		
		for(int i=0;i<mobiles.size();i++) {
			
			String [] str = mobiles.get(i).getText().split(" ");
			String mbname=str[0].trim();
			System.out.println(mbname);
			
			if(mobilename.contains(mbname)) {
			
				driver.findElements(By.xpath("//button[@class=\"btn btn-info\"]")).get(i).click();
			}
			
		}
		
		driver.findElement(By.xpath("//a[@class=\"nav-link btn btn-primary\"]")).click();
		driver.findElement(By.xpath("//button[@class=\"btn btn-success\"]")).click();

	}

}
