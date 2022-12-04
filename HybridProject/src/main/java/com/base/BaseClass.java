package com.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utils.PropertyUtils;

public class BaseClass {
	
	public static WebDriver driver=null;
	//Extent Report Initialization
	public static ExtentReports report=null;
	public static ExtentSparkReporter spark = null;
	public static ExtentTest test = null;
	//Logger Initialization.
	public static Logger log = Logger.getLogger(BaseClass.class);
	
	public static void initialization() throws Exception {
		log.info("Reading property file for browser name"); // Replacement for Syso
		String browserName =PropertyUtils.readProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		}
		if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(PropertyUtils.readProperty("url"));
	}
	public void reportInit() {
		report = new ExtentReports();
		spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/target/extentReport.html");
		report.attachReporter(spark);
	}

}
