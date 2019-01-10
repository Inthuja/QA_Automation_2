package com.sgic.automation.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage {
	
	private WebElement lblHeader = driver.findElement(By.xpath("//h1"));
	
	 public DashboardPage(WebDriver driver) {
			super(driver);
		}
	 
	 public Boolean isDashboardDisplayed() {
		 boolean flag = false;
		try {
			lblHeader.isDisplayed();
			flag= true;
		}catch(Exception e){
			flag= false;
		}
		return flag;
	 }
	 public UserManagementPage navigateToUserManagement() {
		 return new UserManagementPage(driver);
		 
	 }
}
