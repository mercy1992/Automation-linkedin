package com.assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

/**
 * LoginPage.java - class to verify Login Page functions Created by MercyVenesiyaJ
 * on 30/08/2019.
 */

public class LoginPage {
	
	private static final Logger LOGGER = Logger.getLogger(LoginPage.class);
	WebDriver driver;
	
	@Test
	public void openBrowser() {
		
		System.setProperty("webdriver.gecko.driver", "driver//geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		LOGGER.info("openBrowser successfully");
		
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("LinkedIn Login");
		driver.findElement(By.xpath("(//input[@class = 'gNO89b'])[2]")).submit();
		driver.findElement(By.xpath("//*[text() = 'LinkedIn Login, Sign in | LinkedIn']")).click();
		driver.findElement(By.id("username")).sendKeys("m04.venesiya@gmail.com");
		driver.findElement(By.id("password")).sendKeys("venesiya");
		driver.findElement(By.xpath("//button[@class=\"btn__primary--large from__button--floating\"]")).click();
		LOGGER.info("LoginPage successfully");
		
		WebElement sucMsg = driver.findElement(By.xpath("//*[text() = 'mercy venesiya']"));
		System.out.println(sucMsg.isDisplayed());
		LOGGER.info("successfully");
		driver.close();
	}
	
}


