package com.epam.dsb.denmarkRailway.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverSingletone {
	private static final String DEFAULT_WEB_DRIVER = "CHROME";
    private static final String FIREFOX_WEBDRIVER = "webdriver.gecko.driver";
	private static final String EXPLORER_WEBDRIVER = "webdriver.ie.driver";
	private static final String CHROME_WEBDRIVER = "webdriver.chrome.driver";
	private static final String PATH_TO_FIREFOX_WEBDRIVER = "src/test/resources/geckodriver.exe";
	private static final String PATH_TO_EXPLORER_WEBDRIVER = "src/test/resources/IEDriverServer.exe";
	private static final String PATH_TO_CHROME_WEBDRIVER = "src/test/resources/chromedriver.exe";
	private static final String BROWSER = "chrome";
	private static final String HUB = "http://localhost:4444/wd/hub";
	private static final int COMMAND_DEFAULT_TIMEOUT_SECONDS = 15;
	private static WebDriver singletone = null;

	private WebDriverSingletone() {

	}

	public static WebDriver getMyBrowser() {
		if (singletone != null) {
			return singletone;
		}
		return singletone = init();
	}

	private static WebDriver init() {
		WebDriver driver = null;

		switch (DEFAULT_WEB_DRIVER) {
		case "FIREFOX": {
			System.setProperty(FIREFOX_WEBDRIVER, PATH_TO_FIREFOX_WEBDRIVER);
			driver = new FirefoxDriver();
			break;
		}
		case "IE": {
			System.setProperty(EXPLORER_WEBDRIVER, PATH_TO_EXPLORER_WEBDRIVER);
			driver = new InternetExplorerDriver();
			break;
		}
		case "CHROME": {
			System.setProperty(CHROME_WEBDRIVER, PATH_TO_CHROME_WEBDRIVER);
			driver = new ChromeDriver();
			break;
		}
		case "REMOTE.CHROME":

			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setBrowserName(BROWSER);
			System.setProperty(CHROME_WEBDRIVER, PATH_TO_CHROME_WEBDRIVER);
			try {
				driver = new RemoteWebDriver(new URL(HUB), capabilities);
			} catch (MalformedURLException e) {
				MyLogger.info(e.getMessage());
			}
			break;
			
		default:
			try {
				throw new Exception("Browser not found");
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		driver.manage().timeouts().implicitlyWait(COMMAND_DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
		return driver;
	}

}
