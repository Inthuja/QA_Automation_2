package com.sgic.automation.demo.pagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sgic.automation.demo.pages.DashboardPage;
import com.sgic.automation.demo.pages.LoginPage;

public class LoginTest extends BaseTest{
	@Test
	public void verifyAdminLogin() {
		LoginPage loginPage = new LoginPage(driver);
		DashboardPage dashboardPage= loginPage.login("Admin", "admin123");
		Assert.assertTrue(dashboardPage.isDashboardDisplayed());
	}

}
