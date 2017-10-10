package com.epam.dsb.denmarkRailway.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HighLight {

	public static void highlightElement(By locator) {
		WebDriver driver = WebDriverSingletone.getMyBrowser();
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid green'",
				driver.findElement(locator));
	}

	public static void unHighlightElement(By locator) {
		WebDriver driver = WebDriverSingletone.getMyBrowser();
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='0px'", driver.findElement(locator));
	}
}
