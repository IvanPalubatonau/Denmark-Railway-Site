package com.epam.dsb.denmarkRailway.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyWait {

	private static final int WAIT_ELEMENT_TIMEOUT = 10;

	public static void waitForElementPresent(By locator) {
		WebDriver driver = WebDriverSingletone.getMyBrowser();
		new WebDriverWait(driver, WAIT_ELEMENT_TIMEOUT)
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}

	public static void waitForElementEnabled(By locator) {
		WebDriver driver = WebDriverSingletone.getMyBrowser();
		new WebDriverWait(driver, WAIT_ELEMENT_TIMEOUT).until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static void waitForElementVisible(By locator) {
		WebDriver driver = WebDriverSingletone.getMyBrowser();
		new WebDriverWait(driver, WAIT_ELEMENT_TIMEOUT)
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
}
