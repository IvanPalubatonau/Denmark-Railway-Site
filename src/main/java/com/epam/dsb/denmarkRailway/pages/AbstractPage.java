package com.epam.dsb.denmarkRailway.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.epam.dsb.denmarkRailway.utils.HighLight;
import com.epam.dsb.denmarkRailway.utils.MyLogger;
import com.epam.dsb.denmarkRailway.utils.MyWait;
import com.epam.dsb.denmarkRailway.utils.Screenshoter;
import com.epam.dsb.denmarkRailway.utils.WebDriverSingletone;



public abstract class AbstractPage {

	protected WebDriver driver;

	protected AbstractPage() {
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
		MyWait.waitForElementPresent(locator);
		MyLogger.info("Clicking element '" + driver.findElement(locator).getText() + "'(Located: " + locator + ")");
		driver.findElement(locator).click();

	}

	public void scrollIntoView(final By locator) {
		WebElement element = driver.findElement(locator);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

	}

	// LOGGER!!!!
	public void selectByVisibleTextAndScreeshot(By locator, String text) {
		MyWait.waitForElementEnabled(locator);
		HighLight.highlightElement(locator);
		Screenshoter.takeScreenshot();
		HighLight.unHighlightElement(locator);
		WebElement element = driver.findElement(locator);
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	// LOGGER!!!!
	public void selectByVisibleText(By locator, String text) {
		MyWait.waitForElementVisible(locator);
		WebElement element = driver.findElement(locator);
		element.click();
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void typeAndScreeshot(final By locator, String text) {
		MyWait.waitForElementVisible(locator);
		HighLight.highlightElement(locator);
		MyLogger.info("Typing text '" + text + "' to input form '" + driver.findElement(locator).getAttribute("name")
				+ "' (Located: " + locator + ")");
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(text);
		Screenshoter.takeScreenshot();
		HighLight.unHighlightElement(locator);
	}

	public void type(final By locator, String text) {
		MyWait.waitForElementVisible(locator);
		MyLogger.info("Typing text '" + text + "' to input form '" + driver.findElement(locator).getAttribute("name")
				+ "' (Located: " + locator + ")");
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(text);

	}
	
	 public void selectElementInDropMenuAndScreenshot(By menuLocator,By selectableLocator ) {
	        WebElement element;
	        MyWait.waitForElementVisible(menuLocator);
	        HighLight.highlightElement(menuLocator);
	        Screenshoter.takeScreenshot();
	        HighLight.unHighlightElement(menuLocator);
	        driver.findElement(menuLocator).click();
	            MyLogger.info("Clicking element '" + driver.findElement(menuLocator).getText() + "' (Located: " + menuLocator + ")");
	            MyWait.waitForElementVisible(selectableLocator);
	            element = driver.findElement(selectableLocator);
	            HighLight.highlightElement(selectableLocator);
		        Screenshoter.takeScreenshot();
		        HighLight.unHighlightElement(selectableLocator);
		        Actions action = new Actions(driver);
	            action.moveToElement(element).click().perform();
	        Screenshoter.takeScreenshot();
	        
	    }
	 
	 public void selectElementInDropMenu(By menuLocator,By selectableLocator ) {
	        WebElement element;
	        MyWait.waitForElementVisible(menuLocator);
	       	  
	        driver.findElement(menuLocator).click();
	            MyLogger.info("Clicking element '" + driver.findElement(menuLocator).getText() + "' (Located: " + menuLocator + ")");
	            MyWait.waitForElementVisible(selectableLocator);
	            element = driver.findElement(selectableLocator);
	            	        
		        Actions action = new Actions(driver);
	            action.moveToElement(element).click().build().perform();
	     	        
	    }
	 
	 public String getTextofElement(By locator) {
		 MyWait.waitForElementVisible(locator);
			MyLogger.info("Clicking element '" + driver.findElement(locator).getText() + "'(Located: " + locator + ")");
			String textOfElement=driver.findElement(locator).getText();
			return textOfElement;
	     	        
	    }
}
