package com.practice;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignments {

	public RemoteWebDriver driver;

	// @Test
	public void assign1() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/angularpractice");

		driver.findElement(By.name("name")).sendKeys("Madhulika Gardi");
		driver.findElement(By.name("email")).sendKeys("gardimadhulika@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("Madhu1234");
		driver.findElement(By.className("form-check-input")).click();
		WebElement ele = driver.findElement(By.id("exampleFormControlSelect1"));
		Select option = new Select(ele);
		option.selectByVisibleText("Female");
		driver.findElement(By.xpath("//input[@value=\"option1\"]")).click();
		driver.findElement(By.name("bday")).clear();
		driver.findElement(By.name("bday")).sendKeys("01-11-1996");
		driver.findElement(By.xpath("//input[@Value=\"Submit\"]")).click();

		System.out.println(
				driver.findElement(By.xpath("//div[@class=\"alert alert-success alert-dismissible\"]")).getText());
	}

	@Test
	public void dynamicwebElement() throws InterruptedException {

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(option);

		String[] vegetablestoAdd = { "Cucumber", "Beetroot", "Brinjal", "Tomato", "Pista" };
		int j=0;
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		List vegIteams = Arrays.asList(vegetablestoAdd);
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		List<WebElement> items = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < items.size(); i++) {

			String[] itemsToBeAdded = items.get(i).getText().split("-");
			String veggies = itemsToBeAdded[0].trim();

			
			if (vegIteams.contains(veggies)) {
				j++;

				driver.findElements(By.cssSelector("div.product-action")).get(i).click();
				
				if(j==vegetablestoAdd.length) {
					break;
				}

			}
		}
		
		driver.get("https://www.myntra.com/");
		Actions action = new Actions(driver);
		WebElement women=driver.findElement(By.xpath("(//a[@href=\"/shop/women\"])[1]"));
		action.moveToElement(women).perform();
		
		String tshirtsname [] = {"H&M", "Nautica"};
		List girlsTShirt = Arrays.asList(tshirtsname);
		
		driver.findElement(By.xpath("(//a[contains(text(),\"Tshirts\")])[1]")).click();
		List<WebElement> name=driver.findElements(By.cssSelector("h3.product-brand"));
		
		System.out.println(name.size());
		
		for(int i=0;i<name.size();i++) {
			
			String tshirts = name.get(i).getText();
			
			if(girlsTShirt.contains(tshirts)) {
			
			Thread.sleep(2000);
			driver.findElements(By.cssSelector("img.img-responsive")).get(i).click();
				
			}
			
		}

	}
	
	
}
