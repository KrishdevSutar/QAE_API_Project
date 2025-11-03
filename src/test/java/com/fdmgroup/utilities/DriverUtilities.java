package com.fdmgroup.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverUtilities {
	private static DriverUtilities driverutilities;
	private static WebDriver driver;
	
	private DriverUtilities() {
		super();
	}
	
	public static DriverUtilities getInstance() {
		if(driverutilities == null) {
			driverutilities = new DriverUtilities();
		}
		return driverutilities;
	}
	
	public WebDriver getDriver() {
		if(driver == null) {
			createDriver();
		}
		return driver;
	}

	private void createDriver() {
		String driverName = getDriverName();
		switch(driverName) {
		case "Chrome":
			this.driver = new ChromeDriver();
//		case "Firefox":
//			this.driver = new FirefoxDriver();
		default:
			break;
		}
		
	}

	private String getDriverName() {
		String driverName = "";
		Properties config = new Properties();
		try {
			config.load(new FileInputStream("src/test/resources/config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		driverName = config.getProperty("browser");
		return driverName;
	} 
	
	public void resetDriver() {
		driver.quit();
		driverutilities = null;
		driver = null;
	}
}
