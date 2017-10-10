package com.epam.dsb.denmarkRailway.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
	}

	public void click(final By locator) {
		MyWait.waitForElementVisible(locator);
		MyLogger.info("Clicking element '" + driver.findElement(locator).getText() + "'(Located: " + locator + ")");
		Screenshoter.takeScreenshot();
		driver.findElement(locator).click();
	}
}
