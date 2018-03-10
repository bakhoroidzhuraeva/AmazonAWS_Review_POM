package com.amazonAWS.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * @author MarifatA --> WebDriver factory takes String as input and returns the
 *         implementation of the WebDriver based on that
 *
 */
public class Driver {

	private static WebDriver driver;

	public static WebDriver getDriver(String browser) {
		String driverType = browser == null ? Configuration.getProperty("browser") : browser;
		// if browser has value, use browser
		// else use the value from the Configuration file

		if (driver == null) {
			// create WebDriver based on the value of browser parameter
			switch (driverType.toLowerCase()) {
			case "chrome":
				System.setProperty(Configuration.getProperty("chromepath"), Configuration.getProperty("chromedriver"));
				driver = new ChromeDriver();
				break;

			case "firefox":
				System.setProperty(Configuration.getProperty("geckopath"), Configuration.getProperty("geckodriver"));
				driver = new FirefoxDriver();
				break;
			case "safari":
				driver = new SafariDriver();
				break;

			}
			// return
		}
		return driver;

	}

	public static void quit() {
		if (driver != null) {
			driver.quit();
			driver = null;

		}
	}

}
