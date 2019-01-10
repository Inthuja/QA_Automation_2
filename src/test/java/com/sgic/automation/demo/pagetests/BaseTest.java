package com.sgic.automation.demo.pagetests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

//import com.sgic.auotomation.demo.DataStore;
import com.sgic.automation.demo.util.Functions;

public class BaseTest {

 protected static WebDriver driver;
 private String browser;

 public static Properties prop = new Properties();
 public FileInputStream file;


 private static String screenShotFolderPath = System.getProperty("usr.dir") + "src/test/resources/screenshhots";

 @BeforeMethod
 @BeforeClass(alwaysRun = true)
 public void setUp() throws Exception {
   InputStream input = null;
   input = this.getClass().getClassLoader().getResourceAsStream("config/config.properties");
   prop.load(input);

   browser = System.getProperty("browser");
   if (browser == null || browser.isEmpty()) {
     browser = prop.getProperty("browser");
   }

   switch (browser) {
     case "firefox":
       driver = new FirefoxDriver();
       break;
     case "chrome":
       // System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedrivepath"));
       driver = new ChromeDriver();
     default:
       driver = new FirefoxDriver();
   }
    driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("timeout")), TimeUnit.SECONDS);
//   DataStore.readExcelFile("src/test/resources/data/TestData.xlsx");
 }

 

 @AfterClass
 public void tearDown() throws Exception {
   driver.quit();
 }

}
