package com.practice;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentsNo5 {

	public RemoteWebDriver driver;

	@Test
	public void assign5() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[@href=\"/nested_frames\"]")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src=\"/frame_top\"]")));
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src=\"/frame_middle\"]")));
		System.out.println(driver.findElement(By.cssSelector("div#content")).getText());

		// open URL in differant TAB............
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.cssSelector("div#gf-BIG a")).size());
		List<WebElement> url = driver.findElements(By.xpath("//table[@class=\"gf-t\"]//tr//td[3 ]//a"));
		System.out.println(url.size());
		for (int i = 1; i < url.size(); i++) {

			String clickonurl = Keys.chord(Keys.CONTROL, Keys.ENTER);
			driver.findElements(By.xpath("//table[@class=\"gf-t\"]//tr//td[3]//a")).get(i).sendKeys(clickonurl);
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		Set<String> handlers = driver.getWindowHandles();
		Iterator<String> itr = handlers.iterator();
		while (itr.hasNext()) {

			driver.switchTo().window(itr.next());
			System.out.println(driver.getTitle());
		}
	}
}
