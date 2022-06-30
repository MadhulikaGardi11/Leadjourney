package Demo;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeLaunch {

	public static RemoteWebDriver driver;

	@BeforeClass
	public void launchBrowser() {

		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();

		 driver.manage().window().maximize();

		driver.get("https://myuat.crmnextlab.com/appqabackup/login/login");

	}

	
	  @AfterClass 
	  public void tearDown() {
	  
	  driver.close(); }
	 
}
