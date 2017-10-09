package com.epam.dsb.denmarkRailway.utils;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;




public class WebDriverSingletone {
	private static final String DEFAULT_WEB_DRIVER = "CHROME";
	private static final int COMMAND_DEFAULT_TIMEOUT_SECONDS = 10;
    
	private static WebDriver singltone = null;

	private WebDriverSingletone() {
		
	}

	public static WebDriver getMyBrowser() {
		if (singltone != null) {
			return singltone;
		}
		return singltone = init();
	}

	private static WebDriver init() {
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
		driver.manage().timeouts().implicitlyWait(COMMAND_DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
		return driver;
	}
	
	
}
