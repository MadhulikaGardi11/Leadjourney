package com.Listeners;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Demo.LeadDemo;
import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class LeadListeners extends LeadDemo implements ITestListener{
	
	
	
	public  void onTestFailure(ITestResult result) {
	
		System.out.println("I am failed");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
		String currentDateandTime = sdf.format(new Date());
		
		AShot shot = new AShot();
		shot.shootingStrategy(ShootingStrategies.viewportPasting(2000));
	    Screenshot sc=	shot.takeScreenshot(driver);
	    BufferedImage image=sc.getImage();
	    try {
	    //  File ss=new File("Screenshot.jpg" + "currentDateandTime");
			ImageIO.write(image, "jpg", new File("Screenshot.jpg"));
		//	ImageIO.write(image, "jpg", ss);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
