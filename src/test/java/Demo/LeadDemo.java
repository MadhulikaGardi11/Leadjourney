package Demo;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.DataDriven.ExcelUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeadDemo extends ChromeLaunch {

	@Test
	public void LoginPage() throws InterruptedException, EncryptedDocumentException, IOException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

		driver.findElement(By.cssSelector("input#TxtName")).sendKeys(ExcelUtility.getPUData(1, 0));
		driver.findElement(By.cssSelector("input#TxtPassword")).sendKeys(ExcelUtility.getPUData(1, 1));

		driver.findElement(By.cssSelector("input.login-button.button.w-100")).click();

	}

	@Test(priority = 1)
	public void NewLead() throws InterruptedException {

		Actions action = new Actions(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

		WebElement LeadBtn = driver.findElement(By.xpath("//i[@class=\"icon icon-obj6\"]"));
		action.moveToElement(LeadBtn).click().perform();

		WebElement NewBtn = driver.findElement(By.xpath("//a[@title=\"New\"]"));
		action.moveToElement(NewBtn).click().perform();

		driver.findElement(By.xpath("//input[@name=\"FIRSTNAME\"]")).sendKeys("Sunanda");
		driver.findElement(By.xpath("//input[@name=\"LASTNAME\"]")).sendKeys("More");
		driver.findElement(By.xpath("//input[@name=\"LE_MOBILE\"]")).sendKeys("90018765");
		// String
		// errormsg=driver.findElement(By.cssSelector("span.error-message.pt1.db")).getText();
		// System.out.println(errormsg);
		WebElement ProductsList = driver.findElement(By.name("LE_PRODUCT"));
		Select productoptions = new Select(ProductsList);
		productoptions.selectByVisibleText("EC2604 Gold Card");

		WebElement ratingList = driver.findElement(By.xpath("//select[@name=\"LE_LEADRATING\"]"));
		Select ratingoptions = new Select(ratingList);
		ratingoptions.selectByVisibleText("Cold");

		WebElement sourceList = driver.findElement(By.xpath("//select[@name=\"LE_LEADSOURCE\"]"));
		Select srcopt = new Select(sourceList);
		srcopt.selectByValue("28");

		WebElement territory = driver.findElement(By.xpath("//a[@data-autoid=\"LE_TERRITORY_srch\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", territory);
		territory.click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.querySelector(\"div[title='Bahrain']\").click()");

		driver.findElement(By.xpath("//span[contains(text(),\"Save and Proceed\")]")).click();

		String Actual = driver.findElement(By.xpath("//div[@title=\"EC2604 _Credit Card\"]")).getText();
		String Expected = "EC2604_Credit Card";

		Assert.assertEquals(Actual, Expected);

	}

	@Test(priority = 2)
	public void Interested() throws InterruptedException, EncryptedDocumentException, IOException {

		driver.findElement(By.xpath("//span[contains(text(),\"Edit\")]")).click();

		driver.findElement(By.xpath("//span[contains(text(),\"EC2604_Interetsed\")]")).click();

		driver.findElement(By.xpath(
				"//*[@id=\"newobject\"]/div/div[1]/div/div/div[2]/div[1]/div/div/div/div/div[2]/div[1]/div/div/div/input"))
				.sendKeys("10000");

		driver.findElement(By.xpath("//span[contains(text(),\"Save and Proceed\")]")).click();

		Thread.sleep(5000);
		driver.findElement(By.xpath("//i[@class=\"icon icon-cardview f20 white\"]")).click();

		String assigname = driver.findElement(By.xpath("//span[@data-autoid=\"LE_ASSIGNTO_ctrl\"]")).getText();
		System.out.println(assigname);

		if (assigname.equals("Kapoor")) {

			WebDriverManager.edgedriver().setup();
			driver.get("https://myuat.crmnextlab.com/appqabackup/login/login");
			driver.findElement(By.xpath("//input[@name=\"UserName\"]"))
					.sendKeys(ExcelUtility.getAssignedUserData(1, 0));
			driver.findElement(By.xpath("//input[@id=\"TxtPassword\"]"))
					.sendKeys(ExcelUtility.getAssignedUserData(1, 1));
			driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		} else if (assigname.equals("Shiwastav")) {
			WebDriverManager.edgedriver().setup();
			driver.get("https://myuat.crmnextlab.com/appqabackup/login/login");
			driver.findElement(By.xpath("//input[@name=\"UserName\"]"))
					.sendKeys(ExcelUtility.getAssignedUserData(2, 0));
			driver.findElement(By.xpath("//input[@id=\"TxtPassword\"]"))
					.sendKeys(ExcelUtility.getAssignedUserData(2, 1));
			driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		} else if (assigname.equals("Roy")) {
			WebDriverManager.edgedriver().setup();
			driver.get("https://myuat.crmnextlab.com/appqabackup/login/login");
			driver.findElement(By.xpath("//input[@name=\"UserName\"]"))
					.sendKeys(ExcelUtility.getAssignedUserData(3, 0));
			driver.findElement(By.xpath("//input[@id=\"TxtPassword\"]"))
					.sendKeys(ExcelUtility.getAssignedUserData(3, 1));
			driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		}

	}

	@Test(priority = 3)
	public void AppointmnetFixed() throws InterruptedException {
		Actions action = new Actions(driver);

		WebElement BALeadbtn = driver.findElement(By.xpath("//i[@class=\"icon icon-sales\"]"));
		action.moveToElement(BALeadbtn).perform();

		WebElement BALead = driver.findElement(By.xpath("//span[@title=\"Leads\"]"));
		action.moveToElement(BALead).click().perform();

		WebElement LeadName = driver.findElement(By.xpath(
				"//*[@id=\"home-page\"]/div[2]/div/div/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[3]/div[1]/div/div[2]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[2]/div[2]/div/span/a/span"));
		String Title = LeadName.getText();
		System.out.println(Title);
		if (Title.equals("Shubham More")) {

			LeadName.click();
		}

		driver.findElement(By.xpath("//a[@title=\"Edit\"]")).click();
		driver.findElement(By.xpath("//span[contains(text(),\"Processing\")]")).click();

		driver.findElement(By.xpath("//i[@class=\"icon  icon-acid-calendar\"]")).click();

		String month = "June 2022";

		while (true) {
			String text = driver.findElement(By.xpath("//span[@class='navigation-title lh-copy pt-4']")).getText();
			System.out.println(text);

			if (text.equals(month)) {
				break;
			} else {

				driver.findElement(By.xpath("//i[@class='icon icon-arrow-left3 pointer']")).click();
			}

		}

		driver.findElement(By.xpath("//div[normalize-space()='17']")).click();
		driver.findElement(By.xpath("//i[@class='icon-acid-timer']")).click();
		driver.findElement(By.xpath("//li[normalize-space()='01:55 PM']")).click();

		driver.findElement(By.xpath("//textarea[@name=\"cust_6790\"]")).sendKeys("Pune");

		driver.findElement(By.xpath("//span[contains(text(),\"Save and Proceed\")]")).click();

		Thread.sleep(5000);
		driver.findElement(By.xpath("//i[@class=\"icon icon-cardview f20 white\"]")).click();

		driver.findElement(By.xpath("//span[contains(text(),\"Activities\")]")).click();

		String dateandtime = driver.findElement(By.xpath("//div[@data-autoid=\"Act_ex1_1_0\"]")).getText();
		System.out.println("Appointmnet is fixed on " + dateandtime);

	}

	@Test(priority = 4)
	public void Logout() {

		driver.findElement(By.xpath("//*[@id=\"reactheader\"]/div/div[3]/div[5]/a/img")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Logout']")).click();

	}
}
