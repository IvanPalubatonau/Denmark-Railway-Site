package com.epam.dsb.denmarkRailway.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import static com.epam.dsb.denmarkRailway.utils.HighLight.*;
import static com.epam.dsb.denmarkRailway.utils.MyLogger.*;
import  static com.epam.dsb.denmarkRailway.utils.MyWait.*;
import static com.epam.dsb.denmarkRailway.utils.Screenshoter.*;
import com.epam.dsb.denmarkRailway.utils.WebDriverSingletone;



public abstract class AbstractPage {

	protected WebDriver driver;

	protected AbstractPage() {
		this.driver = WebDriverSingletone.getMyBrowser();
	}

	public void open(String url) {
		info("Going to URL: " + url);
		driver.get(url);
		driver.manage().window().maximize();
	}

	public void clickAndScreeshot(final By locator) {
		waitForElementVisible(locator);
		info("Clicking element '" + driver.findElement(locator).getText() + "'(Located: " + locator + ")");
		highlightElement(locator);
		scrollIntoView(locator);
		takeScreenshot();
		unHighlightElement(locator);
		driver.findElement(locator).click();

	}

	public void click(final By locator) {
		waitForElementPresent(locator);
		info("Clicking element '" + driver.findElement(locator).getText() + "'(Located: " + locator + ")");
		driver.findElement(locator).click();

	}

	public void scrollIntoView(final By locator) {
		WebElement element = driver.findElement(locator);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

	}

	// LOGGER!!!!
	public void selectByVisibleTextAndScreeshot(By locator, String text) {
		waitForElementEnabled(locator);
		highlightElement(locator);
		takeScreenshot();
		unHighlightElement(locator);
		WebElement element = driver.findElement(locator);
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	// LOGGER!!!!
	public void selectByVisibleText(By locator, String text) {
		waitForElementVisible(locator);
		WebElement element = driver.findElement(locator);
		element.click();
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void typeAndScreeshot(final By locator, String text) {
		waitForElementVisible(locator);
		highlightElement(locator);
		info("Typing text '" + text + "' to input form '" + driver.findElement(locator).getAttribute("name")
				+ "' (Located: " + locator + ")");
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(text);
	    takeScreenshot();
		unHighlightElement(locator);
	}

	public void type(final By locator, String text) {
		waitForElementVisible(locator);
		info("Typing text '" + text + "' to input form '" + driver.findElement(locator).getAttribute("name")
				+ "' (Located: " + locator + ")");
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(text);

	}
	
	 public void selectElementInDropMenuAndScreenshot(By menuLocator,By selectableLocator ) {
	        WebElement element;
	        waitForElementVisible(menuLocator);
	        highlightElement(menuLocator);
	      takeScreenshot();
	        unHighlightElement(menuLocator);
	        driver.findElement(menuLocator).click();
	           info("Clicking element '" + driver.findElement(menuLocator).getText() + "' (Located: " + menuLocator + ")");
	            waitForElementVisible(selectableLocator);
	            element = driver.findElement(selectableLocator);
	            highlightElement(selectableLocator);
		        takeScreenshot();
		       unHighlightElement(selectableLocator);
		        Actions action = new Actions(driver);
	            action.moveToElement(element).click().perform();
	        takeScreenshot();
	        
	    }
	 
	 public void selectElementInDropMenu(By menuLocator,By selectableLocator ) {
	        WebElement element;
	        waitForElementVisible(menuLocator);
	       	  
	        driver.findElement(menuLocator).click();
	            info("Clicking element '" + driver.findElement(menuLocator).getText() + "' (Located: " + menuLocator + ")");
	           waitForElementVisible(selectableLocator);
	            element = driver.findElement(selectableLocator);
	            	        
		        Actions action = new Actions(driver);
	            action.moveToElement(element).click().build().perform();
	     	        
	    }
	 
	 public String getTextofElement(By locator) {
		 waitForElementVisible(locator);
			info("Clicking element '" + driver.findElement(locator).getText() + "'(Located: " + locator + ")");
			String textOfElement=driver.findElement(locator).getText();
			return textOfElement;
	     	        
	    }
}
