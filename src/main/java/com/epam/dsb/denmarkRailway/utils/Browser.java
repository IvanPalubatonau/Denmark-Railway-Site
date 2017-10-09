package com.epam.dsb.denmarkRailway.utils;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;





public class Browser {
	private static final String DEFAULT_WEB_DRIVER = "CHROME";
	//private static final int PAGE_LOAD_DEFAULT_TIMEOUT_SECONDS = 15;
	private static final int COMMAND_DEFAULT_TIMEOUT_SECONDS = 10;
	//private static final int WAIT_ELEMENT_TIMEOUT = 10;
	//private static final String SCREENSHOTS_NAME_TPL = "screenshots/scr";
	private WebDriver driver;
	private static Browser browser = null;

	private Browser(WebDriver driver) {
		this.driver = driver;
	}

	public static Browser getBrowser() {
		if (browser != null) {
			return browser;
		}
		return browser = init();
	}

	private static Browser init() {
		WebDriver driver = null;

		switch (DEFAULT_WEB_DRIVER) {
		case "FIREFOX": {
			System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		}
		case "IE": {
			System.setProperty("webdriver.ie.driver", "src/test/resources/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		}
		case "CHROME": {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}
		default:
			try {
				throw new Exception("Browser not found");
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		//driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(COMMAND_DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
		return new Browser(driver);
	}
	
	public void open(String url) {
	       // Logger.info("Going to URL: " + url);
	        driver.get(url);
	    }
}
