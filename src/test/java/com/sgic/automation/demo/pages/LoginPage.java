package com.sgic.automation.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
	
	private WebElement txtUsername = driver.findElement(By.id("txtUsername"));
	private WebElement txtPassword = driver.findElement(By.id("txtPassword"));
	private WebElement btnLogin = driver.findElement(By.id("btnLogin"));
	
	 public LoginPage(WebDriver driver) {
		super(driver);
	}
	 public DashboardPage login(String username,String password) {
		 txtUsername.sendKeys(username);
		 txtPassword.sendKeys(password);
		 btnLogin.click();
		 
		 return new DashboardPage(driver);
		 
	 }
}
