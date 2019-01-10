package com.sgic.automation.demo.test;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sgic.automation.demo.util.Log;

public class LoginTest extends BaseTest{
	private static Logger logger = LogManager.getLogger(LoginTest.class);

	boolean flag = false;

	@Test
	public void testUntitledTestCase() throws Exception {
	driver.get(prop.getProperty("baseUrl"));
	   Log.startTestCase();
	driver.findElement(By.id("txtUsername")).clear();
	driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	driver.findElement(By.id("txtPassword")).click();
	driver.findElement(By.id("txtPassword")).clear();
	driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	driver.findElement(By.id("frmLogin")).submit();
	driver.findElement(By.id("welcome")).click();
	if (driver.findElement(By.id("welcome")).getText().equalsIgnoreCase("Welcome Admin")) {
	flag = true;
	} else {
	logger.log(Level.ERROR, "Failed To find the message");
	}

	Assert.assertTrue(flag);

	driver.findElement(By.id("welcome")).click();
	   driver.findElement(By.linkText("Logout")).click();
	   Log.endTestCase();
	}

	}