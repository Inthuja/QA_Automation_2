package com.sgic.automation.demo.test;

import static org.testng.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.sgic.automation.demo.util.Functions;

public class BaseTest {
	protected static WebDriver driver;
	// private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();

	private String browser;
	private static String screenShotFolderPath=System.getProperty("user.dir")+"/src/test/resources/screenshots/";

	protected static Properties prop = new Properties();

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {


//		baseUrl = "https://www.katalon.com/";

		InputStream inputStream = null;
		inputStream = this.getClass().getClassLoader().getResourceAsStream("config/config.properties");
		prop.load(inputStream);

		browser = System.getProperty("browser");
		if (browser == null || browser.isEmpty()) {
			browser = prop.getProperty("browser");
		}
		switch (browser) {
		case "firefox":
			driver = new FirefoxDriver();
			break;

		case "chrome":
			 System.setProperty("webdriver.chrome.driver",prop.getProperty("chromedriverpath"));
			// "E:/Software/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			break;

		default:
			driver = new FirefoxDriver();
		}

		driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("timeout")), TimeUnit.SECONDS);
	}
	
	public static String captureScreenShot() {
		String filename = Functions.getTimeStamp("yyyy-MM-dd_HH:mm:ss")+".jpg";
        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File(screenShotFolderPath + filename));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }    
        return filename;
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

}