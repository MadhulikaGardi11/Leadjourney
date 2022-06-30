package com.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown {

	public RemoteWebDriver driver;

	//@Test
	public void staticDropDown() {

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(option);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://www.spicejet.com/");
		driver.findElement(By.xpath("(//*[name()='svg'][@data-testid='svg-img'])[16]")).click();

		System.out.println(driver
				.findElement(By.xpath("(//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep'])[5]")).getText());

		for (int i = 1; i < 5; i++) {
			driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-k8qxaj r-d9fdf6']//div[1]//div[2]//div[3]"))
					.click();
		}

		for (int i = 0; i < 2; i++) {

			driver.findElement(By.xpath(" (//*[name()='svg'][@data-testid='svg-img'])[21]")).click();
		}

		driver.findElement(By.xpath("//div[@class=\"css-1dbjc4n r-obd0qt r-k8qxaj r-d9fdf6\"]/div")).click();
		System.out.println(driver
				.findElement(By.xpath("(//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep'])[5]")).getText());

		driver.findElement(By.xpath("//div[@class=\"css-1dbjc4n r-18u37iz r-1g40b8q\"]/div/div[1]/div[1]")).click();
		driver.findElement(By.xpath("(//div[contains(text(),'Pune')])[1]")).click();
		driver.findElement(By.xpath("(//div[contains(text(),'Goa')])[2]")).click();

		driver.findElement(By.xpath("//div[@data-testid=\"undefined-month-June-2022\"]/div[3]/div[3]/div[5]/div/div"))
				.click();
		driver.findElement(By.xpath("(//div[@class=\"css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep\"])[4]")).click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//div[@data-testid=\"undefined-month-July-2022\"]/div[3]/div[2]/div[7]/div/div"))
				.click();
	}

	// @Test
	public void dynamicDropDrown() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.get("https://www.myntra.com/");

		Actions action = new Actions(driver);
		WebElement Womnebtn = driver.findElement(By.xpath("//a[contains(text(),'Women')]"));
		action.moveToElement(Womnebtn).perform();
		driver.findElement(
				By.xpath("//a[contains(text(),'Beauty & Personal Care')]/parent::li/following-sibling::li/a")).click();
		driver.findElement(By.xpath(" //div[@class='vertical-filters-filters categories-container']//li[8]//label[1]"))
				.click();
		System.out.println(
				driver.findElement(By.xpath("//h4[contains(text(),'Matte and Pearly Gloss 8 ml')]")).getText());
		System.out.println(driver.findElement(By.xpath(
				"//div[@class=\"search-searchProductsContainer row-base\"]/section/ul/li[2]/a/div[2]/div/span/span[1]"))
				.getText());

	}

	//@Test
	public void autoSuggestedDropDownDemo() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise");
		
		driver.findElement(By.id("autosuggest")).sendKeys("Aust");
		Thread.sleep(3000);
		List<WebElement> options=driver.findElements(By.xpath("//li[@class=\"ui-menu-item\"]/a"));

		for(WebElement option : options) {
			
			if(option.getText().equalsIgnoreCase("Austria")) {
				option.click();
				break;
			}
		}
	}
	@Test
	public void execrsise1(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("checkBoxOption1")).click();
		System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());
		driver.findElement(By.id("checkBoxOption1")).click();
		System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());
		
		
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
	}

}
