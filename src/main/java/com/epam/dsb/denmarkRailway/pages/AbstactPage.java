package com.epam.dsb.denmarkRailway.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.epam.dsb.denmarkRailway.utils.HighLight;
import com.epam.dsb.denmarkRailway.utils.MyLogger;
import com.epam.dsb.denmarkRailway.utils.MyWait;
import com.epam.dsb.denmarkRailway.utils.Screenshoter;
import com.epam.dsb.denmarkRailway.utils.WebDriverSingletone;

public abstract class AbstactPage {

	protected WebDriver driver;

	protected AbstactPage() {
		this.driver = WebDriverSingletone.getMyBrowser();
	}

	public void open(String url) {
		MyLogger.info("Going to URL: " + url);
		driver.get(url);
		driver.manage().window().maximize();
	}

	public void clickAndScreeshot(final By locator) {
		MyWait.waitForElementVisible(locator);
		MyLogger.info("Clicking element '" + driver.findElement(locator).getText() + "'(Located: " + locator + ")");
		HighLight.highlightElement(locator);
		scrollIntoView(locator);
       	Screenshoter.takeScreenshot();
		HighLight.unHighlightElement(locator);
		driver.findElement(locator).click();
		
	}
	public void click(final By locator) {
		MyWait.waitForElementVisible(locator);
		MyLogger.info("Clicking element '" + driver.findElement(locator).getText() + "'(Located: " + locator + ")");
		driver.findElement(locator).click();
		
	}
	public void scrollIntoView(final By locator) {
		WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		
	}
	
}
